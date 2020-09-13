// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.systems.windows;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.windows.*;


@Properties(inherit = org.bytedeco.systems.presets.windows.class)
public class ACTIVATION_CONTEXT_COMPATIBILITY_INFORMATION extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ACTIVATION_CONTEXT_COMPATIBILITY_INFORMATION(Pointer p) { super(p); }

    public native @Cast("DWORD") int ElementCount(); public native ACTIVATION_CONTEXT_COMPATIBILITY_INFORMATION ElementCount(int setter);
    public native @ByRef COMPATIBILITY_CONTEXT_ELEMENT Elements(int i); public native ACTIVATION_CONTEXT_COMPATIBILITY_INFORMATION Elements(int i, COMPATIBILITY_CONTEXT_ELEMENT setter);
    @MemberGetter public native COMPATIBILITY_CONTEXT_ELEMENT Elements();
}
