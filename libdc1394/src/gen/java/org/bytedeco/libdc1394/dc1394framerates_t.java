// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.libdc1394;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.libdc1394.global.dc1394.*;


/**
 * List of framerates
 *
 * dc1394framerates_t contains a list of available framerates for a particular video mode.
 */
@Properties(inherit = org.bytedeco.libdc1394.presets.dc1394.class)
public class dc1394framerates_t extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public dc1394framerates_t() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public dc1394framerates_t(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public dc1394framerates_t(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public dc1394framerates_t position(long position) {
        return (dc1394framerates_t)super.position(position);
    }
    @Override public dc1394framerates_t getPointer(long i) {
        return new dc1394framerates_t(this).position(position + i);
    }

    public native @Cast("uint32_t") int num(); public native dc1394framerates_t num(int setter);
    public native @Cast("dc1394framerate_t") int framerates(int i); public native dc1394framerates_t framerates(int i, int setter);
    @MemberGetter public native @Cast("dc1394framerate_t*") IntPointer framerates();
}
