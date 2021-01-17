// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_video;

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
import org.bytedeco.opencv.opencv_dnn.*;
import static org.bytedeco.opencv.global.opencv_dnn.*;

import static org.bytedeco.opencv.global.opencv_video.*;


/** \brief K-nearest neighbours - based Background/Foreground Segmentation Algorithm.
<p>
The class implements the K-nearest neighbours background subtraction described in \cite Zivkovic2006 .
Very efficient if number of foreground pixels is low.
 */
@Namespace("cv") @Properties(inherit = org.bytedeco.opencv.presets.opencv_video.class)
public class BackgroundSubtractorKNN extends BackgroundSubtractor {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public BackgroundSubtractorKNN(Pointer p) { super(p); }

    /** \brief Returns the number of last frames that affect the background model
    */
    public native int getHistory();
    /** \brief Sets the number of last frames that affect the background model
    */
    public native void setHistory(int history);

    /** \brief Returns the number of data samples in the background model
    */
    public native int getNSamples();
    /** \brief Sets the number of data samples in the background model.
    <p>
    The model needs to be reinitalized to reserve memory.
    */
    public native void setNSamples(int _nN);//needs reinitialization!

    /** \brief Returns the threshold on the squared distance between the pixel and the sample
    <p>
    The threshold on the squared distance between the pixel and the sample to decide whether a pixel is
    close to a data sample.
     */
    public native double getDist2Threshold();
    /** \brief Sets the threshold on the squared distance
    */
    public native void setDist2Threshold(double _dist2Threshold);

    /** \brief Returns the number of neighbours, the k in the kNN.
    <p>
    K is the number of samples that need to be within dist2Threshold in order to decide that that
    pixel is matching the kNN background model.
     */
    public native int getkNNSamples();
    /** \brief Sets the k in the kNN. How many nearest neighbours need to match.
    */
    public native void setkNNSamples(int _nkNN);

    /** \brief Returns the shadow detection flag
    <p>
    If true, the algorithm detects shadows and marks them. See createBackgroundSubtractorKNN for
    details.
     */
    public native @Cast("bool") boolean getDetectShadows();
    /** \brief Enables or disables shadow detection
    */
    public native void setDetectShadows(@Cast("bool") boolean detectShadows);

    /** \brief Returns the shadow value
    <p>
    Shadow value is the value used to mark shadows in the foreground mask. Default value is 127. Value 0
    in the mask always means background, 255 means foreground.
     */
    public native int getShadowValue();
    /** \brief Sets the shadow value
    */
    public native void setShadowValue(int value);

    /** \brief Returns the shadow threshold
    <p>
    A shadow is detected if pixel is a darker version of the background. The shadow threshold (Tau in
    the paper) is a threshold defining how much darker the shadow can be. Tau= 0.5 means that if a pixel
    is more than twice darker then it is not shadow. See Prati, Mikic, Trivedi and Cucchiara,
    *Detecting Moving Shadows...*, IEEE PAMI,2003.
     */
    public native double getShadowThreshold();
    /** \brief Sets the shadow threshold
     */
    public native void setShadowThreshold(double threshold);
}
