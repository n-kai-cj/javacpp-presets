// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.dnnl;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.dnnl.global.dnnl.*;


/** \} dnnl_api_pooling
 <p>
 *  \addtogroup dnnl_api_pooling_v2
 *  \{
 <p>
 *  A descriptor of a pooling operation. */
@Properties(inherit = org.bytedeco.dnnl.presets.dnnl.class)
public class dnnl_pooling_v2_desc_t extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public dnnl_pooling_v2_desc_t() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public dnnl_pooling_v2_desc_t(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public dnnl_pooling_v2_desc_t(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public dnnl_pooling_v2_desc_t position(long position) {
        return (dnnl_pooling_v2_desc_t)super.position(position);
    }
    @Override public dnnl_pooling_v2_desc_t getPointer(long i) {
        return new dnnl_pooling_v2_desc_t(this).position(position + i);
    }

    /** The kind of primitive. Used for self-identifying the primitive
     *  descriptor. Must be #dnnl_pooling_v2. */
    public native @Cast("dnnl_primitive_kind_t") int primitive_kind(); public native dnnl_pooling_v2_desc_t primitive_kind(int setter);
    /** The kind of propagation. Possible values: #dnnl_forward_training,
     *  #dnnl_forward_inference, #dnnl_backward, and #dnnl_backward_data. */
    public native @Cast("dnnl_prop_kind_t") int prop_kind(); public native dnnl_pooling_v2_desc_t prop_kind(int setter);
    /** The kind of pooling algorithm.
     *  Possible values: #dnnl_pooling_max,
     *  #dnnl_pooling_avg_include_padding, and
     *  #dnnl_pooling_avg_exclude_padding. */
    public native @Cast("dnnl_alg_kind_t") int alg_kind(); public native dnnl_pooling_v2_desc_t alg_kind(int setter);
    /** Source memory descriptor. */
    public native @ByRef dnnl_memory_desc_t src_desc(); public native dnnl_pooling_v2_desc_t src_desc(dnnl_memory_desc_t setter);
    /** Source gradient memory descriptor. */
    public native @ByRef dnnl_memory_desc_t diff_src_desc(); public native dnnl_pooling_v2_desc_t diff_src_desc(dnnl_memory_desc_t setter);
    /** Destination memory descriptor. */
    public native @ByRef dnnl_memory_desc_t dst_desc(); public native dnnl_pooling_v2_desc_t dst_desc(dnnl_memory_desc_t setter);
    /** Destination gradient memory descriptor. */
    public native @ByRef dnnl_memory_desc_t diff_dst_desc(); public native dnnl_pooling_v2_desc_t diff_dst_desc(dnnl_memory_desc_t setter);
    /** Pooling kernel strides for spatial dimensions. */
    @MemberGetter public native @Cast("int64_t*") LongPointer strides();
    /** Pooling kernel spatial dimensions. */
    @MemberGetter public native @Cast("int64_t*") LongPointer kernel();
    /** Padding in each spatial dimension. padding[0] is a padding in the
     *  beginning (\p padding_l), padding[1] is a padding in the end (\p
     *  padding_r). */
    @MemberGetter public native @Cast("int64_t*") LongPointer padding(int i);
    @MemberGetter public native @Cast("int64_t**") PointerPointer padding();
    /** The accumulator data type. Initialized automatically. */
    public native @Cast("dnnl_data_type_t") int accum_data_type(); public native dnnl_pooling_v2_desc_t accum_data_type(int setter);
    /** Pooling dilations for spatial dimensions. */
    @MemberGetter public native @Cast("int64_t*") LongPointer dilation();
}
