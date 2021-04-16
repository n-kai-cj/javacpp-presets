// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


// GraphRunner takes a Graph, some inputs to feed, and some outputs
// to fetch and executes the graph required to feed and fetch the
// inputs and outputs.
//
// This class is only meant for internal use where one needs to
// partially evaluate inexpensive nodes in a graph, such as for shape
// inference or for constant folding.  Because of its limited, simple
// use-cases, it executes all computation on the given device (CPU by default)
// and is not meant to be particularly lightweight, fast, or efficient.
@Namespace("tensorflow") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class GraphRunner extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public GraphRunner(Pointer p) { super(p); }

  // REQUIRES: `env` is not nullptr.
  public GraphRunner(Env env) { super((Pointer)null); allocate(env); }
  private native void allocate(Env env);
  // REQUIRES: 'device' is not nullptr. Not owned.
  public GraphRunner(Device device) { super((Pointer)null); allocate(device); }
  private native void allocate(Device device);

  // Function semantics for `inputs`, `output_names` and `outputs`
  // matches those from Session::Run().
  //
  // NOTE: The output tensors share lifetime with the GraphRunner, and could
  // be destroyed once the GraphRunner is destroyed.
  //
  // REQUIRES: `graph`, `env`, and `outputs` are not nullptr.
  // `function_library` may be nullptr.
  public native @ByVal Status Run(Graph graph, FunctionLibraryRuntime function_library,
               @Cast("const tensorflow::GraphRunner::NamedTensorList*") @ByRef StringTensorPairVector inputs,
               @Const @ByRef StringVector output_names,
               TensorVector outputs);
}
