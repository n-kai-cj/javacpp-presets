// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Represents the value of one dimension in a TensorShape. */
@Namespace("tensorflow") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class TensorShapeDim extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TensorShapeDim(Pointer p) { super(p); }

  public TensorShapeDim(@Cast("tensorflow::int64") long s) { super((Pointer)null); allocate(s); }
  private native void allocate(@Cast("tensorflow::int64") long s);
  public native @Cast("tensorflow::int64") long size(); public native TensorShapeDim size(long setter);
}
