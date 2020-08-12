// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.nvml;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.cuda.cudart.*;
import static org.bytedeco.cuda.global.cudart.*;

import static org.bytedeco.cuda.global.nvml.*;


/**
 * Structure to store utilization value and process Id
 */
@Properties(inherit = org.bytedeco.cuda.presets.nvml.class)
public class nvmlProcessUtilizationSample_t extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public nvmlProcessUtilizationSample_t() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public nvmlProcessUtilizationSample_t(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public nvmlProcessUtilizationSample_t(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public nvmlProcessUtilizationSample_t position(long position) {
        return (nvmlProcessUtilizationSample_t)super.position(position);
    }
    @Override public nvmlProcessUtilizationSample_t getPointer(long i) {
        return new nvmlProcessUtilizationSample_t(this).position(position + i);
    }

    /** PID of process */
    public native @Cast("unsigned int") int pid(); public native nvmlProcessUtilizationSample_t pid(int setter);
    /** CPU Timestamp in microseconds */
    public native @Cast("unsigned long long") long timeStamp(); public native nvmlProcessUtilizationSample_t timeStamp(long setter);
    /** SM (3D/Compute) Util Value */
    public native @Cast("unsigned int") int smUtil(); public native nvmlProcessUtilizationSample_t smUtil(int setter);
    /** Frame Buffer Memory Util Value */
    public native @Cast("unsigned int") int memUtil(); public native nvmlProcessUtilizationSample_t memUtil(int setter);
    /** Encoder Util Value */
    public native @Cast("unsigned int") int encUtil(); public native nvmlProcessUtilizationSample_t encUtil(int setter);
    /** Decoder Util Value */
    public native @Cast("unsigned int") int decUtil(); public native nvmlProcessUtilizationSample_t decUtil(int setter);
}
