// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;

// -------------------------------------------------------------------

@Namespace("tensorflow") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class DebugOptions extends MessageLite {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DebugOptions(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public DebugOptions(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public DebugOptions position(long position) {
        return (DebugOptions)super.position(position);
    }

  public DebugOptions() { super((Pointer)null); allocate(); }
  private native void allocate();

  public DebugOptions(@Const @ByRef DebugOptions from) { super((Pointer)null); allocate(from); }
  private native void allocate(@Const @ByRef DebugOptions from);

  public native @ByRef @Name("operator =") DebugOptions put(@Const @ByRef DebugOptions from);

  public native Arena GetArena();
  public native Pointer GetMaybeArenaPointer();
  public static native @Cast("const google::protobuf::Descriptor*") Pointer descriptor();
  public static native @Cast("const google::protobuf::Descriptor*") Pointer GetDescriptor();
  public static native @Cast("const google::protobuf::Reflection*") Pointer GetReflection();
  public static native @Const @ByRef DebugOptions default_instance();

  public static native void InitAsDefaultInstance();  // FOR INTERNAL USE ONLY
  public static native @Const DebugOptions internal_default_instance();
  @MemberGetter public static native int kIndexInFileMessages();
  public static final int kIndexInFileMessages = kIndexInFileMessages();

  public native void UnsafeArenaSwap(DebugOptions other);
  public native void Swap(DebugOptions other);
  

  // implements Message ----------------------------------------------

  public native DebugOptions New();

  public native DebugOptions New(Arena arena);
  public native void CopyFrom(@Cast("const google::protobuf::Message*") @ByRef MessageLite from);
  public native void MergeFrom(@Cast("const google::protobuf::Message*") @ByRef MessageLite from);
  public native void CopyFrom(@Const @ByRef DebugOptions from);
  public native void MergeFrom(@Const @ByRef DebugOptions from);
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

  // repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;
  public native int debug_tensor_watch_opts_size();
  public native void clear_debug_tensor_watch_opts();
  @MemberGetter public static native int kDebugTensorWatchOptsFieldNumber();
  public static final int kDebugTensorWatchOptsFieldNumber = kDebugTensorWatchOptsFieldNumber();
  public native DebugTensorWatch mutable_debug_tensor_watch_opts(int index);
  public native @Const @ByRef DebugTensorWatch debug_tensor_watch_opts(int index);
  public native DebugTensorWatch add_debug_tensor_watch_opts();

  // bool reset_disk_byte_usage = 11;
  public native void clear_reset_disk_byte_usage();
  @MemberGetter public static native int kResetDiskByteUsageFieldNumber();
  public static final int kResetDiskByteUsageFieldNumber = kResetDiskByteUsageFieldNumber();
  public native @Cast("bool") boolean reset_disk_byte_usage();
  public native void set_reset_disk_byte_usage(@Cast("bool") boolean value);

  // int64 global_step = 10;
  public native void clear_global_step();
  @MemberGetter public static native int kGlobalStepFieldNumber();
  public static final int kGlobalStepFieldNumber = kGlobalStepFieldNumber();
  public native @Cast("google::protobuf::int64") long global_step();
  public native void set_global_step(@Cast("google::protobuf::int64") long value);
}
