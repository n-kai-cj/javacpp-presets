// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief A container for key-value pair type metadata. Not thread-safe */
@Namespace("arrow") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class KeyValueMetadata extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public KeyValueMetadata(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public KeyValueMetadata(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public KeyValueMetadata position(long position) {
        return (KeyValueMetadata)super.position(position);
    }
    @Override public KeyValueMetadata getPointer(long i) {
        return new KeyValueMetadata(this).position(position + i);
    }

  public KeyValueMetadata() { super((Pointer)null); allocate(); }
  private native void allocate();
  public KeyValueMetadata(@ByVal StringVector keys, @ByVal StringVector values) { super((Pointer)null); allocate(keys, values); }
  private native void allocate(@ByVal StringVector keys, @ByVal StringVector values);
  public KeyValueMetadata(@Const @ByRef StringStringMap map) { super((Pointer)null); allocate(map); }
  private native void allocate(@Const @ByRef StringStringMap map);

  public native void ToUnorderedMap(StringStringMap out);
  public native void Append(@StdString String key, @StdString String value);
  public native void Append(@StdString BytePointer key, @StdString BytePointer value);

  public native @ByVal StringResult Get(@StdString String key);
  public native @ByVal StringResult Get(@StdString BytePointer key);
  public native @Cast("bool") boolean Contains(@StdString String key);
  public native @Cast("bool") boolean Contains(@StdString BytePointer key);
  // Note that deleting may invalidate known indices
  public native @ByVal Status Delete(@StdString String key);
  public native @ByVal Status Delete(@StdString BytePointer key);
  public native @ByVal Status Delete(@Cast("int64_t") long index);
  public native @ByVal Status DeleteMany(@Cast("int64_t*") @StdVector LongPointer indices);
  public native @ByVal Status DeleteMany(@Cast("int64_t*") @StdVector LongBuffer indices);
  public native @ByVal Status DeleteMany(@Cast("int64_t*") @StdVector long[] indices);
  public native @ByVal Status Set(@StdString String key, @StdString String value);
  public native @ByVal Status Set(@StdString BytePointer key, @StdString BytePointer value);

  public native void reserve(@Cast("int64_t") long n);

  public native @Cast("int64_t") long size();
  public native @StdString String key(@Cast("int64_t") long i);
  public native @StdString String value(@Cast("int64_t") long i);
  public native @Const @ByRef StringVector keys();
  public native @Const @ByRef StringVector values();

  public native @ByVal StringStringPairVector sorted_pairs();

  /** \brief Perform linear search for key, returning -1 if not found */
  public native int FindKey(@StdString String key);
  public native int FindKey(@StdString BytePointer key);

  public native @SharedPtr KeyValueMetadata Copy();

  /** \brief Return a new KeyValueMetadata by combining the passed metadata
   *  with this KeyValueMetadata. Colliding keys will be overridden by the
   *  passed metadata. Assumes keys in both containers are unique */
  public native @SharedPtr KeyValueMetadata Merge(@Const @ByRef KeyValueMetadata other);

  public native @Cast("bool") boolean Equals(@Const @ByRef KeyValueMetadata other);
  public native @StdString String ToString();
}
