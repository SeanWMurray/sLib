package main.components;

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
}
