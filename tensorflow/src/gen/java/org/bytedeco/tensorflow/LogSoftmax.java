// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Computes log softmax activations.
 * 
 *  For each batch {@code i} and class {@code j} we have
 * 
 *      logsoftmax[i, j] = logits[i, j] - log(sum(exp(logits[i])))
 * 
 *  Arguments:
 *  * scope: A Scope object
 *  * logits: 2-D with shape {@code [batch_size, num_classes]}.
 * 
 *  Returns:
 *  * {@code Output}: Same shape as {@code logits}. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class LogSoftmax extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LogSoftmax(Pointer p) { super(p); }

  public LogSoftmax(@Const @ByRef Scope scope, @ByVal Input logits) { super((Pointer)null); allocate(scope, logits); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input logits);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public native @ByRef Operation operation(); public native LogSoftmax operation(Operation setter);
  public native @ByRef Output logsoftmax(); public native LogSoftmax logsoftmax(Output setter);
}
