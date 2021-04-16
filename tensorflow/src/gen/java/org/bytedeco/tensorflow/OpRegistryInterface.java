// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


// Users that want to look up an OpDef by type name should take an
// OpRegistryInterface.  Functions accepting a
// (const) OpRegistryInterface* may call LookUp() from multiple threads.
@Namespace("tensorflow") @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class OpRegistryInterface extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public OpRegistryInterface(Pointer p) { super(p); }


  // Returns an error status and sets *op_reg_data to nullptr if no OpDef is
  // registered under that name, otherwise returns the registered OpDef.
  // Caller must not delete the returned pointer.
  public native @ByVal Status LookUp(@StdString BytePointer op_type_name,
                          @Cast("const tensorflow::OpRegistrationData**") PointerPointer op_reg_data);
  public native @ByVal Status LookUp(@StdString BytePointer op_type_name,
                          @Const @ByPtrPtr OpRegistrationData op_reg_data);
  public native @ByVal Status LookUp(@StdString String op_type_name,
                          @Const @ByPtrPtr OpRegistrationData op_reg_data);

  // Shorthand for calling LookUp to get the OpDef.
  public native @ByVal Status LookUpOpDef(@StdString BytePointer op_type_name, @Cast("const tensorflow::OpDef**") PointerPointer op_def);
  public native @ByVal Status LookUpOpDef(@StdString BytePointer op_type_name, @Const @ByPtrPtr OpDef op_def);
  public native @ByVal Status LookUpOpDef(@StdString String op_type_name, @Const @ByPtrPtr OpDef op_def);
}
