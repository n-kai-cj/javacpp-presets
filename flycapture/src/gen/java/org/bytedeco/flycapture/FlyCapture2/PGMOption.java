// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.flycapture.FlyCapture2;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.flycapture.global.FlyCapture2.*;


    /** Options for saving PGM images. */
    @Namespace("FlyCapture2") @NoOffset @Properties(inherit = org.bytedeco.flycapture.presets.FlyCapture2.class)
public class PGMOption extends Pointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public PGMOption(Pointer p) { super(p); }
        /** Native array allocator. Access with {@link Pointer#position(long)}. */
        public PGMOption(long size) { super((Pointer)null); allocateArray(size); }
        private native void allocateArray(long size);
        @Override public PGMOption position(long position) {
            return (PGMOption)super.position(position);
        }
        @Override public PGMOption getPointer(long i) {
            return new PGMOption((Pointer)this).position(position + i);
        }
    
        /** Whether to save the PPM as a binary file. */
        public native @Cast("bool") boolean binaryFile(); public native PGMOption binaryFile(boolean setter);
        /** Reserved for future use. */
        public native @Cast("unsigned int") int reserved(int i); public native PGMOption reserved(int i, int setter);
        @MemberGetter public native @Cast("unsigned int*") IntPointer reserved();

        public PGMOption() { super((Pointer)null); allocate(); }
        private native void allocate();
    }
