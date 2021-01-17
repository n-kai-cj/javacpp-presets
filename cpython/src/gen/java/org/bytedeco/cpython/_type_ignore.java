// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cpython;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpython.global.python.*;

@Properties(inherit = org.bytedeco.cpython.presets.python.class)
public class _type_ignore extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public _type_ignore() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public _type_ignore(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public _type_ignore(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public _type_ignore position(long position) {
        return (_type_ignore)super.position(position);
    }
    @Override public _type_ignore getPointer(long i) {
        return new _type_ignore((Pointer)this).position(position + i);
    }

    public native @Cast("_type_ignore_kind") int kind(); public native _type_ignore kind(int setter);
            @Name("v.TypeIgnore.lineno") public native int v_TypeIgnore_lineno(); public native _type_ignore v_TypeIgnore_lineno(int setter);
            @Name("v.TypeIgnore.tag") public native @Cast("string") PyObject v_TypeIgnore_tag(); public native _type_ignore v_TypeIgnore_tag(PyObject setter);
}
