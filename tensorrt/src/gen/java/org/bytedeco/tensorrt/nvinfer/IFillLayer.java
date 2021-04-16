// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

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
 *  \brief Generate an output tensor with specified mode.
 * 
 *  The fill layer has two variants, static and dynamic. Static fill specifies its parameters
 *  at layer creation time via Dims and the get/set accessor functions of the IFillLayer.
 *  Dynamic fill specifies one or more of its parameters as ITensors, by using ILayer::setTensor to add
 *  a corresponding input.  The corresponding static parameter is used if an input is missing or null.
 * 
 *  The shape of the output is specified by the parameter \p Dimension, or if non-null and present,
 *  the first input, which must be a 1D Int32 shape tensor.  Thus an application can determine if the
 *  IFillLayer has a dynamic output shape based on whether it has a non-null first input.
 * 
 *  Alpha and Beta are treated differently based on the Fill Operation specified. See details in
 *  IFillLayer::setAlpha(), IFillLayer::setBeta(), and IFillLayer::setInput().
 * 
 *  @see FillOperation
 * 
 *  \warning Do not inherit from this class, as doing so will break forward-compatibility of the API and ABI. */
@Namespace("nvinfer1") @Properties(inherit = org.bytedeco.tensorrt.presets.nvinfer.class)
public class IFillLayer extends ILayer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IFillLayer(Pointer p) { super(p); }

    /**
     *  \brief Set the output tensor's dimensions.
     * 
     *  @param dimensions The output tensor's dimensions.
     * 
     *  If the first input is set, it is reset to null.
     * 
     *  @see getDimensions */
    //
    
    
    //!
    //!
    //!
    //!
    //!
    public native @NoException void setDimensions(@ByVal Dims dimensions);

    /**
     *  \brief Get the output tensor's dimensions.
     * 
     *  @return The output tensor's dimensions, or an invalid Dims structure.
     * 
     *  If the first input is present and non-null,
     *  this function returns a Dims with nbDims = -1.
     * 
     *  @see setDimensions
     *  */
    
    
    //!
    //!
    //!
    public native @ByVal @NoException Dims getDimensions();

    /**
     *  \brief Set the fill operation for the layer.
     * 
     *  @see getOperation(), FillOperation
     *  */
    
    
    //!
    //!
    //!
    public native @NoException void setOperation(FillOperation op);
    public native @NoException void setOperation(@Cast("nvinfer1::FillOperation") int op);

    /**
     *  \brief Get the fill operation for the layer.
     * 
     *  @see setOperation(), FillOperation
     *  */
    
    
    //!
    //!
    //!
    //!
    //!
    public native @NoException FillOperation getOperation();

    /**
     *  \brief Set the alpha parameter.
     * 
     *  @param alpha has different meanings for each operator:
     * 
     *  Operation          | Usage
     *  kLINSPACE          | the start value;
     *  kRANDOMUNIFORM     | the minimum value;
     * 
     *  If the second input is set, it is reset to null.
     * 
     *  @see getAlpha */
    //
    
    
    //!
    //!
    //!
    //!
    //!
    public native @NoException void setAlpha(double alpha);

    /**
     *  \brief Get the value of alpha parameter.
     * 
     *  @return A double value of alpha.
     * 
     *  If the second input is present and non-null,
     *  this function returns a Dims with nbDims = -1.
     * 
     *  @see setAlpha
     *  */
    
    
    //!
    //!
    //!
    //!
    //!
    //!
    public native @NoException double getAlpha();

    /**
     *  \brief Set the beta parameter.
     * 
     *  @param beta has different meanings for each operator:
     * 
     *  Operation          | Usage
     *  kLINSPACE          | the delta value;
     *  kRANDOMUNIFORM     | the maximal value;
     * 
     *  If the third input is set, it is reset to null.
     * 
     *  @see getBeta
     *  */
    
    
    //!
    //!
    //!
    //!
    //!
    public native @NoException void setBeta(double beta);

    /**
     *  \brief Get the value of beta parameter.
     * 
     *  @return A double value of beta.
     * 
     *  If the third input is present and non-null,
     *  this function returns a Dims with nbDims = -1.
     * 
     *  @see setBeta
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
    public native @NoException double getBeta();

    /**
     *  \brief replace an input of this layer with a specific tensor.
     * 
     *  @param index the index of the input to set.
     *  @param tensor the new input tensor
     * 
     *  Indices for kLINSPACE are described as:
     * 
     *  - 0: Shape tensor, represents the output tensor's dimensions.
     *  - 1: Start, a scalar, represents the start value.
     *  - 2: Delta, a 1D tensor, length equals to shape tensor's nbDims, represents the delta value for each dimension.
     * 
     *  Indices for kRANDOM_UNIFORM are described as:
     * 
     *  - 0: Shape tensor, represents the output tensor's dimensions.
     *  - 1: Minimum, a scalar, represents the minimum random value.
     *  - 2: Maximum, a scalar, represents the maximal random value.
     * 
     *  Using the corresponding setter resets the input to null.
     * 
     *  If either inputs 1 or 2, is non-null, then both must be non-null and have the same data type.
     * 
     *  If this function is called for an index greater or equal to getNbInputs(),
     *  then afterwards getNbInputs() returns index + 1, and any missing intervening
     *  inputs are set to null.
     *  */
    public native void setInput(int index, @ByRef ITensor tensor);
}
