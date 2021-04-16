// Targeted by JavaCPP version 1.5.6-SNAPSHOT: DO NOT EDIT THIS FILE

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

@Name("Ort::Base<OrtTensorTypeAndShapeInfo>") @NoOffset @Properties(inherit = org.bytedeco.onnxruntime.presets.onnxruntime.class)
public class BaseTensorTypeAndShapeInfo extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public BaseTensorTypeAndShapeInfo(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public BaseTensorTypeAndShapeInfo(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public BaseTensorTypeAndShapeInfo position(long position) {
        return (BaseTensorTypeAndShapeInfo)super.position(position);
    }
    @Override public BaseTensorTypeAndShapeInfo getPointer(long i) {
        return new BaseTensorTypeAndShapeInfo((Pointer)this).position(position + i);
    }


  public BaseTensorTypeAndShapeInfo() { super((Pointer)null); allocate(); }
  private native void allocate();
  public BaseTensorTypeAndShapeInfo(OrtTensorTypeAndShapeInfo p) { super((Pointer)null); allocate(p); }
  private native void allocate(OrtTensorTypeAndShapeInfo p);

  public native @Name("operator OrtTensorTypeAndShapeInfo*") OrtTensorTypeAndShapeInfo asOrtTensorTypeAndShapeInfo();

  public native OrtTensorTypeAndShapeInfo release();
}
