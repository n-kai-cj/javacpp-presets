// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tvm;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.dnnl.*;
import static org.bytedeco.dnnl.global.dnnl.*;
import org.bytedeco.llvm.LLVM.*;
import static org.bytedeco.llvm.global.LLVM.*;

import static org.bytedeco.tvm.global.tvm_runtime.*;


// #ifndef _LIBCPP_SGX_NO_IOSTREAMS
/**
 * \brief a std::ostream class that can can wrap Stream objects,
 *  can use ostream with that output to underlying Stream
 *
 * Usage example:
 * <pre>{@code
 *
 *   Stream *fs = Stream::Create("hdfs:///test.txt", "w");
 *   dmlc::ostream os(fs);
 *   os << "hello world" << std::endl;
 *   delete fs;
 * }</pre>
 */
@Namespace("dmlc") @NoOffset @Properties(inherit = org.bytedeco.tvm.presets.tvm_runtime.class)
public class ostream extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ostream(Pointer p) { super(p); }

  /**
   * \brief construct std::ostream type
   * @param stream the Stream output to be used
   * @param buffer_size internal streambuf size
   */
  public ostream(Stream stream,
                     @Cast("size_t") long buffer_size/*=(1 << 10)*/) { super((Pointer)null); allocate(stream, buffer_size); }
  private native void allocate(Stream stream,
                     @Cast("size_t") long buffer_size/*=(1 << 10)*/);
  public ostream(Stream stream) { super((Pointer)null); allocate(stream); }
  private native void allocate(Stream stream);
  // explictly synchronize the buffer
  /**
   * \brief set internal stream to be stream, reset states
   * @param stream new stream as output
   */
  public native void set_stream(Stream stream);

  /** @return how many bytes we written so far */
  public native @Cast("size_t") long bytes_written();
}
