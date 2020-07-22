package main;

import main.components.Display;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


public class SFrame extends JFrame implements Runnable {

    private int width;
    private int height;

    private boolean running;
    private long frame_time_ms = 1000 / 30;

    private Thread frameThread;

    private BufferedImage displayImage;
    private Display display;

    public SFrame(int width, int height) {
        this.width = width;
        this.height = height;

        setSize(width, height);
        setResizable(false);
        setTitle("Default");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

        int topBar = (int) (height - getContentPane().getSize().getHeight());
        setSize(width, height + topBar);

        displayImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        frameThread = new Thread(this);
    }

    public SFrame() {
        this(640, 480);
    }

    public void setDisplay(Display display) {
        this.display = display;
        this.display.setSize(width, height);
        this.display.setBufferedImage(displayImage);
    }

    public void startThread() {
        frameThread.start();
    }

    public void end() {
        running = false;
    }

    @Override
    public void run() {
        long startTime;
        long difference;
        long delayTime;
        running = true;

        double frameTime = 1.0;

        while (running) {
            startTime = System.nanoTime();

            display.update();
            displayImage = display.getImage();
            draw();

            difference = System.nanoTime() - startTime;
            delayTime = frame_time_ms - (difference / 1000000);
            frameTime = 1.0;
            if (delayTime < 0) {
                delayTime = 0;
                frameTime = (difference / 1000000) / frame_time_ms;
            }

            try {
                Thread.sleep(delayTime);
            } catch (InterruptedException e) { }
        }

        System.exit(0);
    }


    private void draw() {
        BufferStrategy buffer = getBufferStrategy();
        if (buffer == null) {
            createBufferStrategy(3);
            buffer = getBufferStrategy();
        }

        Graphics g = buffer.getDrawGraphics();
        g.drawImage(displayImage, 0, 0, getWidth(), getHeight(), null);
        buffer.show();
    }

}
