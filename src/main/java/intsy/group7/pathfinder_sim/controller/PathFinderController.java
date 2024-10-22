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

            if (algo.equalsIgnoreCase("A*")) {
                LineDrawer.drawLines(mainFrame, pfp.getLayeredPane(), graph, AStarAlgorithm.AStar(graph, start, goal).getPath());
            } 
            // else if (algo.equalsIgnoreCase("BFS")) {
            //     LineDrawer.drawLines(mainFrame, pfp.getLayeredPane(), graph, BFSAlgorithm.bfs(graph, start, goal));
            // } 
            // else if (algo.equalsIgnoreCase("DFS")) {
            //     LineDrawer.drawLines(mainFrame, pfp.getLayeredPane(), graph, DFSAlgorithm.dfs(graph, start, goal));
            // } 
            // else if (algo.equalsIgnoreCase("Greedy BFS")) {
            //     LineDrawer.drawLines(mainFrame, pfp.getLayeredPane(), graph, GreedyBFS.greedyBFS(graph, start, goal));
            // } 
            // else if (algo.equalsIgnoreCase("UCS")) {
            //     LineDrawer.drawLines(mainFrame, pfp.getLayeredPane(), graph, UCSAlgorithm.UCS(graph, start, goal));
            // } 
            else {
                throw new UnsupportedOperationException("Unsupported algorithm: " + algo);
            }

            System.out.println("From: " + from + "\nTo: " + to + "\nAlgo: " + algo); // DEBUGGING
        }  
        

        else {
            throw new UnsupportedOperationException("Unsupported action: " + source);
        }
    }
    
    public void sample() {}
    
}
