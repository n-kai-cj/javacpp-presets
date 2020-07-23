// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.cudart;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cuda.global.cudart.*;


/**
 * CUDA Channel format descriptor
 */
@Properties(inherit = org.bytedeco.cuda.presets.cudart.class)
public class cudaChannelFormatDesc extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public cudaChannelFormatDesc() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public cudaChannelFormatDesc(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public cudaChannelFormatDesc(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public cudaChannelFormatDesc position(long position) {
        return (cudaChannelFormatDesc)super.position(position);
    }

    /** x */
    public native int x(); public native cudaChannelFormatDesc x(int setter);
    /** y */
    public native int y(); public native cudaChannelFormatDesc y(int setter);
    /** z */
    public native int z(); public native cudaChannelFormatDesc z(int setter);
    /** w */
    public native int w(); public native cudaChannelFormatDesc w(int setter);
    /** Channel format kind */
    public native @Cast("cudaChannelFormatKind") int f(); public native cudaChannelFormatDesc f(int setter);
}
