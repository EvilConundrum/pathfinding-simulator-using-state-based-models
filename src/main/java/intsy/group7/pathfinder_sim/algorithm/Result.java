package intsy.group7.pathfinder_sim.algorithm;

import java.util.List;

import intsy.group7.pathfinder_sim.model.Node;

public class Result {
    private final List<Node> path;
    private final List<Node> traversal;

    public Result(List<Node> path, List<Node> traversal) {
        this.path = path;
        this.traversal = traversal;
    }

    public List<Node> getPath() {
        return path;
    }

    public List<Node> getTraversal() {
        return traversal;
    }
}