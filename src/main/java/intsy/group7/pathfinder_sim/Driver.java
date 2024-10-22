package intsy.group7.pathfinder_sim;


import intsy.group7.pathfinder_sim.model.*;
import intsy.group7.pathfinder_sim.dao.*;

import intsy.group7.pathfinder_sim.controller.*;

public class Driver{
    public static void main(String[] args) {
        System.out.println("Test Print");
        
        Graph graph = new Graph();
        GraphDAO graphDAO = new GraphDAO();
        graphDAO.loadGraphNodes("src/main/java/intsy/group7/pathfinder_sim/dao/nodes.csv", graph);
        graphDAO.loadGraphEdges("src/main/java/intsy/group7/pathfinder_sim/dao/edges.csv", graph);
        new DefaultPageController(graph);

    }
}