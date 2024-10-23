package intsy.group7.pathfinder_sim.controller;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.util.HashMap;

import intsy.group7.pathfinder_sim.helper.Helper;
import intsy.group7.pathfinder_sim.model.*;
import intsy.group7.pathfinder_sim.view.*;

public class ManageMapController implements ActionListener {

    private Graph graph;

    private ManageMapPage mmp;
    private JFrame mainFrame;
    private RoundedButton[] buttons;
    private HashMap<Node, RoundedButton> nodeButtonMap;

    private String[] locations, nodes;

    public ManageMapController(Graph graph, ManageMapPage mmp, JFrame mainFrame) {

        this.graph = graph;

        this.mmp = mmp;
        this.mainFrame = mainFrame;
        
        // Set current locations as all eatery nodes
        this.locations = graph.getEateryNodes();

        this.nodes = graph.getAllNodes();

        mmp.launchManageMapPage(mainFrame, locations, nodes);
        mmp.addClickListener(this);

        this.buttons = NodeMaker.getButtons(graph, "ManageMap");
        for (RoundedButton button : buttons) {
            mmp.getLayeredPane().add(button, JLayeredPane.POPUP_LAYER);
        }

        mainFrame.setVisible(true);

        this.nodeButtonMap = new HashMap<>();
        Helper.setNodeButtonMap(buttons, graph, nodeButtonMap);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        ViewAlgorithmPage vap = new ViewAlgorithmPage();
        AboutPage ap = new AboutPage();
        PathFinderPage pfp = new PathFinderPage();

        if (source == mmp.getPathFinderButton()) {
            mainFrame.getContentPane().removeAll();

            new PathFinderController(graph, pfp, this.mainFrame);
        } 
        else if (source == mmp.getManageMapButton()) {}

        else if (source == mmp.getViewAlgosButton()) {
            mainFrame.getContentPane().removeAll();

            new ViewAlgorithmController(graph, vap, this.mainFrame); 
        } 
        else if (source == mmp.getAboutButton()) {
            mainFrame.getContentPane().removeAll();

            new AboutController(graph, ap, this.mainFrame);        
        }
        else if (source == mmp.getExitButton()) {
            System.exit(0);    
        }  
        else if (source == mmp.getAdd1Button()) { // Add Node Button
            String name;
            int heuristic1;
            boolean isDefault;
            
            name = mmp.getAddName().trim();
            isDefault = false;
            
            if (NodeMaker.getClickedButton() == null) {
                JOptionPane.showMessageDialog(mainFrame, "Please select a node", 
                                             "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (mmp.getfTraf().trim().isEmpty()) {
                JOptionPane.showMessageDialog(mainFrame, "Please enter a heuristic", 
                                             "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (name.isEmpty()) {
                heuristic1 = Integer.parseInt(mmp.getfTraf().trim());
        
                if (heuristic1 > 0) { // Check if heuristic is available
                    int response = JOptionPane.showConfirmDialog(mainFrame, 
                        "Do you want to keep the existing name: \"" + NodeMaker.getClickedButton().getText() + 
                        "\" and set Foot Traffic to " + heuristic1 + "?", 
                        "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
                    if (response == JOptionPane.YES_OPTION) {
                        name = NodeMaker.getClickedButton().getText();
                        isDefault = true;
                    } 
                    else {
                        JOptionPane.showMessageDialog(mainFrame, "Please enter a name", 
                                                     "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(mainFrame, "Please enter a name", 
                                                 "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        
            if (name.length() > 2) {
                JOptionPane.showMessageDialog(mainFrame, "Max char for name is 2", 
                                             "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Add confirmation pane if name and heuristics are valid
            if (!name.isEmpty()) {
                if (name.startsWith("R") || name.startsWith("S")) {
                    JOptionPane.showMessageDialog(mainFrame, "Name cannot start with 'R' or 'S'", 
                                                "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int response = JOptionPane.showConfirmDialog(mainFrame, 
                    "Name and heuristics are valid. Do you want to proceed?", 
                    "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (response != JOptionPane.YES_OPTION) {
                    return;
                }
            }

            heuristic1 = Integer.parseInt(mmp.getfTraf().trim());

            if (isDefault == false) {
                for (Node node : graph.getNodes()) {
                    if (node.getId().equals(name)) {
                        JOptionPane.showMessageDialog(mainFrame, "Node already exists");
                        return;
                    }
                }
            }

            // Assign vacant node to eatery
            for (Node node : graph.getNodes()) {
                if (node.getId().equals(NodeMaker.getClickedButton().getText())) {
                    node.setId(name);
                    node.setState("eatery");
                    node.setHeuristic(heuristic1*5);
                    NodeMaker.getClickedButton().setBackground(Color.YELLOW);
                    NodeMaker.getClickedButton().setText(name);
                    NodeMaker.getClickedButton().setEnabled(false);
                    mmp.updateAllComboBoxes(graph.getEateryNodes(), graph.getAllNodes());
                    pfp.updateAllComboBoxes(graph.getAllNodes());
                }
            }
        
        }
        else if (source == mmp.getAdd2Button()) { // Add Edge Button
            String startNode = mmp.getStartNode();
            String endNode = mmp.getEndNode();

            if (startNode.equals(endNode)) {
                JOptionPane.showMessageDialog(mainFrame, "Start and End nodes cannot be the same", 
                                             "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }            

            for (Node node : graph.getNodes()) {
                if (node.getId().equals(startNode)) {
                    for (Node node2 : graph.getNodes()) {
                        if (node2.getId().equals(endNode)) {
                            int distance = (int) Helper.calcDist(node, node2);
                            graph.addEdges(node, node2, distance);
                        }
                    }
                }
            }

            JOptionPane.showMessageDialog(mainFrame, startNode + " to " + endNode + " connected", 
                                        "Success", JOptionPane.INFORMATION_MESSAGE);


        }
        else if (source == mmp.getRmvButton()) { // Remove Eatery Button
            String eateryToRemove = mmp.getRmvPlace().trim();

            for (Node node : graph.getNodes()) {
                if (node.getId().equals(eateryToRemove)) {
                    node.setState("vacant");
                    RoundedButton button = nodeButtonMap.get(node);
                    if (button != null) {
                        button.setBackground(Helper.noGray);
                        button.setEnabled(true);
                    }
                    mmp.updateAllComboBoxes(graph.getEateryNodes(), graph.getAllNodes());
                }
            }
        }

        else {
            throw new UnsupportedOperationException("UNSUPPORTED ACTION: " + source);
        }

    }

}
