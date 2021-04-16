// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


@Namespace("arrow") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class BaseBinaryScalar extends Scalar {
    static { Loader.load(); }

  
  
    public BaseBinaryScalar(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type) { super((Pointer)null); allocate(type); }
    private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type);
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public BaseBinaryScalar(Pointer p) { super(p); }


  public native @SharedPtr ArrowBuffer value(); public native BaseBinaryScalar value(ArrowBuffer setter);
}
