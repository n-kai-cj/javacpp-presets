// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;

// ===================================================================

@Namespace("tensorflow") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class VariableDef extends MessageLite {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public VariableDef(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public VariableDef(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public VariableDef position(long position) {
        return (VariableDef)super.position(position);
    }

  public VariableDef() { super((Pointer)null); allocate(); }
  private native void allocate();

  public VariableDef(@Const @ByRef VariableDef from) { super((Pointer)null); allocate(from); }
  private native void allocate(@Const @ByRef VariableDef from);

  public native @ByRef @Name("operator =") VariableDef put(@Const @ByRef VariableDef from);

  public native Arena GetArena();
  public native Pointer GetMaybeArenaPointer();
  public static native @Cast("const google::protobuf::Descriptor*") Pointer descriptor();
  public static native @Cast("const google::protobuf::Descriptor*") Pointer GetDescriptor();
  public static native @Cast("const google::protobuf::Reflection*") Pointer GetReflection();
  public static native @Const @ByRef VariableDef default_instance();

  public static native void InitAsDefaultInstance();  // FOR INTERNAL USE ONLY
  public static native @Const VariableDef internal_default_instance();
  @MemberGetter public static native int kIndexInFileMessages();
  public static final int kIndexInFileMessages = kIndexInFileMessages();

  public native void UnsafeArenaSwap(VariableDef other);
  public native void Swap(VariableDef other);
  

  // implements Message ----------------------------------------------

  public native VariableDef New();

  public native VariableDef New(Arena arena);
  public native void CopyFrom(@Cast("const google::protobuf::Message*") @ByRef MessageLite from);
  public native void MergeFrom(@Cast("const google::protobuf::Message*") @ByRef MessageLite from);
  public native void CopyFrom(@Const @ByRef VariableDef from);
  public native void MergeFrom(@Const @ByRef VariableDef from);
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

  // string variable_name = 1;
  public native void clear_variable_name();
  @MemberGetter public static native int kVariableNameFieldNumber();
  public static final int kVariableNameFieldNumber = kVariableNameFieldNumber();
  public native @StdString BytePointer variable_name();
  public native void set_variable_name(@StdString BytePointer value);
  public native void set_variable_name(@StdString String value);
  public native void set_variable_name(@Cast("const char*") BytePointer value, @Cast("size_t") long size);
  public native void set_variable_name(String value, @Cast("size_t") long size);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer mutable_variable_name();
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer release_variable_name();
  public native void set_allocated_variable_name(@StdString @Cast({"char*", "std::string*"}) BytePointer variable_name);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer unsafe_arena_release_variable_name();
  public native void unsafe_arena_set_allocated_variable_name(
        @StdString @Cast({"char*", "std::string*"}) BytePointer variable_name);

  // string initializer_name = 2;
  public native void clear_initializer_name();
  @MemberGetter public static native int kInitializerNameFieldNumber();
  public static final int kInitializerNameFieldNumber = kInitializerNameFieldNumber();
  public native @StdString BytePointer initializer_name();
  public native void set_initializer_name(@StdString BytePointer value);
  public native void set_initializer_name(@StdString String value);
  public native void set_initializer_name(@Cast("const char*") BytePointer value, @Cast("size_t") long size);
  public native void set_initializer_name(String value, @Cast("size_t") long size);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer mutable_initializer_name();
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer release_initializer_name();
  public native void set_allocated_initializer_name(@StdString @Cast({"char*", "std::string*"}) BytePointer initializer_name);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer unsafe_arena_release_initializer_name();
  public native void unsafe_arena_set_allocated_initializer_name(
        @StdString @Cast({"char*", "std::string*"}) BytePointer initializer_name);

  // string snapshot_name = 3;
  public native void clear_snapshot_name();
  @MemberGetter public static native int kSnapshotNameFieldNumber();
  public static final int kSnapshotNameFieldNumber = kSnapshotNameFieldNumber();
  public native @StdString BytePointer snapshot_name();
  public native void set_snapshot_name(@StdString BytePointer value);
  public native void set_snapshot_name(@StdString String value);
  public native void set_snapshot_name(@Cast("const char*") BytePointer value, @Cast("size_t") long size);
  public native void set_snapshot_name(String value, @Cast("size_t") long size);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer mutable_snapshot_name();
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer release_snapshot_name();
  public native void set_allocated_snapshot_name(@StdString @Cast({"char*", "std::string*"}) BytePointer snapshot_name);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer unsafe_arena_release_snapshot_name();
  public native void unsafe_arena_set_allocated_snapshot_name(
        @StdString @Cast({"char*", "std::string*"}) BytePointer snapshot_name);

  // string initial_value_name = 6;
  public native void clear_initial_value_name();
  @MemberGetter public static native int kInitialValueNameFieldNumber();
  public static final int kInitialValueNameFieldNumber = kInitialValueNameFieldNumber();
  public native @StdString BytePointer initial_value_name();
  public native void set_initial_value_name(@StdString BytePointer value);
  public native void set_initial_value_name(@StdString String value);
  public native void set_initial_value_name(@Cast("const char*") BytePointer value, @Cast("size_t") long size);
  public native void set_initial_value_name(String value, @Cast("size_t") long size);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer mutable_initial_value_name();
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer release_initial_value_name();
  public native void set_allocated_initial_value_name(@StdString @Cast({"char*", "std::string*"}) BytePointer initial_value_name);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer unsafe_arena_release_initial_value_name();
  public native void unsafe_arena_set_allocated_initial_value_name(
        @StdString @Cast({"char*", "std::string*"}) BytePointer initial_value_name);

  // .tensorflow.SaveSliceInfoDef save_slice_info_def = 4;
  public native @Cast("bool") boolean has_save_slice_info_def();
  public native void clear_save_slice_info_def();
  @MemberGetter public static native int kSaveSliceInfoDefFieldNumber();
  public static final int kSaveSliceInfoDefFieldNumber = kSaveSliceInfoDefFieldNumber();
  public native @Const @ByRef SaveSliceInfoDef save_slice_info_def();
  public native SaveSliceInfoDef release_save_slice_info_def();
  public native SaveSliceInfoDef mutable_save_slice_info_def();
  public native void set_allocated_save_slice_info_def(SaveSliceInfoDef save_slice_info_def);
  public native void unsafe_arena_set_allocated_save_slice_info_def(
        SaveSliceInfoDef save_slice_info_def);
  public native SaveSliceInfoDef unsafe_arena_release_save_slice_info_def();

  // bool is_resource = 5;
  public native void clear_is_resource();
  @MemberGetter public static native int kIsResourceFieldNumber();
  public static final int kIsResourceFieldNumber = kIsResourceFieldNumber();
  public native @Cast("bool") boolean is_resource();
  public native void set_is_resource(@Cast("bool") boolean value);

  // bool trainable = 7;
  public native void clear_trainable();
  @MemberGetter public static native int kTrainableFieldNumber();
  public static final int kTrainableFieldNumber = kTrainableFieldNumber();
  public native @Cast("bool") boolean trainable();
  public native void set_trainable(@Cast("bool") boolean value);

  // .tensorflow.VariableSynchronization synchronization = 8;
  public native void clear_synchronization();
  @MemberGetter public static native int kSynchronizationFieldNumber();
  public static final int kSynchronizationFieldNumber = kSynchronizationFieldNumber();
  public native @Cast("tensorflow::VariableSynchronization") int synchronization();
  public native void set_synchronization(@Cast("tensorflow::VariableSynchronization") int value);

  // .tensorflow.VariableAggregation aggregation = 9;
  public native void clear_aggregation();
  @MemberGetter public static native int kAggregationFieldNumber();
  public static final int kAggregationFieldNumber = kAggregationFieldNumber();
  public native @Cast("tensorflow::VariableAggregation") int aggregation();
  public native void set_aggregation(@Cast("tensorflow::VariableAggregation") int value);
}
