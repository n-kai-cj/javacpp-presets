package canvas;

import javafx.scene.canvas.Canvas;

/**
 *  resizable canvas class. refer from https://stackoverflow.com/a/57154987.
 */
public class ResizableCanvas extends Canvas {
    @Override
    public boolean isResizable() {
        return true;
    }

    @Override
    public double maxHeight(double width) {
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public double maxWidth(double height) {
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public double minWidth(double height) {
        return 1D;
    }

    @Override
    public double minHeight(double width) {
        return 1D;
    }

    @Override
    public void resize(double width, double height) {
        if (!this.widthProperty().isBound())
            this.setWidth(width);
        if (!this.heightProperty().isBound())
            this.setHeight(height);
    }
}
