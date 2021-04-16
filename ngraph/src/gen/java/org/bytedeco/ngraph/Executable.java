// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.ngraph;

import org.bytedeco.ngraph.Allocator;
import org.bytedeco.ngraph.Function;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.ngraph.global.ngraph.*;


@Name("ngraph::runtime::Executable") @NoOffset @Properties(inherit = org.bytedeco.ngraph.presets.ngraph.class)
public class Executable extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Executable(Pointer p) { super(p); }


    /** @param outputs vector of runtime::Tensor used as outputs
     *  @param inputs vector of runtime::Tensor used as inputs
     *  @return true if iteration is successful, false otherwise */
    public native @Cast("bool") boolean call(@Const @ByRef TensorVector outputs,
                          @Const @ByRef TensorVector inputs);

    /** \brief Executes a single iteration of a Function.
     *  @param outputs vector of runtime::Tensor used as outputs
     *  @param inputs vector of runtime::Tensor used as inputs
     *  @return true if iteration is successful, false otherwise */
    public native @Cast("bool") boolean call_with_validate(@Const @ByRef TensorVector outputs,
                                @Const @ByRef TensorVector inputs);

    /** \brief Collect performance information gathered on a Function.
     *  @return Vector of PerformanceCounter information. */
    public native @StdVector PerformanceCounter get_performance_data();

    /** \brief Validates a Function.
     *  @param outputs vector of runtime::Tensor used as outputs
     *  @param inputs vector of runtime::Tensor used as inputs */
    public native void validate(@Const @ByRef TensorVector outputs,
                      @Const @ByRef TensorVector inputs);

    /** \brief Query the input Parameters
     *  @return an ngraph::op::ParameterVector of all input parameters */
    public native @Const @ByRef ParameterVector get_parameters();

    /** \brief Query the output Results
     *  @return an ngraph::ResultVector of all input parameters */
    public native @Const @ByRef ResultVector get_results();

    /** \brief Save this compiled Executable to an output stream.
     *     Saved stream may be read with Backend::load */
    public native void save(@Cast("std::ostream*") @ByRef Pointer output_stream);

    /** \brief Create an input Tensor
     *  @param input_index The index position in the input Parameter vector. This would be the same
     *  order of Parameters passed into the inputs in the call() method.
     *  @return A Tensor */
    public native @SharedPtr @ByVal Tensor create_input_tensor(@Cast("size_t") long input_index);

    /** \brief Create an output Tensor
     *  @param output_index The index position in the output Result vector. This would be the same
     *  order of Results passed into the outputs in the call() method.
     *  @return A Tensor */
    public native @SharedPtr @ByVal Tensor create_output_tensor(@Cast("size_t") long output_index);

    /** \brief Create a vector of input Tensors
     *  @param input_index The index position in the input Parameter vector. This would be the same
     *  order of Parameters passed into the inputs in the call() method.
     *  @param pipeline_depth The number of stages in the input pipeline. For double-buffered input
     *  you would specify pipeline_depth=2
     *  @return A vector of Tensors, one for each stage of the pipeline */
    public native @ByVal TensorVector create_input_tensor(@Cast("size_t") long input_index, @Cast("size_t") long pipeline_depth);

    /** \brief Create a vector of output Tensors
     *  @param output_index The index position in the output Result vector. This would be the same
     *                      order of Results passed into the outputs in the call() method.
     *  @param pipeline_depth The number of stages in the output pipeline. For double-buffered
     *                        output you would specify pipeline_depth=2
     *  @return A vector of Tensors, one for each stage of the pipeline */
    public native @ByVal TensorVector create_output_tensor(@Cast("size_t") long output_index, @Cast("size_t") long pipeline_depth);
}
