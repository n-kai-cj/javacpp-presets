// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.librealsense2;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.librealsense2.global.realsense2.*;


@Properties(inherit = org.bytedeco.librealsense2.presets.realsense2.class)
public class STRauSupportVectorControl extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public STRauSupportVectorControl() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public STRauSupportVectorControl(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public STRauSupportVectorControl(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public STRauSupportVectorControl position(long position) {
        return (STRauSupportVectorControl)super.position(position);
    }
    @Override public STRauSupportVectorControl getPointer(long i) {
        return new STRauSupportVectorControl(this).position(position + i);
    }

    public native @Cast("uint32_t") int minWest(); public native STRauSupportVectorControl minWest(int setter);
    public native @Cast("uint32_t") int minEast(); public native STRauSupportVectorControl minEast(int setter);
    public native @Cast("uint32_t") int minWEsum(); public native STRauSupportVectorControl minWEsum(int setter);
    public native @Cast("uint32_t") int minNorth(); public native STRauSupportVectorControl minNorth(int setter);
    public native @Cast("uint32_t") int minSouth(); public native STRauSupportVectorControl minSouth(int setter);
    public native @Cast("uint32_t") int minNSsum(); public native STRauSupportVectorControl minNSsum(int setter);
    public native @Cast("uint32_t") int uShrink(); public native STRauSupportVectorControl uShrink(int setter);
    public native @Cast("uint32_t") int vShrink(); public native STRauSupportVectorControl vShrink(int setter);
}
