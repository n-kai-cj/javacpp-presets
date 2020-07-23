// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorrt.nvinfer;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.cuda.cudart.*;
import static org.bytedeco.cuda.global.cudart.*;
import org.bytedeco.cuda.cublas.*;
import static org.bytedeco.cuda.global.cublas.*;
import org.bytedeco.cuda.cudnn.*;
import static org.bytedeco.cuda.global.cudnn.*;
import org.bytedeco.cuda.nvrtc.*;
import static org.bytedeco.cuda.global.nvrtc.*;

import static org.bytedeco.tensorrt.global.nvinfer.*;


/**
 *  \class IInt8Calibrator
 * 
 *  \brief Application-implemented interface for calibration.
 * 
 *  Calibration is a step performed by the builder when deciding suitable scale factors for 8-bit inference.
 * 
 *  It must also provide a method for retrieving representative images which the calibration process can use to examine
 *  the distribution of activations. It may optionally implement a method for caching the calibration result for reuse
 *  on subsequent runs.
 *  */
@Namespace("nvinfer1") @Properties(inherit = org.bytedeco.tensorrt.presets.nvinfer.class)
public class IInt8Calibrator extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public IInt8Calibrator() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public IInt8Calibrator(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IInt8Calibrator(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public IInt8Calibrator position(long position) {
        return (IInt8Calibrator)super.position(position);
    }

    /**
     *  \brief Get the batch size used for calibration batches.
     * 
     *  @return The batch size.
     *  */
    
    
    //!
    //!
    //!
    //!
    //!
    @Virtual(true) public native @Const({false, false, true}) int getBatchSize();

    /**
     *  \brief Get a batch of input for calibration.
     * 
     *  The batch size of the input must match the batch size returned by getBatchSize().
     * 
     *  @param bindings An array of pointers to device memory that must be updated to point to device memory
     *  containing each network input data.
     *  @param names The names of the network input for each pointer in the binding array.
     *  @param nbBindings The number of pointers in the bindings array.
     *  @return False if there are no more batches for calibration.
     * 
     *  @see getBatchSize()
     *  */
    
    
    //!
    //!
    //!
    //!
    //!
    @Virtual(true) public native @Cast("bool") boolean getBatch(@Cast("void**") PointerPointer bindings, @Cast("const char**") PointerPointer names, int nbBindings);

    /**
     *  \brief Load a calibration cache.
     * 
     *  Calibration is potentially expensive, so it can be useful to generate the calibration data once, then use it on
     *  subsequent builds of the network. The cache includes the regression cutoff and quantile values used to generate
     *  it, and will not be used if these do not batch the settings of the current calibrator. However, the network
     *  should also be recalibrated if its structure changes, or the input data set changes, and it is the
     *  responsibility of the application to ensure this.
     * 
     *  @param length The length of the cached data, that should be set by the called function. If there is no data,
     *  this should be zero.
     * 
     *  @return A pointer to the cache, or nullptr if there is no data.
     *  */
    
    
    //!
    //!
    //!
    //!
    @Virtual(true) public native @Const Pointer readCalibrationCache(@Cast("std::size_t*") @ByRef LongPointer length);

    /**
     *  \brief Save a calibration cache.
     * 
     *  @param ptr A pointer to the data to cache.
     *  @param length The length in bytes of the data to cache.
     * 
     *  @see readCalibrationCache()
     *  */
    
    
    //!
    //!
    //!
    @Virtual(true) public native void writeCalibrationCache(@Const Pointer ptr, @Cast("std::size_t") long length);

    /**
     *  \brief Get the algorithm used by this calibrator.
     * 
     *  @return The algorithm used by the calibrator.
     *  */
    @Virtual(true) public native CalibrationAlgoType getAlgorithm();
}
