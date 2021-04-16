// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.caffe;

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

import static org.bytedeco.caffe.global.caffe.*;
  // namespace internal

// #if PROTOBUF_USE_EXCEPTIONS
@Namespace("google::protobuf") @NoOffset @Properties(inherit = org.bytedeco.caffe.presets.caffe.class)
public class FatalException extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FatalException(Pointer p) { super(p); }

  public FatalException(@Cast("const char*") BytePointer filename, int line, @StdString BytePointer message) { super((Pointer)null); allocate(filename, line, message); }
  private native void allocate(@Cast("const char*") BytePointer filename, int line, @StdString BytePointer message);
  public FatalException(String filename, int line, @StdString String message) { super((Pointer)null); allocate(filename, line, message); }
  private native void allocate(String filename, int line, @StdString String message);

  public native @Cast("const char*") BytePointer what();

  public native @Cast("const char*") BytePointer filename();
  public native int line();
  public native @StdString BytePointer message();
}
