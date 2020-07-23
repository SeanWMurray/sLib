package main;

import main.components.Display;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/* SFrame class
 - Purpose: Simplifies setting up a JFrame and graphics for that JFrame
 - Function: Creates a JFrame of specific attributes that houses a Display class
   as well as a thread that handles timing and graphical computations
 */

public class SFrame extends JFrame implements Runnable {

    // The dimension of the frame
    private int width;
    private int height;

    // The thread designated to Display
    private Thread frameThread;

    // Whether or not the loop in the thread is enabled
    private boolean running;

    // The frames per second of the application
    // - 1000 ms = 1 second, so 1000 / 30 = 30 frames per second
    private long frame_time_ms = 1000 / 30;

    // The image that Display manipulates, and the currently assigned Display
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

    // Passes a default resolution to the other constructor
    public SFrame() {
        this(640, 480);
    }

    // Sets the frame's display
    // - Assigns a Display class to the frame and passes the Display the buffered image
    //   so it can be modified without accessing the SFrame
    public void setDisplay(Display display) {
        this.display = display;
        this.display.setSize(width, height);
        this.display.setBufferedImage(displayImage);
    }

    // Starts the program/thread
    // - Calls the start method of the thread that was instantiated in the constructor
    //   which in turn calls the run method specified in this class
    public void startThread() {
        frameThread.start();
    }

    // Ends the program
    // - Running is set to false, halting the thread loop and moving to System.exit
    public void end() {
        running = false;
    }

    // Updates the display
    // - Called by the thread start method, this starts the timing graphical calculations
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
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.exit(0);
    }


    // Establishes a BufferStrategy and displays graphics
    private void draw() {

        //Checks if buffer strategy already exists, if not creates it
        BufferStrategy buffer = getBufferStrategy();
        if (buffer == null) {
            createBufferStrategy(3);
            buffer = getBufferStrategy();
        }

        Graphics g = buffer.getDrawGraphics();
        g.drawImage(displayImage, 0, 0, getWidth(), getHeight(), null);
        g.dispose();
        buffer.show();
    }

}
