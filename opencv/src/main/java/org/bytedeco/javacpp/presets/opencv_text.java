/*
 * Copyright (C) 2016-2017 Bram Biesbrouck, Samuel Audet
 *
 * Licensed either under the Apache License, Version 2.0, or (at your option)
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation (subject to the "Classpath" exception),
 * either version 2, or any later version (collectively, the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     http://www.gnu.org/licenses/
 *     http://www.gnu.org/software/classpath/license.html
 *
 * or as provided in the LICENSE.txt file that accompanied this code.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bytedeco.javacpp.presets;

import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

/**
 * Wrapper for OpenCV module text, part of OpenCV_Contrib.
 *
 * @author Bram Biesbrouck
 */
@Properties(inherit = {opencv_highgui.class, opencv_ml.class}, value = {
    @Platform(include = {"<opencv2/text.hpp>", "<opencv2/text/erfilter.hpp>", "<opencv2/text/ocr.hpp>"},
              link = "opencv_text@.3.3"),
    @Platform(value = "windows", link = "opencv_text331")},
              target = "org.bytedeco.javacpp.opencv_text")
public class opencv_text implements InfoMapper {
    public void map(InfoMap infoMap) {
	
	infoMap.put(new Info("std::deque<int>").pointerTypes("IntDeque").define());
	infoMap.put(new Info("std::vector<cv::text::ERStat>").pointerTypes("ERStatVector").define());
	infoMap.put(new Info("std::vector<std::vector<cv::text::ERStat> >").pointerTypes("ERStatVectorVector").define());
	infoMap.put(new Info("std::vector<double>").pointerTypes("DoubleVector").define());
	infoMap.put(new Info("std::vector<std::string>").pointerTypes("StdStringVector").define());
	
	infoMap.put(new Info("std::vector<cv::Vec2i>").pointerTypes("PointVector").cast());
	infoMap.put(new Info("std::vector<std::vector<cv::Vec2i> >").pointerTypes("PointVectorVector").cast());
	
    }
}
