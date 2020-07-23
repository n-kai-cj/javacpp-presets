// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief A RandomAccessFile wrapper that makes reads slower.
 * 
 *  Similar to SlowInputStream, but allows random access and seeking. */
@Namespace("arrow::io") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class SlowRandomAccessFile extends RandomAccessFileSlowInputStreamBase {
    static { Loader.load(); }


  
    public SlowRandomAccessFile(@SharedPtr @Cast({"", "std::shared_ptr<arrow::io::RandomAccessFile>"}) RandomAccessFile stream,
                          @SharedPtr LatencyGenerator latencies) { super((Pointer)null); allocate(stream, latencies); }
    private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::io::RandomAccessFile>"}) RandomAccessFile stream,
                          @SharedPtr LatencyGenerator latencies);
  
    public SlowRandomAccessFile(@SharedPtr @Cast({"", "std::shared_ptr<arrow::io::RandomAccessFile>"}) RandomAccessFile stream, double average_latency) { super((Pointer)null); allocate(stream, average_latency); }
    private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::io::RandomAccessFile>"}) RandomAccessFile stream, double average_latency);
  
    public SlowRandomAccessFile(@SharedPtr @Cast({"", "std::shared_ptr<arrow::io::RandomAccessFile>"}) RandomAccessFile stream, double average_latency,
                          int seed) { super((Pointer)null); allocate(stream, average_latency, seed); }
    private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::io::RandomAccessFile>"}) RandomAccessFile stream, double average_latency,
                          int seed);
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SlowRandomAccessFile(Pointer p) { super(p); }


  public native @ByVal Status Close();
  public native @ByVal Status Abort();
  public native @Cast("bool") boolean closed();

  public native @ByVal LongResult Read(@Cast("int64_t") long nbytes, Pointer out);
  public native @ByVal BufferResult Read(@Cast("int64_t") long nbytes);
  public native @ByVal LongResult ReadAt(@Cast("int64_t") long _position, @Cast("int64_t") long nbytes, Pointer out);
  public native @ByVal BufferResult ReadAt(@Cast("int64_t") long _position, @Cast("int64_t") long nbytes);
  public native @ByVal StringViewResult Peek(@Cast("int64_t") long nbytes);

  public native @ByVal LongResult GetSize();
  public native @ByVal Status Seek(@Cast("int64_t") long _position);
  public native @ByVal LongResult Tell();
}
