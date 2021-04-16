// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.llvm.clang;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.llvm.LLVM.*;
import static org.bytedeco.llvm.global.LLVM.*;

import static org.bytedeco.llvm.global.clang.*;


@Properties(inherit = org.bytedeco.llvm.presets.clang.class)
public class CXCursorAndRangeVisitor extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public CXCursorAndRangeVisitor() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public CXCursorAndRangeVisitor(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CXCursorAndRangeVisitor(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public CXCursorAndRangeVisitor position(long position) {
        return (CXCursorAndRangeVisitor)super.position(position);
    }
    @Override public CXCursorAndRangeVisitor getPointer(long i) {
        return new CXCursorAndRangeVisitor((Pointer)this).position(position + i);
    }

  public native Pointer context(); public native CXCursorAndRangeVisitor context(Pointer setter);
  public static class Visit_Pointer_CXCursor_CXSourceRange extends FunctionPointer {
      static { Loader.load(); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public    Visit_Pointer_CXCursor_CXSourceRange(Pointer p) { super(p); }
      protected Visit_Pointer_CXCursor_CXSourceRange() { allocate(); }
      private native void allocate();
      public native @Cast("CXVisitorResult") int call(Pointer context, @ByVal CXCursor arg1, @ByVal CXSourceRange arg2);
  }
  public native Visit_Pointer_CXCursor_CXSourceRange visit(); public native CXCursorAndRangeVisitor visit(Visit_Pointer_CXCursor_CXSourceRange setter);
}
