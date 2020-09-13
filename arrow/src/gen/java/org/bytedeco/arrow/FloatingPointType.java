// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief Base class for all floating-point data types */
@Namespace("arrow") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class FloatingPointType extends NumberType {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FloatingPointType(Pointer p) { super(p); }

  public enum Precision { HALF(0), SINGLE(1), DOUBLE(2);

      public final int value;
      private Precision(int v) { this.value = v; }
      private Precision(Precision e) { this.value = e.value; }
      public Precision intern() { for (Precision e : values()) if (e.value == value) return e; return this; }
      @Override public String toString() { return intern().name(); }
  }
  public native Precision precision();
}
