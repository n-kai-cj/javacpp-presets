// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.skia;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.skia.global.Skia.*;


@Opaque @Properties(inherit = org.bytedeco.skia.presets.Skia.class)
public class gr_glinterface_t extends Pointer {
    /** Empty constructor. Calls {@code super((Pointer)null)}. */
    public gr_glinterface_t() { super((Pointer)null); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public gr_glinterface_t(Pointer p) { super(p); }
}
