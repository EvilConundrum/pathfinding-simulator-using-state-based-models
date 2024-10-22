package intsy.group7.pathfinder_sim.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import intsy.group7.pathfinder_sim.model.Edge;
import intsy.group7.pathfinder_sim.model.Graph;
import intsy.group7.pathfinder_sim.model.Node;

public class DFSAlgorithm {
        
    /**
     * The algorithm implementation for DFS Pathfinding algorithm
     * 
     * @author Jaztin Jimenez
     * @return the path of the DFS algorithm or null if path is not found
     */
    public static Result dfs (Graph graph, Node start, Node goal) {
        Stack<Node> stack = new Stack<>(); // Stack implementation for DFS Traversal
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> parent = new HashMap<>();
        List<Node> traversal = new LinkedList<>(); // List of traversed nodes

        stack.push(start);
        visited.add(start);
        parent.put(start, null);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            traversal.add(node);  // Track traversal

            if (node.equals(goal)) { // if goal node is found, construct the path for the DFS path output
                List<Node> path = reconstructPath(parent, goal);
                return new Result(path, traversal);  // Return both path and traversal
            }

            for (Edge edge : node.getEdges()) {  // Goes through every child node of the parent node
                Node neighbor = edge.getDestination();
                if (!visited.contains(neighbor)) {  // Skips the node if the node is already visited
                    stack.push(neighbor);
                    visited.add(neighbor);
                    parent.put(neighbor, node);
                }
            }
        }
        
        return new Result(null, traversal); // No path found
    }

    /**
     * Function to return the list of nodes that shows the path of the DFS algorithm
     * 
     * @author Jaztin Jimenez
     * @return list of nodes that shows the path of the DFS algorithm
     */
    private static List<Node> reconstructPath(Map<Node, Node> parent, Node goal) {
        List<Node> path = new LinkedList<>();
        for (Node node = goal; node != null; node = parent.get(node)) {
            path.add(0, node);
        }
        return path;
    }
}