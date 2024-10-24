package intsy.group7.pathfinder_sim.helper;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;

import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import java.awt.Component;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import intsy.group7.pathfinder_sim.controller.NodeMaker;
import intsy.group7.pathfinder_sim.model.*;
import intsy.group7.pathfinder_sim.view.RoundedButton;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;

public class Helper {
    public static Color cPureRed = new Color(255, 0, 0);
    public static Color cRed = new Color(188, 24, 35);
    public static Color cBlue = new Color(0, 0, 255);
    public static Color cRoyalBlue = new Color(30,61,151);
    public static Color cYellow = new Color(255, 255, 0);
    public static Color cGold = new Color(155,147,46);
    public static Color cGray = new Color(74, 71, 71);
    public static Color cBlack = new Color(0, 0, 0);
    public static Color cBlackLess = new Color(0, 0, 0, 100);    
    public static Color cWhite = new Color(255, 255, 255);
    public static Color cDirtyWhite = new Color(238, 238, 238);
    public static Color cGreenTHA = new Color(0, 105, 55);
    public static Color cGreenText = new Color(5, 65, 3);
    public static Color cGreenTHA2 = new Color(0, 112, 60);

    public static Dimension screenSize = new Dimension(1280, 720);
    public static ImageIcon mapImage = new ImageIcon("src/main/java/intsy/group7/pathfinder_sim/view/images/MapDLSU.png");


    public static String sampleText = "     Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";

    public static void updateNumberFieldFormatter(JFormattedTextField field, int min, int max, Class<?> valueClass) {
        NumberFormatter numberFormatter = createNumberFormatter(min, max, valueClass);
        field.setFormatterFactory(new DefaultFormatterFactory(numberFormatter));
    }

    public static NumberFormatter createNumberFormatter(int minNum, int maxNum, Class<?> valueClass) {
        NumberFormat format = NumberFormat.getInstance(); // Step 1: Create a NumberFormat instance
        format.setGroupingUsed(false); // Disable comma grouping

        NumberFormatter numberFormatter = new NumberFormatter(format) { 
            @Override
            public Object stringToValue(String string) throws ParseException {
                if (string == null || string.trim().isEmpty()) {
                    return null; // Return null for empty input
                }
                return super.stringToValue(string);
            }
        };
        numberFormatter.setValueClass(valueClass);
        numberFormatter.setMinimum(minNum); // Minimum value
        numberFormatter.setMaximum(maxNum); // Maximum value
        numberFormatter.setAllowsInvalid(false); // Don't allow invalid values

        return numberFormatter;
    }

    public static void setNodeButtonMap(RoundedButton[] buttons, Graph graph, HashMap<Node, RoundedButton> map, 
                                        HashMap<String, RoundedButton> stringButtonMap, String mode) {
        // Populate the HashMap with nodes and their corresponding buttons
        for (Node node : graph.getNodes()) {
            for (RoundedButton button : buttons) {
                if (button.getText().equals(node.getId())) {
                    map.put(node, button);
                    if (mode.equalsIgnoreCase("PathFinder"));
                        stringButtonMap.put(node.getId(), button);
                    System.out.println("Node: " + node.getId() + " Button: " + button.getText());
                    break;
                }
            }
        }
    }

    public static void assignButtons(RoundedButton[] buttons, Graph graph, JLayeredPane layeredPane, 
                                     String mode, HashMap<Node, RoundedButton> nodeButtonMap, 
                                     HashMap<String, RoundedButton> stringButtonMap) {

        // Revalidate and repaint the layeredPane to reflect the changes
        layeredPane.revalidate();
        layeredPane.repaint();

        buttons = NodeMaker.getButtons(graph, mode);
        for (RoundedButton button : buttons) {
            layeredPane.add(button, JLayeredPane.POPUP_LAYER);
        }

        if (nodeButtonMap != null) 
            nodeButtonMap.clear();
        
        setNodeButtonMap(buttons, graph, nodeButtonMap, stringButtonMap, mode);

    }

    public static double calcDist(Node origin, Node destination) {
        int origin_x = origin.getX_coord();
        int origin_y = origin.getY_coord();
        int destination_x = destination.getX_coord();
        int destination_y = destination.getY_coord();
        double result = Math.sqrt(Math.pow((destination_x - origin_x),2) + Math.pow((destination_y-origin_y),2));
        return result;
    }
}
