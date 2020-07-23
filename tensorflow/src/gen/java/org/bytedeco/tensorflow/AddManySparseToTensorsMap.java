// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** \defgroup sparse_ops Sparse Ops
 *  \{
 <p>
 *  Add an {@code N}-minibatch {@code SparseTensor} to a {@code SparseTensorsMap}, return {@code N} handles.
 * 
 *  A {@code SparseTensor} of rank {@code R} is represented by three tensors: {@code sparse_indices},
 *  {@code sparse_values}, and {@code sparse_shape}, where
 * 
 *  <pre>{@code sparse_indices.shape[1] == sparse_shape.shape[0] == R}</pre>
 * 
 *  An {@code N}-minibatch of {@code SparseTensor} objects is represented as a {@code SparseTensor}
 *  having a first {@code sparse_indices} column taking values between {@code [0, N)}, where
 *  the minibatch size {@code N == sparse_shape[0]}.
 * 
 *  The input {@code SparseTensor} must have rank {@code R} greater than 1, and the first
 *  dimension is treated as the minibatch dimension.  Elements of the {@code SparseTensor}
 *  must be sorted in increasing order of this first dimension.  The stored
 *  {@code SparseTensor} objects pointed to by each row of the output {@code sparse_handles}
 *  will have rank {@code R-1}.
 * 
 *  The {@code SparseTensor} values can then be read out as part of a minibatch by passing
 *  the given keys as vector elements to {@code TakeManySparseFromTensorsMap}.  To ensure
 *  the correct {@code SparseTensorsMap} is accessed, ensure that the same
 *  {@code container} and {@code shared_name} are passed to that Op.  If no {@code shared_name}
 *  is provided here, instead use the *name* of the Operation created by calling
 *  {@code AddManySparseToTensorsMap} as the {@code shared_name} passed to
 *  {@code TakeManySparseFromTensorsMap}.  Ensure the Operations are colocated.
 * 
 *  Arguments:
 *  * scope: A Scope object
 *  * sparse_indices: 2-D.  The {@code indices} of the minibatch {@code SparseTensor}.
 *  {@code sparse_indices[:, 0]} must be ordered values in {@code [0, N)}.
 *  * sparse_values: 1-D.  The {@code values} of the minibatch {@code SparseTensor}.
 *  * sparse_shape: 1-D.  The {@code shape} of the minibatch {@code SparseTensor}.
 *  The minibatch size {@code N == sparse_shape[0]}.
 * 
 *  Optional attributes (see {@code Attrs}):
 *  * container: The container name for the {@code SparseTensorsMap} created by this op.
 *  * shared_name: The shared name for the {@code SparseTensorsMap} created by this op.
 *  If blank, the new Operation's unique name is used.
 * 
 *  Returns:
 *  * {@code Output}: 1-D.  The handles of the {@code SparseTensor} now stored in the
 *  {@code SparseTensorsMap}.  Shape: {@code [N]}. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class AddManySparseToTensorsMap extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public AddManySparseToTensorsMap(Pointer p) { super(p); }

  /** Optional attribute setters for AddManySparseToTensorsMap */
  public static class Attrs extends Pointer {
      static { Loader.load(); }
      /** Default native constructor. */
      public Attrs() { super((Pointer)null); allocate(); }
      /** Native array allocator. Access with {@link Pointer#position(long)}. */
      public Attrs(long size) { super((Pointer)null); allocateArray(size); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public Attrs(Pointer p) { super(p); }
      private native void allocate();
      private native void allocateArray(long size);
      @Override public Attrs position(long position) {
          return (Attrs)super.position(position);
      }
  
    /** The container name for the {@code SparseTensorsMap} created by this op.
     * 
     *  Defaults to "" */
    
    ///
    public native @ByVal Attrs Container(@StringPiece BytePointer x);
    public native @ByVal Attrs Container(@StringPiece String x);

    /** The shared name for the {@code SparseTensorsMap} created by this op.
     *  If blank, the new Operation's unique name is used.
     * 
     *  Defaults to "" */
    public native @ByVal Attrs SharedName(@StringPiece BytePointer x);
    public native @ByVal Attrs SharedName(@StringPiece String x);

    public native @StringPiece BytePointer container_(); public native Attrs container_(BytePointer setter);
    public native @StringPiece BytePointer shared_name_(); public native Attrs shared_name_(BytePointer setter);
  }
  public AddManySparseToTensorsMap(@Const @ByRef Scope scope, @ByVal Input sparse_indices, @ByVal Input sparse_values,
                            @ByVal Input sparse_shape) { super((Pointer)null); allocate(scope, sparse_indices, sparse_values, sparse_shape); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input sparse_indices, @ByVal Input sparse_values,
                            @ByVal Input sparse_shape);
  public AddManySparseToTensorsMap(@Const @ByRef Scope scope, @ByVal Input sparse_indices, @ByVal Input sparse_values,
                            @ByVal Input sparse_shape, @Const @ByRef Attrs attrs) { super((Pointer)null); allocate(scope, sparse_indices, sparse_values, sparse_shape, attrs); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input sparse_indices, @ByVal Input sparse_values,
                            @ByVal Input sparse_shape, @Const @ByRef Attrs attrs);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public static native @ByVal Attrs Container(@StringPiece BytePointer x);
  public static native @ByVal Attrs Container(@StringPiece String x);
  public static native @ByVal Attrs SharedName(@StringPiece BytePointer x);
  public static native @ByVal Attrs SharedName(@StringPiece String x);

  public native @ByRef Operation operation(); public native AddManySparseToTensorsMap operation(Operation setter);
  public native @ByRef Output sparse_handles(); public native AddManySparseToTensorsMap sparse_handles(Output setter);
}
