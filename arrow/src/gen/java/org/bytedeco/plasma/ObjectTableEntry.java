// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.plasma;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.plasma.*;
  //  namespace internal

/** This type is used by the Plasma store. It is here because it is exposed to
 *  the eviction policy. */
@Namespace("plasma") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.plasma.class)
public class ObjectTableEntry extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ObjectTableEntry(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public ObjectTableEntry(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public ObjectTableEntry position(long position) {
        return (ObjectTableEntry)super.position(position);
    }
    @Override public ObjectTableEntry getPointer(long i) {
        return new ObjectTableEntry(this).position(position + i);
    }

  public ObjectTableEntry() { super((Pointer)null); allocate(); }
  private native void allocate();

  /** Memory mapped file containing the object. */
  public native int fd(); public native ObjectTableEntry fd(int setter);
  /** Device number. */
  public native int device_num(); public native ObjectTableEntry device_num(int setter);
  /** Size of the underlying map. */
  public native @Cast("int64_t") long map_size(); public native ObjectTableEntry map_size(long setter);
  /** Offset from the base of the mmap. */
  public native @Cast("ptrdiff_t") long offset(); public native ObjectTableEntry offset(long setter);
  /** Pointer to the object data. Needed to free the object. */
  public native @Cast("uint8_t*") BytePointer pointer(); public native ObjectTableEntry pointer(BytePointer setter);
  /** Size of the object in bytes. */
  public native @Cast("int64_t") long data_size(); public native ObjectTableEntry data_size(long setter);
  /** Size of the object metadata in bytes. */
  public native @Cast("int64_t") long metadata_size(); public native ObjectTableEntry metadata_size(long setter);
  /** Number of clients currently using this object. */
  public native int ref_count(); public native ObjectTableEntry ref_count(int setter);
  /** Unix epoch of when this object was created. */
  public native @Cast("int64_t") long create_time(); public native ObjectTableEntry create_time(long setter);
  /** How long creation of this object took. */
  public native @Cast("int64_t") long construct_duration(); public native ObjectTableEntry construct_duration(long setter);

  /** The state of the object, e.g., whether it is open or sealed. */
  public native ObjectState state(); public native ObjectTableEntry state(ObjectState setter);
  /** The digest of the object. Used to see if two objects are the same. */
  public native @Cast("unsigned char") byte digest(int i); public native ObjectTableEntry digest(int i, byte setter);
  @MemberGetter public native @Cast("unsigned char*") BytePointer digest();

// #ifdef PLASMA_CUDA
// #else
  public native @SharedPtr CudaIpcPlaceholder ipc_handle(); public native ObjectTableEntry ipc_handle(CudaIpcPlaceholder setter);
// #endif
}
