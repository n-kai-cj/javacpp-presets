import java.nio.ByteBuffer;
import java.util.zip.CRC32;

public class OggOpusHeader {

    private final static String OGG_VORVIS_HEADER_STR = "OggS";
    private final static byte[] OGG_VORVIS_HEADER_BYTES = OGG_VORVIS_HEADER_STR.getBytes();

    public static final String MAGIC_HEADER_STR = "OpusHead";
    public static final byte[] MAGIC_HEADER_BYTES = MAGIC_HEADER_STR.getBytes();

    public final static String COMMENT_HEADER_STR = "OpusTags";
    public final static byte[] COMMENT_HEADER_BYTES = COMMENT_HEADER_STR.getBytes();

    private final static int outputGain = 0;
    private final static byte channelMappingFamily = 0;

    private boolean isFirst = true;
    private long ogg_granule_position = 0;
    private int ogg_bitstream_serial_number = 0;
    private int ogg_page_sequence_number = 0;
    private final static int OGG_CRC_POLY = 0x04c11db7;
    private final static int OGG_MAX_SEGMENTS = 255;
    private CRC32 ogg_crc;
    private ByteBuffer deepCopyBuffer = ByteBuffer.allocate(1024);


    public int initialize(int sampleRateHz, int channel, byte[] dst) {
        if (dst == null) {
            return -1;
        }
        byte[] opusIdHeader = opusIDHeader(channel, sampleRateHz);
        byte[] opusComHeader = opusCommentHeader("opus", "libopus");
        if (dst.length < opusIdHeader.length + opusComHeader.length) {
            return -1;
        }
        this.isFirst = true;
        this.ogg_page_sequence_number = 0;

        byte[] oggOpusIdHeader = new byte[1024];
        int oggOpusIdHeaderLen = encode(opusIdHeader, 0, opusIdHeader.length, oggOpusIdHeader);
        byte[] oggOpusComHeader = new byte[1024];
        int oggOpusComHeaderLen = encode(opusComHeader, 0, opusComHeader.length, oggOpusComHeader);

        if (this.deepCopyBuffer.remaining() < oggOpusIdHeaderLen + oggOpusComHeaderLen) {
            this.deepCopyBuffer = ByteBuffer.allocate(oggOpusIdHeaderLen + oggOpusComHeaderLen);
        }
        deepCopy(oggOpusIdHeader, 0, dst, 0, oggOpusIdHeaderLen, this.deepCopyBuffer);
        deepCopy(oggOpusComHeader, 0, dst, oggOpusIdHeaderLen, oggOpusComHeaderLen, this.deepCopyBuffer);

        return oggOpusIdHeaderLen + oggOpusComHeaderLen;
    }

    public void uninitialize() {
        // do nothing
    }

    public int encode(byte[] in, int inOffset, int inLength, byte[] dst) {
        int dstLength = -1;

        int length = 28;
        if (dst.length < length) {
            System.err.println("oggEncode() dst length is too short " + dst.length + ", required length = " + length);
            return dstLength;
        }
        if (inLength > OGG_MAX_SEGMENTS * OGG_MAX_SEGMENTS) {
            System.err.println("oggEncode() input length is too large " + inLength);
            return dstLength;
        }
        System.arraycopy(OGG_VORVIS_HEADER_BYTES, 0, dst, 0, 4);

        byte nPageSeg = (byte) Math.ceil(inLength / (double) OGG_MAX_SEGMENTS);

        byte ogg_header_type = 0;
        if (this.isFirst) {
            this.isFirst = false;
            ogg_header_type = 0x02;
            this.ogg_granule_position = 0;
            this.ogg_bitstream_serial_number = (int) System.currentTimeMillis();
            this.ogg_crc = new CRC32();
        }
        this.ogg_crc.update(OGG_CRC_POLY);

        // version
        dst[4] = 0;
        // header type
        dst[5] = ogg_header_type;
        // granule position
        putInt8(dst, 6, this.ogg_granule_position);
        // bitstream serial number
        putInt4(dst, 14, this.ogg_bitstream_serial_number);
        // page sequence number
        putInt4(dst, 18, this.ogg_page_sequence_number++);
        // CRC checksum
        putInt4(dst, 22, this.ogg_crc.getValue());
        // number page segment
        dst[26] = nPageSeg;
        // segment table
        for (int i = 0; i < nPageSeg; i++) {
            if (i + 1 == nPageSeg) {
                dst[27 + i] = (byte) (inLength - (i * OGG_MAX_SEGMENTS));
            } else {
                dst[27 + i] = (byte) OGG_MAX_SEGMENTS;
            }
        }

        dstLength = 27 + nPageSeg;
        if (this.deepCopyBuffer.remaining() < dstLength + inLength) {
            this.deepCopyBuffer = ByteBuffer.allocate(dstLength + inLength);
        }
        deepCopy(in, inOffset, dst, dstLength, inLength, this.deepCopyBuffer);
        dstLength += inLength;

        return dstLength;
    }


    /* Header contents:
      - "OpusHead" (64 bits)
      - version number (8 bits)
      - Channels C (8 bits)
      - Pre-skip (16 bits)
      - Sampling rate (32 bits)
      - Gain in dB (16 bits, S7.8)
      - Mapping (8 bits, 0=single stream (mono/stereo) 1=Vorbis mapping,
                 2=ambisonics, 3=projection ambisonics, 4..239: reserved,
                 240..254: experiments, 255: multistream with no mapping)

      - if (mapping != 0)
         - N = total number of streams (8 bits)
         - M = number of paired streams (8 bits)
         - if (mapping != a projection family)
           - C times channel origin
              - if (C<2*M)
                 - stream = byte/2
                 - if (byte&0x1 == 0)
                     - left
                   else
                     - right
              - else
                 - stream = byte-M
        - else
           - D demixing matrix (C*(N+M)*16 bits)
    */
    private byte[] opusIDHeader(int channel, int sampleRateHz) {
        int length = 19;
        byte[] data = new byte[length];
        System.arraycopy(MAGIC_HEADER_BYTES, 0, data, 0, 8);

        // The version number MUST always be '1'
        data[8] = 1;
        // This is the number of output channels
        data[9] = (byte) channel;
        // This is the number of samples (at 48 kHz) to discard from the decoder output when starting playback
        putInt2(data, 10, 0);
        // This is the sample rate of the original input in Hz
        putInt4(data, 12, sampleRateHz);
        // This is the sample rate of the original input
        putInt2(data, 16, outputGain);
        // This octet indicates the order and semantic meaning of the output channels
        data[18] = channelMappingFamily;

        return data;
    }


    /*
     Comments will be stored in the Vorbis style.
     It is described in the "Structure" section of
        http://www.xiph.org/ogg/vorbis/doc/v-comment.html

     However, Opus and other non-vorbis formats omit the "framing_bit".

    The comment header is decoded as follows:
      1) [vendor_length] = read an unsigned integer of 32 bits
      2) [vendor_string] = read a UTF-8 vector as [vendor_length] octets
      3) [user_comment_list_length] = read an unsigned integer of 32 bits
      4) iterate [user_comment_list_length] times {
         5) [length] = read an unsigned integer of 32 bits
         6) this iteration's user comment = read a UTF-8 vector as [length] octets
         }
      7) done.
    */
    public byte[] opusCommentHeader(String vendorName, String encoderName) {
        int pos = 0;
        byte[] vendorBytes = vendorName.getBytes();
        byte[] usercomment0 = encoderName.getBytes();
        int length = 20 + vendorBytes.length + usercomment0.length;
        byte[] data = new byte[length];

        // magic signature
        System.arraycopy(COMMENT_HEADER_BYTES, 0, data, pos, 8);
        pos += 8;

        // vendor string length
        putInt4(data, pos, vendorBytes.length);
        pos += 4;

        // vendor string
        System.arraycopy(vendorBytes, 0, data, pos, vendorBytes.length);
        pos += vendorBytes.length;

        // user comment list length
        putInt4(data, pos, 1);
        pos += 4;

        // user comment #0 string length
        putInt4(data, pos, usercomment0.length);
        pos += 4;

        // user comment #0 string
        System.arraycopy(usercomment0, 0, data, pos, usercomment0.length);
        pos += usercomment0.length;

        if (pos != data.length) {
            System.err.println("length is invalid " + pos + ":" + data.length);
            return null;
        }

        return data;
    }


    private static void putInt2(byte[] data, int offset, int v) {
        int i = offset;
        data[i++] = (byte) ((v >>> 0) & 0xFF);
        data[i++] = (byte) ((v >>> 8) & 0xFF);
    }

    private static void putInt4(byte[] data, int offset, long v) {
        int i = offset;
        data[i++] = (byte) ((v >>> 0) & 0xFF);
        data[i++] = (byte) ((v >>> 8) & 0xFF);
        data[i++] = (byte) ((v >>> 16) & 0xFF);
        data[i++] = (byte) ((v >>> 24) & 0xFF);
    }

    private static void putInt8(byte[] data, int offset, long v) {
        int i = offset;
        data[i++] = (byte) ((v >>> 0) & 0xFF);
        data[i++] = (byte) ((v >>> 8) & 0xFF);
        data[i++] = (byte) ((v >>> 16) & 0xFF);
        data[i++] = (byte) ((v >>> 24) & 0xFF);
        data[i++] = (byte) ((v >>> 32) & 0xFF);
        data[i++] = (byte) ((v >>> 40) & 0xFF);
        data[i++] = (byte) ((v >>> 48) & 0xFF);
        data[i++] = (byte) ((v >>> 56) & 0xFF);
    }

    private static void deepCopy(byte[] src, int srcOffset, byte[] dst, int dstOffset, int copyLength, ByteBuffer buffer) {
        buffer.clear();
        buffer.put(src, srcOffset, copyLength);
        buffer.flip();
        buffer.get(dst, dstOffset, copyLength);
        buffer.clear();
    }

}
