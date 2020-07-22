package main.components.shapes;

import main.components.Layer;

public abstract class Shape {

    protected Layer layer;
    private int[] shapeContents;

    public Shape(Layer layer) {
        this.layer = layer;
    }

    public void drawShape() {
        draw();
        layer.writeBuffer(shapeContents);
    }

    public int[] getShape() {
        if (shapeContents == null) {
            return new int[layer.getDisplay().getPixelBuffer().length];
        } else {
            return shapeContents;
        }
    }

    public void setShape(int[] shapeContents) {
        this.shapeContents = shapeContents;
    }

    public Layer getLayer() {
        return layer;
    }

    public abstract void draw();

}
