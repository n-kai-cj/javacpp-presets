// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.parquet;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.parquet.*;


/** \brief Experimental helper class for bindings (like Python) that struggle
 *  either with std::move or C++ exceptions */
@Namespace("parquet::arrow") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.parquet.class)
public class FileReaderBuilder extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FileReaderBuilder(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public FileReaderBuilder(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public FileReaderBuilder position(long position) {
        return (FileReaderBuilder)super.position(position);
    }
    @Override public FileReaderBuilder getPointer(long i) {
        return new FileReaderBuilder((Pointer)this).position(position + i);
    }

  public FileReaderBuilder() { super((Pointer)null); allocate(); }
  private native void allocate();

  /** Create FileReaderBuilder from Arrow file and optional properties / metadata */
  public native @ByVal Status Open(@SharedPtr @Cast({"", "std::shared_ptr<arrow::io::RandomAccessFile>"}) RandomAccessFile file,
                         @Const @ByRef(nullValue = "parquet::ReaderProperties(parquet::default_reader_properties())") ReaderProperties properties,
                         @SharedPtr FileMetaData metadata/*=nullptr*/);
  public native @ByVal Status Open(@SharedPtr @Cast({"", "std::shared_ptr<arrow::io::RandomAccessFile>"}) RandomAccessFile file);

  public native ParquetFileReader raw_reader();

  /** Set Arrow MemoryPool for memory allocation */
  public native FileReaderBuilder memory_pool(MemoryPool pool);
  /** Set Arrow reader properties */
  public native FileReaderBuilder properties(@Const @ByRef ArrowReaderProperties arg_properties);
  /** Build FileReader instance */
  public native @ByVal Status Build(@UniquePtr FileReader out);
}
