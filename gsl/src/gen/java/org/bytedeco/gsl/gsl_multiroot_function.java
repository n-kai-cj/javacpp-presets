// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.gsl;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;

import static org.bytedeco.gsl.global.gsl.*;


/* Definition of vector-valued functions with parameters based on gsl_vector */

@Name("gsl_multiroot_function_struct") @Properties(inherit = org.bytedeco.gsl.presets.gsl.class)
public class gsl_multiroot_function extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public gsl_multiroot_function() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public gsl_multiroot_function(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public gsl_multiroot_function(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public gsl_multiroot_function position(long position) {
        return (gsl_multiroot_function)super.position(position);
    }
    @Override public gsl_multiroot_function getPointer(long i) {
        return new gsl_multiroot_function(this).position(position + i);
    }

  public static class F_gsl_vector_Pointer_gsl_vector extends FunctionPointer {
      static { Loader.load(); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public    F_gsl_vector_Pointer_gsl_vector(Pointer p) { super(p); }
      protected F_gsl_vector_Pointer_gsl_vector() { allocate(); }
      private native void allocate();
      public native int call(@Const gsl_vector x, Pointer params, gsl_vector f);
  }
  public native F_gsl_vector_Pointer_gsl_vector f(); public native gsl_multiroot_function f(F_gsl_vector_Pointer_gsl_vector setter);
  public native @Cast("size_t") long n(); public native gsl_multiroot_function n(long setter);
  public native Pointer params(); public native gsl_multiroot_function params(Pointer setter);
}
