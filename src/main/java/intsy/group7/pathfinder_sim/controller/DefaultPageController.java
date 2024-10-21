package intsy.group7.pathfinder_sim.controller;

import javax.swing.*;

import java.awt.event.*;

import intsy.group7.pathfinder_sim.algorithm.*;
import intsy.group7.pathfinder_sim.model.*;
import intsy.group7.pathfinder_sim.view.*;

public class DefaultPageController implements ActionListener {
    
    private JFrame mainFrame;
    private DefaultPage dp;
    private Graph graph;

    public DefaultPageController(Graph graph) {

        this.graph = graph;

        this.mainFrame = new JFrame();
        this.dp = new DefaultPage();

        dp.launchDefaultPage(mainFrame);
        dp.addClickListener(this);

        // DEBUGGING
        // ManageMapPage mmp = new ManageMapPage();
        // new ManageMapController(graph, mmp, this.mainFrame);
        // mmp.addClickListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        ManageMapPage mmp = new ManageMapPage();
        ViewAlgorithmPage vap = new ViewAlgorithmPage();
        AboutPage ap = new AboutPage();

        if (source == dp.getPathFinderButton()) {
            System.out.println("Path Finder Button Clicked");

        } 
        else if (source == dp.getManageMapButton()) {           
            new ManageMapController(graph, mmp, this.mainFrame);
            mainFrame.getLayeredPane().add(mmp, JLayeredPane.DEFAULT_LAYER); // Add the new page
            mainFrame.getLayeredPane().moveToFront(mmp);

        } 
        else if (source == dp.getViewAlgosButton()) {
            new ViewAlgorithmController(graph, vap, this.mainFrame); 
            mainFrame.getLayeredPane().add(vap.getLayeredPane(), JLayeredPane.DEFAULT_LAYER);
            mainFrame.getLayeredPane().moveToFront(vap.getLayeredPane());
            
        } 
        else if (source == dp.getAboutButton()) {
            new AboutController(graph, ap, this.mainFrame);
            mainFrame.getLayeredPane().add(ap, JLayeredPane.DEFAULT_LAYER);
            mainFrame.getLayeredPane().moveToFront(ap.getLayeredPane());
        
        } 
        else if (source == dp.getExitButton()) {
            System.exit(0);    
        } 
        else {
            throw new UnsupportedOperationException("Unsupported action: " + source);
        }

    }

    
    
}
