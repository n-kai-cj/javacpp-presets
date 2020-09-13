// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.systems.windows;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.windows.*;


@Properties(inherit = org.bytedeco.systems.presets.windows.class)
public class JOB_SET_ARRAY extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public JOB_SET_ARRAY() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public JOB_SET_ARRAY(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public JOB_SET_ARRAY(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public JOB_SET_ARRAY position(long position) {
        return (JOB_SET_ARRAY)super.position(position);
    }
    @Override public JOB_SET_ARRAY getPointer(long i) {
        return new JOB_SET_ARRAY(this).position(position + i);
    }

    public native @Cast("HANDLE") Pointer JobHandle(); public native JOB_SET_ARRAY JobHandle(Pointer setter);   // Handle to job object to insert
    public native @Cast("DWORD") int MemberLevel(); public native JOB_SET_ARRAY MemberLevel(int setter);  // Level of this job in the set. Must be > 0. Can be sparse.
    public native @Cast("DWORD") int Flags(); public native JOB_SET_ARRAY Flags(int setter);        // Unused. Must be zero
}
