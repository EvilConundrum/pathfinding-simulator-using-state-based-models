package intsy.group7.pathfinder_sim.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import intsy.group7.pathfinder_sim.view.AboutPage;
import intsy.group7.pathfinder_sim.view.ManageMapPage;
import intsy.group7.pathfinder_sim.view.ViewAlgorithmPage;

public class AboutController implements ActionListener {
    
    private AboutPage ap;
    private JFrame mainFrame;

    private String text = "     Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
    
    public AboutController(AboutPage ap, JFrame mainFrame) {
        
        this.ap = ap;
        this.mainFrame = mainFrame;
        
        ap.launchAboutPage(mainFrame, this.text);
        ap.addClickListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        ManageMapPage mmp = new ManageMapPage();
        ViewAlgorithmPage vap = new ViewAlgorithmPage();

        if (source == ap.getPathFinderButton()) {
            System.out.println("Path Finder Button Clicked");

        } 
        else if (source == ap.getManageMapButton()) {           
            new ManageMapController(mmp, this.mainFrame);
            mainFrame.getLayeredPane().add(mmp, JLayeredPane.DEFAULT_LAYER); // Add the new page

        } 
        else if (source == ap.getViewAlgosButton()) {
            new ViewAlgorithmController(vap, this.mainFrame); 
            mainFrame.getLayeredPane().add(vap.getLayeredPane(), JLayeredPane.DEFAULT_LAYER);
            
        } 
        else if (source == ap.getAboutButton()) {
            new AboutController(ap, this.mainFrame);
            mainFrame.getLayeredPane().add(ap, JLayeredPane.DEFAULT_LAYER);
        
        } 
        else if (source == ap.getExitButton()) {
            System.exit(0);    
        } 
        else {
            throw new UnsupportedOperationException("Unsupported action: " + source);
        }
    }
}
