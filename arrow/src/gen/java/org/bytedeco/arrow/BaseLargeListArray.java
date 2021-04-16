// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;

@Name("arrow::BaseListArray<arrow::LargeListType>") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class BaseLargeListArray extends Array {
    static { Loader.load(); }
    /** Default native constructor. */
    public BaseLargeListArray() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public BaseLargeListArray(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public BaseLargeListArray(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public BaseLargeListArray position(long position) {
        return (BaseLargeListArray)super.position(position);
    }
    @Override public BaseLargeListArray getPointer(long i) {
        return new BaseLargeListArray((Pointer)this).position(position + i);
    }


  public native @Cast("const arrow::BaseListArray<arrow::LargeListType>::TypeClass*") LargeListType list_type();

  /** \brief Return array object containing the list's values */
  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array values();

  /** Note that this buffer does not account for any slice offset */
  public native @SharedPtr ArrowBuffer value_offsets();

  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType value_type();

  /** Return pointer to raw value offsets accounting for any slice offset */
  public native @Cast("const arrow::BaseListArray<arrow::LargeListType>::offset_type*") LongPointer raw_value_offsets();

  // The following functions will not perform boundschecking
  public native @Cast("arrow::BaseListArray<arrow::LargeListType>::offset_type") long value_offset(@Cast("int64_t") long i);
  public native @Cast("arrow::BaseListArray<arrow::LargeListType>::offset_type") long value_length(@Cast("int64_t") long i);
  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array value_slice(@Cast("int64_t") long i);
}
