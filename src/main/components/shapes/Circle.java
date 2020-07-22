package main.components.shapes;

import main.components.Layer;

//TODO: Does not function whatsoever
public class Circle extends Shape {

    public Circle(Layer layer) {
        super(layer);
    }

    @Override
    public void draw() {

    }

    /*Does not work
    public void drawCircle(int x, int y, int circ, int color) {
        int[] tempBuf = display.getPixelBuffer();
        for (int i = 0; i < x; i++) {
            for (int k = 0; i < y; i++) {
                int determinant = (i*i) + (k*k) - circ*circ;
                if (determinant < 0) {
                    tempBuf[((k + y) * display.getWidth()) + i + x] = color;
                }
            }
        }
        writeBuffer(tempBuf);
    }
     */
}
