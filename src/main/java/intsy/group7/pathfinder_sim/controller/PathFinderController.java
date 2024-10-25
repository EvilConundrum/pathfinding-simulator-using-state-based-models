package intsy.group7.pathfinder_sim.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFrame;

import intsy.group7.pathfinder_sim.algorithm.*;
import intsy.group7.pathfinder_sim.helper.Helper;
import intsy.group7.pathfinder_sim.model.*;
import intsy.group7.pathfinder_sim.view.*;

public class PathFinderController implements ActionListener {

    private Graph graph;

    private PathFinderPage pfp;
    private JFrame mainFrame;
    private HashMap<String, RoundedButton> stringButtonMap;

    private RoundedButton[] buttons;
    private String[] locations;
    private HashMap<Node, RoundedButton> nodeButtonMap;
    
    public PathFinderController(Graph graph, PathFinderPage pfp, JFrame mainFrame, 
                                HashMap<Node, RoundedButton> nodeButtonMap) { 
        
        this.graph = graph;

        this.pfp = pfp;
        this.mainFrame = mainFrame;
        this.nodeButtonMap = nodeButtonMap;
        
        this.locations = graph.getEateryNodes();
        
        String[] algorithms = {"A*", "BFS", "DFS", "Greedy BFS", "UCS"};
        pfp.launchPathFinderPage(mainFrame, locations, algorithms);
        pfp.addClickListener(this);

        this.stringButtonMap = new HashMap<>();
        Helper.assignButtons(this.buttons, graph, pfp.getLayeredPane(), "PathFinder", 
                             this.nodeButtonMap, this.stringButtonMap);

        pfp.setStringButtonMap(this.stringButtonMap);
    }

    public void setPathFinderButtons() {

    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == pfp.getSubmitButton()) {

            LineDrawer.removeLines(pfp.getLayeredPane());

            if (pfp.getPathText() != null) { // The display for traversal, path, and path cost
                pfp.getLayeredPane().remove(pfp.getPathCostLbl());
                pfp.getLayeredPane().remove(pfp.getTraversalText());
                pfp.getLayeredPane().remove(pfp.getPathText());
            }

            String from = pfp.fromDrop();
            String to = pfp.toDrop();
            String algo = pfp.algoDrop();

            Node start = null, 
                 goal = null;

            for (Node node : graph.getNodes()) {

                if (node.getId().equalsIgnoreCase(from)) {
                        start = node;
                    }
                if (node.getId().equalsIgnoreCase(to)) {
                        goal = node;
                    }
                if (start != null && goal != null) {
                    break;
                }
                    
            }

            Result result = null;
            
            if (algo.equalsIgnoreCase("A*")) {
                result = AStarAlgorithm.AStar(graph, start, goal);
                LineDrawer.drawLines(mainFrame, pfp.getLayeredPane(), result.getPath());
            }            
            else if (algo.equalsIgnoreCase("BFS")) {
                result = BFSAlgorithm.bfs(graph, start, goal);
                LineDrawer.drawLines(mainFrame, pfp.getLayeredPane(), result.getPath());
            } 
            else if (algo.equalsIgnoreCase("DFS")) {
                result = DFSAlgorithm.dfs(graph, start, goal);
                LineDrawer.drawLines(mainFrame, pfp.getLayeredPane(), result.getPath()); 
            } 
            else if (algo.equalsIgnoreCase("Greedy BFS")) {
                result = GreedyBFS.greedyBFS(graph, start, goal);
                LineDrawer.drawLines(mainFrame, pfp.getLayeredPane(), result.getPath());
            } 
            else if (algo.equalsIgnoreCase("UCS")) {
                result = UCSAlgorithm.UCS(graph, start, goal);
                LineDrawer.drawLines(mainFrame, pfp.getLayeredPane(), result.getPath()); 
            } 
            else {
                throw new UnsupportedOperationException("Unsupported algorithm: " + algo);
            }

            // Reset all buttons to the default color
            for (RoundedButton button : nodeButtonMap.values()) {
                if (button.getBackground() == Helper.cBlue) {
                    button.setForeground(Helper.cWhite);
                    button.setBackground(Helper.cRed); // Set the default color for all buttons
                }
            }

            // Change the background color of the start and goal buttons
            if (nodeButtonMap.containsKey(start)) {
                RoundedButton startButton = nodeButtonMap.get(start);
                startButton.setBackground(Helper.cBlue); // Set the desired color for the start button
            }

            if (nodeButtonMap.containsKey(goal)) {
                RoundedButton goalButton = nodeButtonMap.get(goal);
                goalButton.setBackground(Helper.cBlue); // Set the desired color for the goal button
            }            

            pfp.addPathCost(result.getPathCost(), result.getStringTraversal(), result.getStringPath());
        }  

        else {
            throw new UnsupportedOperationException("Unsupported action: " + source);
        }
    }    
}
