package dev.deejai.rain;

import java.awt.Canvas;
import java.awt.Dimension;

public class Game extends Canvas implements Runnable
{
    public static int width = 300;
    public static int height = (width*9) / 16;
    public static int scale = 3;

    private Thread thread;
    private JFrame frame;
    private boolean running = false;

    public Game()
    {
        Dimension size = new Dimension(width*scale, height*scale);
        setPreferredSize(size);

        frame = new JFrame();
    }

    public synchronized void start()
    {
        running = true;
        thread = new Thread(this, "Display");
        thread.start();
    }

    public synchronized void stop()
    {
        running = false;
        try { thread.join(); }
        catch( InterruptedExecution e ){ 
            e.printStackTrace();
        }
    }

    public void run()
    {
        while( running )
        {
            ;
        }
    }

    public static void main( String[] args )
    {
        Game game = new Game();
    }
}