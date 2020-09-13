// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.cpython;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpython.global.python.*;


/* It would be nice if the code generated by asdl_c.py was completely
   independent of Python, but it is a goal the requires too much work
   at this stage.  So, for example, I'll represent identifiers as
   interned Python strings.
*/

/* XXX A sequence should be typed so that its use can be typechecked. */

@Properties(inherit = org.bytedeco.cpython.presets.python.class)
public class asdl_seq extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public asdl_seq() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public asdl_seq(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public asdl_seq(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public asdl_seq position(long position) {
        return (asdl_seq)super.position(position);
    }
    @Override public asdl_seq getPointer(long i) {
        return new asdl_seq(this).position(position + i);
    }

    public native @Cast("Py_ssize_t") long size(); public native asdl_seq size(long setter);
    public native Pointer elements(int i); public native asdl_seq elements(int i, Pointer setter);
    @MemberGetter public native @Cast("void**") PointerPointer elements();
}
