package intsy.group7.pathfinder_sim;

import intsy.group7.pathfinder_sim.model.*;
import intsy.group7.pathfinder_sim.dao.*;
import intsy.group7.pathfinder_sim.controller.*;

import java.io.InputStream;

public class Driver{
    
    public static void main(String[] args) {
        Graph       graph = new Graph();                        // Main model
        GraphDAO    graphDAO = new GraphDAO();    
                      // File reader for nodes and edges
        // Load resources from the classpath
        InputStream nodesStream = Driver.class.getResourceAsStream("/csv/nodes.csv");
        InputStream edgesStream = Driver.class.getResourceAsStream("/csv/edges.csv");

        if (nodesStream != null && edgesStream != null) {
            graphDAO.loadGraphNodes(nodesStream, graph);
            graphDAO.loadGraphEdges(edgesStream, graph);
        } else {
            System.err.println("Resource files not found.");
        }

        new MainController(graph);

        // TESTING
    }
}