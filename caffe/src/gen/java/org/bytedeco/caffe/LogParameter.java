// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.caffe;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import org.bytedeco.opencv.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import org.bytedeco.opencv.opencv_videoio.*;
import static org.bytedeco.opencv.global.opencv_videoio.*;
import org.bytedeco.opencv.opencv_highgui.*;
import static org.bytedeco.opencv.global.opencv_highgui.*;
import org.bytedeco.hdf5.*;
import static org.bytedeco.hdf5.global.hdf5.*;

import static org.bytedeco.caffe.global.caffe.*;

// -------------------------------------------------------------------

@Namespace("caffe") @NoOffset @Properties(inherit = org.bytedeco.caffe.presets.caffe.class)
public class LogParameter extends Message {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LogParameter(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public LogParameter(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public LogParameter position(long position) {
        return (LogParameter)super.position(position);
    }
    @Override public LogParameter getPointer(long i) {
        return new LogParameter(this).position(position + i);
    }

  public LogParameter() { super((Pointer)null); allocate(); }
  private native void allocate();

  public LogParameter(@Const @ByRef LogParameter from) { super((Pointer)null); allocate(from); }
  private native void allocate(@Const @ByRef LogParameter from);

  public native @ByRef @Name("operator =") LogParameter put(@Const @ByRef LogParameter from);
//   #if LANG_CXX11
//   #endif
  public native @Const @ByRef UnknownFieldSet unknown_fields();
  public native UnknownFieldSet mutable_unknown_fields();

  public static native @Const Descriptor descriptor();
  public static native @Const @ByRef LogParameter default_instance();

  public static native void InitAsDefaultInstance();  // FOR INTERNAL USE ONLY
  public static native @Const LogParameter internal_default_instance();
  @MemberGetter public static native int kIndexInFileMessages();
  public static final int kIndexInFileMessages = kIndexInFileMessages();

  public native void Swap(LogParameter other);
  

  // implements Message ----------------------------------------------

  public native final LogParameter New();

  public native final LogParameter New(Arena arena);
  public native final void CopyFrom(@Const @ByRef Message from);
  public native final void MergeFrom(@Const @ByRef Message from);
  public native void CopyFrom(@Const @ByRef LogParameter from);
  public native void MergeFrom(@Const @ByRef LogParameter from);
  public native final void Clear();
  public native @Cast("bool") final boolean IsInitialized();

  public native @Cast("size_t") final long ByteSizeLong();
//   #if GOOGLE_PROTOBUF_ENABLE_EXPERIMENTAL_PARSER
//   #else
  public native @Cast("bool") final boolean MergePartialFromCodedStream(
        CodedInputStream input);
//   #endif  // GOOGLE_PROTOBUF_ENABLE_EXPERIMENTAL_PARSER
  public native final void SerializeWithCachedSizes(
        CodedOutputStream output);
  public native @Cast("google::protobuf::uint8*") final BytePointer InternalSerializeWithCachedSizesToArray(
        @Cast("google::protobuf::uint8*") BytePointer target);
  public native @Cast("google::protobuf::uint8*") final ByteBuffer InternalSerializeWithCachedSizesToArray(
        @Cast("google::protobuf::uint8*") ByteBuffer target);
  public native @Cast("google::protobuf::uint8*") final byte[] InternalSerializeWithCachedSizesToArray(
        @Cast("google::protobuf::uint8*") byte[] target);
  public native final int GetCachedSize();

  public native @ByVal final Metadata GetMetadata();

  // nested types ----------------------------------------------------

  // accessors -------------------------------------------------------

  // optional float shift = 3 [default = 0];
  public native @Cast("bool") boolean has_shift();
  public native void clear_shift();
  @MemberGetter public static native int kShiftFieldNumber();
  public static final int kShiftFieldNumber = kShiftFieldNumber();
  public native float shift();
  public native void set_shift(float value);

  // optional float base = 1 [default = -1];
  public native @Cast("bool") boolean has_base();
  public native void clear_base();
  @MemberGetter public static native int kBaseFieldNumber();
  public static final int kBaseFieldNumber = kBaseFieldNumber();
  public native float base();
  public native void set_base(float value);

  // optional float scale = 2 [default = 1];
  public native @Cast("bool") boolean has_scale();
  public native void clear_scale();
  @MemberGetter public static native int kScaleFieldNumber();
  public static final int kScaleFieldNumber = kScaleFieldNumber();
  public native float scale();
  public native void set_scale(float value);
}
