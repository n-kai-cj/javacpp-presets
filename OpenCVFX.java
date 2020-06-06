import org.bytedeco.opencv.global.opencv_imgproc;
import org.bytedeco.opencv.opencv_core.Mat;

import java.util.ArrayList;

public class OpenCVFX {
    private final static ArrayList<ImShowThread2> list = new ArrayList<>();

    public static void imshow(String name, Mat mat) {
        synchronized (list) {
            for (ImShowThread2 im : list) {
                if (im.getName().equals(name)) {
                    opencv_imgproc.cvtColor(mat, mat, opencv_imgproc.COLOR_BGR2RGB);
                    byte[] data = new byte[mat.cols() * mat.rows() * mat.channels()];
                    mat.data().get(data, 0, data.length);
                    im.addImage(data, 0, data.length, mat.cols(), mat.rows());
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
