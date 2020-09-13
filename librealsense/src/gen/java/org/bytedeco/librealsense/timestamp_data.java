// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.librealsense;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.librealsense.global.RealSense.*;


    /** \brief Timestamp data from the motion microcontroller */
    @Namespace("rs") @Properties(inherit = org.bytedeco.librealsense.presets.RealSense.class)
public class timestamp_data extends rs_timestamp_data {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public timestamp_data(Pointer p) { super(p); }
        /** Native array allocator. Access with {@link Pointer#position(long)}. */
        public timestamp_data(long size) { super((Pointer)null); allocateArray(size); }
        private native void allocateArray(long size);
        @Override public timestamp_data position(long position) {
            return (timestamp_data)super.position(position);
        }
        @Override public timestamp_data getPointer(long i) {
            return new timestamp_data(this).position(position + i);
        }
    
        public timestamp_data(@ByVal rs_timestamp_data orig) { super((Pointer)null); allocate(orig); }
        private native void allocate(@ByVal rs_timestamp_data orig);
        public timestamp_data() { super((Pointer)null); allocate(); }
        private native void allocate();
    }
