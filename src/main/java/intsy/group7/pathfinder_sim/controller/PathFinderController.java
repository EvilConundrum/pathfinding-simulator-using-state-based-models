package intsy.group7.pathfinder_sim.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import intsy.group7.pathfinder_sim.algorithm.*;
import intsy.group7.pathfinder_sim.model.*;
import intsy.group7.pathfinder_sim.view.*;

public class PathFinderController implements ActionListener {

    private Graph graph;

    private PathFinderPage pfp;
    private JFrame mainFrame;
    
    public PathFinderController(Graph graph, PathFinderPage pfp, JFrame mainFrame)  {
        
        this.graph = graph;

        this.pfp = pfp;
        this.mainFrame = mainFrame;
        
        String[] locations = {"Bloemen", "Br. Andrew Hall", "St. La Salle Hall", "Perico's", "etc."}; // DEBUGGING
        String[] algorithms = {"A*", "BFS", "DFS", "Greedy BFS", "UCS"};
        pfp.launchPathFinderPage(mainFrame, locations, algorithms);
        pfp.addClickListener(this);

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
            System.out.println("From: " + from + "\nTo: " + to + "\nAlgo: " + algo); // DEBUGGING
        }  
        

        else {
            throw new UnsupportedOperationException("Unsupported action: " + source);
        }
    }
    
    public void sample() {}
    
}
