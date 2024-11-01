package intsy.group7.pathfinder_sim.model;

/**
 * Represents a connection (edge) between two nodes with a specific weight.
 * Each edge has an origin node, a destination node, and a weight.
 *
 * @author Vienn Balcita
 */
public class Edge {
    private final Node  origin;
    private final Node  destination;
    private final int   weight;

    /**
     * Constructs an Edge with specified origin, destination, and weight.
     *
     * @param origin      The starting node of the edge.
     * @param destination The ending node of the edge.
     * @param weight      The weight associated with the edge.
     */
    public Edge(Node origin, Node destination, int weight) {
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
    }

    public Node getOrigin() {
        return origin;
    }

    public Node getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }
}
