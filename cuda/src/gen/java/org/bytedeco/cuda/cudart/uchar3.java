// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.cudart;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cuda.global.cudart.*;


@Properties(inherit = org.bytedeco.cuda.presets.cudart.class)
public class uchar3 extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public uchar3() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public uchar3(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public uchar3(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public uchar3 position(long position) {
        return (uchar3)super.position(position);
    }
    @Override public uchar3 getPointer(long i) {
        return new uchar3(this).position(position + i);
    }

    public native @Cast("unsigned char") byte x(); public native uchar3 x(byte setter);
    public native @Cast("unsigned char") byte y(); public native uchar3 y(byte setter);
    public native @Cast("unsigned char") byte z(); public native uchar3 z(byte setter);
}
