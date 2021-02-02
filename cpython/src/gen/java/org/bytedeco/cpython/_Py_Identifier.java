// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cpython;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpython.global.python.*;


// #ifdef Py_REF_DEBUG
// #endif


/********************* String Literals ****************************************/
/* This structure helps managing static strings. The basic usage goes like this:
   Instead of doing

       r = PyObject_CallMethod(o, "foo", "args", ...);

   do

       _Py_IDENTIFIER(foo);
       ...
       r = _PyObject_CallMethodId(o, &PyId_foo, "args", ...);

   PyId_foo is a static variable, either on block level or file level. On first
   usage, the string "foo" is interned, and the structures are linked. On interpreter
   shutdown, all strings are released.

   Alternatively, _Py_static_string allows choosing the variable name.
   _PyUnicode_FromId returns a borrowed reference to the interned string.
   _PyObject_{Get,Set,Has}AttrId are __getattr__ versions using _Py_Identifier*.
*/
@Properties(inherit = org.bytedeco.cpython.presets.python.class)
public class _Py_Identifier extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public _Py_Identifier() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public _Py_Identifier(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public _Py_Identifier(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public _Py_Identifier position(long position) {
        return (_Py_Identifier)super.position(position);
    }
    @Override public _Py_Identifier getPointer(long i) {
        return new _Py_Identifier((Pointer)this).position(position + i);
    }

    public native _Py_Identifier next(); public native _Py_Identifier next(_Py_Identifier setter);
    public native @Cast("const char*") BytePointer string(); public native _Py_Identifier string(BytePointer setter);
    public native PyObject object(); public native _Py_Identifier object(PyObject setter);
}
