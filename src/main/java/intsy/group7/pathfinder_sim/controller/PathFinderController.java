package intsy.group7.pathfinder_sim.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import intsy.group7.pathfinder_sim.algorithm.*;
import intsy.group7.pathfinder_sim.helper.Helper;
import intsy.group7.pathfinder_sim.model.*;
import intsy.group7.pathfinder_sim.view.*;
import javafx.scene.shape.Line;

public class PathFinderController implements ActionListener {

    private Graph graph;

    private PathFinderPage pfp;
    private JFrame mainFrame;

    private String[] locations, nodes;
    private HashMap<Node, RoundedButton> nodeButtonMap;
    
    public PathFinderController(Graph graph, PathFinderPage pfp, JFrame mainFrame)  {
        
        this.graph = graph;

        this.pfp = pfp;
        this.mainFrame = mainFrame;
        
        this.locations = graph.getEateryNodes();
        this.nodes = graph.getAllNodes();
        
        String[] algorithms = {"A*", "BFS", "DFS", "Greedy BFS", "UCS"};
        pfp.launchPathFinderPage(mainFrame, locations, algorithms);
        pfp.addClickListener(this);

        RoundedButton[] buttons = NodeMaker.getButtons(graph, "PathFinder");
        for (RoundedButton button : buttons) {
            pfp.getLayeredPane().add(button, JLayeredPane.POPUP_LAYER);
        }

        mainFrame.setVisible(true);
        nodeButtonMap = new HashMap<>();
        Helper.setNodeButtonMap(buttons, graph, nodeButtonMap);
    }


    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        ManageMapPage mmp = new ManageMapPage();
        ViewAlgorithmPage vap = new ViewAlgorithmPage();
        AboutPage ap = new AboutPage();

        if (source == pfp.getPathFinderButton()) {}

        else if (source == pfp.getManageMapButton()) {      
            mainFrame.getContentPane().removeAll();
            
            new ManageMapController(graph, mmp, this.mainFrame);
        } 
        else if (source == pfp.getViewAlgosButton()) {
            mainFrame.getContentPane().removeAll();

            new ViewAlgorithmController(graph, vap, this.mainFrame);           
        } 
        else if (source == pfp.getAboutButton()) {
            mainFrame.getContentPane().removeAll();

            new AboutController(graph, ap, this.mainFrame);        
        } 
        else if (source == pfp.getExitButton()) {
            System.exit(0);    
        }
        
        // TODO: Implement all functionalities below
        else if (source == pfp.getSubmitButton()) {

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

            pfp.addPathCost(result.getPathCost(), result.getStringTraversal(), result.getStringPath());
        }  

        else {
            throw new UnsupportedOperationException("Unsupported action: " + source);
        }
    }
    
    public void sample() {}
    
}
