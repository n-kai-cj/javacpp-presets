// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.gsl;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;

import static org.bytedeco.gsl.global.gsl.*;

// #else
// #endif

@Properties(inherit = org.bytedeco.gsl.presets.gsl.class)
public class gsl_vector_ushort extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public gsl_vector_ushort() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public gsl_vector_ushort(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public gsl_vector_ushort(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public gsl_vector_ushort position(long position) {
        return (gsl_vector_ushort)super.position(position);
    }

  public native @Cast("size_t") long size(); public native gsl_vector_ushort size(long setter);
  public native @Cast("size_t") long stride(); public native gsl_vector_ushort stride(long setter);
  public native @Cast("unsigned short*") ShortPointer data(); public native gsl_vector_ushort data(ShortPointer setter);
  public native gsl_block_ushort block(); public native gsl_vector_ushort block(gsl_block_ushort setter);
  public native int owner(); public native gsl_vector_ushort owner(int setter);
}
