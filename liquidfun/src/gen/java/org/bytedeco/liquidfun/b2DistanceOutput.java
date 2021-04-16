// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.liquidfun;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.liquidfun.global.liquidfun.*;


/** Output for b2Distance. */
@Properties(inherit = org.bytedeco.liquidfun.presets.liquidfun.class)
public class b2DistanceOutput extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public b2DistanceOutput() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public b2DistanceOutput(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public b2DistanceOutput(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public b2DistanceOutput position(long position) {
        return (b2DistanceOutput)super.position(position);
    }
    @Override public b2DistanceOutput getPointer(long i) {
        return new b2DistanceOutput((Pointer)this).position(position + i);
    }

	/** closest point on shapeA */
	public native @ByRef b2Vec2 pointA(); public native b2DistanceOutput pointA(b2Vec2 setter);
	/** closest point on shapeB */
	public native @ByRef b2Vec2 pointB(); public native b2DistanceOutput pointB(b2Vec2 setter);
	public native @Cast("float32") float distance(); public native b2DistanceOutput distance(float setter);
	/** number of GJK iterations used */
	public native @Cast("int32") int iterations(); public native b2DistanceOutput iterations(int setter);
}
