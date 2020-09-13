// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.cpython;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpython.global.python.*;



/* hash secret
 *
 * memory layout on 64 bit systems
 *   cccccccc cccccccc cccccccc  uc -- unsigned char[24]
 *   pppppppp ssssssss ........  fnv -- two Py_hash_t
 *   k0k0k0k0 k1k1k1k1 ........  siphash -- two uint64_t
 *   ........ ........ ssssssss  djbx33a -- 16 bytes padding + one Py_hash_t
 *   ........ ........ eeeeeeee  pyexpat XML hash salt
 *
 * memory layout on 32 bit systems
 *   cccccccc cccccccc cccccccc  uc
 *   ppppssss ........ ........  fnv -- two Py_hash_t
 *   k0k0k0k0 k1k1k1k1 ........  siphash -- two uint64_t (*)
 *   ........ ........ ssss....  djbx33a -- 16 bytes padding + one Py_hash_t
 *   ........ ........ eeee....  pyexpat XML hash salt
 *
 * (*) The siphash member may not be available on 32 bit platforms without
 *     an unsigned int64 data type.
 */
// #ifndef Py_LIMITED_API
@Properties(inherit = org.bytedeco.cpython.presets.python.class)
public class _Py_HashSecret_t extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public _Py_HashSecret_t() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public _Py_HashSecret_t(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public _Py_HashSecret_t(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public _Py_HashSecret_t position(long position) {
        return (_Py_HashSecret_t)super.position(position);
    }
    @Override public _Py_HashSecret_t getPointer(long i) {
        return new _Py_HashSecret_t(this).position(position + i);
    }

    /* ensure 24 bytes */
    public native @Cast("unsigned char") byte uc(int i); public native _Py_HashSecret_t uc(int i, byte setter);
    @MemberGetter public native @Cast("unsigned char*") BytePointer uc();
    /* two Py_hash_t for FNV */
        @Name("fnv.prefix") public native @Cast("Py_hash_t") long fnv_prefix(); public native _Py_HashSecret_t fnv_prefix(long setter);
        @Name("fnv.suffix") public native @Cast("Py_hash_t") long fnv_suffix(); public native _Py_HashSecret_t fnv_suffix(long setter);
    /* two uint64 for SipHash24 */
        @Name("siphash.k0") public native @Cast("uint64_t") long siphash_k0(); public native _Py_HashSecret_t siphash_k0(long setter);
        @Name("siphash.k1") public native @Cast("uint64_t") long siphash_k1(); public native _Py_HashSecret_t siphash_k1(long setter);
    /* a different (!) Py_hash_t for small string optimization */
        @Name("djbx33a.padding") public native @Cast("unsigned char") byte djbx33a_padding(int i); public native _Py_HashSecret_t djbx33a_padding(int i, byte setter);
        @Name("djbx33a.padding") @MemberGetter public native @Cast("unsigned char*") BytePointer djbx33a_padding();
        @Name("djbx33a.suffix") public native @Cast("Py_hash_t") long djbx33a_suffix(); public native _Py_HashSecret_t djbx33a_suffix(long setter);
        @Name("expat.padding") public native @Cast("unsigned char") byte expat_padding(int i); public native _Py_HashSecret_t expat_padding(int i, byte setter);
        @Name("expat.padding") @MemberGetter public native @Cast("unsigned char*") BytePointer expat_padding();
        @Name("expat.hashsalt") public native @Cast("Py_hash_t") long expat_hashsalt(); public native _Py_HashSecret_t expat_hashsalt(long setter);
}
