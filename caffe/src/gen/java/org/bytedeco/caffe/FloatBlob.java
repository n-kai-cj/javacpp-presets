// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.caffe;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import org.bytedeco.opencv.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import org.bytedeco.opencv.opencv_videoio.*;
import static org.bytedeco.opencv.global.opencv_videoio.*;
import org.bytedeco.opencv.opencv_highgui.*;
import static org.bytedeco.opencv.global.opencv_highgui.*;
import org.bytedeco.hdf5.*;
import static org.bytedeco.hdf5.global.hdf5.*;

import static org.bytedeco.caffe.global.caffe.*;


/**
 * \brief A wrapper around SyncedMemory holders serving as the basic
 *        computational unit through which Layer%s, Net%s, and Solver%s
 *        interact.
 *
 * TODO(dox): more thorough description.
 */
@Name("caffe::Blob<float>") @NoOffset @Properties(inherit = org.bytedeco.caffe.presets.caffe.class)
public class FloatBlob extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FloatBlob(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public FloatBlob(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public FloatBlob position(long position) {
        return (FloatBlob)super.position(position);
    }

  public FloatBlob() { super((Pointer)null); allocate(); }
  private native void allocate();

  /** \brief Deprecated; use <code>Blob(const vector<int>& shape)</code>. */
  public FloatBlob(int num, int channels, int height,
        int width) { super((Pointer)null); allocate(num, channels, height, width); }
  private native void allocate(int num, int channels, int height,
        int width);
  public FloatBlob(@StdVector IntPointer shape) { super((Pointer)null); allocate(shape); }
  private native void allocate(@StdVector IntPointer shape);
  public FloatBlob(@StdVector IntBuffer shape) { super((Pointer)null); allocate(shape); }
  private native void allocate(@StdVector IntBuffer shape);
  public FloatBlob(@StdVector int[] shape) { super((Pointer)null); allocate(shape); }
  private native void allocate(@StdVector int[] shape);

  /** \brief Deprecated; use <code>Reshape(const vector<int>& shape)</code>. */
  public native void Reshape(int num, int channels, int height,
        int width);
  /**
   * \brief Change the dimensions of the blob, allocating new memory if
   *        necessary.
   *
   * This function can be called both to create an initial allocation
   * of memory, and to adjust the dimensions of a top blob during Layer::Reshape
   * or Layer::Forward. When changing the size of blob, memory will only be
   * reallocated if sufficient memory does not already exist, and excess memory
   * will never be freed.
   *
   * Note that reshaping an input blob and immediately calling Net::Backward is
   * an error; either Net::Forward or Net::Reshape need to be called to
   * propagate the new input shape to higher layers.
   */
  public native void Reshape(@StdVector IntPointer shape);
  public native void Reshape(@StdVector IntBuffer shape);
  public native void Reshape(@StdVector int[] shape);
  public native void Reshape(@Const @ByRef BlobShape shape);
  public native void ReshapeLike(@Const @ByRef FloatBlob other);
  public native @StdString BytePointer shape_string();
  public native @StdVector IntPointer shape();
  /**
   * \brief Returns the dimension of the index-th axis (or the negative index-th
   *        axis from the end, if index is negative).
   *
   * @param index the axis index, which may be negative as it will be
   *        "canonicalized" using CanonicalAxisIndex.
   *        Dies on out of range index.
   */
  public native int shape(int index);
  public native int num_axes();
  public native int count();

  /**
   * \brief Compute the volume of a slice; i.e., the product of dimensions
   *        among a range of axes.
   *
   * @param start_axis The first axis to include in the slice.
   *
   * @param end_axis The first axis to exclude from the slice.
   */
  public native int count(int start_axis, int end_axis);
  /**
   * \brief Compute the volume of a slice spanning from a particular first
   *        axis to the final axis.
   *
   * @param start_axis The first axis to include in the slice.
   */
  public native int count(int start_axis);

  /**
   * \brief Returns the 'canonical' version of a (usually) user-specified axis,
   *        allowing for negative indexing (e.g., -1 for the last axis).
   *
   * @param axis_index the axis index.
   *        If 0 <= index < num_axes(), return index.
   *        If -num_axes <= index <= -1, return (num_axes() - (-index)),
   *        e.g., the last axis index (num_axes() - 1) if index == -1,
   *        the second to last if index == -2, etc.
   *        Dies on out of range index.
   */
  public native int CanonicalAxisIndex(int axis_index);

  /** \brief Deprecated legacy shape accessor num: use shape(0) instead. */
  public native int num();
  /** \brief Deprecated legacy shape accessor channels: use shape(1) instead. */
  public native int channels();
  /** \brief Deprecated legacy shape accessor height: use shape(2) instead. */
  public native int height();
  /** \brief Deprecated legacy shape accessor width: use shape(3) instead. */
  public native int width();
  public native int LegacyShape(int index);

  public native int offset(int n, int c/*=0*/, int h/*=0*/,
        int w/*=0*/);
  public native int offset(int n);

  public native int offset(@StdVector IntPointer indices);
  public native int offset(@StdVector IntBuffer indices);
  public native int offset(@StdVector int[] indices);
  /**
   * \brief Copy from a source Blob.
   *
   * @param source the Blob to copy from
   * @param copy_diff if false, copy the data; if true, copy the diff
   * @param reshape if false, require this Blob to be pre-shaped to the shape
   *        of other (and die otherwise); if true, Reshape this Blob to other's
   *        shape if necessary
   */
  public native void CopyFrom(@Const @ByRef FloatBlob source, @Cast("bool") boolean copy_diff/*=false*/,
        @Cast("bool") boolean reshape/*=false*/);
  public native void CopyFrom(@Const @ByRef FloatBlob source);

  public native float data_at(int n, int c, int h,
        int w);

  public native float diff_at(int n, int c, int h,
        int w);

  public native float data_at(@StdVector IntPointer index);
  public native float data_at(@StdVector IntBuffer index);
  public native float data_at(@StdVector int[] index);

  public native float diff_at(@StdVector IntPointer index);
  public native float diff_at(@StdVector IntBuffer index);
  public native float diff_at(@StdVector int[] index);

  public native @SharedPtr SyncedMemory data();

  public native @SharedPtr SyncedMemory diff();

  public native @Const FloatPointer cpu_data();
  public native void set_cpu_data(FloatPointer data);
  public native void set_cpu_data(FloatBuffer data);
  public native void set_cpu_data(float[] data);
  public native @Const IntPointer gpu_shape();
  public native @Const FloatPointer gpu_data();
  public native void set_gpu_data(FloatPointer data);
  public native void set_gpu_data(FloatBuffer data);
  public native void set_gpu_data(float[] data);
  public native @Const FloatPointer cpu_diff();
  public native @Const FloatPointer gpu_diff();
  public native FloatPointer mutable_cpu_data();
  public native FloatPointer mutable_gpu_data();
  public native FloatPointer mutable_cpu_diff();
  public native FloatPointer mutable_gpu_diff();
  public native void Update();
  public native void FromProto(@Const @ByRef BlobProto proto, @Cast("bool") boolean reshape/*=true*/);
  public native void FromProto(@Const @ByRef BlobProto proto);
  public native void ToProto(BlobProto proto, @Cast("bool") boolean write_diff/*=false*/);
  public native void ToProto(BlobProto proto);

  /** \brief Compute the sum of absolute values (L1 norm) of the data. */
  public native float asum_data();
  /** \brief Compute the sum of absolute values (L1 norm) of the diff. */
  public native float asum_diff();
  /** \brief Compute the sum of squares (L2 norm squared) of the data. */
  public native float sumsq_data();
  /** \brief Compute the sum of squares (L2 norm squared) of the diff. */
  public native float sumsq_diff();

  /** \brief Scale the blob data by a constant factor. */
  public native void scale_data(float scale_factor);
  /** \brief Scale the blob diff by a constant factor. */
  public native void scale_diff(float scale_factor);

  /**
   * \brief Set the data_ shared_ptr to point to the SyncedMemory holding the
   *        data_ of Blob other -- useful in Layer%s which simply perform a copy
   *        in their Forward pass.
   *
   * This deallocates the SyncedMemory holding this Blob's data_, as
   * shared_ptr calls its destructor when reset with the "=" operator.
   */
  public native void ShareData(@Const @ByRef FloatBlob other);
  /**
   * \brief Set the diff_ shared_ptr to point to the SyncedMemory holding the
   *        diff_ of Blob other -- useful in Layer%s which simply perform a copy
   *        in their Forward pass.
   *
   * This deallocates the SyncedMemory holding this Blob's diff_, as
   * shared_ptr calls its destructor when reset with the "=" operator.
   */
  public native void ShareDiff(@Const @ByRef FloatBlob other);

  public native @Cast("bool") boolean ShapeEquals(@Const @ByRef BlobProto other);
}
