package main.components;


import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;

public abstract class Display {

    private int width = 0;
    private int height = 0;

    private ArrayList<Layer> layers = new ArrayList<>();

    private BufferedImage displayImage;
    private int[] pixelBuffer;
    private int[] pushBuffer;

    public Display() { }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setBufferedImage(BufferedImage image) {
        displayImage = image;
        pixelBuffer = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
    }

    public void addLayer(Layer layer) {
        layers.add(layer);
    }

    public void addLayers(ArrayList<Layer> layerArrayList) {
        for (Layer l: layerArrayList) {
            layers.add(l);
        }
    }

    public int[] getPixelBuffer() {
        return pixelBuffer;
    }

    public void update() {
        updateBuffer();

        for (Layer l: layers) {
            for (int i = 0; i < pixelBuffer.length; i++) {
                pixelBuffer[i] = l.getLayerBuffer()[i];
            }
        }
    }

    public abstract void updateBuffer();

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
