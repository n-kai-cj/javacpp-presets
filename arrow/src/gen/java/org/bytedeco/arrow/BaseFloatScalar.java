// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


@Name("arrow::NumericScalar<arrow::FloatType>") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class BaseFloatScalar extends Scalar {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public BaseFloatScalar(Pointer p) { super(p); }


  public BaseFloatScalar(@Cast("arrow::NumericScalar<arrow::FloatType>::ValueType") float value) { super((Pointer)null); allocate(value); }
  private native void allocate(@Cast("arrow::NumericScalar<arrow::FloatType>::ValueType") float value);

  public BaseFloatScalar() { super((Pointer)null); allocate(); }
  private native void allocate();
}
