// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Computes the matrix square root of one or more square matrices:
 * 
 *  matmul(sqrtm(A), sqrtm(A)) = A
 * 
 *  The input matrix should be invertible. If the input matrix is real, it should
 *  have no eigenvalues which are real and negative (pairs of complex conjugate
 *  eigenvalues are allowed).
 * 
 *  The matrix square root is computed by first reducing the matrix to
 *  quasi-triangular form with the real Schur decomposition. The square root
 *  of the quasi-triangular matrix is then computed directly. Details of
 *  the algorithm can be found in: Nicholas J. Higham, "Computing real
 *  square roots of a real matrix", Linear Algebra Appl., 1987.
 * 
 *  The input is a tensor of shape {@code [..., M, M]} whose inner-most 2 dimensions
 *  form square matrices. The output is a tensor of the same shape as the input
 *  containing the matrix square root for all input submatrices {@code [..., :, :]}.
 * 
 *  Arguments:
 *  * scope: A Scope object
 *  * input: Shape is {@code [..., M, M]}.
 * 
 *  Returns:
 *  * {@code Output}: Shape is {@code [..., M, M]}.
 * 
 *  \compatibility(scipy)
 *  Equivalent to scipy.linalg.sqrtm
 *  \end_compatibility */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class MatrixSquareRoot extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MatrixSquareRoot(Pointer p) { super(p); }

  public MatrixSquareRoot(@Const @ByRef Scope scope, @ByVal Input input) { super((Pointer)null); allocate(scope, input); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input input);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public native @ByRef Operation operation(); public native MatrixSquareRoot operation(Operation setter);
  public native @ByRef Output output(); public native MatrixSquareRoot output(Output setter);
}
