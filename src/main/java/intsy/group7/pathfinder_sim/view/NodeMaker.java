package intsy.group7.pathfinder_sim.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

import intsy.group7.pathfinder_sim.model.Graph;

//use: manage map (location picker)
public class NodeMaker {
    //HashMap to store the label as the key and Point (X, Y)
    private static LinkedHashMap<String, Point> map;
    private static Color noRed = new Color(188, 24, 35);
    private static Color noGreen = new Color(0, 255, 0);
    private static Color noBlue = new Color(0, 0, 255);
    private static Color noYellow = new Color(255, 255, 0);
    private static Color noLightGray = new Color(74, 71, 71);
    private static Color noBlack = new Color(0, 0, 0);
    private static ArrayList<Boolean> eateryNodes = new ArrayList<>();

    //returns the vacant nodes as RoundedButton
    public static RoundedButton[] getButtons(Graph graph, String mode) {
        Point pointA;
        int x, y, i;
        RoundedButton[] roundButtons = new RoundedButton[86];
         
        for(i=0; i<roundButtons.length; i++) {
            
            pointA = new Point(graph.getNodes().get(i).getX_coord(), graph.getNodes().get(i).getY_coord());

            x = pointA.x;
            y = pointA.y;

            roundButtons[i] = new RoundedButton(graph.getNodes().get(i).getId());
            roundButtons[i].setFont(new Font("Helvetica", Font.BOLD, 10));
            roundButtons[i].setForeground(Color.WHITE);
            roundButtons[i].setBounds(x, y, 22, 22); 
            roundButtons[i].setOpaque(true); 
            roundButtons[i].setBorder(null);
            roundButtons[i].setContentAreaFilled(true); 
            roundButtons[i].setCustomBorderColor(Color.WHITE); 
            roundButtons[i].setCustomBorderThickness(2);

                
            if (mode.equalsIgnoreCase("EateryAndVacant")) {
                if (graph.getNodes().get(i).getState().equalsIgnoreCase("road")) {
                    roundButtons[i].setEnabled(false);
                    roundButtons[i].setVisible(false);
                }
                if (graph.getNodes().get(i).getState().equalsIgnoreCase("eatery")) {
                    roundButtons[i].setBackground(noYellow);
                    roundButtons[i].setEnabled(false);
                }
                if (graph.getNodes().get(i).getState().equalsIgnoreCase("vacant")) {
                    roundButtons[i].setBackground(noLightGray);
                }
            }
            else {            
                roundButtons[i].setBackground(noLightGray);
            }
            
            roundButtons[i].addActionListener(new ButtonClickListener());
        }

        return roundButtons;
    }
}
