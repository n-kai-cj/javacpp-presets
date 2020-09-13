// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.cudart;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cuda.global.cudart.*;

// #endif

/**
 * CUDA host function
 * @param userData Argument value passed to the function
 */
@Convention("CUDART_CB") @Properties(inherit = org.bytedeco.cuda.presets.cudart.class)
public class cudaHostFn_t extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    cudaHostFn_t(Pointer p) { super(p); }
    protected cudaHostFn_t() { allocate(); }
    private native void allocate();
    public native void call(Pointer userData);
}
