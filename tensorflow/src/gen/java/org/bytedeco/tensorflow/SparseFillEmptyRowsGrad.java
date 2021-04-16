// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** The gradient of SparseFillEmptyRows.
 * 
 *  Takes vectors reverse_index_map, shaped {@code [N]}, and grad_values,
 *  shaped {@code [N_full]}, where {@code N_full >= N} and copies data into either
 *  {@code d_values} or {@code d_default_value}.  Here {@code d_values} is shaped {@code [N]} and
 *  {@code d_default_value} is a scalar.
 * 
 *    d_values[j] = grad_values[reverse_index_map[j]]
 *    d_default_value = sum_{k : 0 .. N_full - 1} (
 *       grad_values[k] * 1{k not in reverse_index_map})
 * 
 *  Arguments:
 *  * scope: A Scope object
 *  * reverse_index_map: 1-D.  The reverse index map from SparseFillEmptyRows.
 *  * grad_values: 1-D.  The gradients from backprop.
 * 
 *  Returns:
 *  * {@code Output} d_values: 1-D.  The backprop into values.
 *  * {@code Output} d_default_value: 0-D.  The backprop into default_value. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class SparseFillEmptyRowsGrad extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SparseFillEmptyRowsGrad(Pointer p) { super(p); }

  public SparseFillEmptyRowsGrad(@Const @ByRef Scope scope, @ByVal Input reverse_index_map, @ByVal Input grad_values) { super((Pointer)null); allocate(scope, reverse_index_map, grad_values); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input reverse_index_map, @ByVal Input grad_values);

  public native @ByRef Operation operation(); public native SparseFillEmptyRowsGrad operation(Operation setter);
  public native @ByRef Output d_values(); public native SparseFillEmptyRowsGrad d_values(Output setter);
  public native @ByRef Output d_default_value(); public native SparseFillEmptyRowsGrad d_default_value(Output setter);
}
