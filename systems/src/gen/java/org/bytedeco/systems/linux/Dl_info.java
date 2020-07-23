// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.systems.linux;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.linux.*;



// #ifdef __USE_GNU
/* Structure containing information about object searched using
   `dladdr'.  */
@Properties(inherit = org.bytedeco.systems.presets.linux.class)
public class Dl_info extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public Dl_info() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public Dl_info(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Dl_info(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public Dl_info position(long position) {
        return (Dl_info)super.position(position);
    }

  public native @Cast("const char*") BytePointer dli_fname(); public native Dl_info dli_fname(BytePointer setter);	/* File name of defining object.  */
  public native Pointer dli_fbase(); public native Dl_info dli_fbase(Pointer setter);		/* Load address of that object.  */
  public native @Cast("const char*") BytePointer dli_sname(); public native Dl_info dli_sname(BytePointer setter);	/* Name of nearest symbol.  */
  public native Pointer dli_saddr(); public native Dl_info dli_saddr(Pointer setter);		/* Exact value of nearest symbol.  */
}
