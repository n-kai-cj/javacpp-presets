// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

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
 *  \class DimsCHW
 *  \brief Descriptor for data with one channel dimension and two spatial dimensions.
 * 
 *  @deprecated DimsCHW will be removed in a future version of TensorRT, use Dims3 instead.
 *  */
@Namespace("nvinfer1") @Properties(inherit = org.bytedeco.tensorrt.presets.nvinfer.class)
public class DimsCHW extends Dims3 {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DimsCHW(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public DimsCHW(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public DimsCHW position(long position) {
        return (DimsCHW)super.position(position);
    }
    @Override public DimsCHW getPointer(long i) {
        return new DimsCHW(this).position(position + i);
    }

    /**
     *  \brief Construct an empty DimsCHW object.
     *  */
    
    
    //!
    //!
    //!
    public DimsCHW() { super((Pointer)null); allocate(); }
    private native void allocate();

    /**
     *  \brief Construct a DimsCHW given channel count, height and width.
     * 
     *  @param channels The channel count.
     *  @param height The height of the data.
     *  @param width The width of the data.
     *  */
    
    
    //!
    //!
    //!
    public DimsCHW(int channels, int height, int width) { super((Pointer)null); allocate(channels, height, width); }
    private native void allocate(int channels, int height, int width);

    /**
     *  \brief Get the channel count.
     * 
     *  @return The channel count.
     *  */
    
    
    //!
    //!
    //!
    public native @ByRef IntPointer c();

    /**
     *  \brief Get the channel count.
     * 
     *  @return The channel count.
     *  */

    /**
     *  \brief Get the height.
     * 
     *  @return The height.
     *  */
    
    
    //!
    //!
    //!
    public native @ByRef IntPointer h();

    /**
     *  \brief Get the height.
     * 
     *  @return The height.
     *  */

    /**
     *  \brief Get the width.
     * 
     *  @return The width.
     *  */
    
    
    //!
    //!
    //!
    public native @ByRef IntPointer w();

    /**
     *  \brief Get the width.
     * 
     *  @return The width.
     *  */
}
