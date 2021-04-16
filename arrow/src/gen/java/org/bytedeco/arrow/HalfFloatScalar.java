// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


@Namespace("arrow") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class HalfFloatScalar extends BaseHalfFloatScalar {
    static { Loader.load(); }

  
  
    public HalfFloatScalar(@Cast("arrow::NumericScalar<arrow::HalfFloatType>::ValueType") short value) { super((Pointer)null); allocate(value); }
    private native void allocate(@Cast("arrow::NumericScalar<arrow::HalfFloatType>::ValueType") short value);
  
    public HalfFloatScalar() { super((Pointer)null); allocate(); }
    private native void allocate();
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public HalfFloatScalar(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public HalfFloatScalar(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public HalfFloatScalar position(long position) {
        return (HalfFloatScalar)super.position(position);
    }
    @Override public HalfFloatScalar getPointer(long i) {
        return new HalfFloatScalar((Pointer)this).position(position + i);
    }

}
