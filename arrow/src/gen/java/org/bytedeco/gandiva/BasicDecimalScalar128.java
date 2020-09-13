// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.gandiva;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.gandiva.*;


/** Represents a 128-bit decimal value along with its precision and scale. */
@Namespace("gandiva") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.gandiva.class)
public class BasicDecimalScalar128 extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public BasicDecimalScalar128(Pointer p) { super(p); }

  public BasicDecimalScalar128(@Cast("int64_t") long high_bits, @Cast("uint64_t") long low_bits, int precision,
                                    int scale) { super((Pointer)null); allocate(high_bits, low_bits, precision, scale); }
  private native void allocate(@Cast("int64_t") long high_bits, @Cast("uint64_t") long low_bits, int precision,
                                    int scale);

  public BasicDecimalScalar128(@Const @ByRef BasicDecimal128 value, int precision,
                                    int scale) { super((Pointer)null); allocate(value, precision, scale); }
  private native void allocate(@Const @ByRef BasicDecimal128 value, int precision,
                                    int scale);

  public BasicDecimalScalar128(int precision, int scale) { super((Pointer)null); allocate(precision, scale); }
  private native void allocate(int precision, int scale);

  public native int scale();

  public native int precision();

  public native @Const @ByRef BasicDecimal128 value();
}
