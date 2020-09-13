// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.onnx;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.onnx.global.onnx.*;


// Exception class used for handling errors in type and shape inference

@Namespace("onnx") @NoOffset @Properties(inherit = org.bytedeco.onnx.presets.onnx.class)
public class InferenceError extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public InferenceError(Pointer p) { super(p); }


  public InferenceError(@StdString BytePointer message) { super((Pointer)null); allocate(message); }
  private native void allocate(@StdString BytePointer message);
  public InferenceError(@StdString String message) { super((Pointer)null); allocate(message); }
  private native void allocate(@StdString String message);

  public native @NoException @Cast("const char*") BytePointer what();

  public native void AppendContext(@StdString BytePointer context);
  public native void AppendContext(@StdString String context);
}
