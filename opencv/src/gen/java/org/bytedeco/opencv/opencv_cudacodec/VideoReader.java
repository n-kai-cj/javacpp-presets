// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_cudacodec;

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

import static org.bytedeco.opencv.global.opencv_cudacodec.*;


/** \brief Video reader interface.
<p>
\note
   -   An example on how to use the videoReader class can be found at
        opencv_source_code/samples/gpu/video_reader.cpp
 */
@Name("cv::cudacodec::VideoReader") @Properties(inherit = org.bytedeco.opencv.presets.opencv_cudacodec.class)
public class VideoReader extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public VideoReader(Pointer p) { super(p); }


    /** \brief Grabs, decodes and returns the next video frame.
    <p>
    If no frames has been grabbed (there are no more frames in video file), the methods return false .
    The method throws Exception if error occurs.
     */
    public native @Cast("bool") boolean nextFrame(@ByRef GpuMat frame, @ByRef(nullValue = "cv::cuda::Stream::Null()") Stream stream);
    public native @Cast("bool") boolean nextFrame(@ByRef GpuMat frame);

    /** \brief Returns information about video file format.
    */
    public native @ByVal FormatInfo format();
}
