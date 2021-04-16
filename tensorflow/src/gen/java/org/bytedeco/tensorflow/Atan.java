// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Computes the trignometric inverse tangent of x element-wise.
 * 
 *  The {@code tf.math.atan} operation returns the inverse of {@code tf.math.tan}, such that
 *  if {@code y = tf.math.tan(x)} then, {@code x = tf.math.atan(y)}.
 * 
 *  **Note**: The output of {@code tf.math.atan} will lie within the invertible range
 *  of tan, i.e (-pi/2, pi/2).
 * 
 *  For example:
 * 
 *  <pre>{@code python
 *  # Note: [1.047, 0.785] ~= [(pi/3), (pi/4)]
 *  x = tf.constant([1.047, 0.785])
 *  y = tf.math.tan(x) # [1.731261, 0.99920404]
 * 
 *  tf.math.atan(y) # [1.047, 0.785] = x
 *  }</pre>
 * 
 * 
 *  Arguments:
 *  * scope: A Scope object
 * 
 *  Returns:
 *  * {@code Output}: The y tensor. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class Atan extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Atan(Pointer p) { super(p); }

  public Atan(@Const @ByRef Scope scope, @ByVal Input x) { super((Pointer)null); allocate(scope, x); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input x);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public native @ByRef Operation operation(); public native Atan operation(Operation setter);
  public native @ByRef Output y(); public native Atan y(Output setter);
}
