// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.llvm.LLVM;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.llvm.global.LLVM.*;


@Properties(inherit = org.bytedeco.llvm.presets.LLVM.class)
public class LLVMOpInfo1 extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public LLVMOpInfo1() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public LLVMOpInfo1(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMOpInfo1(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public LLVMOpInfo1 position(long position) {
        return (LLVMOpInfo1)super.position(position);
    }
    @Override public LLVMOpInfo1 getPointer(long i) {
        return new LLVMOpInfo1(this).position(position + i);
    }

  public native @ByRef LLVMOpInfoSymbol1 AddSymbol(); public native LLVMOpInfo1 AddSymbol(LLVMOpInfoSymbol1 setter);
  public native @ByRef LLVMOpInfoSymbol1 SubtractSymbol(); public native LLVMOpInfo1 SubtractSymbol(LLVMOpInfoSymbol1 setter);
  public native @Cast("uint64_t") long Value(); public native LLVMOpInfo1 Value(long setter);
  public native @Cast("uint64_t") long VariantKind(); public native LLVMOpInfo1 VariantKind(long setter);
}
