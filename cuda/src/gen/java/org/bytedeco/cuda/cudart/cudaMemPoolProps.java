// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.cudart;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cuda.global.cudart.*;


@Properties(inherit = org.bytedeco.cuda.presets.cudart.class)
public class cudaMemPoolProps extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public cudaMemPoolProps() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public cudaMemPoolProps(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public cudaMemPoolProps(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public cudaMemPoolProps position(long position) {
        return (cudaMemPoolProps)super.position(position);
    }
    @Override public cudaMemPoolProps getPointer(long i) {
        return new cudaMemPoolProps(this).position(position + i);
    }

    public native @Cast("cudaMemAllocationType") int allocType(); public native cudaMemPoolProps allocType(int setter);
    public native @Cast("cudaMemAllocationHandleType") int handleTypes(); public native cudaMemPoolProps handleTypes(int setter);
    public native @ByRef cudaMemLocation location(); public native cudaMemPoolProps location(cudaMemLocation setter);
    public native Pointer win32SecurityAttributes(); public native cudaMemPoolProps win32SecurityAttributes(Pointer setter);
    public native @Cast("unsigned char") byte reserved(int i); public native cudaMemPoolProps reserved(int i, byte setter);
    @MemberGetter public native @Cast("unsigned char*") BytePointer reserved();
}
