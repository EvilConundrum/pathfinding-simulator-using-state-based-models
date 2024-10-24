package intsy.group7.pathfinder_sim.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import intsy.group7.pathfinder_sim.model.Graph;
import intsy.group7.pathfinder_sim.view.RoundedButton;
import intsy.group7.pathfinder_sim.helper.Helper;

public class NodeMaker {


    private static RoundedButton currentClickedButton = null;
    private static RoundedButton lastClickedButton = null;

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
            roundButtons[i].setForeground(Helper.cWhite);
            roundButtons[i].setBounds(x, y, 22, 22); 
            roundButtons[i].setOpaque(true); 
            roundButtons[i].setBorder(null);
            roundButtons[i].setContentAreaFilled(true); 
            roundButtons[i].setCustomBorderColor(Helper.cWhite); 
            roundButtons[i].setCustomBorderThickness(2);

                
            if (mode.equalsIgnoreCase("ManageMap")) {
                if (graph.getNodes().get(i).getState().equalsIgnoreCase("road")) {
                    roundButtons[i].setEnabled(false);
                    roundButtons[i].setVisible(true);
                    roundButtons[i].setOpaque(false);
                    roundButtons[i].setBackground(new Color(74, 71, 71, 100)); // Example: 50% opacity (128 out of 255)
                    roundButtons[i].setCustomBorderColor(new Color (255, 255, 255, 100)); // Example: 50% opacity (128 out of 255) 
                
                }
                if (graph.getNodes().get(i).getState().equalsIgnoreCase("eatery")) {
                    roundButtons[i].setBackground(Color.YELLOW);
                    roundButtons[i].setEnabled(false);
                }
                if (graph.getNodes().get(i).getState().equalsIgnoreCase("vacant")) {
                    roundButtons[i].setBackground(Helper.cGray);
                }
            }
            else {            
                roundButtons[i].setBackground(Helper.cGray);
            }

            if (mode.equalsIgnoreCase("PathFinder")) {
                if (graph.getNodes().get(i).getState().equalsIgnoreCase("road")) {
                    roundButtons[i].setBackground(Color.BLACK);
                    roundButtons[i].setEnabled(false);
                }
                if (graph.getNodes().get(i).getState().equalsIgnoreCase("eatery")) {
                    roundButtons[i].setBackground(Color.YELLOW);
                    roundButtons[i].setEnabled(false);
                }
                if (graph.getNodes().get(i).getState().equalsIgnoreCase("vacant")) {
                    roundButtons[i].setBackground(Color.BLUE);
                    roundButtons[i].setEnabled(false);
                }
            }
            
            roundButtons[i].addActionListener(new ButtonClickListener());
        }

        return roundButtons;
    }

    public static RoundedButton getClickedButton() {
        return currentClickedButton;
    }
    
    public static void changeButtonColor() {
        if (currentClickedButton != null) {
            currentClickedButton.setBackground(Helper.cGray);
        }
    }

    static class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentClickedButton = (RoundedButton) e.getSource();

            // Reset the color of the last clicked button
            if (lastClickedButton != null && lastClickedButton.getBackground() != Color.YELLOW) {
                lastClickedButton.setBackground(Helper.cGray);
            }            
            currentClickedButton.setBackground(Color.GREEN); // Set the color of the currently clicked button to green
            lastClickedButton = currentClickedButton; // Update the last clicked button reference            


            System.out.println("Button " + currentClickedButton.getText() + " clicked."); // DEBUGGING

        }
    }

}
