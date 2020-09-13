// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;

@Namespace("Eigen") @Opaque @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class ThreadPoolDevice extends Pointer {
    /** Empty constructor. Calls {@code super((Pointer)null)}. */
    public ThreadPoolDevice() { super((Pointer)null); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ThreadPoolDevice(Pointer p) { super(p); }
}
