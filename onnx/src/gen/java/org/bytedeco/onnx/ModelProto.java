// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.onnx;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.onnx.global.onnx.*;

// -------------------------------------------------------------------

@Namespace("onnx") @NoOffset @Properties(inherit = org.bytedeco.onnx.presets.onnx.class)
public class ModelProto extends MessageLite {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ModelProto(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public ModelProto(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public ModelProto position(long position) {
        return (ModelProto)super.position(position);
    }
    @Override public ModelProto getPointer(long i) {
        return new ModelProto(this).position(position + i);
    }

  public ModelProto() { super((Pointer)null); allocate(); }
  private native void allocate();

  public ModelProto(@Const @ByRef ModelProto from) { super((Pointer)null); allocate(from); }
  private native void allocate(@Const @ByRef ModelProto from);

  public native @ByRef @Name("operator =") ModelProto put(@Const @ByRef ModelProto from);
//   #if LANG_CXX11
//   #endif
  public native @Const @ByRef UnknownFieldSet unknown_fields();
  public native UnknownFieldSet mutable_unknown_fields();

  public static native @Cast("const google::protobuf::Descriptor*") Pointer descriptor();
  public static native @Const @ByRef ModelProto default_instance();

  public static native void InitAsDefaultInstance();  // FOR INTERNAL USE ONLY
  public static native @Const ModelProto internal_default_instance();
  @MemberGetter public static native int kIndexInFileMessages();
  public static final int kIndexInFileMessages = kIndexInFileMessages();

  public native void Swap(ModelProto other);
  

  // implements Message ----------------------------------------------

  public native ModelProto New();

  public native ModelProto New(Arena arena);
  public native void CopyFrom(@Cast("const google::protobuf::Message*") @ByRef MessageLite from);
  public native void MergeFrom(@Cast("const google::protobuf::Message*") @ByRef MessageLite from);
  public native void CopyFrom(@Const @ByRef ModelProto from);
  public native void MergeFrom(@Const @ByRef ModelProto from);
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

  // repeated .onnx.OperatorSetIdProto opset_import = 8;
  public native int opset_import_size();
  public native void clear_opset_import();
  @MemberGetter public static native int kOpsetImportFieldNumber();
  public static final int kOpsetImportFieldNumber = kOpsetImportFieldNumber();
  public native OperatorSetIdProto mutable_opset_import(int index);
  public native @Const @ByRef OperatorSetIdProto opset_import(int index);
  public native OperatorSetIdProto add_opset_import();

  // repeated .onnx.StringStringEntryProto metadata_props = 14;
  public native int metadata_props_size();
  public native void clear_metadata_props();
  @MemberGetter public static native int kMetadataPropsFieldNumber();
  public static final int kMetadataPropsFieldNumber = kMetadataPropsFieldNumber();
  public native StringStringEntryProto mutable_metadata_props(int index);
  public native @Const @ByRef StringStringEntryProto metadata_props(int index);
  public native StringStringEntryProto add_metadata_props();

  // repeated .onnx.TrainingInfoProto training_info = 20;
  public native int training_info_size();
  public native void clear_training_info();
  @MemberGetter public static native int kTrainingInfoFieldNumber();
  public static final int kTrainingInfoFieldNumber = kTrainingInfoFieldNumber();
  public native TrainingInfoProto mutable_training_info(int index);
  public native @Const @ByRef TrainingInfoProto training_info(int index);
  public native TrainingInfoProto add_training_info();

  // optional string producer_name = 2;
  public native @Cast("bool") boolean has_producer_name();
  public native void clear_producer_name();
  @MemberGetter public static native int kProducerNameFieldNumber();
  public static final int kProducerNameFieldNumber = kProducerNameFieldNumber();
  public native @StdString BytePointer producer_name();
  public native void set_producer_name(@StdString BytePointer value);
  public native void set_producer_name(@StdString String value);
//   #if LANG_CXX11
//   #endif
  public native void set_producer_name(@Cast("const char*") BytePointer value, @Cast("size_t") long size);
  public native void set_producer_name(String value, @Cast("size_t") long size);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer mutable_producer_name();
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer release_producer_name();
  public native void set_allocated_producer_name(@StdString @Cast({"char*", "std::string*"}) BytePointer producer_name);

  // optional string producer_version = 3;
  public native @Cast("bool") boolean has_producer_version();
  public native void clear_producer_version();
  @MemberGetter public static native int kProducerVersionFieldNumber();
  public static final int kProducerVersionFieldNumber = kProducerVersionFieldNumber();
  public native @StdString BytePointer producer_version();
  public native void set_producer_version(@StdString BytePointer value);
  public native void set_producer_version(@StdString String value);
//   #if LANG_CXX11
//   #endif
  public native void set_producer_version(@Cast("const char*") BytePointer value, @Cast("size_t") long size);
  public native void set_producer_version(String value, @Cast("size_t") long size);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer mutable_producer_version();
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer release_producer_version();
  public native void set_allocated_producer_version(@StdString @Cast({"char*", "std::string*"}) BytePointer producer_version);

  // optional string domain = 4;
  public native @Cast("bool") boolean has_domain();
  public native void clear_domain();
  @MemberGetter public static native int kDomainFieldNumber();
  public static final int kDomainFieldNumber = kDomainFieldNumber();
  public native @StdString BytePointer domain();
  public native void set_domain(@StdString BytePointer value);
  public native void set_domain(@StdString String value);
//   #if LANG_CXX11
//   #endif
  public native void set_domain(@Cast("const char*") BytePointer value, @Cast("size_t") long size);
  public native void set_domain(String value, @Cast("size_t") long size);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer mutable_domain();
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer release_domain();
  public native void set_allocated_domain(@StdString @Cast({"char*", "std::string*"}) BytePointer domain);

  // optional string doc_string = 6;
  public native @Cast("bool") boolean has_doc_string();
  public native void clear_doc_string();
  @MemberGetter public static native int kDocStringFieldNumber();
  public static final int kDocStringFieldNumber = kDocStringFieldNumber();
  public native @StdString BytePointer doc_string();
  public native void set_doc_string(@StdString BytePointer value);
  public native void set_doc_string(@StdString String value);
//   #if LANG_CXX11
//   #endif
  public native void set_doc_string(@Cast("const char*") BytePointer value, @Cast("size_t") long size);
  public native void set_doc_string(String value, @Cast("size_t") long size);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer mutable_doc_string();
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer release_doc_string();
  public native void set_allocated_doc_string(@StdString @Cast({"char*", "std::string*"}) BytePointer doc_string);

  // optional .onnx.GraphProto graph = 7;
  public native @Cast("bool") boolean has_graph();
  public native void clear_graph();
  @MemberGetter public static native int kGraphFieldNumber();
  public static final int kGraphFieldNumber = kGraphFieldNumber();
  public native @Const @ByRef GraphProto graph();
  public native GraphProto release_graph();
  public native GraphProto mutable_graph();
  public native void set_allocated_graph(GraphProto graph);

  // optional int64 ir_version = 1;
  public native @Cast("bool") boolean has_ir_version();
  public native void clear_ir_version();
  @MemberGetter public static native int kIrVersionFieldNumber();
  public static final int kIrVersionFieldNumber = kIrVersionFieldNumber();
  public native @Cast("google::protobuf::int64") long ir_version();
  public native void set_ir_version(@Cast("google::protobuf::int64") long value);

  // optional int64 model_version = 5;
  public native @Cast("bool") boolean has_model_version();
  public native void clear_model_version();
  @MemberGetter public static native int kModelVersionFieldNumber();
  public static final int kModelVersionFieldNumber = kModelVersionFieldNumber();
  public native @Cast("google::protobuf::int64") long model_version();
  public native void set_model_version(@Cast("google::protobuf::int64") long value);
}
