// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.spinnaker.Spinnaker_C;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.spinnaker.global.Spinnaker_C.*;


/**	
* \defgroup TLSystemC_h TLSystem Structures
* \ingroup CQuickSpin
*/
/*@{*/

@Properties(inherit = org.bytedeco.spinnaker.presets.Spinnaker_C.class)
public class quickSpinTLSystem extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public quickSpinTLSystem() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public quickSpinTLSystem(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public quickSpinTLSystem(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public quickSpinTLSystem position(long position) {
        return (quickSpinTLSystem)super.position(position);
    }
    @Override public quickSpinTLSystem getPointer(long i) {
        return new quickSpinTLSystem((Pointer)this).position(position + i);
    }

	public native @Cast("quickSpinBooleanNode") spinNodeHandle EnumerateGEVInterfaces(); public native quickSpinTLSystem EnumerateGEVInterfaces(spinNodeHandle setter);
	public native @Cast("quickSpinCommandNode") spinNodeHandle AutoForceIP(); public native quickSpinTLSystem AutoForceIP(spinNodeHandle setter);
}
