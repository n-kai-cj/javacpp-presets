// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

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
public class DropoutParameter extends Message {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DropoutParameter(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public DropoutParameter(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public DropoutParameter position(long position) {
        return (DropoutParameter)super.position(position);
    }
    @Override public DropoutParameter getPointer(long i) {
        return new DropoutParameter((Pointer)this).position(position + i);
    }

  public DropoutParameter() { super((Pointer)null); allocate(); }
  private native void allocate();

  public DropoutParameter(@Const @ByRef DropoutParameter from) { super((Pointer)null); allocate(from); }
  private native void allocate(@Const @ByRef DropoutParameter from);

  public native @ByRef @Name("operator =") DropoutParameter put(@Const @ByRef DropoutParameter from);
//   #if LANG_CXX11
//   #endif
  public native @Const @ByRef UnknownFieldSet unknown_fields();
  public native UnknownFieldSet mutable_unknown_fields();

  public static native @Const Descriptor descriptor();
  public static native @Const @ByRef DropoutParameter default_instance();

  public static native void InitAsDefaultInstance();  // FOR INTERNAL USE ONLY
  public static native @Const DropoutParameter internal_default_instance();
  @MemberGetter public static native int kIndexInFileMessages();
  public static final int kIndexInFileMessages = kIndexInFileMessages();

  public native void Swap(DropoutParameter other);
  

  // implements Message ----------------------------------------------

  public native final DropoutParameter New();

  public native final DropoutParameter New(Arena arena);
  public native final void CopyFrom(@Const @ByRef Message from);
  public native final void MergeFrom(@Const @ByRef Message from);
  public native void CopyFrom(@Const @ByRef DropoutParameter from);
  public native void MergeFrom(@Const @ByRef DropoutParameter from);
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

  // optional float dropout_ratio = 1 [default = 0.5];
  public native @Cast("bool") boolean has_dropout_ratio();
  public native void clear_dropout_ratio();
  @MemberGetter public static native int kDropoutRatioFieldNumber();
  public static final int kDropoutRatioFieldNumber = kDropoutRatioFieldNumber();
  public native float dropout_ratio();
  public native void set_dropout_ratio(float value);
}
