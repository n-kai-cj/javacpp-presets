// Targeted by JavaCPP version 1.5.6-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.cudart;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cuda.global.cudart.*;


/**
 * Memset node parameters
 */
@Properties(inherit = org.bytedeco.cuda.presets.cudart.class)
public class CUDA_MEMSET_NODE_PARAMS extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public CUDA_MEMSET_NODE_PARAMS() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public CUDA_MEMSET_NODE_PARAMS(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CUDA_MEMSET_NODE_PARAMS(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public CUDA_MEMSET_NODE_PARAMS position(long position) {
        return (CUDA_MEMSET_NODE_PARAMS)super.position(position);
    }
    @Override public CUDA_MEMSET_NODE_PARAMS getPointer(long i) {
        return new CUDA_MEMSET_NODE_PARAMS((Pointer)this).position(position + i);
    }

    /** Destination device pointer */
    public native @Cast("CUdeviceptr") long dst(); public native CUDA_MEMSET_NODE_PARAMS dst(long setter);
    /** Pitch of destination device pointer. Unused if height is 1 */
    public native @Cast("size_t") long pitch(); public native CUDA_MEMSET_NODE_PARAMS pitch(long setter);
    /** Value to be set */
    public native @Cast("unsigned int") int value(); public native CUDA_MEMSET_NODE_PARAMS value(int setter);
    /** Size of each element in bytes. Must be 1, 2, or 4. */
    public native @Cast("unsigned int") int elementSize(); public native CUDA_MEMSET_NODE_PARAMS elementSize(int setter);
    /** Width of the row in elements */
    public native @Cast("size_t") long width(); public native CUDA_MEMSET_NODE_PARAMS width(long setter);
    /** Number of rows */
    public native @Cast("size_t") long height(); public native CUDA_MEMSET_NODE_PARAMS height(long setter);
}
