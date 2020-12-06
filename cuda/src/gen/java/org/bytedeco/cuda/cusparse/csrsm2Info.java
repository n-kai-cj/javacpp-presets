// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.cusparse;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.cuda.cudart.*;
import static org.bytedeco.cuda.global.cudart.*;

import static org.bytedeco.cuda.global.cusparse.*;


@Opaque @Properties(inherit = org.bytedeco.cuda.presets.cusparse.class)
public class csrsm2Info extends Pointer {
    /** Empty constructor. Calls {@code super((Pointer)null)}. */
    public csrsm2Info() { super((Pointer)null); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public csrsm2Info(Pointer p) { super(p); }
}
