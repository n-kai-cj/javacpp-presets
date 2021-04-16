// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.systems.linux;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.linux.*;



/* Data structure to contain attributes for thread creation.  */
@Properties(inherit = org.bytedeco.systems.presets.linux.class)
public class posix_spawnattr_t extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public posix_spawnattr_t() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public posix_spawnattr_t(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public posix_spawnattr_t(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public posix_spawnattr_t position(long position) {
        return (posix_spawnattr_t)super.position(position);
    }
    @Override public posix_spawnattr_t getPointer(long i) {
        return new posix_spawnattr_t((Pointer)this).position(position + i);
    }

  public native short __flags(); public native posix_spawnattr_t __flags(short setter);
  public native @Cast("pid_t") int __pgrp(); public native posix_spawnattr_t __pgrp(int setter);
  public native @ByRef sigset_t __sd(); public native posix_spawnattr_t __sd(sigset_t setter);
  public native @ByRef sigset_t __ss(); public native posix_spawnattr_t __ss(sigset_t setter);
  public native @ByRef sched_param __sp(); public native posix_spawnattr_t __sp(sched_param setter);
  public native int __policy(); public native posix_spawnattr_t __policy(int setter);
  public native int __pad(int i); public native posix_spawnattr_t __pad(int i, int setter);
  @MemberGetter public native @Cast("int*") IntPointer __pad();
}
