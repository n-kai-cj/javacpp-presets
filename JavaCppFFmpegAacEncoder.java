import org.bytedeco.javacpp.*;

public class JavaCppFFmpegAacEncoder {
    private avcodec.AVCodecContext enc = null;
    private avutil.AVFrame frame = null;
    private long pts = 0;
    private swresample.SwrContext swr = null;
    private avcodec.AVPacket pkt = new avcodec.AVPacket();
    private BytePointer[] out = null;
    private Pointer[] in = null;
    private PointerPointer<Pointer> inPtrPtr = null;
    private PointerPointer<Pointer> outPtrPtr = null;

    static {
        avcodec.avcodec_register_all();
        avformat.av_register_all();
        avfilter.avfilter_register_all();
        avformat.avformat_network_init();
        avutil.av_log_set_level(avutil.AV_LOG_ERROR);
    }

    public JavaCppFFmpegAacEncoder(int sampleRate, int c, int bps) {
        avcodec.AVCodec avCodec = avcodec.avcodec_find_encoder(avcodec.AV_CODEC_ID_AAC);
        if (avCodec == null) {
            return;
        }
        this.enc = avcodec.avcodec_alloc_context3(avCodec);
        if (this.enc == null) {
            return;
        }
        this.enc.codec_type(avutil.AVMEDIA_TYPE_AUDIO);
        this.enc.bit_rate(bps);
        this.enc.sample_rate(sampleRate);
        this.enc.channel_layout(avutil.AV_CH_LAYOUT_MONO);
        this.enc.channels(c);
        this.enc.sample_fmt(avCodec.sample_fmts().get(0));
        this.enc.codec_id(avCodec.id());
        avutil.AVRational time_base = new avutil.AVRational();
        time_base.num(1);
        time_base.den(sampleRate);
        this.enc.time_base(time_base);
        this.enc.strict_std_compliance(-2);
        this.enc.flags(this.enc.flags() | avcodec.CODEC_FLAG_GLOBAL_HEADER);
        int ret = avcodec.avcodec_open2(this.enc, avCodec, (PointerPointer<Pointer>) null);
        if (ret < 0) {
            return;
        }
        this.frame = avutil.av_frame_alloc();
        if (this.frame == null) {
            return;
        }
        this.frame.nb_samples(this.enc.frame_size());
        this.frame.format(this.enc.sample_fmt());
        this.frame.channel_layout(this.enc.channel_layout());
        this.swr = swresample.swr_alloc_set_opts(null, this.enc.channel_layout(), avutil.AV_SAMPLE_FMT_FLTP,
                this.enc.sample_rate(), this.enc.channel_layout(), avutil.AV_SAMPLE_FMT_S16,
                this.enc.sample_rate(), 0, null);
        if (this.swr == null) {
            return;
        }
        ret = swresample.swr_init(this.swr);
        if (ret < 0) {
            return;
        }
        int audioInputFrameSize = this.enc.frame_size();
        int planes = avutil.av_sample_fmt_is_planar(this.enc.sample_fmt()) != 0
                ? this.enc.channels()
                : 1;
        int data_size = avutil.av_samples_get_buffer_size((IntPointer) null, this.enc.channels(),
                audioInputFrameSize, this.enc.sample_fmt(), 1) / planes;
        out = new BytePointer[planes];
        for (int i = 0; i < out.length; i++) {
            out[i] = new BytePointer(avutil.av_malloc(data_size)).capacity(data_size);
        }
        in = new Pointer[avutil.AVFrame.AV_NUM_DATA_POINTERS];
        inPtrPtr = new PointerPointer<>(avutil.AVFrame.AV_NUM_DATA_POINTERS);
        outPtrPtr = new PointerPointer<>(avutil.AVFrame.AV_NUM_DATA_POINTERS);
        for (int i = 0; i < out.length; i++) {
            outPtrPtr.put(i, out[i]);
        }
    }

    public void exit() {
        avcodec.avcodec_free_context(this.enc);
        avutil.av_frame_free(this.frame);
        avutil.av_free(this.frame);
        avutil.av_free(this.enc);
    }

    public boolean enc(byte[] data) {
        if (data == null) {
            return false;
        }
        if (data.length != 2048) {
            return false;
        }
        for (int i = 0; i < this.enc.channels(); i++) {
            in[i] = new BytePointer(data);
            inPtrPtr.put(i, in[i]);
        }
        int src_nb_samples = 1024;
        int dst_nb_samples = (int) avutil.av_rescale_rnd(
                swresample.swr_get_delay(this.swr, this.enc.sample_rate()) + src_nb_samples,
                this.enc.sample_rate(), this.enc.sample_rate(), avutil.AV_ROUND_UP);
        int ret = swresample.swr_convert(this.swr, outPtrPtr, dst_nb_samples, inPtrPtr, src_nb_samples);
        if (ret < 0) {
            return false;
        }
        ret = avcodec.avcodec_fill_audio_frame(this.frame, this.enc.channels(),
                this.enc.sample_fmt(), out[0], (int) out[0].limit(), 0);
        for (int i = 0; i < out.length; i++) {
            this.frame.data(i, out[i].position(0));
            this.frame.linesize(i, (int) out[i].limit());
        }
        if (ret < 0) {
            return false;
        }
        this.frame.pts(pts);
        pts += this.frame.nb_samples();
        ret = avcodec.avcodec_send_frame(this.enc, this.frame);
        if (ret != 0) {
            return false;
        }
        avcodec.av_init_packet(pkt);
        pkt.data(null);
        pkt.size(0);
        ret = avcodec.avcodec_receive_packet(this.enc, pkt);
        if (ret != 0) {
            return false;
        }
        byte[] eBuf = new byte[pkt.size()];
        this.pkt.data().get(eBuf, 0, eBuf.length);
        avcodec.av_packet_unref(pkt);

        return true;
    }

}
