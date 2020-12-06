// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.parquet;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.parquet.*;


// Simple string key retriever
@Namespace("parquet") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.parquet.class)
public class StringKeyIdRetriever extends DecryptionKeyRetriever {
    static { Loader.load(); }
    /** Default native constructor. */
    public StringKeyIdRetriever() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public StringKeyIdRetriever(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public StringKeyIdRetriever(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public StringKeyIdRetriever position(long position) {
        return (StringKeyIdRetriever)super.position(position);
    }
    @Override public StringKeyIdRetriever getPointer(long i) {
        return new StringKeyIdRetriever(this).position(position + i);
    }

  public native void PutKey(@StdString String key_id, @StdString String key);
  public native void PutKey(@StdString BytePointer key_id, @StdString BytePointer key);
  public native @StdString String GetKey(@StdString String key_metadata);
  public native @StdString BytePointer GetKey(@StdString BytePointer key_metadata);
}
