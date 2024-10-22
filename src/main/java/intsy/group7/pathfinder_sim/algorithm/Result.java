package intsy.group7.pathfinder_sim.algorithm;

import java.util.List;

import static intsy.group7.pathfinder_sim.algorithm.PathCostCalculator.calculateTotalCost;
import intsy.group7.pathfinder_sim.model.Node;

public class Result {
    private final List<Node> path;
    private final List<Node> traversal;
    private final int pathCost;

    public Result(List<Node> path, List<Node> traversal) {
        this.path = path;
        this.traversal = traversal;
        this.pathCost = calculateTotalCost(path);
    }

    public List<Node> getPath() {
        return path;
    }

    public List<Node> getTraversal() {
        return traversal;
    }

    public int getPathCost() {
        return pathCost;
    }
}