// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Extract the shape information of a JPEG-encoded image.
 * 
 *  This op only parses the image header, so it is much faster than DecodeJpeg.
 * 
 *  Arguments:
 *  * scope: A Scope object
 *  * contents: 0-D. The JPEG-encoded image.
 * 
 *  Optional attributes (see {@code Attrs}):
 *  * output_type: (Optional) The output type of the operation (int32 or int64).
 *  Defaults to int32.
 * 
 *  Returns:
 *  * {@code Output}: 1-D. The image shape with format [height, width, channels]. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class ExtractJpegShape extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ExtractJpegShape(Pointer p) { super(p); }

  /** Optional attribute setters for ExtractJpegShape */
  public static class Attrs extends Pointer {
      static { Loader.load(); }
      /** Default native constructor. */
      public Attrs() { super((Pointer)null); allocate(); }
      /** Native array allocator. Access with {@link Pointer#position(long)}. */
      public Attrs(long size) { super((Pointer)null); allocateArray(size); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public Attrs(Pointer p) { super(p); }
      private native void allocate();
      private native void allocateArray(long size);
      @Override public Attrs position(long position) {
          return (Attrs)super.position(position);
      }
      @Override public Attrs getPointer(long i) {
          return new Attrs((Pointer)this).position(position + i);
      }
  
    /** (Optional) The output type of the operation (int32 or int64).
     *  Defaults to int32.
     * 
     *  Defaults to DT_INT32 */
    public native @ByVal Attrs OutputType(@Cast("tensorflow::DataType") int x);

    public native @Cast("tensorflow::DataType") int output_type_(); public native Attrs output_type_(int setter);
  }
  public ExtractJpegShape(@Const @ByRef Scope scope, @ByVal Input contents) { super((Pointer)null); allocate(scope, contents); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input contents);
  public ExtractJpegShape(@Const @ByRef Scope scope, @ByVal Input contents, @Const @ByRef Attrs attrs) { super((Pointer)null); allocate(scope, contents, attrs); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input contents, @Const @ByRef Attrs attrs);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public static native @ByVal Attrs OutputType(@Cast("tensorflow::DataType") int x);

  public native @ByRef Operation operation(); public native ExtractJpegShape operation(Operation setter);
  public native @ByRef Output image_shape(); public native ExtractJpegShape image_shape(Output setter);
}
