// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.cudart;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cuda.global.cudart.*;


@Properties(inherit = org.bytedeco.cuda.presets.cudart.class)
public class cudaMemPoolPtrExportData extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public cudaMemPoolPtrExportData() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public cudaMemPoolPtrExportData(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public cudaMemPoolPtrExportData(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public cudaMemPoolPtrExportData position(long position) {
        return (cudaMemPoolPtrExportData)super.position(position);
    }
    @Override public cudaMemPoolPtrExportData getPointer(long i) {
        return new cudaMemPoolPtrExportData(this).position(position + i);
    }

    public native @Cast("unsigned char") byte reserved(int i); public native cudaMemPoolPtrExportData reserved(int i, byte setter);
    @MemberGetter public native @Cast("unsigned char*") BytePointer reserved();
}
