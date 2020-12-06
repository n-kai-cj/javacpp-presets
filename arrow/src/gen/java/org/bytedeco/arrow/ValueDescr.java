// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief A descriptor type that gives the shape (array or scalar) and
 *  DataType of a Value, but without the data */
@Namespace("arrow") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class ValueDescr extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ValueDescr(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public ValueDescr(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public ValueDescr position(long position) {
        return (ValueDescr)super.position(position);
    }
    @Override public ValueDescr getPointer(long i) {
        return new ValueDescr(this).position(position + i);
    }

  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type(); public native ValueDescr type(DataType setter);
  public enum Shape {
    /** \brief Either Array or Scalar */
    ANY(0),

    /** \brief Array type */
    ARRAY(1),

    /** \brief Only Scalar arguments supported */
    SCALAR(2);

      public final int value;
      private Shape(int v) { this.value = v; }
      private Shape(Shape e) { this.value = e.value; }
      public Shape intern() { for (Shape e : values()) if (e.value == value) return e; return this; }
      @Override public String toString() { return intern().name(); }
  }

  public native Shape shape(); public native ValueDescr shape(Shape setter);

  public ValueDescr() { super((Pointer)null); allocate(); }
  private native void allocate();

  public ValueDescr(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, Shape shape) { super((Pointer)null); allocate(type, shape); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, Shape shape);
  public ValueDescr(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @Cast("arrow::ValueDescr::Shape") int shape) { super((Pointer)null); allocate(type, shape); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @Cast("arrow::ValueDescr::Shape") int shape);

  public ValueDescr(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type) { super((Pointer)null); allocate(type); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type);

  /** \brief Convenience constructor for ANY descr */
  public static native @ByVal ValueDescr Any(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type);

  /** \brief Convenience constructor for Value::ARRAY descr */
  public static native @ByVal ValueDescr Array(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type);

  /** \brief Convenience constructor for Value::SCALAR descr */
  public static native @ByVal ValueDescr Scalar(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type);

  public native @Cast("bool") @Name("operator ==") boolean equals(@Const @ByRef ValueDescr other);

  public native @Cast("bool") @Name("operator !=") boolean notEquals(@Const @ByRef ValueDescr other);

  public native @StdString String ToString();
}
