import org.bytedeco.opencv.global.opencv_imgproc;
import org.bytedeco.opencv.opencv_core.Mat;

import java.util.ArrayList;

public class OpenCVFX {
    private final static ArrayList<ImShowThread2> list = new ArrayList<>();

    public static void imshow(String name, Mat mat) {
        if (mat.channels() == 1) opencv_imgproc.cvtColor(mat, mat, opencv_imgproc.COLOR_GRAY2BGR);
        opencv_imgproc.cvtColor(mat, mat, opencv_imgproc.COLOR_BGR2RGB);
        byte[] data = new byte[mat.cols() * mat.rows() * mat.channels()];
        mat.data().get(data, 0, data.length);
        imshow(name, data, mat.cols(), mat.rows());
    }

    public static void imshow(String name, byte[] data, int width, int height) {
        if (data.length != width * height * 3) {
            System.err.println("error: imshow() data length must be [width * height * 3]");
            return;
        }
        synchronized (list) {
            for (ImShowThread2 im : list) {
                if (im.getName().equals(name)) {
                    im.addImage(data, 0, data.length, width, height);
                    return;
                }
            }
            ImShowThread2 im = new ImShowThread2(name);
            im.start();
            list.add(im);
        }
    }

    public static void destroyAllWindows() {
        synchronized (list) {
            for (int i = 0; i < list.size(); ++i) {
                list.get(i).setDestroyAllWindows((i+1)==list.size());
                list.get(i).stop();
            }
            list.clear();
        }
    }


}
