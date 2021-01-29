// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


@Namespace("arrow::fs") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class FileSystemGlobalOptions extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public FileSystemGlobalOptions() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public FileSystemGlobalOptions(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FileSystemGlobalOptions(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public FileSystemGlobalOptions position(long position) {
        return (FileSystemGlobalOptions)super.position(position);
    }
    @Override public FileSystemGlobalOptions getPointer(long i) {
        return new FileSystemGlobalOptions((Pointer)this).position(position + i);
    }

  /** Path to a single PEM file holding all TLS CA certificates
   * 
   *  If empty, the underlying TLS library's defaults will be used. */
  
  ///
  public native @StdString String tls_ca_file_path(); public native FileSystemGlobalOptions tls_ca_file_path(String setter);

  /** Path to a directory holding TLS CA certificates in individual PEM files
   *  named along the OpenSSL "hashed" format.
   * 
   *  If empty, the underlying TLS library's defaults will be used. */
  public native @StdString String tls_ca_dir_path(); public native FileSystemGlobalOptions tls_ca_dir_path(String setter);
}
