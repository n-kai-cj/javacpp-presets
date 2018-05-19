import com.nec.cl.spf.smc.avst.util.ConstParams;
import org.bytedeco.javacpp.*;

public class JavaCppFFmpegH264Decoder {
    private avcodec.AVPacket pkt;
    private avcodec.AVCodec avCodec;
    private avcodec.AVCodecContext dec;
    private avutil.AVFrame yuv = null;
    private BytePointer srcBp = null;
    private BytePointer yuvBp = null;

    static {
        avcodec.avcodec_register_all();
        avformat.av_register_all();
        avfilter.avfilter_register_all();
        avformat.avformat_network_init();
        avutil.av_log_set_level(avutil.AV_LOG_ERROR);
    }

    public JavaCppFFmpegH264Decoder() {
        this.pkt = new avcodec.AVPacket();
        avcodec.av_init_packet(this.pkt);
        this.avCodec = avcodec.avcodec_find_decoder(ConstParams.CODEC_ID_H264);
        this.dec = avcodec.avcodec_alloc_context3(this.avCodec);
        this.dec.codec_type(avutil.AVMEDIA_TYPE_VIDEO);
        this.dec.pix_fmt(avutil.AV_PIX_FMT_YUV420P);
        int ret;
        ret = avcodec.avcodec_open2(this.dec, this.avCodec, (PointerPointer<Pointer>) null);
        if (ret < 0) {
            return;
        }
        this.yuv = avutil.av_frame_alloc();
    }

    public void exit() {
        if (this.dec != null) {
            avcodec.avcodec_close(this.dec);
            avcodec.avcodec_free_context(this.dec);
            this.dec = null;
        }
        if (this.avCodec != null) {
            this.avCodec = null;
        }
        if (this.yuv != null) {
            avutil.av_frame_free(this.yuv);
            this.yuv = null;
        }
        if (this.pkt != null) {
            avcodec.av_packet_unref(this.pkt);
            this.pkt = null;
        }
    }

    public boolean dec(byte[] data, int length) {
        if (this.srcBp == null || this.srcBp.asBuffer().remaining() < length) {
            this.srcBp = new BytePointer(avutil.av_malloc(length));
        }
        this.srcBp.put(data, 0, length);
        avcodec.av_init_packet(this.pkt);
        avcodec.av_packet_from_data(this.pkt, this.srcBp, length);
        int size = avcodec.avcodec_send_packet(this.dec, this.pkt);
        if (size < 0) {
            return false;
        }
        avcodec.av_packet_unref(this.pkt);
        size = avcodec.avcodec_receive_frame(this.dec, this.yuv);
        if (size < 0) {
            return false;
        }
        while (size >= 0) {
            int width = this.yuv.width();
            int height = this.yuv.height();
            int yuvLen = avutil.av_image_get_buffer_size(this.yuv.format(), width, height, 1);
            if (this.yuvBp == null) {
                this.yuvBp = new BytePointer(yuvLen);
            }
            byte[] rBuf = new byte[yuvLen];
            avutil.av_image_copy_to_buffer(this.yuvBp, yuvLen,
                    this.yuv.data(), this.yuv.linesize(),
                    avutil.AV_PIX_FMT_YUV420P, width, height, 1);
            this.yuvBp.get(rBuf, 0, rBuf.length);
            size = avcodec.avcodec_receive_frame(this.dec, this.yuv);
        }
        return true;
    }

}
