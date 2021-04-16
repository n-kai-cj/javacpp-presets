// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;
  // IWYU pragma: keep

@Namespace("arrow::detail") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class Fingerprintable extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Fingerprintable(Pointer p) { super(p); }


  public native @StdString String fingerprint();

  public native @StdString String metadata_fingerprint();
}
