package intsy.group7.pathfinder_sim.model;
import java.util.LinkedList;

public class Graph {
    private LinkedList<Node> nodes;
    private LinkedList<Edge> edges;

public Graph() {
    this.nodes = new LinkedList<>();
    this.edges = new LinkedList<>();
}

public Node getNode(int index){
    if(index >= 0 && index < nodes.size()) {
        return nodes.get(index);
    }
    return null;
}

public void addNode(Node node) {
    nodes.add(node);
}

public void addEdges(Node Origin, Node Destination, int Weight) {
    Edge edge = new Edge(Origin, Destination, Weight);
    Origin.addEdge(edge);
    edges.add(edge);
}
}