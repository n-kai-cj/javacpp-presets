// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


@Namespace("arrow::io") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class ReadRange extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public ReadRange() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public ReadRange(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ReadRange(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public ReadRange position(long position) {
        return (ReadRange)super.position(position);
    }

  public native @Cast("int64_t") long offset(); public native ReadRange offset(long setter);
  public native @Cast("int64_t") long length(); public native ReadRange length(long setter);

  
  

  public native @Cast("bool") boolean Contains(@Const @ByRef ReadRange other);
}
