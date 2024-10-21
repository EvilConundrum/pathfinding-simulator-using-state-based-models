package intsy.group7.pathfinder_sim.controller;



import javax.swing.*;
import java.awt.event.*;

import intsy.group7.pathfinder_sim.algorithm.*;
import intsy.group7.pathfinder_sim.model.*;
import intsy.group7.pathfinder_sim.view.*;

public class ManageMapController implements ActionListener {

    private ManageMapPage mmp;
    private JFrame mainFrame;

    public ManageMapController(ManageMapPage mmp, JFrame mainFrame) {

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
            System.out.println("Path Finder Button Clicked");

        } 
        else if (source == mmp.getManageMapButton()) {           
            new ManageMapController(mmp, this.mainFrame);
            mainFrame.getLayeredPane().add(mmp, JLayeredPane.DEFAULT_LAYER); // Add the new page
            
        } 
        else if (source == mmp.getViewAlgosButton()) {
            new ViewAlgorithmController(vap, this.mainFrame); 
            mainFrame.getLayeredPane().add(vap.getLayeredPane(), JLayeredPane.DEFAULT_LAYER);
            
        } 
        else if (source == mmp.getAboutButton()) {
            new AboutController(ap, this.mainFrame);
            mainFrame.getLayeredPane().add(ap, JLayeredPane.DEFAULT_LAYER);
        
        } 
        else if (source == mmp.getExitButton()) {
            System.exit(0);    
        } 
        else {
            throw new UnsupportedOperationException("Unsupported action: " + source);
        }

    }    

}
