// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.gsl;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;

import static org.bytedeco.gsl.global.gsl.*;


@Properties(inherit = org.bytedeco.gsl.presets.gsl.class)
public class gsl_multifit_robust_type extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public gsl_multifit_robust_type() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public gsl_multifit_robust_type(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public gsl_multifit_robust_type(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public gsl_multifit_robust_type position(long position) {
        return (gsl_multifit_robust_type)super.position(position);
    }
    @Override public gsl_multifit_robust_type getPointer(long i) {
        return new gsl_multifit_robust_type((Pointer)this).position(position + i);
    }

  public native @Cast("const char*") BytePointer name(); public native gsl_multifit_robust_type name(BytePointer setter);     /* method name */
  public static class Wfun_gsl_vector_gsl_vector extends FunctionPointer {
      static { Loader.load(); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public    Wfun_gsl_vector_gsl_vector(Pointer p) { super(p); }
      protected Wfun_gsl_vector_gsl_vector() { allocate(); }
      private native void allocate();
      public native int call(@Const gsl_vector r, gsl_vector w);
  }
  public native Wfun_gsl_vector_gsl_vector wfun(); public native gsl_multifit_robust_type wfun(Wfun_gsl_vector_gsl_vector setter);
  public static class Psi_deriv_gsl_vector_gsl_vector extends FunctionPointer {
      static { Loader.load(); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public    Psi_deriv_gsl_vector_gsl_vector(Pointer p) { super(p); }
      protected Psi_deriv_gsl_vector_gsl_vector() { allocate(); }
      private native void allocate();
      public native int call(@Const gsl_vector r, gsl_vector dpsi);
  }
  public native Psi_deriv_gsl_vector_gsl_vector psi_deriv(); public native gsl_multifit_robust_type psi_deriv(Psi_deriv_gsl_vector_gsl_vector setter);
  public native double tuning_default(); public native gsl_multifit_robust_type tuning_default(double setter); /* default tuning constant */
}
