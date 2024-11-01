package intsy.group7.pathfinder_sim.view;

import javax.swing.*;
import java.awt.*;

public class SquarePanel extends JPanel {

    private final int size;
    private final Color color;

    public SquarePanel(Color color, int size) {
        this.color = color;
        this.size = size;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Set the color for the square
        g.setColor(color);
        g.fillRect(size, size, size, size);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new intsy.group7.pathfinder_sim.view.asset.SquarePanel(Color.RED, 50));
        frame.setVisible(true);
    }
}