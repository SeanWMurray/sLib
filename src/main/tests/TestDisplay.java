package main.tests;

import main.components.Display;
import main.components.Layer;
import main.components.shapes.Rectangle;

import java.awt.*;

public class TestDisplay extends Display {

    Layer testLayer;

    int i = 5;

    public TestDisplay() {
        testLayer = new Layer(this);
        addLayer(testLayer);
    }

    @Override
    public void onTick() {
        i = (i + 1) % 200;
        testLayer.setPoint(30, i, Color.orange.getRGB());
        testLayer.setPoint(30, 30, Color.yellow.getRGB());
        testLayer.setPoint(31, 30, Color.yellow.getRGB());
        testLayer.setPoint(32, 30, Color.yellow.getRGB());
        testLayer.setPoint(30, 31, Color.yellow.getRGB());
        testLayer.setPoint(31, 31, Color.yellow.getRGB());
        testLayer.setPoint(32, 31, Color.yellow.getRGB());
        testLayer.addShape(new Rectangle(testLayer, 40, 40, 300, 300, Color.MAGENTA.getRGB()));
//        int[] inter = testLayer.getLayerBuffer();
//        for (int i = 0; i < getPixelBuffer().length; i++) {
//            inter[i] = i;
//        }
//        testLayer.writeBuffer(inter);
//      testLayer.drawSquare( 40, 40, 80, 80, Color.MAGENTA.getRGB());

    }


}
