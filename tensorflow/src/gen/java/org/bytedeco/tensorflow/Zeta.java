// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Compute the Hurwitz zeta function \(\zeta(x, q)\).
 * 
 *  The Hurwitz zeta function is defined as:
 * 
 * 
 *  \(\zeta(x, q) = \sum_{n=0}^{\infty} (q + n)^{-x}\)
 * 
 *  Arguments:
 *  * scope: A Scope object
 * 
 *  Returns:
 *  * {@code Output}: The z tensor. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class Zeta extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Zeta(Pointer p) { super(p); }

  public Zeta(@Const @ByRef Scope scope, @ByVal Input x,
       @ByVal Input q) { super((Pointer)null); allocate(scope, x, q); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input x,
       @ByVal Input q);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public native @ByRef Operation operation(); public native Zeta operation(Operation setter);
  public native @ByRef Output z(); public native Zeta z(Output setter);
}
