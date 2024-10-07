package intsy.group7.pathfinder_sim.model;
import java.util.LinkedList;

public class Node {
    private String id;
    private LinkedList<Edge> edges;

public Node(String id){
    this.id = id;
    this.edges = new LinkedList<>();
}

public String getId(){
    return this.id;
}

public void setId(String id){
    this.id = id;
}

public void addEdge(Edge edge){
    edges.add(edge);
}

public void removeEdge(Edge edge){
    edges.remove(edge);
}
}