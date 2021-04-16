// Targeted by JavaCPP version 1.5.6-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cpython;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpython.global.python.*;

@Properties(inherit = org.bytedeco.cpython.presets.python.class)
public class Innerfunc_String_long_Pointer extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    Innerfunc_String_long_Pointer(Pointer p) { super(p); }
    protected Innerfunc_String_long_Pointer() { allocate(); }
    private native void allocate();
    public native PyObject call(String arg0, @Cast("Py_ssize_t") long arg1, Pointer arg2);
}
