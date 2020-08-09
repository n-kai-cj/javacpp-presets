// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.dnnl;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.dnnl.global.dnnl.*;


/** \} dnnl_api_batch_normalization
 <p>
 *  \addtogroup dnnl_api_layer_normalization Layer Normalization
 * 
 *  A primitive to perform layer normalization. Normalization is performed
 *  within the last logical dimension of data tensor.
 * 
 *  Both forward and backward propagation primitives support in-place
 *  operation; that is, src and dst can refer to the same memory for forward
 *  propagation, and diff_dst and diff_src can refer to the same memory for
 *  backward propagation.
 * 
 *  The layer normalization primitives computations can be controlled by
 *  specifying different dnnl::normalization_flags values. For example,
 *  layer normalization forward propagation can be configured to either
 *  compute the mean and variance or take them as arguments. It can either
 *  perform scaling and shifting using gamma and beta parameters or not.
 *  Optionally, it can also perform a fused ReLU, which in case of training
 *  would also require a workspace.
 * 
 *  @see \ref dev_guide_layer_normalization in developer guide
 * 
 *  \{
 <p>
 *  Layer normalization forward propagation primitive. */
@Namespace("dnnl") @Properties(inherit = org.bytedeco.dnnl.presets.dnnl.class)
public class layer_normalization_forward extends primitive {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public layer_normalization_forward(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public layer_normalization_forward(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public layer_normalization_forward position(long position) {
        return (layer_normalization_forward)super.position(position);
    }
    @Override public layer_normalization_forward getPointer(long i) {
        return new layer_normalization_forward(this).position(position + i);
    }

    /** Descriptor for a layer normalization forward propagation primitive. */
    @NoOffset public static class desc extends Pointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public desc(Pointer p) { super(p); }
    
        
        ///
        public native @ByRef dnnl_layer_normalization_desc_t data(); public native desc data(dnnl_layer_normalization_desc_t setter);

        /** Constructs a descriptor for layer normalization forward
         *  propagation primitive.
         * 
         *  @param aprop_kind Propagation kind. Possible values are
         *      #dnnl::prop_kind::forward_training, and
         *      #dnnl::prop_kind::forward_inference.
         *  @param data_desc Source and destination memory descriptor.
         *  @param stat_desc Statistics memory descriptors.
         *  @param epsilon Layer normalization epsilon parameter.
         *  @param flags Layer normalization flags (\ref
         *      dnnl::normalization_flags). */
        
        ///
        public desc(prop_kind aprop_kind, @Const @ByRef memory.desc data_desc,
                        @Const @ByRef memory.desc stat_desc, float epsilon,
                        normalization_flags flags) { super((Pointer)null); allocate(aprop_kind, data_desc, stat_desc, epsilon, flags); }
        private native void allocate(prop_kind aprop_kind, @Const @ByRef memory.desc data_desc,
                        @Const @ByRef memory.desc stat_desc, float epsilon,
                        normalization_flags flags);
        public desc(@Cast("dnnl::prop_kind") int aprop_kind, @Const @ByRef memory.desc data_desc,
                        @Const @ByRef memory.desc stat_desc, float epsilon,
                        @Cast("dnnl::normalization_flags") int flags) { super((Pointer)null); allocate(aprop_kind, data_desc, stat_desc, epsilon, flags); }
        private native void allocate(@Cast("dnnl::prop_kind") int aprop_kind, @Const @ByRef memory.desc data_desc,
                        @Const @ByRef memory.desc stat_desc, float epsilon,
                        @Cast("dnnl::normalization_flags") int flags);

        /** Constructs a descriptor for layer normalization forward
         *  propagation primitive.
         * 
         *  @param aprop_kind Propagation kind. Possible values are
         *      #dnnl::prop_kind::forward_training, and
         *      #dnnl::prop_kind::forward_inference.
         *  @param data_desc Source and destination memory descriptor.
         *  @param epsilon Layer normalization epsilon parameter.
         *  @param flags Layer normalization flags (\ref
         *      dnnl::normalization_flags). */
        public desc(prop_kind aprop_kind, @Const @ByRef memory.desc data_desc, float epsilon,
                        normalization_flags flags) { super((Pointer)null); allocate(aprop_kind, data_desc, epsilon, flags); }
        private native void allocate(prop_kind aprop_kind, @Const @ByRef memory.desc data_desc, float epsilon,
                        normalization_flags flags);
        public desc(@Cast("dnnl::prop_kind") int aprop_kind, @Const @ByRef memory.desc data_desc, float epsilon,
                        @Cast("dnnl::normalization_flags") int flags) { super((Pointer)null); allocate(aprop_kind, data_desc, epsilon, flags); }
        private native void allocate(@Cast("dnnl::prop_kind") int aprop_kind, @Const @ByRef memory.desc data_desc, float epsilon,
                        @Cast("dnnl::normalization_flags") int flags);
    }

    /** Primitive descriptor for a layer normalization forward propagation
     *  primitive. */
    public static class primitive_desc extends org.bytedeco.dnnl.primitive_desc {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public primitive_desc(Pointer p) { super(p); }
        /** Native array allocator. Access with {@link Pointer#position(long)}. */
        public primitive_desc(long size) { super((Pointer)null); allocateArray(size); }
        private native void allocateArray(long size);
        @Override public primitive_desc position(long position) {
            return (primitive_desc)super.position(position);
        }
        @Override public primitive_desc getPointer(long i) {
            return new primitive_desc(this).position(position + i);
        }
    
        /** Default constructor. Produces an empty object. */
        
        ///
        public primitive_desc() { super((Pointer)null); allocate(); }
        private native void allocate();

        /** Constructs a primitive descriptor for a layer normalization forward
         *  propagation primitive.
         * 
         *  @param adesc Descriptor for a layer normalization forward propagation
         *      primitive.
         *  @param aengine Engine to use.
         *  @param allow_empty A flag signifying whether construction is
         *      allowed to fail without throwing an exception. In this case an
         *      empty object will be produced. This flag is optional and
         *      defaults to false. */
        
        ///
        public primitive_desc(@Const @ByRef desc adesc, @Const @ByRef engine aengine,
                        @Cast("bool") boolean allow_empty/*=false*/) { super((Pointer)null); allocate(adesc, aengine, allow_empty); }
        private native void allocate(@Const @ByRef desc adesc, @Const @ByRef engine aengine,
                        @Cast("bool") boolean allow_empty/*=false*/);
        public primitive_desc(@Const @ByRef desc adesc, @Const @ByRef engine aengine) { super((Pointer)null); allocate(adesc, aengine); }
        private native void allocate(@Const @ByRef desc adesc, @Const @ByRef engine aengine);

        /** Constructs a primitive descriptor for a layer normalization forward
         *  propagation primitive.
         * 
         *  @param adesc Descriptor for a layer normalization forward propagation
         *      primitive.
         *  @param attr Primitive attributes to use.
         *  @param aengine Engine to use.
         *  @param allow_empty A flag signifying whether construction is
         *      allowed to fail without throwing an exception. In this case an
         *      empty object will be produced. This flag is optional and
         *      defaults to false. */
        
        ///
        public primitive_desc(@Const @ByRef desc adesc, @Const @ByRef primitive_attr attr,
                        @Const @ByRef engine aengine, @Cast("bool") boolean allow_empty/*=false*/) { super((Pointer)null); allocate(adesc, attr, aengine, allow_empty); }
        private native void allocate(@Const @ByRef desc adesc, @Const @ByRef primitive_attr attr,
                        @Const @ByRef engine aengine, @Cast("bool") boolean allow_empty/*=false*/);
        public primitive_desc(@Const @ByRef desc adesc, @Const @ByRef primitive_attr attr,
                        @Const @ByRef engine aengine) { super((Pointer)null); allocate(adesc, attr, aengine); }
        private native void allocate(@Const @ByRef desc adesc, @Const @ByRef primitive_attr attr,
                        @Const @ByRef engine aengine);

        /** Constructs a primitive descriptor for a layer normalization
         *  forward propagation primitive from a C API primitive descriptor
         *  that must have a matching kind.
         * 
         *  @param pd C API primitive descriptor for a layer normalization
         *      forward propagation primitive. */
        public primitive_desc(dnnl_primitive_desc pd) { super((Pointer)null); allocate(pd); }
        private native void allocate(dnnl_primitive_desc pd);

        /** \copydoc dnnl::primitive_desc_base::src_desc()const */
        public native @ByVal memory.desc src_desc();

        /** \copydoc dnnl::primitive_desc_base::dst_desc()const */
        public native @ByVal memory.desc dst_desc();

        /** \copydoc dnnl::primitive_desc_base::weights_desc()const */
        public native @ByVal memory.desc weights_desc();

        /** \copydoc dnnl::primitive_desc_base::workspace_desc()const */
        public native @ByVal memory.desc workspace_desc();

        /** \copydoc dnnl::batch_normalization_forward::primitive_desc::mean_desc()const */
        public native @ByVal memory.desc mean_desc();

        /** \copydoc dnnl::batch_normalization_forward::primitive_desc::variance_desc()const */
        public native @ByVal memory.desc variance_desc();
    }

    /** Default constructor. Produces an empty object. */
    public layer_normalization_forward() { super((Pointer)null); allocate(); }
    private native void allocate();

    /** Constructs a layer normalization forward propagation primitive.
     *  @param pd Primitive descriptor for a layer normalization forward
     *      propagation primitive. */
    public layer_normalization_forward(@Const @ByRef primitive_desc pd) { super((Pointer)null); allocate(pd); }
    private native void allocate(@Const @ByRef primitive_desc pd);
}
