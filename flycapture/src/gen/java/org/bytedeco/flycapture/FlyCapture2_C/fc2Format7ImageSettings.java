// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.flycapture.FlyCapture2_C;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.flycapture.FlyCapture2.*;
import static org.bytedeco.flycapture.global.FlyCapture2.*;

import static org.bytedeco.flycapture.global.FlyCapture2_C.*;


    /*@}*/

    /**
     * \defgroup CIIDCStructures IIDC specific structures
     *
     * These structures are specific to IIDC camera operation only.
     */

    /*@{*/

    /** Format 7 image settings. */
    @Properties(inherit = org.bytedeco.flycapture.presets.FlyCapture2_C.class)
public class fc2Format7ImageSettings extends Pointer {
        static { Loader.load(); }
        /** Default native constructor. */
        public fc2Format7ImageSettings() { super((Pointer)null); allocate(); }
        /** Native array allocator. Access with {@link Pointer#position(long)}. */
        public fc2Format7ImageSettings(long size) { super((Pointer)null); allocateArray(size); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public fc2Format7ImageSettings(Pointer p) { super(p); }
        private native void allocate();
        private native void allocateArray(long size);
        @Override public fc2Format7ImageSettings position(long position) {
            return (fc2Format7ImageSettings)super.position(position);
        }
        @Override public fc2Format7ImageSettings getPointer(long i) {
            return new fc2Format7ImageSettings(this).position(position + i);
        }
    
        /** Format 7 mode. */
        public native @Cast("fc2Mode") int mode(); public native fc2Format7ImageSettings mode(int setter);
        /** Horizontal image offset. */
        public native @Cast("unsigned int") int offsetX(); public native fc2Format7ImageSettings offsetX(int setter);
        /** Vertical image offset. */
        public native @Cast("unsigned int") int offsetY(); public native fc2Format7ImageSettings offsetY(int setter);
        /** Width of image. */
        public native @Cast("unsigned int") int width(); public native fc2Format7ImageSettings width(int setter);
        /** Height of image. */
        public native @Cast("unsigned int") int height(); public native fc2Format7ImageSettings height(int setter);
        /** Pixel format of image. */
        public native @Cast("fc2PixelFormat") int pixelFormat(); public native fc2Format7ImageSettings pixelFormat(int setter);
        /** Reserved for future use. */
        public native @Cast("unsigned int") int reserved(int i); public native fc2Format7ImageSettings reserved(int i, int setter);
        @MemberGetter public native @Cast("unsigned int*") IntPointer reserved();

    }
