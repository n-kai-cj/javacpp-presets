// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief The combination of a field name and data type, with optional metadata
 * 
 *  Fields are used to describe the individual constituents of a
 *  nested DataType or a Schema.
 * 
 *  A field's metadata is represented by a KeyValueMetadata instance,
 *  which holds arbitrary key-value pairs. */
@Namespace("arrow") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class Field extends Fingerprintable {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Field(Pointer p) { super(p); }

  public Field(@StdString String name, @SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @Cast("bool") boolean nullable/*=true*/,
          @Cast("const arrow::KeyValueMetadata*") @SharedPtr @ByVal(nullValue = "std::shared_ptr<const arrow::KeyValueMetadata>(nullptr)") KeyValueMetadata metadata) { super((Pointer)null); allocate(name, type, nullable, metadata); }
  private native void allocate(@StdString String name, @SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @Cast("bool") boolean nullable/*=true*/,
          @Cast("const arrow::KeyValueMetadata*") @SharedPtr @ByVal(nullValue = "std::shared_ptr<const arrow::KeyValueMetadata>(nullptr)") KeyValueMetadata metadata);
  public Field(@StdString String name, @SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type) { super((Pointer)null); allocate(name, type); }
  private native void allocate(@StdString String name, @SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type);
  public Field(@StdString BytePointer name, @SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @Cast("bool") boolean nullable/*=true*/,
          @Cast("const arrow::KeyValueMetadata*") @SharedPtr @ByVal(nullValue = "std::shared_ptr<const arrow::KeyValueMetadata>(nullptr)") KeyValueMetadata metadata) { super((Pointer)null); allocate(name, type, nullable, metadata); }
  private native void allocate(@StdString BytePointer name, @SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @Cast("bool") boolean nullable/*=true*/,
          @Cast("const arrow::KeyValueMetadata*") @SharedPtr @ByVal(nullValue = "std::shared_ptr<const arrow::KeyValueMetadata>(nullptr)") KeyValueMetadata metadata);
  public Field(@StdString BytePointer name, @SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type) { super((Pointer)null); allocate(name, type); }
  private native void allocate(@StdString BytePointer name, @SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type);

  /** \brief Return the field's attached metadata */
  public native @Cast("const arrow::KeyValueMetadata*") @SharedPtr @ByVal KeyValueMetadata metadata();

  /** \brief Return whether the field has non-empty metadata */
  public native @Cast("bool") boolean HasMetadata();

  /** \brief Return a copy of this field with the given metadata attached to it */
  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::Field>"}) Field WithMetadata(
        @Const @Cast("const arrow::KeyValueMetadata*") @SharedPtr @ByRef KeyValueMetadata metadata);

  /** \brief EXPERIMENTAL: Return a copy of this field with the given metadata
   *  merged with existing metadata (any colliding keys will be overridden by
   *  the passed metadata) */
  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::Field>"}) Field WithMergedMetadata(
        @Const @Cast("const arrow::KeyValueMetadata*") @SharedPtr @ByRef KeyValueMetadata metadata);

  /** \brief Return a copy of this field without any metadata attached to it */
  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::Field>"}) Field RemoveMetadata();

  /** \brief Return a copy of this field with the replaced type. */
  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::Field>"}) Field WithType(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type);

  /** \brief Return a copy of this field with the replaced name. */
  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::Field>"}) Field WithName(@StdString String name);
  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::Field>"}) Field WithName(@StdString BytePointer name);

  /** \brief Return a copy of this field with the replaced nullability. */
  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::Field>"}) Field WithNullable(@Cast("bool") boolean nullable);

  /** \brief Options that control the behavior of {@code MergeWith}.
   *  Options are to be added to allow type conversions, including integer
   *  widening, promotion from integer to float, or conversion to or from boolean. */
  public static class MergeOptions extends Pointer {
      static { Loader.load(); }
      /** Default native constructor. */
      public MergeOptions() { super((Pointer)null); allocate(); }
      /** Native array allocator. Access with {@link Pointer#position(long)}. */
      public MergeOptions(long size) { super((Pointer)null); allocateArray(size); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public MergeOptions(Pointer p) { super(p); }
      private native void allocate();
      private native void allocateArray(long size);
      @Override public MergeOptions position(long position) {
          return (MergeOptions)super.position(position);
      }
      @Override public MergeOptions getPointer(long i) {
          return new MergeOptions(this).position(position + i);
      }
  
    /** If true, a Field of NullType can be unified with a Field of another type.
     *  The unified field will be of the other type and become nullable.
     *  Nullability will be promoted to the looser option (nullable if one is not
     *  nullable). */
    public native @Cast("bool") boolean promote_nullability(); public native MergeOptions promote_nullability(boolean setter);

    public static native @ByVal MergeOptions Defaults();
  }

  /** \brief Merge the current field with a field of the same name.
   * 
   *  The two fields must be compatible, i.e:
   *    - have the same name
   *    - have the same type, or of compatible types according to {@code options}.
   * 
   *  The metadata of the current field is preserved; the metadata of the other
   *  field is discarded. */
  public native @ByVal FieldResult MergeWith(
        @Const @ByRef Field other, @ByVal(nullValue = "arrow::Field::MergeOptions::Defaults()") MergeOptions options);
  public native @ByVal FieldResult MergeWith(
        @Const @ByRef Field other);

  
  ///
  ///
  public native @ByVal FieldVector Flatten();

  /** \brief Indicate if fields are equals.
   * 
   *  @param other [in] field to check equality with.
   *  @param check_metadata [in] controls if it should check for metadata
   *             equality.
   * 
   *  @return true if fields are equal, false otherwise. */
  public native @Cast("bool") boolean Equals(@Const @ByRef Field other, @Cast("bool") boolean check_metadata/*=false*/);
  public native @Cast("bool") boolean Equals(@Const @ByRef Field other);

  /** \brief Indicate if fields are compatibles.
   * 
   *  See the criteria of MergeWith.
   * 
   *  @return true if fields are compatible, false otherwise. */
  public native @Cast("bool") boolean IsCompatibleWith(@Const @ByRef Field other);

  /** \brief Return a string representation ot the field
   *  @param show_metadata [in] when true, if KeyValueMetadata is non-empty,
   *  print keys and values in the output */
  public native @StdString String ToString(@Cast("bool") boolean show_metadata/*=false*/);
  public native @StdString String ToString();

  /** \brief Return the field name */
  public native @StdString String name();
  /** \brief Return the field data type */
  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type();
  /** \brief Return whether the field is nullable */
  public native @Cast("bool") boolean nullable();

  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::Field>"}) Field Copy();
}
