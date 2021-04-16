// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


// ----------------------------------------------------------------------
// MapArray

/** Concrete Array class for map data
 * 
 *  NB: "value" in this context refers to a pair of a key and the corresponding item */
@Namespace("arrow") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class MapArray extends ListArray {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MapArray(Pointer p) { super(p); }


  public MapArray(@SharedPtr @Cast({"", "std::shared_ptr<arrow::ArrayData>"}) ArrayData data) { super((Pointer)null); allocate(data); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::ArrayData>"}) ArrayData data);

  public MapArray(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @Cast("int64_t") long length,
             @SharedPtr ArrowBuffer value_offsets,
             @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array keys, @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array items,
             @SharedPtr ArrowBuffer null_bitmap/*=nullptr*/,
             @Cast("int64_t") long null_count/*=arrow::kUnknownNullCount*/, @Cast("int64_t") long offset/*=0*/) { super((Pointer)null); allocate(type, length, value_offsets, keys, items, null_bitmap, null_count, offset); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @Cast("int64_t") long length,
             @SharedPtr ArrowBuffer value_offsets,
             @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array keys, @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array items,
             @SharedPtr ArrowBuffer null_bitmap/*=nullptr*/,
             @Cast("int64_t") long null_count/*=arrow::kUnknownNullCount*/, @Cast("int64_t") long offset/*=0*/);
  public MapArray(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @Cast("int64_t") long length,
             @SharedPtr ArrowBuffer value_offsets,
             @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array keys, @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array items) { super((Pointer)null); allocate(type, length, value_offsets, keys, items); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @Cast("int64_t") long length,
             @SharedPtr ArrowBuffer value_offsets,
             @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array keys, @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array items);

  
  ///
  ///
  public MapArray(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @Cast("int64_t") long length,
             @SharedPtr ArrowBuffer value_offsets,
             @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array values,
             @SharedPtr ArrowBuffer null_bitmap/*=nullptr*/,
             @Cast("int64_t") long null_count/*=arrow::kUnknownNullCount*/, @Cast("int64_t") long offset/*=0*/) { super((Pointer)null); allocate(type, length, value_offsets, values, null_bitmap, null_count, offset); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @Cast("int64_t") long length,
             @SharedPtr ArrowBuffer value_offsets,
             @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array values,
             @SharedPtr ArrowBuffer null_bitmap/*=nullptr*/,
             @Cast("int64_t") long null_count/*=arrow::kUnknownNullCount*/, @Cast("int64_t") long offset/*=0*/);
  public MapArray(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @Cast("int64_t") long length,
             @SharedPtr ArrowBuffer value_offsets,
             @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array values) { super((Pointer)null); allocate(type, length, value_offsets, values); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @Cast("int64_t") long length,
             @SharedPtr ArrowBuffer value_offsets,
             @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array values);

  /** \brief Construct MapArray from array of offsets and child key, item arrays
   * 
   *  This function does the bare minimum of validation of the offsets and
   *  input types, and will allocate a new offsets array if necessary (i.e. if
   *  the offsets contain any nulls). If the offsets do not have nulls, they
   *  are assumed to be well-formed
   * 
   *  @param offsets [in] Array containing n + 1 offsets encoding length and
   *  size. Must be of int32 type
   *  @param keys [in] Array containing key values
   *  @param items [in] Array containing item values
   *  @param pool [in] MemoryPool in case new offsets array needs to be
   *  allocated because of null values */
  public static native @ByVal ArrayResult FromArrays(
        @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array offsets, @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array keys,
        @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array items, MemoryPool pool/*=arrow::default_memory_pool()*/);
  public static native @ByVal ArrayResult FromArrays(
        @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array offsets, @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array keys,
        @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array items);

  public static native @ByVal ArrayResult FromArrays(
        @SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array offsets,
        @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array keys, @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array items,
        MemoryPool pool/*=arrow::default_memory_pool()*/);
  public static native @ByVal ArrayResult FromArrays(
        @SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array offsets,
        @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array keys, @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array items);

  public native @Const MapType map_type();

  /** \brief Return array object containing all map keys */
  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array keys();

  /** \brief Return array object containing all mapped items */
  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array items();

  /** Validate child data before constructing the actual MapArray. */
  public static native @ByVal Status ValidateChildData(
        @Const @ByRef ArrayDataVector child_data);
}
