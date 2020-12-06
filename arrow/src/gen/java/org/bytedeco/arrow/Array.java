// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


// ----------------------------------------------------------------------
// User array accessor types

/** \brief Array base type
 *  Immutable data array with some logical type and some length.
 * 
 *  Any memory is owned by the respective Buffer instance (or its parents).
 * 
 *  The base class is only required to have a null bitmap buffer if the null
 *  count is greater than 0
 * 
 *  If known, the null count can be provided in the base Array constructor. If
 *  the null count is not known, pass -1 to indicate that the null count is to
 *  be computed on the first call to null_count() */
@Namespace("arrow") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class Array extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Array(Pointer p) { super(p); }


  /** \brief Return true if value at index is null. Does not boundscheck */
  public native @Cast("bool") boolean IsNull(@Cast("int64_t") long i);

  /** \brief Return true if value at index is valid (not null). Does not
   *  boundscheck */
  public native @Cast("bool") boolean IsValid(@Cast("int64_t") long i);

  /** \brief Return a Scalar containing the value of this array at i */
  public native @ByVal ScalarResult GetScalar(@Cast("int64_t") long i);

  /** Size in the number of elements this array contains. */
  public native @Cast("int64_t") long length();

  /** A relative position into another array's data, to enable zero-copy
   *  slicing. This value defaults to zero */
  public native @Cast("int64_t") long offset();

  /** The number of null entries in the array. If the null count was not known
   *  at time of construction (and set to a negative value), then the null
   *  count will be computed and cached on the first invocation of this
   *  function */
  public native @Cast("int64_t") long null_count();

  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type();
  
  ///
  public native @Cast("arrow::Type::type") int type_id();

  /** Buffer for the validity (null) bitmap, if any. Note that Union types
   *  never have a null bitmap.
   * 
   *  Note that for {@code null_count == 0} or for null type, this will be null.
   *  This buffer does not account for any slice offset */
  
  ///
  public native @SharedPtr ArrowBuffer null_bitmap();

  /** Raw pointer to the null bitmap.
   * 
   *  Note that for {@code null_count == 0} or for null type, this will be null.
   *  This buffer does not account for any slice offset */
  public native @Cast("const uint8_t*") BytePointer null_bitmap_data();

  /** Equality comparison with another array */
  public native @Cast("bool") boolean Equals(@Const @ByRef Array arr, @Const @ByRef(nullValue = "arrow::EqualOptions::Defaults()") EqualOptions arg1);
  public native @Cast("bool") boolean Equals(@Const @ByRef Array arr);

  /** \brief Return the formatted unified diff of arrow::Diff between this
   *  Array and another Array */
  
  ///
  public native @StdString String Diff(@Const @ByRef Array other);

  /** Approximate equality comparison with another array
   * 
   *  epsilon is only used if this is FloatArray or DoubleArray */
  public native @Cast("bool") boolean ApproxEquals(@SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array arr,
                      @Const @ByRef(nullValue = "arrow::EqualOptions::Defaults()") EqualOptions arg1);
  public native @Cast("bool") boolean ApproxEquals(@SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array arr);

  /** Compare if the range of slots specified are equal for the given array and
   *  this array.  end_idx exclusive.  This methods does not bounds check. */
  public native @Cast("bool") boolean RangeEquals(@Cast("int64_t") long start_idx, @Cast("int64_t") long end_idx, @Cast("int64_t") long other_start_idx,
                     @Const @ByRef Array other);
  public native @Cast("bool") boolean RangeEquals(@Const @ByRef Array other, @Cast("int64_t") long start_idx, @Cast("int64_t") long end_idx,
                     @Cast("int64_t") long other_start_idx);

  
  ///
  public native @ByVal Status Accept(ArrayVisitor visitor);

  /** Construct a zero-copy view of this array with the given type.
   * 
   *  This method checks if the types are layout-compatible.
   *  Nested types are traversed in depth-first order. Data buffers must have
   *  the same item sizes, even though the logical types may be different.
   *  An error is returned if the types are not layout-compatible. */
  
  ///
  ///
  public native @ByVal ArrayResult View(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type);

  /** Construct a zero-copy slice of the array with the indicated offset and
   *  length
   * 
   *  @param offset [in] the position of the first element in the constructed
   *  slice
   *  @param length [in] the length of the slice. If there are not enough
   *  elements in the array, the length will be adjusted accordingly
   * 
   *  @return a new object wrapped in std::shared_ptr<Array> */
  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array Slice(@Cast("int64_t") long offset, @Cast("int64_t") long length);

  /** Slice from offset until end of the array */
  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array Slice(@Cast("int64_t") long offset);

  /** Input-checking variant of Array::Slice */
  public native @ByVal ArrayResult SliceSafe(@Cast("int64_t") long offset, @Cast("int64_t") long length);
  /** Input-checking variant of Array::Slice */
  public native @ByVal ArrayResult SliceSafe(@Cast("int64_t") long offset);

  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::ArrayData>"}) ArrayData data();

  public native int num_fields();

  /** @return PrettyPrint representation of array suitable for debugging */
  
  ///
  ///
  public native @StdString String ToString();

  /** \brief Perform cheap validation checks to determine obvious inconsistencies
   *  within the array's internal data.
   * 
   *  This is O(k) where k is the number of descendents.
   * 
   *  @return Status */
  
  ///
  ///
  public native @ByVal Status Validate();

  /** \brief Perform extensive validation checks to determine inconsistencies
   *  within the array's internal data.
   * 
   *  This is potentially O(k*n) where k is the number of descendents and n
   *  is the array length.
   * 
   *  @return Status */
  public native @ByVal Status ValidateFull();
}
