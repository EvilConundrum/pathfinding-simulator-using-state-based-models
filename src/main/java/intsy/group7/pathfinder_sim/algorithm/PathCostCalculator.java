package intsy.group7.pathfinder_sim.algorithm;

import java.util.List;

import intsy.group7.pathfinder_sim.model.Edge;
import intsy.group7.pathfinder_sim.model.Node;

public class PathCostCalculator {

    /**
     * This method is called to calculate the total path cost of a path
     * 
     * Note: Call this method after using one of the path algorithm methods to acquire the cost
     *
     * @param path  The list of nodes representing the path
     * @return The total cost of the path
     * @author Jaztin Jimenez
     */
    public static int calculateTotalCost(List<Node> path) {
        if (path == null || path.size() < 2) { // If the path is empty or only contains one node, then the path cost is zero
            return 0; 
        }

        int totalCost = 0;

        for (int i = 0; i < path.size() - 1; i++) { // Iterate through all nodes
            Node currentNode = path.get(i);
            Node nextNode = path.get(i + 1);

            
            boolean findEdge = false; // Checks if the edge is found
            for (Edge edge : currentNode.getEdges()) {
                if (edge.getDestination().equals(nextNode)) { 
                    totalCost += edge.getWeight(); // adds the cost of the edges
                    findEdge = true;
                    break;
                }
            }

            // No path found
            if (!findEdge) {
                return -1;
            }
        }

        return totalCost; // returns the total cost
    }
}