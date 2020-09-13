// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.cpython;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpython.global.python.*;

@Properties(inherit = org.bytedeco.cpython.presets.python.class)
public class _PyCFunctionFastWithKeywords extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    _PyCFunctionFastWithKeywords(Pointer p) { super(p); }
    protected _PyCFunctionFastWithKeywords() { allocate(); }
    private native void allocate();
    public native PyObject call(PyObject arg0,
                                                   @Cast("PyObject*const*") PointerPointer arg1, @Cast("Py_ssize_t") long arg2,
                                                   PyObject arg3);
}
