// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Outputs random values from a normal distribution. The parameters may each be a
 * 
 *  scalar which applies to the entire output, or a vector of length shape[0] which
 *  stores the parameters for each batch.
 * 
 *  Arguments:
 *  * scope: A Scope object
 *  * shape: The shape of the output tensor. Batches are indexed by the 0th dimension.
 *  * means: The mean parameter of each batch.
 *  * stdevs: The standard deviation parameter of each batch. Must be greater than 0.
 *  * minvals: The minimum cutoff. May be -infinity.
 *  * maxvals: The maximum cutoff. May be +infinity, and must be more than the minval
 *  for each batch.
 * 
 *  Optional attributes (see {@code Attrs}):
 *  * seed: If either {@code seed} or {@code seed2} are set to be non-zero, the random number
 *  generator is seeded by the given seed.  Otherwise, it is seeded by a
 *  random seed.
 *  * seed2: A second seed to avoid seed collision.
 * 
 *  Returns:
 *  * {@code Output}: A matrix of shape num_batches x samples_per_batch, filled with random
 *  truncated normal values using the parameters for each row. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class ParameterizedTruncatedNormal extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ParameterizedTruncatedNormal(Pointer p) { super(p); }

  /** Optional attribute setters for ParameterizedTruncatedNormal */
  public static class Attrs extends Pointer {
      static { Loader.load(); }
      /** Default native constructor. */
      public Attrs() { super((Pointer)null); allocate(); }
      /** Native array allocator. Access with {@link Pointer#position(long)}. */
      public Attrs(long size) { super((Pointer)null); allocateArray(size); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public Attrs(Pointer p) { super(p); }
      private native void allocate();
      private native void allocateArray(long size);
      @Override public Attrs position(long position) {
          return (Attrs)super.position(position);
      }
      @Override public Attrs getPointer(long i) {
          return new Attrs(this).position(position + i);
      }
  
    /** If either {@code seed} or {@code seed2} are set to be non-zero, the random number
     *  generator is seeded by the given seed.  Otherwise, it is seeded by a
     *  random seed.
     * 
     *  Defaults to 0 */
    
    ///
    public native @ByVal Attrs Seed(@Cast("tensorflow::int64") long x);

    /** A second seed to avoid seed collision.
     * 
     *  Defaults to 0 */
    public native @ByVal Attrs Seed2(@Cast("tensorflow::int64") long x);

    public native @Cast("tensorflow::int64") long seed_(); public native Attrs seed_(long setter);
    public native @Cast("tensorflow::int64") long seed2_(); public native Attrs seed2_(long setter);
  }
  public ParameterizedTruncatedNormal(@Const @ByRef Scope scope,
                               @ByVal Input shape, @ByVal Input means, @ByVal Input stdevs,
                               @ByVal Input minvals, @ByVal Input maxvals) { super((Pointer)null); allocate(scope, shape, means, stdevs, minvals, maxvals); }
  private native void allocate(@Const @ByRef Scope scope,
                               @ByVal Input shape, @ByVal Input means, @ByVal Input stdevs,
                               @ByVal Input minvals, @ByVal Input maxvals);
  public ParameterizedTruncatedNormal(@Const @ByRef Scope scope,
                               @ByVal Input shape, @ByVal Input means, @ByVal Input stdevs,
                               @ByVal Input minvals, @ByVal Input maxvals, @Const @ByRef Attrs attrs) { super((Pointer)null); allocate(scope, shape, means, stdevs, minvals, maxvals, attrs); }
  private native void allocate(@Const @ByRef Scope scope,
                               @ByVal Input shape, @ByVal Input means, @ByVal Input stdevs,
                               @ByVal Input minvals, @ByVal Input maxvals, @Const @ByRef Attrs attrs);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public static native @ByVal Attrs Seed(@Cast("tensorflow::int64") long x);
  public static native @ByVal Attrs Seed2(@Cast("tensorflow::int64") long x);

  public native @ByRef Operation operation(); public native ParameterizedTruncatedNormal operation(Operation setter);
  public native @ByRef Output output(); public native ParameterizedTruncatedNormal output(Output setter);
}
