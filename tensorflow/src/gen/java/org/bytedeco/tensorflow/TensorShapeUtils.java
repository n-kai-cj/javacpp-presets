// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;

// END_SKIP_DOXYGEN

/** \brief Static helper routines for {@code TensorShape}. Includes a few common
 *  predicates on a tensor shape. */
@Namespace("tensorflow") @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class TensorShapeUtils extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public TensorShapeUtils() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public TensorShapeUtils(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TensorShapeUtils(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public TensorShapeUtils position(long position) {
        return (TensorShapeUtils)super.position(position);
    }

  public static native @Cast("bool") boolean IsScalar(@Const @ByRef TensorShape shape);

  public static native @Cast("bool") boolean IsVector(@Const @ByRef TensorShape shape);

  public static native @Cast("bool") boolean IsVectorOrHigher(@Const @ByRef TensorShape shape);

  public static native @Cast("bool") boolean IsMatrix(@Const @ByRef TensorShape shape);

  public static native @Cast("bool") boolean IsSquareMatrix(@Const @ByRef TensorShape shape);

  public static native @Cast("bool") boolean IsMatrixOrHigher(@Const @ByRef TensorShape shape);

  /** \brief Returns a {@code TensorShape} whose dimensions are
   *  {@code dims[0]}, {@code dims[1]}, ..., {@code dims[n-1]}. */
  public static native @ByVal Status MakeShape(@Const IntPointer dims, @Cast("tensorflow::int64") long n, TensorShape out);
  public static native @ByVal Status MakeShape(@Const IntBuffer dims, @Cast("tensorflow::int64") long n, TensorShape out);
  public static native @ByVal Status MakeShape(@Const int[] dims, @Cast("tensorflow::int64") long n, TensorShape out);
  public static native @ByVal Status MakeShape(@Cast("const tensorflow::int64*") LongPointer dims, @Cast("tensorflow::int64") long n, TensorShape out);
  public static native @ByVal Status MakeShape(@Cast("const tensorflow::int64*") LongBuffer dims, @Cast("tensorflow::int64") long n, TensorShape out);
  public static native @ByVal Status MakeShape(@Cast("const tensorflow::int64*") long[] dims, @Cast("tensorflow::int64") long n, TensorShape out);
  public static native @ByVal Status MakeShape(@ArraySlice IntPointer shape, TensorShape out);
  public static native @ByVal Status MakeShape(@ArraySlice IntBuffer shape, TensorShape out);
  public static native @ByVal Status MakeShape(@ArraySlice int[] shape, TensorShape out);
  public static native @ByVal Status MakeShape(@Cast("tensorflow::int64*") @ArraySlice LongPointer shape, TensorShape out);
  public static native @ByVal Status MakeShape(@Cast("tensorflow::int64*") @ArraySlice LongBuffer shape, TensorShape out);
  public static native @ByVal Status MakeShape(@Cast("tensorflow::int64*") @ArraySlice long[] shape, TensorShape out);
  public static native @ByVal Status MakeShape(@Const IntPointer dims, @Cast("tensorflow::int64") long n, PartialTensorShape out);
  public static native @ByVal Status MakeShape(@Const IntBuffer dims, @Cast("tensorflow::int64") long n, PartialTensorShape out);
  public static native @ByVal Status MakeShape(@Const int[] dims, @Cast("tensorflow::int64") long n, PartialTensorShape out);
  public static native @ByVal Status MakeShape(@Cast("const tensorflow::int64*") LongPointer dims, @Cast("tensorflow::int64") long n, PartialTensorShape out);
  public static native @ByVal Status MakeShape(@Cast("const tensorflow::int64*") LongBuffer dims, @Cast("tensorflow::int64") long n, PartialTensorShape out);
  public static native @ByVal Status MakeShape(@Cast("const tensorflow::int64*") long[] dims, @Cast("tensorflow::int64") long n, PartialTensorShape out);
  public static native @ByVal Status MakeShape(@ArraySlice IntPointer shape,
                            PartialTensorShape out);
  public static native @ByVal Status MakeShape(@ArraySlice IntBuffer shape,
                            PartialTensorShape out);
  public static native @ByVal Status MakeShape(@ArraySlice int[] shape,
                            PartialTensorShape out);
  public static native @ByVal Status MakeShape(@Cast("tensorflow::int64*") @ArraySlice LongPointer shape,
                            PartialTensorShape out);
  public static native @ByVal Status MakeShape(@Cast("tensorflow::int64*") @ArraySlice LongBuffer shape,
                            PartialTensorShape out);
  public static native @ByVal Status MakeShape(@Cast("tensorflow::int64*") @ArraySlice long[] shape,
                            PartialTensorShape out);

  public static native @StdString BytePointer ShapeListString(@Cast("const tensorflow::gtl::ArraySlice<tensorflow::TensorShape>*") @ByRef TensorShapeVector shapes);

  /** \brief Returns true iff {@code shape} starts with {@code prefix}. */
  public static native @Cast("bool") boolean StartsWith(@Const @ByRef TensorShape shape, @Const @ByRef TensorShape prefix);

  /** \brief Returns true iff {@code shape} ends with {@code suffix}. */
  public static native @Cast("bool") boolean EndsWith(@Const @ByRef TensorShape shape, @Const @ByRef TensorShape suffix);

  /** \brief Returns the product of values in an int64 array,
   *  or a failing Status if the array represents a value larger than
   *  a {@code TensorShape} can hold. */
  public static native @ByVal Status NumElements(@Cast("tensorflow::int64*") @ArraySlice LongPointer shape, @Cast("tensorflow::int64*") LongPointer num_elements);
  public static native @ByVal Status NumElements(@Cast("tensorflow::int64*") @ArraySlice LongBuffer shape, @Cast("tensorflow::int64*") LongBuffer num_elements);
  public static native @ByVal Status NumElements(@Cast("tensorflow::int64*") @ArraySlice long[] shape, @Cast("tensorflow::int64*") long... num_elements);
}
