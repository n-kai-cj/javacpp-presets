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
public class RunGraphResponse extends MessageLite {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public RunGraphResponse(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public RunGraphResponse(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public RunGraphResponse position(long position) {
        return (RunGraphResponse)super.position(position);
    }
    @Override public RunGraphResponse getPointer(long i) {
        return new RunGraphResponse(this).position(position + i);
    }

  public RunGraphResponse() { super((Pointer)null); allocate(); }
  private native void allocate();

  public RunGraphResponse(@Const @ByRef RunGraphResponse from) { super((Pointer)null); allocate(from); }
  private native void allocate(@Const @ByRef RunGraphResponse from);

  public native @ByRef @Name("operator =") RunGraphResponse put(@Const @ByRef RunGraphResponse from);

  public native Arena GetArena();
  public native Pointer GetMaybeArenaPointer();
  public static native @Cast("const google::protobuf::Descriptor*") Pointer descriptor();
  public static native @Cast("const google::protobuf::Descriptor*") Pointer GetDescriptor();
  public static native @Cast("const google::protobuf::Reflection*") Pointer GetReflection();
  public static native @Const @ByRef RunGraphResponse default_instance();

  public static native void InitAsDefaultInstance();  // FOR INTERNAL USE ONLY
  public static native @Const RunGraphResponse internal_default_instance();
  @MemberGetter public static native int kIndexInFileMessages();
  public static final int kIndexInFileMessages = kIndexInFileMessages();

  public native void UnsafeArenaSwap(RunGraphResponse other);
  public native void Swap(RunGraphResponse other);
  

  // implements Message ----------------------------------------------

  public native RunGraphResponse New();

  public native RunGraphResponse New(Arena arena);
  public native void CopyFrom(@Cast("const google::protobuf::Message*") @ByRef MessageLite from);
  public native void MergeFrom(@Cast("const google::protobuf::Message*") @ByRef MessageLite from);
  public native void CopyFrom(@Const @ByRef RunGraphResponse from);
  public native void MergeFrom(@Const @ByRef RunGraphResponse from);
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

  // repeated .tensorflow.NamedTensorProto recv = 1;
  public native int recv_size();
  public native void clear_recv();
  @MemberGetter public static native int kRecvFieldNumber();
  public static final int kRecvFieldNumber = kRecvFieldNumber();
  public native NamedTensorProto mutable_recv(int index);
  public native @Const @ByRef NamedTensorProto recv(int index);
  public native NamedTensorProto add_recv();

  // repeated .tensorflow.GraphDef partition_graph = 4;
  public native int partition_graph_size();
  public native void clear_partition_graph();
  @MemberGetter public static native int kPartitionGraphFieldNumber();
  public static final int kPartitionGraphFieldNumber = kPartitionGraphFieldNumber();
  public native GraphDef mutable_partition_graph(int index);
  public native @Const @ByRef GraphDef partition_graph(int index);
  public native GraphDef add_partition_graph();

  // string status_error_message = 6;
  public native void clear_status_error_message();
  @MemberGetter public static native int kStatusErrorMessageFieldNumber();
  public static final int kStatusErrorMessageFieldNumber = kStatusErrorMessageFieldNumber();
  public native @StdString BytePointer status_error_message();
  public native void set_status_error_message(@StdString BytePointer value);
  public native void set_status_error_message(@StdString String value);
  public native void set_status_error_message(@Cast("const char*") BytePointer value, @Cast("size_t") long size);
  public native void set_status_error_message(String value, @Cast("size_t") long size);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer mutable_status_error_message();
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer release_status_error_message();
  public native void set_allocated_status_error_message(@StdString @Cast({"char*", "std::string*"}) BytePointer status_error_message);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer unsafe_arena_release_status_error_message();
  public native void unsafe_arena_set_allocated_status_error_message(
        @StdString @Cast({"char*", "std::string*"}) BytePointer status_error_message);

  // .tensorflow.StepStats step_stats = 2;
  public native @Cast("bool") boolean has_step_stats();
  public native void clear_step_stats();
  @MemberGetter public static native int kStepStatsFieldNumber();
  public static final int kStepStatsFieldNumber = kStepStatsFieldNumber();
  public native @Const @ByRef StepStats step_stats();
  public native StepStats release_step_stats();
  public native StepStats mutable_step_stats();
  public native void set_allocated_step_stats(StepStats step_stats);
  public native void unsafe_arena_set_allocated_step_stats(
        StepStats step_stats);
  public native StepStats unsafe_arena_release_step_stats();

  // .tensorflow.CostGraphDef cost_graph = 3;
  public native @Cast("bool") boolean has_cost_graph();
  public native void clear_cost_graph();
  @MemberGetter public static native int kCostGraphFieldNumber();
  public static final int kCostGraphFieldNumber = kCostGraphFieldNumber();
  public native @Const @ByRef CostGraphDef cost_graph();
  public native CostGraphDef release_cost_graph();
  public native CostGraphDef mutable_cost_graph();
  public native void set_allocated_cost_graph(CostGraphDef cost_graph);
  public native void unsafe_arena_set_allocated_cost_graph(
        CostGraphDef cost_graph);
  public native CostGraphDef unsafe_arena_release_cost_graph();

  // .tensorflow.error.Code status_code = 5;
  public native void clear_status_code();
  @MemberGetter public static native int kStatusCodeFieldNumber();
  public static final int kStatusCodeFieldNumber = kStatusCodeFieldNumber();
  public native @Cast("tensorflow::error::Code") int status_code();
  public native void set_status_code(@Cast("tensorflow::error::Code") int value);
}
