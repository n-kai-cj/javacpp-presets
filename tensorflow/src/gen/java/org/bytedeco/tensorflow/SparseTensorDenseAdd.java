// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Adds up a {@code SparseTensor} and a dense {@code Tensor}, producing a dense {@code Tensor}.
 * 
 *  This Op does not require {@code a_indices} be sorted in standard lexicographic order.
 * 
 *  Arguments:
 *  * scope: A Scope object
 *  * a_indices: 2-D.  The {@code indices} of the {@code SparseTensor}, with shape {@code [nnz, ndims]}.
 *  * a_values: 1-D.  The {@code values} of the {@code SparseTensor}, with shape {@code [nnz]}.
 *  * a_shape: 1-D.  The {@code shape} of the {@code SparseTensor}, with shape {@code [ndims]}.
 *  * b: {@code ndims}-D Tensor.  With shape {@code a_shape}.
 * 
 *  Returns:
 *  * {@code Output}: The output tensor. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class SparseTensorDenseAdd extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SparseTensorDenseAdd(Pointer p) { super(p); }

  public SparseTensorDenseAdd(@Const @ByRef Scope scope, @ByVal Input a_indices, @ByVal Input a_values,
                       @ByVal Input a_shape, @ByVal Input b) { super((Pointer)null); allocate(scope, a_indices, a_values, a_shape, b); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input a_indices, @ByVal Input a_values,
                       @ByVal Input a_shape, @ByVal Input b);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public native @ByRef Operation operation(); public native SparseTensorDenseAdd operation(Operation setter);
  public native @ByRef Output output(); public native SparseTensorDenseAdd output(Output setter);
}
