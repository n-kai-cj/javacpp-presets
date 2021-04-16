// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.gsl;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;

import static org.bytedeco.gsl.global.gsl.*;


@Name("gsl_odeiv2_step_struct") @Properties(inherit = org.bytedeco.gsl.presets.gsl.class)
public class gsl_odeiv2_step extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public gsl_odeiv2_step() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public gsl_odeiv2_step(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public gsl_odeiv2_step(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public gsl_odeiv2_step position(long position) {
        return (gsl_odeiv2_step)super.position(position);
    }
    @Override public gsl_odeiv2_step getPointer(long i) {
        return new gsl_odeiv2_step((Pointer)this).position(position + i);
    }

  public native @Const gsl_odeiv2_step_type type(); public native gsl_odeiv2_step type(gsl_odeiv2_step_type setter);
  public native @Cast("size_t") long dimension(); public native gsl_odeiv2_step dimension(long setter);
  public native Pointer state(); public native gsl_odeiv2_step state(Pointer setter);
}
