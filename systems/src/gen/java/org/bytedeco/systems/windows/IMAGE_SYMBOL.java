// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.systems.windows;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.windows.*;
                       // Symbols, relocs, and linenumbers are 2 byte packed
// #endif

//
// Symbol format.
//

@Properties(inherit = org.bytedeco.systems.presets.windows.class)
public class IMAGE_SYMBOL extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public IMAGE_SYMBOL() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public IMAGE_SYMBOL(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IMAGE_SYMBOL(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public IMAGE_SYMBOL position(long position) {
        return (IMAGE_SYMBOL)super.position(position);
    }
    @Override public IMAGE_SYMBOL getPointer(long i) {
        return new IMAGE_SYMBOL(this).position(position + i);
    }

        @Name("N.ShortName") public native @Cast("BYTE") byte N_ShortName(int i); public native IMAGE_SYMBOL N_ShortName(int i, byte setter);
        @Name("N.ShortName") @MemberGetter public native @Cast("BYTE*") BytePointer N_ShortName();
            @Name("N.Name.Short") public native @Cast("DWORD") int N_Name_Short(); public native IMAGE_SYMBOL N_Name_Short(int setter);     // if 0, use LongName
            @Name("N.Name.Long") public native @Cast("DWORD") int N_Name_Long(); public native IMAGE_SYMBOL N_Name_Long(int setter);      // offset into string table
        @Name("N.LongName") public native @Cast("DWORD") int N_LongName(int i); public native IMAGE_SYMBOL N_LongName(int i, int setter);
        @Name("N.LongName") @MemberGetter public native @Cast("DWORD*") IntPointer N_LongName();    // PBYTE [2]
    public native @Cast("DWORD") int Value(); public native IMAGE_SYMBOL Value(int setter);
    public native @Cast("SHORT") short SectionNumber(); public native IMAGE_SYMBOL SectionNumber(short setter);
    public native @Cast("WORD") short Type(); public native IMAGE_SYMBOL Type(short setter);
    public native @Cast("BYTE") byte StorageClass(); public native IMAGE_SYMBOL StorageClass(byte setter);
    public native @Cast("BYTE") byte NumberOfAuxSymbols(); public native IMAGE_SYMBOL NumberOfAuxSymbols(byte setter);
}
