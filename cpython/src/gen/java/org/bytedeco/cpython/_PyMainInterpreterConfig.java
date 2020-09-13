// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.cpython;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpython.global.python.*;

/* Note: _PyCoreConfig_INIT sets other fields to 0/NULL */

/* Placeholders while working on the new configuration API
 *
 * See PEP 432 for final anticipated contents
 */
@Properties(inherit = org.bytedeco.cpython.presets.python.class)
public class _PyMainInterpreterConfig extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public _PyMainInterpreterConfig() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public _PyMainInterpreterConfig(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public _PyMainInterpreterConfig(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public _PyMainInterpreterConfig position(long position) {
        return (_PyMainInterpreterConfig)super.position(position);
    }
    @Override public _PyMainInterpreterConfig getPointer(long i) {
        return new _PyMainInterpreterConfig(this).position(position + i);
    }

    public native int install_signal_handlers(); public native _PyMainInterpreterConfig install_signal_handlers(int setter);   /* Install signal handlers? -1 means unset */
    public native PyObject argv(); public native _PyMainInterpreterConfig argv(PyObject setter);                /* sys.argv list, can be NULL */
    public native PyObject executable(); public native _PyMainInterpreterConfig executable(PyObject setter);          /* sys.executable str */
    public native PyObject prefix(); public native _PyMainInterpreterConfig prefix(PyObject setter);              /* sys.prefix str */
    public native PyObject base_prefix(); public native _PyMainInterpreterConfig base_prefix(PyObject setter);         /* sys.base_prefix str, can be NULL */
    public native PyObject exec_prefix(); public native _PyMainInterpreterConfig exec_prefix(PyObject setter);         /* sys.exec_prefix str */
    public native PyObject base_exec_prefix(); public native _PyMainInterpreterConfig base_exec_prefix(PyObject setter);    /* sys.base_exec_prefix str, can be NULL */
    public native PyObject warnoptions(); public native _PyMainInterpreterConfig warnoptions(PyObject setter);         /* sys.warnoptions list, can be NULL */
    public native PyObject xoptions(); public native _PyMainInterpreterConfig xoptions(PyObject setter);            /* sys._xoptions dict, can be NULL */
    public native PyObject module_search_path(); public native _PyMainInterpreterConfig module_search_path(PyObject setter);  /* sys.path list */
}
