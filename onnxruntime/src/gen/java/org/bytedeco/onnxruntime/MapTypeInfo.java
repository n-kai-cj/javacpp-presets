// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.onnxruntime;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.dnnl.*;
import static org.bytedeco.dnnl.global.dnnl.*;

import static org.bytedeco.onnxruntime.global.onnxruntime.*;


@Namespace("Ort") @Properties(inherit = org.bytedeco.onnxruntime.presets.onnxruntime.class)
public class MapTypeInfo extends BaseMapTypeInfo {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MapTypeInfo(Pointer p) { super(p); }

  public MapTypeInfo(OrtMapTypeInfo p) { super((Pointer)null); allocate(p); }
  private native void allocate(OrtMapTypeInfo p);

  public native @Cast("ONNXTensorElementDataType") int GetMapKeyType();
  public native @ByVal TypeInfo GetMapValueType();
}
