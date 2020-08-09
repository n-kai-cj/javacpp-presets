// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** Concrete type class for 32-bit time data (as number of seconds or milliseconds
 *  since midnight) */
@Namespace("arrow") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class Time32Type extends TimeType {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Time32Type(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public Time32Type(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public Time32Type position(long position) {
        return (Time32Type)super.position(position);
    }
    @Override public Time32Type getPointer(long i) {
        return new Time32Type(this).position(position + i);
    }

  @MemberGetter public static native @Cast("const arrow::Type::type") int type_id();
  public static final int type_id = type_id();

  public static native String type_name();

  public native int bit_width();

  public Time32Type(TimeUnit.type unit/*=arrow::TimeUnit::MILLI*/) { super((Pointer)null); allocate(unit); }
  private native void allocate(TimeUnit.type unit/*=arrow::TimeUnit::MILLI*/);
  public Time32Type() { super((Pointer)null); allocate(); }
  private native void allocate();
  public Time32Type(@Cast("arrow::TimeUnit::type") int unit/*=arrow::TimeUnit::MILLI*/) { super((Pointer)null); allocate(unit); }
  private native void allocate(@Cast("arrow::TimeUnit::type") int unit/*=arrow::TimeUnit::MILLI*/);

  public native @StdString String ToString();

  public native @StdString String name();
}
