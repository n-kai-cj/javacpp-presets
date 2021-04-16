// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


@Namespace("arrow::csv") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class ReadOptions extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public ReadOptions() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public ReadOptions(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ReadOptions(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public ReadOptions position(long position) {
        return (ReadOptions)super.position(position);
    }
    @Override public ReadOptions getPointer(long i) {
        return new ReadOptions((Pointer)this).position(position + i);
    }

  // Reader options

  /** Whether to use the global CPU thread pool */
  public native @Cast("bool") boolean use_threads(); public native ReadOptions use_threads(boolean setter);
  /** Block size we request from the IO layer; also determines the size of
   *  chunks when use_threads is true */
  public native int block_size(); public native ReadOptions block_size(int setter);  // 1 MB

  /** Number of header rows to skip (not including the row of column names, if any) */
  public native int skip_rows(); public native ReadOptions skip_rows(int setter);
  /** Column names for the target table.
   *  If empty, fall back on autogenerate_column_names. */
  public native @ByRef StringVector column_names(); public native ReadOptions column_names(StringVector setter);
  /** Whether to autogenerate column names if {@code column_names} is empty.
   *  If true, column names will be of the form "f0", "f1"...
   *  If false, column names will be read from the first CSV row after {@code skip_rows}. */
  public native @Cast("bool") boolean autogenerate_column_names(); public native ReadOptions autogenerate_column_names(boolean setter);

  /** Create read options with default values */
  public static native @ByVal ReadOptions Defaults();
}
