// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Checks a tensor for NaN and Inf values.
 * 
 *  When run, reports an {@code InvalidArgument} error if {@code tensor} has any values
 *  that are not a number (NaN) or infinity (Inf). Otherwise, passes {@code tensor} as-is.
 * 
 *  Arguments:
 *  * scope: A Scope object
 *  * message: Prefix of the error message.
 * 
 *  Returns:
 *  * {@code Output}: The output tensor. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class CheckNumerics extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CheckNumerics(Pointer p) { super(p); }

  public CheckNumerics(@Const @ByRef Scope scope, @ByVal Input tensor,
                @StringPiece BytePointer message) { super((Pointer)null); allocate(scope, tensor, message); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input tensor,
                @StringPiece BytePointer message);
  public CheckNumerics(@Const @ByRef Scope scope, @ByVal Input tensor,
                @StringPiece String message) { super((Pointer)null); allocate(scope, tensor, message); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input tensor,
                @StringPiece String message);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public native @ByRef Operation operation(); public native CheckNumerics operation(Operation setter);
  public native @ByRef Output output(); public native CheckNumerics output(Output setter);
}
