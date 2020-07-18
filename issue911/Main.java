import org.bytedeco.javacpp.Loader;
import org.bytedeco.opencv.global.opencv_core;
import org.bytedeco.opencv.global.opencv_cudaimgproc;
import org.bytedeco.opencv.global.opencv_imgproc;
import org.bytedeco.opencv.opencv_core.GpuMat;
import org.bytedeco.opencv.opencv_cudaoptflow.FarnebackOpticalFlow;
import org.bytedeco.opencv.opencv_cudafeatures2d.ORB;
import org.bytedeco.opencv.opencv_cudaimgproc.TemplateMatching;
import org.bytedeco.opencv.opencv_java;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Loader.load(opencv_java.class);
        try {
            Loader.load(org.bytedeco.opencv.opencv_cudaoptflow.FarnebackOpticalFlow.class);
        } catch (UnsatisfiedLinkError e) {
            try {
            String path = Loader.cacheResource(org.bytedeco.opencv.opencv_cudaoptflow.FarnebackOpticalFlow.class, "windows-x86_64/jniopencv_ximgproc.dll").getPath();
            new ProcessBuilder("c:/DependenciesGui.exe", path).start().waitFor();
            } catch (IOException|InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        GpuMat mat_cuda = new GpuMat();
        System.out.println("mat_cuda succeed");
        ORB orb_cuda = ORB.create();
        System.out.println("orb_cuda succeed");
        TemplateMatching temp_cuda = opencv_cudaimgproc.createTemplateMatching(opencv_core.CV_8UC1, opencv_imgproc.TM_SQDIFF);
        System.out.println("temp_cuda succeed");
        FarnebackOpticalFlow optflow_cuda = FarnebackOpticalFlow.create();
        System.out.println("optflow_cuda succeed");
    }
}
