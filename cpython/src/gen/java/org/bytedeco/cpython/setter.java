// Targeted by JavaCPP version 1.5.6-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cpython;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpython.global.python.*;

@Properties(inherit = org.bytedeco.cpython.presets.python.class)
public class setter extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    setter(Pointer p) { super(p); }
    protected setter() { allocate(); }
    private native void allocate();
    public native int call(PyObject arg0, PyObject arg1, Pointer arg2);
}
