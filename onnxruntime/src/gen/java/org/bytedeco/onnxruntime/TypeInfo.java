// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.onnxruntime;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.opencl.*;
import static org.bytedeco.opencl.global.OpenCL.*;
import org.bytedeco.dnnl.*;
import static org.bytedeco.dnnl.global.dnnl.*;

import static org.bytedeco.onnxruntime.global.onnxruntime.*;


@Namespace("Ort") @Properties(inherit = org.bytedeco.onnxruntime.presets.onnxruntime.class)
public class TypeInfo extends BaseTypeInfo {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TypeInfo(Pointer p) { super(p); }

  public TypeInfo(OrtTypeInfo p) { super((Pointer)null); allocate(p); }
  private native void allocate(OrtTypeInfo p);

  public native @ByVal UnownedTensorTypeAndShapeInfo GetTensorTypeAndShapeInfo();
  public native @ByVal UnownedSequenceTypeInfo GetSequenceTypeInfo();
  public native @ByVal UnownedMapTypeInfo GetMapTypeInfo();

  public native @Cast("ONNXType") int GetONNXType();
}
