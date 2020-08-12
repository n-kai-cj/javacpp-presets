// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.cudart;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cuda.global.cudart.*;


@Properties(inherit = org.bytedeco.cuda.presets.cudart.class)
public class short3 extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public short3() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public short3(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public short3(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public short3 position(long position) {
        return (short3)super.position(position);
    }
    @Override public short3 getPointer(long i) {
        return new short3(this).position(position + i);
    }

    public native short x(); public native short3 x(short setter);
    public native short y(); public native short3 y(short setter);
    public native short z(); public native short3 z(short setter);
}
