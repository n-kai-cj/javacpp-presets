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


/** \brief A container of zero or more Fragments.
 * 
 *  A Dataset acts as a union of Fragments, e.g. files deeply nested in a
 *  directory. A Dataset has a schema to which Fragments must align during a
 *  scan operation. This is analogous to Avro's reader and writer schema. */
@Namespace("arrow::dataset") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow_dataset.class)
public class Dataset extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Dataset(Pointer p) { super(p); }

  /** \brief Begin to build a new Scan operation against this Dataset */
  public native @ByVal ScannerBuilderResult NewScan(@SharedPtr ScanContext context);
  public native @ByVal ScannerBuilderResult NewScan();

  /** \brief GetFragments returns an iterator of Fragments given a predicate. */
  public native @ByVal FragmentIteratorResult GetFragments(@ByVal Expression predicate);
  public native @ByVal FragmentIteratorResult GetFragments();

  public native @Const @SharedPtr @ByRef Schema schema();

  /** \brief An expression which evaluates to true for all data viewed by this Dataset.
   *  May be null, which indicates no information is available. */
  public native @Const @ByRef Expression partition_expression();

  /** \brief The name identifying the kind of Dataset */
  
  ///
  public native @StdString String type_name();

  /** \brief Return a copy of this Dataset with a different schema.
   * 
   *  The copy will view the same Fragments. If the new schema is not compatible with the
   *  original dataset's schema then an error will be raised. */
  public native @ByVal DatasetResult ReplaceSchema(
        @SharedPtr @ByVal Schema schema);
}
