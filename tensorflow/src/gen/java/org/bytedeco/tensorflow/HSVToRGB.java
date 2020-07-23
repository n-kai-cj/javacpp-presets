// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Convert one or more images from HSV to RGB.
 * 
 *  Outputs a tensor of the same shape as the {@code images} tensor, containing the RGB
 *  value of the pixels. The output is only well defined if the value in {@code images}
 *  are in {@code [0,1]}.
 * 
 *  See {@code rgb_to_hsv} for a description of the HSV encoding.
 * 
 *  Arguments:
 *  * scope: A Scope object
 *  * images: 1-D or higher rank. HSV data to convert. Last dimension must be size 3.
 * 
 *  Returns:
 *  * {@code Output}: {@code images} converted to RGB. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class HSVToRGB extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public HSVToRGB(Pointer p) { super(p); }

  public HSVToRGB(@Const @ByRef Scope scope, @ByVal Input images) { super((Pointer)null); allocate(scope, images); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input images);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public native @ByRef Operation operation(); public native HSVToRGB operation(Operation setter);
  public native @ByRef Output output(); public native HSVToRGB output(Output setter);
}
