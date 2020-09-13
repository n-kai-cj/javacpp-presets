// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


// ---------------------------------------------------------------------
// An intermediate class for storing Future results

@Namespace("arrow") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class FutureStorageBase extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FutureStorageBase(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public FutureStorageBase(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public FutureStorageBase position(long position) {
        return (FutureStorageBase)super.position(position);
    }
    @Override public FutureStorageBase getPointer(long i) {
        return new FutureStorageBase(this).position(position + i);
    }

  public FutureStorageBase() { super((Pointer)null); allocate(); }
  private native void allocate();
}
