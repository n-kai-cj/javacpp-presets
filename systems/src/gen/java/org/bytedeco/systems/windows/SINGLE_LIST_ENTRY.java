// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.systems.windows;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.windows.*;


//
//  Singly linked list structure. Can be used as either a list head, or
//  as link words.
//

@Properties(inherit = org.bytedeco.systems.presets.windows.class)
public class SINGLE_LIST_ENTRY extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SINGLE_LIST_ENTRY() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SINGLE_LIST_ENTRY(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SINGLE_LIST_ENTRY(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SINGLE_LIST_ENTRY position(long position) {
        return (SINGLE_LIST_ENTRY)super.position(position);
    }
    @Override public SINGLE_LIST_ENTRY getPointer(long i) {
        return new SINGLE_LIST_ENTRY((Pointer)this).position(position + i);
    }

    public native SINGLE_LIST_ENTRY Next(); public native SINGLE_LIST_ENTRY Next(SINGLE_LIST_ENTRY setter);
}
