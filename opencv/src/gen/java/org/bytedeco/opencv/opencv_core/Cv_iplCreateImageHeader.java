// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_core;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;

import static org.bytedeco.opencv.global.opencv_core.*;


@Convention("CV_STDCALL") @Properties(inherit = org.bytedeco.opencv.presets.opencv_core.class)
public class Cv_iplCreateImageHeader extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    Cv_iplCreateImageHeader(Pointer p) { super(p); }
    protected Cv_iplCreateImageHeader() { allocate(); }
    private native void allocate();
    public native IplImage call(int arg0,int arg1,int arg2,@Cast("char*") BytePointer arg3,@Cast("char*") BytePointer arg4,int arg5,int arg6,int arg7,int arg8,int arg9,
                            IplROI arg10,IplImage arg11,Pointer arg12,IplTileInfo arg13);
}
