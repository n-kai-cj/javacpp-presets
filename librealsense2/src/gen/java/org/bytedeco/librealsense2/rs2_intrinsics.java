// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.librealsense2;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.librealsense2.global.realsense2.*;


/** \brief Video stream intrinsics. */
@Properties(inherit = org.bytedeco.librealsense2.presets.realsense2.class)
public class rs2_intrinsics extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public rs2_intrinsics() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public rs2_intrinsics(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public rs2_intrinsics(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public rs2_intrinsics position(long position) {
        return (rs2_intrinsics)super.position(position);
    }
    @Override public rs2_intrinsics getPointer(long i) {
        return new rs2_intrinsics(this).position(position + i);
    }

    /** Width of the image in pixels */
    public native int width(); public native rs2_intrinsics width(int setter);
    /** Height of the image in pixels */
    public native int height(); public native rs2_intrinsics height(int setter);
    /** Horizontal coordinate of the principal point of the image, as a pixel offset from the left edge */
    public native float ppx(); public native rs2_intrinsics ppx(float setter);
    /** Vertical coordinate of the principal point of the image, as a pixel offset from the top edge */
    public native float ppy(); public native rs2_intrinsics ppy(float setter);
    /** Focal length of the image plane, as a multiple of pixel width */
    public native float fx(); public native rs2_intrinsics fx(float setter);
    /** Focal length of the image plane, as a multiple of pixel height */
    public native float fy(); public native rs2_intrinsics fy(float setter);
    /** Distortion model of the image */
    public native @Cast("rs2_distortion") int model(); public native rs2_intrinsics model(int setter);
    /** Distortion coefficients. Order for Brown-Conrady: [k1, k2, p1, p2, k3]. Order for F-Theta Fish-eye: [k1, k2, k3, k4, 0]. Other models are subject to their own interpretations */
    public native float coeffs(int i); public native rs2_intrinsics coeffs(int i, float setter);
    @MemberGetter public native FloatPointer coeffs();
}
