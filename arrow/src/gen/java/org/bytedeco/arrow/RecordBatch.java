// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \class RecordBatch
 *  \brief Collection of equal-length arrays matching a particular Schema
 * 
 *  A record batch is table-like data structure that is semantically a sequence
 *  of fields, each a contiguous Arrow array */
@Namespace("arrow") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class RecordBatch extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public RecordBatch(Pointer p) { super(p); }


  /** @param schema [in] The record batch schema
   *  @param num_rows [in] length of fields in the record batch. Each array
   *  should have the same length as num_rows
   *  @param columns [in] the record batch fields as vector of arrays */
  
  ///
  ///
  public static native @SharedPtr @Cast({"", "std::shared_ptr<arrow::RecordBatch>"}) RecordBatch Make(@SharedPtr @ByVal Schema schema,
                                             @Cast("int64_t") long num_rows,
                                             @ByVal ArrayVector columns);

  /** \brief Construct record batch from vector of internal data structures
   *  @since 0.5.0
   * 
   *  This class is intended for internal use, or advanced users.
   * 
   *  @param schema the record batch schema
   *  @param num_rows the number of semantic rows in the record batch. This
   *  should be equal to the length of each field
   *  @param columns the data for the batch's columns */
  
  ///
  public static native @SharedPtr @Cast({"", "std::shared_ptr<arrow::RecordBatch>"}) RecordBatch Make(
        @SharedPtr @ByVal Schema schema, @Cast("int64_t") long num_rows,
        @ByVal ArrayDataVector columns);

  /** \brief Convert record batch to struct array
   * 
   *  Create a struct array whose child arrays are the record batch's columns.
   *  Note that the record batch's top-level field metadata cannot be reflected
   *  in the resulting struct array. */
  
  ///
  public native @ByVal ArrayResult ToStructArray();

  /** \brief Construct record batch from struct array
   * 
   *  This constructs a record batch using the child arrays of the given
   *  array, which must be a struct array.  Note that the struct array's own
   *  null bitmap is not reflected in the resulting record batch. */
  
  ///
  public static native @ByVal RecordBatchResult FromStructArray(
        @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array array);

  /** \brief Determine if two record batches are exactly equal
   * 
   *  @param other [in] the RecordBatch to compare with
   *  @param check_metadata [in] if true, check that Schema metadata is the same
   *  @return true if batches are equal */
  public native @Cast("bool") boolean Equals(@Const @ByRef RecordBatch other, @Cast("bool") boolean check_metadata/*=false*/);
  public native @Cast("bool") boolean Equals(@Const @ByRef RecordBatch other);

  /** \brief Determine if two record batches are approximately equal */
  public native @Cast("bool") boolean ApproxEquals(@Const @ByRef RecordBatch other);

  // \return the table's schema
  /** @return true if batches are equal */
  public native @SharedPtr @ByVal Schema schema();

  /** \brief Retrieve all columns at once */
  public native @ByVal ArrayVector columns();

  /** \brief Retrieve an array from the record batch
   *  @param i [in] field index, does not boundscheck
   *  @return an Array object */
  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array column(int i);

  /** \brief Retrieve an array from the record batch
   *  @param name [in] field name
   *  @return an Array or null if no field was found */
  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array GetColumnByName(@StdString String name);
  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array GetColumnByName(@StdString BytePointer name);

  /** \brief Retrieve an array's internal data from the record batch
   *  @param i [in] field index, does not boundscheck
   *  @return an internal ArrayData object */
  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::ArrayData>"}) ArrayData column_data(int i);

  /** \brief Retrieve all arrays' internal data from the record batch. */
  
  ///
  public native @ByVal ArrayDataVector column_data();

  /** \brief Add column to the record batch, producing a new RecordBatch
   * 
   *  @param i [in] field index, which will be boundschecked
   *  @param field [in] field to be added
   *  @param column [in] column to be added */
  
  ///
  ///
  public native @ByVal RecordBatchResult AddColumn(
        int i, @SharedPtr @Cast({"", "std::shared_ptr<arrow::Field>"}) Field field,
        @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array column);

  /** \brief Add new nullable column to the record batch, producing a new
   *  RecordBatch.
   * 
   *  For non-nullable columns, use the Field-based version of this method.
   * 
   *  @param i [in] field index, which will be boundschecked
   *  @param field_name [in] name of field to be added
   *  @param column [in] column to be added */
  
  ///
  public native @ByVal RecordBatchResult AddColumn(
        int i, @StdString String field_name, @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array column);
  public native @ByVal RecordBatchResult AddColumn(
        int i, @StdString BytePointer field_name, @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array column);

  /** \brief Remove column from the record batch, producing a new RecordBatch
   * 
   *  @param i [in] field index, does boundscheck */
  public native @ByVal RecordBatchResult RemoveColumn(int i);

  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::RecordBatch>"}) RecordBatch ReplaceSchemaMetadata(
        @Const @Cast("const arrow::KeyValueMetadata*") @SharedPtr @ByRef KeyValueMetadata metadata);

  /** \brief Name in i-th column */
  public native @StdString String column_name(int i);

  /** @return the number of columns in the table */
  public native int num_columns();

  /** @return the number of rows (the corresponding length of each column) */
  public native @Cast("int64_t") long num_rows();

  /** \brief Slice each of the arrays in the record batch
   *  @param offset [in] the starting offset to slice, through end of batch
   *  @return new record batch */
  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::RecordBatch>"}) RecordBatch Slice(@Cast("int64_t") long offset);

  /** \brief Slice each of the arrays in the record batch
   *  @param offset [in] the starting offset to slice
   *  @param length [in] the number of elements to slice from offset
   *  @return new record batch */
  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::RecordBatch>"}) RecordBatch Slice(@Cast("int64_t") long offset, @Cast("int64_t") long length);

  /** @return PrettyPrint representation suitable for debugging */
  
  ///
  ///
  public native @StdString String ToString();

  /** \brief Perform cheap validation checks to determine obvious inconsistencies
   *  within the record batch's schema and internal data.
   * 
   *  This is O(k) where k is the total number of fields and array descendents.
   * 
   *  @return Status */
  
  ///
  ///
  public native @ByVal Status Validate();

  /** \brief Perform extensive validation checks to determine inconsistencies
   *  within the record batch's schema and internal data.
   * 
   *  This is potentially O(k*n) where n is the number of rows.
   * 
   *  @return Status */
  public native @ByVal Status ValidateFull();
}
