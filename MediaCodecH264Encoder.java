import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Bundle;
import org.bytedeco.javacpp.*;

import java.io.IOException;
import java.nio.ByteBuffer;

public class MediaCodecH264Encoder {
    private int w;
    private int h;
    private PixConv conv;
    private BytePointer bp;
    private final static String encName = "video/avc";
    private MediaCodec enc = null;
    private MediaFormat fmt = null;
    private final Object lock = new Object();
    private long tsUs = 0;
    private MediaCodec.BufferInfo bufInfo = new MediaCodec.BufferInfo();
    private final Bundle params = new Bundle();
    private int fps;


    public MediaCodecH264Encoder(int w, int h, int kbps, int fps) {
        synchronized (this.lock) {
            this.w = w;
            this.h = h;
            this.fps = fps;
            this.conv = new PixConv();
            if (!this.conv.init(this.w, this.h, avutil.AV_PIX_FMT_YUV420P, avutil.AV_PIX_FMT_NV12)) {
                return;
            }
            try {
                this.enc = MediaCodec.createEncoderByType(encName);
            } catch (IOException e) {
                this.enc = null;
                return;
            }
            // ----------------------------------------------------------------------------------------------------
            this.fmt = MediaFormat.createVideoFormat(encName, this.w, this.h);
            this.fmt.setInteger(MediaFormat.KEY_COLOR_FORMAT, MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420Flexible);
            this.fmt.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, 1);
            this.fmt.setInteger(MediaFormat.KEY_PRIORITY, 0);
            this.fmt.setInteger(MediaFormat.KEY_MAX_INPUT_SIZE, 0);
            this.fmt.setInteger(MediaFormat.KEY_PROFILE, MediaCodecInfo.CodecProfileLevel.AVCProfileMain);
            this.fmt.setInteger(MediaFormat.KEY_LEVEL, MediaCodecInfo.CodecProfileLevel.AVCLevel41);
            this.tsUs = 0;
            this.fmt.setInteger(MediaFormat.KEY_FRAME_RATE, fps);
            this.fmt.setInteger(MediaFormat.KEY_BIT_RATE, (kbps * 1000));
            this.fmt.setInteger(MediaFormat.KEY_INTRA_REFRESH_PERIOD, fps);
            this.fmt.setInteger(MediaFormat.KEY_CAPTURE_RATE, fps);
            this.params.putInt(MediaCodec.PARAMETER_KEY_VIDEO_BITRATE, kbps*1000);
            try {
                enc.configure(fmt, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE);
                enc.start();
                enc.setParameters(this.params);
            } catch (Exception e) {
                return;
            }
            // ----------------------------------------------------------------------------------------------------

        }
    }

    public void exit() {
        synchronized (this.lock) {
            if (this.enc != null) {
                try {
                    dequeue();
                    this.enc.stop();
                    this.enc.release();
                } catch (IllegalStateException e) {
                }
                this.enc = null;
            }
        }
    }

    public boolean enc(byte[] buffer) {
        if (buffer == null) {
            return false;
        }
        if (this.bp == null) {
            this.bp = new BytePointer(buffer.length);
        }
        this.bp.put(buffer);
        buffer = this.conv.conv(this.w, this.h, this.bp, buffer);
        synchronized (this.lock) {
            if (!necProc(buffer)) {
                return false;
            }
        }
        return true;
    }

    private boolean necProc(byte[] rawData) {
        if (rawData == null || rawData.length == 0) {
            return false;
        }
        synchronized (this.lock) {
            boolean ret = queue(rawData);
            if (!ret) {
                return false;
            }
            ret = dequeue();
            if (!ret) {
                int retry = 1;
                while (!ret) {
                    if (retry > 2) {
                        break;
                    }
                    ret = dequeue();
                    retry++;
                }
            }
            return ret;
        }
    }

    private boolean queue(byte[] rawData) {
        synchronized (this.lock) {
            int inIndex = this.enc.dequeueInputBuffer(30 * 1000);
            if (inIndex < 0) {
                return false;
            }
            ByteBuffer inputBuffer = this.enc.getInputBuffer(inIndex);
            if (inputBuffer == null) {
                return false;
            }
            inputBuffer.put(rawData);
            this.enc.queueInputBuffer(inIndex, 0, inputBuffer.position(), this.tsUs, 0);
            this.tsUs += 1000 * 1000 / (double) this.fps;
        }
        return true;
    }

    private boolean dequeue() {
        synchronized (this.lock) {
            int outIndex = this.enc.dequeueOutputBuffer(this.bufInfo, 30 * 1000);
            if (outIndex == MediaCodec.INFO_OUTPUT_FORMAT_CHANGED) {
                return false;
            } else if (outIndex == MediaCodec.INFO_TRY_AGAIN_LATER) {
                return false;
            } else if (outIndex < 0) {
                return false;
            }
            ByteBuffer outputBuffer = this.enc.getOutputBuffer(outIndex);
            if (outputBuffer == null) {
                return false;
            }
            int esDataLength = outputBuffer.remaining();
            byte[] eBuf = new byte[esDataLength];
            outputBuffer.get(eBuf, 0, esDataLength);
            this.enc.releaseOutputBuffer(outIndex, false);
        }
        return true;
    }

    public class PixConv {
        private swscale.SwsContext conv = null;
        private BytePointer bp = null;
        private int picSize = 0;
        private avutil.AVFrame encFrame = null;
        private avutil.AVFrame f = null;
        private PointerPointer<avutil.AVFrame> fPtrPtr = null;
        private PointerPointer<avutil.AVFrame> encFramePtrPtr = null;
        private BytePointer dstBp = null;
        private ByteBuffer dstBuf = ByteBuffer.allocateDirect(1);
        private int sFmt = -1;
        private int dFmt = -1;

        PixConv() {
        }

        synchronized byte[] conv(int w, int h, BytePointer data, byte[] dstByte) {
            if (convFrm(w, h, data) == null) {
                return null;
            }
            int len = avutil.av_image_get_buffer_size(this.dFmt, w, h, 1);
            if (len < 0) {
                return null;
            }
            if (dstByte.length != len) {
                return null;
            }
            this.dstBuf.clear();
            if (this.dstBuf.remaining() != len) {
                this.dstBuf = ByteBuffer.allocateDirect(len);
                this.dstBp = new BytePointer(this.dstBuf);
            }
            int ret = avutil.av_image_copy_to_buffer(this.dstBp, len,
                    this.encFrame.data(), this.encFrame.linesize(),
                    this.dFmt, w, h, 1);
            if (ret < 0) {
                return null;
            }
            this.dstBuf.get(dstByte);

            return dstByte;
        }

        synchronized avutil.AVFrame convFrm(int w, int h, BytePointer data) {
            if (this.sFmt < 0 || this.dFmt < 0) {
                return null;
            }
            int ret = avutil.av_image_fill_arrays(this.f.data(), this.f.linesize(), data,
                    this.sFmt, w, h, 1);
            if (ret < 0) {
                return null;
            }
            ret = avutil.av_image_fill_arrays(this.encFrame.data(), this.encFrame.linesize(), this.bp,
                    this.dFmt, w, h, 1);
            if (ret < 0) {
                return null;
            }
            ret = swscale.sws_scale(
                    this.conv,
                    this.fPtrPtr,
                    this.f.linesize(),
                    0,
                    h,
                    this.encFramePtrPtr,
                    this.encFrame.linesize());
            if (ret < 0) {
                return null;
            }
            return this.encFrame;
        }

        boolean init(int width, int height, int src_pix_fmt, int dst_pix_fmt) {
            if (this.sFmt == src_pix_fmt && this.dFmt == dst_pix_fmt) {
                return true;
            }
            this.encFrame = avutil.av_frame_alloc();
            if (this.encFrame == null) {
                return false;
            }
            this.encFrame.format(dst_pix_fmt);
            this.encFrame.width(width);
            this.encFrame.height(height);
            this.encFrame.pts(0);
            this.f = avutil.av_frame_alloc();
            if (this.f == null) {
                return false;
            }
            this.f.format(src_pix_fmt);
            this.f.width(width);
            this.f.height(height);
            this.f.pts(0);
            this.fPtrPtr = new PointerPointer<>(this.f);
            this.encFramePtrPtr = new PointerPointer<>(this.encFrame);
            this.picSize = avutil.av_image_get_buffer_size(dst_pix_fmt, width, height, 1);
            if (this.picSize <= 0) {
                return false;
            }
            this.bp = new BytePointer(avutil.av_malloc(this.picSize));
            this.conv = swscale.sws_getContext(
                    width, height, src_pix_fmt,
                    width, height, dst_pix_fmt,
                    swscale.SWS_BICUBIC, null, null, (DoublePointer) null);
            if (this.conv == null) {
                return false;
            }
            this.sFmt = src_pix_fmt;
            this.dFmt = dst_pix_fmt;
            return true;
        }

        void exit() {
            if (this.encFrame != null) {
                avutil.av_frame_free(this.encFrame);
                avutil.av_free(this.encFrame);
                this.encFrame = null;
            }
            if (this.f != null) {
                avutil.av_frame_free(this.f);
                avutil.av_free(this.f);
                this.f = null;
            }
            if (this.conv != null) {
                swscale.sws_freeContext(this.conv);
                this.conv = null;
            }
            if (this.bp != null) {
                avutil.av_free(this.bp);
                this.bp = null;
            }
            this.sFmt = -1;
            this.dFmt = -1;
        }

    }

}
