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
public class PyCLongDoubleScalarObject extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public PyCLongDoubleScalarObject() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public PyCLongDoubleScalarObject(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public PyCLongDoubleScalarObject(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public PyCLongDoubleScalarObject position(long position) {
        return (PyCLongDoubleScalarObject)super.position(position);
    }
    @Override public PyCLongDoubleScalarObject getPointer(long i) {
        return new PyCLongDoubleScalarObject(this).position(position + i);
    }

        public native @ByRef PyObject ob_base(); public native PyCLongDoubleScalarObject ob_base(PyObject setter);
        public native @ByRef npy_clongdouble obval(); public native PyCLongDoubleScalarObject obval(npy_clongdouble setter);
}
