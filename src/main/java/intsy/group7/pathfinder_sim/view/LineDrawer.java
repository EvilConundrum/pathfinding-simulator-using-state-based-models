package intsy.group7.pathfinder_sim.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import intsy.group7.pathfinder_sim.model.*;

public class LineDrawer {

    public static void drawLines(JFrame frame, JLayeredPane pane, List<Node> node) {
        
        for (int i = 0; i < node.size() - 1; i++) {

            Point currentPoint = new Point(node.get(i).getX_coord(), node.get(i).getY_coord());
            Point nextPoint = new Point(node.get(i+1).getX_coord(), node.get(i+1).getY_coord());


            if (currentPoint != null && nextPoint != null) {
                LineComponent line = new LineComponent(currentPoint.x, currentPoint.y, nextPoint.x, nextPoint.y);

                int minX = Math.min(currentPoint.x, nextPoint.x);
                int minY = Math.min(currentPoint.y, nextPoint.y);
                int width = Math.abs(nextPoint.x - currentPoint.x);
                int height = Math.abs(nextPoint.y - currentPoint.y);

                line.setBounds(minX, minY, width + 1, height + 1);
                pane.add(line, JLayeredPane.POPUP_LAYER);
            }
        }

        frame.repaint();
    }

    static class LineComponent extends JComponent {
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
            int thickness = 4; 

            g.setColor(Color.RED);



            for (int i = 0; i < thickness; i++) {
                
                g.drawLine(x1 - getX() - i, y1 - getY() - i, x2 - getX() - i, y2 - getY() - i);
                g.drawLine(x1 - getX() + i, y1 - getY() + i, x2 - getX() + i, y2 - getY() + i);
            }        
        }
    }
}