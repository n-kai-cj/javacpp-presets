// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.arrow_dataset;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;
import org.bytedeco.parquet.*;
import static org.bytedeco.arrow.global.parquet.*;

import static org.bytedeco.arrow.global.arrow_dataset.*;


/** \brief A generic Iterator that can return errors */
@Name("arrow::Iterator<std::shared_ptr<arrow::dataset::Fragment> >") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow_dataset.class)
public class FragmentIterator extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FragmentIterator(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public FragmentIterator(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public FragmentIterator position(long position) {
        return (FragmentIterator)super.position(position);
    }
    @Override public FragmentIterator getPointer(long i) {
        return new FragmentIterator(this).position(position + i);
    }

  /** \brief Iterator may be constructed from any type which has a member function
   *  with signature Status Next(T*);
   * 
   *  The argument is moved or copied to the heap and kept in a unique_ptr<void>. Only
   *  its destructor and its Next method (which are stored in function pointers) are
   *  referenced after construction.
   * 
   *  This approach is used to dodge MSVC linkage hell (ARROW-6244, ARROW-6558) when using
   *  an abstract template base class: instead of being inlined as usual for a template
   *  function the base's virtual destructor will be exported, leading to multiple
   *  definition errors when linking to any other TU where the base is instantiated. */

  public FragmentIterator() { super((Pointer)null); allocate(); }
  private native void allocate();

  /** \brief Return the next element of the sequence, IterationTraits<T>::End() when the
   *  iteration is completed. Calling this on a default constructed Iterator
   *  will result in undefined behavior. */
  public native @ByVal FragmentResult Next();

  /** Pass each element of the sequence to a visitor. Will return any error status
   *  returned by the visitor, terminating iteration. */

  /** Iterators will only compare equal if they are both null.
   *  Equality comparability is required to make an Iterator of Iterators
   *  (to check for the end condition). */
  public native @Cast("bool") boolean Equals(@Const @ByRef FragmentIterator other);

  public native @Cast("bool") @Name("operator bool") boolean asBoolean();

  @NoOffset public static class RangeIterator extends Pointer {
      static { Loader.load(); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public RangeIterator(Pointer p) { super(p); }
      /** Native array allocator. Access with {@link Pointer#position(long)}. */
      public RangeIterator(long size) { super((Pointer)null); allocateArray(size); }
      private native void allocateArray(long size);
      @Override public RangeIterator position(long position) {
          return (RangeIterator)super.position(position);
      }
      @Override public RangeIterator getPointer(long i) {
          return new RangeIterator(this).position(position + i);
      }
  
    public RangeIterator() { super((Pointer)null); allocate(); }
    private native void allocate();

    public RangeIterator(@ByVal FragmentIterator i) { super((Pointer)null); allocate(i); }
    private native void allocate(@ByVal FragmentIterator i);

    public native @Cast("bool") @Name("operator !=") boolean notEquals(@Const @ByRef RangeIterator other);

    public native @ByRef @Name("operator ++") RangeIterator increment();

    public native @ByVal @Name("operator *") FragmentResult multiply();
  }

  public native @ByVal RangeIterator begin();

  public native @ByVal RangeIterator end();

  /** \brief Move every element of this iterator into a vector. */
  public native @ByVal FragmentVectorResult ToVector();
}
