// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.llvm.clang;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.llvm.LLVM.*;
import static org.bytedeco.llvm.global.LLVM.*;

import static org.bytedeco.llvm.global.clang.*;


/**
 * Contains the results of code-completion.
 *
 * This data structure contains the results of code completion, as
 * produced by \c clang_codeCompleteAt(). Its contents must be freed by
 * \c clang_disposeCodeCompleteResults.
 */
@Properties(inherit = org.bytedeco.llvm.presets.clang.class)
public class CXCodeCompleteResults extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public CXCodeCompleteResults() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public CXCodeCompleteResults(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CXCodeCompleteResults(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public CXCodeCompleteResults position(long position) {
        return (CXCodeCompleteResults)super.position(position);
    }
    @Override public CXCodeCompleteResults getPointer(long i) {
        return new CXCodeCompleteResults(this).position(position + i);
    }

  /**
   * The code-completion results.
   */
  public native CXCompletionResult Results(); public native CXCodeCompleteResults Results(CXCompletionResult setter);

  /**
   * The number of code-completion results stored in the
   * \c Results array.
   */
  public native @Cast("unsigned") int NumResults(); public native CXCodeCompleteResults NumResults(int setter);
}
