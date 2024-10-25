package intsy.group7.pathfinder_sim.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.OverlayLayout;
import java.awt.BorderLayout;

import intsy.group7.pathfinder_sim.model.*;
import intsy.group7.pathfinder_sim.view.*;

public class MainController implements ActionListener {
    
    private JFrame mainFrame;
    private HashMap<Node, RoundedButton> nodeButtonMap;


    private DefaultPage dp;
    private PathFinderPage pfp;

    private ViewAlgorithmPage vap;
    private AboutPage ap;
    private ManageMapPage mmp;
    

    public MainController(Graph graph) {
        this.mainFrame = new JFrame();
        
        this.dp = new DefaultPage();        
        dp.launchDefaultPage(mainFrame);
        mainFrame.setLocationRelativeTo(null); // Center JFrame on screen
        
        this.pfp = new PathFinderPage();
        this.mmp = new ManageMapPage();
        this.vap = new ViewAlgorithmPage();
        this.ap = new AboutPage();

        this.nodeButtonMap = new HashMap<>();
        new ManageMapController(graph, mmp, pfp, mainFrame, nodeButtonMap); // launchPage is inside here
        new PathFinderController(graph, pfp, mainFrame, nodeButtonMap); // LaunchPage is inside here        

        vap.launchViewAlgorithmPage(mainFrame);
        ap.launchAboutPage(mainFrame);

        JLayeredPane layeredPaneContainer = new JLayeredPane();
        layeredPaneContainer.setLayout(new OverlayLayout(layeredPaneContainer));
        layeredPaneContainer.add(dp.getSecondaryLayer(), 1);
        layeredPaneContainer.add(dp.getMainLayer(), 2);
        layeredPaneContainer.add(pfp.getLayeredPane(), 3);
        layeredPaneContainer.add(mmp.getLayeredPane(), 4);
        layeredPaneContainer.add(vap.getLayeredPane(), 5);
        layeredPaneContainer.add(ap.getLayeredPane(), 6);

        mainFrame.getContentPane().setLayout(new BorderLayout());
        mainFrame.getContentPane().add(layeredPaneContainer, BorderLayout.CENTER);
        
        dp.addClickListener(this);
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dp.getMainLayer().setVisible(false); // Won't be shown again anymore

        Object source = e.getSource();

        if (source == dp.getPathFinderButton()) {
            mmp.getLayeredPane().setVisible(false);
            vap.getLayeredPane().setVisible(false);
            ap.getLayeredPane().setVisible(false);

            pfp.getLayeredPane().setVisible(true);
        } 
        else if (source == dp.getManageMapButton()) {
            pfp.getLayeredPane().setVisible(false);
            vap.getLayeredPane().setVisible(false);
            ap.getLayeredPane().setVisible(false);

            mmp.getLayeredPane().setVisible(true);
        } 
        else if (source == dp.getViewAlgosButton()) {
            pfp.getLayeredPane().setVisible(false);
            mmp.getLayeredPane().setVisible(false);
            ap.getLayeredPane().setVisible(false);
            
            vap.getLayeredPane().setVisible(true);
        } 
        else if (source == dp.getAboutButton()) {
            pfp.getLayeredPane().setVisible(false);
            mmp.getLayeredPane().setVisible(false);
            vap.getLayeredPane().setVisible(false);

            ap.getLayeredPane().setVisible(true);
        } 
        else if (source == dp.getExitButton()) {
            System.exit(0);    
        } 
        else {
            throw new UnsupportedOperationException("Unsupported action: " + source);
        }

    }
}
