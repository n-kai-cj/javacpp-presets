// Targeted by JavaCPP version 1.5.6-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.cudart;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cuda.global.cudart.*;


/**
 * External memory buffer descriptor
 */
@Properties(inherit = org.bytedeco.cuda.presets.cudart.class)
public class CUDA_EXTERNAL_MEMORY_BUFFER_DESC extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public CUDA_EXTERNAL_MEMORY_BUFFER_DESC() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public CUDA_EXTERNAL_MEMORY_BUFFER_DESC(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CUDA_EXTERNAL_MEMORY_BUFFER_DESC(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public CUDA_EXTERNAL_MEMORY_BUFFER_DESC position(long position) {
        return (CUDA_EXTERNAL_MEMORY_BUFFER_DESC)super.position(position);
    }
    @Override public CUDA_EXTERNAL_MEMORY_BUFFER_DESC getPointer(long i) {
        return new CUDA_EXTERNAL_MEMORY_BUFFER_DESC((Pointer)this).position(position + i);
    }

    /**
     * Offset into the memory object where the buffer's base is
     */
    public native @Cast("unsigned long long") long offset(); public native CUDA_EXTERNAL_MEMORY_BUFFER_DESC offset(long setter);
    /**
     * Size of the buffer
     */
    public native @Cast("unsigned long long") long size(); public native CUDA_EXTERNAL_MEMORY_BUFFER_DESC size(long setter);
    /**
     * Flags reserved for future use. Must be zero.
     */
    public native @Cast("unsigned int") int flags(); public native CUDA_EXTERNAL_MEMORY_BUFFER_DESC flags(int setter);
    public native @Cast("unsigned int") int reserved(int i); public native CUDA_EXTERNAL_MEMORY_BUFFER_DESC reserved(int i, int setter);
    @MemberGetter public native @Cast("unsigned int*") IntPointer reserved();
}
