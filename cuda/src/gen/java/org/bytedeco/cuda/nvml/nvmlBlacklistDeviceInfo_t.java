// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.nvml;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.cuda.cudart.*;
import static org.bytedeco.cuda.global.cudart.*;

import static org.bytedeco.cuda.global.nvml.*;

/** \} */

/***************************************************************************************************/
/** \defgroup nvmlGpuBlacklistQueries GPU Blacklist Queries
 * This chapter describes NVML operations that are associated with blacklisted GPUs.
 *  \{
 */
/***************************************************************************************************/

/**
 * Blacklist GPU device information
 **/
@Properties(inherit = org.bytedeco.cuda.presets.nvml.class)
public class nvmlBlacklistDeviceInfo_t extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public nvmlBlacklistDeviceInfo_t() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public nvmlBlacklistDeviceInfo_t(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public nvmlBlacklistDeviceInfo_t(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public nvmlBlacklistDeviceInfo_t position(long position) {
        return (nvmlBlacklistDeviceInfo_t)super.position(position);
    }
    @Override public nvmlBlacklistDeviceInfo_t getPointer(long i) {
        return new nvmlBlacklistDeviceInfo_t(this).position(position + i);
    }

    /** The PCI information for the blacklisted GPU */
    public native @ByRef nvmlPciInfo_t pciInfo(); public native nvmlBlacklistDeviceInfo_t pciInfo(nvmlPciInfo_t setter);
    /** The ASCII string UUID for the blacklisted GPU */
    public native @Cast("char") byte uuid(int i); public native nvmlBlacklistDeviceInfo_t uuid(int i, byte setter);
    @MemberGetter public native @Cast("char*") BytePointer uuid();
}
