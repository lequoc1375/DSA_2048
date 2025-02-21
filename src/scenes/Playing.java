package src.scenes;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Playing implements SceneMethods {
    private Frame frame;
    private Rectangle menuButton, recordButton;

    public Playing(Frame frame) {
        this.frame = frame;

        // Xác định vị trí hai nút
        menuButton = new Rectangle(20, 20, 120, 50);      // Nút Menu
        recordButton = new Rectangle(940, 20, 120, 50);   // Nút Record
    }

    @Override
    public void render(Graphics g) {
        // Nút Menu
        g.setColor(Color.GRAY);
        g.fillRect(menuButton.x, menuButton.y, menuButton.width, menuButton.height);
        g.setColor(Color.WHITE);
        g.drawString("Menu", menuButton.x + 40, menuButton.y + 30);

        // Nút Record
        g.setColor(Color.GRAY);
        g.fillRect(recordButton.x, recordButton.y, recordButton.width, recordButton.height);
        g.setColor(Color.WHITE);
        g.drawString("Record", recordButton.x + 40, recordButton.y + 30);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (menuButton.contains(x, y)) {
            System.out.println("Menu clicked!");
        }
        if (recordButton.contains(x, y)) {
            System.out.println("Record clicked!");
        }
    }

    @Override
    public void mouseMoved(int x, int y) {}

    @Override
    public void mousePressed(int x, int y) {}

    @Override
    public void mouseReleased(int x, int y) {}

    @Override
    public void mouseDragged(int x, int y) {}
}
