// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorrt.nvinfer;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.cuda.cudart.*;
import static org.bytedeco.cuda.global.cudart.*;
import org.bytedeco.cuda.cublas.*;
import static org.bytedeco.cuda.global.cublas.*;
import org.bytedeco.cuda.cudnn.*;
import static org.bytedeco.cuda.global.cudnn.*;
import org.bytedeco.cuda.nvrtc.*;
import static org.bytedeco.cuda.global.nvrtc.*;

import static org.bytedeco.tensorrt.global.nvinfer.*;


/**
 *  \class DimsExprs
 * 
 *  Analog of class Dims with expressions instead of constants for the dimensions.
 *  */
@Namespace("nvinfer1") @Properties(inherit = org.bytedeco.tensorrt.presets.nvinfer.class)
public class DimsExprs extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public DimsExprs() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public DimsExprs(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DimsExprs(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public DimsExprs position(long position) {
        return (DimsExprs)super.position(position);
    }

    /** The number of dimensions. */
    public native int nbDims(); public native DimsExprs nbDims(int setter);
    /** The extent of each dimension. */
    public native @Const IDimensionExpr d(int i); public native DimsExprs d(int i, IDimensionExpr setter);
    @MemberGetter public native @Cast("const nvinfer1::IDimensionExpr**") PointerPointer d();
}
