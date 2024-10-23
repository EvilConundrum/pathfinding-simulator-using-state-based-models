package intsy.group7.pathfinder_sim.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import intsy.group7.pathfinder_sim.model.*;
import intsy.group7.pathfinder_sim.view.*;

public class AboutController implements ActionListener {
    
    private Graph graph;

    private AboutPage ap;
    private JFrame mainFrame;

    private String text = "     Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
    
    public AboutController(Graph graph, AboutPage ap, JFrame mainFrame) {
        
        this.graph = graph;

        this.ap = ap;
        this.mainFrame = mainFrame;
        
        ap.launchAboutPage(mainFrame, this.text);
        ap.addClickListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        PathFinderPage pfp = new PathFinderPage();
        ManageMapPage mmp = new ManageMapPage();
        ViewAlgorithmPage vap = new ViewAlgorithmPage();

        if (source == ap.getPathFinderButton()) {
            mainFrame.getContentPane().removeAll();

            new PathFinderController(graph, pfp, this.mainFrame);

        } 
        else if (source == ap.getManageMapButton()) {          
            mainFrame.getContentPane().removeAll();
             
            new ManageMapController(graph, mmp, this.mainFrame);
        } 
        else if (source == ap.getViewAlgosButton()) {
            mainFrame.getContentPane().removeAll();

            new ViewAlgorithmController(graph, vap, this.mainFrame);             
        } 
        else if (source == ap.getAboutButton()) {}

        else if (source == ap.getExitButton()) {
            System.exit(0);    
        } 
        else {
            throw new UnsupportedOperationException("Unsupported action: " + source);
        }
    }
}
