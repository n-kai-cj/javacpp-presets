// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.systems.linux;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.linux.*;


/* This is the structure that must be passed (by reference) to `dlinfo' for
   the RTLD_DI_SERINFO and RTLD_DI_SERINFOSIZE requests.  */
@Properties(inherit = org.bytedeco.systems.presets.linux.class)
public class Dl_serinfo extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public Dl_serinfo() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public Dl_serinfo(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Dl_serinfo(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public Dl_serinfo position(long position) {
        return (Dl_serinfo)super.position(position);
    }
    @Override public Dl_serinfo getPointer(long i) {
        return new Dl_serinfo(this).position(position + i);
    }

  public native @Cast("size_t") long dls_size(); public native Dl_serinfo dls_size(long setter);		/* Size in bytes of the whole buffer.  */
  public native @Cast("unsigned int") int dls_cnt(); public native Dl_serinfo dls_cnt(int setter);		/* Number of elements in `dls_serpath'.  */
  public native @ByRef Dl_serpath dls_serpath(int i); public native Dl_serinfo dls_serpath(int i, Dl_serpath setter);
  @MemberGetter public native Dl_serpath dls_serpath();	/* Actually longer, dls_cnt elements.  */
}
