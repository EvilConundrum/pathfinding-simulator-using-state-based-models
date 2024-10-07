package intsy.group7.pathfinder_sim.model;

public class Edge {
    private Node origin;
    private Node destination;
    private int weight;

    public Edge(Node origin, Node destination, int weight){
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
    }

    public Node getOrigin() {
        return this.origin;
    }

    public Node getDestination() {
        return this.destination;
    }

    public int getWeight() {
        return this.weight;
    }
}
