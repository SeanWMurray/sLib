package main.components;

import java.awt.*;

public class Layer {

    private Display display;

    private int[] pixelBuffer;

    public Layer(Display display) {
        this.display = display;
        pixelBuffer = display.getPixelBuffer();
    }

    public void writeBuffer(int[] pixelBuffer) {
        this.pixelBuffer = pixelBuffer;
    }

    public int[] getLayerBuffer() {
        return pixelBuffer;
    }

    //Does not work
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

    public void drawSquare (int topx, int topy, int botx, int boty, int color) {
        int[] tempBuf = display.getPixelBuffer();
        for (int i = topx; i < botx; i++) {
            for (int k = topy; k < boty; k++) {
                tempBuf[(k * display.getWidth()) + i] = color;
            }
        }
        writeBuffer(tempBuf);
    }
}
