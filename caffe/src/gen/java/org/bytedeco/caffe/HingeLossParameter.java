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
public class HingeLossParameter extends Message {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public HingeLossParameter(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public HingeLossParameter(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public HingeLossParameter position(long position) {
        return (HingeLossParameter)super.position(position);
    }
    @Override public HingeLossParameter getPointer(long i) {
        return new HingeLossParameter((Pointer)this).position(position + i);
    }

  public HingeLossParameter() { super((Pointer)null); allocate(); }
  private native void allocate();

  public HingeLossParameter(@Const @ByRef HingeLossParameter from) { super((Pointer)null); allocate(from); }
  private native void allocate(@Const @ByRef HingeLossParameter from);

  public native @ByRef @Name("operator =") HingeLossParameter put(@Const @ByRef HingeLossParameter from);
//   #if LANG_CXX11
//   #endif
  public native @Const @ByRef UnknownFieldSet unknown_fields();
  public native UnknownFieldSet mutable_unknown_fields();

  public static native @Const Descriptor descriptor();
  public static native @Const @ByRef HingeLossParameter default_instance();

  public static native void InitAsDefaultInstance();  // FOR INTERNAL USE ONLY
  public static native @Const HingeLossParameter internal_default_instance();
  @MemberGetter public static native int kIndexInFileMessages();
  public static final int kIndexInFileMessages = kIndexInFileMessages();

  public native void Swap(HingeLossParameter other);
  

  // implements Message ----------------------------------------------

  public native final HingeLossParameter New();

  public native final HingeLossParameter New(Arena arena);
  public native final void CopyFrom(@Const @ByRef Message from);
  public native final void MergeFrom(@Const @ByRef Message from);
  public native void CopyFrom(@Const @ByRef HingeLossParameter from);
  public native void MergeFrom(@Const @ByRef HingeLossParameter from);
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
  @MemberGetter public static native @Cast("const caffe::HingeLossParameter::Norm") int L1();
  public static final int L1 = L1();
  @MemberGetter public static native @Cast("const caffe::HingeLossParameter::Norm") int L2();
  public static final int L2 = L2();
  public static native @Cast("bool") boolean Norm_IsValid(int value);
  @MemberGetter public static native @Cast("const caffe::HingeLossParameter::Norm") int Norm_MIN();
  public static final int Norm_MIN = Norm_MIN();
  @MemberGetter public static native @Cast("const caffe::HingeLossParameter::Norm") int Norm_MAX();
  public static final int Norm_MAX = Norm_MAX();
  @MemberGetter public static native int Norm_ARRAYSIZE();
  public static final int Norm_ARRAYSIZE = Norm_ARRAYSIZE();
  public static native @Const EnumDescriptor Norm_descriptor();
  public static native @StdString BytePointer Norm_Name(@Cast("caffe::HingeLossParameter::Norm") int value);
  public static native @Cast("bool") boolean Norm_Parse(@StdString BytePointer name,
        @Cast("caffe::HingeLossParameter::Norm*") IntPointer value);
  public static native @Cast("bool") boolean Norm_Parse(@StdString String name,
        @Cast("caffe::HingeLossParameter::Norm*") IntBuffer value);
  public static native @Cast("bool") boolean Norm_Parse(@StdString BytePointer name,
        @Cast("caffe::HingeLossParameter::Norm*") int[] value);
  public static native @Cast("bool") boolean Norm_Parse(@StdString String name,
        @Cast("caffe::HingeLossParameter::Norm*") IntPointer value);
  public static native @Cast("bool") boolean Norm_Parse(@StdString BytePointer name,
        @Cast("caffe::HingeLossParameter::Norm*") IntBuffer value);
  public static native @Cast("bool") boolean Norm_Parse(@StdString String name,
        @Cast("caffe::HingeLossParameter::Norm*") int[] value);

  // accessors -------------------------------------------------------

  // optional .caffe.HingeLossParameter.Norm norm = 1 [default = L1];
  public native @Cast("bool") boolean has_norm();
  public native void clear_norm();
  @MemberGetter public static native int kNormFieldNumber();
  public static final int kNormFieldNumber = kNormFieldNumber();
  public native @Cast("caffe::HingeLossParameter_Norm") int norm();
  public native void set_norm(@Cast("caffe::HingeLossParameter_Norm") int value);
}
