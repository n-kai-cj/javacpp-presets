// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_tracking;

import org.bytedeco.javacpp.annotation.Index;
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
import org.bytedeco.opencv.opencv_plot.*;
import static org.bytedeco.opencv.global.opencv_plot.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import org.bytedeco.opencv.opencv_videoio.*;
import static org.bytedeco.opencv.global.opencv_videoio.*;
import org.bytedeco.opencv.opencv_highgui.*;
import static org.bytedeco.opencv.global.opencv_highgui.*;
import org.bytedeco.opencv.opencv_flann.*;
import static org.bytedeco.opencv.global.opencv_flann.*;
import org.bytedeco.opencv.opencv_features2d.*;
import static org.bytedeco.opencv.global.opencv_features2d.*;
import org.bytedeco.opencv.opencv_calib3d.*;
import static org.bytedeco.opencv.global.opencv_calib3d.*;
import org.bytedeco.opencv.opencv_video.*;
import static org.bytedeco.opencv.global.opencv_video.*;
import org.bytedeco.opencv.opencv_dnn.*;
import static org.bytedeco.opencv.global.opencv_dnn.*;

import static org.bytedeco.opencv.global.opencv_tracking.*;


/************************************ Specific TrackerSamplerAlgorithm Classes ************************************/

/** \brief TrackerSampler based on CSC (current state centered), used by MIL algorithm TrackerMIL
 */
@Namespace("cv") @NoOffset @Properties(inherit = org.bytedeco.opencv.presets.opencv_tracking.class)
public class TrackerSamplerCSC extends TrackerSamplerAlgorithm {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TrackerSamplerCSC(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public TrackerSamplerCSC(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public TrackerSamplerCSC position(long position) {
        return (TrackerSamplerCSC)super.position(position);
    }

  /** enum cv::TrackerSamplerCSC:: */
  public static final int
    /** mode for init positive samples */
    MODE_INIT_POS = 1,
    /** mode for init negative samples */
    MODE_INIT_NEG = 2,
    /** mode for update positive samples */
    MODE_TRACK_POS = 3,
    /** mode for update negative samples */
    MODE_TRACK_NEG = 4,
    /** mode for detect samples */
    MODE_DETECT = 5;

  @NoOffset public static class Params extends Pointer {
      static { Loader.load(); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public Params(Pointer p) { super(p); }
      /** Native array allocator. Access with {@link Pointer#position(long)}. */
      public Params(long size) { super((Pointer)null); allocateArray(size); }
      private native void allocateArray(long size);
      @Override public Params position(long position) {
          return (Params)super.position(position);
      }
  
    public Params() { super((Pointer)null); allocate(); }
    private native void allocate();
    /** radius for gathering positive instances during init */
    public native float initInRad(); public native Params initInRad(float setter);
    /** radius for gathering positive instances during tracking */
    public native float trackInPosRad(); public native Params trackInPosRad(float setter);
    /** size of search window */
    public native float searchWinSize(); public native Params searchWinSize(float setter);
    /** # negative samples to use during init */
    public native int initMaxNegNum(); public native Params initMaxNegNum(int setter);
    /** # positive samples to use during training */
    public native int trackMaxPosNum(); public native Params trackMaxPosNum(int setter);
    /** # negative samples to use during training */
    public native int trackMaxNegNum(); public native Params trackMaxNegNum(int setter);
  }

  /** \brief Constructor
    @param parameters TrackerSamplerCSC parameters TrackerSamplerCSC::Params
     */
  public TrackerSamplerCSC( @Const @ByRef(nullValue = "cv::TrackerSamplerCSC::Params()") Params parameters ) { super((Pointer)null); allocate(parameters); }
  private native void allocate( @Const @ByRef(nullValue = "cv::TrackerSamplerCSC::Params()") Params parameters );
  public TrackerSamplerCSC( ) { super((Pointer)null); allocate(); }
  private native void allocate( );

  /** \brief Set the sampling mode of TrackerSamplerCSC
    @param samplingMode The sampling mode
    <p>
    The modes are:
    <p>
    -   "MODE_INIT_POS = 1" -- for the positive sampling in initialization step
    -   "MODE_INIT_NEG = 2" -- for the negative sampling in initialization step
    -   "MODE_TRACK_POS = 3" -- for the positive sampling in update step
    -   "MODE_TRACK_NEG = 4" -- for the negative sampling in update step
    -   "MODE_DETECT = 5" -- for the sampling in detection step
     */
  public native void setMode( int samplingMode );
}
