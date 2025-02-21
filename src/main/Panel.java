package src.main;

import src.controller.KeyBoard;
import src.controller.Mouse;

import javax.swing.*;
import java.awt.*;


public class Panel extends JPanel {
    public src.main.Frame frame;
    private Dimension size;
    private Mouse mouse;
    private KeyBoard keyBoard;
    public Panel(Frame frame) {
        this.frame = frame;
        setSize();
        controller();
    }
    private void setSize() {
        size = new Dimension(1080 , 1080);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    private void controller() {
        mouse = new Mouse(frame);
        keyBoard = new KeyBoard(frame);
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        addKeyListener(keyBoard);
        requestFocus();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        frame.getRender().render(g);
    }

}
