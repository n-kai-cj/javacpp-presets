// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cpython;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpython.global.python.*;


@Properties(inherit = org.bytedeco.cpython.presets.python.class)
public class PyMethodDescrObject extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public PyMethodDescrObject() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public PyMethodDescrObject(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public PyMethodDescrObject(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public PyMethodDescrObject position(long position) {
        return (PyMethodDescrObject)super.position(position);
    }
    @Override public PyMethodDescrObject getPointer(long i) {
        return new PyMethodDescrObject((Pointer)this).position(position + i);
    }

    public native @ByRef PyDescrObject d_common(); public native PyMethodDescrObject d_common(PyDescrObject setter);
    public native PyMethodDef d_method(); public native PyMethodDescrObject d_method(PyMethodDef setter);
    public native vectorcallfunc vectorcall(); public native PyMethodDescrObject vectorcall(vectorcallfunc setter);
}
