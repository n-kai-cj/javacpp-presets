// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** Concrete Array class for boolean data */
@Namespace("arrow") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class BooleanArray extends PrimitiveArray {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public BooleanArray(Pointer p) { super(p); }


  public BooleanArray(@SharedPtr @Cast({"", "std::shared_ptr<arrow::ArrayData>"}) ArrayData data) { super((Pointer)null); allocate(data); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::ArrayData>"}) ArrayData data);

  public BooleanArray(@Cast("int64_t") long length, @SharedPtr ArrowBuffer data,
                 @SharedPtr ArrowBuffer null_bitmap/*=nullptr*/,
                 @Cast("int64_t") long null_count/*=arrow::kUnknownNullCount*/, @Cast("int64_t") long offset/*=0*/) { super((Pointer)null); allocate(length, data, null_bitmap, null_count, offset); }
  private native void allocate(@Cast("int64_t") long length, @SharedPtr ArrowBuffer data,
                 @SharedPtr ArrowBuffer null_bitmap/*=nullptr*/,
                 @Cast("int64_t") long null_count/*=arrow::kUnknownNullCount*/, @Cast("int64_t") long offset/*=0*/);
  public BooleanArray(@Cast("int64_t") long length, @SharedPtr ArrowBuffer data) { super((Pointer)null); allocate(length, data); }
  private native void allocate(@Cast("int64_t") long length, @SharedPtr ArrowBuffer data);

  public native @Cast("bool") boolean Value(@Cast("int64_t") long i);

  public native @Cast("bool") boolean GetView(@Cast("int64_t") long i);

  /** \brief Return the number of false (0) values among the valid
   *  values. Result is not cached. */
  public native @Cast("int64_t") long false_count();

  /** \brief Return the number of true (1) values among the valid
   *  values. Result is not cached. */
  public native @Cast("int64_t") long true_count();
}
