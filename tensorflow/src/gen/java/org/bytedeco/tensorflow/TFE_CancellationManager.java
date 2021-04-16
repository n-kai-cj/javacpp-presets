// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


@Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class TFE_CancellationManager extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public TFE_CancellationManager() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public TFE_CancellationManager(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TFE_CancellationManager(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public TFE_CancellationManager position(long position) {
        return (TFE_CancellationManager)super.position(position);
    }
    @Override public TFE_CancellationManager getPointer(long i) {
        return new TFE_CancellationManager((Pointer)this).position(position + i);
    }

  public native @MemberGetter @ByRef CancellationManager cancellation_manager();
}
