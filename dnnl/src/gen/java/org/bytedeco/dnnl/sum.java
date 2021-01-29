// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.dnnl;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.opencl.*;
import static org.bytedeco.opencl.global.OpenCL.*;

import static org.bytedeco.dnnl.global.dnnl.*;


/** \} dnnl_api_concat
 <p>
 *  \addtogroup dnnl_api_sum Sum
 * 
 *  A primitive to sum multiple tensors.
 * 
 *  @see \ref dev_guide_sum in developer guide
 * 
 *  \{
 <p>
 *  Out-of-place summation (sum) primitive. */
@Namespace("dnnl") @Properties(inherit = org.bytedeco.dnnl.presets.dnnl.class)
public class sum extends primitive {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public sum(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public sum(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public sum position(long position) {
        return (sum)super.position(position);
    }
    @Override public sum getPointer(long i) {
        return new sum((Pointer)this).position(position + i);
    }

    /** Primitive descriptor for a sum primitive. */
    public static class primitive_desc extends primitive_desc_base {
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
    

        /** Default constructor. Produces an empty object. */

        /** Constructs a primitive descriptor for a sum primitive.
         * 
         *  @param dst Destination memory descriptor.
         *  @param scales Vector of scales to multiply data in each source
         *      memory by.
         *  @param srcs Vector of source memory descriptors.
         *  @param aengine Engine to perform the operation on.
         *  @param attr Primitive attributes to use (optional). */
        
        ///
        ///
        public primitive_desc(@Const @ByRef memory.desc dst,
                        @StdVector FloatPointer scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine,
                        @Const @ByRef(nullValue = "dnnl::primitive_attr()") primitive_attr attr) { super((Pointer)null); allocate(dst, scales, srcs, aengine, attr); }
        private native void allocate(@Const @ByRef memory.desc dst,
                        @StdVector FloatPointer scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine,
                        @Const @ByRef(nullValue = "dnnl::primitive_attr()") primitive_attr attr);
        public primitive_desc(@Const @ByRef memory.desc dst,
                        @StdVector FloatPointer scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine) { super((Pointer)null); allocate(dst, scales, srcs, aengine); }
        private native void allocate(@Const @ByRef memory.desc dst,
                        @StdVector FloatPointer scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine);
        public primitive_desc(@Const @ByRef memory.desc dst,
                        @StdVector FloatBuffer scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine,
                        @Const @ByRef(nullValue = "dnnl::primitive_attr()") primitive_attr attr) { super((Pointer)null); allocate(dst, scales, srcs, aengine, attr); }
        private native void allocate(@Const @ByRef memory.desc dst,
                        @StdVector FloatBuffer scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine,
                        @Const @ByRef(nullValue = "dnnl::primitive_attr()") primitive_attr attr);
        public primitive_desc(@Const @ByRef memory.desc dst,
                        @StdVector FloatBuffer scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine) { super((Pointer)null); allocate(dst, scales, srcs, aengine); }
        private native void allocate(@Const @ByRef memory.desc dst,
                        @StdVector FloatBuffer scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine);
        public primitive_desc(@Const @ByRef memory.desc dst,
                        @StdVector float[] scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine,
                        @Const @ByRef(nullValue = "dnnl::primitive_attr()") primitive_attr attr) { super((Pointer)null); allocate(dst, scales, srcs, aengine, attr); }
        private native void allocate(@Const @ByRef memory.desc dst,
                        @StdVector float[] scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine,
                        @Const @ByRef(nullValue = "dnnl::primitive_attr()") primitive_attr attr);
        public primitive_desc(@Const @ByRef memory.desc dst,
                        @StdVector float[] scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine) { super((Pointer)null); allocate(dst, scales, srcs, aengine); }
        private native void allocate(@Const @ByRef memory.desc dst,
                        @StdVector float[] scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine);

        /** Constructs a primitive descriptor for a sum primitive.
         * 
         *  This version derives the destination memory descriptor
         *  automatically.
         * 
         *  @param scales Vector of scales by which to multiply data in each
         *      source memory object.
         *  @param srcs Vector of source memory descriptors.
         *  @param aengine Engine on which to perform the operation.
         *  @param attr Primitive attributes to use (optional). */
        
        ///
        public primitive_desc(@StdVector FloatPointer scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine,
                        @Const @ByRef(nullValue = "dnnl::primitive_attr()") primitive_attr attr) { super((Pointer)null); allocate(scales, srcs, aengine, attr); }
        private native void allocate(@StdVector FloatPointer scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine,
                        @Const @ByRef(nullValue = "dnnl::primitive_attr()") primitive_attr attr);
        public primitive_desc(@StdVector FloatPointer scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine) { super((Pointer)null); allocate(scales, srcs, aengine); }
        private native void allocate(@StdVector FloatPointer scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine);
        public primitive_desc(@StdVector FloatBuffer scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine,
                        @Const @ByRef(nullValue = "dnnl::primitive_attr()") primitive_attr attr) { super((Pointer)null); allocate(scales, srcs, aengine, attr); }
        private native void allocate(@StdVector FloatBuffer scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine,
                        @Const @ByRef(nullValue = "dnnl::primitive_attr()") primitive_attr attr);
        public primitive_desc(@StdVector FloatBuffer scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine) { super((Pointer)null); allocate(scales, srcs, aengine); }
        private native void allocate(@StdVector FloatBuffer scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine);
        public primitive_desc(@StdVector float[] scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine,
                        @Const @ByRef(nullValue = "dnnl::primitive_attr()") primitive_attr attr) { super((Pointer)null); allocate(scales, srcs, aengine, attr); }
        private native void allocate(@StdVector float[] scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine,
                        @Const @ByRef(nullValue = "dnnl::primitive_attr()") primitive_attr attr);
        public primitive_desc(@StdVector float[] scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine) { super((Pointer)null); allocate(scales, srcs, aengine); }
        private native void allocate(@StdVector float[] scales,
                        @StdVector memory.desc srcs, @Const @ByRef engine aengine);

        /** Constructs a primitive descriptor for sum primitive from a C API
         *  primitive descriptor which must have a matching kind.
         * 
         *  @param pd C API primitive descriptor for reorder primitive. */
        

        /** \copydoc dnnl::primitive_desc_base::src_desc(int)const */
        public native @ByVal memory.desc src_desc(int idx/*=0*/);
        public native @ByVal memory.desc src_desc();

        /** \copydoc dnnl::primitive_desc_base::dst_desc()const */
        public native @ByVal memory.desc dst_desc();
    }

    /** Default constructor. Produces an empty object. */
    public sum() { super((Pointer)null); allocate(); }
    private native void allocate();

    /** Constructs a sum primitive.
     *  @param pd Primitive descriptor for sum primitive. */
    public sum(@Const @ByRef primitive_desc pd) { super((Pointer)null); allocate(pd); }
    private native void allocate(@Const @ByRef primitive_desc pd);
}
