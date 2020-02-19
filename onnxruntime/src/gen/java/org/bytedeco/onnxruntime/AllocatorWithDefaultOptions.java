// Targeted by JavaCPP version 1.5.3-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.onnxruntime;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.onnxruntime.global.onnxruntime.*;


@Namespace("Ort") @NoOffset @Properties(inherit = org.bytedeco.onnxruntime.presets.onnxruntime.class)
public class AllocatorWithDefaultOptions extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public AllocatorWithDefaultOptions(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public AllocatorWithDefaultOptions(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public AllocatorWithDefaultOptions position(long position) {
        return (AllocatorWithDefaultOptions)super.position(position);
    }

  public AllocatorWithDefaultOptions() { super((Pointer)null); allocate(); }
  private native void allocate();

  public native @Name("operator OrtAllocator*") OrtAllocator asOrtAllocator();

  public native Pointer Alloc(@Cast("size_t") long size);
  public native void Free(Pointer p);

  public native @Const OrtMemoryInfo GetInfo();
}
