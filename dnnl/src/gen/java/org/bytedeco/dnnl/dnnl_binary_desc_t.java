// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.dnnl;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.opencl.*;
import static org.bytedeco.opencl.global.OpenCL.*;

import static org.bytedeco.dnnl.global.dnnl.*;


/** \} dnnl_api_rnn
 <p>
 *  \addtogroup dnnl_api_binary
 *  \{
 <p>
 *  A descriptor of a binary operation. */
@Properties(inherit = org.bytedeco.dnnl.presets.dnnl.class)
public class dnnl_binary_desc_t extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public dnnl_binary_desc_t() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public dnnl_binary_desc_t(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public dnnl_binary_desc_t(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public dnnl_binary_desc_t position(long position) {
        return (dnnl_binary_desc_t)super.position(position);
    }
    @Override public dnnl_binary_desc_t getPointer(long i) {
        return new dnnl_binary_desc_t((Pointer)this).position(position + i);
    }

    /** The kind of primitive. Used for self-identifying the primitive
     *  descriptor. Must be #dnnl_binary. */
    public native @Cast("dnnl_primitive_kind_t") int primitive_kind(); public native dnnl_binary_desc_t primitive_kind(int setter);
    /** The kind of the binary algorithm. Possible values:
     *  #dnnl_binary_add, #dnnl_binary_mul, #dnnl_binary_max, #dnnl_binary_min,
     *  #dnnl_binary_div and #dnnl_binary_sub. */
    public native @Cast("dnnl_alg_kind_t") int alg_kind(); public native dnnl_binary_desc_t alg_kind(int setter);
    /** Source memory descriptors. */
    public native @ByRef dnnl_memory_desc_t src_desc(int i); public native dnnl_binary_desc_t src_desc(int i, dnnl_memory_desc_t setter);
    @MemberGetter public native dnnl_memory_desc_t src_desc();
    /** Destination memory descriptor. */
    public native @ByRef dnnl_memory_desc_t dst_desc(); public native dnnl_binary_desc_t dst_desc(dnnl_memory_desc_t setter);
}
