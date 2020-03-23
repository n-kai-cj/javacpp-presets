// Targeted by JavaCPP version 1.5.2: DO NOT EDIT THIS FILE

package org.bytedeco.systems.windows;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.systems.global.windows.*;

@Namespace @Name("void") @Opaque @Properties(inherit = org.bytedeco.systems.presets.windows.class)
public class LPCVOID extends Pointer {
    /** Empty constructor. Calls {@code super((Pointer)null)}. */
    public LPCVOID() { super((Pointer)null); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LPCVOID(Pointer p) { super(p); }
}