// Targeted by JavaCPP version 1.5.2: DO NOT EDIT THIS FILE

package org.bytedeco.systems.windows;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.systems.global.windows.*;


//
// Last resume performance structure
//

@Properties(inherit = org.bytedeco.systems.presets.windows.class)
public class RESUME_PERFORMANCE extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public RESUME_PERFORMANCE() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public RESUME_PERFORMANCE(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public RESUME_PERFORMANCE(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public RESUME_PERFORMANCE position(long position) {
        return (RESUME_PERFORMANCE)super.position(position);
    }

    public native @Cast("DWORD") int PostTimeMs(); public native RESUME_PERFORMANCE PostTimeMs(int setter);
    public native @Cast("ULONGLONG") long TotalResumeTimeMs(); public native RESUME_PERFORMANCE TotalResumeTimeMs(long setter);
    public native @Cast("ULONGLONG") long ResumeCompleteTimestamp(); public native RESUME_PERFORMANCE ResumeCompleteTimestamp(long setter);
}