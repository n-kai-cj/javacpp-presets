// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.numpy;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.cpython.*;
import static org.bytedeco.cpython.global.python.*;

import static org.bytedeco.numpy.global.numpy.*;

// #else
// #endif

/**********************************
 * The nditer object, added in 1.6
 **********************************/

/* The actual structure of the iterator is an internal detail */
@Opaque @Properties(inherit = org.bytedeco.numpy.presets.numpy.class)
public class NpyIter extends Pointer {
    /** Empty constructor. Calls {@code super((Pointer)null)}. */
    public NpyIter() { super((Pointer)null); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public NpyIter(Pointer p) { super(p); }
}
