package intsy.group7.pathfinder_sim.controller;



import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

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
        
        String[] locations = new String[0];
        List<String> locationList = new ArrayList<>();
        for (Node node : graph.getNodes()) {
            if (node.isEatery()) {
                locationList.add(node.getId());
            }
        }
        locations = locationList.toArray(new String[0]);

        String[] nodes = new String[0];
        List<String> nodeList = new ArrayList<>();
        for (Node node : graph.getNodes()) {
            nodeList.add(node.getId());
        }
        nodes = nodeList.toArray(new String[0]);

        mmp.launchManageMapPage(mainFrame, locations, nodes);
        mmp.addClickListener(this);

        RoundedButton[] buttons = NodeMaker.getVacantButtons(NodeMaker.getEateryNodes());
        for (RoundedButton button : buttons) {
            mmp.getLayeredPane().add(button, JLayeredPane.POPUP_LAYER);
        }

        mainFrame.setVisible(true);
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

            int heuristic1 = Integer.parseInt(mmp.getfTraf().trim());
            int xCoord = 0; // TODO: Implement x coord and yCoord
            int yCoord = 0;
            boolean isEatery = true;

            graph.addNode(new Node(name, heuristic1, xCoord, yCoord, isEatery));
        
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
