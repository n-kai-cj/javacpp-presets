// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.flycapture.FlyCapture2_C;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.flycapture.FlyCapture2.*;
import static org.bytedeco.flycapture.global.FlyCapture2.*;

import static org.bytedeco.flycapture.global.FlyCapture2_C.*;


    /** The current version of the library. */
    @Properties(inherit = org.bytedeco.flycapture.presets.FlyCapture2_C.class)
public class fc2Version extends Pointer {
        static { Loader.load(); }
        /** Default native constructor. */
        public fc2Version() { super((Pointer)null); allocate(); }
        /** Native array allocator. Access with {@link Pointer#position(long)}. */
        public fc2Version(long size) { super((Pointer)null); allocateArray(size); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public fc2Version(Pointer p) { super(p); }
        private native void allocate();
        private native void allocateArray(long size);
        @Override public fc2Version position(long position) {
            return (fc2Version)super.position(position);
        }
        @Override public fc2Version getPointer(long i) {
            return new fc2Version(this).position(position + i);
        }
    
        /** Major version number. */
        public native @Cast("unsigned int") int major(); public native fc2Version major(int setter);
        /** Minor version number. */
        public native @Cast("unsigned int") int minor(); public native fc2Version minor(int setter);
        /** Type version number. */
        public native @Cast("unsigned int") int type(); public native fc2Version type(int setter);
        /** Build version number. */
        public native @Cast("unsigned int") int build(); public native fc2Version build(int setter);
    }
