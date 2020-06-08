package main.tests;

import main.components.Display;
import main.components.Layer;

import java.awt.*;

public class TestDisplay extends Display {

    Layer testLayer;

    public TestDisplay() {
        testLayer = new Layer(this);
        addLayer(testLayer);
    }

    @Override
    public void onTick() {
        testLayer.drawCircle(100, 100, 50, Color.MAGENTA.getRGB());
//        int[] inter = testLayer.getLayerBuffer();
//        for (int i = 0; i < getPixelBuffer().length; i++) {
//            inter[i] = i;
//        }
//        testLayer.writeBuffer(inter);
//      testLayer.drawSquare( 40, 40, 80, 80, Color.MAGENTA.getRGB());

    }


}
