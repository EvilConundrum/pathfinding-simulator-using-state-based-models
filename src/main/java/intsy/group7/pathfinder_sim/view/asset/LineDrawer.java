package intsy.group7.pathfinder_sim.view.asset;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import intsy.group7.pathfinder_sim.model.*;

/**
 * Utility class for drawing and removing lines between nodes on a JLayeredPane.
 * <p></p>
 * This class utilizes a list of LineComponent objects to represent lines between points.
 * Lines are drawn between nodes based on their coordinates and added to a specified pane.
 *
 * @author Jansen Sajeh Mortega
 * @author Sean Kyle Dimaunahan
 */
public class LineDrawer {

    private static final List<LineComponent> lines = new ArrayList<>();

    /**
     * Draws lines connecting a list of nodes and adds them to the specified pane.
     *
     * @param frame The JFrame containing the pane.
     * @param pane  The JLayeredPane to add lines.
     * @param nodes The list of nodes to connect with lines.
     */
    public static void drawLines(JFrame frame, JLayeredPane pane, List<Node> nodes) {
        for (int i = 0; i < nodes.size() - 1; i++) {
            Point currentPoint = new Point(nodes.get(i).getXCoord() + 10, nodes.get(i).getYCoord() + 8);
            Point nextPoint = new Point(nodes.get(i + 1).getXCoord() + 10, nodes.get(i + 1).getYCoord() + 8);
            LineComponent line = new LineComponent(currentPoint.x, currentPoint.y, nextPoint.x, nextPoint.y);

            int minX = Math.min(currentPoint.x, nextPoint.x);
            int minY = Math.min(currentPoint.y, nextPoint.y);
            int width = Math.abs(nextPoint.x - currentPoint.x);
            int height = Math.abs(nextPoint.y - currentPoint.y);

            line.setBounds(minX, minY, width + 10, height + 10);
            pane.add(line, JLayeredPane.POPUP_LAYER);
            lines.add(line);
        }
        frame.repaint();
    }

    /**
     * Removes all drawn lines from the specified pane.
     *
     * @param pane The JLayeredPane to remove lines from.
     */
    public static void removeLines(JLayeredPane pane) {
        for (LineComponent line : lines) {
            pane.remove(line);
        }
        lines.clear();
        pane.repaint();
    }

    /**
     * A custom JComponent that represents a line with specified start and end coordinates.
     * <p></p>
     * This component is used for drawing lines between points in the LineDrawer class.
     */
    public static class LineComponent extends JComponent {
        private final int x1, y1, x2, y2;

        /**
         * Initializes the LineComponent with start and end coordinates.
         *
         * @param x1 Starting x-coordinate.
         * @param y1 Starting y-coordinate.
         * @param x2 Ending x-coordinate.
         * @param y2 Ending y-coordinate.
         */
        public LineComponent(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.RED);
            g2d.setStroke(new BasicStroke(8, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
            g2d.drawLine(x1 - getX(), y1 - getY(), x2 - getX(), y2 - getY());
        }
    }
}