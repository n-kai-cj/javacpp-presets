// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cpython;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpython.global.python.*;


/* Non-ASCII strings allocated through PyUnicode_New use the
   PyCompactUnicodeObject structure. state.compact is set, and the data
   immediately follow the structure. */
@Properties(inherit = org.bytedeco.cpython.presets.python.class)
public class PyCompactUnicodeObject extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public PyCompactUnicodeObject() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public PyCompactUnicodeObject(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public PyCompactUnicodeObject(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public PyCompactUnicodeObject position(long position) {
        return (PyCompactUnicodeObject)super.position(position);
    }
    @Override public PyCompactUnicodeObject getPointer(long i) {
        return new PyCompactUnicodeObject((Pointer)this).position(position + i);
    }

    public native @ByRef PyASCIIObject _base(); public native PyCompactUnicodeObject _base(PyASCIIObject setter);
    public native @Cast("Py_ssize_t") long utf8_length(); public native PyCompactUnicodeObject utf8_length(long setter);     /* Number of bytes in utf8, excluding the
                                 * terminating \0. */
    public native @Cast("char*") BytePointer utf8(); public native PyCompactUnicodeObject utf8(BytePointer setter);                 /* UTF-8 representation (null-terminated) */
    public native @Cast("Py_ssize_t") long wstr_length(); public native PyCompactUnicodeObject wstr_length(long setter);     /* Number of code points in wstr, possible
                                 * surrogates count as two code points. */
}
