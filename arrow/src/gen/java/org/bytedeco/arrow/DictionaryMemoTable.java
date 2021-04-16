// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


// ----------------------------------------------------------------------
// Dictionary builder

@Namespace("arrow::internal") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class DictionaryMemoTable extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DictionaryMemoTable(Pointer p) { super(p); }

  public DictionaryMemoTable(MemoryPool pool, @SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type) { super((Pointer)null); allocate(pool, type); }
  private native void allocate(MemoryPool pool, @SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type);
  public DictionaryMemoTable(MemoryPool pool, @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array dictionary) { super((Pointer)null); allocate(pool, dictionary); }
  private native void allocate(MemoryPool pool, @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array dictionary);

  public native @ByVal Status GetArrayData(@Cast("int64_t") long start_offset, @SharedPtr ArrayData out);

  /** \brief Insert new memo values */
  public native @ByVal Status InsertValues(@Const @ByRef Array values);

  public native int size();
}
