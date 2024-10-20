package intsy.group7.pathfinder_sim.model;

public class Edge {
    private Node origin;
    private Node destination;
    private double weight;

public Edge(Node origin, Node destination, double weight){
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

public double getWeight() {
    return this.weight;
}
}
