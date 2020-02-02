/*
 * (C) Copyright 2014 Amaury Crickx
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

import java.util.Arrays;

/**
 * A voice activity detector attempts to detect presence or abscence of voice in the signal.
 * <p>
 * The technique used here is a simple (but efficient) one based on a characteristic of (white) noise :
 * when applying autocorrelation, the mean value of the computed cofficients gets close to zero. <br/>
 * Voice activity detection has undergone quite a lot of research, best algorithms use several hints before deciding presence or
 * absence of voice.
 * </p>
 *
 * @author Amaury Crickx
 * @see <a href="http://en.wikipedia.org/wiki/White_noise">White noise</a>
 * @see <a href="http://en.wikipedia.org/wiki/Autocorrelation">Autocorrelation</a>
 * @see <a href="http://en.wikipedia.org/wiki/Voice_activity_detection">Voice activity detection</a>
 * @see <a href="http://ieeexplore.ieee.org/xpl/articleDetails.jsp?arnumber=6403507&punumber%3D97">Unsupervised VAD article on IEEE</a>
 */
public class VoiceActivityDetector {

    private static final int WINDOW_MILLIS = 1;
    private static final int FADE_MILLIS = 2;
    private static final int MIN_SILENCE_MILLIS = 4;
    private static final int MIN_VOICE_MILLIS = 20;

    private double threshold = 0.0001d;

    private double[] fadeInFactors = new double[1];
    private double[] fadeOutFactors = new double[1];

    private double[] doubleTmpBuffer = new double[1];
    private double[] shortenedVoiceSampleDouble = new double[1];
    private double[] correlation = new double[1];
    private double[] window = new double[1];
    private boolean[] voiceActivityResult = new boolean[1];

    /**
     * constructor.
     */
    public VoiceActivityDetector() {
    }

    /**
     * Sets the noise threshold used to determine if a given section is silence or not
     *
     * @param threshold the threshold
     */
    public void setAutocorrellationThreshold(double threshold) {
        this.threshold = threshold;
    }

    public int removeSilence(byte[] voiceSample, float sampleRate, byte[] dst) {
        if (doubleTmpBuffer.length < voiceSample.length / 2) {
            doubleTmpBuffer = new double[voiceSample.length / 2];
        }
        for (int i = 0; i < voiceSample.length / 2; i++) {
            short sample = Utility.byteToShort(voiceSample, i * 2);
            doubleTmpBuffer[i] = sample / (double) Short.MAX_VALUE;
        }
        if (shortenedVoiceSampleDouble.length < voiceSample.length / 2) {
            shortenedVoiceSampleDouble = new double[voiceSample.length / 2];
        }
        int doubleLength = removeSilence(doubleTmpBuffer, voiceSample.length / 2, sampleRate, shortenedVoiceSampleDouble);
        for (int i = 0; i < doubleLength; i++) {
            short sample = (short) (shortenedVoiceSampleDouble[i] * Short.MAX_VALUE);
            Utility.shortToByte(sample, dst, i * 2);
        }
        return doubleLength * 2;
    }

    /**
     * Removes silence out of the given voice sample
     *
     * @param voiceSample       the voice sample, values between -1.0 and 1.0
     * @param voiceSampleLength the length of voice sample
     * @param sampleRate        the sample rate
     * @param dst               a new voice sample with silence removed
     * @return the length of dst array
     */
    public int removeSilence(double[] voiceSample, int voiceSampleLength, float sampleRate, double[] dst) {
        int oneMilliInSamples = (int) sampleRate / 1000;
        int minSilenceLength = MIN_SILENCE_MILLIS * oneMilliInSamples;
        int minActivityLength = getMinimumVoiceActivityLength(sampleRate);
        if (voiceSampleLength < minActivityLength) {
            //System.out.println("minActivityLength="+minActivityLength+", voice length = "+voiceSampleLength);
            System.arraycopy(voiceSample, 0, dst, 0, voiceSampleLength);
            return voiceSampleLength;
        }

        int windowSize = WINDOW_MILLIS * oneMilliInSamples;
        if (correlation.length < windowSize) {
            correlation = new double[windowSize];
        }
        if (window.length < windowSize) {
            window = new double[windowSize];
        }
        if (voiceActivityResult.length < voiceSampleLength) {
            voiceActivityResult = new boolean[voiceSampleLength];
        }
        for (int position = 0; position + windowSize < voiceSampleLength; position += windowSize) {
            System.arraycopy(voiceSample, position, window, 0, windowSize);
            double mean = bruteForceAutocorrelation(window, correlation, windowSize);
            //System.out.println("mean = "+mean);
            Arrays.fill(voiceActivityResult, position, position + windowSize, mean > threshold);
        }
        mergeSmallSilentAreas(voiceActivityResult, voiceSampleLength, minSilenceLength);
        int silenceCounter = mergeSmallActiveAreas(voiceActivityResult, voiceSampleLength, minActivityLength);

        //System.out.println((int)((double)silenceCounter / voiceSampleLength * 100.0d) + "% removed");

        if (silenceCounter > 0) {
            int fadeLength = FADE_MILLIS * oneMilliInSamples;
            initFadeFactors(fadeLength);
            int copyCounter = 0;
            for (int i = 0; i < voiceSampleLength; i++) {
                if (voiceActivityResult[i]) {
                    // detect lenght of active frame
                    int startIndex = i;
                    int counter = 0;
                    while (i < voiceSampleLength && voiceActivityResult[i++]) {
                        counter++;
                    }
                    int endIndex = startIndex + counter;

                    applyFadeInFadeOut(voiceSample, fadeLength, startIndex, endIndex);
                    System.arraycopy(voiceSample, startIndex, dst, copyCounter, counter);
                    copyCounter += counter;
                }
            }
            return voiceSampleLength - silenceCounter;
        } else {
            System.arraycopy(voiceSample, 0, dst, 0, voiceSampleLength);
            return voiceSampleLength;
        }
    }

    /**
     * Gets the minimum voice activity length that will be considered by the remove silence method
     *
     * @param sampleRate the sample rate
     * @return the length
     */
    private int getMinimumVoiceActivityLength(float sampleRate) {
        return MIN_VOICE_MILLIS * (int) sampleRate / 1000;
    }

    /**
     * Applies a linear fade in / out to the given portion of audio (removes unwanted cracks)
     *
     * @param voiceSample the voice sample
     * @param fadeLength  the fade length
     * @param startIndex  fade in start point
     * @param endIndex    fade out end point
     */
    private void applyFadeInFadeOut(double[] voiceSample, int fadeLength, int startIndex, int endIndex) {
        int fadeOutStart = endIndex - fadeLength;
        for (int j = 0; j < fadeLength; j++) {
            voiceSample[startIndex + j] *= fadeInFactors[j];
            voiceSample[fadeOutStart + j] *= fadeOutFactors[j];
        }
    }

    /**
     * Merges small active areas
     *
     * @param result            the voice activity result
     * @param resultLength      the length of voice activity result
     * @param minActivityLength the minimum length to apply
     * @return a count of silent elements
     */
    private int mergeSmallActiveAreas(boolean[] result, int resultLength, int minActivityLength) {
        boolean active;
        int increment;
        int silenceCounter = 0;
        for (int i = 0; i < resultLength; i += increment) {
            active = result[i];
            increment = 1;
            while ((i + increment < resultLength) && result[i + increment] == active) {
                increment++;
            }
            if (active && increment < minActivityLength) {
                // convert short activity to opposite
                Arrays.fill(result, i, i + increment, !active);
                silenceCounter += increment;
            }
            if (!active) {
                silenceCounter += increment;
            }
        }
        return silenceCounter;
    }

    /**
     * Merges small silent areas
     *
     * @param result           the voice activity result
     * @param resultLength     the length of voice activity result
     * @param minSilenceLength the minimum silence length to apply
     */
    private void mergeSmallSilentAreas(boolean[] result, int resultLength, int minSilenceLength) {
        boolean active;
        int increment;
        for (int i = 0; i < resultLength; i += increment) {
            active = result[i];
            increment = 1;
            while ((i + increment < resultLength) && result[i + increment] == active) {
                increment++;
            }
            if (!active && increment < minSilenceLength) {
                // convert short silence to opposite
                Arrays.fill(result, i, i + increment, !active);
            }
        }
    }

    /**
     * Initialize the fade in/ fade out factors properties
     *
     * @param fadeLength the fade length
     */
    private void initFadeFactors(int fadeLength) {
        if (fadeInFactors.length < fadeLength) {
            fadeInFactors = new double[fadeLength];
        }
        if (fadeOutFactors.length < fadeLength) {
            fadeOutFactors = new double[fadeLength];
        }
        for (int i = 0; i < fadeLength; i++) {
            fadeInFactors[i] = (1.0d / fadeLength) * i;
            fadeOutFactors[i] = 1.0d - fadeInFactors[i];
        }
    }

    /**
     * Applies autocorrelation in Oﾂｲ operations. Keep arrays very short !
     *
     * @param voiceSample the voice sample buffer
     * @param correlation the correlation buffer
     * @param length      the length of buffer
     * @return the mean correlation value
     */
    private double bruteForceAutocorrelation(double[] voiceSample, double[] correlation, int length) {
        Arrays.fill(correlation, 0);
        for (int j = 0; j < length; j++) {
            for (int i = 0; i < length; i++) {
                correlation[j] += voiceSample[i] * voiceSample[(length + i - j) % length];
            }
        }
        double mean = 0.0d;
        for (int i = 0; i < length; i++) {
            mean += correlation[i];
        }
        return mean / length;
    }

    private static short byteToShort(byte[] data, int start) {
        if (data == null || data.length - start < 2) {
            return Short.MIN_VALUE;
        }
        short value = (short) (data[start] & 0xff
                | ((data[start + 1] & 0xff) << 8));
        return value;
    }

    private static byte[] shortToByte(short value) {
        byte[] data = new byte[2];
        data[0] = (byte) (value & 0x00ff);
        data[1] = (byte) ((value & 0xff00) >>> 8);
        return data;
    }

    private static byte[] shortToByte(short value, byte[] data, int start) {
        if (data == null) {
            return shortToByte(value);
        }
        data[start] = (byte) (value & 0x00ff);
        data[start + 1] = (byte) ((value & 0xff00) >>> 8);
        return data;
    }

}
