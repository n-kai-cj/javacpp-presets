// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Makes a copy of {@code x}.
 * 
 *  Arguments:
 *  * scope: A Scope object
 *  * x: The source tensor of type {@code T}.
 * 
 *  Returns:
 *  * {@code Output}:     y: A {@code Tensor} of type {@code T}. A copy of {@code x}. Guaranteed that {@code y}
 *        is not an alias of {@code x}. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class DeepCopy extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DeepCopy(Pointer p) { super(p); }

  public DeepCopy(@Const @ByRef Scope scope, @ByVal Input x) { super((Pointer)null); allocate(scope, x); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input x);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public native @ByRef Operation operation(); public native DeepCopy operation(Operation setter);
  public native @ByRef Output y(); public native DeepCopy y(Output setter);
}
