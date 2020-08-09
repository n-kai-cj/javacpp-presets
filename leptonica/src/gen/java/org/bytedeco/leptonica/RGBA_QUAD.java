// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.leptonica;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.leptonica.global.lept.*;



    /** Colormap table entry (after the BMP version).
     * Note that the BMP format stores the colormap table exactly
     * as it appears here, with color samples being stored sequentially,
     * in the order (b,g,r,a). */
@Name("RGBA_Quad") @Properties(inherit = org.bytedeco.leptonica.presets.lept.class)
public class RGBA_QUAD extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public RGBA_QUAD() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public RGBA_QUAD(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public RGBA_QUAD(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public RGBA_QUAD position(long position) {
        return (RGBA_QUAD)super.position(position);
    }
    @Override public RGBA_QUAD getPointer(long i) {
        return new RGBA_QUAD(this).position(position + i);
    }

    /** blue value */
    public native @Cast("l_uint8") byte blue(); public native RGBA_QUAD blue(byte setter);
    /** green value */
    public native @Cast("l_uint8") byte green(); public native RGBA_QUAD green(byte setter);
    /** red value */
    public native @Cast("l_uint8") byte red(); public native RGBA_QUAD red(byte setter);
    /** alpha value */
    public native @Cast("l_uint8") byte alpha(); public native RGBA_QUAD alpha(byte setter);
}
