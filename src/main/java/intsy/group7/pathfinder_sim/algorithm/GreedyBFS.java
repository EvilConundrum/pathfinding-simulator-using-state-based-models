package intsy.group7.pathfinder_sim.algorithm;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import intsy.group7.pathfinder_sim.model.Edge;
import intsy.group7.pathfinder_sim.model.Graph;
import intsy.group7.pathfinder_sim.model.Node;

public class GreedyBFS {

    /**
     * The algorithm implementation for GBFS Pathfinding algorithm
     * 
     * @author Jaztin Jimenez
     * @return the path of the GBFS algorithm or null if path is not found
     */
    public static Result greedyBFS(Graph graph, Node start, Node goal) {
        // Using PriorityQueue for nodes to be sorted ascendingly
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(Node::getHeuristic));
        // Using HashSet for visited nodes to avoid revisiting them
        Set<Node> visited = new HashSet<>();
        // Using HashMap for storing parent node of each node in the path
        Map<Node, Node> parent = new HashMap<>();
        List<Node> traversal = new LinkedList<>(); // List of traversed nodes
        

        openSet.add(start);
        parent.put(start, null);

        // Loop until the openSet is empty
        while (!openSet.isEmpty()) {
            // Get the node with the lowest cost from the openSet
            Node current = openSet.poll();
            traversal.add(current); // Add the current node to the traversal list

            // If goal node is found, construct the path for the GBFS path output
            if (current.equals(goal)) {
                List<Node> path = reconstructPath(parent, goal);
                return new Result(path, traversal);  // Return both path and traversal
            }

            // Mark the current node as visited
            visited.add(current);

            // Go through every edge of the current node
            for (Edge edge : current.getEdges()) {
                Node neighbor = edge.getDestination();

                // If neighbor node is not visited, add it to the openSet and update its parent node
                if (!visited.contains(neighbor)) {
                    openSet.add(neighbor);
                    parent.put(neighbor, current);
                }
            }
        }
        return new Result(null, traversal); // Path not found
    }

    /**
     * Function to return the list of nodes that shows the path of the BFS algorithm
     * 
     * @author Jaztin Jimenez
     * @return list of nodes that shows the path of the BFS algorithm
     */
    private static List<Node> reconstructPath(Map<Node, Node> parent, Node goal) {
        List<Node> path = new LinkedList<>();
        for (Node node = goal; node != null; node = parent.get(node)) {
            path.add(0, node);
        }
        return path;
    }
}
