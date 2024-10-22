package intsy.group7.pathfinder_sim.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import intsy.group7.pathfinder_sim.model.Edge;
import intsy.group7.pathfinder_sim.model.Graph;
import intsy.group7.pathfinder_sim.model.Node;

public class BFSAlgorithm {

    /**
     * The algorithm implementation for BFS Pathfinding algorithm
     * 
     * @author Jaztin Jimenez
     * @return the path of the BFS algorithm or null if path is not found
     */
    public static Result bfs (Graph graph, Node start, Node goal) {
        Queue<Node> queue = new LinkedList<>(); // Queue implementation for BFS Traversal
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> parent = new HashMap<>();
        List<Node> traversal = new LinkedList<>(); // List of traversed nodes

        queue.add(start);
        visited.add(start);
        parent.put(start, null);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            traversal.add(node);  // Track traversal

            if (node.equals(goal)) { // If goal node is found, construct the path for the BFS path output
                LinkedList<Node> path = reconstructPath(parent, goal);
                return new Result(path, traversal);  // Return both path and traversal
            }

            for (Edge edge : node.getEdges()) { // Goes through every child node of the parent node
                Node neighbor = edge.getDestination();
                if (!visited.contains(neighbor)) { // Skips the node if the node is already visited
                    queue.add(neighbor);
                    visited.add(neighbor);
                    parent.put(neighbor, node);
                }
            }
        }
    
        return new Result(null, traversal);  // Return both path and traversal
    
}

    /**
     * Function to return the list of nodes that shows the path of the BFS algorithm
     * 
     * @author Jaztin Jimenez
     * @return list of nodes that shows the path of the BFS algorithm
     */
    private static LinkedList<Node> reconstructPath(Map<Node, Node> parent, Node goal) {
        LinkedList<Node> path = new LinkedList<>();
        for (Node node = goal; node != null; node = parent.get(node)) { // constructs the path until the goal is reached
            path.add(0, node);
        }
        return path;
    }
}