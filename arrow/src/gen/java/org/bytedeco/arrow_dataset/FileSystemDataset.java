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


/** \brief A Dataset of FileFragments.
 * 
 *  A FileSystemDataset is composed of one or more FileFragment. The fragments
 *  are independent and don't need to share the same format and/or filesystem. */
@Namespace("arrow::dataset") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow_dataset.class)
public class FileSystemDataset extends Dataset {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FileSystemDataset(Pointer p) { super(p); }

  /** \brief Create a FileSystemDataset.
   * 
   *  @param schema [in] the schema of the dataset
   *  @param root_partition [in] the partition expression of the dataset
   *  @param format [in] the format of each FileFragment.
   *  @param filesystem [in] the filesystem of each FileFragment, or nullptr if the
   *             fragments wrap buffers.
   *  @param fragments [in] list of fragments to create the dataset from.
   * 
   *  Note that fragments wrapping files resident in differing filesystems are not
   *  permitted; to work with multiple filesystems use a UnionDataset.
   * 
   *  @return A constructed dataset. */
  public static native @ByVal FileSystemDatasetResult Make(
        @SharedPtr @ByVal Schema schema, @SharedPtr @ByVal Expression root_partition,
        @SharedPtr FileFormat format, @SharedPtr FileSystem filesystem,
        @ByVal FileFragmentVector fragments);

  /** \brief Write a dataset. */
  public static native @ByVal Status Write(@Const @ByRef FileSystemDatasetWriteOptions write_options,
                        @SharedPtr @ByVal Scanner scanner);

  /** \brief Return the type name of the dataset. */
  public native @StdString String type_name();

  /** \brief Replace the schema of the dataset. */
  public native @ByVal DatasetResult ReplaceSchema(
        @SharedPtr @ByVal Schema schema);

  /** \brief Return the path of files. */
  public native @ByVal StringVector files();

  /** \brief Return the format. */
  public native @SharedPtr FileFormat format();

  /** \brief Return the filesystem. May be nullptr if the fragments wrap buffers. */
  public native @SharedPtr FileSystem filesystem();

  public native @StdString String ToString();
}
