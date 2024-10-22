package intsy.group7.pathfinder_sim.helper;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;

import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import intsy.group7.pathfinder_sim.model.*;
import intsy.group7.pathfinder_sim.view.RoundedButton;

import java.awt.Color;

public class Helper {
    public static Color noRed = new Color(188, 24, 35);
    public static Color noGreen = new Color(0, 255, 0);
    public static Color noBlue = new Color(0, 0, 255);
    public static Color noYellow = new Color(255, 255, 0);
    public static Color noGray = new Color(74, 71, 71);
    public static Color noBlack = new Color(0, 0, 0);


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

    public static void setNodeButtonMap(RoundedButton[] buttons, Graph graph, HashMap<Node, RoundedButton> map) {
        // Populate the HashMap with nodes and their corresponding buttons
        for (Node node : graph.getNodes()) {
            for (RoundedButton button : buttons) {
                if (button.getText().equals(node.getId())) {
                    map.put(node, button);
                    System.out.println("Node: " + node.getId() + " Button: " + button.getText());
                    break;
                }
            }
        }
    }
}
