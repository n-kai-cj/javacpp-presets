// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.gandiva;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.gandiva.*;

/** \brief runtime config for gandiva
 * 
 *  It contains elements to customize gandiva execution
 *  at run time. */
@Namespace("gandiva") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.gandiva.class)
public class Configuration extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Configuration(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public Configuration(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public Configuration position(long position) {
        return (Configuration)super.position(position);
    }
    @Override public Configuration getPointer(long i) {
        return new Configuration((Pointer)this).position(position + i);
    }


  public Configuration() { super((Pointer)null); allocate(); }
  private native void allocate();
  public Configuration(@Cast("bool") boolean optimize) { super((Pointer)null); allocate(optimize); }
  private native void allocate(@Cast("bool") boolean optimize);

  public native @Cast("std::size_t") long Hash();
  public native @Cast("bool") @Name("operator ==") boolean equals(@Const @ByRef Configuration other);
  public native @Cast("bool") @Name("operator !=") boolean notEquals(@Const @ByRef Configuration other);

  public native @Cast("bool") boolean optimize();
  public native void set_optimize(@Cast("bool") boolean optimize);
}
