// Targeted by JavaCPP version 1.5.6-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.nvcodec.nvcuvid;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.cuda.cudart.*;
import static org.bytedeco.cuda.global.cudart.*;

import static org.bytedeco.nvcodec.global.nvcuvid.*;

@Opaque @Properties(inherit = org.bytedeco.nvcodec.presets.nvcuvid.class)
public class _CUcontextlock_st extends Pointer {
    /** Empty constructor. Calls {@code super((Pointer)null)}. */
    public _CUcontextlock_st() { super((Pointer)null); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public _CUcontextlock_st(Pointer p) { super(p); }
}
