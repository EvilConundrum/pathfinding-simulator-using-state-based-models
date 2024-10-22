package intsy.group7.pathfinder_sim.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import intsy.group7.pathfinder_sim.model.*;

public class LineDrawer {

    private static LineComponent line;
    private static List<LineComponent> lines = new ArrayList<>();

    public static void drawLines(JFrame frame, JLayeredPane pane, List<Node> node) {
        
        for (int i = 0; i < node.size() - 1; i++) {

            Point currentPoint = new Point(node.get(i).getX_coord(), node.get(i).getY_coord());
            Point nextPoint = new Point(node.get(i+1).getX_coord(), node.get(i+1).getY_coord());


            if (currentPoint != null && nextPoint != null) {
                line = new LineComponent(currentPoint.x, currentPoint.y, nextPoint.x, nextPoint.y);

                int minX = Math.min(currentPoint.x, nextPoint.x);
                int minY = Math.min(currentPoint.y, nextPoint.y);
                int width = Math.abs(nextPoint.x - currentPoint.x);
                int height = Math.abs(nextPoint.y - currentPoint.y);

                line.setBounds(minX, minY, width + 1, height + 1);
                pane.add(line, JLayeredPane.POPUP_LAYER);
                lines.add(line);
            }

        }

        frame.repaint();
    }

    public static LineComponent getLineComponent() {
        return line;
    }

    public static void removeLines(JLayeredPane pane) {
        for (LineComponent line : lines) {
            pane.remove(line);
        }
        lines.clear();
        pane.repaint();
    }

    public static class LineComponent extends JComponent {
        private final int x1, y1, x2, y2;

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
            int thickness = 5; // Set the desired thickness here
    
            g2d.setColor(Color.RED);
            g2d.setStroke(new BasicStroke(thickness));
    
            g2d.drawLine(x1 - getX(), y1 - getY(), x2 - getX(), y2 - getY());
        }
    }
}