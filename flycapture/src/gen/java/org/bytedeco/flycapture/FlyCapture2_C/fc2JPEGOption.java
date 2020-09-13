// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.flycapture.FlyCapture2_C;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.flycapture.FlyCapture2.*;
import static org.bytedeco.flycapture.global.FlyCapture2.*;

import static org.bytedeco.flycapture.global.FlyCapture2_C.*;


    /** Options for saving JPEG image. */
    @Properties(inherit = org.bytedeco.flycapture.presets.FlyCapture2_C.class)
public class fc2JPEGOption extends Pointer {
        static { Loader.load(); }
        /** Default native constructor. */
        public fc2JPEGOption() { super((Pointer)null); allocate(); }
        /** Native array allocator. Access with {@link Pointer#position(long)}. */
        public fc2JPEGOption(long size) { super((Pointer)null); allocateArray(size); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public fc2JPEGOption(Pointer p) { super(p); }
        private native void allocate();
        private native void allocateArray(long size);
        @Override public fc2JPEGOption position(long position) {
            return (fc2JPEGOption)super.position(position);
        }
        @Override public fc2JPEGOption getPointer(long i) {
            return new fc2JPEGOption(this).position(position + i);
        }
    
        /** Whether to save as a progressive JPEG file. */
        public native @Cast("BOOL") int progressive(); public native fc2JPEGOption progressive(int setter);
        /**
         * JPEG image quality in range (0-100).
         * - 100 - Superb quality.
         * - 75  - Good quality.
         * - 50  - Normal quality.
         * - 10  - Poor quality.
         */
        public native @Cast("unsigned int") int quality(); public native fc2JPEGOption quality(int setter);
        /** Reserved for future use. */
        public native @Cast("unsigned int") int reserved(int i); public native fc2JPEGOption reserved(int i, int setter);
        @MemberGetter public native @Cast("unsigned int*") IntPointer reserved();

    }
