// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.parquet;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.parquet.*;


// ----------------------------------------------------------------------

@Namespace("parquet") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.parquet.class)
public class ByteArray extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ByteArray(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public ByteArray(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public ByteArray position(long position) {
        return (ByteArray)super.position(position);
    }
    @Override public ByteArray getPointer(long i) {
        return new ByteArray(this).position(position + i);
    }

  public ByteArray() { super((Pointer)null); allocate(); }
  private native void allocate();
  public ByteArray(@Cast("uint32_t") int len, @Cast("const uint8_t*") BytePointer ptr) { super((Pointer)null); allocate(len, ptr); }
  private native void allocate(@Cast("uint32_t") int len, @Cast("const uint8_t*") BytePointer ptr);
  public ByteArray(@Cast("uint32_t") int len, @Cast("const uint8_t*") ByteBuffer ptr) { super((Pointer)null); allocate(len, ptr); }
  private native void allocate(@Cast("uint32_t") int len, @Cast("const uint8_t*") ByteBuffer ptr);
  public ByteArray(@Cast("uint32_t") int len, @Cast("const uint8_t*") byte[] ptr) { super((Pointer)null); allocate(len, ptr); }
  private native void allocate(@Cast("uint32_t") int len, @Cast("const uint8_t*") byte[] ptr);
  public native @Cast("uint32_t") int len(); public native ByteArray len(int setter);
  public native @Cast("const uint8_t*") BytePointer ptr(); public native ByteArray ptr(BytePointer setter);
}
