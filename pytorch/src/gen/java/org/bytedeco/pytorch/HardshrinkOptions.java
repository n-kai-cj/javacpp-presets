// Targeted by JavaCPP version 1.5.6-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.pytorch;

import org.bytedeco.pytorch.Allocator;
import org.bytedeco.pytorch.Function;
import org.bytedeco.pytorch.Module;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;

import static org.bytedeco.pytorch.global.torch.*;
 // namespace functional

// ============================================================================

/** Options for the {@code Hardshrink} module.
 * 
 *  Example:
 *  <pre>{@code
 *  Hardshrink model(HardshrinkOptions().lambda(42.42));
 *  }</pre> */
@Namespace("torch::nn") @NoOffset @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class HardshrinkOptions extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public HardshrinkOptions(Pointer p) { super(p); }

  /* implicit */ public HardshrinkOptions(double lambda/*=0.5*/) { super((Pointer)null); allocate(lambda); }
private native void allocate(double lambda/*=0.5*/);
public HardshrinkOptions() { super((Pointer)null); allocate(); }
private native void allocate();
  public native @ByRef @NoException DoublePointer lambda();
}
