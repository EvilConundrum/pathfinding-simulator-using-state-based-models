package intsy.group7.pathfinder_sim.algorithm;

import java.util.LinkedList;
import java.util.List;

import intsy.group7.pathfinder_sim.model.Node;

public class Result {
    private final LinkedList<Node> path;
    private final List<Node> traversal;

    public Result(LinkedList<Node> path, List<Node> traversal) {
        this.path = path;
        this.traversal = traversal;
    }

    public LinkedList<Node> getPath() {
        return path;
    }

    public List<Node> getTraversal() {
        return traversal;
    }
}