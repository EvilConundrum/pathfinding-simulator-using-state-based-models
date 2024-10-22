package intsy.group7.pathfinder_sim.algorithm;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import intsy.group7.pathfinder_sim.model.Edge;
import intsy.group7.pathfinder_sim.model.Graph;
import intsy.group7.pathfinder_sim.model.Node;


public class AStarAlgorithm {

    /**
     * The algorithm implementation for AStar Pathfinding algorithm
     * 
     * @author Jaztin Jimenez
     * @return the path of the AStar algorithm or null if path is not found
     */
    public static Result AStar(Graph graph, Node start, Node goal) {
        // Using PriorityQueue for nodes to be sorted ascendingly
        PriorityQueue<AStar_NodeHelper> openSet = new PriorityQueue<>(Comparator.comparingInt(n -> n.fCost));
        // Stores the cost from the start node to each node
        Map<Node, Integer> gScore = new HashMap<>(); 
        // Stores the parent node of each node
        Map<Node, Node> parent = new HashMap<>();
        List<Node> traversal = new LinkedList<>(); // List of traversed nodes

        // Initialize gScore for start node
        gScore.put(start, 0);
        parent.put(start, null);

        // Add start node to the open set
        openSet.add(new AStar_NodeHelper(start, 0, start.getHeuristic()));

        // Loop until the openSet is empty
        while (!openSet.isEmpty()) {
            // Get the node with the lowest cost from the openSet
            AStar_NodeHelper current = openSet.poll();
            traversal.add(current.node);  // Track traversal

            // If goal node is found, construct the path for the AStar path output
            if (current.node.equals(goal)) {
                List<Node> path = reconstructPath(parent, goal);
                return new Result(path, traversal);  // Return both path and traversal
            }

            // Go through every edge of the current node
            for (Edge edge : current.node.getEdges()) {
                Node neighbor = edge.getDestination();
                int tempGScore = gScore.get(current.node) + edge.getWeight();  // Temporary gScore
                
                // Check if the temporary gScore is less than the current gScore of the neighbor
                if (tempGScore < gScore.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    // Update gScore if this path is better
                    gScore.put(neighbor, tempGScore);
                    int fScore = tempGScore + neighbor.getHeuristic();  // fCost = gScore + heuristic
                    
                    // Adds the node with the updated gScore and fScore
                    openSet.add(new AStar_NodeHelper(neighbor, tempGScore, fScore));
                    parent.put(neighbor, current.node);

                    System.out.println(fScore);
                }
            }
        }
        return new Result(null, traversal);  // No path found
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

    /**
     * Helper class to store node for priority queue
     * 
     * @author Jaztin Jimenez
     */
    static class AStar_NodeHelper {
        Node node;
        int gCost;
        int fCost;

        /**
         * Constructor for helper
         */
        AStar_NodeHelper(Node node, int gCost, int fCost) {
            this.node = node;
            this.gCost = gCost;
            this.fCost = fCost;
        }
    }
}