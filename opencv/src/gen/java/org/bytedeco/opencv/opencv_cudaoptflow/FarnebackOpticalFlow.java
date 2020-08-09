// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_cudaoptflow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_core.*;
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
import org.bytedeco.opencv.opencv_objdetect.*;
import static org.bytedeco.opencv.global.opencv_objdetect.*;
import org.bytedeco.opencv.opencv_video.*;
import static org.bytedeco.opencv.global.opencv_video.*;
import org.bytedeco.opencv.opencv_ximgproc.*;
import static org.bytedeco.opencv.global.opencv_ximgproc.*;
import org.bytedeco.opencv.opencv_optflow.*;
import static org.bytedeco.opencv.global.opencv_optflow.*;
import org.bytedeco.opencv.opencv_cudaarithm.*;
import static org.bytedeco.opencv.global.opencv_cudaarithm.*;
import org.bytedeco.opencv.opencv_cudafilters.*;
import static org.bytedeco.opencv.global.opencv_cudafilters.*;
import org.bytedeco.opencv.opencv_cudaimgproc.*;
import static org.bytedeco.opencv.global.opencv_cudaimgproc.*;
import static org.bytedeco.opencv.global.opencv_cudawarping.*;

import static org.bytedeco.opencv.global.opencv_cudaoptflow.*;


//
// FarnebackOpticalFlow
//

/** \brief Class computing a dense optical flow using the Gunnar Farneback's algorithm.
 */
@Namespace("cv::cuda") @Properties(inherit = org.bytedeco.opencv.presets.opencv_cudaoptflow.class)
public class FarnebackOpticalFlow extends DenseOpticalFlow {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FarnebackOpticalFlow(Pointer p) { super(p); }

    public native int getNumLevels();
    public native void setNumLevels(int numLevels);

    public native double getPyrScale();
    public native void setPyrScale(double pyrScale);

    public native @Cast("bool") boolean getFastPyramids();
    public native void setFastPyramids(@Cast("bool") boolean fastPyramids);

    public native int getWinSize();
    public native void setWinSize(int winSize);

    public native int getNumIters();
    public native void setNumIters(int numIters);

    public native int getPolyN();
    public native void setPolyN(int polyN);

    public native double getPolySigma();
    public native void setPolySigma(double polySigma);

    public native int getFlags();
    public native void setFlags(int flags);

    public static native @Ptr FarnebackOpticalFlow create(
                int numLevels/*=5*/,
                double pyrScale/*=0.5*/,
                @Cast("bool") boolean fastPyramids/*=false*/,
                int winSize/*=13*/,
                int numIters/*=10*/,
                int polyN/*=5*/,
                double polySigma/*=1.1*/,
                int flags/*=0*/);
    public static native @Ptr FarnebackOpticalFlow create();
}
