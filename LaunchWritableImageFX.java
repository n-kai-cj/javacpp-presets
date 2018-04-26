import java.nio.ByteBuffer;
import java.util.ArrayList;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_videoio;
import org.bytedeco.javacpp.opencv_videoio.VideoCapture;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LaunchWritableImageFX extends Application {
	final int width = 1280;
	final int height = 720;
	final int capDevNum = 0;
	final int fps = 30;
	
	public static void run(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		final BorderPane bp = new BorderPane();
		final Label label = new Label("label");
		final ImageView imageView = new ImageView();
		bp.setTop(label);
		bp.setCenter(imageView);
		Task<byte[]> task = new Task<byte[]>() {
			boolean loopFlag = true;
			@Override
			public void cancelled() {
				System.out.println("cancelled called");
				this.loopFlag = false;
			}
			@Override
			protected byte[] call() throws Exception {
				VideoCapture videoCapture = new VideoCapture();
				videoCapture.open(capDevNum);
				videoCapture.set(opencv_videoio.CV_CAP_PROP_FRAME_WIDTH, width);
				videoCapture.set(opencv_videoio.CV_CAP_PROP_FRAME_HEIGHT, height);
				videoCapture.set(opencv_videoio.CV_CAP_PROP_FPS, fps);
				ArrayList<byte[]> ringBuf = new ArrayList<>();
				for (int i = 0; i < 10; i++) {
					ringBuf.add(new byte[width*height*3]);
				}
				int counter = 0;
				while (this.loopFlag) {
					videoCapture.grab();
					Mat mat = new Mat();
					videoCapture.read(mat);
					byte[] buf = ringBuf.get((counter++)%ringBuf.size());
//					byte[] buf = new byte[width*height*3];
					mat.data().get(buf);
					mat.release();
					mat.close();
					updateValue(buf);
				}
				videoCapture.release();
				videoCapture.close();
				return null;
			}
		};
		final PixelFormat<ByteBuffer> pf = PixelFormat.getByteRgbInstance();
		final WritableImage wi = new WritableImage(width, height);
		task.valueProperty().addListener((obs, oldVal, newVal) -> {
			if (newVal == null) return;
			long s = System.currentTimeMillis();
			// TODO reorder from BGR to RGB
//			WritableImage wi = new WritableImage(width, height);
			wi.getPixelWriter().setPixels(0, 0, width, height, pf, newVal, 0, width*3);
			imageView.setImage(wi);
			long e = System.currentTimeMillis();
			long elapsed = e-s;
			System.out.println(elapsed+"[msec]");
			label.setText(elapsed+"[msec]");
		});
		new Thread(task).start();
		primaryStage.setOnCloseRequest(e -> {
			System.out.println("cancel calling");
			task.cancel();
		});
		Scene scene = new Scene(bp, width, height);
		primaryStage.setScene(scene);
		primaryStage.setWidth(width);
		primaryStage.setHeight(height);
		primaryStage.show();
	}
	
}
