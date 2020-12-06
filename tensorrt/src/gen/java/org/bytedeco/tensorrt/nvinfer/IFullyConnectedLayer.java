// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

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


/** \class IFullyConnectedLayer
 * 
 *  \brief A fully connected layer in a network definition.
 *  This layer expects an input tensor of three or more non-batch dimensions.  The input is automatically
 *  reshaped into an {@code MxV} tensor {@code X}, where {@code V} is a product of the last three dimensions and {@code M}
 *  is a product of the remaining dimensions (where the product over 0 dimensions is defined as 1).  For example:
 * 
 *  - If the input tensor has shape {@code {C, H, W}}, then the tensor is reshaped into {@code {1, C*H*W}}.
 *  - If the input tensor has shape {@code {P, C, H, W}}, then the tensor is reshaped into {@code {P, C*H*W}}.
 * 
 *  The layer then performs the following operation:
 * 
 *  ~~~
 *  Y := matmul(X, W^T) + bias
 *  ~~~
 * 
 *  Where {@code X} is the {@code MxV} tensor defined above, {@code W} is the {@code KxV} weight tensor
 *  of the layer, and {@code bias} is a row vector size {@code K} that is broadcasted to
 *  {@code MxK}.  {@code K} is the number of output channels, and configurable via
 *  setNbOutputChannels().  If {@code bias} is not specified, it is implicitly {@code 0}.
 * 
 *  The {@code MxK} result {@code Y} is then reshaped such that the last three dimensions are {@code {K, 1, 1}} and
 *  the remaining dimensions match the dimensions of the input tensor. For example:
 * 
 *  - If the input tensor has shape {@code {C, H, W}}, then the output tensor will have shape {@code {K, 1, 1}}.
 *  - If the input tensor has shape {@code {P, C, H, W}}, then the output tensor will have shape {@code {P, K, 1, 1}}.
 * 
 *  \warning Do not inherit from this class, as doing so will break forward-compatibility of the API and ABI.
 *  */
@Namespace("nvinfer1") @Properties(inherit = org.bytedeco.tensorrt.presets.nvinfer.class)
public class IFullyConnectedLayer extends ILayer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IFullyConnectedLayer(Pointer p) { super(p); }

    /**
     *  \brief Set the number of output channels {@code K} from the fully connected layer.
     * 
     *  If executing this layer on DLA, number of output channels must in the range [1,8192].
     * 
     *  @see getNbOutputChannels()
     *  */
    
    
    //!
    //!
    //!
    public native void setNbOutputChannels(int nbOutputs);

    /**
     *  \brief Get the number of output channels {@code K} from the fully connected layer.
     * 
     *  @see setNbOutputChannels()
     *  */
    
    
    //!
    //!
    //!
    public native int getNbOutputChannels();

    /**
     *  \brief Set the kernel weights, given as a {@code KxC} matrix in row-major order.
     * 
     *  @see getKernelWeights()
     *  */
    
    
    //!
    //!
    //!
    public native void setKernelWeights(@ByVal Weights weights);

    /**
     *  \brief Get the kernel weights.
     * 
     *  @see setKernelWeights()
     *  */
    
    
    //!
    //!
    //!
    //!
    public native @ByVal Weights getKernelWeights();

    /**
     *  \brief Set the bias weights.
     * 
     *  Bias is optional. To omit bias, set the count value in the weights structure to zero.
     * 
     *  @see getBiasWeightsWeights()
     *  */
    
    
    //!
    //!
    //!
    public native void setBiasWeights(@ByVal Weights weights);

    /**
     *  \brief Get the bias weights.
     * 
     *  @see setBiasWeightsWeights()
     *  */
    public native @ByVal Weights getBiasWeights();
    /**
     *  \brief Append or replace an input of this layer with a specific tensor
     * 
     *  @param index the index of the input to modify.
     *  @param tensor the new input tensor
     * 
     *  For a IFullyConnectedLayer, only index 0 is valid unless explicit precision mode is enabled.
     *  With explicit precision mode, values 0-1 are valid where value 1 overrides kernel weights.
     *  Kernel weights tensor (computed at build-time) must be an output of dequantize scale layer (i.e. a scale layer
     *  with int8 input and float output) in explicit precision network. Conversely, this input tensor can be overridden
     *  via appropriate set call. The indices are as follows:
     * 
     *  - 0: The input activation tensor.
     *  - 1: The kernel weights tensor (a constant tensor).
     * 
     *  If this function is called with a value greater than 0, then the function getNbInputs() changes */
    public native void setInput(int index, @ByRef ITensor tensor);
}
