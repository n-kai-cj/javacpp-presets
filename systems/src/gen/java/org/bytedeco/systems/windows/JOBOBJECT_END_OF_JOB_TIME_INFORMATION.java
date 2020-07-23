// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.systems.windows;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.windows.*;


@Properties(inherit = org.bytedeco.systems.presets.windows.class)
public class JOBOBJECT_END_OF_JOB_TIME_INFORMATION extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public JOBOBJECT_END_OF_JOB_TIME_INFORMATION() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public JOBOBJECT_END_OF_JOB_TIME_INFORMATION(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public JOBOBJECT_END_OF_JOB_TIME_INFORMATION(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public JOBOBJECT_END_OF_JOB_TIME_INFORMATION position(long position) {
        return (JOBOBJECT_END_OF_JOB_TIME_INFORMATION)super.position(position);
    }

    public native @Cast("DWORD") int EndOfJobTimeAction(); public native JOBOBJECT_END_OF_JOB_TIME_INFORMATION EndOfJobTimeAction(int setter);
}
