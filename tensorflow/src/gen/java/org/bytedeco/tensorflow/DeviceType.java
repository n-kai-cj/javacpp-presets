// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


// A DeviceType is just a string, but we wrap it up in a class to give
// some type checking as we're passing these around
@Namespace("tensorflow") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class DeviceType extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DeviceType(Pointer p) { super(p); }

  public DeviceType(@Cast("const char*") BytePointer type) { super((Pointer)null); allocate(type); }
  private native void allocate(@Cast("const char*") BytePointer type);
  public DeviceType(String type) { super((Pointer)null); allocate(type); }
  private native void allocate(String type);

  public native @Cast("const char*") BytePointer type();
  public native @StdString BytePointer type_string();

  public native @Cast("bool") @Name("operator <") boolean lessThan(@Const @ByRef DeviceType other);
  public native @Cast("bool") @Name("operator ==") boolean equals(@Const @ByRef DeviceType other);
  public native @Cast("bool") @Name("operator !=") boolean notEquals(@Const @ByRef DeviceType other);
}
