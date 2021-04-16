// Targeted by JavaCPP version 1.5.6-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.pytorch;

import org.bytedeco.pytorch.Allocator;
import org.bytedeco.pytorch.Function;
import org.bytedeco.pytorch.Module;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;

import static org.bytedeco.pytorch.global.torch.*;


// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ TransformerEncoderLayer ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

/** TransformerEncoderLayer module.
 *  See https://pytorch.org/docs/master/generated/torch.nn.TransformerEncoderLayer.html to
 *  learn abouut the exact behavior of this encoder layer model
 * 
 *  See the documentation for {@code torch::nn::TransformerEncoderLayer} class to learn what
 *  constructor arguments are supported for this encoder layer model
 * 
 *  Example:
 *  <pre>{@code
 *  TransformerEncoderLayer encoderLayer(TransformerEncoderLayerOptions(512, 8).dropout(0.1));
 *  }</pre> */
@Namespace("torch::nn") @NoOffset @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class TransformerEncoderLayerImpl extends TransformerEncoderLayerImplCloneable {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TransformerEncoderLayerImpl(Pointer p) { super(p); }

    public TransformerEncoderLayerImpl(@Cast("int64_t") long d_model, @Cast("int64_t") long nhead) { super((Pointer)null); allocate(d_model, nhead); }
    @NoDeallocator private native void allocate(@Cast("int64_t") long d_model, @Cast("int64_t") long nhead);
    public TransformerEncoderLayerImpl(@Const @ByRef TransformerEncoderLayerOptions options_) { super((Pointer)null); allocate(options_); }
    @NoDeallocator private native void allocate(@Const @ByRef TransformerEncoderLayerOptions options_);

    public native @ByVal Tensor forward(
          @Const @ByRef Tensor src,
          @Const @ByRef(nullValue = "at::Tensor{}") Tensor src_mask,
          @Const @ByRef(nullValue = "at::Tensor{}") Tensor src_key_padding_mask);
    public native @ByVal Tensor forward(
          @Const @ByRef Tensor src);

    public native void reset();

    public native void reset_parameters();
    /** options with which this {@code TransformerEncoderLayer} was constructed */
    public native @ByRef TransformerEncoderLayerOptions options(); public native TransformerEncoderLayerImpl options(TransformerEncoderLayerOptions setter);

    /** self attention */
    public native @ByRef MultiheadAttention self_attn(); public native TransformerEncoderLayerImpl self_attn(MultiheadAttention setter);

    /** feedforward first linear layer */
    public native @ByRef Linear linear1(); public native TransformerEncoderLayerImpl linear1(Linear setter);

    /** feedforward dropout layer */
    public native @ByRef Dropout dropout(); public native TransformerEncoderLayerImpl dropout(Dropout setter);

    /** feedforward second linear layer */
    public native @ByRef Linear linear2(); public native TransformerEncoderLayerImpl linear2(Linear setter);

    /** pre feedforward, normalization layer */
    public native @ByRef LayerNorm norm1(); public native TransformerEncoderLayerImpl norm1(LayerNorm setter);
    /** post feedfastward, normalization layer */
    public native @ByRef LayerNorm norm2(); public native TransformerEncoderLayerImpl norm2(LayerNorm setter);

    /** pre feedfastward, dropout layer */
    public native @ByRef Dropout dropout1(); public native TransformerEncoderLayerImpl dropout1(Dropout setter);
    /** post feedfastward, dropout layer */
    public native @ByRef Dropout dropout2(); public native TransformerEncoderLayerImpl dropout2(Dropout setter);
}
