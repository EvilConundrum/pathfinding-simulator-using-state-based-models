package intsy.group7.pathfinder_sim.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JFrame;

import intsy.group7.pathfinder_sim.algorithm.*;
import intsy.group7.pathfinder_sim.algorithm.result.Result;
import intsy.group7.pathfinder_sim.helper.Helper;
import intsy.group7.pathfinder_sim.model.*;
import intsy.group7.pathfinder_sim.view.asset.LineDrawer;
import intsy.group7.pathfinder_sim.view.asset.RoundedButton;
import intsy.group7.pathfinder_sim.view.subpage.PathFinderPage;

/**
 * PathFinderController controls interactions between the user and the pathfinding view.
 * It processes the user's choices and triggers the appropriate search algorithms.
 *
 * @author Sean Kyle Dimaunahan
 * @author Clive Jarel Ang
 */
public class PathFinderController implements ActionListener {

    private final Graph graph;
    private final PathFinderPage pathFinderPage;
    private final JFrame mainFrame;
    private final HashMap<Node, RoundedButton> nodeButtonMap;

    /**
     * Initializes the PathFinderController with the required components.
     *
     * @param graph         The Graph instance representing the map's nodes and edges.
     * @param pathFinderPage The PathFinderPage view instance for user interaction.
     * @param mainFrame     The main application frame containing the UI.
     * @param nodeButtonMap A map of Node objects to RoundedButton instances for easy button reference.
     */
    public PathFinderController(Graph graph, PathFinderPage pathFinderPage, JFrame mainFrame,
                                HashMap<Node, RoundedButton> nodeButtonMap) {
        this.graph = graph;
        this.pathFinderPage = pathFinderPage;
        this.mainFrame = mainFrame;
        this.nodeButtonMap = nodeButtonMap;

        setupPathFinderPage();
    }

    /**
     * Configures the PathFinderPage UI with algorithm options and locations, and sets up button listeners.
     */
    private void setupPathFinderPage() {
        String[] locations = graph.getEateryNodes();
        String[] algorithms = {"A*", "BFS", "DFS", "Greedy BFS", "UCS"};

        pathFinderPage.launchPathFinderPage(locations, algorithms);
        pathFinderPage.addClickListener(this);

        HashMap<String, RoundedButton> stringButtonMap = new HashMap<>();
        Helper.assignButtons(graph, pathFinderPage.getLayeredPane(), "PathFinder", nodeButtonMap, stringButtonMap);
        pathFinderPage.setStringButtonMap(stringButtonMap);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pathFinderPage.getSubmitButton()) {
            processPathfindingRequest();
        } else {
            throw new UnsupportedOperationException("Unsupported action: " + e.getSource());
        }
    }

    /**
     * Processes a pathfinding request based on user-selected algorithm, start, and goal nodes.
     */
    private void processPathfindingRequest() {
        clearPreviousPath();

        String from = pathFinderPage.fromDrop();
        String to = pathFinderPage.toDrop();
        String selectedAlgorithm = pathFinderPage.algoDrop();

        Node startNode = findNodeById(from);
        Node goalNode = findNodeById(to);

        if (startNode != null && goalNode != null) {
            Result pathfindingResult = executeAlgorithm(selectedAlgorithm, startNode, goalNode);
            displayPath(pathfindingResult, startNode, goalNode);
        }
    }

    /**
     * Finds a node in the graph by its ID.
     *
     * @param nodeId The ID of the node to find.
     * @return The corresponding Node object, or null if not found.
     */
    private Node findNodeById(String nodeId) {
        for (Node node : graph.getNodes()) {
            if (node.getId().equalsIgnoreCase(nodeId)) {
                return node;
            }
        }
        return null;
    }

    /**
     * Executes the specified pathfinding algorithm.
     *
     * @param algorithm The name of the algorithm to execute.
     * @param start     The start node for the pathfinding.
     * @param goal      The goal node for the pathfinding.
     * @return The Result object containing path, path cost, and traversal details.
     */
    private Result executeAlgorithm(String algorithm, Node start, Node goal) {
        Result result;

        switch (algorithm) {
            case "A*":
                result = AStarAlgorithm.AStar(start, goal);
                break;
            case "BFS":
                result = BFSAlgorithm.BFS(start, goal);
                break;
            case "DFS":
                result = DFSAlgorithm.DFS(start, goal);
                break;
            case "Greedy BFS":
                result = GBFSAlgorithm.GBFS(start, goal);
                break;
            case "UCS":
                result = UCSAlgorithm.UCS(start, goal);
                break;
            default:
                throw new UnsupportedOperationException("Unsupported algorithm: " + algorithm);
        }

        LineDrawer.drawLines(mainFrame, pathFinderPage.getLayeredPane(), result.getPath());
        return result;
    }

    /**
     * Clears any previously drawn path and resets button colors.
     */
    private void clearPreviousPath() {
        LineDrawer.removeLines(pathFinderPage.getLayeredPane());

        if (pathFinderPage.getPathText() != null) {
            pathFinderPage.getLayeredPane().remove(pathFinderPage.getPathCostLbl());
            pathFinderPage.getLayeredPane().remove(pathFinderPage.getTraversalText());
            pathFinderPage.getLayeredPane().remove(pathFinderPage.getPathText());
        }

        nodeButtonMap.values().forEach(button -> {
            if (button.getBackground() == Helper.NEON_BLUE) {
                button.setForeground(Helper.WHITE);
                button.setBackground(Helper.MAROON_RED); // Reset to default
            }
        });
    }

    /**
     * Displays the resulting path and updates the UI to highlight the path, start, and goal nodes.
     *
     * @param result     The Result object containing pathfinding details.
     * @param startNode  The starting node for the path.
     * @param goalNode   The goal node for the path.
     */
    private void displayPath(Result result, Node startNode, Node goalNode) {
        RoundedButton startButton = nodeButtonMap.get(startNode);
        RoundedButton goalButton = nodeButtonMap.get(goalNode);

        if (startButton != null) {
            startButton.setBackground(Helper.NEON_BLUE); // Highlight start node
        }
        if (goalButton != null) {
            goalButton.setBackground(Helper.NEON_BLUE); // Highlight goal node
        }

        pathFinderPage.addPathCost(result.getPathCost(), result.getStringTraversal(), result.getStringPath());
    }
}
