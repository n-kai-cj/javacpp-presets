// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Computes scaled exponential linear: {@code scale * alpha * (exp(features) - 1)}
 * 
 *  if < 0, {@code scale * features} otherwise.
 * 
 *  To be used together with
 *  {@code initializer = tf.variance_scaling_initializer(factor=1.0, mode='FAN_IN')}.
 *  For correct dropout, use {@code tf.contrib.nn.alpha_dropout}.
 * 
 *  See [Self-Normalizing Neural Networks](https://arxiv.org/abs/1706.02515)
 * 
 *  Arguments:
 *  * scope: A Scope object
 * 
 *  Returns:
 *  * {@code Output}: The activations tensor. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class Selu extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Selu(Pointer p) { super(p); }

  public Selu(@Const @ByRef Scope scope, @ByVal Input features) { super((Pointer)null); allocate(scope, features); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input features);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public native @ByRef Operation operation(); public native Selu operation(Operation setter);
  public native @ByRef Output activations(); public native Selu activations(Output setter);
}
