import javafx.application.Platform;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.bytedeco.javacpp.*;
import org.bytedeco.librealsense2.global.realsense2;
import org.bytedeco.librealsense2.*;
import org.bytedeco.opencv.global.opencv_core;
import org.bytedeco.opencv.global.opencv_imgproc;
import org.bytedeco.opencv.opencv_core.*;

import java.nio.*;
import java.util.*;
import java.util.concurrent.*;

public class RealSenseCapture {
    static final int width = 640;
    static final int height = 480;
    public static void main(String[] args) {
        final int fps = 30;
        final int COLOR_STREAM_INDEX = -1;
        final int DEPTH_STREAM_INDEX = -1;
        rs2_error e = new rs2_error();
        realsense2.rs2_log_to_console(realsense2.RS2_LOG_SEVERITY_ERROR, e);
        if (!check_error(e)) {
            return;
        }
        rs2_context ctx = realsense2.rs2_create_context(realsense2.RS2_API_VERSION, e);
        if (!check_error(e)) {
            return;
        }
        rs2_device_list list = realsense2.rs2_query_devices(ctx, e);
        if (!check_error(e)) {
            return;
        }
        int rs2_list_size = realsense2.rs2_get_device_count(list, e);
        if (!check_error(e)) {
            return;
        }
        System.out.printf("realsense device %d\n", rs2_list_size);
        if (rs2_list_size == 0) {
            return;
        }
        rs2_device rsdev = realsense2.rs2_create_device(list, 0, e);
        if (!check_error(e)) {
            return;
        }

        if (rsdev == null) {
            System.err.println("device not found. serial number = ");
            return;
        }

        // Declare RealSense pipeline, encapsulating the actual device and sensors
        rs2_pipeline pipe = realsense2.rs2_create_pipeline(ctx, e);
        //Create a configuration for configuring the pipeline with a non default profile
        rs2_config cfg = realsense2.rs2_create_config(e);
        //Add desired streams to configuration
        realsense2.rs2_config_enable_stream(cfg, realsense2.RS2_STREAM_COLOR, COLOR_STREAM_INDEX, width, height, realsense2.RS2_FORMAT_RGB8, fps, e);
        realsense2.rs2_config_enable_stream(cfg, realsense2.RS2_STREAM_DEPTH, DEPTH_STREAM_INDEX, width, height, realsense2.RS2_FORMAT_Z16, fps, e);
        if (!check_error(e)) {
            return;
        }

        // Start streaming with default recommended configuration
        rs2_pipeline_profile selection = realsense2.rs2_pipeline_start_with_config(pipe, cfg, e);
        if (!check_error(e)) {
            return;
        }

        // Define align object that will be used to align to color viewport.
        rs2_processing_block align_to_color = realsense2.rs2_create_align(realsense2.RS2_STREAM_COLOR, e);
        if (!check_error(e)) {
            return;
        }
        rs2_frame_queue align_queue = realsense2.rs2_create_frame_queue(1, e);
        if (!check_error(e)) {
            return;
        }
        realsense2.rs2_start_processing_queue(align_to_color, align_queue, e);
        if (!check_error(e)) {
            return;
        }
        int psize = 100;
        IntPointer stream = new IntPointer(psize);
        IntPointer format = new IntPointer(psize);
        IntPointer indexP = new IntPointer(psize);
        IntPointer unique_id = new IntPointer(psize);
        IntPointer framerate = new IntPointer(psize);
        rs2_frame color_frame = null;
        rs2_frame depth_frame = null;

        while (true) {
            rs2_frame tmpFrames = realsense2.rs2_pipeline_wait_for_frames(pipe, realsense2.RS2_DEFAULT_TIMEOUT, e);
            if (!check_error(e)) {
                continue;
            }

            // Align depth frame to color viewport
            realsense2.rs2_frame_add_ref(tmpFrames, e);
            if (!check_error(e)) {
                rs2_release_frames(color_frame, depth_frame, tmpFrames);
                continue;
            }
            realsense2.rs2_process_frame(align_to_color, tmpFrames, e);
            rs2_frame frames = realsense2.rs2_wait_for_frame(align_queue, 5000, e);
            if (!check_error(e)) {
                rs2_release_frames(color_frame, depth_frame, tmpFrames, frames);
                continue;
            }
            rs2_release_frames(tmpFrames);

            int num_of_frames = realsense2.rs2_embedded_frames_count(frames, e);
            // retrieve each frame
            for (int i = 0; i < num_of_frames; i++) {
                rs2_frame frame = realsense2.rs2_extract_frame(frames, i, e);
                rs2_stream_profile mode = realsense2.rs2_get_frame_stream_profile(frame, e);
                realsense2.rs2_get_stream_profile_data(mode, stream, format, indexP, unique_id, framerate, e);
                String stream_type = realsense2.rs2_stream_to_string(stream.get()).getString();
                // retrieve each frame
                switch (stream_type.toLowerCase()) {
                    case "color":
                        color_frame = frame;
                        break;
                    case "depth":
                        depth_frame = frame;
                        break;
                    default:
                        System.err.println("invalid stream data "+stream_type);
                        break;
                }
            }
            if (color_frame == null || depth_frame == null) {
                // release frames
                rs2_release_frames(color_frame, depth_frame, frames);
                continue;
            }

            BytePointer color_pointer = new BytePointer(realsense2.rs2_get_frame_data(color_frame, e));
            int color_data_size = realsense2.rs2_get_frame_data_size(color_frame, e);
            byte[] color_byte = new byte[color_data_size];
            color_pointer.get(color_byte, 0, color_data_size);
            color_pointer.close();

            BytePointer depth_pointer = new BytePointer(realsense2.rs2_get_frame_data(depth_frame, e));
            int depth_data_size = realsense2.rs2_get_frame_data_size(depth_frame, e);
            byte[] depth_byte = new byte[depth_data_size];
            depth_pointer.get(depth_byte, 0, depth_data_size);
            depth_pointer.close();
            byte[] color_depth_byte = toColorMap(depth_byte, width, height, -1, -1);

            // show rgb
            OpenCVFX.imshow("color", color_byte, width, height);
            // show depth
            OpenCVFX.imshow("depth", color_depth_byte, width, height);

            // release frames
            rs2_release_frames(color_frame, depth_frame, frames);

            if (OpenCVFX.waitKey() == 27) {
                break;
            }

        }

        OpenCVFX.destroyAllWindows();

        // Stop pipeline streaming
        realsense2.rs2_pipeline_stop(pipe, e);

        // Release resources
        realsense2.rs2_delete_pipeline_profile(selection);
        realsense2.rs2_delete_processing_block(align_to_color);
        realsense2.rs2_delete_frame_queue(align_queue);
        realsense2.rs2_delete_config(cfg);
        realsense2.rs2_delete_pipeline(pipe);
        realsense2.rs2_delete_device(rsdev);
        realsense2.rs2_delete_device_list(list);
        realsense2.rs2_delete_context(ctx);

    }

    private static byte[] toColorMap(byte[] depth, int w, int h, double max, double min) {
        byte[] result = new byte[w * h * 3];
        Mat depthmat = new Mat(h, w, opencv_core.CV_16UC1);
        depthmat.data().put(depth, 0, depth.length);
        Mat rmat = toColorMap(depthmat, max, min);
        rmat.data().get(result, 0, result.length);

        depthmat.release();
        depthmat.close();
        rmat.release();
        rmat.close();
        return result;
    }

    private static Mat toColorMap(Mat depth, double max, double min) {
        Mat out = new Mat();
        if (max < 0 || min < 0) {
            double[] minVal = new double[1];
            double[] maxVal = new double[1];
            opencv_core.minMaxLoc(depth, minVal, maxVal, null, null, null);
            min = minVal[0];
            max = maxVal[0];
        }
        double scale = 255 / (max - min);
        depth.convertTo(out, opencv_core.CV_8UC1, scale, -min * scale);
        opencv_imgproc.applyColorMap(out, out, opencv_imgproc.COLORMAP_JET);
        return out;
    }

    private static void rs2_release_frames(rs2_frame... frames) {
        for (rs2_frame frame : frames) {
            if (frame != null) {
                realsense2.rs2_release_frame(frame);
            }
        }
    }

    private static boolean check_error(rs2_error e) {
        if (!e.isNull()) {
            System.err.printf("%s(%s): %s%n",
                    realsense2.rs2_get_failed_function(e).getString(),
                    realsense2.rs2_get_failed_args(e).getString(),
                    realsense2.rs2_get_error_message(e).getString());
            return false;
        }
        return true;
    }

    static class OpenCVFX {
        private final static ArrayList<ImShowThread> list = new ArrayList<>();

        public static void imshow(String name, byte[] data, int width, int height) {
            if (data.length != width * height * 3) {
                System.err.println("error: imshow() data length must be [width * height * 3]");
                return;
            }
            synchronized (list) {
                for (ImShowThread im : list) {
                    if (im.getName().equals(name)) {
                        im.addImage(data, 0, data.length, width, height);
                        return;
                    }
                }
                ImShowThread im = new ImShowThread(name);
                im.start();
                list.add(im);
                im.addImage(data, 0, data.length, width, height);
            }
        }

        public static int waitKey() {
            synchronized (list) {
                for (ImShowThread im : list) {
                    int key = im.getKey();
                    if (key != -1) {
                        return key;
                    }
                }
                return -1;
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


        static class ImShowThread implements Runnable {
            private final String window_name;
            private boolean loopFlag = true;
            private final Thread thread = new Thread(this);
            private static final int maxQueueSize = 3;
            private final ArrayBlockingQueue<byte[]> queue = new ArrayBlockingQueue<>(maxQueueSize);
            private boolean isLaunch = false;
            private boolean destroyAllWindows = true;
            private Stage tmpStage = null;
            private int keyCode;

            public ImShowThread(String name) {
                this.window_name = name;
            }

            public void start() {
                this.thread.start();
            }

            public void stop() {
                this.loopFlag = false;
                try {
                    this.thread.interrupt();
                    this.thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            public String getName() {
                return this.window_name;
            }

            public void setDestroyAllWindows(boolean flag) {
                this.destroyAllWindows = flag;
            }

            public void addImage(byte[] data, int offset, int length, int width, int height) {
                byte[] cd = new byte[length - offset];
                ByteBuffer.wrap(data, offset, length).get(cd, 0, cd.length);
                while (this.queue.size() >= maxQueueSize) {
                    this.queue.poll();
                }
                try {
                    this.queue.offer(cd, 10, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                }
            }

            public int getKey() {
                int result = this.keyCode;
                this.keyCode = -1;
                return result;
            }

            @Override
            public void run() {
                ImageView imageView = new ImageView();
                WritableImage writableImage = new WritableImage(1, 1);
                PixelFormat<ByteBuffer> pf = PixelFormat.getByteRgbInstance();
                while (this.loopFlag) {
                    byte[] data;
                    try {
                        data = this.queue.poll(50, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        sleep(30);
                        continue;
                    }
                    if (data == null) {
                        sleep(30);
                        continue;
                    }
                    if (!this.isLaunch) {
                        try {
                            Platform.startup(() -> launchFxWindow(imageView, width, height, this.window_name));
                        } catch (IllegalStateException ise) {
                            launchFxWindow(imageView, width, height, this.window_name);
                        }
                        writableImage = new WritableImage(width, height);
                    }
                    while (!this.isLaunch) {
                        sleep(100);
                    }

                    writableImage.getPixelWriter().setPixels(0, 0, width, height, pf, data, 0, width * 3);
                    imageView.setImage(writableImage);
                }
                if (this.destroyAllWindows) {
                    Platform.runLater(Platform::exit);
                }
            }

            private void sleep(long ms) {
                try {
                    Thread.sleep(ms);
                } catch (InterruptedException ignored) {
                }
            }

            private void launchFxWindow(ImageView iv, int w, int h, String name) {
                Platform.runLater(() -> {
                    Scene scene = new Scene(new StackPane(iv), w, h);
                    Stage stage = new Stage();
                    stage.setTitle(name);
                    stage.showingProperty().addListener((obs, ov, nv) -> {
                        if (ov && !nv) {
                            this.isLaunch = false;
                            this.tmpStage = new Stage();
                            this.tmpStage.setScene(new Scene(new StackPane(), 1, 1));
                            this.tmpStage.show();
                        }
                    });
                    scene.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> this.keyCode = keyEvent.getCode().getCode());
                    stage.setScene(scene);
                    stage.show();
                    if (this.tmpStage != null && this.tmpStage.isShowing()) {
                        this.tmpStage.close();
                    }
                    this.isLaunch = true;
                });
            }

        }

    }
}
