// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.dnnl;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.dnnl.global.dnnl.*;

/** \endcond
 <p>
 *  An execution engine. */
@Namespace("dnnl") @Properties(inherit = org.bytedeco.dnnl.presets.dnnl.class)
public class engine extends dnnl_engine_handle {
    static { Loader.load(); }


    
        public engine() { super((Pointer)null); allocate(); }
        private native void allocate();
        public engine(@Const @ByRef engine arg0) { super((Pointer)null); allocate(arg0); }
        private native void allocate(@Const @ByRef engine arg0);
        
        ///
        public engine(dnnl_engine t, @Cast("bool") boolean weak/*=false*/) { super((Pointer)null); allocate(t, weak); }
        private native void allocate(dnnl_engine t, @Cast("bool") boolean weak/*=false*/);
        public engine(dnnl_engine t) { super((Pointer)null); allocate(t); }
        private native void allocate(dnnl_engine t);
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public engine(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public engine(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public engine position(long position) {
        return (engine)super.position(position);
    }
    @Override public engine getPointer(long i) {
        return new engine(this).position(position + i);
    }


    /** Kinds of engines. */
    public enum kind {
        /** An unspecified engine */
        any(dnnl_any_engine),
        /** CPU engine */
        cpu(dnnl_cpu),
        /** GPU engine */
        gpu(dnnl_gpu);

        public final int value;
        private kind(int v) { this.value = v; }
        private kind(kind e) { this.value = e.value; }
        public kind intern() { for (kind e : values()) if (e.value == value) return e; return this; }
        @Override public String toString() { return intern().name(); }
    }

    /** Constructs an empty engine. An empty engine cannot be used in any
     *  operations. */

    /** Returns the number of engines of a certain kind.
     * 
     *  @param akind The kind of engines to count.
     *  @return The number of engines of the specified kind. */
    
    ///
    public static native @Cast("size_t") long get_count(kind akind);
    public static native @Cast("size_t") long get_count(@Cast("dnnl::engine::kind") int akind);

    /** Constructs an engine.
     * 
     *  @param akind The kind of engine to construct.
     *  @param index The index of the engine. Must be less than the value
     *      returned by #get_count() for this particular kind of engine. */
    public engine(kind akind, @Cast("size_t") long index) { super((Pointer)null); allocate(akind, index); }
    private native void allocate(kind akind, @Cast("size_t") long index);
    public engine(@Cast("dnnl::engine::kind") int akind, @Cast("size_t") long index) { super((Pointer)null); allocate(akind, index); }
    private native void allocate(@Cast("dnnl::engine::kind") int akind, @Cast("size_t") long index);

// #if DNNL_GPU_RUNTIME == DNNL_RUNTIME_OCL
// #endif

    /** Constructs an engine based on a primitive from the primitive
     *  descriptor \p pd by querying its engine.
     * 
     *  @param pd The primitive descriptor to query. */
    public engine(@Const @ByRef dnnl_primitive_desc_handle pd) { super((Pointer)null); allocate(pd); }
    private native void allocate(@Const @ByRef dnnl_primitive_desc_handle pd);

    /** Returns the kind of the engine.
     *  @return The kind of the engine. */
    public native kind get_kind();

// #if DNNL_GPU_RUNTIME == DNNL_RUNTIME_OCL
// #endif

    /** Returns the engine of a primitive descriptor.
     * 
     *  @param pd The primitive descriptor to query.
     *  @return A weak handle to the engine that the primitive descriptor was
     *      created with. */
}
