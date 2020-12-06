// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.parquet;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.parquet.*;


@Namespace("parquet") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.parquet.class)
public class ColumnCryptoMetaData extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ColumnCryptoMetaData(Pointer p) { super(p); }

  public static native @UniquePtr ColumnCryptoMetaData Make(@Cast("const uint8_t*") BytePointer metadata);
  public static native @UniquePtr ColumnCryptoMetaData Make(@Cast("const uint8_t*") ByteBuffer metadata);
  public static native @UniquePtr ColumnCryptoMetaData Make(@Cast("const uint8_t*") byte[] metadata);

  public native @SharedPtr ColumnPath path_in_schema();
  public native @Cast("bool") boolean encrypted_with_footer_key();
  public native @StdString String key_metadata();
}
