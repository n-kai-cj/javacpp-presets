// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_core;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;

import static org.bytedeco.opencv.global.opencv_core.*;


@Properties(inherit = org.bytedeco.opencv.presets.opencv_core.class)
public class Cv32suf extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public Cv32suf() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public Cv32suf(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Cv32suf(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public Cv32suf position(long position) {
        return (Cv32suf)super.position(position);
    }
    @Override public Cv32suf getPointer(long i) {
        return new Cv32suf(this).position(position + i);
    }

    public native int i(); public native Cv32suf i(int setter);
    public native @Cast("unsigned") int u(); public native Cv32suf u(int setter);
    public native float f(); public native Cv32suf f(float setter);
}
