// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Bitcasts a tensor from one type to another without copying data.
 * 
 *  Given a tensor {@code input}, this operation returns a tensor that has the same buffer
 *  data as {@code input} with datatype {@code type}.
 * 
 *  If the input datatype {@code T} is larger than the output datatype {@code type} then the
 *  shape changes from [...] to [..., sizeof({@code T})/sizeof({@code type})].
 * 
 *  If {@code T} is smaller than {@code type}, the operator requires that the rightmost
 *  dimension be equal to sizeof({@code type})/sizeof({@code T}). The shape then goes from
 *  [..., sizeof({@code type})/sizeof({@code T})] to [...].
 * 
 *  tf.bitcast() and tf.cast() work differently when real dtype is casted as a complex dtype
 *  (e.g. tf.complex64 or tf.complex128) as tf.cast() make imaginary part 0 while tf.bitcast()
 *  gives module error.
 *  For example,
 * 
 *  Example 1:
 *  <pre>{@code python
 *  >>> a = [1., 2., 3.]
 *  >>> equality_bitcast = tf.bitcast(a,tf.complex128)
 *  tensorflow.python.framework.errors_impl.InvalidArgumentError: Cannot bitcast from float to complex128: shape [3] [Op:Bitcast]
 *  >>> equality_cast = tf.cast(a,tf.complex128)
 *  >>> print(equality_cast)
 *  tf.Tensor([1.+0.j 2.+0.j 3.+0.j], shape=(3,), dtype=complex128)
 *  }</pre>
 *  Example 2:
 *  <pre>{@code python
 *  >>> tf.bitcast(tf.constant(0xffffffff, dtype=tf.uint32), tf.uint8)
 *  <tf.Tensor: ... shape=(4,), dtype=uint8, numpy=array([255, 255, 255, 255], dtype=uint8)>
 *  }</pre>
 *  Example 3:
 *  <pre>{@code python
 *  >>> x = [1., 2., 3.]
 *  >>> y = [0., 2., 3.]
 *  >>> equality= tf.equal(x,y)
 *  >>> equality_cast = tf.cast(equality,tf.float32)
 *  >>> equality_bitcast = tf.bitcast(equality_cast,tf.uint8)
 *  >>> print(equality)
 *  tf.Tensor([False True True], shape=(3,), dtype=bool)
 *  >>> print(equality_cast)
 *  tf.Tensor([0. 1. 1.], shape=(3,), dtype=float32)
 *  >>> print(equality_bitcast)
 *  tf.Tensor(
 *  [[ 0 0 0 0]
 *   [ 0 0 128 63]
 *   [ 0 0 128 63]], shape=(3, 4), dtype=uint8)
 *  }</pre>
 * 
 *  *NOTE*: Bitcast is implemented as a low-level cast, so machines with different
 *  endian orderings will give different results.
 * 
 *  Arguments:
 *  * scope: A Scope object
 * 
 *  Returns:
 *  * {@code Output}: The output tensor. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class Bitcast extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Bitcast(Pointer p) { super(p); }

  public Bitcast(@Const @ByRef Scope scope, @ByVal Input input, @Cast("tensorflow::DataType") int type) { super((Pointer)null); allocate(scope, input, type); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input input, @Cast("tensorflow::DataType") int type);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public native @ByRef Operation operation(); public native Bitcast operation(Operation setter);
  public native @ByRef Output output(); public native Bitcast output(Output setter);
}
