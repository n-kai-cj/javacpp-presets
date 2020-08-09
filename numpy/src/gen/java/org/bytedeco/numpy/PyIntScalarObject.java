// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.numpy;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.cpython.*;
import static org.bytedeco.cpython.global.python.*;

import static org.bytedeco.numpy.global.numpy.*;



@Properties(inherit = org.bytedeco.numpy.presets.numpy.class)
public class PyIntScalarObject extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public PyIntScalarObject() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public PyIntScalarObject(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public PyIntScalarObject(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public PyIntScalarObject position(long position) {
        return (PyIntScalarObject)super.position(position);
    }
    @Override public PyIntScalarObject getPointer(long i) {
        return new PyIntScalarObject(this).position(position + i);
    }

        public native @ByRef PyObject ob_base(); public native PyIntScalarObject ob_base(PyObject setter);
        public native int obval(); public native PyIntScalarObject obval(int setter);
}
