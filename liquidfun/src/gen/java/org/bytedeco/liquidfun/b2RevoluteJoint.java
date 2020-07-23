// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.liquidfun;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.liquidfun.global.liquidfun.*;


/** A revolute joint constrains two bodies to share a common point while they
 *  are free to rotate about the point. The relative rotation about the shared
 *  point is the joint angle. You can limit the relative rotation with
 *  a joint limit that specifies a lower and upper angle. You can use a motor
 *  to drive the relative rotation about the shared point. A maximum motor torque
 *  is provided so that infinite forces are not generated. */
@NoOffset @Properties(inherit = org.bytedeco.liquidfun.presets.liquidfun.class)
public class b2RevoluteJoint extends b2Joint {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public b2RevoluteJoint(Pointer p) { super(p); }

	public native @ByVal b2Vec2 GetAnchorA();
	public native @ByVal b2Vec2 GetAnchorB();

	/** The local anchor point relative to bodyA's origin. */
	public native @Const @ByRef b2Vec2 GetLocalAnchorA();

	/** The local anchor point relative to bodyB's origin. */
	public native @Const @ByRef b2Vec2 GetLocalAnchorB();

	/** Get the reference angle. */
	public native @Cast("float32") float GetReferenceAngle();

	/** Get the current joint angle in radians. */
	public native @Cast("float32") float GetJointAngle();

	/** Get the current joint angle speed in radians per second. */
	public native @Cast("float32") float GetJointSpeed();

	/** Is the joint limit enabled? */
	public native @Cast("bool") boolean IsLimitEnabled();

	/** Enable/disable the joint limit. */
	public native void EnableLimit(@Cast("bool") boolean flag);

	/** Get the lower joint limit in radians. */
	public native @Cast("float32") float GetLowerLimit();

	/** Get the upper joint limit in radians. */
	public native @Cast("float32") float GetUpperLimit();

	/** Set the joint limits in radians. */
	public native void SetLimits(@Cast("float32") float lower, @Cast("float32") float upper);

	/** Is the joint motor enabled? */
	public native @Cast("bool") boolean IsMotorEnabled();

	/** Enable/disable the joint motor. */
	public native void EnableMotor(@Cast("bool") boolean flag);

	/** Set the motor speed in radians per second. */
	public native void SetMotorSpeed(@Cast("float32") float speed);

	/** Get the motor speed in radians per second. */
	public native @Cast("float32") float GetMotorSpeed();

	/** Set the maximum motor torque, usually in N-m. */
	public native void SetMaxMotorTorque(@Cast("float32") float torque);
	public native @Cast("float32") float GetMaxMotorTorque();

	/** Get the reaction force given the inverse time step.
	 *  Unit is N. */
	public native @ByVal b2Vec2 GetReactionForce(@Cast("float32") float inv_dt);

	/** Get the reaction torque due to the joint limit given the inverse time step.
	 *  Unit is N*m. */
	public native @Cast("float32") float GetReactionTorque(@Cast("float32") float inv_dt);

	/** Get the current motor torque given the inverse time step.
	 *  Unit is N*m. */
	public native @Cast("float32") float GetMotorTorque(@Cast("float32") float inv_dt);

	/** Dump to b2Log. */
	public native void Dump();
}
