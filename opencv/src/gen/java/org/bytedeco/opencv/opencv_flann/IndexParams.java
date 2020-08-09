// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_flann;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_core.*;

import static org.bytedeco.opencv.global.opencv_flann.*;


@Namespace("cv::flann") @NoOffset @Properties(inherit = org.bytedeco.opencv.presets.opencv_flann.class)
public class IndexParams extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IndexParams(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public IndexParams(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public IndexParams position(long position) {
        return (IndexParams)super.position(position);
    }
    @Override public IndexParams getPointer(long i) {
        return new IndexParams(this).position(position + i);
    }

    public IndexParams() { super((Pointer)null); allocate(); }
    private native void allocate();

    public native @Str BytePointer getString(@Str BytePointer key, @Str BytePointer defaultVal/*=cv::String()*/);
    public native @Str BytePointer getString(@Str BytePointer key);
    public native @Str String getString(@Str String key, @Str String defaultVal/*=cv::String()*/);
    public native @Str String getString(@Str String key);
    public native int getInt(@Str BytePointer key, int defaultVal/*=-1*/);
    public native int getInt(@Str BytePointer key);
    public native int getInt(@Str String key, int defaultVal/*=-1*/);
    public native int getInt(@Str String key);
    public native double getDouble(@Str BytePointer key, double defaultVal/*=-1*/);
    public native double getDouble(@Str BytePointer key);
    public native double getDouble(@Str String key, double defaultVal/*=-1*/);
    public native double getDouble(@Str String key);

    public native void setString(@Str BytePointer key, @Str BytePointer value);
    public native void setString(@Str String key, @Str String value);
    public native void setInt(@Str BytePointer key, int value);
    public native void setInt(@Str String key, int value);
    public native void setDouble(@Str BytePointer key, double value);
    public native void setDouble(@Str String key, double value);
    public native void setFloat(@Str BytePointer key, float value);
    public native void setFloat(@Str String key, float value);
    public native void setBool(@Str BytePointer key, @Cast("bool") boolean value);
    public native void setBool(@Str String key, @Cast("bool") boolean value);
    public native void setAlgorithm(int value);

    // FIXIT: replace by void write(FileStorage& fs) const + read()
    public native void getAll(@ByRef StringVector names,
                    @Cast("cv::flann::FlannIndexType*") @StdVector IntPointer types,
                    @ByRef StringVector strValues,
                    @StdVector DoublePointer numValues);
    public native void getAll(@ByRef StringVector names,
                    @Cast("cv::flann::FlannIndexType*") @StdVector IntBuffer types,
                    @ByRef StringVector strValues,
                    @StdVector DoubleBuffer numValues);
    public native void getAll(@ByRef StringVector names,
                    @Cast("cv::flann::FlannIndexType*") @StdVector int[] types,
                    @ByRef StringVector strValues,
                    @StdVector double[] numValues);

    public native Pointer params(); public native IndexParams params(Pointer setter);
}
