// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.openpose;

import org.bytedeco.javacpp.annotation.Index;
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
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import org.bytedeco.opencv.opencv_videoio.*;
import static org.bytedeco.opencv.global.opencv_videoio.*;
import org.bytedeco.opencv.opencv_highgui.*;
import static org.bytedeco.opencv.global.opencv_highgui.*;
import org.bytedeco.hdf5.*;
import static org.bytedeco.hdf5.global.hdf5.*;
import org.bytedeco.caffe.*;
import static org.bytedeco.caffe.global.caffe.*;

import static org.bytedeco.openpose.global.openpose.*;

    @Name("op::Point<float>") @NoOffset @Properties(inherit = org.bytedeco.openpose.presets.openpose.class)
public class FloatPoint extends Pointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public FloatPoint(Pointer p) { super(p); }
        /** Native array allocator. Access with {@link Pointer#position(long)}. */
        public FloatPoint(long size) { super((Pointer)null); allocateArray(size); }
        private native void allocateArray(long size);
        @Override public FloatPoint position(long position) {
            return (FloatPoint)super.position(position);
        }
    
        public native float x(); public native FloatPoint x(float setter);
        public native float y(); public native FloatPoint y(float setter);

        public FloatPoint(float x/*=0*/, float y/*=0*/) { super((Pointer)null); allocate(x, y); }
        private native void allocate(float x/*=0*/, float y/*=0*/);
        public FloatPoint() { super((Pointer)null); allocate(); }
        private native void allocate();

        /**
         * Copy constructor.
         * It performs {@code fast copy}: For performance purpose, copying a Point<T> or Point<T> or cv::Mat just copies the
         * reference, it still shares the same internal data.
         * Modifying the copied element will modify the original one.
         * Use clone() for a slower but real copy, similarly to cv::Mat and Point<T>.
         * @param point Point to be copied.
         */
        public FloatPoint(@Const @ByRef FloatPoint point) { super((Pointer)null); allocate(point); }
        private native void allocate(@Const @ByRef FloatPoint point);

        /**
         * Copy assignment.
         * Similar to Point<T>(const Point<T>& point).
         * @param point Point to be copied.
         * @return The resulting Point.
         */
        public native @ByRef @Name("operator =") FloatPoint put(@Const @ByRef FloatPoint point);

        /**
         * Move constructor.
         * It destroys the original Point to be moved.
         * @param point Point to be moved.
         */

        /**
         * Move assignment.
         * Similar to Point<T>(Point<T>&& point).
         * @param point Point to be moved.
         * @return The resulting Point.
         */

        public native float area();

        /**
         * It returns a string with the whole Point<T> data. Useful for debugging.
         * The format is: {@code [x, y]}
         * @return A string with the Point<T> values in the above format.
         */
        





        // ------------------------------ Comparison operators ------------------------------ //
        /**
         * Less comparison operator.
         * @param point Point<T> to be compared.
         * @return Whether the instance satisfies the condition with respect to point.
         */
        public native @Cast("bool") @Name("operator <") boolean lessThan(@Const @ByRef FloatPoint point);

        /**
         * Greater comparison operator.
         * @param point Point<T> to be compared.
         * @return Whether the instance satisfies the condition with respect to point.
         */
        public native @Cast("bool") @Name("operator >") boolean greaterThan(@Const @ByRef FloatPoint point);

        /**
         * Less or equal comparison operator.
         * @param point Point<T> to be compared.
         * @return Whether the instance satisfies the condition with respect to point.
         */
        public native @Cast("bool") @Name("operator <=") boolean lessThanEquals(@Const @ByRef FloatPoint point);

        /**
         * Greater or equal comparison operator.
         * @param point Point<T> to be compared.
         * @return Whether the instance satisfies the condition with respect to point.
         */
        public native @Cast("bool") @Name("operator >=") boolean greaterThanEquals(@Const @ByRef FloatPoint point);

        /**
         * Equal comparison operator.
         * @param point Point<T> to be compared.
         * @return Whether the instance satisfies the condition with respect to point.
         */
        public native @Cast("bool") @Name("operator ==") boolean equals(@Const @ByRef FloatPoint point);

        /**
         * Not equal comparison operator.
         * @param point Point<T> to be compared.
         * @return Whether the instance satisfies the condition with respect to point.
         */
        public native @Cast("bool") @Name("operator !=") boolean notEquals(@Const @ByRef FloatPoint point);





        // ------------------------------ Basic Operators ------------------------------ //
        public native @ByRef @Name("operator +=") FloatPoint addPut(@Const @ByRef FloatPoint point);

        public native @ByVal @Name("operator +") FloatPoint add(@Const @ByRef FloatPoint point);

        public native @ByRef @Name("operator +=") FloatPoint addPut(float value);

        public native @ByVal @Name("operator +") FloatPoint add(float value);

        public native @ByRef @Name("operator -=") FloatPoint subtractPut(@Const @ByRef FloatPoint point);

        public native @ByVal @Name("operator -") FloatPoint subtract(@Const @ByRef FloatPoint point);

        public native @ByRef @Name("operator -=") FloatPoint subtractPut(float value);

        public native @ByVal @Name("operator -") FloatPoint subtract(float value);

        public native @ByRef @Name("operator *=") FloatPoint multiplyPut(float value);

        public native @ByVal @Name("operator *") FloatPoint multiply(float value);

        public native @ByRef @Name("operator /=") FloatPoint dividePut(float value);

        public native @ByVal @Name("operator /") FloatPoint divide(float value);
    }
