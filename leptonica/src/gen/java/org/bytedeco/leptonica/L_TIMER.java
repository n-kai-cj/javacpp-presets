// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.leptonica;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.leptonica.global.lept.*;



/*------------------------------------------------------------------------*
 *                          Timing structs                                *
 *------------------------------------------------------------------------*/
@Namespace @Name("void") @Opaque @Properties(inherit = org.bytedeco.leptonica.presets.lept.class)
public class L_TIMER extends Pointer {
    /** Empty constructor. Calls {@code super((Pointer)null)}. */
    public L_TIMER() { super((Pointer)null); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public L_TIMER(Pointer p) { super(p); }
}
