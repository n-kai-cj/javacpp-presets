// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.ngraph;

import org.bytedeco.ngraph.Allocator;
import org.bytedeco.ngraph.Function;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.ngraph.global.ngraph.*;


    @Namespace("ngraph") @Properties(inherit = org.bytedeco.ngraph.presets.ngraph.class)
public class CheckLocInfo extends Pointer {
        static { Loader.load(); }
        /** Default native constructor. */
        public CheckLocInfo() { super((Pointer)null); allocate(); }
        /** Native array allocator. Access with {@link Pointer#position(long)}. */
        public CheckLocInfo(long size) { super((Pointer)null); allocateArray(size); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public CheckLocInfo(Pointer p) { super(p); }
        private native void allocate();
        private native void allocateArray(long size);
        @Override public CheckLocInfo position(long position) {
            return (CheckLocInfo)super.position(position);
        }
        @Override public CheckLocInfo getPointer(long i) {
            return new CheckLocInfo((Pointer)this).position(position + i);
        }
    
        public native @Cast("const char*") BytePointer file(); public native CheckLocInfo file(BytePointer setter);
        public native int line(); public native CheckLocInfo line(int setter);
        public native @Cast("const char*") BytePointer check_string(); public native CheckLocInfo check_string(BytePointer setter);
    }
