// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.parquet;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.parquet.*;


// Data encodings. Mirrors parquet::Encoding
@Namespace("parquet") @Properties(inherit = org.bytedeco.arrow.presets.parquet.class)
public class Encoding extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public Encoding() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public Encoding(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Encoding(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public Encoding position(long position) {
        return (Encoding)super.position(position);
    }
    @Override public Encoding getPointer(long i) {
        return new Encoding(this).position(position + i);
    }

  public enum type {
    PLAIN(0),
    PLAIN_DICTIONARY(2),
    RLE(3),
    BIT_PACKED(4),
    DELTA_BINARY_PACKED(5),
    DELTA_LENGTH_BYTE_ARRAY(6),
    DELTA_BYTE_ARRAY(7),
    RLE_DICTIONARY(8),
    BYTE_STREAM_SPLIT(9),
    // Should always be last element (except UNKNOWN)
    UNDEFINED(10),
    UNKNOWN(999);

      public final int value;
      private type(int v) { this.value = v; }
      private type(type e) { this.value = e.value; }
      public type intern() { for (type e : values()) if (e.value == value) return e; return this; }
      @Override public String toString() { return intern().name(); }
  }
}
