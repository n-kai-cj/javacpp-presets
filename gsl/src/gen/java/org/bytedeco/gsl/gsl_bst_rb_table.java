// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.gsl;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;

import static org.bytedeco.gsl.global.gsl.*;


/* red-black tree data structure */
@Properties(inherit = org.bytedeco.gsl.presets.gsl.class)
public class gsl_bst_rb_table extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public gsl_bst_rb_table() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public gsl_bst_rb_table(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public gsl_bst_rb_table(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public gsl_bst_rb_table position(long position) {
        return (gsl_bst_rb_table)super.position(position);
    }
    @Override public gsl_bst_rb_table getPointer(long i) {
        return new gsl_bst_rb_table((Pointer)this).position(position + i);
    }

  public native gsl_bst_rb_node rb_root(); public native gsl_bst_rb_table rb_root(gsl_bst_rb_node setter);   /* tree's root */
  public native gsl_bst_cmp_function rb_compare(); public native gsl_bst_rb_table rb_compare(gsl_bst_cmp_function setter);  /* comparison function */
  public native Pointer rb_param(); public native gsl_bst_rb_table rb_param(Pointer setter);                    /* extra argument to |rb_compare| */
  public native @Const gsl_bst_allocator rb_alloc(); public native gsl_bst_rb_table rb_alloc(gsl_bst_allocator setter); /* memory allocator */
  public native @Cast("size_t") long rb_count(); public native gsl_bst_rb_table rb_count(long setter);                   /* number of items in tree */
  public native @Cast("unsigned long") long rb_generation(); public native gsl_bst_rb_table rb_generation(long setter);       /* generation number */
}
