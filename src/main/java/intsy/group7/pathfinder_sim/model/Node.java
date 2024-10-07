package intsy.group7.pathfinder_sim.model;
import java.util.LinkedList;

public class Node {
    private String id;
    private LinkedList<Edge> edges;
    private int heuristic;

public Node(String id, int heuristic){
    this.id = id;
    this.heuristic = heuristic;
    this.edges = new LinkedList<>();
}

public String getId(){
    return this.id;
}

public int getHeuristic(){
    return this.heuristic;
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