// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Generate a single randomly distorted bounding box for an image.
 * 
 *  Bounding box annotations are often supplied in addition to ground-truth labels
 *  in image recognition or object localization tasks. A common technique for
 *  training such a system is to randomly distort an image while preserving
 *  its content, i.e. *data augmentation*. This Op outputs a randomly distorted
 *  localization of an object, i.e. bounding box, given an {@code image_size},
 *  {@code bounding_boxes} and a series of constraints.
 * 
 *  The output of this Op is a single bounding box that may be used to crop the
 *  original image. The output is returned as 3 tensors: {@code begin}, {@code size} and
 *  {@code bboxes}. The first 2 tensors can be fed directly into {@code tf.slice} to crop the
 *  image. The latter may be supplied to {@code tf.image.draw_bounding_boxes} to visualize
 *  what the bounding box looks like.
 * 
 *  Bounding boxes are supplied and returned as {@code [y_min, x_min, y_max, x_max]}. The
 *  bounding box coordinates are floats in {@code [0.0, 1.0]} relative to the width and
 *  height of the underlying image.
 * 
 *  For example,
 * 
 *  <pre>{@code python
 *      # Generate a single distorted bounding box.
 *      begin, size, bbox_for_draw = tf.image.sample_distorted_bounding_box(
 *          tf.shape(image),
 *          bounding_boxes=bounding_boxes)
 * 
 *      # Draw the bounding box in an image summary.
 *      image_with_box = tf.image.draw_bounding_boxes(tf.expand_dims(image, 0),
 *                                                    bbox_for_draw)
 *      tf.summary.image('images_with_box', image_with_box)
 * 
 *      # Employ the bounding box to distort the image.
 *      distorted_image = tf.slice(image, begin, size)
 *  }</pre>
 * 
 *  Note that if no bounding box information is available, setting
 *  {@code use_image_if_no_bounding_boxes = true} will assume there is a single implicit
 *  bounding box covering the whole image. If {@code use_image_if_no_bounding_boxes} is
 *  false and no bounding boxes are supplied, an error is raised.
 * 
 *  Arguments:
 *  * scope: A Scope object
 *  * image_size: 1-D, containing {@code [height, width, channels]}.
 *  * bounding_boxes: 3-D with shape {@code [batch, N, 4]} describing the N bounding boxes
 *  associated with the image.
 *  * min_object_covered: The cropped area of the image must contain at least this
 *  fraction of any bounding box supplied. The value of this parameter should be
 *  non-negative. In the case of 0, the cropped area does not need to overlap
 *  any of the bounding boxes supplied.
 * 
 *  Optional attributes (see {@code Attrs}):
 *  * seed: If either {@code seed} or {@code seed2} are set to non-zero, the random number
 *  generator is seeded by the given {@code seed}.  Otherwise, it is seeded by a random
 *  seed.
 *  * seed2: A second seed to avoid seed collision.
 *  * aspect_ratio_range: The cropped area of the image must have an aspect ratio =
 *  width / height within this range.
 *  * area_range: The cropped area of the image must contain a fraction of the
 *  supplied image within this range.
 *  * max_attempts: Number of attempts at generating a cropped region of the image
 *  of the specified constraints. After {@code max_attempts} failures, return the entire
 *  image.
 *  * use_image_if_no_bounding_boxes: Controls behavior if no bounding boxes supplied.
 *  If true, assume an implicit bounding box covering the whole input. If false,
 *  raise an error.
 * 
 *  Returns:
 *  * {@code Output} begin: 1-D, containing {@code [offset_height, offset_width, 0]}. Provide as input to
 *  {@code tf.slice}.
 *  * {@code Output} size: 1-D, containing {@code [target_height, target_width, -1]}. Provide as input to
 *  {@code tf.slice}.
 *  * {@code Output} bboxes: 3-D with shape {@code [1, 1, 4]} containing the distorted bounding box.
 *  Provide as input to {@code tf.image.draw_bounding_boxes}. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class SampleDistortedBoundingBoxV2 extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SampleDistortedBoundingBoxV2(Pointer p) { super(p); }

  /** Optional attribute setters for SampleDistortedBoundingBoxV2 */
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
  
    /** If either {@code seed} or {@code seed2} are set to non-zero, the random number
     *  generator is seeded by the given {@code seed}.  Otherwise, it is seeded by a random
     *  seed.
     * 
     *  Defaults to 0 */
    
    ///
    public native @ByVal Attrs Seed(@Cast("tensorflow::int64") long x);

    /** A second seed to avoid seed collision.
     * 
     *  Defaults to 0 */
    
    ///
    public native @ByVal Attrs Seed2(@Cast("tensorflow::int64") long x);

    /** The cropped area of the image must have an aspect ratio =
     *  width / height within this range.
     * 
     *  Defaults to [0.75, 1.33] */
    
    ///
    public native @ByVal Attrs AspectRatioRange(@ArraySlice FloatPointer x);
    public native @ByVal Attrs AspectRatioRange(@ArraySlice FloatBuffer x);
    public native @ByVal Attrs AspectRatioRange(@ArraySlice float... x);

    /** The cropped area of the image must contain a fraction of the
     *  supplied image within this range.
     * 
     *  Defaults to [0.05, 1] */
    
    ///
    public native @ByVal Attrs AreaRange(@ArraySlice FloatPointer x);
    public native @ByVal Attrs AreaRange(@ArraySlice FloatBuffer x);
    public native @ByVal Attrs AreaRange(@ArraySlice float... x);

    /** Number of attempts at generating a cropped region of the image
     *  of the specified constraints. After {@code max_attempts} failures, return the entire
     *  image.
     * 
     *  Defaults to 100 */
    
    ///
    public native @ByVal Attrs MaxAttempts(@Cast("tensorflow::int64") long x);

    /** Controls behavior if no bounding boxes supplied.
     *  If true, assume an implicit bounding box covering the whole input. If false,
     *  raise an error.
     * 
     *  Defaults to false */
    public native @ByVal Attrs UseImageIfNoBoundingBoxes(@Cast("bool") boolean x);

    public native @Cast("tensorflow::int64") long seed_(); public native Attrs seed_(long setter);
    public native @Cast("tensorflow::int64") long seed2_(); public native Attrs seed2_(long setter);
    public native @ArraySlice FloatPointer aspect_ratio_range_(); public native Attrs aspect_ratio_range_(FloatPointer setter);
    public native @ArraySlice FloatPointer area_range_(); public native Attrs area_range_(FloatPointer setter);
    public native @Cast("tensorflow::int64") long max_attempts_(); public native Attrs max_attempts_(long setter);
    public native @Cast("bool") boolean use_image_if_no_bounding_boxes_(); public native Attrs use_image_if_no_bounding_boxes_(boolean setter);
  }
  public SampleDistortedBoundingBoxV2(@Const @ByRef Scope scope,
                               @ByVal Input image_size,
                               @ByVal Input bounding_boxes,
                               @ByVal Input min_object_covered) { super((Pointer)null); allocate(scope, image_size, bounding_boxes, min_object_covered); }
  private native void allocate(@Const @ByRef Scope scope,
                               @ByVal Input image_size,
                               @ByVal Input bounding_boxes,
                               @ByVal Input min_object_covered);
  public SampleDistortedBoundingBoxV2(@Const @ByRef Scope scope,
                               @ByVal Input image_size,
                               @ByVal Input bounding_boxes,
                               @ByVal Input min_object_covered, @Const @ByRef Attrs attrs) { super((Pointer)null); allocate(scope, image_size, bounding_boxes, min_object_covered, attrs); }
  private native void allocate(@Const @ByRef Scope scope,
                               @ByVal Input image_size,
                               @ByVal Input bounding_boxes,
                               @ByVal Input min_object_covered, @Const @ByRef Attrs attrs);

  public static native @ByVal Attrs Seed(@Cast("tensorflow::int64") long x);
  public static native @ByVal Attrs Seed2(@Cast("tensorflow::int64") long x);
  public static native @ByVal Attrs AspectRatioRange(@ArraySlice FloatPointer x);
  public static native @ByVal Attrs AspectRatioRange(@ArraySlice FloatBuffer x);
  public static native @ByVal Attrs AspectRatioRange(@ArraySlice float... x);
  public static native @ByVal Attrs AreaRange(@ArraySlice FloatPointer x);
  public static native @ByVal Attrs AreaRange(@ArraySlice FloatBuffer x);
  public static native @ByVal Attrs AreaRange(@ArraySlice float... x);
  public static native @ByVal Attrs MaxAttempts(@Cast("tensorflow::int64") long x);
  public static native @ByVal Attrs UseImageIfNoBoundingBoxes(@Cast("bool") boolean x);

  public native @ByRef Operation operation(); public native SampleDistortedBoundingBoxV2 operation(Operation setter);
  public native @ByRef Output begin(); public native SampleDistortedBoundingBoxV2 begin(Output setter);
  public native @ByRef Output size(); public native SampleDistortedBoundingBoxV2 size(Output setter);
  public native @ByRef Output bboxes(); public native SampleDistortedBoundingBoxV2 bboxes(Output setter);
}
