// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

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


/** \brief Create FileSystemDataset from custom {@code _metadata} cache file.
 * 
 *  Dask and other systems will generate a cache metadata file by concatenating
 *  the RowGroupMetaData of multiple parquet files into a single parquet file
 *  that only contains metadata and no ColumnChunk data.
 * 
 *  ParquetDatasetFactory creates a FileSystemDataset composed of
 *  ParquetFileFragment where each fragment is pre-populated with the exact
 *  number of row groups and statistics for each columns. */
@Namespace("arrow::dataset") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow_dataset.class)
public class ParquetDatasetFactory extends DatasetFactory {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ParquetDatasetFactory(Pointer p) { super(p); }

  /** \brief Create a ParquetDatasetFactory from a metadata path.
   * 
   *  The {@code metadata_path} will be read from {@code filesystem}. Each RowGroup
   *  contained in the metadata file will be relative to {@code dirname(metadata_path)}.
   * 
   *  @param metadata_path [in] path of the metadata parquet file
   *  @param filesystem [in] from which to open/read the path
   *  @param format [in] to read the file with.
   *  @param options [in] see ParquetFactoryOptions */
  
  ///
  ///
  public static native @ByVal DatasetFactoryResult Make(
        @StdString String metadata_path, @SharedPtr FileSystem filesystem,
        @SharedPtr ParquetFileFormat format, @ByVal ParquetFactoryOptions options);
  public static native @ByVal DatasetFactoryResult Make(
        @StdString BytePointer metadata_path, @SharedPtr FileSystem filesystem,
        @SharedPtr ParquetFileFormat format, @ByVal ParquetFactoryOptions options);

  /** \brief Create a ParquetDatasetFactory from a metadata source.
   * 
   *  Similar to the previous Make definition, but the metadata can be a Buffer
   *  and the base_path is explicited instead of inferred from the metadata
   *  path.
   * 
   *  @param metadata [in] source to open the metadata parquet file from
   *  @param base_path [in] used as the prefix of every parquet files referenced
   *  @param filesystem [in] from which to read the files referenced.
   *  @param format [in] to read the file with.
   *  @param options [in] see ParquetFactoryOptions */
  public static native @ByVal DatasetFactoryResult Make(
        @Const @ByRef FileSource metadata, @StdString String base_path,
        @SharedPtr FileSystem filesystem,
        @SharedPtr ParquetFileFormat format, @ByVal ParquetFactoryOptions options);
  public static native @ByVal DatasetFactoryResult Make(
        @Const @ByRef FileSource metadata, @StdString BytePointer base_path,
        @SharedPtr FileSystem filesystem,
        @SharedPtr ParquetFileFormat format, @ByVal ParquetFactoryOptions options);

  public native @ByVal SchemaVectorResult InspectSchemas(
        @ByVal InspectOptions options);

  public native @ByVal DatasetResult Finish(@ByVal FinishOptions options);
}
