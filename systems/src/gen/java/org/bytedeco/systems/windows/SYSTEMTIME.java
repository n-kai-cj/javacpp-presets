// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.systems.windows;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.windows.*;

// #endif

//
// System time is represented with the following structure:
//

@Properties(inherit = org.bytedeco.systems.presets.windows.class)
public class SYSTEMTIME extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SYSTEMTIME() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SYSTEMTIME(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SYSTEMTIME(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SYSTEMTIME position(long position) {
        return (SYSTEMTIME)super.position(position);
    }
    @Override public SYSTEMTIME getPointer(long i) {
        return new SYSTEMTIME(this).position(position + i);
    }

    public native @Cast("WORD") short wYear(); public native SYSTEMTIME wYear(short setter);
    public native @Cast("WORD") short wMonth(); public native SYSTEMTIME wMonth(short setter);
    public native @Cast("WORD") short wDayOfWeek(); public native SYSTEMTIME wDayOfWeek(short setter);
    public native @Cast("WORD") short wDay(); public native SYSTEMTIME wDay(short setter);
    public native @Cast("WORD") short wHour(); public native SYSTEMTIME wHour(short setter);
    public native @Cast("WORD") short wMinute(); public native SYSTEMTIME wMinute(short setter);
    public native @Cast("WORD") short wSecond(); public native SYSTEMTIME wSecond(short setter);
    public native @Cast("WORD") short wMilliseconds(); public native SYSTEMTIME wMilliseconds(short setter);
}
