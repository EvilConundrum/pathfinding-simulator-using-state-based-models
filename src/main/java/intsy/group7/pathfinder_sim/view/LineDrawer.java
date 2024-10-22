package intsy.group7.pathfinder_sim.view;

import javax.swing.*;
import java.awt.*;

import java.util.LinkedList;

import intsy.group7.pathfinder_sim.model.*;


public class LineDrawer {
    
    // public static void drawLines(JFrame frame, JLayeredPane pane, HashMap<String, Point> nodeCoordinates, String nodePath) {

    //     for (int i = 0; i < nodePath.length() - 1; i++) {
    //         String currentNode = String.valueOf(nodePath.charAt(i));
    //         String nextNode = String.valueOf(nodePath.charAt(i + 1));
            
    //         Point currentPoint = nodeCoordinates.get(currentNode);
    //         Point nextPoint = nodeCoordinates.get(nextNode);
            
    //         if (currentPoint != null && nextPoint != null) {
    //             LineComponent line = new LineComponent(currentPoint.x, currentPoint.y, nextPoint.x, nextPoint.y);
    //             line.setForeground(Color.RED); 
    //             pane.add(line, JLayeredPane.POPUP_LAYER);
    //         }
    //     }
        
    //     frame.repaint();
    // }

    public static void drawLines(JFrame frame, JLayeredPane pane, Graph graph, LinkedList<Node> path) {

        for (int i = 0; i < path.size()-1; i++) {
            // String currentNode = String.valueOf(nodePath.charAt(i));
            // String nextNode = String.valueOf(nodePath.charAt(i + 1));
            
            // Point currentPoint = nodeCoordinates.get(currentNode);
            // Point nextPoint = nodeCoordinates.get(nextNode);
            
            // if (currentPoint != null && nextPoint != null) {
                LineComponent line = new LineComponent(path.get(i).getX_coord(), path.get(i).getY_coord(), 
                                                       path.get(i + 1).getX_coord(), path.get(i + 1).getY_coord());
                line.setForeground(Color.RED); 
                pane.add(line, JLayeredPane.DRAG_LAYER);
            // }
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
            int thickness = 2; 

            g.setColor(Color.RED);

            for (int i = 0; i < thickness; i++) {
                g.drawLine(x1 - getX() - i, y1 - getY() - i, x2 - getX() - i, y2 - getY() - i);
                g.drawLine(x1 - getX() + i, y1 - getY() + i, x2 - getX() + i, y2 - getY() + i);
            }        
        }
    }
}
