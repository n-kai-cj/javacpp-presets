// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_text;

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
import org.bytedeco.opencv.opencv_dnn.*;
import static org.bytedeco.opencv.global.opencv_dnn.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import org.bytedeco.opencv.opencv_videoio.*;
import static org.bytedeco.opencv.global.opencv_videoio.*;
import org.bytedeco.opencv.opencv_highgui.*;
import static org.bytedeco.opencv.global.opencv_highgui.*;
import org.bytedeco.opencv.opencv_flann.*;
import static org.bytedeco.opencv.global.opencv_flann.*;
import org.bytedeco.opencv.opencv_features2d.*;
import static org.bytedeco.opencv.global.opencv_features2d.*;
import org.bytedeco.opencv.opencv_ml.*;
import static org.bytedeco.opencv.global.opencv_ml.*;

import static org.bytedeco.opencv.global.opencv_text.*;


//base class BaseOCR declares a common API that would be used in a typical text recognition scenario
@Namespace("cv::text") @Properties(inherit = org.bytedeco.opencv.presets.opencv_text.class)
public class BaseOCR extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public BaseOCR(Pointer p) { super(p); }

    public native void run(@ByRef Mat image, @StdString @ByRef BytePointer output_text, RectVector component_rects/*=NULL*/,
                         StringVector component_texts/*=NULL*/, FloatVector component_confidences/*=NULL*/,
                         int component_level/*=0*/);
    public native void run(@ByRef Mat image, @StdString @ByRef BytePointer output_text);
    public native void run(@ByRef Mat image, @ByRef Mat mask, @StdString @ByRef BytePointer output_text, RectVector component_rects/*=NULL*/,
                         StringVector component_texts/*=NULL*/, FloatVector component_confidences/*=NULL*/,
                         int component_level/*=0*/);
    public native void run(@ByRef Mat image, @ByRef Mat mask, @StdString @ByRef BytePointer output_text);
}
