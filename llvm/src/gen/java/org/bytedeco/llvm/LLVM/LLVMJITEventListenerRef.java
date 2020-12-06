// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.llvm.LLVM;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.llvm.global.LLVM.*;


/**
 * @see llvm::JITEventListener
 */
@Name("LLVMOpaqueJITEventListener") @Opaque @Properties(inherit = org.bytedeco.llvm.presets.LLVM.class)
public class LLVMJITEventListenerRef extends Pointer {
    /** Empty constructor. Calls {@code super((Pointer)null)}. */
    public LLVMJITEventListenerRef() { super((Pointer)null); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMJITEventListenerRef(Pointer p) { super(p); }
}
