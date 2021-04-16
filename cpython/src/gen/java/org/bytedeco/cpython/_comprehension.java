// Targeted by JavaCPP version 1.5.6-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cpython;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpython.global.python.*;


@Properties(inherit = org.bytedeco.cpython.presets.python.class)
public class _comprehension extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public _comprehension() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public _comprehension(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public _comprehension(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public _comprehension position(long position) {
        return (_comprehension)super.position(position);
    }
    @Override public _comprehension getPointer(long i) {
        return new _comprehension((Pointer)this).position(position + i);
    }

    public native _expr target(); public native _comprehension target(_expr setter);
    public native _expr iter(); public native _comprehension iter(_expr setter);
    public native asdl_seq ifs(); public native _comprehension ifs(asdl_seq setter);
    public native int is_async(); public native _comprehension is_async(int setter);
}
