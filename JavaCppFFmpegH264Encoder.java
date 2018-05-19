import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.avcodec.AVCodec;
import org.bytedeco.javacpp.avcodec.AVCodecContext;
import org.bytedeco.javacpp.avcodec.AVPacket;
import org.bytedeco.javacpp.avutil.AVFrame;
import org.bytedeco.javacpp.avutil.AVRational;

import java.nio.ByteBuffer;

public class JavaCppFFmpegH264Encoder {
    private AVFrame encFrm = null;
    private AVFrame f = null;
    private BytePointer bp = null;
    private AVCodecContext enc = null;
    private AVPacket pkt = null;
    private AVRational tb = new AVRational();
    private PixConv conv = null;
    private int w;
    private int h;
    private final Object lock = new Object();

    static {
        // FFmpeg init
        avcodec.avcodec_register_all();
        avformat.av_register_all();
        avfilter.avfilter_register_all();
        avformat.avformat_network_init();
        // FFmpeg log output level
        avutil.av_log_set_level(avutil.AV_LOG_ERROR);
    }

    public JavaCppFFmpegH264Encoder(int w, int h, int kbps, int fps) {
        synchronized (this.lock) {
            this.w = w;
            this.h = h;
            this.encFrm = avutil.av_frame_alloc();
            if (this.encFrm == null) {
                return;
            }
            this.encFrm.format(avutil.AV_PIX_FMT_YUV420P);
            this.encFrm.width(w);
            this.encFrm.height(h);
            this.encFrm.pts(0);
            this.f = avutil.av_frame_alloc();
            if (this.f == null) {
                return;
            }
            this.f.format(avutil.AV_PIX_FMT_BGR24);
            this.f.width(w);
            this.f.height(h);
            this.f.pts(0);
            // Pixel format conv
            this.conv = new PixConv();
            if (!this.conv.init(w, h, this.f.format(), this.encFrm.format())) {
                return;
            }
            this.pkt = new AVPacket();
            avcodec.av_init_packet(this.pkt);
            int level = 41;
            int profile = 77;
            int coderType = 0;
            int trellis = 0;
            String preset = "ultrafast";
            AVCodec avCodec = avcodec.avcodec_find_encoder(avcodec.AV_CODEC_ID_H264);
            if (avCodec == null) {
                return;
            }
            // ----------------------------------------------------------------------------------------------------
            this.enc = avcodec.avcodec_alloc_context3(avCodec);
            if (this.enc == null) {
                return;
            }
            this.enc.width(w);
            this.enc.height(h);
            this.enc.level(level);
            this.enc.rc_max_rate(kbps * 1000);
            this.enc.rc_min_rate(kbps * 1000);
            this.enc.bit_rate(kbps * 1000);
            this.tb.num(1);
            this.tb.den(fps);
            this.enc.time_base(this.tb);
            this.enc.gop_size(fps * 10);
            this.enc.codec_id(avCodec.id());
            this.enc.codec_type(avutil.AVMEDIA_TYPE_VIDEO);
            this.enc.pix_fmt(avutil.AV_PIX_FMT_YUV420P);
            this.enc.qmin(10);
            this.enc.qmax(51);
            this.enc.thread_count(0);
            int ret = avutil.av_opt_set(this.enc.priv_data(), "tune", "zerolatency", 0);
            if (ret < 0) {
                return;
            }
            this.enc.profile(profile);
            this.enc.coder_type(coderType);
            this.enc.trellis(trellis);
            ret = avutil.av_opt_set(this.enc.priv_data(), "preset", preset, 0);
            if (ret < 0) {
                return;
            }
            ret = avcodec.avcodec_open2(this.enc, avCodec, (PointerPointer<Pointer>) null);
            if (ret < 0) {
                return;
            }
            // ----------------------------------------------------------------------------------------------------
        }
    }

    public void exit() {
        synchronized (this.lock) {
            avcodec.av_packet_unref(this.pkt);
            avutil.av_frame_free(this.encFrm);
            avutil.av_frame_free(this.f);
            avutil.av_free(this.encFrm);
            avutil.av_free(this.f);
            avcodec.avcodec_close(this.enc);
            avcodec.avcodec_free_context(this.enc);
            avutil.av_free(this.enc);
            if (this.conv != null) {
                this.conv.exit();
                this.conv = null;
            }
        }
    }

    public boolean enc(byte[] buf) {
        int ret;
        if (this.bp == null || this.bp.asBuffer().remaining() != buf.length) {
            this.bp = new BytePointer(buf.length);
        }
        this.bp.put(buf);
        this.encFrm = this.conv.convFrm(w, h, this.bp);
        if (this.encFrm == null) {
            return false;
        }
        this.encFrm.pts(this.encFrm.pts() + 1);
        avcodec.av_init_packet(this.pkt);
        this.pkt.flags(this.pkt.flags() | avcodec.AV_PKT_FLAG_KEY);
        this.pkt.data(null);
        this.pkt.size(0);
        synchronized (this.lock) {
            ret = avcodec.avcodec_send_frame(this.enc, this.encFrm);
            if (ret < 0) {
                return false;
            }
            ret = avcodec.avcodec_receive_packet(this.enc, this.pkt);
            if (ret < 0) {
                return false;
            }
            while (ret >= 0) {
                int avPacketLen = this.pkt.size();
                byte[] eBuf = new byte[avPacketLen];
                this.pkt.data().get(eBuf, 0, avPacketLen);
                avcodec.av_packet_unref(this.pkt);
                ret = avcodec.avcodec_receive_packet(this.enc, this.pkt);
            }
            avcodec.av_packet_unref(this.pkt);
        }
        return true;
    }

    public class PixConv {
        private swscale.SwsContext conv = null;
        private BytePointer bp = null;
        private int picSize = 0;
        private AVFrame encFrame = null;
        private AVFrame f = null;
        private PointerPointer<AVFrame> fPtrPtr = null;
        private PointerPointer<AVFrame> encFramePtrPtr = null;
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

        synchronized AVFrame convFrm(int w, int h, BytePointer data) {
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
