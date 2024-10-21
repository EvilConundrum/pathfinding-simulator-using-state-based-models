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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        PathFinderPage pfp = new PathFinderPage();
        ManageMapPage mmp = new ManageMapPage();
        ViewAlgorithmPage vap = new ViewAlgorithmPage();
        AboutPage ap = new AboutPage();

        if (source == dp.getPathFinderButton()) {
            mainFrame.getContentPane().removeAll();

            new PathFinderController(graph, pfp, this.mainFrame);

        } 
        else if (source == dp.getManageMapButton()) {
            mainFrame.getContentPane().removeAll();
            
            new ManageMapController(graph, mmp, this.mainFrame);
        } 
        else if (source == dp.getViewAlgosButton()) {
            mainFrame.getContentPane().removeAll();

            new ViewAlgorithmController(graph, vap, this.mainFrame); 
        } 
        else if (source == dp.getAboutButton()) {
            mainFrame.getContentPane().removeAll();

            new AboutController(graph, ap, this.mainFrame);        
        } 
        else if (source == dp.getExitButton()) {
            System.exit(0);    
        } 
        else {
            throw new UnsupportedOperationException("Unsupported action: " + source);
        }

    }
}
