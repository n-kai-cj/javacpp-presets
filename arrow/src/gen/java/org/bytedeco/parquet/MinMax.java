// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.parquet;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.parquet.*;


@Namespace("parquet::internal") @Properties(inherit = org.bytedeco.arrow.presets.parquet.class)
public class MinMax extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public MinMax() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public MinMax(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MinMax(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public MinMax position(long position) {
        return (MinMax)super.position(position);
    }
    @Override public MinMax getPointer(long i) {
        return new MinMax(this).position(position + i);
    }

  public native short min(); public native MinMax min(short setter);
  public native short max(); public native MinMax max(short setter);
}
