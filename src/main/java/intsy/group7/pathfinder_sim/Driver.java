package intsy.group7.pathfinder_sim;

import intsy.group7.pathfinder_sim.model.*;
import intsy.group7.pathfinder_sim.dao.*;
import intsy.group7.pathfinder_sim.controller.*;

public class Driver{
    public static void main(String[] args) {
        Graph       graph = new Graph();                        // Main model
        GraphDAO    graphDAO = new GraphDAO();                  // File reader for nodes and edges
        String      CSVFolderPath = "src/main/resources/csv/";  // Relative path to the csv folder

        graphDAO.loadGraphNodes(CSVFolderPath + "nodes.csv", graph);
        graphDAO.loadGraphEdges(CSVFolderPath + "edges.csv", graph);

        new MainController(graph);
    }
}