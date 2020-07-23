package main.components.shapes;

import main.components.Layer;

public class Rectangle extends Shape {

    public int xTop, xBottom, yTop, yBottom, color;

    public Rectangle(Layer layer) {
        super(layer);
    }

    public Rectangle(Layer layer, int xTop, int yTop, int xBottom, int yBottom, int color) {
        super(layer);
        this.xTop = xTop;
        this.xBottom = xBottom;
        this.yTop = yTop;
        this.yBottom = yBottom;
        this.color = color;
    }

    //Called by the drawShape method to update the shape before drawing
    @Override
    public void draw() {
        int[] tempBuf = getShape();
        for (int i = xTop; i < xBottom; i++) {
            for (int k = yTop; k < yBottom; k++) {
                tempBuf[(k * getLayer().getDisplay().getWidth()) + i] = color;
            }
        }
        setShape(tempBuf);
    }
}
