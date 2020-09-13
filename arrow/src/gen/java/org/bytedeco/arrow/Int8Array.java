// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** Concrete Array class for numeric data. */
@Name("arrow::NumericArray<arrow::Int8Type>") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class Int8Array extends PrimitiveArray {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Int8Array(Pointer p) { super(p); }


  public Int8Array(@SharedPtr @Cast({"", "std::shared_ptr<arrow::ArrayData>"}) ArrayData data) { super((Pointer)null); allocate(data); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::ArrayData>"}) ArrayData data);

  // Only enable this constructor without a type argument for types without additional
  // metadata

  public native @Cast("const arrow::NumericArray<arrow::Int8Type>::value_type*") BytePointer raw_values();

  public native @Cast("arrow::NumericArray<arrow::Int8Type>::value_type") byte Value(@Cast("int64_t") long i);

  // For API compatibility with BinaryArray etc.
  public native @Cast("arrow::NumericArray<arrow::Int8Type>::value_type") byte GetView(@Cast("int64_t") long i);
}
