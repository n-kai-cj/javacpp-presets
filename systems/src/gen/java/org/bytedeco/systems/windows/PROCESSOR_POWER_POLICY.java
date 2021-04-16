// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.systems.windows;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.windows.*;


// processor power policy
@Properties(inherit = org.bytedeco.systems.presets.windows.class)
public class PROCESSOR_POWER_POLICY extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public PROCESSOR_POWER_POLICY() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public PROCESSOR_POWER_POLICY(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public PROCESSOR_POWER_POLICY(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public PROCESSOR_POWER_POLICY position(long position) {
        return (PROCESSOR_POWER_POLICY)super.position(position);
    }
    @Override public PROCESSOR_POWER_POLICY getPointer(long i) {
        return new PROCESSOR_POWER_POLICY((Pointer)this).position(position + i);
    }

    public native @Cast("DWORD") int Revision(); public native PROCESSOR_POWER_POLICY Revision(int setter);       // 1

    // Dynamic Throttling Policy
    public native @Cast("BYTE") byte DynamicThrottle(); public native PROCESSOR_POWER_POLICY DynamicThrottle(byte setter);
    public native @Cast("BYTE") byte Spare(int i); public native PROCESSOR_POWER_POLICY Spare(int i, byte setter);
    @MemberGetter public native @Cast("BYTE*") BytePointer Spare();

    // Flags
    public native @Cast("DWORD") @NoOffset int DisableCStates(); public native PROCESSOR_POWER_POLICY DisableCStates(int setter);
    public native @Cast("DWORD") @NoOffset int Reserved(); public native PROCESSOR_POWER_POLICY Reserved(int setter);

    // System policy information
    // The Array is last, in case it needs to be grown and the structure
    // revision incremented.
    public native @Cast("DWORD") int PolicyCount(); public native PROCESSOR_POWER_POLICY PolicyCount(int setter);
    public native @ByRef PROCESSOR_POWER_POLICY_INFO Policy(int i); public native PROCESSOR_POWER_POLICY Policy(int i, PROCESSOR_POWER_POLICY_INFO setter);
    @MemberGetter public native PROCESSOR_POWER_POLICY_INFO Policy();

}
