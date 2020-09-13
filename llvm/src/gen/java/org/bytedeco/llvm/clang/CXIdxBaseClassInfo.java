// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.llvm.clang;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.llvm.LLVM.*;
import static org.bytedeco.llvm.global.LLVM.*;

import static org.bytedeco.llvm.global.clang.*;


@Properties(inherit = org.bytedeco.llvm.presets.clang.class)
public class CXIdxBaseClassInfo extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public CXIdxBaseClassInfo() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public CXIdxBaseClassInfo(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CXIdxBaseClassInfo(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public CXIdxBaseClassInfo position(long position) {
        return (CXIdxBaseClassInfo)super.position(position);
    }
    @Override public CXIdxBaseClassInfo getPointer(long i) {
        return new CXIdxBaseClassInfo(this).position(position + i);
    }

  public native @Const CXIdxEntityInfo base(); public native CXIdxBaseClassInfo base(CXIdxEntityInfo setter);
  public native @ByRef CXCursor cursor(); public native CXIdxBaseClassInfo cursor(CXCursor setter);
  public native @ByRef CXIdxLoc loc(); public native CXIdxBaseClassInfo loc(CXIdxLoc setter);
}
