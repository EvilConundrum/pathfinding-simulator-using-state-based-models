package intsy.group7.pathfinder_sim.view.asset;

import javax.swing.*;
import java.awt.*;

/**
 * A JPanel with a solid color background and customizable size.
 * <p></p>
 * This panel can be used to represent a square area of any specified color and size.
 *
 * @author Jansen Sajeh Mortega
 */
public class SquarePanel extends JPanel {

    private final Color color;
    private final int size;

    /**
     * Initializes the SquarePanel with a specified color and size.
     *
     * @param color The color of the square.
     * @param size  The size of the square.
     */
    public SquarePanel(Color color, int size) {
        this.color = color;
        this.size = size;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, 0, size, size);
    }
}