// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


@Namespace("tensorflow") @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class ServerFactory extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ServerFactory(Pointer p) { super(p); }

  // Creates a new server based on the given `server_def`, and stores
  // it in `*out_server`. Returns OK on success, otherwise returns an
  // error.
  public native @ByVal Status NewServer(@Const @ByRef ServerDef server_def,
                             @UniquePtr ServerInterface out_server);

  // Returns true if and only if this factory can create a server
  // based on the given `server_def`.
  public native @Cast("bool") boolean AcceptsOptions(@Const @ByRef ServerDef server_def);

  // For each `ServerFactory` subclass, an instance of that class must
  // be registered by calling this method.
  //
  // The `server_type` must be unique to the server factory.
  public static native void Register(@StdString BytePointer server_type, ServerFactory factory);
  public static native void Register(@StdString String server_type, ServerFactory factory);

  // Looks up a factory that can create a server based on the given
  // `server_def`, and stores it in `*out_factory`. Returns OK on
  // success, otherwise returns an error.
  public static native @ByVal Status GetFactory(@Const @ByRef ServerDef server_def,
                             @Cast("tensorflow::ServerFactory**") PointerPointer out_factory);
  public static native @ByVal Status GetFactory(@Const @ByRef ServerDef server_def,
                             @ByPtrPtr ServerFactory out_factory);
}
