package intsy.group7.pathfinder_sim.model;
import java.util.LinkedList;

public class Node {
    private String id;
    private LinkedList<Edge> edges;
    private int heuristic;
    private int x_coord;
    private int y_coord;
    private String state;
 
    public Node(String var1, int var2, int var3, int var4, String state) {
       this.id = var1;
       this.heuristic = var2;
       this.x_coord = var3;
       this.y_coord = var4;
       this.state = state;
       this.edges = new LinkedList<Edge>();
    }
 
    public String getId() {
       return this.id;
    }
 
    public int getHeuristic() {
       return this.heuristic;
    }

    public void setHeuristic(int var1) {
       this.heuristic = var1;
    }
    public String getState() {
      return this.state;
    }
    public void setState(String state) {
      this.state = state;
    }
    public void setId(String var1) {
       this.id = var1;
    }
 
    public int getX_coord() {
       return this.x_coord;
    }
 
    public int getY_coord() {
       return this.y_coord;
    }
 
    public void addEdge(Edge var1) {
       this.edges.add(var1);
    }
 
    public void removeEdge(Edge var1) {
       this.edges.remove(var1);
    }
 
    public LinkedList<Edge> getEdges() {
       return this.edges;
    }
 }