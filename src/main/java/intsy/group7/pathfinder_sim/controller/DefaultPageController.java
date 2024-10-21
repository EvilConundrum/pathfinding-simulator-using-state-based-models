package intsy.group7.pathfinder_sim.controller;

import javax.swing.*;

import java.awt.event.*;

import intsy.group7.pathfinder_sim.algorithm.*;
import intsy.group7.pathfinder_sim.model.*;
import intsy.group7.pathfinder_sim.view.*;

public class DefaultPageController implements ActionListener {
    
    private JFrame mainFrame;
    private DefaultPage dp;

    public DefaultPageController() {

        this.mainFrame = new JFrame();

        this.dp = new DefaultPage();

        dp.launchDefaultPage(mainFrame);
        dp.addClickListener(this);   
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
            new ManageMapController(mmp, this.mainFrame);
            mainFrame.getLayeredPane().add(mmp, JLayeredPane.DEFAULT_LAYER); // Add the new page

        } 
        else if (source == dp.getViewAlgosButton()) {
            new ViewAlgorithmController(vap, this.mainFrame); 
            mainFrame.getLayeredPane().add(vap.getLayeredPane(), JLayeredPane.DEFAULT_LAYER);
            
        } 
        else if (source == dp.getAboutButton()) {
            new AboutController(ap, this.mainFrame);
            mainFrame.getLayeredPane().add(ap, JLayeredPane.DEFAULT_LAYER);
        
        } 
        else if (source == dp.getExitButton()) {
            System.exit(0);    
        } 
        else {
            throw new UnsupportedOperationException("Unsupported action: " + source);
        }

    }

    
    
}
