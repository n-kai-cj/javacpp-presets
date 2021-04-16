// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.flycapture.FlyCapture2_C;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.flycapture.FlyCapture2.*;
import static org.bytedeco.flycapture.global.FlyCapture2.*;

import static org.bytedeco.flycapture.global.FlyCapture2_C.*;


    /** Description of the system. */
    @Properties(inherit = org.bytedeco.flycapture.presets.FlyCapture2_C.class)
public class fc2SystemInfo extends Pointer {
        static { Loader.load(); }
        /** Default native constructor. */
        public fc2SystemInfo() { super((Pointer)null); allocate(); }
        /** Native array allocator. Access with {@link Pointer#position(long)}. */
        public fc2SystemInfo(long size) { super((Pointer)null); allocateArray(size); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public fc2SystemInfo(Pointer p) { super(p); }
        private native void allocate();
        private native void allocateArray(long size);
        @Override public fc2SystemInfo position(long position) {
            return (fc2SystemInfo)super.position(position);
        }
        @Override public fc2SystemInfo getPointer(long i) {
            return new fc2SystemInfo((Pointer)this).position(position + i);
        }
    
        /** Operating system type as described by OSType. */
        public native @Cast("fc2OSType") int osType(); public native fc2SystemInfo osType(int setter);

        /** Detailed description of the operating system. */
        public native @Cast("char") byte osDescription(int i); public native fc2SystemInfo osDescription(int i, byte setter);
        @MemberGetter public native @Cast("char*") BytePointer osDescription();

        /** Byte order of the system. */
        public native @Cast("fc2ByteOrder") int byteOrder(); public native fc2SystemInfo byteOrder(int setter);

        /** Amount of memory available on the system. */
        public native @Cast("size_t") long sysMemSize(); public native fc2SystemInfo sysMemSize(long setter);

        /** Detailed description of the CPU. */
        public native @Cast("char") byte cpuDescription(int i); public native fc2SystemInfo cpuDescription(int i, byte setter);
        @MemberGetter public native @Cast("char*") BytePointer cpuDescription();

        /** Number of cores on all CPUs on the system. */
        public native @Cast("size_t") long numCpuCores(); public native fc2SystemInfo numCpuCores(long setter);

        /** List of drivers used. */
        public native @Cast("char") byte driverList(int i); public native fc2SystemInfo driverList(int i, byte setter);
        @MemberGetter public native @Cast("char*") BytePointer driverList();

        /** List of libraries used. */
        public native @Cast("char") byte libraryList(int i); public native fc2SystemInfo libraryList(int i, byte setter);
        @MemberGetter public native @Cast("char*") BytePointer libraryList();

        /** Detailed description of the GPU. */
        public native @Cast("char") byte gpuDescription(int i); public native fc2SystemInfo gpuDescription(int i, byte setter);
        @MemberGetter public native @Cast("char*") BytePointer gpuDescription();

        /** Screen resolution width in pixels. */
        public native @Cast("size_t") long screenWidth(); public native fc2SystemInfo screenWidth(long setter);

        /** Screen resolution height in pixels. */
        public native @Cast("size_t") long screenHeight(); public native fc2SystemInfo screenHeight(long setter);

        /** Reserved for future use. */
        public native @Cast("unsigned int") int reserved(int i); public native fc2SystemInfo reserved(int i, int setter);
        @MemberGetter public native @Cast("unsigned int*") IntPointer reserved();

    }
