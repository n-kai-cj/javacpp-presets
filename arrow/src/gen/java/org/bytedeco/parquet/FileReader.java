// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.parquet;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.parquet.*;


/** \brief Arrow read adapter class for deserializing Parquet files as Arrow row batches.
 * 
 *  This interfaces caters for different use cases and thus provides different
 *  interfaces. In its most simplistic form, we cater for a user that wants to
 *  read the whole Parquet at once with the {@code FileReader::ReadTable} method.
 * 
 *  More advanced users that also want to implement parallelism on top of each
 *  single Parquet files should do this on the RowGroup level. For this, they can
 *  call {@code FileReader::RowGroup(i)->ReadTable} to receive only the specified
 *  RowGroup as a table.
 * 
 *  In the most advanced situation, where a consumer wants to independently read
 *  RowGroups in parallel and consume each column individually, they can call
 *  {@code FileReader::RowGroup(i)->Column(j)->Read} and receive an {@code arrow::Column}
 *  instance.
 *  */
// TODO(wesm): nested data does not always make sense with this user
// interface unless you are only reading a single leaf node from a branch of
// a table. For example:
//
// repeated group data {
//   optional group record {
//     optional int32 val1;
//     optional byte_array val2;
//     optional bool val3;
//   }
//   optional int32 val4;
// }
//
// In the Parquet file, there are 3 leaf nodes:
//
// * data.record.val1
// * data.record.val2
// * data.record.val3
// * data.val4
//
// When materializing this data in an Arrow array, we would have:
//
// data: list<struct<
//   record: struct<
//    val1: int32,
//    val2: string (= list<uint8>),
//    val3: bool,
//   >,
//   val4: int32
// >>
//
// However, in the Parquet format, each leaf node has its own repetition and
// definition levels describing the structure of the intermediate nodes in
// this array structure. Thus, we will need to scan the leaf data for a group
// of leaf nodes part of the same type tree to create a single result Arrow
// nested array structure.
//
// This is additionally complicated "chunky" repeated fields or very large byte
// arrays
@Namespace("parquet::arrow") @Properties(inherit = org.bytedeco.arrow.presets.parquet.class)
public class FileReader extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FileReader(Pointer p) { super(p); }

  /** Factory function to create a FileReader from a ParquetFileReader and properties */
  public static native @ByVal Status Make(MemoryPool pool,
                                @UniquePtr ParquetFileReader reader,
                                @Const @ByRef ArrowReaderProperties properties,
                                @UniquePtr FileReader out);

  /** Factory function to create a FileReader from a ParquetFileReader */
  public static native @ByVal Status Make(MemoryPool pool,
                                @UniquePtr ParquetFileReader reader,
                                @UniquePtr FileReader out);

  // Since the distribution of columns amongst a Parquet file's row groups may
  // be uneven (the number of values in each column chunk can be different), we
  // provide a column-oriented read interface. The ColumnReader hides the
  // details of paging through the file's row groups and yielding
  // fully-materialized arrow::Array instances
  //
  // Returns error status if the column of interest is not flat.
  public native @ByVal Status GetColumn(int i, @UniquePtr ColumnReader out);

  /** \brief Return arrow schema for all the columns. */
  
  ///
  public native @ByVal Status GetSchema(@SharedPtr Schema out);

  /** \brief Read column as a whole into a chunked array.
   * 
   *  The indicated column index is relative to the schema */
  public native @ByVal Status ReadColumn(int i,
                                       @SharedPtr ChunkedArray out);

  // NOTE: Experimental API
  // Reads a specific top level schema field into an Array
  // The index i refers the index of the top level schema field, which may
  // be nested or flat - e.g.
  //
  // 0 foo.bar
  //   foo.bar.baz
  //   foo.qux
  // 1 foo2
  // 2 foo3
  //
  // i=0 will read the entire foo struct, i=1 the foo2 primitive column etc
  
  ///
  ///
  public native @ByVal Status ReadSchemaField(
        int i, @SharedPtr ChunkedArray out);

  /** \brief Return a RecordBatchReader of row groups selected from row_group_indices.
   * 
   *  Note that the ordering in row_group_indices matters. FileReaders must outlive
   *  their RecordBatchReaders.
   * 
   *  @return error Status if row_group_indices contains an invalid index */
  public native @ByVal Status GetRecordBatchReader(
        @StdVector IntPointer row_group_indices,
        @UniquePtr RecordBatchReader out);
  public native @ByVal Status GetRecordBatchReader(
        @StdVector IntBuffer row_group_indices,
        @UniquePtr RecordBatchReader out);
  public native @ByVal Status GetRecordBatchReader(
        @StdVector int[] row_group_indices,
        @UniquePtr RecordBatchReader out);

  /** \brief Return a RecordBatchReader of row groups selected from
   *  row_group_indices, whose columns are selected by column_indices.
   * 
   *  Note that the ordering in row_group_indices and column_indices
   *  matter. FileReaders must outlive their RecordBatchReaders.
   * 
   *  @return error Status if either row_group_indices or column_indices
   *      contains an invalid index */
  public native @ByVal Status GetRecordBatchReader(
        @StdVector IntPointer row_group_indices, @StdVector IntPointer column_indices,
        @UniquePtr RecordBatchReader out);
  public native @ByVal Status GetRecordBatchReader(
        @StdVector IntBuffer row_group_indices, @StdVector IntBuffer column_indices,
        @UniquePtr RecordBatchReader out);
  public native @ByVal Status GetRecordBatchReader(
        @StdVector int[] row_group_indices, @StdVector int[] column_indices,
        @UniquePtr RecordBatchReader out);

  /** Read all columns into a Table */
  
  ///
  public native @ByVal Status ReadTable(@SharedPtr Table out);

  /** \brief Read the given columns into a Table
   * 
   *  The indicated column indices are relative to the schema */
  public native @ByVal Status ReadTable(@StdVector IntPointer column_indices,
                                      @SharedPtr Table out);
  public native @ByVal Status ReadTable(@StdVector IntBuffer column_indices,
                                      @SharedPtr Table out);
  public native @ByVal Status ReadTable(@StdVector int[] column_indices,
                                      @SharedPtr Table out);

  public native @ByVal Status ReadRowGroup(int i, @StdVector IntPointer column_indices,
                                         @SharedPtr Table out);
  public native @ByVal Status ReadRowGroup(int i, @StdVector IntBuffer column_indices,
                                         @SharedPtr Table out);
  public native @ByVal Status ReadRowGroup(int i, @StdVector int[] column_indices,
                                         @SharedPtr Table out);

  public native @ByVal Status ReadRowGroup(int i, @SharedPtr Table out);

  public native @ByVal Status ReadRowGroups(@StdVector IntPointer row_groups,
                                          @StdVector IntPointer column_indices,
                                          @SharedPtr Table out);
  public native @ByVal Status ReadRowGroups(@StdVector IntBuffer row_groups,
                                          @StdVector IntBuffer column_indices,
                                          @SharedPtr Table out);
  public native @ByVal Status ReadRowGroups(@StdVector int[] row_groups,
                                          @StdVector int[] column_indices,
                                          @SharedPtr Table out);

  public native @ByVal Status ReadRowGroups(@StdVector IntPointer row_groups,
                                          @SharedPtr Table out);
  public native @ByVal Status ReadRowGroups(@StdVector IntBuffer row_groups,
                                          @SharedPtr Table out);
  public native @ByVal Status ReadRowGroups(@StdVector int[] row_groups,
                                          @SharedPtr Table out);

  /** \brief Scan file contents with one thread, return number of rows */
  public native @ByVal Status ScanContents(@StdVector IntPointer columns,
                                         int column_batch_size,
                                         @Cast("int64_t*") LongPointer num_rows);
  public native @ByVal Status ScanContents(@StdVector IntBuffer columns,
                                         int column_batch_size,
                                         @Cast("int64_t*") LongBuffer num_rows);
  public native @ByVal Status ScanContents(@StdVector int[] columns,
                                         int column_batch_size,
                                         @Cast("int64_t*") long[] num_rows);

  /** \brief Return a reader for the RowGroup, this object must not outlive the
   *    FileReader. */
  public native @SharedPtr RowGroupReader RowGroup(int row_group_index);

  /** \brief The number of row groups in the file */
  public native int num_row_groups();

  public native ParquetFileReader parquet_reader();

  /** Set whether to use multiple threads during reads of multiple columns.
   *  By default only one thread is used. */
  public native void set_use_threads(@Cast("bool") boolean use_threads);

  public native @Const @ByRef ArrowReaderProperties properties();

  public native @Const @ByRef SchemaManifest manifest();
}
