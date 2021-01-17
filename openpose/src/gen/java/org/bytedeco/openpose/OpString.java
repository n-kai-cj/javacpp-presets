// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

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

    /**
     * String: Basic container for std::string to avoid std::string in the WrapperStructXXX classes. Otherwise,
     * cryptic runtime DLL errors could occur when exporting OpenPose to other projects using different STL DLLs.
     */
    @Name("op::String") @NoOffset @Properties(inherit = org.bytedeco.openpose.presets.openpose.class)
public class OpString extends Pointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public OpString(Pointer p) { super(p); }
        /** Native array allocator. Access with {@link Pointer#position(long)}. */
        public OpString(long size) { super((Pointer)null); allocateArray(size); }
        private native void allocateArray(long size);
        @Override public OpString position(long position) {
            return (OpString)super.position(position);
        }
        @Override public OpString getPointer(long i) {
            return new OpString(this).position(position + i);
        }
    
        public OpString() { super((Pointer)null); allocate(); }
        private native void allocate();

        /**
         * It will force a copy of the char* of std::string to avoid DLL runtime errors. Example usages:
         * std::string stdString = "This is a std::string"; 
         * String string(stdString.c_str()); 
         */
        public OpString(@Cast("const char*") BytePointer charPtr) { super((Pointer)null); allocate(charPtr); }
        private native void allocate(@Cast("const char*") BytePointer charPtr);
        public OpString(String charPtr) { super((Pointer)null); allocate(charPtr); }
        private native void allocate(String charPtr);

        /**
         * It will force a copy of string
         */

        public native @StdString BytePointer getStdString();

        public native @Cast("bool") boolean empty();
    }
