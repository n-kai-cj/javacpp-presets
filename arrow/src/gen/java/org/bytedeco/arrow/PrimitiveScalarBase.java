// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \} */

@Namespace("arrow::internal") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class PrimitiveScalarBase extends Scalar {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public PrimitiveScalarBase(Pointer p) { super(p); }

  public native Pointer mutable_data();
  public native @Const Pointer data();
}
