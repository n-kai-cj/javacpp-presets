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


// #endif

@Name("dmlc::type_name_helper<float>") @Properties(inherit = org.bytedeco.tvm.presets.tvm_runtime.class)
public class type_name_helper extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public type_name_helper() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public type_name_helper(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public type_name_helper(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public type_name_helper position(long position) {
        return (type_name_helper)super.position(position);
    }
    @Override public type_name_helper getPointer(long i) {
        return new type_name_helper(this).position(position + i);
    }

    public static native @StdString BytePointer value();
  }
