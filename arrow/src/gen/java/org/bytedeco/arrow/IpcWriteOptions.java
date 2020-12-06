// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief Options for writing Arrow IPC messages */
@Namespace("arrow::ipc") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class IpcWriteOptions extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public IpcWriteOptions() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public IpcWriteOptions(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IpcWriteOptions(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public IpcWriteOptions position(long position) {
        return (IpcWriteOptions)super.position(position);
    }
    @Override public IpcWriteOptions getPointer(long i) {
        return new IpcWriteOptions(this).position(position + i);
    }

  // If true, allow field lengths that don't fit in a signed 32-bit int.
  // Some implementations may not be able to parse such streams.
  public native @Cast("bool") boolean allow_64bit(); public native IpcWriteOptions allow_64bit(boolean setter);
  // The maximum permitted schema nesting depth.
  public native int max_recursion_depth(); public native IpcWriteOptions max_recursion_depth(int setter);

  // Write padding after memory buffers to this multiple of
  // bytes. Generally 8 or 64
  public native int alignment(); public native IpcWriteOptions alignment(int setter);

  /** \brief Write the pre-0.15.0 encapsulated IPC message format
   *  consisting of a 4-byte prefix instead of 8 byte */
  public native @Cast("bool") boolean write_legacy_ipc_format(); public native IpcWriteOptions write_legacy_ipc_format(boolean setter);

  /** \brief The memory pool to use for allocations made during IPC writing */
  
  ///
  public native MemoryPool memory_pool(); public native IpcWriteOptions memory_pool(MemoryPool setter);

  /** \brief Compression codec to use for record batch body buffers
   * 
   *  May only be UNCOMPRESSED, LZ4_FRAME and ZSTD. */
  public native @SharedPtr Codec codec(); public native IpcWriteOptions codec(Codec setter);

  /** \brief Use global CPU thread pool to parallelize any computational tasks
   *  like compression */
  
  ///
  public native @Cast("bool") boolean use_threads(); public native IpcWriteOptions use_threads(boolean setter);

  /** \brief Format version to use for IPC messages and their metadata.
   * 
   *  Presently using V5 version (readable by 1.0.0 and later).
   *  V4 is also available (readable by 0.8.0 and later). */
  public native MetadataVersion metadata_version(); public native IpcWriteOptions metadata_version(MetadataVersion setter);

  public static native @ByVal IpcWriteOptions Defaults();
}
