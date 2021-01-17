// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.openpose;

import org.bytedeco.javacpp.annotation.Index;
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
import org.bytedeco.hdf5.*;
import static org.bytedeco.hdf5.global.hdf5.*;
import org.bytedeco.caffe.*;
import static org.bytedeco.caffe.global.caffe.*;

import static org.bytedeco.openpose.global.openpose.*;

    /**
     * Producer is an abstract class to extract frames from a source (image directory, video file,
     * webcam stream, etc.). It has the basic and common functions (e.g., getFrame, release & isOpened).
     */
    @Namespace("op") @NoOffset @Properties(inherit = org.bytedeco.openpose.presets.openpose.class)
public class Producer extends Pointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public Producer(Pointer p) { super(p); }
    
        /**
         * Constructor of Producer.
         */

        /**
         * Destructor of Producer. It is virtual so that any children class can implement
         * its own destructor.
         */

        /**
         * Main function of Producer, it retrieves and returns a new frame from the frames producer.
         * @return Mat with the new frame.
         */
        public native @ByVal Matrix getFrame();

        /**
         * Analogous to getFrame, but it could return > 1 frame.
         * @return std::vector<Mat> with the new frame(s).
         */
        public native @StdVector Matrix getFrames();

        /**
         * It retrieves and returns the camera matrixes from the frames producer.
         * Virtual class because FlirReader implements their own.
         * @return std::vector<Mat> with the camera matrices.
         */
        public native @StdVector Matrix getCameraMatrices();

        /**
         * It retrieves and returns the camera extrinsic parameters from the frames producer.
         * Virtual class because FlirReader implements their own.
         * @return std::vector<Mat> with the camera extrinsic parameters.
         */
        public native @StdVector Matrix getCameraExtrinsics();

        /**
         * It retrieves and returns the camera intrinsic parameters from the frames producer.
         * Virtual class because FlirReader implements their own.
         * @return std::vector<Mat> with the camera intrinsic parameters.
         */
        public native @StdVector Matrix getCameraIntrinsics();

        /**
         * This function returns a unique frame name (e.g., the frame number for video, the
         * frame counter for webcam, the image name for image directory reader, etc.).
         * @return std::string with an unique frame name.
         */
        public native @StdString BytePointer getNextFrameName();

        /**
         * This function sets whether the producer must keep the original fps frame rate or extract the frames as quick
         * as possible.
         * @param fpsMode ProducerFpsMode parameter specifying the new value.
         */
        public native void setProducerFpsMode(ProducerFpsMode fpsMode);

        /**
         * This function returns the type of producer (video, webcam, ...).
         * @return ProducerType with the kind of producer.
         */
        public native ProducerType getType();

        /**
         * This function returns whether the Producer instance is still opened and able
         * to retrieve more frames.
         * @return bool indicating whether the Producer is opened.
         */
        public native @Cast("bool") boolean isOpened();

        /**
         * This function releases and closes the Producer. After it is called, no more frames
         * can be retrieved from Producer::getFrames.
         */
        public native void release();

        /**
         * This function is a wrapper of cv::VideoCapture::get. It allows getting different properties
         * of the Producer (fps, width, height, etc.). See the OpenCV documentation for all the
         * available properties.
         * @param capProperty int indicating the property to be modified.
         * @return double returning the property value.
         */
        public native double get(int capProperty);

        /**
         * This function is a wrapper of cv::VideoCapture::set. It allows setting different properties
         * of the Producer (fps, width, height, etc.). See the OpenCV documentation for all the
         * available properties.
         * @param capProperty int indicating the property to be modified.
         * @param value double indicating the new value to be assigned.
         */
        public native void set(int capProperty, double value);

        /**
         * Extra attributes that VideoCapture::get/set do not contain.
         * @param property ProducerProperty indicating the property to be modified.
         */
        public native double get(ProducerProperty property);

        /**
         * Extra attributes that VideoCapture::get/set do not contain.
         * @param property ProducerProperty indicating the property to be modified.
         * @param value double indicating the new value to be assigned.
         */
        public native void set(ProducerProperty property, double value);
    }
