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
    private static final String IMAGE_PATH = "/images/MapDLSU.png";
    public static ImageIcon MAP_IMAGE = new ImageIcon(Helper.class.getResource(IMAGE_PATH));

    public static String VIEWALGO_INFO =
        "In The Bow and Bite Map, we use a set of powerful algorithms to find the best routes through various eateries: A*, Greedy Best-First Search (Greedy BFS), Breadth-First Search (BFS), Depth-First Search (DFS), and Uniform Cost Search (UCS). Each algorithm brings a unique approach to navigating the map and offers different advantages based on your needs.<br><br>" +
        
        "<b>A* (A-Star)</b> is a widely used algorithm for finding the shortest path by combining the cost from the start node to the current node and an estimated cost from the current node to the goal. This heuristic-based approach makes A* optimal and complete, meaning it always finds the shortest path if one exists. The time complexity of A* is O(bᵈ), where b is the branching factor and d is the depth of the solution. A* performs well for most scenarios in our app, as it efficiently balances speed and accuracy by estimating foot traffic as part of its heuristic.<br><br>" +
        
        "<b>Greedy Best-First Search (Greedy BFS)</b> focuses purely on the estimated distance to the goal node without considering the cost so far, making it fast but not always optimal. With a time complexity of O(bᵐ) (where m is the maximum depth), Greedy BFS may find quick routes but isn't guaranteed to provide the shortest one. In The Bow and Bite Map, Greedy BFS offers a solution for users who prioritize speed over precision, potentially bypassing crowded areas swiftly by leveraging our foot traffic heuristic.<br><br>" +
        
        "<b>Breadth-First Search (BFS)</b> explores nodes layer by layer from the start node, ensuring that it finds the shortest path in an unweighted graph. However, BFS can be memory-intensive, with a time complexity of O(bᵈ). It is useful for shorter routes or smaller maps where accuracy is key, as it examines each node systematically.<br><br>" +
        
        "<b>Depth-First Search (DFS)</b>, unlike BFS, delves deep into a path before backtracking. While it has a similar time complexity of O(bᵈ), DFS is not guaranteed to find the shortest path but is memory efficient. DFS is useful in exploring specific paths in detail, making it suitable for users interested in discovering routes without prioritizing shortest distances.<br><br>" +

        "<b>Uniform Cost Search (UCS)</b> expands the least costly path, making it optimal for finding the shortest route in weighted graphs. Its time complexity is O(b^(C*/ϵ)), where C* is the cost of the optimal solution, and ϵ is the smallest step cost. UCS is particularly effective when paths have varying costs, such as those impacted by different levels of foot traffic.<br><br>" +
        
        "Each algorithm in The Bow and Bite Map has its strengths, balancing between speed, memory efficiency, and accuracy. By offering a choice among these methods, the app provides users with flexibility for planning routes tailored to their priorities, whether they're looking for the quickest route, the least crowded, or the shortest path possible.";

        public static String ABOUT_INFO = "Welcome to The Bow and Bite Map, a pathfinding app that turns your food cravings into an efficient adventure! " +
            "Our app combines advanced algorithms—A*, Greedy Best-First Search (BFS), Breadth-First Search (BFS), " +
            "Depth-First Search (DFS), and Uniform Cost Search (UCS)—to map out the quickest and most efficient routes to " +
            "nearby eateries. We use real-time foot traffic data as our heuristic, helping you avoid crowded paths and " +
            "enjoy a smooth journey to your favorite meals.<br><br>" +
        
            "When you open The Bow and Bite Map, you’re not just browsing a list of restaurants. You’re setting out on a " +
            "curated path, where each route is optimized to save time and bring ease to your day. Simply choose an eatery " +
            "as your starting point and another as your goal, and let our algorithms do the rest! If you're feeling " +
            "adventurous, you can select different algorithms to see how each approach finds paths uniquely suited to your " +
            "needs.<br><br>" +
        
            "But The Bow and Bite Map isn’t limited to pre-set locations. We’ve designed the app to be dynamic, allowing " +
            "you to add new eateries or create unique paths between existing ones. Maybe a new café popped up on the " +
            "corner, or perhaps a favorite bistro has a shortcut you want to document. You can easily add new nodes and " +
            "connect them, expanding the map in a way that reflects your own food discoveries.<br><br>" +
        
            "We’ve also included a vacancy feature—so if an eatery is temporarily closed, you can mark it as vacant, " +
            "helping other users find open locations without detours. The Bow and Bite Map adapts to you, whether you’re " +
            "avoiding busy spots or uncovering hidden gems. So, why settle for random suggestions or crowded pathways? " +
            "Chart your own culinary course with The Bow and Bite Map and make each meal a carefully mapped experience!<br><br>" +
        
            "<b>Authors:</b><br>" +
            "&emsp;Ang, Clive Jarel<br>" +
            "&emsp;Balcita, Vienn Rowen<br>" +
            "&emsp;Dimaunahan, Sean Kyle<br>" +
            "&emsp;Mortega, Jansen Sajeh<br>" +
            "&emsp;Jimenez, Jaztin Jacob";



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