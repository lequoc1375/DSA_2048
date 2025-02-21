package src.main;

import src.scenes.Playing;

import javax.swing.*;

public class Frame extends JFrame implements Runnable {
    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;
    private Thread thread;
    private Panel panel;
    private Playing playing;
    private Render render;
    public Frame() {
        panel = new Panel(this);
        playing = new Playing(this);
        render = new Render(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Largest number");
        add(panel);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
    public void start() {
        thread = new Thread(this) {};
        thread.start();
    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long lastTimeCheck = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;

        long now;

        while (true) {
            now = System.nanoTime();

            // Render
            if (now - lastFrame >= timePerFrame) {
                repaint();
                lastFrame = now;
                frames++;
            }

            // Update
            if (now - lastUpdate >= timePerUpdate) {
                updateGame();
                lastUpdate = now;
                updates++;
            }

            if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }

        }

    }

    private void updateGame() {
    }

    public Playing getPlaying() {
        return playing;
    }

    public Render getRender() {
        return render;
    }
}
