package intsy.group7.pathfinder_sim.controller;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.View;

import java.awt.event.*;

import intsy.group7.pathfinder_sim.algorithm.*;
import intsy.group7.pathfinder_sim.model.*;
import intsy.group7.pathfinder_sim.view.*;

public class MainController implements ActionListener, MouseListener {

    private ViewAlgorithmPage view;
    private DefaultPage dp;
    private AboutPage aboutPage;
    private ImageResizer imageResizer;

    public MainController(ViewAlgorithmPage view, DefaultPage dp) {
        JFrame mainFrame = new JFrame();

        String text = "     Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";

        this.view = view;
        this.dp = dp;

        // view.launchViewAlgorithmPage(mainFrame, text);

        // ManageMapPage view = new ManageMapPage();
        // view.launchManageMapPage(mainFrame, locations, nodes);


        // aboutPage = new AboutPage(mainFrame, text);
        // defaultPage = new DefaultPage();
        // imageResizer = new ImageResizer();
        
        dp.launchDefaultPage(mainFrame);

        this.view.addClickListener(this);
        this.dp.addClickListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == view.getPathFinderButton()) {

            System.out.println("Path Finder Button Clicked");
        } else if (source == view.getManageMapButton()) {
            
        } else if (source == view.getViewAlgosButton()) {
            System.out.println("View Algos Button Clicked");
        } else if (source == view.getAboutButton()) {
            System.out.println("About Button Clicked");
        } else if (source == view.getExitButton()) {
            System.exit(0);    
        } 
        
        else if (source == dp.getPathFinderButton()) {
            System.out.println("Path Finder Button Clicked");
        } else if (source == dp.getManageMapButton()) {
            System.out.println("Manage Map Button Clicked");
        } else if (source == dp.getViewAlgosButton()) {
            System.out.println("View Algos Button Clicked");
        } else if (source == dp.getAboutButton()) {
            System.out.println("About Button Clicked");
        } else if (source == dp.getExitButton()) {
            System.exit(0);
        }
        
        

        else {
            throw new UnsupportedOperationException("Unsupported action: " + source);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

}
