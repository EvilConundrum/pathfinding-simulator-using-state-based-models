package intsy.group7.pathfinder_sim.model;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        Edge originEdge = new Edge(Origin, Destination, Weight);
        Edge destinationEdge = new Edge(Destination, Origin, Weight);
        Origin.addEdge(originEdge);
        Destination.addEdge(destinationEdge);
        edges.add(originEdge);
        edges.add(destinationEdge);
    }
    public void removeNode(Node node){
        for (Edge edge : node.getEdges()){
            this.removeEdge(edge);
        }
        this.nodes.remove(node);
    }

    public void removeEdge(Edge edge){
        this.edges.remove(edge);
    }

    public String[] getEateryNodes() {
        List<String> locationList = new ArrayList<>();
        for (Node node : getNodes()) {
            if (node.getState().equalsIgnoreCase("eatery")) {
                locationList.add(node.getId());
            }
        }
        return locationList.toArray(new String[0]);
    }

    public String[] getAllNodes() {
        List<String> nodeList = new ArrayList<>();
        for (Node node : getNodes()) {
            nodeList.add(node.getId());
        }
        return nodeList.toArray(new String[0]);
    }
}