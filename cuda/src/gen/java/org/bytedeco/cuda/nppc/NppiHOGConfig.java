// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.nppc;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.cuda.cudart.*;
import static org.bytedeco.cuda.global.cudart.*;

import static org.bytedeco.cuda.global.nppc.*;



/** 
 * The NppiHOGConfig structure defines the configuration parameters for the HOG descriptor: 
 */
 
@Properties(inherit = org.bytedeco.cuda.presets.nppc.class)
public class NppiHOGConfig extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public NppiHOGConfig() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public NppiHOGConfig(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public NppiHOGConfig(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public NppiHOGConfig position(long position) {
        return (NppiHOGConfig)super.position(position);
    }
    @Override public NppiHOGConfig getPointer(long i) {
        return new NppiHOGConfig(this).position(position + i);
    }

    /**  square cell size (pixels). */
    public native int cellSize(); public native NppiHOGConfig cellSize(int setter);
    /**  square histogram block size (pixels). */
    public native int histogramBlockSize(); public native NppiHOGConfig histogramBlockSize(int setter);
    /**  required number of histogram bins. */
    public native int nHistogramBins(); public native NppiHOGConfig nHistogramBins(int setter);
    /**  detection window size (pixels). */
    public native @ByRef NppiSize detectionWindowSize(); public native NppiHOGConfig detectionWindowSize(NppiSize setter);
}
