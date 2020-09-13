// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.skia;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.skia.global.Skia.*;


@Properties(inherit = org.bytedeco.skia.presets.Skia.class)
public class gr_vk_ycbcrconversioninfo_t extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public gr_vk_ycbcrconversioninfo_t() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public gr_vk_ycbcrconversioninfo_t(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public gr_vk_ycbcrconversioninfo_t(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public gr_vk_ycbcrconversioninfo_t position(long position) {
        return (gr_vk_ycbcrconversioninfo_t)super.position(position);
    }
    @Override public gr_vk_ycbcrconversioninfo_t getPointer(long i) {
        return new gr_vk_ycbcrconversioninfo_t(this).position(position + i);
    }

    public native @Cast("uint32_t") int fFormat(); public native gr_vk_ycbcrconversioninfo_t fFormat(int setter);
    public native @Cast("uint64_t") long fExternalFormat(); public native gr_vk_ycbcrconversioninfo_t fExternalFormat(long setter);
    public native @Cast("uint32_t") int fYcbcrModel(); public native gr_vk_ycbcrconversioninfo_t fYcbcrModel(int setter);
    public native @Cast("uint32_t") int fYcbcrRange(); public native gr_vk_ycbcrconversioninfo_t fYcbcrRange(int setter);
    public native @Cast("uint32_t") int fXChromaOffset(); public native gr_vk_ycbcrconversioninfo_t fXChromaOffset(int setter);
    public native @Cast("uint32_t") int fYChromaOffset(); public native gr_vk_ycbcrconversioninfo_t fYChromaOffset(int setter);
    public native @Cast("uint32_t") int fChromaFilter(); public native gr_vk_ycbcrconversioninfo_t fChromaFilter(int setter);
    public native @Cast("uint32_t") int fForceExplicitReconstruction(); public native gr_vk_ycbcrconversioninfo_t fForceExplicitReconstruction(int setter);
    public native @Cast("uint32_t") int fFormatFeatures(); public native gr_vk_ycbcrconversioninfo_t fFormatFeatures(int setter);
}
