// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


// ===================================================================

@Namespace("tensorflow") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class TrackableObjectGraph_TrackableObject_ObjectReference extends MessageLite {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TrackableObjectGraph_TrackableObject_ObjectReference(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public TrackableObjectGraph_TrackableObject_ObjectReference(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public TrackableObjectGraph_TrackableObject_ObjectReference position(long position) {
        return (TrackableObjectGraph_TrackableObject_ObjectReference)super.position(position);
    }
    @Override public TrackableObjectGraph_TrackableObject_ObjectReference getPointer(long i) {
        return new TrackableObjectGraph_TrackableObject_ObjectReference((Pointer)this).position(position + i);
    }

  public TrackableObjectGraph_TrackableObject_ObjectReference() { super((Pointer)null); allocate(); }
  private native void allocate();

  public TrackableObjectGraph_TrackableObject_ObjectReference(@Const @ByRef TrackableObjectGraph_TrackableObject_ObjectReference from) { super((Pointer)null); allocate(from); }
  private native void allocate(@Const @ByRef TrackableObjectGraph_TrackableObject_ObjectReference from);

  public native @ByRef @Name("operator =") TrackableObjectGraph_TrackableObject_ObjectReference put(@Const @ByRef TrackableObjectGraph_TrackableObject_ObjectReference from);

  public native Arena GetArena();
  public native Pointer GetMaybeArenaPointer();
  public static native @Cast("const google::protobuf::Descriptor*") Pointer descriptor();
  public static native @Cast("const google::protobuf::Descriptor*") Pointer GetDescriptor();
  public static native @Cast("const google::protobuf::Reflection*") Pointer GetReflection();
  public static native @Const @ByRef TrackableObjectGraph_TrackableObject_ObjectReference default_instance();

  public static native void InitAsDefaultInstance();  // FOR INTERNAL USE ONLY
  public static native @Const TrackableObjectGraph_TrackableObject_ObjectReference internal_default_instance();
  @MemberGetter public static native int kIndexInFileMessages();
  public static final int kIndexInFileMessages = kIndexInFileMessages();

  public native void UnsafeArenaSwap(TrackableObjectGraph_TrackableObject_ObjectReference other);
  public native void Swap(TrackableObjectGraph_TrackableObject_ObjectReference other);
  

  // implements Message ----------------------------------------------

  public native TrackableObjectGraph_TrackableObject_ObjectReference New();

  public native TrackableObjectGraph_TrackableObject_ObjectReference New(Arena arena);
  public native void CopyFrom(@Cast("const google::protobuf::Message*") @ByRef MessageLite from);
  public native void MergeFrom(@Cast("const google::protobuf::Message*") @ByRef MessageLite from);
  public native void CopyFrom(@Const @ByRef TrackableObjectGraph_TrackableObject_ObjectReference from);
  public native void MergeFrom(@Const @ByRef TrackableObjectGraph_TrackableObject_ObjectReference from);
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

  // string local_name = 2;
  public native void clear_local_name();
  @MemberGetter public static native int kLocalNameFieldNumber();
  public static final int kLocalNameFieldNumber = kLocalNameFieldNumber();
  public native @StdString BytePointer local_name();
  public native void set_local_name(@StdString BytePointer value);
  public native void set_local_name(@StdString String value);
  public native void set_local_name(@Cast("const char*") BytePointer value, @Cast("size_t") long size);
  public native void set_local_name(String value, @Cast("size_t") long size);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer mutable_local_name();
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer release_local_name();
  public native void set_allocated_local_name(@StdString @Cast({"char*", "std::string*"}) BytePointer local_name);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer unsafe_arena_release_local_name();
  public native void unsafe_arena_set_allocated_local_name(
        @StdString @Cast({"char*", "std::string*"}) BytePointer local_name);

  // int32 node_id = 1;
  public native void clear_node_id();
  @MemberGetter public static native int kNodeIdFieldNumber();
  public static final int kNodeIdFieldNumber = kNodeIdFieldNumber();
  public native @Cast("google::protobuf::int32") int node_id();
  public native void set_node_id(@Cast("google::protobuf::int32") int value);
}
