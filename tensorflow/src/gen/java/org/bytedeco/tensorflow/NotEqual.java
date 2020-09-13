// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Returns the truth value of (x != y) element-wise.
 * 
 *  *NOTE*: {@code NotEqual} supports broadcasting. More about broadcasting
 *  [here](http://docs.scipy.org/doc/numpy/user/basics.broadcasting.html)
 * 
 *  Arguments:
 *  * scope: A Scope object
 * 
 *  Returns:
 *  * {@code Output}: The z tensor. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class NotEqual extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public NotEqual(Pointer p) { super(p); }

  /** Optional attribute setters for NotEqual */
  public static class Attrs extends Pointer {
      static { Loader.load(); }
      /** Default native constructor. */
      public Attrs() { super((Pointer)null); allocate(); }
      /** Native array allocator. Access with {@link Pointer#position(long)}. */
      public Attrs(long size) { super((Pointer)null); allocateArray(size); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public Attrs(Pointer p) { super(p); }
      private native void allocate();
      private native void allocateArray(long size);
      @Override public Attrs position(long position) {
          return (Attrs)super.position(position);
      }
      @Override public Attrs getPointer(long i) {
          return new Attrs(this).position(position + i);
      }
  
    /** Defaults to true */
    public native @ByVal Attrs IncompatibleShapeError(@Cast("bool") boolean x);

    public native @Cast("bool") boolean incompatible_shape_error_(); public native Attrs incompatible_shape_error_(boolean setter);
  }
  public NotEqual(@Const @ByRef Scope scope, @ByVal Input x,
           @ByVal Input y) { super((Pointer)null); allocate(scope, x, y); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input x,
           @ByVal Input y);
  public NotEqual(@Const @ByRef Scope scope, @ByVal Input x,
           @ByVal Input y, @Const @ByRef Attrs attrs) { super((Pointer)null); allocate(scope, x, y, attrs); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input x,
           @ByVal Input y, @Const @ByRef Attrs attrs);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public static native @ByVal Attrs IncompatibleShapeError(@Cast("bool") boolean x);

  public native @ByRef Operation operation(); public native NotEqual operation(Operation setter);
  public native @ByRef Output z(); public native NotEqual z(Output setter);
}
