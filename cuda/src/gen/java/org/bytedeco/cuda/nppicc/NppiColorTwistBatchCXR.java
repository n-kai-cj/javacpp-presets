// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.nppicc;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.cuda.cudart.*;
import static org.bytedeco.cuda.global.cudart.*;
import org.bytedeco.cuda.nppc.*;
import static org.bytedeco.cuda.global.nppc.*;

import static org.bytedeco.cuda.global.nppicc.*;


/** \} color_twist */

/** \} image_color_twist */

/** \defgroup image_color_twist_batch ColorTwistBatch
 *
 * Routines for converting between various image color models using user supplied matrix coefficients on batches of images.
 *
 * \{ 
 *
 */
 
/** \name ColorTwistBatch
 * 
 * Perform color twist pixel batch processing.  Color twist consists of applying the following formula to each
 * image pixel using coefficients from one or more user supplied color twist device memory matrix arrays as follows where 
 * dst[x] and src[x] represent destination pixel and source pixel channel or plane x. The full sized
 * coefficient matrix should be sent for all pixel channel sizes, the function will process the appropriate
 * coefficients and channels for the corresponding pixel size.  ColorTwistBatch generally takes the same parameter list as ColorTwist
 * except that there is a list of N instances of those parameters (N > 1) and that list is passed in device memory;  The matrix
 * pointers referenced for each image in the batch also need to point to device memory matrix values. A convenient
 * data structure is provided that allows for easy initialization of the parameter lists.  The only restriction on these functions is
 * that there is one single ROI which is applied respectively to each image in the batch.  The primary purpose of this function is to
 * provide improved performance for batches of smaller images as long as GPU resources are available.  Therefore it is recommended
 * that the function not be used for very large images as there may not be resources available for processing several large images
 * simultaneously.  
 *
 *  <pre>{@code
 *      dst[0] = aTwist[0][0] * src[0] + aTwist[0][1] * src[1] + aTwist[0][2] * src[2] + aTwist[0][3]
 *      dst[1] = aTwist[1][0] * src[0] + aTwist[1][1] * src[1] + aTwist[1][2] * src[2] + aTwist[1][3]
 *      dst[2] = aTwist[2][0] * src[0] + aTwist[2][1] * src[1] + aTwist[2][2] * src[2] + aTwist[2][3]
 *  }</pre>
 *
 * \{
 */

@Properties(inherit = org.bytedeco.cuda.presets.nppicc.class)
public class NppiColorTwistBatchCXR extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public NppiColorTwistBatchCXR() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public NppiColorTwistBatchCXR(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public NppiColorTwistBatchCXR(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public NppiColorTwistBatchCXR position(long position) {
        return (NppiColorTwistBatchCXR)super.position(position);
    }
    @Override public NppiColorTwistBatchCXR getPointer(long i) {
        return new NppiColorTwistBatchCXR(this).position(position + i);
    }

    public native @Const Pointer pSrc(); public native NppiColorTwistBatchCXR pSrc(Pointer setter);  /* device memory pointer */
    public native int nSrcStep(); public native NppiColorTwistBatchCXR nSrcStep(int setter);
    public native Pointer pDst(); public native NppiColorTwistBatchCXR pDst(Pointer setter);        /* device memory pointer */
    public native int nDstStep(); public native NppiColorTwistBatchCXR nDstStep(int setter);
    public native @Cast("Npp32f*") FloatPointer pTwist(); public native NppiColorTwistBatchCXR pTwist(FloatPointer setter); /* device memory pointer to the color twist matrix with floating-point coefficient values to be used for this image */
}
