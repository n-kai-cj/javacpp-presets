// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.systems.macosx;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.macosx.*;

// #endif	/* (!_POSIX_C_SOURCE || _DARWIN_C_SOURCE) */

/*
 * [XSI] Structure used by kernel to store most addresses.
 */
@Properties(inherit = org.bytedeco.systems.presets.macosx.class)
public class sockaddr extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public sockaddr() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public sockaddr(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public sockaddr(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public sockaddr position(long position) {
        return (sockaddr)super.position(position);
    }
    @Override public sockaddr getPointer(long i) {
        return new sockaddr(this).position(position + i);
    }

	public native @Cast("__uint8_t") byte sa_len(); public native sockaddr sa_len(byte setter);		/* total length */
	public native @Cast("sa_family_t") byte sa_family(); public native sockaddr sa_family(byte setter);	/* [XSI] address family */
	public native @Cast("char") byte sa_data(int i); public native sockaddr sa_data(int i, byte setter);
	@MemberGetter public native @Cast("char*") BytePointer sa_data();	/* [XSI] addr value (actually larger) */
}
