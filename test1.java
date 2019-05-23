package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.indexer.FloatIndexer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class VideoCapture extends Application {
    static final int cameraId = 0;
    static final int width = 640;
    static final int height = 480;


    private Canvas canvas = new Canvas();
    private WritableImage wi = new WritableImage(1, 1);
    private final PixelFormat<ByteBuffer> pf = PixelFormat.getByteRgbInstance();
    private opencv_core.Mat rgbOrgMat = null;
    private BytePointer facePictureBuf;
    private opencv_dnn.Net cvNet = null;

    private ArrayList<String> cocoNames = null;

    private ArrayList<byte[]> shareList = new ArrayList<>();
    private VICaptureThread viCaptureThread = new VICaptureThread();
    private VideoCaptureTask videoCaptureTask = new VideoCaptureTask(this.shareList);

    static void run(String[] args) {
        // RuntimeException: No native JavaCPP library in memory. (Has Loader.load() been called?) - https://github.com/bytedeco/javacpp/issues/44
        Loader.load(opencv_core.class);
        launch(args);
    }

    private void exit() {
        this.viCaptureThread.stop();
        this.videoCaptureTask.stop();
    }

    @Override
    public void start(Stage primaryStage) {
        this.viCaptureThread.setShareList(this.shareList);
        this.viCaptureThread.start();
        this.videoCaptureTask.start();
        this.videoCaptureTask.valueProperty().addListener((obs, ov, nv) -> {
            if (nv == null) return;
//            hoge(nv.data);
            darknet(nv.data);
            if (this.wi == null || (int) this.wi.getWidth() != nv.w || (int) this.wi.getHeight() != nv.h) {
                this.wi = new WritableImage(nv.w, nv.h);
            }
            this.wi.getPixelWriter().setPixels(0, 0, nv.w, nv.h, pf, nv.data, 0, nv.w * 3);
            this.canvas.getGraphicsContext2D().drawImage(this.wi, 0, 0,
                    this.canvas.getWidth(), this.canvas.getHeight());
        });

//        this.cvNet = opencv_dnn.readNetFromCaffe("caffe/deploy.prototxt", "caffe/res10_300x300_ssd_iter_140000.caffemodel");
//        this.cvNet = opencv_dnn.readNetFromTensorflow("tf/frozen_inference_graph.pb", "tf/ssd_inception_v2_coco_2017_11_17.pbtxt");
        this.cvNet = opencv_dnn.readNetFromDarknet("darknet/yolov3.cfg", "darknet/yolov3.weights");

        StackPane root = new StackPane();
        AnchorPane pane = createPaneForCanvas(this.canvas);
        root.getChildren().add(pane);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.showingProperty().addListener((obs, ov, nv) -> {
            if (ov && !nv) exit();
        });
        primaryStage.show();
    }

    private void darknet(byte[] data) {
        if (this.rgbOrgMat == null) {
            this.facePictureBuf = new BytePointer(data.length);
            this.rgbOrgMat = new opencv_core.Mat(height, width, opencv_core.CV_8UC3, this.facePictureBuf);
        }
        this.facePictureBuf.put(data, 0, data.length);

        int tfWidth = 288;
        int tfHeight = 288;

        if (this.cocoNames == null) {
            try {
                this.cocoNames = (ArrayList<String>) Files.readAllLines(Paths.get("darknet/coco.names"), StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        opencv_core.StringVector ln = this.cvNet.getUnconnectedOutLayersNames();

        long s1 = System.currentTimeMillis();
        this.cvNet.setInput(opencv_dnn.blobFromImage(this.rgbOrgMat, 1/255.0,
                new opencv_core.Size(tfWidth, tfHeight),
//                new opencv_core.Scalar(103.93, 116.77, 123.68, 0),
                new opencv_core.Scalar(0),
                false, false, opencv_core.CV_32F));
        long s2 = System.currentTimeMillis();
//        opencv_core.Mat cvOut = this.cvNet.forward(outs, ln);
        opencv_core.MatVector cvOut = new opencv_core.MatVector();
        this.cvNet.forward(cvOut, ln);
        long s3 = System.currentTimeMillis();

        System.out.println("+++ setinput=" + (s2 - s1) + ", forward=" + (s3 - s2));

        IntPointer outLayers = this.cvNet.getUnconnectedOutLayers();
        String outLayerType = this.cvNet.getLayer(new opencv_dnn.DictValue(outLayers.get())).type().getString();

        ArrayList<Integer> clsIds = new ArrayList<>();
//        ArrayList<Float> confs = new ArrayList<>();
        FloatBuffer confs = FloatBuffer.allocate(10);
        ArrayList<opencv_core.Rect> rects = new ArrayList<>();

        if (outLayerType.toLowerCase().startsWith("detectionoutput")) {
            System.out.println("DetectionOutput NOT IMPLEMENTED !!!");
            // Network produces output blob with a shape 1x1xNx7 where N is a number of
            // detections and an every detection is a vector of values
            // [batchId, classId, confidence, left, top, right, bottom]
            if (cvOut.size() < 0) {
                System.err.println("error: DetectionOutput, but out size is "+cvOut.size());
                return;
            }
        } else if (outLayerType.toLowerCase().startsWith("region")) {
            for (int i = 0; i < cvOut.size(); i++) {
                // Network produces output blob with a shape NxC where N is a number of
                // detected objects and C is a number of classes + 4 where the first 4
                // numbers are [center_x, center_y, width, height]
                opencv_core.Mat ne = cvOut.get(i);
                FloatIndexer detection = ne.createIndexer(); // create indexer to access elements of the matric
                for (int j = 0; j < ne.rows(); ++j) {
                    opencv_core.Mat scores = ne.row(j).colRange(5, ne.cols());
                    DoublePointer confidence = new DoublePointer(10);
                    DoublePointer minVal = new DoublePointer(10);
                    opencv_core.Point classIdPoint = new opencv_core.Point(10);
                    opencv_core.Point minPoint = new opencv_core.Point(10);
                    opencv_core.minMaxLoc(scores, minVal, confidence, minPoint, classIdPoint, null);
                    if (confidence.get() > 0.8) {
                        System.out.println("something matched. confidence="+confidence.get());
//                        int centerX = ne.data().get(0) * width;
//                        int centerY = ne.data().get(1) * height;
//                        int regWidth = ne.data().get(2) * width;
//                        int regHeight = ne.data().get(3) * height;
                        int centerX = (int) (detection.get(j, 0) * width);
                        int centerY = (int) (detection.get(j, 1) * height);
                        int regWidth = (int) (detection.get(2) * width);
                        int regHeight = (int) (detection.get(3) * height);
                        int left = centerX - regWidth/2;
                        int top = centerY - regHeight/2;
                        //System.out.println("cx="+centerX+", cy="+centerY+", regw="+regWidth+", regh="+regHeight+", left="+left+", top="+top);
                        clsIds.add(classIdPoint.x());
//                        confs.add((float) confidence.get());
                        confs.put((float) confidence.get());
                        rects.add(new opencv_core.Rect(left, top, regWidth, regHeight));
                    }
                }
            }
        } else {
            System.err.println("error out layer type "+outLayerType);
            return;
        }
        if (rects.size() <= 0) {
            return;
        }
        confs.flip();
        opencv_core.RectVector boxes = new opencv_core.RectVector();
        rects.forEach(boxes::push_back);
        FloatPointer confidences = new FloatPointer(confs);
        IntPointer indices = new IntPointer(rects.size());
        opencv_dnn.NMSBoxes(boxes, confidences, 0.8f, 0.4f, indices);
        for (int i = (int) indices.position(); i < indices.limit(); i++) {
            int idx = indices.get(i);
            opencv_core.Rect box = boxes.get(idx);

            int tx = box.x();
            int ty = box.y();
            int bx = box.x()+box.width();
            int by = box.y()+box.height();
            System.out.println("tx="+tx+", ty="+ty+", bx="+bx+", by="+by);
            final int thickness = 5;
            final opencv_core.Scalar color = new opencv_core.Scalar(255, 0, 0, 0);
            opencv_imgproc.rectangle(this.rgbOrgMat,
                    new opencv_core.Rect(new opencv_core.Point(tx, ty), new opencv_core.Point(bx, by)),
                    color, thickness, opencv_imgproc.CV_AA, 0);
            String label = String.format("%s : %.2f[%%]", this.cocoNames.get(clsIds.get(idx)), confidences.get(idx)*100.0);
            System.out.println("i="+i+", label="+label);
            opencv_imgproc.putText(this.rgbOrgMat,
                    label, new opencv_core.Point(Math.max(tx - 10, 0), Math.max(ty - 10, 0)),
                    opencv_imgproc.FONT_HERSHEY_DUPLEX, 2.0, color,
                    thickness, opencv_imgproc.LINE_AA, false);

        }
        this.rgbOrgMat.arrayData().get(data);
    }

    private void hoge(byte[] data) {
        if (this.rgbOrgMat == null) {
            this.facePictureBuf = new BytePointer(data.length);
            this.rgbOrgMat = new opencv_core.Mat(height, width, opencv_core.CV_8UC3, this.facePictureBuf);
        }
        this.facePictureBuf.put(data, 0, data.length);

        int tfWidth = 224;
        int tfHeight = 224;

        long s1 = System.currentTimeMillis();
        this.cvNet.setInput(opencv_dnn.blobFromImage(this.rgbOrgMat, 1.0,
                new opencv_core.Size(tfWidth, tfHeight),
                new opencv_core.Scalar(103.93, 116.77, 123.68, 0),
                false, false, opencv_core.CV_32F));
        long s2 = System.currentTimeMillis();
        opencv_core.Mat cvOut = this.cvNet.forward();
        long s3 = System.currentTimeMillis();

        System.out.println("+++ setinput=" + (s2 - s1) + ", forward=" + (s3 - s2));

        // extract a 2d matrix for 4d output matrix with form of (number of detections x 7)
        opencv_core.Mat ne = new opencv_core.Mat(new opencv_core.Size(cvOut.size(3), cvOut.size(2)), opencv_core.CV_32F, cvOut.ptr(0, 0));
        FloatIndexer detection = ne.createIndexer(); // create indexer to access elements of the matric
        for (int i = 0; i < cvOut.size(3); i++) {//iterate to extract elements
            float score = detection.get(i, 2);
            float f1 = detection.get(i, 3);
            float f2 = detection.get(i, 4);
            float f3 = detection.get(i, 5);
            float f4 = detection.get(i, 6);
            if (score > 0.8) {
                float tx = f1 * width;//top left point's x
                float ty = f2 * height;//top left point's y
                float bx = f3 * width;//bottom right point's x
                float by = f4 * height;//bottom right point's y
                final int thickness = 5;
                final opencv_core.Scalar color = new opencv_core.Scalar(255, 0, 0, 0);
                opencv_imgproc.rectangle(this.rgbOrgMat,
                        new opencv_core.Rect(new opencv_core.Point((int) tx, (int) ty), new opencv_core.Point((int) bx, (int) by)),
                        color, thickness, opencv_imgproc.CV_AA, 0);
                opencv_imgproc.putText(this.rgbOrgMat,
                        String.format("%.2f[%%]", score * 100.0),
                        new opencv_core.Point((int) Math.max(tx - 10, 0), (int) Math.max(ty - 10, 0)),
                        opencv_imgproc.FONT_HERSHEY_DUPLEX, 3.0, color,
                        thickness, opencv_imgproc.LINE_AA, false);
            }
        }

        this.rgbOrgMat.arrayData().get(data);
    }

    private static AnchorPane createPaneForCanvas(Canvas canvas) {
        AnchorPane canvasAnchorPane = new AnchorPane();
        StackPane canvasStackPane = new StackPane();
        canvasAnchorPane.getChildren().add(canvasStackPane);
        AnchorPane.setBottomAnchor(canvasStackPane, 0.0);
        AnchorPane.setTopAnchor(canvasStackPane, 0.0);
        AnchorPane.setRightAnchor(canvasStackPane, 0.0);
        AnchorPane.setLeftAnchor(canvasStackPane, 0.0);
        canvasStackPane.getChildren().add(canvas);
        canvas.widthProperty().bind(canvasStackPane.widthProperty());
        canvas.heightProperty().bind(canvasStackPane.heightProperty());
        return canvasAnchorPane;
    }

}
