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

    public String getStringPath() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            Node node = path.get(i);
            sb.append(node.getId());
            if (i < path.size() - 1) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }
    
    public String getStringTraversal() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < traversal.size(); i++) {
            Node node = traversal.get(i);
            sb.append(node.getId());
            if (i < traversal.size() - 1) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }

}