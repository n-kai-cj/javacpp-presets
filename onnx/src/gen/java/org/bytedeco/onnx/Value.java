// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.onnx;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.onnx.global.onnx.*;



@Namespace("onnx") @NoOffset @Properties(inherit = org.bytedeco.onnx.presets.onnx.class)
public class Value extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Value(Pointer p) { super(p); }

  
  
  public Value(Node node_, @Cast("size_t") long offset_) { super((Pointer)null); allocate(node_, offset_); }
  private native void allocate(Node node_, @Cast("size_t") long offset_);
  public native Value setElemType(@Cast("int32_t") int elem_type);
  public native @Cast("int32_t") int elemType();
  public native @Cast("bool") boolean has_sizes();
  public native Value setSizes(@StdVector DimensionIR sizes);
  public native @StdVector DimensionIR sizes();
  public native @Cast("size_t") long unique();
  public native @Cast("bool") boolean has_unique_name();
  public native @StdString BytePointer uniqueName();
  public native Value setUniqueName(@StdString BytePointer name);
  public native Value setUniqueName(@StdString String name);
  public native Value setStage(@Cast("size_t") long s);
  public native @Cast("size_t") long stage();
  public native Node node();
  public native @Cast("size_t") long offset();
  public native Graph owningGraph();
  // TODO: make this more const correct
  public native @StdVector Use uses();

  // Replaces all uses of this node with 'newValue'.
  //
  // Given:   %3 = f(%1, %2)
  //          %4 = g(%3)
  //          %5 = h(%3, %3)
  // Execute: %3.replaceAllUsesWith(%6)
  // Result:  %3 = f(%1, %2)
  //          %4 = g(%6)
  //          %5 = h(%6, %6)
  public native void replaceAllUsesWith(Value newValue);

  public native Value copyMetadata(Value from);

}
