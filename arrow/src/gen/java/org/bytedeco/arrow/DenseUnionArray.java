// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief Concrete Array class for dense union data
 * 
 *  Note that union types do not have a validity bitmap */
@Namespace("arrow") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class DenseUnionArray extends UnionArray {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DenseUnionArray(Pointer p) { super(p); }


  public DenseUnionArray(@SharedPtr @Cast({"", "std::shared_ptr<arrow::ArrayData>"}) ArrayData data) { super((Pointer)null); allocate(data); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::ArrayData>"}) ArrayData data);

  
  ///
  ///
  public DenseUnionArray(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @Cast("int64_t") long length, @ByVal ArrayVector children,
                    @SharedPtr ArrowBuffer type_ids,
                    @SharedPtr ArrowBuffer value_offsets/*=nullptr*/, @Cast("int64_t") long offset/*=0*/) { super((Pointer)null); allocate(type, length, children, type_ids, value_offsets, offset); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @Cast("int64_t") long length, @ByVal ArrayVector children,
                    @SharedPtr ArrowBuffer type_ids,
                    @SharedPtr ArrowBuffer value_offsets/*=nullptr*/, @Cast("int64_t") long offset/*=0*/);
  public DenseUnionArray(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @Cast("int64_t") long length, @ByVal ArrayVector children,
                    @SharedPtr ArrowBuffer type_ids) { super((Pointer)null); allocate(type, length, children, type_ids); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @Cast("int64_t") long length, @ByVal ArrayVector children,
                    @SharedPtr ArrowBuffer type_ids);

  /** \brief Construct DenseUnionArray from type_ids, value_offsets, and children
   * 
   *  This function does the bare minimum of validation of the offsets and
   *  input types.
   * 
   *  @param type_ids [in] An array of logical type ids for the union type
   *  @param value_offsets [in] An array of signed int32 values indicating the
   *  relative offset into the respective child array for the type in a given slot.
   *  The respective offsets for each child value array must be in order / increasing.
   *  @param children [in] Vector of children Arrays containing the data for each type.
   *  @param type_codes [in] Vector of type codes. */
  
  ///
  ///
  public static native @ByVal ArrayResult Make(@Const @ByRef Array type_ids,
                                               @Const @ByRef Array value_offsets,
                                               @ByVal ArrayVector children,
                                               @Cast("arrow::DenseUnionArray::type_code_t*") @StdVector BytePointer type_codes);
  public static native @ByVal ArrayResult Make(@Const @ByRef Array type_ids,
                                               @Const @ByRef Array value_offsets,
                                               @ByVal ArrayVector children,
                                               @Cast("arrow::DenseUnionArray::type_code_t*") @StdVector ByteBuffer type_codes);
  public static native @ByVal ArrayResult Make(@Const @ByRef Array type_ids,
                                               @Const @ByRef Array value_offsets,
                                               @ByVal ArrayVector children,
                                               @Cast("arrow::DenseUnionArray::type_code_t*") @StdVector byte[] type_codes);

  /** \brief Construct DenseUnionArray with custom field names from type_ids,
   *  value_offsets, and children
   * 
   *  This function does the bare minimum of validation of the offsets and
   *  input types.
   * 
   *  @param type_ids [in] An array of logical type ids for the union type
   *  @param value_offsets [in] An array of signed int32 values indicating the
   *  relative offset into the respective child array for the type in a given slot.
   *  The respective offsets for each child value array must be in order / increasing.
   *  @param children [in] Vector of children Arrays containing the data for each type.
   *  @param field_names [in] Vector of strings containing the name of each field.
   *  @param type_codes [in] Vector of type codes. */
  public static native @ByVal ArrayResult Make(@Const @ByRef Array type_ids,
                                               @Const @ByRef Array value_offsets,
                                               @ByVal ArrayVector children,
                                               @ByVal(nullValue = "std::vector<std::string>({})") StringVector field_names,
                                               @Cast("arrow::DenseUnionArray::type_code_t*") @StdVector BytePointer type_codes/*={}*/);
  public static native @ByVal ArrayResult Make(@Const @ByRef Array type_ids,
                                               @Const @ByRef Array value_offsets,
                                               @ByVal ArrayVector children);
  public static native @ByVal ArrayResult Make(@Const @ByRef Array type_ids,
                                               @Const @ByRef Array value_offsets,
                                               @ByVal ArrayVector children,
                                               @ByVal(nullValue = "std::vector<std::string>({})") StringVector field_names,
                                               @Cast("arrow::DenseUnionArray::type_code_t*") @StdVector ByteBuffer type_codes/*={}*/);
  public static native @ByVal ArrayResult Make(@Const @ByRef Array type_ids,
                                               @Const @ByRef Array value_offsets,
                                               @ByVal ArrayVector children,
                                               @ByVal(nullValue = "std::vector<std::string>({})") StringVector field_names,
                                               @Cast("arrow::DenseUnionArray::type_code_t*") @StdVector byte[] type_codes/*={}*/);

  public native @Const DenseUnionType union_type();

  /** Note that this buffer does not account for any slice offset */
  public native @SharedPtr ArrowBuffer value_offsets();

  public native int value_offset(@Cast("int64_t") long i);

  public native @Const IntPointer raw_value_offsets();
}
