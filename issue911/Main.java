import org.bytedeco.javacpp.Loader;
import org.bytedeco.opencv.global.opencv_core;
import org.bytedeco.opencv.global.opencv_cudaimgproc;
import org.bytedeco.opencv.global.opencv_imgproc;
import org.bytedeco.opencv.opencv_core.GpuMat;
import org.bytedeco.opencv.opencv_cudaoptflow.FarnebackOpticalFlow;
import org.bytedeco.opencv.opencv_cudafeatures2d.ORB;
import org.bytedeco.opencv.opencv_cudaimgproc.TemplateMatching;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            Loader.load(org.bytedeco.opencv.opencv_cudaoptflow.FarnebackOpticalFlow.class);
        } catch (UnsatisfiedLinkError e) {
            try {
                String path = Loader.cacheResource(FarnebackOpticalFlow.class, "windows-x86_64/jniopencv_ximgproc.dll").getPath();
                new ProcessBuilder("C:/DependenciesGui.exe", path).start().waitFor();
            } catch (IOException | InterruptedException ioException) {
                ioException.printStackTrace();
            }
        }

        GpuMat mat_cuda = new GpuMat();
        System.out.println("mat_cuda succeed");
        ORB orb_cuda = ORB.create();
        System.out.println("orb_cuda succeed");
        TemplateMatching temp_cuda = opencv_cudaimgproc.createTemplateMatching(opencv_core.CV_8UC1, opencv_imgproc.TM_SQDIFF);
        System.out.println("temp_cuda succeed");
        org.bytedeco.opencv.opencv_cudaoptflow.FarnebackOpticalFlow optflow_cuda = org.bytedeco.opencv.opencv_cudaoptflow.FarnebackOpticalFlow.create();
        System.out.println("optflow_cuda succeed");
    }
}
