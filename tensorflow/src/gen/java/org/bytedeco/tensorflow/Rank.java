// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Returns the rank of a tensor.
 * 
 *  This operation returns an integer representing the rank of {@code input}.
 * 
 *  For example:
 * 
 *  <pre>{@code
 *  # 't' is [[[1, 1, 1], [2, 2, 2]], [[3, 3, 3], [4, 4, 4]]]
 *  # shape of tensor 't' is [2, 2, 3]
 *  rank(t) ==> 3
 *  }</pre>
 * 
 *  **Note**: The rank of a tensor is not the same as the rank of a matrix. The rank
 *  of a tensor is the number of indices required to uniquely select each element
 *  of the tensor. Rank is also known as "order", "degree", or "ndims."
 * 
 *  Arguments:
 *  * scope: A Scope object
 * 
 *  Returns:
 *  * {@code Output}: The output tensor. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class Rank extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Rank(Pointer p) { super(p); }

  public Rank(@Const @ByRef Scope scope, @ByVal Input input) { super((Pointer)null); allocate(scope, input); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input input);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public native @ByRef Operation operation(); public native Rank operation(Operation setter);
  public native @ByRef Output output(); public native Rank output(Output setter);
}
