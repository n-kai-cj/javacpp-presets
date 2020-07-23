// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.skia;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.skia.global.Skia.*;


@Properties(inherit = org.bytedeco.skia.presets.Skia.class)
public class sk_rsxform_t extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public sk_rsxform_t() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public sk_rsxform_t(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public sk_rsxform_t(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public sk_rsxform_t position(long position) {
        return (sk_rsxform_t)super.position(position);
    }

    public native float fSCos(); public native sk_rsxform_t fSCos(float setter);
    public native float fSSin(); public native sk_rsxform_t fSSin(float setter);
    public native float fTX(); public native sk_rsxform_t fTX(float setter);
    public native float fTY(); public native sk_rsxform_t fTY(float setter);
}
