// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.arrow_dataset;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;
import org.bytedeco.parquet.*;
import static org.bytedeco.arrow.global.parquet.*;

import static org.bytedeco.arrow.global.arrow_dataset.*;


// ----------------------------------------------------------------------
// Partitioning

/** \brief Interface for parsing partition expressions from string partition
 *  identifiers.
 * 
 *  For example, the identifier "foo=5" might be parsed to an equality expression
 *  between the "foo" field and the value 5.
 * 
 *  Some partitionings may store the field names in a metadata
 *  store instead of in file paths, for example
 *  dataset_root/2009/11/... could be used when the partition fields
 *  are "year" and "month"
 * 
 *  Paths are consumed from left to right. Paths must be relative to
 *  the root of a partition; path prefixes must be removed before passing
 *  the path to a partitioning for parsing. */
@Namespace("arrow::dataset") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow_dataset.class)
public class Partitioning extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Partitioning(Pointer p) { super(p); }


  /** \brief The name identifying the kind of partitioning */
  public native @StdString String type_name();

  /** \brief If the input batch shares any fields with this partitioning,
   *  produce sub-batches which satisfy mutually exclusive Expressions. */
  public static class PartitionedBatches extends Pointer {
      static { Loader.load(); }
      /** Default native constructor. */
      public PartitionedBatches() { super((Pointer)null); allocate(); }
      /** Native array allocator. Access with {@link Pointer#position(long)}. */
      public PartitionedBatches(long size) { super((Pointer)null); allocateArray(size); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public PartitionedBatches(Pointer p) { super(p); }
      private native void allocate();
      private native void allocateArray(long size);
      @Override public PartitionedBatches position(long position) {
          return (PartitionedBatches)super.position(position);
      }
      @Override public PartitionedBatches getPointer(long i) {
          return new PartitionedBatches((Pointer)this).position(position + i);
      }
  
    public native @ByRef RecordBatchVector batches(); public native PartitionedBatches batches(RecordBatchVector setter);
    public native @StdVector Expression expressions(); public native PartitionedBatches expressions(Expression setter);
  }
  public native @ByVal PartitionedBatchesResult Partition(
        @SharedPtr @Cast({"", "std::shared_ptr<arrow::RecordBatch>"}) RecordBatch batch);

  /** \brief Parse a path into a partition expression */
  public native @ByVal ExpressionResult Parse(@StdString String path);
  public native @ByVal ExpressionResult Parse(@StdString BytePointer path);

  public native @ByVal StringResult Format(@Const @ByRef Expression expr);

  /** \brief A default Partitioning which always yields scalar(true) */
  public static native @SharedPtr Partitioning Default();

  public native @Const @SharedPtr @ByRef Schema schema();
}
