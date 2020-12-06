// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.cudart;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cuda.global.cudart.*;

/** CUDA surface reference */
@Opaque @Properties(inherit = org.bytedeco.cuda.presets.cudart.class)
public class CUsurfref_st extends Pointer {
    /** Empty constructor. Calls {@code super((Pointer)null)}. */
    public CUsurfref_st() { super((Pointer)null); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CUsurfref_st(Pointer p) { super(p); }
}
