package intsy.group7.pathfinder_sim.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import intsy.group7.pathfinder_sim.algorithm.*;
import intsy.group7.pathfinder_sim.model.*;
import intsy.group7.pathfinder_sim.view.*;

public class ViewAlgorithmController implements ActionListener {

    private Graph graph;

    private ViewAlgorithmPage vap;
    private JFrame mainFrame;

    private String text = "     Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";

    public ViewAlgorithmController(Graph graph, ViewAlgorithmPage vap, JFrame mainFrame) {

        this.graph = graph;

        this.vap = vap;
        this.mainFrame = mainFrame;

        vap.launchViewAlgorithmPage(mainFrame, this.text);
        vap.addClickListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();


        ManageMapPage mmp = new ManageMapPage();
        AboutPage ap = new AboutPage();

        if (source == vap.getPathFinderButton()) {
            mainFrame.getContentPane().removeAll();

            System.out.println("Path Finder Button Clicked");

        } 
        else if (source == vap.getManageMapButton()) {   
            mainFrame.getContentPane().removeAll();

            new ManageMapController(graph, mmp, this.mainFrame);
            // mainFrame.getLayeredPane().add(mmp, JLayeredPane.DEFAULT_LAYER); // Add the new page
            
        } 
        else if (source == vap.getViewAlgosButton()) {
            // new ViewAlgorithmController(graph, vap, this.mainFrame); 
            // mainFrame.getLayeredPane().add(vap.getLayeredPane(), JLayeredPane.DEFAULT_LAYER);

            
        } 
        else if (source == vap.getAboutButton()) {
            mainFrame.getContentPane().removeAll();

            new AboutController(graph, ap, this.mainFrame);
            // mainFrame.getLayeredPane().add(ap, JLayeredPane.DEFAULT_LAYER);
        
        } 
        else if (source == vap.getExitButton()) {
            System.exit(0);    
        }
        
        // TODO: Implement Algorithms here


        else {
            throw new UnsupportedOperationException("Unsupported action: " + source);
        }

    }
}
