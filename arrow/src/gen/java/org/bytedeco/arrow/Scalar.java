// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief Base class for scalar values
 * 
 *  A Scalar represents a single value with a specific DataType.
 *  Scalars are useful for passing single value inputs to compute functions,
 *  or for representing individual array elements (with a non-trivial
 *  wrapping cost, though). */
@Namespace("arrow") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class Scalar extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Scalar(Pointer p) { super(p); }


  /** \brief The type of the scalar value */
  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type(); public native Scalar type(DataType setter);

  /** \brief Whether the value is valid (not null) or not */
  public native @Cast("bool") boolean is_valid(); public native Scalar is_valid(boolean setter);
  public native @Cast("bool") boolean Equals(@Const @ByRef Scalar other);

  public static class Hash extends Pointer {
      static { Loader.load(); }
      /** Default native constructor. */
      public Hash() { super((Pointer)null); allocate(); }
      /** Native array allocator. Access with {@link Pointer#position(long)}. */
      public Hash(long size) { super((Pointer)null); allocateArray(size); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public Hash(Pointer p) { super(p); }
      private native void allocate();
      private native void allocateArray(long size);
      @Override public Hash position(long position) {
          return (Hash)super.position(position);
      }
      @Override public Hash getPointer(long i) {
          return new Hash(this).position(position + i);
      }
  
    public native @Cast("size_t") @Name("operator ()") long apply(@Const @ByRef Scalar scalar);

    public static native @Cast("size_t") long hash(@Const @ByRef Scalar scalar);
  }

  public native @StdString String ToString();

  // TODO(bkietz) add compute::CastOptions
  public native @ByVal ScalarResult CastTo(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType to);
}
