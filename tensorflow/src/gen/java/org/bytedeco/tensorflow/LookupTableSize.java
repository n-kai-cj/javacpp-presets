// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Computes the number of elements in the given table.
 * 
 *  Arguments:
 *  * scope: A Scope object
 *  * table_handle: Handle to the table.
 * 
 *  Returns:
 *  * {@code Output}: Scalar that contains number of elements in the table. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class LookupTableSize extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LookupTableSize(Pointer p) { super(p); }

  public LookupTableSize(@Const @ByRef Scope scope, @ByVal Input table_handle) { super((Pointer)null); allocate(scope, table_handle); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input table_handle);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public native @ByRef Operation operation(); public native LookupTableSize operation(Operation setter);
  public native @ByRef Output size(); public native LookupTableSize size(Output setter);
}
