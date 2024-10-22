package intsy.group7.pathfinder_sim.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import intsy.group7.pathfinder_sim.model.Graph;
import intsy.group7.pathfinder_sim.model.Node;

public class GraphDAO {

    public void loadGraphNodes(String filepath, Graph graph) {
        try (Scanner scanner = new Scanner(new File(filepath))) {   
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] columns = line.split(",");
                String nodeName = columns[0];
                int heuristic = Integer.parseInt(columns[1]);
                int xCoord = Integer.parseInt(columns[2]);
                int yCoord = Integer.parseInt(columns[3]);
                String nodeState = columns[4];
                
                // Create a new Node object using the variables
                Node node = new Node(nodeName, heuristic*5, xCoord, yCoord, nodeState);
                
                // If the node does not exist already, create the new node and add it to the graph
                if (graph.findNode(node) != true) {
                    graph.addNode(node);
                }
                //System.out.println("Node: " + node.getId() + " created!"); check nodes created
            }
            System.out.println("All nodes created successfully"); // DEBUGGING
        } 
        catch (FileNotFoundException e) {
        System.out.println("File not found: " + filepath);
        }
    }
    public void loadGraphEdges(String filepath, Graph graph){
        try (Scanner scanner = new Scanner(new File(filepath))) {   
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] columns = line.split(",");
                String originID = columns[0];
                String destinationID = columns[1];
    
                Node origin = graph.findNode(originID);
                Node destination = graph.findNode(destinationID);
                //If the edge does not exist already, create the the new edge
                System.out.println("Origin: " + origin.getId());
                System.out.println("Destination: " + destination.getId());
                if (graph.findEdge(origin,destination) != true){
                    int distance = (int) calcDist(origin,destination);
                    graph.addEdges(origin, destination, distance);
                }
            }
            // System.out.println("All edges created successfully"); check edges created
        } 
        catch (FileNotFoundException e) {
        System.out.println("File not found: " + filepath);
        }
    }
    
    private double calcDist(Node origin,Node destination){
        int origin_x = origin.getX_coord();
        int origin_y = origin.getY_coord();
        int destination_x = destination.getX_coord();
        int destination_y = destination.getY_coord();
        double result = Math.sqrt(Math.pow((destination_x - origin_x),2) + Math.pow((destination_y-origin_y),2));
        return result;
    }
}
    
    