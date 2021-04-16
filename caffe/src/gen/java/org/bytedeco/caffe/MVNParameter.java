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
public class MVNParameter extends Message {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MVNParameter(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public MVNParameter(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public MVNParameter position(long position) {
        return (MVNParameter)super.position(position);
    }
    @Override public MVNParameter getPointer(long i) {
        return new MVNParameter((Pointer)this).position(position + i);
    }

  public MVNParameter() { super((Pointer)null); allocate(); }
  private native void allocate();

  public MVNParameter(@Const @ByRef MVNParameter from) { super((Pointer)null); allocate(from); }
  private native void allocate(@Const @ByRef MVNParameter from);

  public native @ByRef @Name("operator =") MVNParameter put(@Const @ByRef MVNParameter from);
//   #if LANG_CXX11
//   #endif
  public native @Const @ByRef UnknownFieldSet unknown_fields();
  public native UnknownFieldSet mutable_unknown_fields();

  public static native @Const Descriptor descriptor();
  public static native @Const @ByRef MVNParameter default_instance();

  public static native void InitAsDefaultInstance();  // FOR INTERNAL USE ONLY
  public static native @Const MVNParameter internal_default_instance();
  @MemberGetter public static native int kIndexInFileMessages();
  public static final int kIndexInFileMessages = kIndexInFileMessages();

  public native void Swap(MVNParameter other);
  

  // implements Message ----------------------------------------------

  public native final MVNParameter New();

  public native final MVNParameter New(Arena arena);
  public native final void CopyFrom(@Const @ByRef Message from);
  public native final void MergeFrom(@Const @ByRef Message from);
  public native void CopyFrom(@Const @ByRef MVNParameter from);
  public native void MergeFrom(@Const @ByRef MVNParameter from);
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

  // optional bool across_channels = 2 [default = false];
  public native @Cast("bool") boolean has_across_channels();
  public native void clear_across_channels();
  @MemberGetter public static native int kAcrossChannelsFieldNumber();
  public static final int kAcrossChannelsFieldNumber = kAcrossChannelsFieldNumber();
  public native @Cast("bool") boolean across_channels();
  public native void set_across_channels(@Cast("bool") boolean value);

  // optional bool normalize_variance = 1 [default = true];
  public native @Cast("bool") boolean has_normalize_variance();
  public native void clear_normalize_variance();
  @MemberGetter public static native int kNormalizeVarianceFieldNumber();
  public static final int kNormalizeVarianceFieldNumber = kNormalizeVarianceFieldNumber();
  public native @Cast("bool") boolean normalize_variance();
  public native void set_normalize_variance(@Cast("bool") boolean value);

  // optional float eps = 3 [default = 1e-09];
  public native @Cast("bool") boolean has_eps();
  public native void clear_eps();
  @MemberGetter public static native int kEpsFieldNumber();
  public static final int kEpsFieldNumber = kEpsFieldNumber();
  public native float eps();
  public native void set_eps(float value);
}
