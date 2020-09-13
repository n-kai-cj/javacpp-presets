// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Represents a tensor value that can be used as an operand to an Operation. */
@Namespace("tensorflow") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class Input extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Input(Pointer p) { super(p); }

  /** Initializer enables constructing an Input object from various kinds of C++
   *  constants such as simple primitive constants and nested initializer lists
   *  representing a multi-dimensional array. Initializer constructors are all
   *  templates, so the aforementioned kinds of C++ constants can be used to
   *  construct an Initializer. Initializer stores the value it got constructed
   *  with in a Tensor object. */
  @NoOffset public static class Initializer extends Pointer {
      static { Loader.load(); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public Initializer(Pointer p) { super(p); }
  
    /** Construct from a scalar value of an arithmetic type or a type that can
     *  be converted to a string (eg. a string literal). */

    public Initializer(@Const @ByRef Tensor t) { super((Pointer)null); allocate(t); }
    private native void allocate(@Const @ByRef Tensor t);  // NOLINT(runtime/explicit)

    /** Construct from a scalar value and an explicit shape */

    /** Construct from a initializer list of scalars (a one-dimensional tensor). */

    /** Construct from a initializer list of scalars and an explicit shape. */

    /** Construct a multi-dimensional tensor from a nested initializer
     *  list. Note that C++ syntax allows nesting of arbitrarily typed
     *  initializer lists, so such invalid initializers cannot be disallowed at
     *  compile time. This function performs checks to make sure that the nested
     *  initializer list is indeed a valid multi-dimensional tensor. */

    // START_SKIP_DOXYGEN
    // END_SKIP_DOXYGEN

    public native @ByVal TensorProto AsTensorProto();

    public native @ByRef Status status(); public native Initializer status(Status setter);
    public native @ByRef Tensor tensor(); public native Initializer tensor(Tensor setter);
  }

  /** All of Input's constructors are implicit. Input can be implicitly
   *  constructed from the following objects :
   *  * Output: This is so that the output of an Operation can be directly used
   *    as the input to a op wrapper, which takes Inputs.
   *  * A scalar, or a multi-dimensional tensor specified as a recursive
   *    initializer list. This enables directly passing constants as
   *    inputs to op wrappers.
   *  * A Tensor object. */
  public Input(@Const @ByRef Output o) { super((Pointer)null); allocate(o); }
  private native void allocate(@Const @ByRef Output o);  // NOLINT(runtime/explicit)

  public Input(@Const @ByRef Input.Initializer init) { super((Pointer)null); allocate(init); }
  private native void allocate(@Const @ByRef Input.Initializer init);
  public Input(@ByRef Tensor init) { super((Pointer)null); allocate(init); }
  private native void allocate(@ByRef Tensor init);
  public Input(byte init) { super((Pointer)null); allocate(init); }
  private native void allocate(byte init);
  public Input(short init) { super((Pointer)null); allocate(init); }
  private native void allocate(short init);
  public Input(int init) { super((Pointer)null); allocate(init); }
  private native void allocate(int init);
  public Input(long init) { super((Pointer)null); allocate(init); }
  private native void allocate(long init);
  public Input(float init) { super((Pointer)null); allocate(init); }
  private native void allocate(float init);
  public Input(double init) { super((Pointer)null); allocate(init); }
  private native void allocate(double init);
  public Input(boolean init) { super((Pointer)null); allocate(init); }
  private native void allocate(boolean init);
  public Input(@StdString String init) { super((Pointer)null); allocate(init); }
  private native void allocate(@StdString String init);
  public Input(@StdString BytePointer init) { super((Pointer)null); allocate(init); }
  private native void allocate(@StdString BytePointer init);

  /** Constructor specifying a node name, index and datatype. This should only
   *  be used for specifying a backward edge, needed by control flow. */
  public Input(@StdString BytePointer name, int i, @Cast("tensorflow::DataType") int dt) { super((Pointer)null); allocate(name, i, dt); }
  private native void allocate(@StdString BytePointer name, int i, @Cast("tensorflow::DataType") int dt);
  public Input(@StdString String name, int i, @Cast("tensorflow::DataType") int dt) { super((Pointer)null); allocate(name, i, dt); }
  private native void allocate(@StdString String name, int i, @Cast("tensorflow::DataType") int dt);

  public native Node node();
  public native @StdString BytePointer node_name();
  public native int index();
  public native @Cast("tensorflow::DataType") int data_type();
  public native @ByVal Status status();
  public native @Const @ByRef Tensor tensor();
}
