// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.dnnl;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.opencl.*;
import static org.bytedeco.opencl.global.OpenCL.*;

import static org.bytedeco.dnnl.global.dnnl.*;


/** LSTM forward propagation primitive. */
@Namespace("dnnl") @Properties(inherit = org.bytedeco.dnnl.presets.dnnl.class)
public class lstm_forward extends primitive {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public lstm_forward(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public lstm_forward(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public lstm_forward position(long position) {
        return (lstm_forward)super.position(position);
    }
    @Override public lstm_forward getPointer(long i) {
        return new lstm_forward(this).position(position + i);
    }

    /** Descriptor for an LSTM forward propagation primitive. */
    @NoOffset public static class desc extends Pointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public desc(Pointer p) { super(p); }
    
        
        ///
        ///
        ///
        ///
        ///
        public native @ByRef dnnl_rnn_desc_t data(); public native desc data(dnnl_rnn_desc_t setter);

        /** Constructs a descriptor for an LSTM (with or without peephole and
         *  with or without projection) forward propagation primitive.
         * 
         *  The following arguments may point to a zero memory descriptor:
         *  - \p src_iter_desc together with \p src_iter_c_desc,
         *  - \p weights_peephole_desc,
         *  - \p bias_desc,
         *  - \p dst_iter_desc together with \p dst_iter_c_desc.
         * 
         *  This would then indicate that the LSTM forward propagation
         *  primitive should not use them and should default to zero values
         *  instead.
         * 
         *  The \p weights_projection_desc may point to a zero memory
         *  descriptor. This would then indicate that the LSTM doesn't have
         *  recurrent projection layer.
         * 
         *  \note
         *      All memory descriptors can be initialized with an
         *      #dnnl::memory::format_tag::any value of \p format_tag.
         * 
         *  @param aprop_kind Propagation kind. Possible values are
         *      #dnnl::prop_kind::forward_training, and
         *      #dnnl::prop_kind::forward_inference.
         *  @param direction RNN direction. See \ref dnnl::rnn_direction for
         *      more info.
         *  @param src_layer_desc Memory descriptor for the input vector.
         *  @param src_iter_desc Memory descriptor for the input recurrent
         *      hidden state vector.
         *  @param src_iter_c_desc Memory descriptor for the input recurrent
         *      cell state vector.
         *  @param weights_layer_desc Memory descriptor for the weights
         *      applied to the layer input.
         *  @param weights_iter_desc Memory descriptor for the weights applied
         *      to the recurrent input.
         *  @param weights_peephole_desc Memory descriptor for the weights
         *      applied to the cell states (according to the Peephole LSTM
         *      formula).
         *  @param weights_projection_desc Memory descriptor for the weights
         *      applied to the hidden states to get the recurrent projection
         *      (according to the Projection LSTM formula).
         *  @param bias_desc Bias memory descriptor.
         *  @param dst_layer_desc Memory descriptor for the output vector.
         *  @param dst_iter_desc Memory descriptor for the output recurrent
         *      hidden state vector.
         *  @param dst_iter_c_desc Memory descriptor for the output recurrent
         *      cell state vector.
         *  @param flags Unused. */
        
        ///
        ///
        ///
        ///
        public desc(prop_kind aprop_kind, rnn_direction direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc weights_peephole_desc,
                        @Const @ByRef memory.desc weights_projection_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc,
                        rnn_flags flags/*=dnnl::rnn_flags::undef*/) { super((Pointer)null); allocate(aprop_kind, direction, src_layer_desc, src_iter_desc, src_iter_c_desc, weights_layer_desc, weights_iter_desc, weights_peephole_desc, weights_projection_desc, bias_desc, dst_layer_desc, dst_iter_desc, dst_iter_c_desc, flags); }
        private native void allocate(prop_kind aprop_kind, rnn_direction direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc weights_peephole_desc,
                        @Const @ByRef memory.desc weights_projection_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc,
                        rnn_flags flags/*=dnnl::rnn_flags::undef*/);
        public desc(prop_kind aprop_kind, rnn_direction direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc weights_peephole_desc,
                        @Const @ByRef memory.desc weights_projection_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc) { super((Pointer)null); allocate(aprop_kind, direction, src_layer_desc, src_iter_desc, src_iter_c_desc, weights_layer_desc, weights_iter_desc, weights_peephole_desc, weights_projection_desc, bias_desc, dst_layer_desc, dst_iter_desc, dst_iter_c_desc); }
        private native void allocate(prop_kind aprop_kind, rnn_direction direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc weights_peephole_desc,
                        @Const @ByRef memory.desc weights_projection_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc);
        public desc(@Cast("dnnl::prop_kind") int aprop_kind, @Cast("dnnl::rnn_direction") int direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc weights_peephole_desc,
                        @Const @ByRef memory.desc weights_projection_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc,
                        @Cast("dnnl::rnn_flags") int flags/*=dnnl::rnn_flags::undef*/) { super((Pointer)null); allocate(aprop_kind, direction, src_layer_desc, src_iter_desc, src_iter_c_desc, weights_layer_desc, weights_iter_desc, weights_peephole_desc, weights_projection_desc, bias_desc, dst_layer_desc, dst_iter_desc, dst_iter_c_desc, flags); }
        private native void allocate(@Cast("dnnl::prop_kind") int aprop_kind, @Cast("dnnl::rnn_direction") int direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc weights_peephole_desc,
                        @Const @ByRef memory.desc weights_projection_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc,
                        @Cast("dnnl::rnn_flags") int flags/*=dnnl::rnn_flags::undef*/);
        public desc(@Cast("dnnl::prop_kind") int aprop_kind, @Cast("dnnl::rnn_direction") int direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc weights_peephole_desc,
                        @Const @ByRef memory.desc weights_projection_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc) { super((Pointer)null); allocate(aprop_kind, direction, src_layer_desc, src_iter_desc, src_iter_c_desc, weights_layer_desc, weights_iter_desc, weights_peephole_desc, weights_projection_desc, bias_desc, dst_layer_desc, dst_iter_desc, dst_iter_c_desc); }
        private native void allocate(@Cast("dnnl::prop_kind") int aprop_kind, @Cast("dnnl::rnn_direction") int direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc weights_peephole_desc,
                        @Const @ByRef memory.desc weights_projection_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc);

        /** Constructs a descriptor for an LSTM (with or without peephole)
         *  forward propagation primitive.
         * 
         *  The following arguments may point to a zero memory descriptor:
         *  - \p src_iter_desc together with \p src_iter_c_desc,
         *  - \p weights_peephole_desc,
         *  - \p bias_desc,
         *  - \p dst_iter_desc together with \p dst_iter_c_desc.
         * 
         *  This would then indicate that the LSTM forward propagation
         *  primitive should not use them and should default to zero values
         *  instead.
         * 
         *  \note
         *      All memory descriptors can be initialized with an
         *      #dnnl::memory::format_tag::any value of \p format_tag.
         * 
         *  @param aprop_kind Propagation kind. Possible values are
         *      #dnnl::prop_kind::forward_training, and
         *      #dnnl::prop_kind::forward_inference.
         *  @param direction RNN direction. See \ref dnnl::rnn_direction for
         *      more info.
         *  @param src_layer_desc Memory descriptor for the input vector.
         *  @param src_iter_desc Memory descriptor for the input recurrent
         *      hidden state vector.
         *  @param src_iter_c_desc Memory descriptor for the input recurrent
         *      cell state vector.
         *  @param weights_layer_desc Memory descriptor for the weights
         *      applied to the layer input.
         *  @param weights_iter_desc Memory descriptor for the weights applied
         *      to the recurrent input.
         *  @param weights_peephole_desc Memory descriptor for the weights
         *      applied to the cell states (according to the Peephole LSTM
         *      formula).
         *  @param bias_desc Bias memory descriptor.
         *  @param dst_layer_desc Memory descriptor for the output vector.
         *  @param dst_iter_desc Memory descriptor for the output recurrent
         *      hidden state vector.
         *  @param dst_iter_c_desc Memory descriptor for the output recurrent
         *      cell state vector.
         *  @param flags Unused. */
        
        ///
        ///
        ///
        ///
        public desc(prop_kind aprop_kind, rnn_direction direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc weights_peephole_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc,
                        rnn_flags flags/*=dnnl::rnn_flags::undef*/) { super((Pointer)null); allocate(aprop_kind, direction, src_layer_desc, src_iter_desc, src_iter_c_desc, weights_layer_desc, weights_iter_desc, weights_peephole_desc, bias_desc, dst_layer_desc, dst_iter_desc, dst_iter_c_desc, flags); }
        private native void allocate(prop_kind aprop_kind, rnn_direction direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc weights_peephole_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc,
                        rnn_flags flags/*=dnnl::rnn_flags::undef*/);
        public desc(prop_kind aprop_kind, rnn_direction direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc weights_peephole_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc) { super((Pointer)null); allocate(aprop_kind, direction, src_layer_desc, src_iter_desc, src_iter_c_desc, weights_layer_desc, weights_iter_desc, weights_peephole_desc, bias_desc, dst_layer_desc, dst_iter_desc, dst_iter_c_desc); }
        private native void allocate(prop_kind aprop_kind, rnn_direction direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc weights_peephole_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc);
        public desc(@Cast("dnnl::prop_kind") int aprop_kind, @Cast("dnnl::rnn_direction") int direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc weights_peephole_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc,
                        @Cast("dnnl::rnn_flags") int flags/*=dnnl::rnn_flags::undef*/) { super((Pointer)null); allocate(aprop_kind, direction, src_layer_desc, src_iter_desc, src_iter_c_desc, weights_layer_desc, weights_iter_desc, weights_peephole_desc, bias_desc, dst_layer_desc, dst_iter_desc, dst_iter_c_desc, flags); }
        private native void allocate(@Cast("dnnl::prop_kind") int aprop_kind, @Cast("dnnl::rnn_direction") int direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc weights_peephole_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc,
                        @Cast("dnnl::rnn_flags") int flags/*=dnnl::rnn_flags::undef*/);
        public desc(@Cast("dnnl::prop_kind") int aprop_kind, @Cast("dnnl::rnn_direction") int direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc weights_peephole_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc) { super((Pointer)null); allocate(aprop_kind, direction, src_layer_desc, src_iter_desc, src_iter_c_desc, weights_layer_desc, weights_iter_desc, weights_peephole_desc, bias_desc, dst_layer_desc, dst_iter_desc, dst_iter_c_desc); }
        private native void allocate(@Cast("dnnl::prop_kind") int aprop_kind, @Cast("dnnl::rnn_direction") int direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc weights_peephole_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc);

        /** Constructs a descriptor for an LSTM forward propagation primitive.
         * 
         *  The following arguments may point to a zero memory descriptor:
         *  - \p src_iter_desc together with \p src_iter_c_desc,
         *  - \p bias_desc,
         *  - \p dst_iter_desc together with \p dst_iter_c_desc.
         * 
         *  This would then indicate that the LSTM forward propagation
         *  primitive should not use them and should default to zero values
         *  instead.
         * 
         *  \note
         *      All memory descriptors can be initialized with an
         *      #dnnl::memory::format_tag::any value of \p format_tag.
         * 
         *  @param aprop_kind Propagation kind. Possible values are
         *      #dnnl::prop_kind::forward_training, and
         *      #dnnl::prop_kind::forward_inference.
         *  @param direction RNN direction. See \ref dnnl::rnn_direction for
         *      more info.
         *  @param src_layer_desc Memory descriptor for the input vector.
         *  @param src_iter_desc Memory descriptor for the input recurrent
         *      hidden state vector.
         *  @param src_iter_c_desc Memory descriptor for the input recurrent
         *      cell state vector.
         *  @param weights_layer_desc Memory descriptor for the weights
         *      applied to the layer input.
         *  @param weights_iter_desc Memory descriptor for the weights applied
         *      to the recurrent input.
         *  @param bias_desc Bias memory descriptor.
         *  @param dst_layer_desc Memory descriptor for the output vector.
         *  @param dst_iter_desc Memory descriptor for the output recurrent
         *      hidden state vector.
         *  @param dst_iter_c_desc Memory descriptor for the output recurrent
         *      cell state vector.
         *  @param flags Unused. */
        public desc(prop_kind aprop_kind, rnn_direction direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc,
                        rnn_flags flags/*=dnnl::rnn_flags::undef*/) { super((Pointer)null); allocate(aprop_kind, direction, src_layer_desc, src_iter_desc, src_iter_c_desc, weights_layer_desc, weights_iter_desc, bias_desc, dst_layer_desc, dst_iter_desc, dst_iter_c_desc, flags); }
        private native void allocate(prop_kind aprop_kind, rnn_direction direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc,
                        rnn_flags flags/*=dnnl::rnn_flags::undef*/);
        public desc(prop_kind aprop_kind, rnn_direction direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc) { super((Pointer)null); allocate(aprop_kind, direction, src_layer_desc, src_iter_desc, src_iter_c_desc, weights_layer_desc, weights_iter_desc, bias_desc, dst_layer_desc, dst_iter_desc, dst_iter_c_desc); }
        private native void allocate(prop_kind aprop_kind, rnn_direction direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc);
        public desc(@Cast("dnnl::prop_kind") int aprop_kind, @Cast("dnnl::rnn_direction") int direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc,
                        @Cast("dnnl::rnn_flags") int flags/*=dnnl::rnn_flags::undef*/) { super((Pointer)null); allocate(aprop_kind, direction, src_layer_desc, src_iter_desc, src_iter_c_desc, weights_layer_desc, weights_iter_desc, bias_desc, dst_layer_desc, dst_iter_desc, dst_iter_c_desc, flags); }
        private native void allocate(@Cast("dnnl::prop_kind") int aprop_kind, @Cast("dnnl::rnn_direction") int direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc,
                        @Cast("dnnl::rnn_flags") int flags/*=dnnl::rnn_flags::undef*/);
        public desc(@Cast("dnnl::prop_kind") int aprop_kind, @Cast("dnnl::rnn_direction") int direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc) { super((Pointer)null); allocate(aprop_kind, direction, src_layer_desc, src_iter_desc, src_iter_c_desc, weights_layer_desc, weights_iter_desc, bias_desc, dst_layer_desc, dst_iter_desc, dst_iter_c_desc); }
        private native void allocate(@Cast("dnnl::prop_kind") int aprop_kind, @Cast("dnnl::rnn_direction") int direction,
                        @Const @ByRef memory.desc src_layer_desc,
                        @Const @ByRef memory.desc src_iter_desc,
                        @Const @ByRef memory.desc src_iter_c_desc,
                        @Const @ByRef memory.desc weights_layer_desc,
                        @Const @ByRef memory.desc weights_iter_desc,
                        @Const @ByRef memory.desc bias_desc,
                        @Const @ByRef memory.desc dst_layer_desc,
                        @Const @ByRef memory.desc dst_iter_desc,
                        @Const @ByRef memory.desc dst_iter_c_desc);
    }

    /** Primitive descriptor for an LSTM forward propagation primitive. */
    public static class primitive_desc extends rnn_primitive_desc_base {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public primitive_desc(Pointer p) { super(p); }
        /** Native array allocator. Access with {@link Pointer#position(long)}. */
        public primitive_desc(long size) { super((Pointer)null); allocateArray(size); }
        private native void allocateArray(long size);
        @Override public primitive_desc position(long position) {
            return (primitive_desc)super.position(position);
        }
        @Override public primitive_desc getPointer(long i) {
            return new primitive_desc(this).position(position + i);
        }
    
        /** Default constructor. Produces an empty object. */
        
        ///
        public primitive_desc() { super((Pointer)null); allocate(); }
        private native void allocate();

        /** Constructs a primitive descriptor for an LSTM forward propagation
         *  primitive.
         * 
         *  @param adesc Descriptor for an LSTM forward propagation primitive.
         *  @param aengine Engine to use.
         *  @param allow_empty A flag signifying whether construction is
         *      allowed to fail without throwing an exception. In this case an
         *      empty object will be produced. This flag is optional and
         *      defaults to false. */
        
        ///
        public primitive_desc(@Const @ByRef desc adesc, @Const @ByRef engine aengine,
                        @Cast("bool") boolean allow_empty/*=false*/) { super((Pointer)null); allocate(adesc, aengine, allow_empty); }
        private native void allocate(@Const @ByRef desc adesc, @Const @ByRef engine aengine,
                        @Cast("bool") boolean allow_empty/*=false*/);
        public primitive_desc(@Const @ByRef desc adesc, @Const @ByRef engine aengine) { super((Pointer)null); allocate(adesc, aengine); }
        private native void allocate(@Const @ByRef desc adesc, @Const @ByRef engine aengine);

        /** Constructs a primitive descriptor for an LSTM forward propagation
         *  primitive.
         * 
         *  @param adesc Descriptor for an LSTM forward propagation primitive.
         *  @param attr Primitive attributes to use.
         *  @param aengine Engine to use.
         *  @param allow_empty A flag signifying whether construction is
         *      allowed to fail without throwing an exception. In this case an
         *      empty object will be produced. This flag is optional and
         *      defaults to false. */
        
        ///
        public primitive_desc(@Const @ByRef desc adesc, @Const @ByRef primitive_attr attr,
                        @Const @ByRef engine aengine, @Cast("bool") boolean allow_empty/*=false*/) { super((Pointer)null); allocate(adesc, attr, aengine, allow_empty); }
        private native void allocate(@Const @ByRef desc adesc, @Const @ByRef primitive_attr attr,
                        @Const @ByRef engine aengine, @Cast("bool") boolean allow_empty/*=false*/);
        public primitive_desc(@Const @ByRef desc adesc, @Const @ByRef primitive_attr attr,
                        @Const @ByRef engine aengine) { super((Pointer)null); allocate(adesc, attr, aengine); }
        private native void allocate(@Const @ByRef desc adesc, @Const @ByRef primitive_attr attr,
                        @Const @ByRef engine aengine);

        /** Constructs a primitive descriptor for an LSTM forward propagation
         *  primitive from a C API primitive descriptor that must have a
         *  matching kind.
         * 
         *  @param pd C API primitive descriptor for an LSTM forward
         *      propagation primitive. */
        public primitive_desc(dnnl_primitive_desc pd) { super((Pointer)null); allocate(pd); }
        private native void allocate(dnnl_primitive_desc pd);

        /** \copydoc dnnl::rnn_primitive_desc_base::src_layer_desc()const */
        public native @ByVal memory.desc src_layer_desc();

        /** \copydoc dnnl::rnn_primitive_desc_base::src_iter_desc()const */
        public native @ByVal memory.desc src_iter_desc();

        /** \copydoc dnnl::rnn_primitive_desc_base::src_iter_desc()const */
        public native @ByVal memory.desc src_iter_c_desc();

        /** \copydoc dnnl::rnn_primitive_desc_base::weights_layer_desc()const */
        public native @ByVal memory.desc weights_layer_desc();

        /** \copydoc dnnl::rnn_primitive_desc_base::weights_iter_desc()const */
        public native @ByVal memory.desc weights_iter_desc();

        /** \copydoc dnnl::rnn_primitive_desc_base::weights_peephole_desc()const */
        public native @ByVal memory.desc weights_peephole_desc();

        /** \copydoc dnnl::rnn_primitive_desc_base::weights_projection_desc()const */
        public native @ByVal memory.desc weights_projection_desc();

        /** \copydoc dnnl::rnn_primitive_desc_base::bias_desc()const */
        public native @ByVal memory.desc bias_desc();

        /** \copydoc dnnl::rnn_primitive_desc_base::dst_layer_desc()const */
        public native @ByVal memory.desc dst_layer_desc();

        /** \copydoc dnnl::rnn_primitive_desc_base::dst_iter_desc()const */
        public native @ByVal memory.desc dst_iter_desc();

        /** \copydoc dnnl::rnn_primitive_desc_base::src_iter_desc()const */
        public native @ByVal memory.desc dst_iter_c_desc();

        /** \copydoc dnnl::rnn_primitive_desc_base::workspace_desc()const */
        public native @ByVal memory.desc workspace_desc();
    }

    /** Default constructor. Produces an empty object. */
    public lstm_forward() { super((Pointer)null); allocate(); }
    private native void allocate();

    /** Constructs an LSTM forward propagation primitive.
     *  @param pd Primitive descriptor for an LSTM forward propagation
     *      primitive. */
    public lstm_forward(@Const @ByRef primitive_desc pd) { super((Pointer)null); allocate(pd); }
    private native void allocate(@Const @ByRef primitive_desc pd);
}
