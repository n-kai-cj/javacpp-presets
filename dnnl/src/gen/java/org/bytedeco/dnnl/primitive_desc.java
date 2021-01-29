// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.dnnl;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.opencl.*;
import static org.bytedeco.opencl.global.OpenCL.*;

import static org.bytedeco.dnnl.global.dnnl.*;


/** \} dnnl_api_sum
 <p>
 *  \addtogroup dnnl_api_primitives_common
 *  \{
 <p>
 *  A base class for descriptors of all primitives that have an operation
 *  descriptor and that support iteration over multiple implementations. */
@Name("dnnl::primitive_desc") @NoOffset @Properties(inherit = org.bytedeco.dnnl.presets.dnnl.class)
public class primitive_desc extends primitive_desc_base {
    static { Loader.load(); }

    
        
            public primitive_desc() { super((Pointer)null); allocate(); }
            private native void allocate();
            public primitive_desc(@Const @ByRef primitive_desc arg0) { super((Pointer)null); allocate(arg0); }
            private native void allocate(@Const @ByRef primitive_desc arg0);
            
            ///
            public primitive_desc(dnnl_primitive_desc t, @Cast("bool") boolean weak/*=false*/) { super((Pointer)null); allocate(t, weak); }
            private native void allocate(dnnl_primitive_desc t, @Cast("bool") boolean weak/*=false*/);
            public primitive_desc(dnnl_primitive_desc t) { super((Pointer)null); allocate(t); }
            private native void allocate(dnnl_primitive_desc t);
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public primitive_desc(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public primitive_desc(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public primitive_desc position(long position) {
        return (primitive_desc)super.position(position);
    }
    @Override public primitive_desc getPointer(long i) {
        return new primitive_desc((Pointer)this).position(position + i);
    }


    /** Constructs a primitive descriptor.
     * 
     *  \note
     *      If \p allow_empty is true, the constructor does not throw if a
     *      primitive descriptor cannot be created. But calling next_impl() in
     *      this case will throw.
     * 
     *  \note
     *      This is a low-level implementation detail that is typically not
     *      needed in application code.
     * 
     *  @param desc Constant C API operation descriptor.
     *  @param attr Pointer to primitive attributes. It is safe to pass
     *      nullptr to indicate absence of attributes.
     *  @param aengine Engine to use.
     *  @param hint_fwd_pd C API primitive descriptor for a forward
     *      propagation primitive. It is used as a hint for deciding which
     *      memory format to use for backward propagation or weights gradient.
     *  @param allow_empty A flag signifying whether construction is allowed
     *      to fail without throwing an exception. In this case an empty
     *      object will be produced. This flag is optional and defaults to
     *      false. */
    
    ///
    public primitive_desc(const_dnnl_op_desc_t desc, @Const primitive_attr attr,
                @Const @ByRef engine aengine, @Const dnnl_primitive_desc hint_fwd_pd,
                @Cast("bool") boolean allow_empty/*=false*/) { super((Pointer)null); allocate(desc, attr, aengine, hint_fwd_pd, allow_empty); }
    private native void allocate(const_dnnl_op_desc_t desc, @Const primitive_attr attr,
                @Const @ByRef engine aengine, @Const dnnl_primitive_desc hint_fwd_pd,
                @Cast("bool") boolean allow_empty/*=false*/);
    public primitive_desc(const_dnnl_op_desc_t desc, @Const primitive_attr attr,
                @Const @ByRef engine aengine, @Const dnnl_primitive_desc hint_fwd_pd) { super((Pointer)null); allocate(desc, attr, aengine, hint_fwd_pd); }
    private native void allocate(const_dnnl_op_desc_t desc, @Const primitive_attr attr,
                @Const @ByRef engine aengine, @Const dnnl_primitive_desc hint_fwd_pd);

    /** Advances the primitive iterator to the next implementation.
     * 
     *  @return \c true on success, and \c false if the last implementation
     *      reached, and the primitive descriptor itself is kept unchanged */
    public native @Cast("bool") boolean next_impl();
}
