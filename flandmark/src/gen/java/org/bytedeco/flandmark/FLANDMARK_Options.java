// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.flandmark;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import org.bytedeco.opencv.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;

import static org.bytedeco.flandmark.global.flandmark.*;


@Properties(inherit = org.bytedeco.flandmark.presets.flandmark.class)
public class FLANDMARK_Options extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public FLANDMARK_Options() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public FLANDMARK_Options(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FLANDMARK_Options(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public FLANDMARK_Options position(long position) {
        return (FLANDMARK_Options)super.position(position);
    }
    @Override public FLANDMARK_Options getPointer(long i) {
        return new FLANDMARK_Options(this).position(position + i);
    }

    public native @Cast("uint8_t") byte M(); public native FLANDMARK_Options M(byte setter);
    public native IntPointer S(); public native FLANDMARK_Options S(IntPointer setter);
    public native int bw(int i); public native FLANDMARK_Options bw(int i, int setter);
    @MemberGetter public native IntPointer bw();
    public native int bw_margin(int i); public native FLANDMARK_Options bw_margin(int i, int setter);
    @MemberGetter public native IntPointer bw_margin();
    public native FLANDMARK_PSIG PsiGS0(); public native FLANDMARK_Options PsiGS0(FLANDMARK_PSIG setter);
    public native FLANDMARK_PSIG PsiGS1(); public native FLANDMARK_Options PsiGS1(FLANDMARK_PSIG setter);
    public native FLANDMARK_PSIG PsiGS2(); public native FLANDMARK_Options PsiGS2(FLANDMARK_PSIG setter);
    public native int PSIG_ROWS(int i); public native FLANDMARK_Options PSIG_ROWS(int i, int setter);
    @MemberGetter public native IntPointer PSIG_ROWS();
    public native int PSIG_COLS(int i); public native FLANDMARK_Options PSIG_COLS(int i, int setter);
    @MemberGetter public native IntPointer PSIG_COLS();
}
