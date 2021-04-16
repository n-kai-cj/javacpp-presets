// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

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
public class PyArray_DatetimeMetaData extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public PyArray_DatetimeMetaData() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public PyArray_DatetimeMetaData(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public PyArray_DatetimeMetaData(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public PyArray_DatetimeMetaData position(long position) {
        return (PyArray_DatetimeMetaData)super.position(position);
    }
    @Override public PyArray_DatetimeMetaData getPointer(long i) {
        return new PyArray_DatetimeMetaData((Pointer)this).position(position + i);
    }

    public native @Cast("NPY_DATETIMEUNIT") int base(); public native PyArray_DatetimeMetaData base(int setter);
    public native int num(); public native PyArray_DatetimeMetaData num(int setter);
}
