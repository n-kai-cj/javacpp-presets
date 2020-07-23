// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.liquidfun;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.liquidfun.global.liquidfun.*;


/** Distance joint definition. This requires defining an
 *  anchor point on both bodies and the non-zero length of the
 *  distance joint. The definition uses local anchor points
 *  so that the initial configuration can violate the constraint
 *  slightly. This helps when saving and loading a game.
 *  \warning Do not use a zero or short length. */
@NoOffset @Properties(inherit = org.bytedeco.liquidfun.presets.liquidfun.class)
public class b2DistanceJointDef extends b2JointDef {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public b2DistanceJointDef(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public b2DistanceJointDef(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public b2DistanceJointDef position(long position) {
        return (b2DistanceJointDef)super.position(position);
    }

	public b2DistanceJointDef() { super((Pointer)null); allocate(); }
	private native void allocate();

	/** Initialize the bodies, anchors, and length using the world
	 *  anchors. */
	public native void Initialize(b2Body bodyA, b2Body bodyB,
						@Const @ByRef b2Vec2 anchorA, @Const @ByRef b2Vec2 anchorB);

	/** The local anchor point relative to bodyA's origin. */
	public native @ByRef b2Vec2 localAnchorA(); public native b2DistanceJointDef localAnchorA(b2Vec2 setter);

	/** The local anchor point relative to bodyB's origin. */
	public native @ByRef b2Vec2 localAnchorB(); public native b2DistanceJointDef localAnchorB(b2Vec2 setter);

	/** The natural length between the anchor points. */
	public native @Cast("float32") float length(); public native b2DistanceJointDef length(float setter);

	/** The mass-spring-damper frequency in Hertz. A value of 0
	 *  disables softness. */
	public native @Cast("float32") float frequencyHz(); public native b2DistanceJointDef frequencyHz(float setter);

	/** The damping ratio. 0 = no damping, 1 = critical damping. */
	public native @Cast("float32") float dampingRatio(); public native b2DistanceJointDef dampingRatio(float setter);
}
