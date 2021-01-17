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
import static org.bytedeco.mkl.global.mkl_rt.*;

import static org.bytedeco.tvm.global.tvm_runtime.*;


/** \brief use to store file information */
@Namespace("dmlc::io") @NoOffset @Properties(inherit = org.bytedeco.tvm.presets.tvm_runtime.class)
public class FileInfo extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FileInfo(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public FileInfo(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public FileInfo position(long position) {
        return (FileInfo)super.position(position);
    }
    @Override public FileInfo getPointer(long i) {
        return new FileInfo(this).position(position + i);
    }

  /** \brief full path to the file */
  public native @ByRef URI path(); public native FileInfo path(URI setter);
  /** \brief the size of the file */
  public native @Cast("size_t") long size(); public native FileInfo size(long setter);
  /** \brief the type of the file */
  public native FileType type(); public native FileInfo type(FileType setter);
  /** \brief default constructor */
  public FileInfo() { super((Pointer)null); allocate(); }
  private native void allocate();
}
