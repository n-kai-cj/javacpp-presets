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


// Simple allocator that uses new/delete.
@Namespace("tvm::runtime") @Properties(inherit = org.bytedeco.tvm.presets.tvm_runtime.class)
public class SimpleObjAllocator extends SimpleObjAllocatorBase {
    static { Loader.load(); }
    /** Default native constructor. */
    public SimpleObjAllocator() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SimpleObjAllocator(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SimpleObjAllocator(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SimpleObjAllocator position(long position) {
        return (SimpleObjAllocator)super.position(position);
    }
    @Override public SimpleObjAllocator getPointer(long i) {
        return new SimpleObjAllocator(this).position(position + i);
    }


  // Array handler that uses new/delete.
}
