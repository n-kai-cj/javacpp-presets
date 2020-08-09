// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.parquet;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.parquet.*;


// Reference:
// parquet-mr/parquet-hadoop/src/main/java/org/apache/parquet/
//                            format/converter/ParquetMetadataConverter.java
// Sort order for page and column statistics. Types are associated with sort
// orders (e.g., UTF8 columns should use UNSIGNED) and column stats are
// aggregated using a sort order. As of parquet-format version 2.3.1, the
// order used to aggregate stats is always SIGNED and is not stored in the
// Parquet file. These stats are discarded for types that need unsigned.
// See PARQUET-686.
@Namespace("parquet") @Properties(inherit = org.bytedeco.arrow.presets.parquet.class)
public class SortOrder extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SortOrder() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SortOrder(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SortOrder(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SortOrder position(long position) {
        return (SortOrder)super.position(position);
    }
    @Override public SortOrder getPointer(long i) {
        return new SortOrder(this).position(position + i);
    }

  public enum type { SIGNED(0), UNSIGNED(1), UNKNOWN(2);

      public final int value;
      private type(int v) { this.value = v; }
      private type(type e) { this.value = e.value; }
      public type intern() { for (type e : values()) if (e.value == value) return e; return this; }
      @Override public String toString() { return intern().name(); }
  }
}
