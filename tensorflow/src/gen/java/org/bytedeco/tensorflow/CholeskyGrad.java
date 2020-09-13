// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Computes the reverse mode backpropagated gradient of the Cholesky algorithm.
 * 
 *  For an explanation see "Differentiation of the Cholesky algorithm" by
 *  Iain Murray http://arxiv.org/abs/1602.07527.
 * 
 *  Arguments:
 *  * scope: A Scope object
 *  * l: Output of batch Cholesky algorithm l = cholesky(A). Shape is {@code [..., M, M]}.
 *  Algorithm depends only on lower triangular part of the innermost matrices of
 *  this tensor.
 *  * grad: df/dl where f is some scalar function. Shape is {@code [..., M, M]}.
 *  Algorithm depends only on lower triangular part of the innermost matrices of
 *  this tensor.
 * 
 *  Returns:
 *  * {@code Output}: Symmetrized version of df/dA . Shape is {@code [..., M, M]} */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class CholeskyGrad extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CholeskyGrad(Pointer p) { super(p); }

  public CholeskyGrad(@Const @ByRef Scope scope, @ByVal Input l,
               @ByVal Input grad) { super((Pointer)null); allocate(scope, l, grad); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input l,
               @ByVal Input grad);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public native @ByRef Operation operation(); public native CholeskyGrad operation(Operation setter);
  public native @ByRef Output output(); public native CholeskyGrad output(Output setter);
}
