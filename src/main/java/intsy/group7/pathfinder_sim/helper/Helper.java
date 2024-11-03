package intsy.group7.pathfinder_sim.helper;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.Dimension;

import intsy.group7.pathfinder_sim.controller.NodeMaker;
import intsy.group7.pathfinder_sim.model.*;
import intsy.group7.pathfinder_sim.view.asset.RoundedButton;

/**
 * Utility class providing helper methods and constants for the Pathfinder Simulator application.
 *
 * @author Sean Kyle Dimaunahan
 */
public class Helper {
    public static Color BLOOD_RED = new Color(255, 0, 0);
    public static Color MAROON_RED = new Color(188, 24, 35);
    public static Color NEON_BLUE = new Color(0, 0, 255);
    public static Color NEON_YELLOW = new Color(255, 255, 0);
    public static Color LIGHT_GRAY = new Color(74, 71, 71);
    public static Color BLACK = new Color(0, 0, 0);
    public static Color DARK_GRAY = new Color(0, 0, 0, 100);
    public static Color WHITE = new Color(255, 255, 255);
    public static Color DIRTY_WHITE = new Color(238, 238, 238);
    public static Color GREEN_PRIMARY = new Color(0, 105, 55);
    public static Color GREEN_TEXT = new Color(5, 65, 3);
    public static Color GREEN_ACCENT = new Color(0, 112, 60);

    public static Dimension SCREEN_SIZE = new Dimension(1280, 720);
    private static final String IMAGE_FOLDER_PATH = "src/main/resources/images/";
    public static ImageIcon MAP_IMAGE = new ImageIcon(IMAGE_FOLDER_PATH + "MapDLSU.png");

    public static String SAMPLE_TEXT = "     Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod " +
            "tempor incididunt ut labore et dolore magna aliqua. Lorem ipsum dolor sit amet, consectetur adipiscing " +
            "elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Lorem ipsum dolor sit amet, " +
            "consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Lorem " +
            "ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore " +
            "magna aliqua. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt " +
            "ut labore et dolore magna aliqua. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod " +
            "tempor incididunt ut labore et dolore magna aliqua. Lorem ipsum dolor sit amet, consectetur adipiscing " +
            "elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Lorem ipsum dolor sit amet, " +
            "consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Lorem " +
            "ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore " +
            "magna aliqua. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt " +
            "ut labore et dolore magna aliqua. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod " +
            "tempor incididunt ut labore et dolore magna aliqua. Lorem ipsum dolor sit amet, consectetur adipiscing " +
            "elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Lorem ipsum dolor sit amet, " +
            "consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Lorem " +
            "ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore " +
            "magna aliqua. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt " +
            "ut labore et dolore magna aliqua. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod " +
            "tempor incididunt ut labore et dolore magna aliqua.";

    /**
     * Configures a JFormattedTextField to accept only numeric input within a specified range.
     *
     * @param field       the JFormattedTextField to be formatted
     * @param min         minimum value allowed
     * @param max         maximum value allowed
     * @param valueClass  class type for the field value (e.g., Integer, Double)
     */
    public static void updateNumberFieldFormatter(JFormattedTextField field, int min, int max, Class<?> valueClass) {
        NumberFormatter numberFormatter = createNumberFormatter(min, max, valueClass);
        field.setFormatterFactory(new DefaultFormatterFactory(numberFormatter));
    }

    /**
     * Creates a NumberFormatter that restricts input to a specified numeric range.
     *
     * @param minNum      minimum value allowed
     * @param maxNum      maximum value allowed
     * @param valueClass  class type for the field value (e.g., Integer, Double)
     * @return            configured NumberFormatter
     */
    public static NumberFormatter createNumberFormatter(int minNum, int maxNum, Class<?> valueClass) {
        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(false);

        NumberFormatter numberFormatter = new NumberFormatter(format) {
            @Override
            public Object stringToValue(String string) throws ParseException {
                if (string == null || string.trim().isEmpty()) {
                    return null;
                }
                return super.stringToValue(string);
            }
        };

        numberFormatter.setValueClass(valueClass);
        numberFormatter.setMinimum(minNum);
        numberFormatter.setMaximum(maxNum);
        numberFormatter.setAllowsInvalid(false);

        return numberFormatter;
    }

    /**
     * Populates the specified HashMaps with nodes and their corresponding buttons for the given mode.
     *
     * @param buttons         array of RoundedButtons representing nodes
     * @param graph           the Graph containing nodes
     * @param nodeButtonMap   map linking Nodes to their RoundedButtons
     * @param stringButtonMap map linking node IDs to RoundedButtons (only in "PathFinder" mode)
     * @param mode            operation mode, e.g., "PathFinder"
     */
    public static void setNodeButtonMap(RoundedButton[] buttons, Graph graph,
                                        HashMap<Node, RoundedButton> nodeButtonMap,
                                        HashMap<String, RoundedButton> stringButtonMap, String mode) {
        for (Node node : graph.getNodes()) {
            for (RoundedButton button : buttons) {
                if (button.getText().equals(node.getId())) {
                    nodeButtonMap.put(node, button);
                    if ("PathFinder".equalsIgnoreCase(mode)) {
                        stringButtonMap.put(node.getId(), button);
                    }
                    break;
                }
            }
        }
    }

    /**
     * Assigns RoundedButton nodes to a layered pane and updates button mappings.
     *
     * @param graph            the Graph containing nodes
     * @param layeredPane      the JLayeredPane to add buttons to
     * @param mode             operation mode, e.g., "PathFinder"
     * @param nodeButtonMap    map linking Nodes to their RoundedButtons
     * @param stringButtonMap  map linking node IDs to RoundedButtons
     */
    public static void assignButtons(Graph graph, JLayeredPane layeredPane,
                                     String mode, HashMap<Node, RoundedButton> nodeButtonMap,
                                     HashMap<String, RoundedButton> stringButtonMap) {

        layeredPane.revalidate();
        layeredPane.repaint();

        RoundedButton[] buttons = NodeMaker.getButtons(graph, mode);
        for (RoundedButton button : buttons) {
            layeredPane.add(button, JLayeredPane.POPUP_LAYER);
        }

        // if (nodeButtonMap != null) {
        //     nodeButtonMap.clear();
        // }

        setNodeButtonMap(buttons, graph, nodeButtonMap, stringButtonMap, mode);
    }

    /**
     * Calculates the Euclidean distance between two nodes based on their coordinates.
     *
     * @param origin       the starting Node
     * @param destination  the destination Node
     * @return             distance between origin and destination as a double
     */
    public static double calcDist(Node origin, Node destination) {
        int originX = origin.getXCoord();
        int originY = origin.getYCoord();
        int destinationX = destination.getXCoord();
        int destinationY = destination.getYCoord();
        return Math.sqrt(Math.pow(destinationX - originX, 2) + Math.pow(destinationY - originY, 2));
    }

    
}