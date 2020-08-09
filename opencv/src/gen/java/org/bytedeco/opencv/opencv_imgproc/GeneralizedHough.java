// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_imgproc;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_core.*;

import static org.bytedeco.opencv.global.opencv_imgproc.*;


/** \brief finds arbitrary template in the grayscale image using Generalized Hough Transform
*/
@Namespace("cv") @Properties(inherit = org.bytedeco.opencv.presets.opencv_imgproc.class)
public class GeneralizedHough extends Algorithm {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public GeneralizedHough(Pointer p) { super(p); }

    /** set template to search */
    public native void setTemplate(@ByVal Mat templ, @ByVal(nullValue = "cv::Point(-1, -1)") Point templCenter);
    public native void setTemplate(@ByVal Mat templ);
    public native void setTemplate(@ByVal UMat templ, @ByVal(nullValue = "cv::Point(-1, -1)") Point templCenter);
    public native void setTemplate(@ByVal UMat templ);
    public native void setTemplate(@ByVal GpuMat templ, @ByVal(nullValue = "cv::Point(-1, -1)") Point templCenter);
    public native void setTemplate(@ByVal GpuMat templ);
    public native void setTemplate(@ByVal Mat edges, @ByVal Mat dx, @ByVal Mat dy, @ByVal(nullValue = "cv::Point(-1, -1)") Point templCenter);
    public native void setTemplate(@ByVal Mat edges, @ByVal Mat dx, @ByVal Mat dy);
    public native void setTemplate(@ByVal UMat edges, @ByVal UMat dx, @ByVal UMat dy, @ByVal(nullValue = "cv::Point(-1, -1)") Point templCenter);
    public native void setTemplate(@ByVal UMat edges, @ByVal UMat dx, @ByVal UMat dy);
    public native void setTemplate(@ByVal GpuMat edges, @ByVal GpuMat dx, @ByVal GpuMat dy, @ByVal(nullValue = "cv::Point(-1, -1)") Point templCenter);
    public native void setTemplate(@ByVal GpuMat edges, @ByVal GpuMat dx, @ByVal GpuMat dy);

    /** find template on image */
    public native void detect(@ByVal Mat image, @ByVal Mat positions, @ByVal(nullValue = "cv::OutputArray(cv::noArray())") Mat votes);
    public native void detect(@ByVal Mat image, @ByVal Mat positions);
    public native void detect(@ByVal UMat image, @ByVal UMat positions, @ByVal(nullValue = "cv::OutputArray(cv::noArray())") UMat votes);
    public native void detect(@ByVal UMat image, @ByVal UMat positions);
    public native void detect(@ByVal GpuMat image, @ByVal GpuMat positions, @ByVal(nullValue = "cv::OutputArray(cv::noArray())") GpuMat votes);
    public native void detect(@ByVal GpuMat image, @ByVal GpuMat positions);
    public native void detect(@ByVal Mat edges, @ByVal Mat dx, @ByVal Mat dy, @ByVal Mat positions, @ByVal(nullValue = "cv::OutputArray(cv::noArray())") Mat votes);
    public native void detect(@ByVal Mat edges, @ByVal Mat dx, @ByVal Mat dy, @ByVal Mat positions);
    public native void detect(@ByVal UMat edges, @ByVal UMat dx, @ByVal UMat dy, @ByVal UMat positions, @ByVal(nullValue = "cv::OutputArray(cv::noArray())") UMat votes);
    public native void detect(@ByVal UMat edges, @ByVal UMat dx, @ByVal UMat dy, @ByVal UMat positions);
    public native void detect(@ByVal GpuMat edges, @ByVal GpuMat dx, @ByVal GpuMat dy, @ByVal GpuMat positions, @ByVal(nullValue = "cv::OutputArray(cv::noArray())") GpuMat votes);
    public native void detect(@ByVal GpuMat edges, @ByVal GpuMat dx, @ByVal GpuMat dy, @ByVal GpuMat positions);

    /** Canny low threshold. */
    public native void setCannyLowThresh(int cannyLowThresh);
    public native int getCannyLowThresh();

    /** Canny high threshold. */
    public native void setCannyHighThresh(int cannyHighThresh);
    public native int getCannyHighThresh();

    /** Minimum distance between the centers of the detected objects. */
    public native void setMinDist(double minDist);
    public native double getMinDist();

    /** Inverse ratio of the accumulator resolution to the image resolution. */
    public native void setDp(double dp);
    public native double getDp();

    /** Maximal size of inner buffers. */
    public native void setMaxBufferSize(int maxBufferSize);
    public native int getMaxBufferSize();
}
