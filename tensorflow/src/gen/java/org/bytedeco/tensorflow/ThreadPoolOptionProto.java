// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;

// -------------------------------------------------------------------

@Namespace("tensorflow") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class ThreadPoolOptionProto extends MessageLite {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ThreadPoolOptionProto(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public ThreadPoolOptionProto(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public ThreadPoolOptionProto position(long position) {
        return (ThreadPoolOptionProto)super.position(position);
    }
    @Override public ThreadPoolOptionProto getPointer(long i) {
        return new ThreadPoolOptionProto(this).position(position + i);
    }

  public ThreadPoolOptionProto() { super((Pointer)null); allocate(); }
  private native void allocate();

  public ThreadPoolOptionProto(@Const @ByRef ThreadPoolOptionProto from) { super((Pointer)null); allocate(from); }
  private native void allocate(@Const @ByRef ThreadPoolOptionProto from);

  public native @ByRef @Name("operator =") ThreadPoolOptionProto put(@Const @ByRef ThreadPoolOptionProto from);

  public native Arena GetArena();
  public native Pointer GetMaybeArenaPointer();
  public static native @Cast("const google::protobuf::Descriptor*") Pointer descriptor();
  public static native @Cast("const google::protobuf::Descriptor*") Pointer GetDescriptor();
  public static native @Cast("const google::protobuf::Reflection*") Pointer GetReflection();
  public static native @Const @ByRef ThreadPoolOptionProto default_instance();

  public static native void InitAsDefaultInstance();  // FOR INTERNAL USE ONLY
  public static native @Const ThreadPoolOptionProto internal_default_instance();
  @MemberGetter public static native int kIndexInFileMessages();
  public static final int kIndexInFileMessages = kIndexInFileMessages();

  public native void UnsafeArenaSwap(ThreadPoolOptionProto other);
  public native void Swap(ThreadPoolOptionProto other);
  

  // implements Message ----------------------------------------------

  public native ThreadPoolOptionProto New();

  public native ThreadPoolOptionProto New(Arena arena);
  public native void CopyFrom(@Cast("const google::protobuf::Message*") @ByRef MessageLite from);
  public native void MergeFrom(@Cast("const google::protobuf::Message*") @ByRef MessageLite from);
  public native void CopyFrom(@Const @ByRef ThreadPoolOptionProto from);
  public native void MergeFrom(@Const @ByRef ThreadPoolOptionProto from);
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

  // string global_name = 2;
  public native void clear_global_name();
  @MemberGetter public static native int kGlobalNameFieldNumber();
  public static final int kGlobalNameFieldNumber = kGlobalNameFieldNumber();
  public native @StdString BytePointer global_name();
  public native void set_global_name(@StdString BytePointer value);
  public native void set_global_name(@StdString String value);
  public native void set_global_name(@Cast("const char*") BytePointer value, @Cast("size_t") long size);
  public native void set_global_name(String value, @Cast("size_t") long size);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer mutable_global_name();
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer release_global_name();
  public native void set_allocated_global_name(@StdString @Cast({"char*", "std::string*"}) BytePointer global_name);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer unsafe_arena_release_global_name();
  public native void unsafe_arena_set_allocated_global_name(
        @StdString @Cast({"char*", "std::string*"}) BytePointer global_name);

  // int32 num_threads = 1;
  public native void clear_num_threads();
  @MemberGetter public static native int kNumThreadsFieldNumber();
  public static final int kNumThreadsFieldNumber = kNumThreadsFieldNumber();
  public native @Cast("google::protobuf::int32") int num_threads();
  public native void set_num_threads(@Cast("google::protobuf::int32") int value);
}
