// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.systems.windows;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.windows.*;


@Properties(inherit = org.bytedeco.systems.presets.windows.class)
public class IMAGE_AUX_SYMBOL_TOKEN_DEF extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public IMAGE_AUX_SYMBOL_TOKEN_DEF() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public IMAGE_AUX_SYMBOL_TOKEN_DEF(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IMAGE_AUX_SYMBOL_TOKEN_DEF(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public IMAGE_AUX_SYMBOL_TOKEN_DEF position(long position) {
        return (IMAGE_AUX_SYMBOL_TOKEN_DEF)super.position(position);
    }
    @Override public IMAGE_AUX_SYMBOL_TOKEN_DEF getPointer(long i) {
        return new IMAGE_AUX_SYMBOL_TOKEN_DEF((Pointer)this).position(position + i);
    }

    public native @Cast("BYTE") byte bAuxType(); public native IMAGE_AUX_SYMBOL_TOKEN_DEF bAuxType(byte setter);                  // IMAGE_AUX_SYMBOL_TYPE
    public native @Cast("BYTE") byte bReserved(); public native IMAGE_AUX_SYMBOL_TOKEN_DEF bReserved(byte setter);                 // Must be 0
    public native @Cast("DWORD") int SymbolTableIndex(); public native IMAGE_AUX_SYMBOL_TOKEN_DEF SymbolTableIndex(int setter);
    public native @Cast("BYTE") byte rgbReserved(int i); public native IMAGE_AUX_SYMBOL_TOKEN_DEF rgbReserved(int i, byte setter);
    @MemberGetter public native @Cast("BYTE*") BytePointer rgbReserved();           // Must be 0
}
