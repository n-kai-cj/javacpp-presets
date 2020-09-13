// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.cudart;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cuda.global.cudart.*;


/**
 * 3D memory copy parameters
 */
@Properties(inherit = org.bytedeco.cuda.presets.cudart.class)
public class CUDA_MEMCPY3D extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public CUDA_MEMCPY3D() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public CUDA_MEMCPY3D(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CUDA_MEMCPY3D(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public CUDA_MEMCPY3D position(long position) {
        return (CUDA_MEMCPY3D)super.position(position);
    }
    @Override public CUDA_MEMCPY3D getPointer(long i) {
        return new CUDA_MEMCPY3D(this).position(position + i);
    }

    /** Source X in bytes */
    public native @Cast("size_t") long srcXInBytes(); public native CUDA_MEMCPY3D srcXInBytes(long setter);
    /** Source Y */
    public native @Cast("size_t") long srcY(); public native CUDA_MEMCPY3D srcY(long setter);
    /** Source Z */
    public native @Cast("size_t") long srcZ(); public native CUDA_MEMCPY3D srcZ(long setter);
    /** Source LOD */
    public native @Cast("size_t") long srcLOD(); public native CUDA_MEMCPY3D srcLOD(long setter);
    /** Source memory type (host, device, array) */
    public native @Cast("CUmemorytype") int srcMemoryType(); public native CUDA_MEMCPY3D srcMemoryType(int setter);
    /** Source host pointer */
    public native @Const Pointer srcHost(); public native CUDA_MEMCPY3D srcHost(Pointer setter);
    /** Source device pointer */
    public native @Cast("CUdeviceptr") long srcDevice(); public native CUDA_MEMCPY3D srcDevice(long setter);
    /** Source array reference */
    public native CUarray_st srcArray(); public native CUDA_MEMCPY3D srcArray(CUarray_st setter);
    /** Must be NULL */
    public native Pointer reserved0(); public native CUDA_MEMCPY3D reserved0(Pointer setter);
    /** Source pitch (ignored when src is array) */
    public native @Cast("size_t") long srcPitch(); public native CUDA_MEMCPY3D srcPitch(long setter);
    /** Source height (ignored when src is array; may be 0 if Depth==1) */
    public native @Cast("size_t") long srcHeight(); public native CUDA_MEMCPY3D srcHeight(long setter);

    /** Destination X in bytes */
    public native @Cast("size_t") long dstXInBytes(); public native CUDA_MEMCPY3D dstXInBytes(long setter);
    /** Destination Y */
    public native @Cast("size_t") long dstY(); public native CUDA_MEMCPY3D dstY(long setter);
    /** Destination Z */
    public native @Cast("size_t") long dstZ(); public native CUDA_MEMCPY3D dstZ(long setter);
    /** Destination LOD */
    public native @Cast("size_t") long dstLOD(); public native CUDA_MEMCPY3D dstLOD(long setter);
    /** Destination memory type (host, device, array) */
    public native @Cast("CUmemorytype") int dstMemoryType(); public native CUDA_MEMCPY3D dstMemoryType(int setter);
    /** Destination host pointer */
    public native Pointer dstHost(); public native CUDA_MEMCPY3D dstHost(Pointer setter);
    /** Destination device pointer */
    public native @Cast("CUdeviceptr") long dstDevice(); public native CUDA_MEMCPY3D dstDevice(long setter);
    /** Destination array reference */
    public native CUarray_st dstArray(); public native CUDA_MEMCPY3D dstArray(CUarray_st setter);
    /** Must be NULL */
    public native Pointer reserved1(); public native CUDA_MEMCPY3D reserved1(Pointer setter);
    /** Destination pitch (ignored when dst is array) */
    public native @Cast("size_t") long dstPitch(); public native CUDA_MEMCPY3D dstPitch(long setter);
    /** Destination height (ignored when dst is array; may be 0 if Depth==1) */
    public native @Cast("size_t") long dstHeight(); public native CUDA_MEMCPY3D dstHeight(long setter);

    /** Width of 3D memory copy in bytes */
    public native @Cast("size_t") long WidthInBytes(); public native CUDA_MEMCPY3D WidthInBytes(long setter);
    /** Height of 3D memory copy */
    public native @Cast("size_t") long Height(); public native CUDA_MEMCPY3D Height(long setter);
    /** Depth of 3D memory copy */
    public native @Cast("size_t") long Depth(); public native CUDA_MEMCPY3D Depth(long setter);
}
