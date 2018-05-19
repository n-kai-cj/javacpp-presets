import org.bytedeco.javacpp.*;

public class JavaCppFFmpegAacDecoder {
    private avcodec.AVCodecContext dec = null;
    private avutil.AVFrame frame = null;
    private swresample.SwrContext swr = null;
    private BytePointer[] in = new BytePointer[avutil.AVFrame.AV_NUM_DATA_POINTERS];
    private BytePointer[] out = null;
    private PointerPointer<Pointer> inPtrPtr = new PointerPointer<>(avutil.AVFrame.AV_NUM_DATA_POINTERS);
    private PointerPointer<Pointer> outPtrPtr = new PointerPointer<>(avutil.AVFrame.AV_NUM_DATA_POINTERS);
    private avcodec.AVPacket pkt = new avcodec.AVPacket();
    private BytePointer bp = null;
    private int bSize;

    static {
        avcodec.avcodec_register_all();
        avformat.av_register_all();
        avfilter.avfilter_register_all();
        avformat.avformat_network_init();
        avutil.av_log_set_level(avutil.AV_LOG_ERROR);
    }

    public JavaCppFFmpegAacDecoder(int sampleRate, int c) {
        int ret;
        avcodec.AVCodec avCodec = avcodec.avcodec_find_decoder(avcodec.AV_CODEC_ID_AAC);
        if (avCodec == null) {
            return;
        }
        this.dec = avcodec.avcodec_alloc_context3(avCodec);
        if (this.dec == null) {
            return;
        }
        this.dec.codec_type(avutil.AVMEDIA_TYPE_AUDIO);
        this.dec.sample_rate(sampleRate);
        this.dec.channel_layout(avutil.AV_CH_LAYOUT_MONO);
        this.dec.channels(c);
        this.dec.sample_fmt(avCodec.sample_fmts().get(0));
        this.dec.codec_id(avCodec.id());
        avutil.AVRational time_base = new avutil.AVRational();
        time_base.num(1);
        time_base.den(sampleRate);
        this.dec.time_base(time_base);
        this.dec.strict_std_compliance(-2);
        this.dec.frame_size(1024 * c);
        this.dec.profile(avcodec.AVCodecContext.FF_PROFILE_AAC_MAIN);
        ret = avcodec.avcodec_open2(this.dec, avCodec, (avutil.AVDictionary) null);
        if (ret < 0) {
            return;
        }
        this.frame = avutil.av_frame_alloc();
        if (this.frame == null) {
            return;
        }
        this.bSize = avutil.av_samples_get_buffer_size((IntPointer) null,
                this.dec.channels(), this.dec.frame_size(),
                avutil.AV_SAMPLE_FMT_S16, 1);
        this.swr = swresample.swr_alloc_set_opts(null,
                this.dec.channel_layout(), avutil.AV_SAMPLE_FMT_S16, this.dec.sample_rate(),
                this.dec.channel_layout(), avutil.AV_SAMPLE_FMT_FLTP, this.dec.sample_rate(),
                0, null);
        if (this.swr == null) {
            return;
        }
        ret = swresample.swr_init(this.swr);
        if (ret < 0) {
            return;
        }
        int planes = avutil.av_sample_fmt_is_planar(this.dec.sample_fmt()) != 0 ? this.dec.channels() : 1;
        int data_size = avutil.av_samples_get_buffer_size((IntPointer) null,
                this.dec.channels(), this.dec.frame_size(), avutil.AV_SAMPLE_FMT_S16, 1) / planes;
        this.out = new BytePointer[planes];
        for (int i = 0; i < this.out.length; i++) {
            this.out[i] = new BytePointer(avutil.av_malloc(data_size)).capacity(data_size);
        }
        for (int i = 0; i < this.out.length; i++) {
            this.outPtrPtr.put(i, this.out[i]);
        }
    }

    public boolean dec(byte[] data, int length) {

        if (this.bp == null || this.bp.asBuffer().remaining() < length) {
            this.bp = new BytePointer(avutil.av_malloc(length));
        }
        this.bp.put(data, 0, length);

        avcodec.av_init_packet(this.pkt);
        avcodec.av_packet_from_data(this.pkt, this.bp, length);
        this.pkt.flags(this.pkt.flags() | avcodec.AV_PKT_FLAG_KEY);
        int size = avcodec.avcodec_send_packet(this.dec, this.pkt);
        if (size != -11) {
            return false;
        }
        size = avcodec.avcodec_receive_frame(this.dec, this.frame);
        if (size < 0) {
            return false;
        }
        for (int i = 0; i < this.dec.channels(); i++) {
            if (this.in[i] == null) {
                this.in[i] = new BytePointer(this.frame.extended_data(0));
            } else {
                this.in[i].put(this.frame.extended_data(0));
            }
            this.inPtrPtr.put(i, this.in[i]);
        }
        int src_nb_samples = this.frame.nb_samples();
        int dst_nb_samples = (int) avutil.av_rescale_rnd(
                swresample.swr_get_delay(this.swr, this.dec.sample_rate()) + src_nb_samples,
                this.dec.sample_rate(), this.dec.sample_rate(), avutil.AV_ROUND_UP);
        size = swresample.swr_convert(this.swr, this.outPtrPtr, dst_nb_samples,
                this.inPtrPtr, src_nb_samples);
        if (size < 0) {
            return false;
        }
        byte[] rBuf = new byte[this.bSize];
        this.out[0].get(rBuf);
        avcodec.av_packet_unref(pkt);
        return true;
    }

    public void exit() {
        if (this.dec != null) {
            avcodec.avcodec_close(this.dec);
            avcodec.avcodec_free_context(this.dec);
            this.dec = null;
        }
        if (this.frame != null) {
            avutil.av_frame_free(this.frame);
            this.frame = null;
        }
    }

}
