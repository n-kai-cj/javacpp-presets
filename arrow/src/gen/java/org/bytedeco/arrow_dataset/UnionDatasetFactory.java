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


/** \brief DatasetFactory provides a way to inspect/discover a Dataset's
 *  expected schema before materialization. */
@Namespace("arrow::dataset") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow_dataset.class)
public class UnionDatasetFactory extends DatasetFactory {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public UnionDatasetFactory(Pointer p) { super(p); }

  public static native @ByVal DatasetFactoryResult Make(
        @SharedPtr @StdVector DatasetFactory factories);

  /** \brief Return the list of child DatasetFactory */
  
  ///
  public native @SharedPtr @StdVector DatasetFactory factories();

  /** \brief Get the schemas of the Datasets.
   * 
   *  Instead of applying options globally, it applies at each child factory.
   *  This will not respect {@code options.fragments} exactly, but will respect the
   *  spirit of peeking the first fragments or all of them. */
  public native @ByVal SchemaVectorResult InspectSchemas(
        @ByVal InspectOptions options);

  /** \brief Create a Dataset. */
  public native @ByVal DatasetResult Finish(@ByVal FinishOptions options);
}
