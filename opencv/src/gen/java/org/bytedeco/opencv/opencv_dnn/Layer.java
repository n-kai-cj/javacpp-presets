// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_dnn;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import org.bytedeco.opencv.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;

import static org.bytedeco.opencv.global.opencv_dnn.*;


    /** \brief This interface class allows to build new Layers - are building blocks of networks.
     *
     * Each class, derived from Layer, must implement allocate() methods to declare own outputs and forward() to compute outputs.
     * Also before using the new layer into networks you must register your layer by using one of \ref dnnLayerFactory "LayerFactory" macros.
     */
    @Namespace("cv::dnn") @NoOffset @Properties(inherit = org.bytedeco.opencv.presets.opencv_dnn.class)
public class Layer extends Algorithm {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public Layer(Pointer p) { super(p); }
        /** Native array allocator. Access with {@link Pointer#position(long)}. */
        public Layer(long size) { super((Pointer)null); allocateArray(size); }
        private native void allocateArray(long size);
        @Override public Layer position(long position) {
            return (Layer)super.position(position);
        }
        @Override public Layer getPointer(long i) {
            return new Layer(this).position(position + i);
        }
    

        /** List of learned parameters must be stored here to allow read them by using Net::getParam(). */
        public native @ByRef MatVector blobs(); public native Layer blobs(MatVector setter);

        /** \brief Computes and sets internal parameters according to inputs, outputs and blobs.
         *  @deprecated Use Layer::finalize(InputArrayOfArrays, OutputArrayOfArrays) instead
         *  @param input [in]  vector of already allocated input blobs
         *  @param output [out] vector of already allocated output blobs
         *
         * If this method is called after network has allocated all memory for input and output blobs
         * and before inferencing.
         */
        public native @Deprecated void finalize(@Const @ByRef MatPointerVector input, @ByRef MatVector output);

        /** \brief Computes and sets internal parameters according to inputs, outputs and blobs.
         *  @param inputs [in]  vector of already allocated input blobs
         *  @param outputs [out] vector of already allocated output blobs
         *
         * If this method is called after network has allocated all memory for input and output blobs
         * and before inferencing.
         */
        public native void finalize(@ByVal MatVector inputs, @ByVal MatVector outputs);
        public native void finalize(@ByVal UMatVector inputs, @ByVal UMatVector outputs);
        public native void finalize(@ByVal GpuMatVector inputs, @ByVal GpuMatVector outputs);

        /** \brief Given the \p input blobs, computes the output \p blobs.
         *  @deprecated Use Layer::forward(InputArrayOfArrays, OutputArrayOfArrays, OutputArrayOfArrays) instead
         *  @param input [in]  the input blobs.
         *  @param output [out] allocated output blobs, which will store results of the computation.
         *  @param internals [out] allocated internal blobs
         */
        public native @Deprecated void forward(@ByRef MatPointerVector input, @ByRef MatVector output, @ByRef MatVector internals);

        /** \brief Given the \p input blobs, computes the output \p blobs.
         *  @param inputs [in]  the input blobs.
         *  @param outputs [out] allocated output blobs, which will store results of the computation.
         *  @param internals [out] allocated internal blobs
         */
        public native void forward(@ByVal MatVector inputs, @ByVal MatVector outputs, @ByVal MatVector internals);
        public native void forward(@ByVal UMatVector inputs, @ByVal UMatVector outputs, @ByVal UMatVector internals);
        public native void forward(@ByVal GpuMatVector inputs, @ByVal GpuMatVector outputs, @ByVal GpuMatVector internals);

        /** \brief Given the \p input blobs, computes the output \p blobs.
         *  @param inputs [in]  the input blobs.
         *  @param outputs [out] allocated output blobs, which will store results of the computation.
         *  @param internals [out] allocated internal blobs
         */
        public native void forward_fallback(@ByVal MatVector inputs, @ByVal MatVector outputs, @ByVal MatVector internals);
        public native void forward_fallback(@ByVal UMatVector inputs, @ByVal UMatVector outputs, @ByVal UMatVector internals);
        public native void forward_fallback(@ByVal GpuMatVector inputs, @ByVal GpuMatVector outputs, @ByVal GpuMatVector internals);

        /** \brief
         * \overload
         * @deprecated Use Layer::finalize(InputArrayOfArrays, OutputArrayOfArrays) instead
         */

        /** \brief
         * \overload
         * @deprecated Use Layer::finalize(InputArrayOfArrays, OutputArrayOfArrays) instead
         */
        public native @Deprecated @ByVal MatVector finalize(@Const @ByRef MatVector inputs);

        /** \brief Allocates layer and computes output.
         *  @deprecated This method will be removed in the future release.
         */
        public native @Deprecated void run(@Const @ByRef MatVector inputs, @ByRef MatVector outputs,
                                               @ByRef MatVector internals);

        /** \brief Returns index of input blob into the input array.
         *  @param inputName label of input blob
         *
         * Each layer input and output can be labeled to easily identify them using "%<layer_name%>[.output_name]" notation.
         * This method maps label of input blob to its index into input vector.
         */
        public native int inputNameToIndex(@Str BytePointer inputName);
        public native int inputNameToIndex(@Str String inputName);
        /** \brief Returns index of output blob in output array.
         *  @see inputNameToIndex()
         */
        public native int outputNameToIndex(@Str BytePointer outputName);
        public native int outputNameToIndex(@Str String outputName);

        /**
         * \brief Ask layer if it support specific backend for doing computations.
         * @param backendId [in] computation backend identifier.
         * @see Backend
         */
        public native @Cast("bool") boolean supportBackend(int backendId);

        /**
         * \brief Returns Halide backend node.
         * @param inputs [in] Input Halide buffers.
         * @see BackendNode, BackendWrapper
         *
         * Input buffers should be exactly the same that will be used in forward invocations.
         * Despite we can use Halide::ImageParam based on input shape only,
         * it helps prevent some memory management issues (if something wrong,
         * Halide tests will be failed).
         */

        /**
         * \brief Returns a CUDA backend node
         *
         * @param   context  void pointer to CSLContext object
         * @param   inputs   layer inputs
         * @param   outputs  layer outputs
         */

       /**
        * \brief Automatic Halide scheduling based on layer hyper-parameters.
        * @param node [in] Backend node with Halide functions.
        * @param inputs [in] Blobs that will be used in forward invocations.
        * @param outputs [in] Blobs that will be used in forward invocations.
        * @param targetId [in] Target identifier
        * @see BackendNode, Target
        *
        * Layer don't use own Halide::Func members because we can have applied
        * layers fusing. In this way the fused function should be scheduled.
        */
        public native void applyHalideScheduler(@Ptr BackendNode node,
                                                  @Const @ByRef MatPointerVector inputs,
                                                  @Const @ByRef MatVector outputs,
                                                  int targetId);

        /**
         * \brief Implement layers fusing.
         * @param node [in] Backend node of bottom layer.
         * @see BackendNode
         *
         * Actual for graph-based backends. If layer attached successfully,
         * returns non-empty cv::Ptr to node of the same backend.
         * Fuse only over the last function.
         */
        public native @Ptr BackendNode tryAttach(@Ptr BackendNode node);

        /**
         * \brief Tries to attach to the layer the subsequent activation layer, i.e. do the layer fusion in a partial case.
         * @param layer [in] The subsequent activation layer.
         *
         * Returns true if the activation layer has been attached successfully.
         */
        public native @Cast("bool") boolean setActivation(@Ptr ActivationLayer layer);

        /**
         * \brief Try to fuse current layer with a next one
         * @param top [in] Next layer to be fused.
         * @return True if fusion was performed.
         */
        public native @Cast("bool") boolean tryFuse(@Ptr Layer top);

        /**
         * \brief Returns parameters of layers with channel-wise multiplication and addition.
         * @param scale [out] Channel-wise multipliers. Total number of values should
         *                   be equal to number of channels.
         * @param shift [out] Channel-wise offsets. Total number of values should
         *                   be equal to number of channels.
         *
         * Some layers can fuse their transformations with further layers.
         * In example, convolution + batch normalization. This way base layer
         * use weights from layer after it. Fused layer is skipped.
         * By default, \p scale and \p shift are empty that means layer has no
         * element-wise multiplications or additions.
         */
        public native void getScaleShift(@ByRef Mat scale, @ByRef Mat shift);

        /**
         * \brief "Deattaches" all the layers, attached to particular layer.
         */
        public native void unsetAttached();

        public native @Cast("bool") boolean getMemoryShapes(@Const @ByRef MatShapeVector inputs,
                                             int requiredOutputs,
                                             @ByRef MatShapeVector outputs,
                                             @ByRef MatShapeVector internals);
        public native @Cast("int64") long getFLOPS(@Const @ByRef MatShapeVector inputs,
                                       @Const @ByRef MatShapeVector outputs);

        /** Name of the layer instance, can be used for logging or other internal purposes. */
        public native @Str BytePointer name(); public native Layer name(BytePointer setter);
        /** Type name which was used for creating layer by layer factory. */
        public native @Str BytePointer type(); public native Layer type(BytePointer setter);
        /** prefer target for layer forwarding */
        public native int preferableTarget(); public native Layer preferableTarget(int setter);

        public Layer() { super((Pointer)null); allocate(); }
        private native void allocate();
        /** Initializes only #name, #type and #blobs fields. */
        public Layer(@Const @ByRef LayerParams params) { super((Pointer)null); allocate(params); }
        private native void allocate(@Const @ByRef LayerParams params);
        /** Initializes only #name, #type and #blobs fields. */
        public native void setParamsFrom(@Const @ByRef LayerParams params);
    }
