package intsy.group7.pathfinder_sim.controller;



import javax.swing.*;
import java.awt.event.*;

import intsy.group7.pathfinder_sim.algorithm.*;
import intsy.group7.pathfinder_sim.model.*;
import intsy.group7.pathfinder_sim.view.*;
import javafx.scene.shape.Path;

public class ManageMapController implements ActionListener {

    private Graph graph;


    private ManageMapPage mmp;
    private JFrame mainFrame;

    public ManageMapController(Graph graph, ManageMapPage mmp, JFrame mainFrame) {

        this.graph = graph;

        this.mmp = mmp;
        this.mainFrame = mainFrame;

        String[] locations = {"Bloemen", "Br. Andrew Hall", "St. La Salle Hall", "Perico's", "etc."};
        String[] nodes = {"A", "B", "C", "D", "E", "..."};

        mmp.launchManageMapPage(mainFrame, locations, nodes);
        mmp.addClickListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        ViewAlgorithmPage vap = new ViewAlgorithmPage();
        AboutPage ap = new AboutPage();
        PathFinderPage pfp = new PathFinderPage();

        if (source == mmp.getPathFinderButton()) {
            mainFrame.getContentPane().removeAll();

            new PathFinderController(graph, pfp, this.mainFrame);
        } 
        else if (source == mmp.getManageMapButton()) {}

        else if (source == mmp.getViewAlgosButton()) {
            mainFrame.getContentPane().removeAll();

            new ViewAlgorithmController(graph, vap, this.mainFrame); 
        } 
        else if (source == mmp.getAboutButton()) {
            mainFrame.getContentPane().removeAll();

            new AboutController(graph, ap, this.mainFrame);        
        }
        else if (source == mmp.getExitButton()) {
            System.exit(0);    
        } 
        // TODO: Implement all functionalities below  
        else if (source == mmp.getAdd1Button()) { // Add Node Button
            String name = mmp.getAddName().trim();

            // TODO: Change Heuristics based on Vienn :3
            int heuristic1 = Integer.parseInt(mmp.getGReview().trim());
            int heuristic2 = Integer.parseInt(mmp.getSCapacityName().trim());
            int heuristic3 = Integer.parseInt(mmp.getFloorPrice().trim());
            boolean isEatery = true;

            graph.addNode(new Node(name, heuristic1, heuristic2, heuristic3, isEatery));
        
        }
        else if (source == mmp.getAdd2Button()) { // Add Edge Button
           // TODO: Add Edge adder here
        }
        else if (source == mmp.getRmvButton()) { // Remove Eatery Button
            String eateryToRemove = mmp.getRmvPlace().trim();

            // graph.removeNode(eateryToRemove);
        }

        else {
            throw new UnsupportedOperationException("Unsupported action: " + source);
        }

    }    

}
