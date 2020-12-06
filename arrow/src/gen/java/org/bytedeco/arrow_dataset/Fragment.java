// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

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


/** \brief A granular piece of a Dataset, such as an individual file.
 * 
 *  A Fragment can be read/scanned separately from other fragments. It yields a
 *  collection of RecordBatches when scanned, encapsulated in one or more
 *  ScanTasks.
 * 
 *  Note that Fragments have well defined physical schemas which are reconciled by
 *  the Datasets which contain them; these physical schemas may differ from a parent
 *  Dataset's schema and the physical schemas of sibling Fragments. */
@Namespace("arrow::dataset") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow_dataset.class)
public class Fragment extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Fragment(Pointer p) { super(p); }

  /** \brief Return the physical schema of the Fragment.
   * 
   *  The physical schema is also called the writer schema.
   *  This method is blocking and may suffer from high latency filesystem.
   *  The schema is cached after being read once, or may be specified at construction. */
  
  ///
  ///
  public native @ByVal SchemaResult ReadPhysicalSchema();

  /** \brief Scan returns an iterator of ScanTasks, each of which yields
   *  RecordBatches from this Fragment.
   * 
   *  Note that batches yielded using this method will not be filtered and may not align
   *  with the Fragment's schema. In particular, note that columns referenced by the
   *  filter may be present in yielded batches even if they are not projected (so that
   *  they are available when a filter is applied). Additionally, explicitly projected
   *  columns may be absent if they were not present in this fragment.
   * 
   *  To receive a record batch stream which is fully filtered and projected, use Scanner. */
  public native @ByVal ScanTaskIteratorResult Scan(@SharedPtr ScanOptions options,
                                          @SharedPtr ScanContext context);

  /** \brief Return true if the fragment can benefit from parallel scanning. */
  public native @Cast("bool") boolean splittable();

  public native @StdString String type_name();

  /** \brief An expression which evaluates to true for all data viewed by this
   *  Fragment. */
  public native @Const @SharedPtr @ByRef Expression partition_expression();
}
