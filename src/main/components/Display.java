package main.components;


import java.awt.*;
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

    public Display() {
    }

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
            if (!layerArrayList.contains(l)) {
                layers.add(l);
            }
        }
    }

    public int[] getPixelBuffer() {
        return pixelBuffer;
    }

    public BufferedImage getImage() {
        return displayImage;
    }

    public void update() {
        onTick();

        for (Layer l: layers) {
            int[] tempBuffer = l.getLayerBuffer();
            l.drawShapes();
            for (int i = 0; i < pixelBuffer.length; i++) {
                pixelBuffer[i] = tempBuffer[i];
            }
        }
    }

    public abstract void onTick();

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void initializeBuffer() {
        System.out.println(width + ", " + height);
        for (int i = 0; i < (width*height); i++) {
            System.out.println(i);
            pixelBuffer[i] = Color.black.getRGB();
        }
    }

}
