// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.nvml;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.cuda.cudart.*;
import static org.bytedeco.cuda.global.cudart.*;

import static org.bytedeco.cuda.global.nvml.*;

/** \} */

/** 
 * Information about occurred event
 */
@Properties(inherit = org.bytedeco.cuda.presets.nvml.class)
public class nvmlEventData_t extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public nvmlEventData_t() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public nvmlEventData_t(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public nvmlEventData_t(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public nvmlEventData_t position(long position) {
        return (nvmlEventData_t)super.position(position);
    }
    @Override public nvmlEventData_t getPointer(long i) {
        return new nvmlEventData_t(this).position(position + i);
    }

    /** Specific device where the event occurred */
    public native nvmlDevice_st device(); public native nvmlEventData_t device(nvmlDevice_st setter);
    /** Information about what specific event occurred */
    public native @Cast("unsigned long long") long eventType(); public native nvmlEventData_t eventType(long setter);
    /** Stores XID error for the device in the event of nvmlEventTypeXidCriticalError, */
    public native @Cast("unsigned long long") long eventData(); public native nvmlEventData_t eventData(long setter);
                                            //   eventData is 0 for any other event. eventData is set as 999 for unknown xid error.
    /** If MIG is enabled and nvmlEventTypeXidCriticalError event is attributable to a GPU */
    public native @Cast("unsigned int") int gpuInstanceId(); public native nvmlEventData_t gpuInstanceId(int setter);
                                            //   instance, stores a valid GPU instance ID. gpuInstanceId is set to 0xFFFFFFFF
                                            //   otherwise.
    /** If MIG is enabled and nvmlEventTypeXidCriticalError event is attributable to a */
    public native @Cast("unsigned int") int computeInstanceId(); public native nvmlEventData_t computeInstanceId(int setter);
                                            //   compute instance, stores a valid compute instance ID. computeInstanceId is set to
                                            //   0xFFFFFFFF otherwise.
}
