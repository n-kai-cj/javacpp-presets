// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


// These internal APIs may change without warning or deprecation

// Intermediate data structure with metadata header, and zero or more buffers
// for the message body.
@Namespace("arrow::ipc::internal") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class IpcPayload extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public IpcPayload() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public IpcPayload(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IpcPayload(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public IpcPayload position(long position) {
        return (IpcPayload)super.position(position);
    }

  public native Message.Type type(); public native IpcPayload type(Message.Type setter);
  public native @SharedPtr ArrowBuffer metadata(); public native IpcPayload metadata(ArrowBuffer setter);
  public native @ByRef BufferVector body_buffers(); public native IpcPayload body_buffers(BufferVector setter);
  public native @Cast("int64_t") long body_length(); public native IpcPayload body_length(long setter);
}
