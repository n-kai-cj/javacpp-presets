// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


@Namespace("arrow::compute") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class MatchSubstringOptions extends FunctionOptions {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MatchSubstringOptions(Pointer p) { super(p); }

  public MatchSubstringOptions(@StdString String pattern) { super((Pointer)null); allocate(pattern); }
  private native void allocate(@StdString String pattern);
  public MatchSubstringOptions(@StdString BytePointer pattern) { super((Pointer)null); allocate(pattern); }
  private native void allocate(@StdString BytePointer pattern);

  /** The exact substring to look for inside input values. */
  public native @StdString String pattern(); public native MatchSubstringOptions pattern(String setter);
}
