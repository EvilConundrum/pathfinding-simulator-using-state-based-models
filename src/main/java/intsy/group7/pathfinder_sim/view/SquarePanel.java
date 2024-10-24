package intsy.group7.pathfinder_sim.view;

import javax.swing.*;
import java.awt.*;

public class SquarePanel extends JPanel {

    private int size;
    private Color color;

    public SquarePanel(Color color, int size) {
        this.color = color;
        this.size = size;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Set the color for the square
        g.setColor(color);
        g.fillRect(0, 0, size, size);
    }
}