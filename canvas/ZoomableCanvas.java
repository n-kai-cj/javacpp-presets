package canvas;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

/**
 * canvas class that can be zoom and scaling.
 * refer from https://stackoverflow.com/a/29530135.
 */
public class ZoomableCanvas extends ResizableCanvas {
    private static final double MAX_SCALE = 10.0d;
    private static final double MIN_SCALE = 1.0d;
    private static final double initScale = 1.0d;
    private boolean isZoomable = true;
    private DoubleProperty scale = new SimpleDoubleProperty(initScale);
    private DragContext sceneDragContext = new DragContext();

    public ZoomableCanvas() {
        // add scale transform
        this.scaleXProperty().bind(this.scale);
        this.scaleYProperty().bind(this.scale);

        // add mouse and scroll event filter
        this.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
            if (!isZoomable) return;
            // left mouse button => panning
            if (!event.isPrimaryButtonDown()) return;

            sceneDragContext.mouseAnchorX = event.getSceneX();
            sceneDragContext.mouseAnchorY = event.getSceneY();

            sceneDragContext.translateAnchorX = this.getTranslateX();
            sceneDragContext.translateAnchorY = this.getTranslateY();
        });

        this.addEventFilter(MouseEvent.MOUSE_DRAGGED, event -> {
            if (!isZoomable) return;
            // left mouse button => panning
            if (!event.isPrimaryButtonDown()) return;

            this.setTranslateX(sceneDragContext.translateAnchorX + event.getSceneX() - sceneDragContext.mouseAnchorX);
            this.setTranslateY(sceneDragContext.translateAnchorY + event.getSceneY() - sceneDragContext.mouseAnchorY);

            event.consume();
        });

        this.addEventFilter(ScrollEvent.ANY, event -> {
            if (!isZoomable) return;

            double delta = 1.2;
            double scale = getScale(); // currently we only use Y, same value is used for X
            double oldScale = scale;

            if (event.getDeltaY() < 0)
                scale /= delta;
            else
                scale *= delta;

            scale = clamp(scale);

            double f = (scale / oldScale) - 1;

            double dx = (event.getSceneX() - (this.getBoundsInParent().getWidth() / 2 + this.getBoundsInParent().getMinX()));
            double dy = (event.getSceneY() - (this.getBoundsInParent().getHeight() / 2 + this.getBoundsInParent().getMinY()));

            setScale(scale);

            // note: pivot value must be untransformed, i. e. without scaling
            setPivot(f * dx, f * dy);

            event.consume();
        });
    }

    public void setZoomable(boolean isZoomable) {
        this.isZoomable = isZoomable;
    }

    public void reset() {
        this.setTranslateX(0.0);
        this.setTranslateY(0.0);
        this.sceneDragContext = new DragContext();
        setScale(initScale);
    }

    private double getScale() {
        return this.scale.get();
    }

    private void setScale(double scale) {
        this.scale.set(scale);
    }

    private void setPivot(double x, double y) {
        this.setTranslateX(getTranslateX() - x);
        this.setTranslateY(getTranslateY() - y);
    }

    private double clamp(double value) {
        if (Double.compare(value, MIN_SCALE) < 0)
            return MIN_SCALE;
        if (Double.compare(value, MAX_SCALE) > 0)
            return MAX_SCALE;
        return value;
    }

    /**
     * Mouse drag context used for scene and nodes.
     */
    static class DragContext {
        double mouseAnchorX;
        double mouseAnchorY;
        double translateAnchorX;
        double translateAnchorY;
    }

}
