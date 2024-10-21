package intsy.group7.pathfinder_sim.controller;



import javax.swing.*;
import java.awt.event.*;

import intsy.group7.pathfinder_sim.algorithm.*;
import intsy.group7.pathfinder_sim.model.*;
import intsy.group7.pathfinder_sim.view.*;

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

        if (source == mmp.getPathFinderButton()) {
            mainFrame.getContentPane().removeAll();

            System.out.println("Path Finder Button Clicked");

        } 
        else if (source == mmp.getManageMapButton()) {}

        else if (source == mmp.getViewAlgosButton()) {
            mainFrame.getContentPane().removeAll();

            new ViewAlgorithmController(graph, vap, this.mainFrame); 
            // mainFrame.getLayeredPane().add(vap.getLayeredPane(), JLayeredPane.DEFAULT_LAYER);
            
        } 
        else if (source == mmp.getAboutButton()) {
            mainFrame.getContentPane().removeAll();

            new AboutController(graph, ap, this.mainFrame);
            // mainFrame.getLayeredPane().add(ap, JLayeredPane.DEFAULT_LAYER);
        
        }
        // TODO: Implement all functionalities below  
        else if (source == mmp.getExitButton()) {
            System.exit(0);    
        } 

        else if (source == mmp.getAdd1Button()) { // Add Node Button
            String name = mmp.getAddName().trim();

            // TODO: Change Heuristics based on Vienn :3
            int heuristic1 = Integer.parseInt(mmp.getGReview().trim());
            int heuristic2 = Integer.parseInt(mmp.getSCapacityName().trim());
            int heuristic3 = Integer.parseInt(mmp.getFloorPrice().trim());

            graph.addNode(new Node(name, heuristic1, heuristic2, heuristic3));
        
        }
        else if (source == mmp.getAdd2Button()) { // Add Edge Button
            System.out.println("Add 2 Button Clicked");
        }
        else if (source == mmp.getRmvButton()) { // Remove Eatery Button
            
        }

        else {
            throw new UnsupportedOperationException("Unsupported action: " + source);
        }

    }    

}
