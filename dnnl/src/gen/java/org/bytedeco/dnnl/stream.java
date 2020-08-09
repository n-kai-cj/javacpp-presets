// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.dnnl;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.dnnl.global.dnnl.*;


/** An execution stream. */
@Namespace("dnnl") @Properties(inherit = org.bytedeco.dnnl.presets.dnnl.class)
public class stream extends dnnl_stream_handle {
    static { Loader.load(); }

    
        public stream() { super((Pointer)null); allocate(); }
        private native void allocate();
        public stream(@Const @ByRef stream arg0) { super((Pointer)null); allocate(arg0); }
        private native void allocate(@Const @ByRef stream arg0);
        
        ///
        public stream(dnnl_stream t, @Cast("bool") boolean weak/*=false*/) { super((Pointer)null); allocate(t, weak); }
        private native void allocate(dnnl_stream t, @Cast("bool") boolean weak/*=false*/);
        public stream(dnnl_stream t) { super((Pointer)null); allocate(t); }
        private native void allocate(dnnl_stream t);
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public stream(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public stream(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public stream position(long position) {
        return (stream)super.position(position);
    }
    @Override public stream getPointer(long i) {
        return new stream(this).position(position + i);
    }


    /** Stream flags. Can be combined using the bitwise OR operator. */
    public enum flags {
        /** Default order execution. Either in-order or out-of-order depending
         *  on the engine runtime. */
        default_order(dnnl_stream_default_order),
        /** In-order execution. */
        in_order(dnnl_stream_default_order),
        /** Out-of-order execution. */
        out_of_order(dnnl_stream_out_of_order),
        /** Default stream configuration. */
        default_flags(dnnl_stream_default_flags);

        public final int value;
        private flags(int v) { this.value = v; }
        private flags(flags e) { this.value = e.value; }
        public flags intern() { for (flags e : values()) if (e.value == value) return e; return this; }
        @Override public String toString() { return intern().name(); }
    }

    /** Constructs an empty stream. An empty stream cannot be used in any
     *  operations. */

    /** Constructs a stream for the specified engine and with behavior
     *  controlled by the specified flags.
     * 
     *  @param aengine Engine to create the stream on.
     *  @param aflags Flags controlling stream behavior.
     *  @param attr Stream attributes. */
    public stream(@Const @ByRef engine aengine, flags aflags/*=dnnl::stream::flags::default_flags*/,
                @Const @ByRef(nullValue = "dnnl::stream_attr()") stream_attr attr) { super((Pointer)null); allocate(aengine, aflags, attr); }
    private native void allocate(@Const @ByRef engine aengine, flags aflags/*=dnnl::stream::flags::default_flags*/,
                @Const @ByRef(nullValue = "dnnl::stream_attr()") stream_attr attr);
    public stream(@Const @ByRef engine aengine) { super((Pointer)null); allocate(aengine); }
    private native void allocate(@Const @ByRef engine aengine);

// #if DNNL_GPU_RUNTIME == DNNL_RUNTIME_OCL
// #endif

    /** Waits for all primitives executing in the stream to finish.
     *  @return The stream itself. */
    public native @ByRef @Name("wait") stream _wait();
}
