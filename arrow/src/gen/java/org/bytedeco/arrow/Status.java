// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief Status outcome object (success or error)
 * 
 *  The Status object is an object holding the outcome of an operation.
 *  The outcome is represented as a StatusCode, either success
 *  (StatusCode::OK) or an error (any other of the StatusCode enumeration values).
 * 
 *  Additionally, if an error occurred, a specific error message is generally
 *  attached. */
@Namespace("arrow") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class Status extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Status(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public Status(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public Status position(long position) {
        return (Status)super.position(position);
    }
    @Override public Status getPointer(long i) {
        return new Status(this).position(position + i);
    }

  // Create a success status.
  public Status() { super((Pointer)null); allocate(); }
  @NoException private native void allocate();

  public Status(StatusCode code, @StdString String msg) { super((Pointer)null); allocate(code, msg); }
  private native void allocate(StatusCode code, @StdString String msg);
  public Status(@Cast("arrow::StatusCode") byte code, @StdString BytePointer msg) { super((Pointer)null); allocate(code, msg); }
  private native void allocate(@Cast("arrow::StatusCode") byte code, @StdString BytePointer msg);
  /** \brief Pluggable constructor for use by sub-systems.  detail cannot be null. */
  public Status(StatusCode code, @StdString String msg, @SharedPtr StatusDetail detail) { super((Pointer)null); allocate(code, msg, detail); }
  private native void allocate(StatusCode code, @StdString String msg, @SharedPtr StatusDetail detail);
  public Status(@Cast("arrow::StatusCode") byte code, @StdString BytePointer msg, @SharedPtr StatusDetail detail) { super((Pointer)null); allocate(code, msg, detail); }
  private native void allocate(@Cast("arrow::StatusCode") byte code, @StdString BytePointer msg, @SharedPtr StatusDetail detail);

  // Copy the specified status.
  public Status(@Const @ByRef Status s) { super((Pointer)null); allocate(s); }
  private native void allocate(@Const @ByRef Status s);
  public native @ByRef @Name("operator =") Status put(@Const @ByRef Status s);

  // Move the specified status.

  public native @Cast("bool") boolean Equals(@Const @ByRef Status s);

  // AND the statuses.
  public native @ByVal @Name("operator &") @NoException Status and(@Const @ByRef Status s);
  public native @ByRef @Name("operator &=") @NoException Status andPut(@Const @ByRef Status s);

  /** Return a success status */
  public static native @ByVal Status OK();

  /** Return an error status for out-of-memory conditions */

  /** Return an error status for failed key lookups (e.g. column name in a table) */

  /** Return an error status for type errors (such as mismatching data types) */

  /** Return an error status for unknown errors */

  /** Return an error status when an operation or a combination of operation and
   *  data types is unimplemented */

  /** Return an error status for invalid data (for example a string that fails parsing) */

  /** Return an error status when an index is out of bounds */

  /** Return an error status when a container's capacity would exceed its limits */

  /** Return an error status when some IO-related operation failed */

  /** Return an error status when some (de)serialization operation failed */

  /** Return true iff the status indicates success. */
  public native @Cast("bool") boolean ok();

  /** Return true iff the status indicates an out-of-memory error. */
  public native @Cast("bool") boolean IsOutOfMemory();
  /** Return true iff the status indicates a key lookup error. */
  public native @Cast("bool") boolean IsKeyError();
  /** Return true iff the status indicates invalid data. */
  public native @Cast("bool") boolean IsInvalid();
  /** Return true iff the status indicates an IO-related failure. */
  public native @Cast("bool") boolean IsIOError();
  /** Return true iff the status indicates a container reaching capacity limits. */
  public native @Cast("bool") boolean IsCapacityError();
  /** Return true iff the status indicates an out of bounds index. */
  public native @Cast("bool") boolean IsIndexError();
  /** Return true iff the status indicates a type error. */
  public native @Cast("bool") boolean IsTypeError();
  /** Return true iff the status indicates an unknown error. */
  public native @Cast("bool") boolean IsUnknownError();
  /** Return true iff the status indicates an unimplemented operation. */
  public native @Cast("bool") boolean IsNotImplemented();
  /** Return true iff the status indicates a (de)serialization failure */
  public native @Cast("bool") boolean IsSerializationError();
  /** Return true iff the status indicates a R-originated error. */
  public native @Cast("bool") boolean IsRError();

  public native @Cast("bool") boolean IsCodeGenError();

  public native @Cast("bool") boolean IsExpressionValidationError();

  public native @Cast("bool") boolean IsExecutionError();
  
  ///
  public native @Cast("bool") boolean IsAlreadyExists();

  /** \brief Return a string representation of this status suitable for printing.
   * 
   *  The string "OK" is returned for success. */
  public native @StdString String ToString();

  /** \brief Return a string representation of the status code, without the message
   *  text or POSIX code information. */
  public native @StdString String CodeAsString();
  public static native @StdString String CodeAsString(StatusCode arg0);
  public static native @StdString BytePointer CodeAsString(@Cast("arrow::StatusCode") byte arg0);

  /** \brief Return the StatusCode value attached to this status. */
  public native StatusCode code();

  /** \brief Return the specific error message attached to this status. */
  public native @StdString String message();

  /** \brief Return the status detail attached to this message. */
  public native @SharedPtr StatusDetail detail();

  /** \brief Return a new Status copying the existing status, but
   *  updating with the existing detail. */
  public native @ByVal Status WithDetail(@SharedPtr StatusDetail new_detail);

  /** \brief Return a new Status with changed message, copying the
   *  existing status code and detail. */

  public native void Abort(@StdString String message);
  public native void Abort(@StdString BytePointer message);
}
