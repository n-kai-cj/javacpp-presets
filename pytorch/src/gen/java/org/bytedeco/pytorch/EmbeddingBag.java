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


/** A {@code ModuleHolder} subclass for {@code EmbeddingBagImpl}.
 *  See the documentation for {@code EmbeddingBagImpl} class to learn what methods it
 *  provides, and examples of how to use {@code EmbeddingBag} with {@code torch::nn::EmbeddingBagOptions}.
 *  See the documentation for {@code ModuleHolder} to learn about PyTorch's
 *  module storage semantics. */
@Namespace("torch::nn") @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class EmbeddingBag extends EmbeddingBagImplModuleHolder {
    static { Loader.load(); }

   public EmbeddingBag(@ByVal @Cast("std::nullptr_t*") PointerPointer arg0) { super((Pointer)null); allocate(arg0); }
  private native void allocate(@ByVal @Cast("std::nullptr_t*") PointerPointer arg0); public EmbeddingBag(@SharedPtr @Cast({"", "std::shared_ptr<torch::nn::EmbeddingBagImpl>"}) EmbeddingBagImpl module) { super((Pointer)null); allocate(module); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<torch::nn::EmbeddingBagImpl>"}) EmbeddingBagImpl module);
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public EmbeddingBag(Pointer p) { super(p); }


  /** See the documentation for {@code torch::nn::EmbeddingBagFromPretrainedOptions} class to learn what
   *  optional arguments are supported for this function. */
  public static native @ByVal EmbeddingBag from_pretrained(@Const @ByRef Tensor embeddings, @Const @ByRef(nullValue = "torch::nn::EmbeddingBagFromPretrainedOptions{}") EmbeddingBagFromPretrainedOptions options);
  public static native @ByVal EmbeddingBag from_pretrained(@Const @ByRef Tensor embeddings);
}
