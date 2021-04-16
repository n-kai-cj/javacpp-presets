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


// XXX: This file exists because TensorImpl is in c10, but Dimname is in ATen.
// Due to the c10/ATen library split, TensorImpl cannot depend on Dimname,
// so we have a couple of workarounds.
//
// In the long term, we'll move Dimname to c10 and everything in this file
// can be refactored out. The main blocker for that is that "c10::Symbol"
// actually exists outside of c10 and needs to be moved in.

// TensorImpl has a unique_ptr<NamedTensorMetaInterface> field.
// XXX: Ideally we would just put optional<vector<Dimname>> into TensorImpl.
//
// This class has an important invariant: there must be at least ONE
// non-wildcard
@Namespace("at") @NoOffset @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class NamedTensorMeta extends NamedTensorMetaInterface {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public NamedTensorMeta(Pointer p) { super(p); }

  // This enum is to remind people that the invariant on constructors is that
  // the list of dimnames must have at least one non-wildcard
  public enum HAS_NON_WILDCARD {
    HasNonWildcard(0);

      public final int value;
      private HAS_NON_WILDCARD(int v) { this.value = v; }
      private HAS_NON_WILDCARD(HAS_NON_WILDCARD e) { this.value = e.value; }
      public HAS_NON_WILDCARD intern() { for (HAS_NON_WILDCARD e : values()) if (e.value == value) return e; return this; }
      @Override public String toString() { return intern().name(); }
  }

  public NamedTensorMeta(HAS_NON_WILDCARD arg0, @ByVal DimnameArrayRef names) { super((Pointer)null); allocate(arg0, names); }
  private native void allocate(HAS_NON_WILDCARD arg0, @ByVal DimnameArrayRef names);
  public NamedTensorMeta(@Cast("at::NamedTensorMeta::HAS_NON_WILDCARD") int arg0, @ByVal DimnameArrayRef names) { super((Pointer)null); allocate(arg0, names); }
  private native void allocate(@Cast("at::NamedTensorMeta::HAS_NON_WILDCARD") int arg0, @ByVal DimnameArrayRef names);
  public NamedTensorMeta(HAS_NON_WILDCARD arg0, @StdMove DimnameVector names) { super((Pointer)null); allocate(arg0, names); }
  private native void allocate(HAS_NON_WILDCARD arg0, @StdMove DimnameVector names);
  public NamedTensorMeta(@Cast("at::NamedTensorMeta::HAS_NON_WILDCARD") int arg0, @StdMove DimnameVector names) { super((Pointer)null); allocate(arg0, names); }
  private native void allocate(@Cast("at::NamedTensorMeta::HAS_NON_WILDCARD") int arg0, @StdMove DimnameVector names);

  public native @UniquePtr NamedTensorMetaInterface clone();

  public native @ByVal DimnameArrayRef names();

  // Used for an assertion in TensorImpl.h
  public native @Cast("int64_t") long slow_dim();

  public native void check_invariants();

  public native void set_names(HAS_NON_WILDCARD arg0, @ByVal DimnameArrayRef new_names);
  public native void set_names(@Cast("at::NamedTensorMeta::HAS_NON_WILDCARD") int arg0, @ByVal DimnameArrayRef new_names);

  public native void set_names(HAS_NON_WILDCARD arg0, @StdMove DimnameVector new_names);
  public native void set_names(@Cast("at::NamedTensorMeta::HAS_NON_WILDCARD") int arg0, @StdMove DimnameVector new_names);

  // INVARIANT: at least one Dimname is non-WILDCARD
  public native @StdMove DimnameVector names_(); public native NamedTensorMeta names_(DimnameVector setter);
}
