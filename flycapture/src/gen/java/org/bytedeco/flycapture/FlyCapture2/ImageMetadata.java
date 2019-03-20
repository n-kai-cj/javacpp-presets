// Targeted by JavaCPP version 1.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.flycapture.FlyCapture2;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.flycapture.global.FlyCapture2.*;


    /** Metadata related to an image. */
    @Namespace("FlyCapture2") @NoOffset @Properties(inherit = org.bytedeco.flycapture.presets.FlyCapture2.class)
public class ImageMetadata extends Pointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public ImageMetadata(Pointer p) { super(p); }
        /** Native array allocator. Access with {@link Pointer#position(long)}. */
        public ImageMetadata(long size) { super((Pointer)null); allocateArray(size); }
        private native void allocateArray(long size);
        @Override public ImageMetadata position(long position) {
            return (ImageMetadata)super.position(position);
        }
    
        /** Embedded timestamp. */
        public native @Cast("unsigned int") int embeddedTimeStamp(); public native ImageMetadata embeddedTimeStamp(int embeddedTimeStamp);
        /** Embedded gain. */
        public native @Cast("unsigned int") int embeddedGain(); public native ImageMetadata embeddedGain(int embeddedGain);
        /** Embedded shutter. */
        public native @Cast("unsigned int") int embeddedShutter(); public native ImageMetadata embeddedShutter(int embeddedShutter);
        /** Embedded brightness. */
        public native @Cast("unsigned int") int embeddedBrightness(); public native ImageMetadata embeddedBrightness(int embeddedBrightness);
        /** Embedded exposure. */
        public native @Cast("unsigned int") int embeddedExposure(); public native ImageMetadata embeddedExposure(int embeddedExposure);
        /** Embedded white balance. */
        public native @Cast("unsigned int") int embeddedWhiteBalance(); public native ImageMetadata embeddedWhiteBalance(int embeddedWhiteBalance);
        /** Embedded frame counter. */
        public native @Cast("unsigned int") int embeddedFrameCounter(); public native ImageMetadata embeddedFrameCounter(int embeddedFrameCounter);
        /** Embedded strobe pattern. */
        public native @Cast("unsigned int") int embeddedStrobePattern(); public native ImageMetadata embeddedStrobePattern(int embeddedStrobePattern);
        /** Embedded GPIO pin state. */
        public native @Cast("unsigned int") int embeddedGPIOPinState(); public native ImageMetadata embeddedGPIOPinState(int embeddedGPIOPinState);
        /** Embedded ROI position. */
        public native @Cast("unsigned int") int embeddedROIPosition(); public native ImageMetadata embeddedROIPosition(int embeddedROIPosition);

        /** Reserved for future use. */
        public native @Cast("unsigned int") int reserved(int i); public native ImageMetadata reserved(int i, int reserved);
        @MemberGetter public native @Cast("unsigned int*") IntPointer reserved();

        public ImageMetadata() { super((Pointer)null); allocate(); }
        private native void allocate();
    }