// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.tensorrt.nvinfer;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.cuda.cudart.*;
import static org.bytedeco.cuda.global.cudart.*;
import org.bytedeco.cuda.cublas.*;
import static org.bytedeco.cuda.global.cublas.*;
import org.bytedeco.cuda.cudnn.*;
import static org.bytedeco.cuda.global.cudnn.*;
import org.bytedeco.cuda.nvrtc.*;
import static org.bytedeco.cuda.global.nvrtc.*;

import static org.bytedeco.tensorrt.global.nvinfer.*;


/**
 *  \class IPluginV2DynamicExt
 * 
 *  Similar to IPluginV2Ext, but with support for dynamic shapes.
 * 
 *  Clients should override the public methods, including the following inherited methods:
 * 
 *      virtual int getNbOutputs() const TRTNOEXCEPT = 0;
 *      virtual nvinfer1::DataType getOutputDataType(int index, const nvinfer1::DataType* inputTypes, int nbInputs) const TRTNOEXCEPT = 0;
 *      virtual size_t getSerializationSize() const TRTNOEXCEPT = 0;
 *      virtual void serialize(void* buffer) const TRTNOEXCEPT = 0;
 *      virtual void destroy() TRTNOEXCEPT = 0;
 *      virtual void setPluginNamespace(const char* pluginNamespace) TRTNOEXCEPT = 0;
 *      virtual const char* getPluginNamespace() const TRTNOEXCEPT = 0;
 * 
 *  For getOutputDataType, the inputTypes will always be DataType::kFLOAT or DataType::kINT32,
 *  and the returned type is canonicalized to DataType::kFLOAT if it is DataType::kHALF or DataType:kINT8.
 *  Details about the floating-point precision are elicited later by method supportsFormatCombination.
 *  */
@Namespace("nvinfer1") @NoOffset @Properties(inherit = org.bytedeco.tensorrt.presets.nvinfer.class)
public class IPluginV2DynamicExt extends IPluginV2Ext {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IPluginV2DynamicExt(Pointer p) { super(p); }

    
    
    //!
    //!
    //!
    //!
    //!
    //!
    //!
    //!
    public native IPluginV2DynamicExt clone();

    /**
     *  \brief Get expressions for computing dimensions of an output tensor from dimensions of the input tensors.
     * 
     *  @param outputIndex The index of the output tensor
     *  @param inputs Expressions for dimensions of the input tensors
     *  @param nbInputDims The number of input tensors
     *  @param exprBuilder Object for generating new expressions
     * 
     *  This function is called by the implementations of IBuilder during analysis of the network.
     * 
     *  Example #1: A plugin has a single output that transposes the last two dimensions of the plugin's single input.
     *  The body of the override of getOutputDimensions can be:
     * 
     *      DimsExprs output(inputs[0]);
     *      std::swap(output.d[output.nbDims-1], output.d[output.nbDims-2]);
     *      return output;
     * 
     *  Example #2: A plugin concatenates its two inputs along the first dimension.
     *  The body of the override of getOutputDimensions can be:
     * 
     *      DimsExprs output(inputs[0]);
     *      output.d[0] = exprBuilder.operation(DimensionOperation::kSUM, inputs[0].d[0], inputs[1].d[0]);
     *      return output;
     *  */
    
    
    //!
    //!
    public native @ByVal DimsExprs getOutputDimensions(int outputIndex, @Const DimsExprs inputs, int nbInputs, @ByRef IExprBuilder exprBuilder);

    /**
     *  Limit on number of format combinations accepted.
     *  */
    
    
    //!
    //!
    //!
    //!
    //!
    //!
    //!
    //!
    //!
    //!
    //!
    //!
    @MemberGetter public static native int kFORMAT_COMBINATION_LIMIT();
    public static final int kFORMAT_COMBINATION_LIMIT = kFORMAT_COMBINATION_LIMIT();

    /**
     *  \brief Return true if plugin supports the format and datatype for the input/output indexed by pos.
     * 
     *  For this method inputs are numbered 0..(nbInputs-1) and outputs are numbered nbInputs..(nbInputs+nbOutputs-1).
     *  Using this numbering, pos is an index into InOut, where 0 <= pos < nbInputs+nbOutputs-1.
     * 
     *  TensorRT invokes this method to ask if the input/output indexed by pos supports the format/datatype specified
     *  by inOut[pos].format and inOut[pos].type.  The override should return true if that format/datatype at inOut[pos]
     *  are supported by the plugin.  If support is conditional on other input/output formats/datatypes, the plugin can
     *  make its result conditional on the formats/datatypes in inOut[0..pos-1], which will be set to values
     *  that the plugin supports.  The override should not inspect inOut[pos+1..nbInputs+nbOutputs-1],
     *  which will have invalid values.  In other words, the decision for pos must be based on inOut[0..pos] only.
     * 
     *  Some examples:
     * 
     *  * A definition for a plugin that supports only FP16 NCHW:
     * 
     *          return inOut.format[pos] == TensorFormat::kLINEAR && inOut.type[pos] == DataType::kHALF;
     * 
     *  * A definition for a plugin that supports only FP16 NCHW for its two inputs,
     *    and FP32 NCHW for its single output:
     * 
     *          return inOut.format[pos] == TensorFormat::kLINEAR && (inOut.type[pos] == pos < 2 ?  DataType::kHALF : DataType::kFLOAT);
     * 
     *  * A definition for a "polymorphic" plugin with two inputs and one output that supports
     *    any format or type, but the inputs and output must have the same format and type:
     * 
     *          return pos == 0 || (inOut.format[pos] == inOut.format[0] && inOut.type[pos] == inOut.type[0]);
     * 
     *  Warning: TensorRT will stop asking for formats once it finds kFORMAT_COMBINATION_LIMIT on combinations.
     *  */
    
    
    //!
    //!
    //!
    //!
    //!
    public native @Cast("bool") boolean supportsFormatCombination(int pos, @Const PluginTensorDesc inOut, int nbInputs, int nbOutputs);

    /**
     *  \brief Configure the layer.
     * 
     *  This function is called by the builder prior to initialize().  It provides an opportunity for the layer to make
     *  algorithm choices on the basis of bounds on the input and output tensors, and the target value.
     * 
     *  This function is also called once when the resource requirements are changed based on the optimization profiles.
     * 
     *  @param in The input tensors attributes that are used for configuration.
     *  @param nbInputs Number of input tensors.
     *  @param out The output tensors attributes that are used for configuration.
     *  @param nbOutputs Number of output tensors.
     *  */
    
    
    //!
    //!
    //!
    //!
    public native void configurePlugin(@Const DynamicPluginTensorDesc in, int nbInputs, @Const DynamicPluginTensorDesc out, int nbOutputs);

    /**
     *  \brief Find the workspace size required by the layer.
     * 
     *  This function is called after the plugin is configured, and possibly during execution.
     *  The result should be a sufficient workspace size to deal with inputs and outputs of the given size
     *  or any smaller problem.
     * 
     *  @return The workspace size.
     *  */
    
    
    //!
    //!
    //!
    //!
    public native @Cast("size_t") long getWorkspaceSize(@Const PluginTensorDesc inputs, int nbInputs, @Const PluginTensorDesc outputs, int nbOutputs);

    /**
     *  \brief Execute the layer.
     * 
     *  @param inputDesc how to interpret the memory for the input tensors.
     *  @param outputDesc how to interpret the memory for the output tensors.
     *  @param inputs The memory for the input tensors.
     *  @param outputs The memory for the output tensors.
     *  @param workspace Workspace for execution.
     *  @param stream The stream in which to execute the kernels.
     * 
     *  @return 0 for success, else non-zero (which will cause engine termination).
     *  */
    public native int enqueue(@Const PluginTensorDesc inputDesc, @Const PluginTensorDesc outputDesc, @Cast("const void*const*") PointerPointer inputs, @Cast("void*const*") PointerPointer outputs, Pointer workspace, CUstream_st stream);
    public native int enqueue(@Const PluginTensorDesc inputDesc, @Const PluginTensorDesc outputDesc, @Cast("const void*const*") @ByPtrPtr Pointer inputs, @Cast("void*const*") @ByPtrPtr Pointer outputs, Pointer workspace, CUstream_st stream);
}
