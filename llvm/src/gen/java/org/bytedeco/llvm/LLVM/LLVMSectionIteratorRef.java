// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.llvm.LLVM;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.llvm.global.LLVM.*;


/**
 * \defgroup LLVMCObject Object file reading and writing
 * \ingroup LLVMC
 *
 * \{
 */

// Opaque type wrappers
@Name("LLVMOpaqueSectionIterator") @Opaque @Properties(inherit = org.bytedeco.llvm.presets.LLVM.class)
public class LLVMSectionIteratorRef extends Pointer {
    /** Empty constructor. Calls {@code super((Pointer)null)}. */
    public LLVMSectionIteratorRef() { super((Pointer)null); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMSectionIteratorRef(Pointer p) { super(p); }
}
