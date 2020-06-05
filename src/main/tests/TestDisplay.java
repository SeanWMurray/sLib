package main.tests;

import main.components.Display;
import main.components.Layer;

import java.awt.image.BufferedImage;

public class TestDisplay extends Display {

    Layer testLayer;

    public TestDisplay() {}

    @Override
    public void updateBuffer() {
        testLayer = new Layer(this);
        addLayer(testLayer);
        int[] inter = testLayer.getLayerBuffer();
        for (int i = 0; i < getPixelBuffer().length; i++) {
            inter[i] = i;
        }
        testLayer.writeBuffer(inter);
    }


}
