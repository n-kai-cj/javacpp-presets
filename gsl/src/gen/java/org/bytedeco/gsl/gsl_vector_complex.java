// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

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
public class gsl_vector_complex extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public gsl_vector_complex() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public gsl_vector_complex(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public gsl_vector_complex(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public gsl_vector_complex position(long position) {
        return (gsl_vector_complex)super.position(position);
    }
    @Override public gsl_vector_complex getPointer(long i) {
        return new gsl_vector_complex(this).position(position + i);
    }

  public native @Cast("size_t") long size(); public native gsl_vector_complex size(long setter);
  public native @Cast("size_t") long stride(); public native gsl_vector_complex stride(long setter);
  public native DoublePointer data(); public native gsl_vector_complex data(DoublePointer setter);
  public native gsl_block_complex block(); public native gsl_vector_complex block(gsl_block_complex setter);
  public native int owner(); public native gsl_vector_complex owner(int setter);
}
