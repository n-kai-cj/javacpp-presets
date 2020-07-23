// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.llvm.clang;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.llvm.LLVM.*;
import static org.bytedeco.llvm.global.LLVM.*;

import static org.bytedeco.llvm.global.clang.*;


@Properties(inherit = org.bytedeco.llvm.presets.clang.class)
public class CXIdxObjCCategoryDeclInfo extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public CXIdxObjCCategoryDeclInfo() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public CXIdxObjCCategoryDeclInfo(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CXIdxObjCCategoryDeclInfo(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public CXIdxObjCCategoryDeclInfo position(long position) {
        return (CXIdxObjCCategoryDeclInfo)super.position(position);
    }

  public native @Const CXIdxObjCContainerDeclInfo containerInfo(); public native CXIdxObjCCategoryDeclInfo containerInfo(CXIdxObjCContainerDeclInfo setter);
  public native @Const CXIdxEntityInfo objcClass(); public native CXIdxObjCCategoryDeclInfo objcClass(CXIdxEntityInfo setter);
  public native @ByRef CXCursor classCursor(); public native CXIdxObjCCategoryDeclInfo classCursor(CXCursor setter);
  public native @ByRef CXIdxLoc classLoc(); public native CXIdxObjCCategoryDeclInfo classLoc(CXIdxLoc setter);
  public native @Const CXIdxObjCProtocolRefListInfo protocols(); public native CXIdxObjCCategoryDeclInfo protocols(CXIdxObjCProtocolRefListInfo setter);
}
