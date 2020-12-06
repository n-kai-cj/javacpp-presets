// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief Abstract interface for reading stream of record batches */
@Namespace("arrow") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class RecordBatchReader extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public RecordBatchReader(Pointer p) { super(p); }


  /** @return the shared schema of the record batches in the stream */
  
  ///
  public native @SharedPtr @ByVal Schema schema();

  /** \brief Read the next record batch in the stream. Return null for batch
   *  when reaching end of stream
   * 
   *  @param batch [out] the next loaded batch, null at end of stream
   *  @return Status */
  public native @ByVal Status ReadNext(@SharedPtr RecordBatch batch);

  /** \brief Iterator interface */
  public native @ByVal RecordBatchResult Next();

  /** \brief Consume entire stream as a vector of record batches */
  public native @ByVal Status ReadAll(RecordBatchVector batches);

  /** \brief Read all batches and concatenate as arrow::Table */
  
  ///
  public native @ByVal Status ReadAll(@SharedPtr Table table);

  /** \brief Create a RecordBatchReader from a vector of RecordBatch.
   * 
   *  @param batches [in] the vector of RecordBatch to read from
   *  @param schema [in] schema to conform to. Will be inferred from the first
   *             element if not provided. */
  public static native @ByVal RecordBatchReaderSharedResult Make(
        @ByVal RecordBatchVector batches, @SharedPtr @ByVal(nullValue = "std::shared_ptr<arrow::Schema>(nullptr)") Schema schema);
  public static native @ByVal RecordBatchReaderSharedResult Make(
        @ByVal RecordBatchVector batches);
}
