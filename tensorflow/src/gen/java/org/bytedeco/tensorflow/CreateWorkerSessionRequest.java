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
public class CreateWorkerSessionRequest extends MessageLite {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CreateWorkerSessionRequest(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public CreateWorkerSessionRequest(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public CreateWorkerSessionRequest position(long position) {
        return (CreateWorkerSessionRequest)super.position(position);
    }

  public CreateWorkerSessionRequest() { super((Pointer)null); allocate(); }
  private native void allocate();

  public CreateWorkerSessionRequest(@Const @ByRef CreateWorkerSessionRequest from) { super((Pointer)null); allocate(from); }
  private native void allocate(@Const @ByRef CreateWorkerSessionRequest from);

  public native @ByRef @Name("operator =") CreateWorkerSessionRequest put(@Const @ByRef CreateWorkerSessionRequest from);

  public native Arena GetArena();
  public native Pointer GetMaybeArenaPointer();
  public static native @Cast("const google::protobuf::Descriptor*") Pointer descriptor();
  public static native @Cast("const google::protobuf::Descriptor*") Pointer GetDescriptor();
  public static native @Cast("const google::protobuf::Reflection*") Pointer GetReflection();
  public static native @Const @ByRef CreateWorkerSessionRequest default_instance();

  public static native void InitAsDefaultInstance();  // FOR INTERNAL USE ONLY
  public static native @Const CreateWorkerSessionRequest internal_default_instance();
  @MemberGetter public static native int kIndexInFileMessages();
  public static final int kIndexInFileMessages = kIndexInFileMessages();

  public native void UnsafeArenaSwap(CreateWorkerSessionRequest other);
  public native void Swap(CreateWorkerSessionRequest other);
  

  // implements Message ----------------------------------------------

  public native CreateWorkerSessionRequest New();

  public native CreateWorkerSessionRequest New(Arena arena);
  public native void CopyFrom(@Cast("const google::protobuf::Message*") @ByRef MessageLite from);
  public native void MergeFrom(@Cast("const google::protobuf::Message*") @ByRef MessageLite from);
  public native void CopyFrom(@Const @ByRef CreateWorkerSessionRequest from);
  public native void MergeFrom(@Const @ByRef CreateWorkerSessionRequest from);
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

  // repeated .tensorflow.DeviceAttributes cluster_device_attributes = 4;
  public native int cluster_device_attributes_size();
  public native void clear_cluster_device_attributes();
  @MemberGetter public static native int kClusterDeviceAttributesFieldNumber();
  public static final int kClusterDeviceAttributesFieldNumber = kClusterDeviceAttributesFieldNumber();
  public native DeviceAttributes mutable_cluster_device_attributes(int index);
  public native @Const @ByRef DeviceAttributes cluster_device_attributes(int index);
  public native DeviceAttributes add_cluster_device_attributes();

  // string session_handle = 1;
  public native void clear_session_handle();
  @MemberGetter public static native int kSessionHandleFieldNumber();
  public static final int kSessionHandleFieldNumber = kSessionHandleFieldNumber();
  public native @StdString BytePointer session_handle();
  public native void set_session_handle(@StdString BytePointer value);
  public native void set_session_handle(@StdString String value);
  public native void set_session_handle(@Cast("const char*") BytePointer value, @Cast("size_t") long size);
  public native void set_session_handle(String value, @Cast("size_t") long size);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer mutable_session_handle();
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer release_session_handle();
  public native void set_allocated_session_handle(@StdString @Cast({"char*", "std::string*"}) BytePointer session_handle);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer unsafe_arena_release_session_handle();
  public native void unsafe_arena_set_allocated_session_handle(
        @StdString @Cast({"char*", "std::string*"}) BytePointer session_handle);

  // .tensorflow.ServerDef server_def = 2;
  public native @Cast("bool") boolean has_server_def();
  public native void clear_server_def();
  @MemberGetter public static native int kServerDefFieldNumber();
  public static final int kServerDefFieldNumber = kServerDefFieldNumber();
  public native @Const @ByRef ServerDef server_def();
  public native ServerDef release_server_def();
  public native ServerDef mutable_server_def();
  public native void set_allocated_server_def(ServerDef server_def);
  public native void unsafe_arena_set_allocated_server_def(
        ServerDef server_def);
  public native ServerDef unsafe_arena_release_server_def();

  // bool isolate_session_state = 3;
  public native void clear_isolate_session_state();
  @MemberGetter public static native int kIsolateSessionStateFieldNumber();
  public static final int kIsolateSessionStateFieldNumber = kIsolateSessionStateFieldNumber();
  public native @Cast("bool") boolean isolate_session_state();
  public native void set_isolate_session_state(@Cast("bool") boolean value);
}
