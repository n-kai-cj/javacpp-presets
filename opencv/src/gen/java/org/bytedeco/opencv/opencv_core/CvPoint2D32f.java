// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_core;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;

import static org.bytedeco.opencv.global.opencv_core.*;

// #endif

@NoOffset @Properties(inherit = org.bytedeco.opencv.presets.opencv_core.class)
public class CvPoint2D32f extends AbstractCvPoint2D32f {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CvPoint2D32f(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public CvPoint2D32f(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public CvPoint2D32f position(long position) {
        return (CvPoint2D32f)super.position(position);
    }
    @Override public CvPoint2D32f getPointer(long i) {
        return new CvPoint2D32f(this).position(position + i);
    }

    public native float x(); public native CvPoint2D32f x(float setter);
    public native float y(); public native CvPoint2D32f y(float setter);

// #ifdef CV__VALIDATE_UNUNITIALIZED_VARS
    public CvPoint2D32f() { super((Pointer)null); allocate(); }
    private native void allocate();
// #elif defined(CV__ENABLE_C_API_CTORS) && defined(__cplusplus)
// #endif
// #ifdef __cplusplus
// #endif
}
