package intsy.group7.pathfinder_sim.model;

import java.util.LinkedList;

/**
 * Represents a node within the graph with an ID, heuristic value, coordinates, state, and connections.
 * Each node can have multiple edges connected to other nodes.
 * Used in pathfinding to represent locations with x and y coordinates.
 *
 * @author Vienn Balcita
 */
public class Node {
    private String                  id;
    private final LinkedList<Edge>  edges;
    private int                     heuristic;
    private final int               xCoord;
    private final int               yCoord;
    private String                  state;

    /**
     * Constructs a Node with specified ID, heuristic, coordinates, and state.
     *
     * @param id        The unique identifier for the node.
     * @param heuristic The heuristic value for the node (used in pathfinding).
     * @param xCoord    The x-coordinate of the node.
     * @param yCoord    The y-coordinate of the node.
     * @param state     The state of the node (e.g., "eatery").
     */
    public Node(String id, int heuristic, int xCoord, int yCoord, String state) {
        this.id = id;
        this.heuristic = heuristic;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.state = state;
        this.edges = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public LinkedList<Edge> getEdges() {
        return edges;
    }
}
