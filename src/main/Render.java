package src.main;

import java.awt.*;

public class Render {
    private Frame frame;
    public Render(Frame frame) {
        this.frame = frame;
    }
    public void render(Graphics g) {
        switch (State.state) {
            case PLAYING ->frame.getPlaying().render(g);
        }

    }

}
