// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


// -------------------------------------------------------------------

@Namespace("tensorflow") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class ConfigProto_Experimental extends MessageLite {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ConfigProto_Experimental(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public ConfigProto_Experimental(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public ConfigProto_Experimental position(long position) {
        return (ConfigProto_Experimental)super.position(position);
    }
    @Override public ConfigProto_Experimental getPointer(long i) {
        return new ConfigProto_Experimental((Pointer)this).position(position + i);
    }

  public ConfigProto_Experimental() { super((Pointer)null); allocate(); }
  private native void allocate();

  public ConfigProto_Experimental(@Const @ByRef ConfigProto_Experimental from) { super((Pointer)null); allocate(from); }
  private native void allocate(@Const @ByRef ConfigProto_Experimental from);

  public native @ByRef @Name("operator =") ConfigProto_Experimental put(@Const @ByRef ConfigProto_Experimental from);

  public native Arena GetArena();
  public native Pointer GetMaybeArenaPointer();
  public static native @Cast("const google::protobuf::Descriptor*") Pointer descriptor();
  public static native @Cast("const google::protobuf::Descriptor*") Pointer GetDescriptor();
  public static native @Cast("const google::protobuf::Reflection*") Pointer GetReflection();
  public static native @Const @ByRef ConfigProto_Experimental default_instance();

  public static native void InitAsDefaultInstance();  // FOR INTERNAL USE ONLY
  public static native @Const ConfigProto_Experimental internal_default_instance();
  @MemberGetter public static native int kIndexInFileMessages();
  public static final int kIndexInFileMessages = kIndexInFileMessages();

  public native void UnsafeArenaSwap(ConfigProto_Experimental other);
  public native void Swap(ConfigProto_Experimental other);
  

  // implements Message ----------------------------------------------

  public native ConfigProto_Experimental New();

  public native ConfigProto_Experimental New(Arena arena);
  public native void CopyFrom(@Cast("const google::protobuf::Message*") @ByRef MessageLite from);
  public native void MergeFrom(@Cast("const google::protobuf::Message*") @ByRef MessageLite from);
  public native void CopyFrom(@Const @ByRef ConfigProto_Experimental from);
  public native void MergeFrom(@Const @ByRef ConfigProto_Experimental from);
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

  // string collective_group_leader = 1;
  public native void clear_collective_group_leader();
  @MemberGetter public static native int kCollectiveGroupLeaderFieldNumber();
  public static final int kCollectiveGroupLeaderFieldNumber = kCollectiveGroupLeaderFieldNumber();
  public native @StdString BytePointer collective_group_leader();
  public native void set_collective_group_leader(@StdString BytePointer value);
  public native void set_collective_group_leader(@StdString String value);
  public native void set_collective_group_leader(@Cast("const char*") BytePointer value, @Cast("size_t") long size);
  public native void set_collective_group_leader(String value, @Cast("size_t") long size);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer mutable_collective_group_leader();
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer release_collective_group_leader();
  public native void set_allocated_collective_group_leader(@StdString @Cast({"char*", "std::string*"}) BytePointer collective_group_leader);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer unsafe_arena_release_collective_group_leader();
  public native void unsafe_arena_set_allocated_collective_group_leader(
        @StdString @Cast({"char*", "std::string*"}) BytePointer collective_group_leader);

  // string executor_type = 3;
  public native void clear_executor_type();
  @MemberGetter public static native int kExecutorTypeFieldNumber();
  public static final int kExecutorTypeFieldNumber = kExecutorTypeFieldNumber();
  public native @StdString BytePointer executor_type();
  public native void set_executor_type(@StdString BytePointer value);
  public native void set_executor_type(@StdString String value);
  public native void set_executor_type(@Cast("const char*") BytePointer value, @Cast("size_t") long size);
  public native void set_executor_type(String value, @Cast("size_t") long size);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer mutable_executor_type();
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer release_executor_type();
  public native void set_allocated_executor_type(@StdString @Cast({"char*", "std::string*"}) BytePointer executor_type);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer unsafe_arena_release_executor_type();
  public native void unsafe_arena_set_allocated_executor_type(
        @StdString @Cast({"char*", "std::string*"}) BytePointer executor_type);

  // .tensorflow.SessionMetadata session_metadata = 11;
  public native @Cast("bool") boolean has_session_metadata();
  public native void clear_session_metadata();
  @MemberGetter public static native int kSessionMetadataFieldNumber();
  public static final int kSessionMetadataFieldNumber = kSessionMetadataFieldNumber();
  public native @Const @ByRef SessionMetadata session_metadata();
  public native SessionMetadata release_session_metadata();
  public native SessionMetadata mutable_session_metadata();
  public native void set_allocated_session_metadata(SessionMetadata session_metadata);
  public native void unsafe_arena_set_allocated_session_metadata(
        SessionMetadata session_metadata);
  public native SessionMetadata unsafe_arena_release_session_metadata();

  // int32 recv_buf_max_chunk = 4;
  public native void clear_recv_buf_max_chunk();
  @MemberGetter public static native int kRecvBufMaxChunkFieldNumber();
  public static final int kRecvBufMaxChunkFieldNumber = kRecvBufMaxChunkFieldNumber();
  public native @Cast("google::protobuf::int32") int recv_buf_max_chunk();
  public native void set_recv_buf_max_chunk(@Cast("google::protobuf::int32") int value);

  // bool use_numa_affinity = 5;
  public native void clear_use_numa_affinity();
  @MemberGetter public static native int kUseNumaAffinityFieldNumber();
  public static final int kUseNumaAffinityFieldNumber = kUseNumaAffinityFieldNumber();
  public native @Cast("bool") boolean use_numa_affinity();
  public native void set_use_numa_affinity(@Cast("bool") boolean value);

  // bool collective_deterministic_sequential_execution = 6;
  public native void clear_collective_deterministic_sequential_execution();
  @MemberGetter public static native int kCollectiveDeterministicSequentialExecutionFieldNumber();
  public static final int kCollectiveDeterministicSequentialExecutionFieldNumber = kCollectiveDeterministicSequentialExecutionFieldNumber();
  public native @Cast("bool") boolean collective_deterministic_sequential_execution();
  public native void set_collective_deterministic_sequential_execution(@Cast("bool") boolean value);

  // bool collective_nccl = 7;
  public native void clear_collective_nccl();
  @MemberGetter public static native int kCollectiveNcclFieldNumber();
  public static final int kCollectiveNcclFieldNumber = kCollectiveNcclFieldNumber();
  public native @Cast("bool") boolean collective_nccl();
  public native void set_collective_nccl(@Cast("bool") boolean value);

  // bool share_session_state_in_clusterspec_propagation = 8;
  public native void clear_share_session_state_in_clusterspec_propagation();
  @MemberGetter public static native int kShareSessionStateInClusterspecPropagationFieldNumber();
  public static final int kShareSessionStateInClusterspecPropagationFieldNumber = kShareSessionStateInClusterspecPropagationFieldNumber();
  public native @Cast("bool") boolean share_session_state_in_clusterspec_propagation();
  public native void set_share_session_state_in_clusterspec_propagation(@Cast("bool") boolean value);

  // bool disable_thread_spinning = 9;
  public native void clear_disable_thread_spinning();
  @MemberGetter public static native int kDisableThreadSpinningFieldNumber();
  public static final int kDisableThreadSpinningFieldNumber = kDisableThreadSpinningFieldNumber();
  public native @Cast("bool") boolean disable_thread_spinning();
  public native void set_disable_thread_spinning(@Cast("bool") boolean value);

  // bool share_cluster_devices_in_session = 10;
  public native void clear_share_cluster_devices_in_session();
  @MemberGetter public static native int kShareClusterDevicesInSessionFieldNumber();
  public static final int kShareClusterDevicesInSessionFieldNumber = kShareClusterDevicesInSessionFieldNumber();
  public native @Cast("bool") boolean share_cluster_devices_in_session();
  public native void set_share_cluster_devices_in_session(@Cast("bool") boolean value);

  // bool optimize_for_static_graph = 12;
  public native void clear_optimize_for_static_graph();
  @MemberGetter public static native int kOptimizeForStaticGraphFieldNumber();
  public static final int kOptimizeForStaticGraphFieldNumber = kOptimizeForStaticGraphFieldNumber();
  public native @Cast("bool") boolean optimize_for_static_graph();
  public native void set_optimize_for_static_graph(@Cast("bool") boolean value);
}
