// Targeted by JavaCPP version 1.5.6-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.ffmpeg.avutil;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.ffmpeg.global.avutil.*;


/**
 * \defgroup lavu_math_rational AVRational
 * \ingroup lavu_math
 * Rational number calculation.
 *
 * While rational numbers can be expressed as floating-point numbers, the
 * conversion process is a lossy one, so are floating-point operations. On the
 * other hand, the nature of FFmpeg demands highly accurate calculation of
 * timestamps. This set of rational number utilities serves as a generic
 * interface for manipulating rational numbers as pairs of numerators and
 * denominators.
 *
 * Many of the functions that operate on AVRational's have the suffix {@code _q}, in
 * reference to the mathematical symbol "ℚ" (Q) which denotes the set of all
 * rational numbers.
 *
 * \{
 */

/**
 * Rational number (pair of numerator and denominator).
 */
@Properties(inherit = org.bytedeco.ffmpeg.presets.avutil.class)
public class AVRational extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public AVRational() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public AVRational(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public AVRational(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public AVRational position(long position) {
        return (AVRational)super.position(position);
    }
    @Override public AVRational getPointer(long i) {
        return new AVRational((Pointer)this).position(position + i);
    }

    /** Numerator */
    public native int num(); public native AVRational num(int setter);
    /** Denominator */
    public native int den(); public native AVRational den(int setter);
}
