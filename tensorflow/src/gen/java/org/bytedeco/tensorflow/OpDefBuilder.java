// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


// Builder class passed to the REGISTER_OP() macro.
@Namespace("tensorflow") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class OpDefBuilder extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public OpDefBuilder(Pointer p) { super(p); }

  // Constructs an OpDef with just the name field set.
  public OpDefBuilder(@StdString BytePointer op_name) { super((Pointer)null); allocate(op_name); }
  private native void allocate(@StdString BytePointer op_name);
  public OpDefBuilder(@StdString String op_name) { super((Pointer)null); allocate(op_name); }
  private native void allocate(@StdString String op_name);

  // Adds an attr to this OpDefBuilder (and returns *this). The spec has
  // format "<name>:<type>" or "<name>:<type>=<default>"
  // where <name> matches regexp [a-zA-Z][a-zA-Z0-9_]*
  // (by convention only using capital letters for attrs that can be inferred)
  // <type> can be:
  //   "string", "int", "float", "bool", "type", "shape", or "tensor"
  //   "numbertype", "realnumbertype", "quantizedtype"
  //       (meaning "type" with a restriction on valid values)
  //   "{int32,int64}" or {realnumbertype,quantizedtype,string}"
  //       (meaning "type" with a restriction containing unions of value types)
  //   "{\"foo\", \"bar\n baz\"}", or "{'foo', 'bar\n baz'}"
  //       (meaning "string" with a restriction on valid values)
  //   "list(string)", ..., "list(tensor)", "list(numbertype)", ...
  //       (meaning lists of the above types)
  //   "int >= 2" (meaning "int" with a restriction on valid values)
  //   "list(string) >= 2", "list(int) >= 2"
  //       (meaning "list(string)" / "list(int)" with length at least 2)
  // <default>, if included, should use the Proto text format
  // of <type>.  For lists use [a, b, c] format.
  //
  // Note that any attr specifying the length of an input or output will
  // get a default minimum of 1 unless the >= # syntax is used.
  //
  // TODO(josh11b): Perhaps support restrictions and defaults as optional
  // extra arguments to Attr() instead of encoding them in the spec string.
  // TODO(josh11b): Would like to have better dtype handling for tensor attrs:
  // * Ability to say the type of an input/output matches the type of
  //   the tensor.
  // * Ability to restrict the type of the tensor like the existing
  //   restrictions for type attrs.
  // Perhaps by linking the type of the tensor to a type attr?
  public native @ByRef OpDefBuilder Attr(@StdString BytePointer spec);
  public native @ByRef OpDefBuilder Attr(@StdString String spec);

  // Adds an input or output to this OpDefBuilder (and returns *this).
  // The spec has form "<name>:<type-expr>" or "<name>:Ref(<type-expr>)"
  // where <name> matches regexp [a-z][a-z0-9_]* and <type-expr> can be:
  // * For a single tensor: <type>
  // * For a sequence of tensors with the same type: <number>*<type>
  // * For a sequence of tensors with different types: <type-list>
  // Where:
  //   <type> is either one of "float", "int32", "string", ...
  //                 or the name of an attr (see above) with type "type".
  //   <number> is the name of an attr with type "int".
  //   <type-list> is the name of an attr with type "list(type)".
  // TODO(josh11b): Indicate Ref() via an optional argument instead of
  // in the spec?
  // TODO(josh11b): SparseInput() and SparseOutput() matching the Python
  // handling?
  public native @ByRef OpDefBuilder Input(@StdString BytePointer spec);
  public native @ByRef OpDefBuilder Input(@StdString String spec);
  public native @ByRef OpDefBuilder Output(@StdString BytePointer spec);
  public native @ByRef OpDefBuilder Output(@StdString String spec);

  // Turns on the indicated boolean flag in this OpDefBuilder (and
  // returns *this).
  public native @ByRef OpDefBuilder SetIsCommutative();
  public native @ByRef OpDefBuilder SetIsAggregate();
  public native @ByRef OpDefBuilder SetIsStateful();
  public native @ByRef OpDefBuilder SetAllowsUninitializedInput();

  // Deprecate the op at a certain GraphDef version.
  public native @ByRef OpDefBuilder Deprecated(int version, @StdString BytePointer explanation);
  public native @ByRef OpDefBuilder Deprecated(int version, @StdString String explanation);

  // Adds docs to this OpDefBuilder (and returns *this).
  // Docs have the format:
  //   <1-line summary>
  //   <rest of the description>
  //   <name>: <description of name>
  //   <name>: <description of name>
  //     <if long, indent the description on subsequent lines>
  // Where <name> is the name of an attr, input, or output.  Please
  // wrap docs at 72 columns so that it may be indented in the
  // generated output.  For tensor inputs or outputs (not attrs), you
  // may start the description with an "=" (like name:= <description>)
  // to suppress the automatically-generated type documentation in
  // generated output.
// #ifndef TF_LEAN_BINARY
  public native @ByRef OpDefBuilder Doc(@StdString BytePointer text);
  public native @ByRef OpDefBuilder Doc(@StdString String text);
// #else
// #endif

  // Sets the shape function to be used for shape inference.
  //
  // Note that currently (October 2016), python code still requires a
  // RegisterShape call to invoke this; see call_cpp_shape_fn in
  // python/framework/common_shapes.py
  public native @ByRef OpDefBuilder SetShapeFn(@ByVal @Cast("tensorflow::OpShapeInferenceFn*") Pointer fn);

  // Sets op_reg_data->op_def to the requested OpDef and
  // op_reg_data->shape_inference_fn to the requested shape inference function,
  // or returns an error.
  // Must be called after all of the above methods.
  //
  // Note that OpDefBuilder only reports parsing errors.  You should also
  // call ValidateOpDef() to detect other problems.
  public native @ByVal Status Finalize(OpRegistrationData op_reg_data);
}
