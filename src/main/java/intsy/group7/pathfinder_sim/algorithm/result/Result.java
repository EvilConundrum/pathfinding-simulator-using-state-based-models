package intsy.group7.pathfinder_sim.algorithm.result;

import java.util.List;
import static intsy.group7.pathfinder_sim.algorithm.result.PathCostCalculator.calculateTotalCost;
import intsy.group7.pathfinder_sim.model.Node;

/**
 * The Result class represents the outcome of a pathfinding algorithm,
 * encapsulating the path and traversal order, along with the total path cost.
 *
 * @author Jaztin Jimenez
 * @author Sean Kyle Dimaunahan
 */
public class Result {

    private final List<Node> path;           // List of nodes representing the path from start to goal
    private final List<Node> traversal;      // List of nodes representing the traversal order
    private final int pathCost;              // Total cost of the path

    /**
     * Constructs a Result object.
     * Calculates the path cost using the provided path list.
     *
     * @param path       the list of nodes representing the path from start to goal
     * @param traversal  the list of nodes representing the traversal order
     */
    public Result(List<Node> path, List<Node> traversal) {
        this.path = path;
        this.traversal = traversal;
        this.pathCost = calculateTotalCost(path);
    }

    /**
     * Gets the list of nodes in the path.
     *
     * @return a list of nodes representing the path from start to goal
     */
    public List<Node> getPath() {
        return path;
    }

    /**
     * Gets the total cost of the path.
     *
     * @return the total path cost calculated by summing edge weights in the path
     */
    public int getPathCost() {
        return pathCost;
    }

    /**
     * Generates a string representation of the path.
     * Each node's ID is separated by " > ", with a new line every 10 nodes.
     *
     * @return a formatted string representing the path
     */
    public String getStringPath() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int nodeIndex = 0; nodeIndex < path.size(); nodeIndex++) {
            Node node = path.get(nodeIndex);
            stringBuilder.append(node.getId());
            if (nodeIndex < path.size() - 1) {
                stringBuilder.append(" > ");
            }
            if (nodeIndex > 0 && nodeIndex % 10 == 0) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Generates a string representation of the traversal order.
     * Each node's ID is separated by " > ", with a new line every 16 nodes.
     *
     * @return a formatted string representing the traversal order
     */
    public String getStringTraversal() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int nodeIndex = 0; nodeIndex < traversal.size(); nodeIndex++) {
            Node node = traversal.get(nodeIndex);
            stringBuilder.append(node.getId());
            if (nodeIndex < traversal.size() - 1) {
                stringBuilder.append(" > ");
            }
            if (nodeIndex > 0 && nodeIndex % 16 == 0) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
