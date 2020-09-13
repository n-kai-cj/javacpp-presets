// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.ngraph;

import org.bytedeco.ngraph.Allocator;
import org.bytedeco.ngraph.Function;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.ngraph.global.ngraph.*;

        /** \brief Class for constants. */
        @Namespace("ngraph::op") @NoOffset @Properties(inherit = org.bytedeco.ngraph.presets.ngraph.class)
public class Constant extends Node {
            static { Loader.load(); }
            /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
            public Constant(Pointer p) { super(p); }
        
            @MemberGetter public static native @StdString BytePointer type_name();
            
            ///
            public native @StdString BytePointer description();
            /** \brief Constructs a tensor constant.
             * 
             *  @param type The element type of the tensor constant.
             *  @param shape The shape of the tensor constant.
             *  @param values A vector of literals for initializing the tensor constant. The size
             *         of values must match the size of the shape. */

            /** \brief Constructs a tensor constant
             *         This constructor is mainly to support deserialization of constants.
             * 
             *  @param type The element type of the tensor constant.
             *  @param shape The shape of the tensor constant.
             *  @param values A list of string values to use as the constant data. */
            
            ///
            public Constant(@Const @ByRef Type type, @ByVal Shape shape, @Const @ByRef StringVector values) { super((Pointer)null); allocate(type, shape, values); }
            private native void allocate(@Const @ByRef Type type, @ByVal Shape shape, @Const @ByRef StringVector values);

            /** \brief Constructs a tensor constant with the same initialization value copied across */
            //         the tensor. This constructor is to support deserialization of constants.
            /**
            /** @param type The element type of the tensor constant.
            /** @param shape The shape of the tensor constant.
            /** @param data A void* to constant data. */
            public Constant(@Const @ByRef Type type, @Const @ByRef Shape shape, @Const Pointer data) { super((Pointer)null); allocate(type, shape, data); }
            private native void allocate(@Const @ByRef Type type, @Const @ByRef Shape shape, @Const Pointer data);

            public native void validate_and_infer_types();

            /** \brief Returns the value of the constant node as a Shape object
             *         Can only be used on element::i64 nodes and interprets
             *         negative values as zeros. */
            public native @ByVal Shape get_shape_val();
            /** \brief Returns the value of the constant node as a Strides
             *         object
             *         Can only be used on element::i64 nodes and interprets
             *         negative values as zeros. */
            public native @ByVal Strides get_strides_val();
            /** \brief Returns the value of the constant node as a Coordinate
             *         object
             *         Can only be used on element::i64 nodes and interprets
             *         negative values as zeros. */
            public native @ByVal Coordinate get_coordinate_val();
            /** \brief Returns the value of the constant node as a
             *         CoordinateDiff object
             *         Can only be used on element::i64 nodes. */
            public native @ByVal CoordinateDiff get_coordinate_diff_val();
            /** \brief Returns the value of the constant node as an AxisVector
             *         object
             *         Can only be used on element::i64 nodes and interprets
             *         negative values as zeros. */
            public native @ByVal AxisVector get_axis_vector_val();
            /** \brief Returns the value of the constant node as an AxisSet
             *         object
             *         Can only be used on element::i64 nodes and interprets
             *         negative values as zeros.
             *         Repeated values are allowed. */
            
            ///
            public native @ByVal AxisSet get_axis_set_val();

            /** \brief Wrapper around constructing a shared_ptr of a Constant
             * 
             *  @param type The element type of the tensor constant.
             *  @param shape The shape of the tensor constant.
             *  @param values A vector of values to use as the constant data. */

            /** \brief Wrapper around constructing a shared_ptr of a Constant
             * 
             *  @param type The element type of the tensor constant.
             *  @param shape The shape of the tensor constant.
             *  @param values An initializer_list of values to use as the constant data. */

            public native @SharedPtr @ByVal Node copy_with_new_args(@Const @ByRef NodeVector new_args);

            /** @return The initialization literals for the tensor constant. */
            public native @ByVal StringVector get_value_strings();

            public native @Const Pointer get_data_ptr();

            public native @Cast("bool") boolean is_constant();
            public native @Cast("bool") boolean are_all_data_elements_bitwise_identical();
            public native @StdString BytePointer convert_value_to_string(@Cast("size_t") long index);
        }
