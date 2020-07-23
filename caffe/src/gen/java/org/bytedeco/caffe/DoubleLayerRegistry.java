// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

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


@Name("caffe::LayerRegistry<double>") @Properties(inherit = org.bytedeco.caffe.presets.caffe.class)
public class DoubleLayerRegistry extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DoubleLayerRegistry(Pointer p) { super(p); }

  public static class Creator extends FunctionPointer {
      static { Loader.load(); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public    Creator(Pointer p) { super(p); }
      protected Creator() { allocate(); }
      private native void allocate();
      public native @Cast({"", "boost::shared_ptr<caffe::Layer<double> >"}) @SharedPtr @ByVal DoubleLayer call(@Const @ByRef LayerParameter arg0);
  }

  public static native @Cast("caffe::LayerRegistry<double>::CreatorRegistry*") @ByRef DoubleRegistry Registry();

  // Adds a creator.
  public static native void AddCreator(@StdString BytePointer type, Creator creator);
  public static native void AddCreator(@StdString String type, Creator creator);

  // Get a layer using a LayerParameter.
  public static native @Cast({"", "boost::shared_ptr<caffe::Layer<double> >"}) @SharedPtr @ByVal DoubleLayer CreateLayer(@Const @ByRef LayerParameter param);

  public static native @ByVal StringVector LayerTypeList();
}
