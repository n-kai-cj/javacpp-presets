// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cpython;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpython.global.python.*;


@Properties(inherit = org.bytedeco.cpython.presets.python.class)
public class _keyword extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public _keyword() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public _keyword(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public _keyword(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public _keyword position(long position) {
        return (_keyword)super.position(position);
    }
    @Override public _keyword getPointer(long i) {
        return new _keyword((Pointer)this).position(position + i);
    }

    public native @Cast("identifier") PyObject arg(); public native _keyword arg(PyObject setter);
    public native _expr value(); public native _keyword value(_expr setter);
    public native int lineno(); public native _keyword lineno(int setter);
    public native int col_offset(); public native _keyword col_offset(int setter);
    public native int end_lineno(); public native _keyword end_lineno(int setter);
    public native int end_col_offset(); public native _keyword end_col_offset(int setter);
}
