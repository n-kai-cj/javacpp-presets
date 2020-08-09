// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.parquet;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.parquet.*;


@Namespace("parquet") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.parquet.class)
public class ReaderProperties extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ReaderProperties(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public ReaderProperties(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public ReaderProperties position(long position) {
        return (ReaderProperties)super.position(position);
    }
    @Override public ReaderProperties getPointer(long i) {
        return new ReaderProperties(this).position(position + i);
    }

  public ReaderProperties(MemoryPool pool/*=arrow::default_memory_pool()*/) { super((Pointer)null); allocate(pool); }
  private native void allocate(MemoryPool pool/*=arrow::default_memory_pool()*/);
  public ReaderProperties() { super((Pointer)null); allocate(); }
  private native void allocate();

  public native MemoryPool memory_pool();

  
  ///
  public native @Cast("parquet::ArrowInputStream*") @SharedPtr InputStream GetStream(@Cast("parquet::ArrowInputFile*") @SharedPtr RandomAccessFile source,
                                                @Cast("int64_t") long start, @Cast("int64_t") long num_bytes);

  /** Buffered stream reading allows the user to control the memory usage of
   *  parquet readers. This ensure that all {@code RandomAccessFile::ReadAt} calls are
   *  wrapped in a buffered reader that uses a fix sized buffer (of size
   *  {@code buffer_size()}) instead of the full size of the ReadAt.
   * 
   *  The primary reason for this control knobs is for resource control and not
   *  performance. */
  public native @Cast("bool") boolean is_buffered_stream_enabled();
  public native void enable_buffered_stream();
  public native void disable_buffered_stream();

  public native @Cast("int64_t") long buffer_size();
  public native void set_buffer_size(@Cast("int64_t") long size);

  public native void file_decryption_properties(@SharedPtr FileDecryptionProperties decryption);

  public native @SharedPtr FileDecryptionProperties file_decryption_properties();
}
