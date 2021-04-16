// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.numpy;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.cpython.*;
import static org.bytedeco.cpython.global.python.*;

import static org.bytedeco.numpy.global.numpy.*;


/************************************************************
 * A struct used by PyArray_CreateSortedStridePerm, new in 1.7.
 ************************************************************/

@Properties(inherit = org.bytedeco.numpy.presets.numpy.class)
public class npy_stride_sort_item extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public npy_stride_sort_item() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public npy_stride_sort_item(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public npy_stride_sort_item(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public npy_stride_sort_item position(long position) {
        return (npy_stride_sort_item)super.position(position);
    }
    @Override public npy_stride_sort_item getPointer(long i) {
        return new npy_stride_sort_item((Pointer)this).position(position + i);
    }

    public native @Cast("npy_intp") long perm(); public native npy_stride_sort_item perm(long setter);
    public native @Cast("npy_intp") long stride(); public native npy_stride_sort_item stride(long setter);
}
