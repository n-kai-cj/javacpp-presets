// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cpython;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpython.global.python.*;


/* --- Unicode Type ------------------------------------------------------- */

/* ASCII-only strings created through PyUnicode_New use the PyASCIIObject
   structure. state.ascii and state.compact are set, and the data
   immediately follow the structure. utf8_length and wstr_length can be found
   in the length field; the utf8 pointer is equal to the data pointer. */
@Properties(inherit = org.bytedeco.cpython.presets.python.class)
public class PyASCIIObject extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public PyASCIIObject() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public PyASCIIObject(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public PyASCIIObject(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public PyASCIIObject position(long position) {
        return (PyASCIIObject)super.position(position);
    }
    @Override public PyASCIIObject getPointer(long i) {
        return new PyASCIIObject((Pointer)this).position(position + i);
    }

    /* There are 4 forms of Unicode strings:

       - compact ascii:

         * structure = PyASCIIObject
         * test: PyUnicode_IS_COMPACT_ASCII(op)
         * kind = PyUnicode_1BYTE_KIND
         * compact = 1
         * ascii = 1
         * ready = 1
         * (length is the length of the utf8 and wstr strings)
         * (data starts just after the structure)
         * (since ASCII is decoded from UTF-8, the utf8 string are the data)

       - compact:

         * structure = PyCompactUnicodeObject
         * test: PyUnicode_IS_COMPACT(op) && !PyUnicode_IS_ASCII(op)
         * kind = PyUnicode_1BYTE_KIND, PyUnicode_2BYTE_KIND or
           PyUnicode_4BYTE_KIND
         * compact = 1
         * ready = 1
         * ascii = 0
         * utf8 is not shared with data
         * utf8_length = 0 if utf8 is NULL
         * wstr is shared with data and wstr_length=length
           if kind=PyUnicode_2BYTE_KIND and sizeof(wchar_t)=2
           or if kind=PyUnicode_4BYTE_KIND and sizeof(wchar_t)=4
         * wstr_length = 0 if wstr is NULL
         * (data starts just after the structure)

       - legacy string, not ready:

         * structure = PyUnicodeObject
         * test: kind == PyUnicode_WCHAR_KIND
         * length = 0 (use wstr_length)
         * hash = -1
         * kind = PyUnicode_WCHAR_KIND
         * compact = 0
         * ascii = 0
         * ready = 0
         * interned = SSTATE_NOT_INTERNED
         * wstr is not NULL
         * data.any is NULL
         * utf8 is NULL
         * utf8_length = 0

       - legacy string, ready:

         * structure = PyUnicodeObject structure
         * test: !PyUnicode_IS_COMPACT(op) && kind != PyUnicode_WCHAR_KIND
         * kind = PyUnicode_1BYTE_KIND, PyUnicode_2BYTE_KIND or
           PyUnicode_4BYTE_KIND
         * compact = 0
         * ready = 1
         * data.any is not NULL
         * utf8 is shared and utf8_length = length with data.any if ascii = 1
         * utf8_length = 0 if utf8 is NULL
         * wstr is shared with data.any and wstr_length = length
           if kind=PyUnicode_2BYTE_KIND and sizeof(wchar_t)=2
           or if kind=PyUnicode_4BYTE_KIND and sizeof(wchar_4)=4
         * wstr_length = 0 if wstr is NULL

       Compact strings use only one memory block (structure + characters),
       whereas legacy strings use one block for the structure and one block
       for characters.

       Legacy strings are created by PyUnicode_FromUnicode() and
       PyUnicode_FromStringAndSize(NULL, size) functions. They become ready
       when PyUnicode_READY() is called.

       See also _PyUnicode_CheckConsistency().
    */
    public native @ByRef PyObject ob_base(); public native PyASCIIObject ob_base(PyObject setter);
    public native @Cast("Py_ssize_t") long length(); public native PyASCIIObject length(long setter);          /* Number of code points in the string */
    public native @Cast("Py_hash_t") long hash(); public native PyASCIIObject hash(long setter);             /* Hash value; -1 if not set */
        /*
           SSTATE_NOT_INTERNED (0)
           SSTATE_INTERNED_MORTAL (1)
           SSTATE_INTERNED_IMMORTAL (2)

           If interned != SSTATE_NOT_INTERNED, the two references from the
           dictionary to this object are *not* counted in ob_refcnt.
         */
        @Name("state.interned") public native @Cast("unsigned int") @NoOffset int state_interned(); public native PyASCIIObject state_interned(int setter);
        /* Character size:

           - PyUnicode_WCHAR_KIND (0):

             * character type = wchar_t (16 or 32 bits, depending on the
               platform)

           - PyUnicode_1BYTE_KIND (1):

             * character type = Py_UCS1 (8 bits, unsigned)
             * all characters are in the range U+0000-U+00FF (latin1)
             * if ascii is set, all characters are in the range U+0000-U+007F
               (ASCII), otherwise at least one character is in the range
               U+0080-U+00FF

           - PyUnicode_2BYTE_KIND (2):

             * character type = Py_UCS2 (16 bits, unsigned)
             * all characters are in the range U+0000-U+FFFF (BMP)
             * at least one character is in the range U+0100-U+FFFF

           - PyUnicode_4BYTE_KIND (4):

             * character type = Py_UCS4 (32 bits, unsigned)
             * all characters are in the range U+0000-U+10FFFF
             * at least one character is in the range U+10000-U+10FFFF
         */
        @Name("state.kind") public native @Cast("unsigned int") @NoOffset int state_kind(); public native PyASCIIObject state_kind(int setter);
        /* Compact is with respect to the allocation scheme. Compact unicode
           objects only require one memory block while non-compact objects use
           one block for the PyUnicodeObject struct and another for its data
           buffer. */
        @Name("state.compact") public native @Cast("unsigned int") @NoOffset int state_compact(); public native PyASCIIObject state_compact(int setter);
        /* The string only contains characters in the range U+0000-U+007F (ASCII)
           and the kind is PyUnicode_1BYTE_KIND. If ascii is set and compact is
           set, use the PyASCIIObject structure. */
        @Name("state.ascii") public native @Cast("unsigned int") @NoOffset int state_ascii(); public native PyASCIIObject state_ascii(int setter);
        /* The ready flag indicates whether the object layout is initialized
           completely. This means that this is either a compact object, or
           the data pointer is filled out. The bit is redundant, and helps
           to minimize the test in PyUnicode_IS_READY(). */
        @Name("state.ready") public native @Cast("unsigned int") @NoOffset int state_ready(); public native PyASCIIObject state_ready(int setter);
        /* Padding to ensure that PyUnicode_DATA() is always aligned to
           4 bytes (see issue #19537 on m68k). */
        
    public native @Cast("wchar_t*") Pointer wstr(); public native PyASCIIObject wstr(Pointer setter);              /* wchar_t representation (null-terminated) */
}
