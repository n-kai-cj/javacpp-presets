// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.systems.linux;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.linux.*;

// # endif
// #endif
// #ifdef	__USE_MISC
/* Register a function to be called with the status
   given to `exit' and the given argument.  */
@Properties(inherit = org.bytedeco.systems.presets.linux.class)
public class __func_int_Pointer extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    __func_int_Pointer(Pointer p) { super(p); }
    protected __func_int_Pointer() { allocate(); }
    private native void allocate();
    public native void call(int __status, Pointer __arg);
}
