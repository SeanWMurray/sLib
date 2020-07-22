package main.components;


import main.components.shapes.Shape;

import java.util.ArrayList;

public class Layer {

    private Display display;

    private int[] pixelBuffer;
    private ArrayList<Shape> shapes = new ArrayList<>();

    public Layer(Display display) {
        this.display = display;
        initializeBuffer();
    }

    public void initializeBuffer() {
        pixelBuffer = new int[640 * 480];
        System.out.println(pixelBuffer.length);
    }

    public void writeBuffer(int[] pixelBuffer) {
        this.pixelBuffer = pixelBuffer;
    }

    public int[] getLayerBuffer() {
        return pixelBuffer;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void drawShapes() {
        for (Shape shape: shapes) {
            shape.drawShape();
        }
    }

    public void setPoint(int x, int y, int color) {
        pixelBuffer[(y * display.getWidth()) + x] = color;
    }

    public Display getDisplay() {
        return display;
    }
}
