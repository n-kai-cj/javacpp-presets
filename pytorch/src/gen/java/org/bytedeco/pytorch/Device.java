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


/** Represents a a compute device on which a tensor is located. A device is
 *  uniquely identified by a type, which specifies the type of machine it is
 *  (e.g. CPU or CUDA GPU), and a device index or ordinal, which identifies the
 *  specific compute device when there is more than one of a certain type. The
 *  device index is optional, and in its defaulted state represents (abstractly)
 *  "the current device". Further, there are two constraints on the value of the
 *  device index, if one is explicitly stored:
 *  1. A negative index represents the current device, a non-negative index
 *  represents a specific, concrete device,
 *  2. When the device type is CPU, the device index must be zero. */
@Namespace("c10") @NoOffset @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class Device extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Device(Pointer p) { super(p); }


  /** Constructs a new {@code Device} from a {@code DeviceType} and an optional device
   *  index. */
  /* implicit */ public Device(DeviceType type, @Cast("c10::DeviceIndex") byte index/*=-1*/) { super((Pointer)null); allocate(type, index); }
private native void allocate(DeviceType type, @Cast("c10::DeviceIndex") byte index/*=-1*/);
public Device(DeviceType type) { super((Pointer)null); allocate(type); }
private native void allocate(DeviceType type);
public Device(@Cast("c10::DeviceType") byte type, @Cast("c10::DeviceIndex") byte index/*=-1*/) { super((Pointer)null); allocate(type, index); }
private native void allocate(@Cast("c10::DeviceType") byte type, @Cast("c10::DeviceIndex") byte index/*=-1*/);
public Device(@Cast("c10::DeviceType") byte type) { super((Pointer)null); allocate(type); }
private native void allocate(@Cast("c10::DeviceType") byte type);

  /** Constructs a {@code Device} from a string description, for convenience.
   *  The string supplied must follow the following schema:
   *  {@code (cpu|cuda)[:<device-index>]}
   *  where {@code cpu} or {@code cuda} specifies the device type, and
   *  {@code :<device-index>} optionally specifies a device index. */
  /* implicit */ public Device(@StdString BytePointer device_string) { super((Pointer)null); allocate(device_string); }
private native void allocate(@StdString BytePointer device_string);
public Device(@StdString String device_string) { super((Pointer)null); allocate(device_string); }
private native void allocate(@StdString String device_string);

  /** Returns true if the type and index of this {@code Device} matches that of
   *  {@code other}. */
  

  /** Returns true if the type or index of this {@code Device} differs from that of
   *  {@code other}. */
  

  /** Sets the device index. */
  public native void set_index(@Cast("c10::DeviceIndex") byte index);

  /** Returns the type of device this is. */
  public native @NoException DeviceType type();

  /** Returns the optional index. */
  public native @Cast("c10::DeviceIndex") @NoException byte index();

  /** Returns true if the device has a non-default index. */
  public native @Cast("bool") @NoException boolean has_index();

  /** Return true if the device is of CUDA type. */
  public native @Cast("bool") @NoException boolean is_cuda();

  /** Return true if the device is of XPU type. */
  public native @Cast("bool") @NoException boolean is_xpu();

  /** Return true if the device is of CPU type. */
  public native @Cast("bool") @NoException boolean is_cpu();

  /** Same string as returned from operator<<. */
  public native @StdString BytePointer str();
}
