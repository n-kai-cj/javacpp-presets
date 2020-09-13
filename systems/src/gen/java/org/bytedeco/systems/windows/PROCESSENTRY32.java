// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.systems.windows;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.windows.*;


@Properties(inherit = org.bytedeco.systems.presets.windows.class)
public class PROCESSENTRY32 extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public PROCESSENTRY32() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public PROCESSENTRY32(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public PROCESSENTRY32(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public PROCESSENTRY32 position(long position) {
        return (PROCESSENTRY32)super.position(position);
    }
    @Override public PROCESSENTRY32 getPointer(long i) {
        return new PROCESSENTRY32(this).position(position + i);
    }

    public native @Cast("DWORD") int dwSize(); public native PROCESSENTRY32 dwSize(int setter);
    public native @Cast("DWORD") int cntUsage(); public native PROCESSENTRY32 cntUsage(int setter);
    public native @Cast("DWORD") int th32ProcessID(); public native PROCESSENTRY32 th32ProcessID(int setter);          // this process
    public native @Cast("ULONG_PTR") long th32DefaultHeapID(); public native PROCESSENTRY32 th32DefaultHeapID(long setter);
    public native @Cast("DWORD") int th32ModuleID(); public native PROCESSENTRY32 th32ModuleID(int setter);           // associated exe
    public native @Cast("DWORD") int cntThreads(); public native PROCESSENTRY32 cntThreads(int setter);
    public native @Cast("DWORD") int th32ParentProcessID(); public native PROCESSENTRY32 th32ParentProcessID(int setter);    // this process's parent process
    public native @Cast("LONG") int pcPriClassBase(); public native PROCESSENTRY32 pcPriClassBase(int setter);         // Base priority of process's threads
    public native @Cast("DWORD") int dwFlags(); public native PROCESSENTRY32 dwFlags(int setter);
    public native @Cast("CHAR") byte szExeFile(int i); public native PROCESSENTRY32 szExeFile(int i, byte setter);
    @MemberGetter public native @Cast("CHAR*") BytePointer szExeFile();    // Path
}
