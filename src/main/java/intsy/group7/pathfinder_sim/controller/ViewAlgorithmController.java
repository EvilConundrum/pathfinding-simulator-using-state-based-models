package intsy.group7.pathfinder_sim.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import intsy.group7.pathfinder_sim.view.AboutPage;
import intsy.group7.pathfinder_sim.view.ManageMapPage;
import intsy.group7.pathfinder_sim.view.ViewAlgorithmPage;

public class ViewAlgorithmController implements ActionListener {

    private ViewAlgorithmPage vap;
    private JFrame mainFrame;

    private String text = "     Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";

    public ViewAlgorithmController(ViewAlgorithmPage vap, JFrame mainFrame) {

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
            System.out.println("Path Finder Button Clicked");

        } 
        else if (source == vap.getManageMapButton()) {           
            new ManageMapController(mmp, this.mainFrame);
            mainFrame.getLayeredPane().add(mmp, JLayeredPane.DEFAULT_LAYER); // Add the new page
            
        } 
        else if (source == vap.getViewAlgosButton()) {
            new ViewAlgorithmController(vap, this.mainFrame); 
            mainFrame.getLayeredPane().add(vap.getLayeredPane(), JLayeredPane.DEFAULT_LAYER);
            
        } 
        else if (source == vap.getAboutButton()) {
            new AboutController(ap, this.mainFrame);
            mainFrame.getLayeredPane().add(ap, JLayeredPane.DEFAULT_LAYER);
        
        } 
        else if (source == vap.getExitButton()) {
            System.exit(0);    
        } 
        else {
            throw new UnsupportedOperationException("Unsupported action: " + source);
        }

    }
}
