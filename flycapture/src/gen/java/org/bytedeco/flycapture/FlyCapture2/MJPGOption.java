// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.flycapture.FlyCapture2;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.flycapture.global.FlyCapture2.*;

    /**
     * \defgroup VideoSaveStructures Video saving structures.
     *
     * These structures define various parameters used for saving videos.
     */

    /*@{*/

    /** Options for saving MJPG files. */
    @Namespace("FlyCapture2") @NoOffset @Properties(inherit = org.bytedeco.flycapture.presets.FlyCapture2.class)
public class MJPGOption extends Pointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public MJPGOption(Pointer p) { super(p); }
        /** Native array allocator. Access with {@link Pointer#position(long)}. */
        public MJPGOption(long size) { super((Pointer)null); allocateArray(size); }
        private native void allocateArray(long size);
        @Override public MJPGOption position(long position) {
            return (MJPGOption)super.position(position);
        }
    
        /** Frame rate of the stream */
        public native float frameRate(); public native MJPGOption frameRate(float setter);

        /** Image quality (1-100) */
        public native @Cast("unsigned int") int quality(); public native MJPGOption quality(int setter);

        public native @Cast("unsigned int") int reserved(int i); public native MJPGOption reserved(int i, int setter);
        @MemberGetter public native @Cast("unsigned int*") IntPointer reserved();

        public MJPGOption() { super((Pointer)null); allocate(); }
        private native void allocate();
    }
