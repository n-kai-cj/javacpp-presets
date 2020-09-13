// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.nvml;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.cuda.cudart.*;
import static org.bytedeco.cuda.global.cudart.*;

import static org.bytedeco.cuda.global.nvml.*;


/**
 * Information for Sample
 */
@Properties(inherit = org.bytedeco.cuda.presets.nvml.class)
public class nvmlSample_t extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public nvmlSample_t() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public nvmlSample_t(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public nvmlSample_t(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public nvmlSample_t position(long position) {
        return (nvmlSample_t)super.position(position);
    }
    @Override public nvmlSample_t getPointer(long i) {
        return new nvmlSample_t(this).position(position + i);
    }

    /** CPU Timestamp in microseconds */
    public native @Cast("unsigned long long") long timeStamp(); public native nvmlSample_t timeStamp(long setter);
    /** Sample Value */
    public native @ByRef nvmlValue_t sampleValue(); public native nvmlSample_t sampleValue(nvmlValue_t setter);
}
