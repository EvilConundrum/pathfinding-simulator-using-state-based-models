package intsy.group7.pathfinder_sim.algorithm;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import intsy.group7.pathfinder_sim.algorithm.result.Result;
import intsy.group7.pathfinder_sim.model.Edge;
import intsy.group7.pathfinder_sim.model.Node;

public class UCSAlgorithm { 

    /**
     * The algorithm implementation for UCS Pathfinding algorithm
     *
     * @return the path of the UCS algorithm or null if path is not found
     */
    public static Result UCS(Node start, Node goal) {
        // Using PriorityQueue for nodes to be sorted in ascending order
        PriorityQueue<UCS_NodeHelper> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        Map<Node, Integer> costSoFar = new HashMap<>(); // Stores the cost from the start node to each node
        Map<Node, Node> parent = new HashMap<>();       // Stores the parent node of each node
        List<Node> traversal = new LinkedList<>();      // List of traversed nodes

        // Initialize the costs
        priorityQueue.add(new UCS_NodeHelper(start, 0));
        costSoFar.put(start, 0);
        parent.put(start, null);

        // Loop until the openSet is empty
        while (!priorityQueue.isEmpty()) {
            // Get the node with the lowest cost from the openSet
            UCS_NodeHelper current = priorityQueue.poll();
            traversal.add(current.node);  // Add the node to the traversal list

            // If goal node is found, construct the path for the AStar path output
            if (current.node.equals(goal)) {
                List<Node> path = reconstructPath(parent, goal);
                return new Result(path, traversal);  // Return both path and traversal
            }

            // Go through every edge of the current node
            for (Edge edge : current.node.getEdges()) {
                Node neighbor = edge.getDestination();
                int newCost = costSoFar.get(current.node) + edge.getWeight();

                // Checks if the node is already visited and if the newCost is less than the neighbor node
                if (!costSoFar.containsKey(neighbor) || newCost < costSoFar.get(neighbor)) {
                    // Update the parent node and the cost of the neighbor node
                    costSoFar.put(neighbor, newCost);
                    priorityQueue.add(new UCS_NodeHelper(neighbor, newCost));
                    parent.put(neighbor, current.node);
                }
            }
        }
        return new Result(null, traversal); // Path not found
    }

    /**
     * Function to return the list of nodes that shows the path of the BFS algorithm
     *
     * @return list of nodes that shows the path of the BFS algorithm
     */
    private static List<Node> reconstructPath(Map<Node, Node> parent, Node goal) {
        List<Node> path = new LinkedList<>();
        for (Node node = goal; node != null; node = parent.get(node)) {
            path.add(0, node);
        }
        return path;
    }

    /**
     * Helper class to store node info for priority queue
     */
    static class UCS_NodeHelper {
        Node node;
        int cost;

        UCS_NodeHelper(Node node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}
