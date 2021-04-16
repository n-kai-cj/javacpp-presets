// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;

@Name("arrow::NumericArray<arrow::UInt16Type>") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class UInt16Array extends PrimitiveArray {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public UInt16Array(Pointer p) { super(p); }


  public UInt16Array(@SharedPtr @Cast({"", "std::shared_ptr<arrow::ArrayData>"}) ArrayData data) { super((Pointer)null); allocate(data); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::ArrayData>"}) ArrayData data);

  // Only enable this constructor without a type argument for types without additional
  // metadata

  public native @Cast("const arrow::NumericArray<arrow::UInt16Type>::value_type*") ShortPointer raw_values();

  public native @Cast("arrow::NumericArray<arrow::UInt16Type>::value_type") short Value(@Cast("int64_t") long i);

  // For API compatibility with BinaryArray etc.
  public native @Cast("arrow::NumericArray<arrow::UInt16Type>::value_type") short GetView(@Cast("int64_t") long i);

  public native @ByVal @Cast("arrow::NumericArray<arrow::UInt16Type>::IteratorType*") Pointer begin();

  public native @ByVal @Cast("arrow::NumericArray<arrow::UInt16Type>::IteratorType*") Pointer end();
}
