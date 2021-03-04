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


@Properties(inherit = org.bytedeco.onnxruntime.presets.onnxruntime.class)
public class OrtApiBase extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public OrtApiBase() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public OrtApiBase(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public OrtApiBase(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public OrtApiBase position(long position) {
        return (OrtApiBase)super.position(position);
    }
    @Override public OrtApiBase getPointer(long i) {
        return new OrtApiBase((Pointer)this).position(position + i);
    }

  public static class GetApi_int extends FunctionPointer {
      static { Loader.load(); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public    GetApi_int(Pointer p) { super(p); }
      protected GetApi_int() { allocate(); }
      private native void allocate();
      public native @Const OrtApi call(@Cast("uint32_t") int version);
  }
  public native GetApi_int GetApi(); public native OrtApiBase GetApi(GetApi_int setter);  // Pass in ORT_API_VERSION
  // nullptr will be returned if the version is unsupported, for example when using a runtime older than this header file

  public static class BytePointer_GetVersionString extends FunctionPointer {
      static { Loader.load(); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public    BytePointer_GetVersionString(Pointer p) { super(p); }
      protected BytePointer_GetVersionString() { allocate(); }
      private native void allocate();
      public native @Cast("const char*") BytePointer call();
  }
  public native BytePointer_GetVersionString GetVersionString(); public native OrtApiBase GetVersionString(BytePointer_GetVersionString setter);
}
