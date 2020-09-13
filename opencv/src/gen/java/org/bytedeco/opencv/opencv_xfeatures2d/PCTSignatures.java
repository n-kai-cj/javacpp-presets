// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_xfeatures2d;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import org.bytedeco.opencv.opencv_ml.*;
import static org.bytedeco.opencv.global.opencv_ml.*;
import org.bytedeco.opencv.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
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
import org.bytedeco.opencv.opencv_shape.*;
import static org.bytedeco.opencv.global.opencv_shape.*;

import static org.bytedeco.opencv.global.opencv_xfeatures2d.*;



/*
* Position-Color-Texture signatures
*/

/**
* \brief Class implementing PCT (position-color-texture) signature extraction
*       as described in \cite KrulisLS16.
*       The algorithm is divided to a feature sampler and a clusterizer.
*       Feature sampler produces samples at given set of coordinates.
*       Clusterizer then produces clusters of these samples using k-means algorithm.
*       Resulting set of clusters is the signature of the input image.
*
*       A signature is an array of SIGNATURE_DIMENSION-dimensional points.
*       Used dimensions are:
*       weight, x, y position; lab color, contrast, entropy.
* \cite KrulisLS16
* \cite BeecksUS10
*/
@Namespace("cv::xfeatures2d") @Properties(inherit = org.bytedeco.opencv.presets.opencv_xfeatures2d.class)
public class PCTSignatures extends Algorithm {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public PCTSignatures(Pointer p) { super(p); }

    /**
    * \brief Lp distance function selector.
    */
    /** enum cv::xfeatures2d::PCTSignatures::DistanceFunction */
    public static final int
        L0_25 = 0, L0_5 = 1, L1 = 2, L2 = 3, L2SQUARED = 4, L5 = 5, L_INFINITY = 6;

    /**
    * \brief Point distributions supported by random point generator.
    */
    /** enum cv::xfeatures2d::PCTSignatures::PointDistribution */
    public static final int
        /** Generate numbers uniformly. */
        UNIFORM = 0,
        /** Generate points in a regular grid. */
        REGULAR = 1,
        /** Generate points with normal (gaussian) distribution. */
        NORMAL = 2;

    /**
    * \brief Similarity function selector.
    * @see
    *       Christian Beecks, Merih Seran Uysal, Thomas Seidl.
    *       Signature quadratic form distance.
    *       In Proceedings of the ACM International Conference on Image and Video Retrieval, pages 438-445.
    *       ACM, 2010.
    * \cite BeecksUS10
    * \note For selected distance function: <pre>{@code \[ d(c_i, c_j) \]}</pre>  and parameter: <pre>{@code \[ \alpha \]}</pre>
    */
    /** enum cv::xfeatures2d::PCTSignatures::SimilarityFunction */
    public static final int
        /** <pre>{@code \[ -d(c_i, c_j) \]}</pre> */
        MINUS = 0,
        /** <pre>{@code \[ e^{ -\alpha * d^2(c_i, c_j)} \]}</pre> */
        GAUSSIAN = 1,
        /** <pre>{@code \[ \frac{1}{\alpha + d(c_i, c_j)} \]}</pre> */
        HEURISTIC = 2;


    /**
    * \brief Creates PCTSignatures algorithm using sample and seed count.
    *       It generates its own sets of sampling points and clusterization seed indexes.
    * @param initSampleCount Number of points used for image sampling.
    * @param initSeedCount Number of initial clusterization seeds.
    *       Must be lower or equal to initSampleCount
    * @param pointDistribution Distribution of generated points. Default: UNIFORM.
    *       Available: UNIFORM, REGULAR, NORMAL.
    * @return Created algorithm.
    */
    public static native @Ptr PCTSignatures create(
            int initSampleCount/*=2000*/,
            int initSeedCount/*=400*/,
            int pointDistribution/*=0*/);
    public static native @Ptr PCTSignatures create();

    /**
    * \brief Creates PCTSignatures algorithm using pre-generated sampling points
    *       and number of clusterization seeds. It uses the provided
    *       sampling points and generates its own clusterization seed indexes.
    * @param initSamplingPoints Sampling points used in image sampling.
    * @param initSeedCount Number of initial clusterization seeds.
    *       Must be lower or equal to initSamplingPoints.size().
    * @return Created algorithm.
    */
    public static native @Ptr PCTSignatures create(
            @Const @ByRef Point2fVector initSamplingPoints,
            int initSeedCount);

    /**
    * \brief Creates PCTSignatures algorithm using pre-generated sampling points
    *       and clusterization seeds indexes.
    * @param initSamplingPoints Sampling points used in image sampling.
    * @param initClusterSeedIndexes Indexes of initial clusterization seeds.
    *       Its size must be lower or equal to initSamplingPoints.size().
    * @return Created algorithm.
    */
    public static native @Ptr PCTSignatures create(
            @Const @ByRef Point2fVector initSamplingPoints,
            @StdVector IntPointer initClusterSeedIndexes);
    public static native @Ptr PCTSignatures create(
            @Const @ByRef Point2fVector initSamplingPoints,
            @StdVector IntBuffer initClusterSeedIndexes);
    public static native @Ptr PCTSignatures create(
            @Const @ByRef Point2fVector initSamplingPoints,
            @StdVector int[] initClusterSeedIndexes);



    /**
    * \brief Computes signature of given image.
    * @param image Input image of CV_8U type.
    * @param signature Output computed signature.
    */
    public native void computeSignature(
            @ByVal Mat image,
            @ByVal Mat signature);
    public native void computeSignature(
            @ByVal UMat image,
            @ByVal UMat signature);
    public native void computeSignature(
            @ByVal GpuMat image,
            @ByVal GpuMat signature);

    /**
    * \brief Computes signatures for multiple images in parallel.
    * @param images Vector of input images of CV_8U type.
    * @param signatures Vector of computed signatures.
    */
    public native void computeSignatures(
            @Const @ByRef MatVector images,
            @ByRef MatVector signatures);

    /**
    * \brief Draws signature in the source image and outputs the result.
    *       Signatures are visualized as a circle
    *       with radius based on signature weight
    *       and color based on signature color.
    *       Contrast and entropy are not visualized.
    * @param source Source image.
    * @param signature Image signature.
    * @param result Output result.
    * @param radiusToShorterSideRatio Determines maximal radius of signature in the output image.
    * @param borderThickness Border thickness of the visualized signature.
    */
    public static native void drawSignature(
            @ByVal Mat source,
            @ByVal Mat signature,
            @ByVal Mat result,
            float radiusToShorterSideRatio/*=1.0 / 8*/,
            int borderThickness/*=1*/);
    public static native void drawSignature(
            @ByVal Mat source,
            @ByVal Mat signature,
            @ByVal Mat result);
    public static native void drawSignature(
            @ByVal UMat source,
            @ByVal UMat signature,
            @ByVal UMat result,
            float radiusToShorterSideRatio/*=1.0 / 8*/,
            int borderThickness/*=1*/);
    public static native void drawSignature(
            @ByVal UMat source,
            @ByVal UMat signature,
            @ByVal UMat result);
    public static native void drawSignature(
            @ByVal GpuMat source,
            @ByVal GpuMat signature,
            @ByVal GpuMat result,
            float radiusToShorterSideRatio/*=1.0 / 8*/,
            int borderThickness/*=1*/);
    public static native void drawSignature(
            @ByVal GpuMat source,
            @ByVal GpuMat signature,
            @ByVal GpuMat result);

    /**
    * \brief Generates initial sampling points according to selected point distribution.
    * @param initPoints Output vector where the generated points will be saved.
    * @param count Number of points to generate.
    * @param pointDistribution Point distribution selector.
    *       Available: UNIFORM, REGULAR, NORMAL.
    * \note Generated coordinates are in range [0..1)
    */
    public static native void generateInitPoints(
            @ByRef Point2fVector initPoints,
            int count,
            int pointDistribution);


    /**** sampler ****/

    /**
    * \brief Number of initial samples taken from the image.
    */
    public native int getSampleCount();

    /**
    * \brief Color resolution of the greyscale bitmap represented in allocated bits
    *       (i.e., value 4 means that 16 shades of grey are used).
    *       The greyscale bitmap is used for computing contrast and entropy values.
    */
    public native int getGrayscaleBits();
    /**
    * \brief Color resolution of the greyscale bitmap represented in allocated bits
    *       (i.e., value 4 means that 16 shades of grey are used).
    *       The greyscale bitmap is used for computing contrast and entropy values.
    */
    public native void setGrayscaleBits(int grayscaleBits);

    /**
    * \brief Size of the texture sampling window used to compute contrast and entropy
    *       (center of the window is always in the pixel selected by x,y coordinates
    *       of the corresponding feature sample).
    */
    public native int getWindowRadius();
    /**
    * \brief Size of the texture sampling window used to compute contrast and entropy
    *       (center of the window is always in the pixel selected by x,y coordinates
    *       of the corresponding feature sample).
    */
    public native void setWindowRadius(int radius);


    /**
    * \brief Weights (multiplicative constants) that linearly stretch individual axes of the feature space
    *       (x,y = position; L,a,b = color in CIE Lab space; c = contrast. e = entropy)
    */
    public native float getWeightX();
    /**
    * \brief Weights (multiplicative constants) that linearly stretch individual axes of the feature space
    *       (x,y = position; L,a,b = color in CIE Lab space; c = contrast. e = entropy)
    */
    public native void setWeightX(float weight);

    /**
    * \brief Weights (multiplicative constants) that linearly stretch individual axes of the feature space
    *       (x,y = position; L,a,b = color in CIE Lab space; c = contrast. e = entropy)
    */
    public native float getWeightY();
    /**
    * \brief Weights (multiplicative constants) that linearly stretch individual axes of the feature space
    *       (x,y = position; L,a,b = color in CIE Lab space; c = contrast. e = entropy)
    */
    public native void setWeightY(float weight);

    /**
    * \brief Weights (multiplicative constants) that linearly stretch individual axes of the feature space
    *       (x,y = position; L,a,b = color in CIE Lab space; c = contrast. e = entropy)
    */
    public native float getWeightL();
    /**
    * \brief Weights (multiplicative constants) that linearly stretch individual axes of the feature space
    *       (x,y = position; L,a,b = color in CIE Lab space; c = contrast. e = entropy)
    */
    public native void setWeightL(float weight);

    /**
    * \brief Weights (multiplicative constants) that linearly stretch individual axes of the feature space
    *       (x,y = position; L,a,b = color in CIE Lab space; c = contrast. e = entropy)
    */
    public native float getWeightA();
    /**
    * \brief Weights (multiplicative constants) that linearly stretch individual axes of the feature space
    *       (x,y = position; L,a,b = color in CIE Lab space; c = contrast. e = entropy)
    */
    public native void setWeightA(float weight);

    /**
    * \brief Weights (multiplicative constants) that linearly stretch individual axes of the feature space
    *       (x,y = position; L,a,b = color in CIE Lab space; c = contrast. e = entropy)
    */
    public native float getWeightB();
    /**
    * \brief Weights (multiplicative constants) that linearly stretch individual axes of the feature space
    *       (x,y = position; L,a,b = color in CIE Lab space; c = contrast. e = entropy)
    */
    public native void setWeightB(float weight);

    /**
    * \brief Weights (multiplicative constants) that linearly stretch individual axes of the feature space
    *       (x,y = position; L,a,b = color in CIE Lab space; c = contrast. e = entropy)
    */
    public native float getWeightContrast();
    /**
    * \brief Weights (multiplicative constants) that linearly stretch individual axes of the feature space
    *       (x,y = position; L,a,b = color in CIE Lab space; c = contrast. e = entropy)
    */
    public native void setWeightContrast(float weight);

    /**
    * \brief Weights (multiplicative constants) that linearly stretch individual axes of the feature space
    *       (x,y = position; L,a,b = color in CIE Lab space; c = contrast. e = entropy)
    */
    public native float getWeightEntropy();
    /**
    * \brief Weights (multiplicative constants) that linearly stretch individual axes of the feature space
    *       (x,y = position; L,a,b = color in CIE Lab space; c = contrast. e = entropy)
    */
    public native void setWeightEntropy(float weight);

    /**
    * \brief Initial samples taken from the image.
    *       These sampled features become the input for clustering.
    */
    public native @ByVal Point2fVector getSamplingPoints();



    /**
    * \brief Weights (multiplicative constants) that linearly stretch individual axes of the feature space.
    * @param idx ID of the weight
    * @param value Value of the weight
    * \note
    *       WEIGHT_IDX = 0;
    *       X_IDX = 1;
    *       Y_IDX = 2;
    *       L_IDX = 3;
    *       A_IDX = 4;
    *       B_IDX = 5;
    *       CONTRAST_IDX = 6;
    *       ENTROPY_IDX = 7;
    */
    public native void setWeight(int idx, float value);
    /**
    * \brief Weights (multiplicative constants) that linearly stretch individual axes of the feature space.
    * @param weights Values of all weights.
    * \note
    *       WEIGHT_IDX = 0;
    *       X_IDX = 1;
    *       Y_IDX = 2;
    *       L_IDX = 3;
    *       A_IDX = 4;
    *       B_IDX = 5;
    *       CONTRAST_IDX = 6;
    *       ENTROPY_IDX = 7;
    */
    public native void setWeights(@StdVector FloatPointer weights);
    public native void setWeights(@StdVector FloatBuffer weights);
    public native void setWeights(@StdVector float[] weights);

    /**
    * \brief Translations of the individual axes of the feature space.
    * @param idx ID of the translation
    * @param value Value of the translation
    * \note
    *       WEIGHT_IDX = 0;
    *       X_IDX = 1;
    *       Y_IDX = 2;
    *       L_IDX = 3;
    *       A_IDX = 4;
    *       B_IDX = 5;
    *       CONTRAST_IDX = 6;
    *       ENTROPY_IDX = 7;
    */
    public native void setTranslation(int idx, float value);
    /**
    * \brief Translations of the individual axes of the feature space.
    * @param translations Values of all translations.
    * \note
    *       WEIGHT_IDX = 0;
    *       X_IDX = 1;
    *       Y_IDX = 2;
    *       L_IDX = 3;
    *       A_IDX = 4;
    *       B_IDX = 5;
    *       CONTRAST_IDX = 6;
    *       ENTROPY_IDX = 7;
    */
    public native void setTranslations(@StdVector FloatPointer translations);
    public native void setTranslations(@StdVector FloatBuffer translations);
    public native void setTranslations(@StdVector float[] translations);

    /**
    * \brief Sets sampling points used to sample the input image.
    * @param samplingPoints Vector of sampling points in range [0..1)
    * \note Number of sampling points must be greater or equal to clusterization seed count.
    */
    public native void setSamplingPoints(@ByVal Point2fVector samplingPoints);



    /**** clusterizer ****/
    /**
    * \brief Initial seeds (initial number of clusters) for the k-means algorithm.
    */
    public native @StdVector IntPointer getInitSeedIndexes();
    /**
    * \brief Initial seed indexes for the k-means algorithm.
    */
    public native void setInitSeedIndexes(@StdVector IntPointer initSeedIndexes);
    public native void setInitSeedIndexes(@StdVector IntBuffer initSeedIndexes);
    public native void setInitSeedIndexes(@StdVector int[] initSeedIndexes);
    /**
    * \brief Number of initial seeds (initial number of clusters) for the k-means algorithm.
    */
    public native int getInitSeedCount();

    /**
    * \brief Number of iterations of the k-means clustering.
    *       We use fixed number of iterations, since the modified clustering is pruning clusters
    *       (not iteratively refining k clusters).
    */
    public native int getIterationCount();
    /**
    * \brief Number of iterations of the k-means clustering.
    *       We use fixed number of iterations, since the modified clustering is pruning clusters
    *       (not iteratively refining k clusters).
    */
    public native void setIterationCount(int iterationCount);

    /**
    * \brief Maximal number of generated clusters. If the number is exceeded,
    *       the clusters are sorted by their weights and the smallest clusters are cropped.
    */
    public native int getMaxClustersCount();
    /**
    * \brief Maximal number of generated clusters. If the number is exceeded,
    *       the clusters are sorted by their weights and the smallest clusters are cropped.
    */
    public native void setMaxClustersCount(int maxClustersCount);

    /**
    * \brief This parameter multiplied by the index of iteration gives lower limit for cluster size.
    *       Clusters containing fewer points than specified by the limit have their centroid dismissed
    *       and points are reassigned.
    */
    public native int getClusterMinSize();
    /**
    * \brief This parameter multiplied by the index of iteration gives lower limit for cluster size.
    *       Clusters containing fewer points than specified by the limit have their centroid dismissed
    *       and points are reassigned.
    */
    public native void setClusterMinSize(int clusterMinSize);

    /**
    * \brief Threshold euclidean distance between two centroids.
    *       If two cluster centers are closer than this distance,
    *       one of the centroid is dismissed and points are reassigned.
    */
    public native float getJoiningDistance();
    /**
    * \brief Threshold euclidean distance between two centroids.
    *       If two cluster centers are closer than this distance,
    *       one of the centroid is dismissed and points are reassigned.
    */
    public native void setJoiningDistance(float joiningDistance);

    /**
    * \brief Remove centroids in k-means whose weight is lesser or equal to given threshold.
    */
    public native float getDropThreshold();
    /**
    * \brief Remove centroids in k-means whose weight is lesser or equal to given threshold.
    */
    public native void setDropThreshold(float dropThreshold);

    /**
    * \brief Distance function selector used for measuring distance between two points in k-means.
    */
    public native int getDistanceFunction();
    /**
    * \brief Distance function selector used for measuring distance between two points in k-means.
    *       Available: L0_25, L0_5, L1, L2, L2SQUARED, L5, L_INFINITY.
    */
    public native void setDistanceFunction(int distanceFunction);

}
