// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.onnx;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.onnx.global.onnx.*;

// -------------------------------------------------------------------

@Namespace("onnx") @NoOffset @Properties(inherit = org.bytedeco.onnx.presets.onnx.class)
public class SparseTensorProto extends MessageLite {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SparseTensorProto(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SparseTensorProto(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public SparseTensorProto position(long position) {
        return (SparseTensorProto)super.position(position);
    }
    @Override public SparseTensorProto getPointer(long i) {
        return new SparseTensorProto(this).position(position + i);
    }

  public SparseTensorProto() { super((Pointer)null); allocate(); }
  private native void allocate();

  public SparseTensorProto(@Const @ByRef SparseTensorProto from) { super((Pointer)null); allocate(from); }
  private native void allocate(@Const @ByRef SparseTensorProto from);

  public native @ByRef @Name("operator =") SparseTensorProto put(@Const @ByRef SparseTensorProto from);
//   #if LANG_CXX11
//   #endif
  public native @Const @ByRef UnknownFieldSet unknown_fields();
  public native UnknownFieldSet mutable_unknown_fields();

  public static native @Cast("const google::protobuf::Descriptor*") Pointer descriptor();
  public static native @Const @ByRef SparseTensorProto default_instance();

  public static native void InitAsDefaultInstance();  // FOR INTERNAL USE ONLY
  public static native @Const SparseTensorProto internal_default_instance();
  @MemberGetter public static native int kIndexInFileMessages();
  public static final int kIndexInFileMessages = kIndexInFileMessages();

  public native void Swap(SparseTensorProto other);
  

  // implements Message ----------------------------------------------

  public native SparseTensorProto New();

  public native SparseTensorProto New(Arena arena);
  public native void CopyFrom(@Cast("const google::protobuf::Message*") @ByRef MessageLite from);
  public native void MergeFrom(@Cast("const google::protobuf::Message*") @ByRef MessageLite from);
  public native void CopyFrom(@Const @ByRef SparseTensorProto from);
  public native void MergeFrom(@Const @ByRef SparseTensorProto from);
  public native void Clear();
  public native @Cast("bool") boolean IsInitialized();

  public native @Cast("size_t") long ByteSizeLong();
//   #if GOOGLE_PROTOBUF_ENABLE_EXPERIMENTAL_PARSER
//   #else
  public native @Cast("bool") boolean MergePartialFromCodedStream(
        CodedInputStream input);
//   #endif  // GOOGLE_PROTOBUF_ENABLE_EXPERIMENTAL_PARSER
  public native void SerializeWithCachedSizes(
        CodedOutputStream output);
  public native @Cast("google::protobuf::uint8*") BytePointer InternalSerializeWithCachedSizesToArray(
        @Cast("google::protobuf::uint8*") BytePointer target);
  public native @Cast("google::protobuf::uint8*") ByteBuffer InternalSerializeWithCachedSizesToArray(
        @Cast("google::protobuf::uint8*") ByteBuffer target);
  public native @Cast("google::protobuf::uint8*") byte[] InternalSerializeWithCachedSizesToArray(
        @Cast("google::protobuf::uint8*") byte[] target);
  public native int GetCachedSize();

  public native @ByVal @Cast("google::protobuf::Metadata*") Pointer GetMetadata();

  // nested types ----------------------------------------------------

  // accessors -------------------------------------------------------

  // repeated int64 dims = 3;
  public native int dims_size();
  public native void clear_dims();
  @MemberGetter public static native int kDimsFieldNumber();
  public static final int kDimsFieldNumber = kDimsFieldNumber();
  public native @Cast("google::protobuf::int64") long dims(int index);
  public native void set_dims(int index, @Cast("google::protobuf::int64") long value);
  public native void add_dims(@Cast("google::protobuf::int64") long value);

  // optional .onnx.TensorProto values = 1;
  public native @Cast("bool") boolean has_values();
  public native void clear_values();
  @MemberGetter public static native int kValuesFieldNumber();
  public static final int kValuesFieldNumber = kValuesFieldNumber();
  public native @Const @ByRef TensorProto values();
  public native TensorProto release_values();
  public native TensorProto mutable_values();
  public native void set_allocated_values(TensorProto values);

  // optional .onnx.TensorProto indices = 2;
  public native @Cast("bool") boolean has_indices();
  public native void clear_indices();
  @MemberGetter public static native int kIndicesFieldNumber();
  public static final int kIndicesFieldNumber = kIndicesFieldNumber();
  public native @Const @ByRef TensorProto indices();
  public native TensorProto release_indices();
  public native TensorProto mutable_indices();
  public native void set_allocated_indices(TensorProto indices);
}
