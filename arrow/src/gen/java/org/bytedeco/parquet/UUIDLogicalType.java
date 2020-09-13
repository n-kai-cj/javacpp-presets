// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.parquet;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.parquet.*;


/** \brief Allowed for physical type FIXED_LEN_BYTE_ARRAY with length 16,
 *  must encode raw UUID bytes. */
@Namespace("parquet") @Properties(inherit = org.bytedeco.arrow.presets.parquet.class)
public class UUIDLogicalType extends LogicalType {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public UUIDLogicalType(Pointer p) { super(p); }

  public static native @Cast("const parquet::LogicalType*") @SharedPtr @ByVal LogicalType Make();
}
