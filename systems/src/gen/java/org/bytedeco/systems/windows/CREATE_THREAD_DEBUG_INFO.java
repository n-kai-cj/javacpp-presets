// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.systems.windows;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.windows.*;


@Properties(inherit = org.bytedeco.systems.presets.windows.class)
public class CREATE_THREAD_DEBUG_INFO extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public CREATE_THREAD_DEBUG_INFO() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public CREATE_THREAD_DEBUG_INFO(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CREATE_THREAD_DEBUG_INFO(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public CREATE_THREAD_DEBUG_INFO position(long position) {
        return (CREATE_THREAD_DEBUG_INFO)super.position(position);
    }
    @Override public CREATE_THREAD_DEBUG_INFO getPointer(long i) {
        return new CREATE_THREAD_DEBUG_INFO((Pointer)this).position(position + i);
    }

    public native @Cast("HANDLE") Pointer hThread(); public native CREATE_THREAD_DEBUG_INFO hThread(Pointer setter);
    public native @Cast("LPVOID") Pointer lpThreadLocalBase(); public native CREATE_THREAD_DEBUG_INFO lpThreadLocalBase(Pointer setter);
    public native @Cast("LPTHREAD_START_ROUTINE") PTHREAD_START_ROUTINE lpStartAddress(); public native CREATE_THREAD_DEBUG_INFO lpStartAddress(PTHREAD_START_ROUTINE setter);
}
