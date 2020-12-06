// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tvm;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.dnnl.*;
import static org.bytedeco.dnnl.global.dnnl.*;
import org.bytedeco.llvm.LLVM.*;
import static org.bytedeco.llvm.global.LLVM.*;

import static org.bytedeco.tvm.global.tvm_runtime.*;


/**
 * \brief A custom smart pointer for Object.
 * \tparam T the content data type.
 * @see make_object
 */
@Name("tvm::runtime::ObjectPtr<tvm::runtime::Object>") @NoOffset @Properties(inherit = org.bytedeco.tvm.presets.tvm_runtime.class)
public class ObjectPtr extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ObjectPtr(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public ObjectPtr(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public ObjectPtr position(long position) {
        return (ObjectPtr)super.position(position);
    }
    @Override public ObjectPtr getPointer(long i) {
        return new ObjectPtr(this).position(position + i);
    }

  /** \brief default constructor */
  public ObjectPtr() { super((Pointer)null); allocate(); }
  private native void allocate();
  /** \brief default constructor */  // NOLINT(*)
  /**
   * \brief copy constructor
   * @param other The value to be moved
   */
  public ObjectPtr(@Const @ByRef ObjectPtr other) { super((Pointer)null); allocate(other); }
  private native void allocate(@Const @ByRef ObjectPtr other);
  /**
   * \brief copy constructor
   * @param other The value to be moved
   */
  /**
   * \brief move constructor
   * @param other The value to be moved
   */
  /**
   * \brief move constructor
   * @param other The value to be moved
   */
  /** \brief destructor */
  /**
   * \brief Swap this array with another Object
   * @param other The other Object
   */
  public native void swap(@ByRef ObjectPtr other);
  /**
   * @return Get the content of the pointer
   */
  public native TVMObject get();
  /**
   * @return The pointer
   */
  public native @Name("operator ->") TVMObject access();
  /**
   * @return The reference
   */
  public native @ByRef @Name("operator *") TVMObject multiply();
  /**
   * \brief copy assignmemt
   * @param other The value to be assigned.
   * @return reference to self.
   */
  public native @ByRef @Name("operator =") ObjectPtr put(@Const @ByRef ObjectPtr other);
  /**
   * \brief move assignmemt
   * @param other The value to be assigned.
   * @return reference to self.
   */
  /** \brief reset the content of ptr to be nullptr */
  public native void reset();
  /** @return The use count of the ptr, for debug purposes */
  public native int use_count();
  /** @return whether the reference is unique */
  public native @Cast("bool") boolean unique();
  /** @return Whether two ObjectPtr do not equal each other */
  public native @Cast("bool") @Name("operator ==") boolean equals(@Const @ByRef ObjectPtr other);
  /** @return Whether two ObjectPtr equals each other */
  public native @Cast("bool") @Name("operator !=") boolean notEquals(@Const @ByRef ObjectPtr other);
  /** @return Whether the pointer is nullptr */
  /** @return Whether the pointer is not nullptr */
}
