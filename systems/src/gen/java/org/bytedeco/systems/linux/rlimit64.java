// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.systems.linux;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.linux.*;


// #ifdef __USE_LARGEFILE64
@Properties(inherit = org.bytedeco.systems.presets.linux.class)
public class rlimit64 extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public rlimit64() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public rlimit64(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public rlimit64(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public rlimit64 position(long position) {
        return (rlimit64)super.position(position);
    }

    /* The current (soft) limit.  */
    public native @Cast("rlim64_t") long rlim_cur(); public native rlimit64 rlim_cur(long setter);
    /* The hard limit.  */
    public native @Cast("rlim64_t") long rlim_max(); public native rlimit64 rlim_max(long setter);
 }
