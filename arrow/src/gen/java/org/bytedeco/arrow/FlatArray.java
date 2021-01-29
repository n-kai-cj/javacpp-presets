// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** Base class for non-nested arrays */
@Namespace("arrow") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class FlatArray extends Array {
    static { Loader.load(); }
    /** Default native constructor. */
    public FlatArray() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public FlatArray(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FlatArray(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public FlatArray position(long position) {
        return (FlatArray)super.position(position);
    }
    @Override public FlatArray getPointer(long i) {
        return new FlatArray((Pointer)this).position(position + i);
    }

}
