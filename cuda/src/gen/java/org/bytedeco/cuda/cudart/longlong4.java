// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.cudart;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cuda.global.cudart.*;


@Properties(inherit = org.bytedeco.cuda.presets.cudart.class)
public class longlong4 extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public longlong4() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public longlong4(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public longlong4(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public longlong4 position(long position) {
        return (longlong4)super.position(position);
    }
    @Override public longlong4 getPointer(long i) {
        return new longlong4(this).position(position + i);
    }

    public native long x(); public native longlong4 x(long setter);
    public native long y(); public native longlong4 y(long setter);
    public native long z(); public native longlong4 z(long setter);
    public native long w(); public native longlong4 w(long setter);
}
