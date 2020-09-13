// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.systems.macosx;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.macosx.*;
	/* Set bit for strict POSIX */

/*
 * A structure representing a resource limit.  The address of an instance
 * of this structure is the second parameter to getrlimit()/setrlimit().
 */
@Properties(inherit = org.bytedeco.systems.presets.macosx.class)
public class rlimit extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public rlimit() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public rlimit(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public rlimit(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public rlimit position(long position) {
        return (rlimit)super.position(position);
    }
    @Override public rlimit getPointer(long i) {
        return new rlimit(this).position(position + i);
    }

	public native @Cast("rlim_t") long rlim_cur(); public native rlimit rlim_cur(long setter);		/* current (soft) limit */
	public native @Cast("rlim_t") long rlim_max(); public native rlimit rlim_max(long setter);		/* maximum value for rlim_cur */
}
