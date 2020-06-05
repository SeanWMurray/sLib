package main.tests;

import main.SFrame;

public class Test {

    public static void main(String[] args) {
        SFrame test = new SFrame(640, 480);

        TestDisplay testDisplay = new TestDisplay();
        test.setDisplay(testDisplay);
        test.startThread();
    }
}
