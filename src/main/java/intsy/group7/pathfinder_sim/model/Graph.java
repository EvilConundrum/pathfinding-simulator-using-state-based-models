package intsy.group7.pathfinder_sim.model;
import java.util.LinkedList;

public class Graph {
    private LinkedList<Node> nodes;
    private LinkedList<Edge> edges;

public Graph() {
    this.nodes = new LinkedList<>();
    this.edges = new LinkedList<>();
}

public LinkedList<Node> getNodes() {
    return nodes;
}

public Node getNode(int index){
    if(index >= 0 && index < nodes.size()) {
        return nodes.get(index);
    }
    return null;
}

public Node findNode(String ID){
    for(Node node : nodes) {
        if(node.getId().equals(ID)) {
            return node;
        }
    }
    return null;
}

public boolean findEdge(Node origin, Node destination){
    for (Edge edge : edges) {
        if(edge.getOrigin().equals(origin) && edge.getDestination().equals(destination)) {
            return true;
        }
    }
    return false;
}

public boolean findNode(Node newnode){
    for (Node node : nodes) {
        if(node.equals(newnode)) {
            return true;
        }
    }
    return false;
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