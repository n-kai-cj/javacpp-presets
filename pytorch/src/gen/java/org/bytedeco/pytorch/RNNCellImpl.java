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
 // namespace detail


// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ RNNCell ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

/** An Elman RNN cell with tanh or ReLU non-linearity.
 *  See https://pytorch.org/docs/master/nn.html#torch.nn.RNNCell to learn
 *  about the exact behavior of this module.
 * 
 *  See the documentation for {@code torch::nn::RNNCellOptions} class to learn what
 *  constructor arguments are supported for this module.
 * 
 *  Example:
 *  <pre>{@code
 *  RNNCell model(RNNCellOptions(20, 10).bias(false).nonlinearity(torch::kReLU));
 *  }</pre> */
@Namespace("torch::nn") @NoOffset @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class RNNCellImpl extends RNNCellImplBase {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public RNNCellImpl(Pointer p) { super(p); }

  public RNNCellImpl(@Cast("int64_t") long input_size, @Cast("int64_t") long hidden_size) { super((Pointer)null); allocate(input_size, hidden_size); }
  @NoDeallocator private native void allocate(@Cast("int64_t") long input_size, @Cast("int64_t") long hidden_size);
  public RNNCellImpl(@Const @ByRef RNNCellOptions options_) { super((Pointer)null); allocate(options_); }
  @NoDeallocator private native void allocate(@Const @ByRef RNNCellOptions options_);

  public native @ByVal Tensor forward(@Const @ByRef Tensor input, @ByVal(nullValue = "at::Tensor{}") Tensor hx);
  public native @ByVal Tensor forward(@Const @ByRef Tensor input);
  public native @ByRef RNNCellOptions options(); public native RNNCellImpl options(RNNCellOptions setter);
}
