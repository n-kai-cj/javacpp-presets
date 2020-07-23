// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.systems.macosx;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.macosx.*;

// #endif /* !__DARWIN_NO_LONG_LONG */
@Properties(inherit = org.bytedeco.systems.presets.macosx.class)
public class _Nonnull__compar_Pointer_Pointer extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    _Nonnull__compar_Pointer_Pointer(Pointer p) { super(p); }
    protected _Nonnull__compar_Pointer_Pointer() { allocate(); }
    private native void allocate();
    public native int call(@Const Pointer arg0, @Const Pointer arg1);
}
