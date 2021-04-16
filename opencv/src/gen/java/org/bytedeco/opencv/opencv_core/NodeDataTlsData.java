// Targeted by JavaCPP version 1.5.6-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_core;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;

import static org.bytedeco.opencv.global.opencv_core.*;



/** \brief Simple TLS data class
 *
 * @see TLSDataAccumulator
 */
@Name("cv::TLSData<cv::instr::NodeDataTls>") @Properties(inherit = org.bytedeco.opencv.presets.opencv_core.class)
public class NodeDataTlsData extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public NodeDataTlsData(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public NodeDataTlsData(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public NodeDataTlsData position(long position) {
        return (NodeDataTlsData)super.position(position);
    }
    @Override public NodeDataTlsData getPointer(long i) {
        return new NodeDataTlsData((Pointer)this).position(position + i);
    }

    public NodeDataTlsData() { super((Pointer)null); allocate(); }
    private native void allocate();

    /** Get data associated with key */
    public native NodeDataTls get();
    /** Get data associated with key */
    public native @ByRef NodeDataTls getRef();

    /** Release associated thread data */
    public native void cleanup();
}
