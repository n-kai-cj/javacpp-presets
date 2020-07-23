// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorrt.nvinfer;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.cuda.cudart.*;
import static org.bytedeco.cuda.global.cudart.*;
import org.bytedeco.cuda.cublas.*;
import static org.bytedeco.cuda.global.cublas.*;
import org.bytedeco.cuda.cudnn.*;
import static org.bytedeco.cuda.global.cudnn.*;
import org.bytedeco.cuda.nvrtc.*;
import static org.bytedeco.cuda.global.nvrtc.*;

import static org.bytedeco.tensorrt.global.nvinfer.*;


/**
 *  \class IGpuAllocator
 * 
 *  \brief Application-implemented class for controlling allocation on the GPU.
 *  */
@Namespace("nvinfer1") @Properties(inherit = org.bytedeco.tensorrt.presets.nvinfer.class)
public class IGpuAllocator extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IGpuAllocator(Pointer p) { super(p); }

    /**
     *  A callback implemented by the application to handle acquisition of GPU memory.
     * 
     *  @param size The size of the memory required.
     *  @param alignment The required alignment of memory. Alignment will zero
     *         or a power of 2 not exceeding the alignment guaranteed by cudaMalloc.
     *         Thus this allocator can be safely implemented with cudaMalloc/cudaFree.
     *         An alignment value of zero indicates any alignment is acceptable.
     *  @param flags Reserved for future use. In the current release, 0 will be passed.
     * 
     *  If an allocation request of size 0 is made, nullptr should be returned.
     * 
     *  If an allocation request cannot be satisfied, nullptr should be returned.
     *  */
    
    
    //!
    //!
    //!
    //!
    public native @Name("allocate") Pointer _allocate(@Cast("uint64_t") long size, @Cast("uint64_t") long alignment, @Cast("uint32_t") int flags);

    /**
     *  A callback implemented by the application to handle release of GPU memory.
     * 
     *  TensorRT may pass a nullptr to this function if it was previously returned by allocate().
     * 
     *  @param memory The acquired memory.
     *  */
    
    
    //!
    //!
    public native @Name("free") void _free(Pointer memory);

    /**
     *  Destructor declared virtual as general good practice for a class with virtual methods.
     *  TensorRT never calls the destructor for an IGpuAllocator defined by the application.
     *  */
}
