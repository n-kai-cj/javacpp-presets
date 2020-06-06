import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ImShowThread2 implements Runnable {
    private final String window_name;
    private boolean loopFlag = true;
    private final Thread thread = new Thread(this);
    private static final int maxQueueSize = 3;
    private final ArrayBlockingQueue<Cls> queue = new ArrayBlockingQueue<>(maxQueueSize);
    private boolean isLaunch = false;
    private boolean destroyAllWindows = true;
    private Stage tmpStage = null;

    public ImShowThread2(String name) {
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
        Cls cls = new Cls();
        cls.data = new byte[length - offset];
        ByteBuffer.wrap(data, offset, length).get(cls.data, 0, cls.data.length);
        cls.width = width;
        cls.height = height;
        while (this.queue.size() >= maxQueueSize) {
            this.queue.poll();
        }
        try {
            this.queue.offer(cls, 10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(String.format("warn %s:%s", e.getClass().getSimpleName(), e.getMessage()));
        }
    }

    @Override
    public void run() {
        ImageView imageView = new ImageView();
        WritableImage writableImage = new WritableImage(1, 1);
        int width = 1;
        int height = 1;
        PixelFormat<ByteBuffer> pf = PixelFormat.getByteRgbInstance();
        boolean isLaunching = false;
        while (this.loopFlag) {
            Cls cls;
            try {
                cls = this.queue.poll(50, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                sleep(30);
                continue;
            }
            if (cls == null) {
                sleep(30);
                continue;
            }
            if (!isLaunching &&
                    (!this.isLaunch || width != cls.width || height != cls.height)) {
                isLaunching = true;
                try {
                    Platform.startup(() -> launchFxWindow(imageView, cls.width, cls.height, this.window_name));
                } catch (IllegalStateException ise) {
                    System.out.println(String.format("warn %s:%s", ise.getClass().getSimpleName(), ise.getMessage()));
                    launchFxWindow(imageView, cls.width, cls.height, this.window_name);
                }
                width = cls.width;
                height = cls.height;
                writableImage = new WritableImage(width, height);
                sleep(100);
            }
            if (!this.isLaunch) continue;
            isLaunching = false;

            writableImage.getPixelWriter().setPixels(0, 0, width, height, pf, cls.data, 0, width * 3);
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
            stage.setScene(scene);
            stage.show();
            if (this.tmpStage != null && this.tmpStage.isShowing()) {
                this.tmpStage.close();
            }
            this.isLaunch = true;
        });
    }

    static class Cls {
        byte[] data;
        int width;
        int height;
    }

}
