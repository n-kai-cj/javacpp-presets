// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_xfeatures2d;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import org.bytedeco.opencv.opencv_ml.*;
import static org.bytedeco.opencv.global.opencv_ml.*;
import org.bytedeco.opencv.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import org.bytedeco.opencv.opencv_videoio.*;
import static org.bytedeco.opencv.global.opencv_videoio.*;
import org.bytedeco.opencv.opencv_highgui.*;
import static org.bytedeco.opencv.global.opencv_highgui.*;
import org.bytedeco.opencv.opencv_flann.*;
import static org.bytedeco.opencv.global.opencv_flann.*;
import org.bytedeco.opencv.opencv_features2d.*;
import static org.bytedeco.opencv.global.opencv_features2d.*;
import org.bytedeco.opencv.opencv_calib3d.*;
import static org.bytedeco.opencv.global.opencv_calib3d.*;
import org.bytedeco.opencv.opencv_shape.*;
import static org.bytedeco.opencv.global.opencv_shape.*;

import static org.bytedeco.opencv.global.opencv_xfeatures2d.*;


/**
* \brief Class implementing Signature Quadratic Form Distance (SQFD).
* @see Christian Beecks, Merih Seran Uysal, Thomas Seidl.
*   Signature quadratic form distance.
*   In Proceedings of the ACM International Conference on Image and Video Retrieval, pages 438-445.
*   ACM, 2010.
* \cite BeecksUS10
*/
@Namespace("cv::xfeatures2d") @Properties(inherit = org.bytedeco.opencv.presets.opencv_xfeatures2d.class)
public class PCTSignaturesSQFD extends Algorithm {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public PCTSignaturesSQFD(Pointer p) { super(p); }


    /**
    * \brief Creates the algorithm instance using selected distance function,
    *       similarity function and similarity function parameter.
    * @param distanceFunction Distance function selector. Default: L2
    *       Available: L0_25, L0_5, L1, L2, L2SQUARED, L5, L_INFINITY
    * @param similarityFunction Similarity function selector. Default: HEURISTIC
    *       Available: MINUS, GAUSSIAN, HEURISTIC
    * @param similarityParameter Parameter of the similarity function.
    */
    public static native @Ptr PCTSignaturesSQFD create(
            int distanceFunction/*=3*/,
            int similarityFunction/*=2*/,
            float similarityParameter/*=1.0f*/);
    public static native @Ptr PCTSignaturesSQFD create();

    /**
    * \brief Computes Signature Quadratic Form Distance of two signatures.
    * @param _signature0 The first signature.
    * @param _signature1 The second signature.
    */
    public native float computeQuadraticFormDistance(
            @ByVal Mat _signature0,
            @ByVal Mat _signature1);
    public native float computeQuadraticFormDistance(
            @ByVal UMat _signature0,
            @ByVal UMat _signature1);
    public native float computeQuadraticFormDistance(
            @ByVal GpuMat _signature0,
            @ByVal GpuMat _signature1);

    /**
    * \brief Computes Signature Quadratic Form Distance between the reference signature
    *       and each of the other image signatures.
    * @param sourceSignature The signature to measure distance of other signatures from.
    * @param imageSignatures Vector of signatures to measure distance from the source signature.
    * @param distances Output vector of measured distances.
    */
    public native void computeQuadraticFormDistances(
            @Const @ByRef Mat sourceSignature,
            @Const @ByRef MatVector imageSignatures,
            @StdVector FloatPointer distances);
    public native void computeQuadraticFormDistances(
            @Const @ByRef Mat sourceSignature,
            @Const @ByRef MatVector imageSignatures,
            @StdVector FloatBuffer distances);
    public native void computeQuadraticFormDistances(
            @Const @ByRef Mat sourceSignature,
            @Const @ByRef MatVector imageSignatures,
            @StdVector float[] distances);

}
