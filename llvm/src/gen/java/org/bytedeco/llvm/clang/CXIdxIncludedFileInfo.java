// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.llvm.clang;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.llvm.LLVM.*;
import static org.bytedeco.llvm.global.LLVM.*;

import static org.bytedeco.llvm.global.clang.*;


/**
 * Data for ppIncludedFile callback.
 */
@Properties(inherit = org.bytedeco.llvm.presets.clang.class)
public class CXIdxIncludedFileInfo extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public CXIdxIncludedFileInfo() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public CXIdxIncludedFileInfo(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CXIdxIncludedFileInfo(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public CXIdxIncludedFileInfo position(long position) {
        return (CXIdxIncludedFileInfo)super.position(position);
    }
    @Override public CXIdxIncludedFileInfo getPointer(long i) {
        return new CXIdxIncludedFileInfo(this).position(position + i);
    }

  /**
   * Location of '#' in the \#include/\#import directive.
   */
  public native @ByRef CXIdxLoc hashLoc(); public native CXIdxIncludedFileInfo hashLoc(CXIdxLoc setter);
  /**
   * Filename as written in the \#include/\#import directive.
   */
  public native @Cast("const char*") BytePointer filename(); public native CXIdxIncludedFileInfo filename(BytePointer setter);
  /**
   * The actual file that the \#include/\#import directive resolved to.
   */
  public native CXFile file(); public native CXIdxIncludedFileInfo file(CXFile setter);
  public native int isImport(); public native CXIdxIncludedFileInfo isImport(int setter);
  public native int isAngled(); public native CXIdxIncludedFileInfo isAngled(int setter);
  /**
   * Non-zero if the directive was automatically turned into a module
   * import.
   */
  public native int isModuleImport(); public native CXIdxIncludedFileInfo isModuleImport(int setter);
}
