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
    private PathFinderPage pfp;
    private JFrame mainFrame;
    private RoundedButton[] buttons;
    private HashMap<Node, RoundedButton> nodeButtonMap;

    private String[] locations, nodes;

    public ManageMapController(Graph graph, ManageMapPage mmp, PathFinderPage pfp, JFrame mainFrame) {

        this.graph = graph;

        this.mmp = mmp;
        this.mainFrame = mainFrame;

        this.pfp = pfp;
        
        // Set current locations as all eatery nodes
        this.locations = graph.getEateryNodes();
        this.nodes = graph.getAllNodes();

        mmp.launchManageMapPage(mainFrame, locations, nodes);
        mmp.addClickListener(this);

        this.buttons = NodeMaker.getButtons(graph, "ManageMap");
        for (RoundedButton button : buttons) {
            mmp.getLayeredPane().add(button, JLayeredPane.POPUP_LAYER);
        }

        this.nodeButtonMap = new HashMap<>();
        Helper.setNodeButtonMap(buttons, graph, nodeButtonMap);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == mmp.getAdd1Button()) { // Add Node Button
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
            if (!mmp.getAddName().trim().isEmpty()) {
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
                    mmp.setAddedEatery("\"" + name + "\"" + " added");
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
            else {
                int response = JOptionPane.showConfirmDialog(mainFrame, "Do you want to proceed with the selected nodes?", 
                                                             "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response != JOptionPane.YES_OPTION) {
                    return;
                }
            }            

            for (Node node : graph.getNodes()) {
                if (node.getId().equals(startNode)) {
                    for (Node node2 : graph.getNodes()) {
                        if (node2.getId().equals(endNode)) {
                            int distance = (int) Helper.calcDist(node, node2);
                            graph.addEdges(node, node2, distance);
                            mmp.setAddedEdges("Eatery \"" + startNode + "\" to " + "Eatery \"" + endNode + "\" connected");
                            break;
                        }
                    }
                }
            }
        }
        else if (source == mmp.getRmvButton()) { // Remove Eatery Button
            String eateryToRemove = mmp.getRmvPlace().trim();

            int response = JOptionPane.showConfirmDialog(mainFrame, 
            "Are you sure you want to remove " + eateryToRemove + "?", 
            "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        
            if (response != JOptionPane.YES_OPTION) {
                return;
            }

            for (Node node : graph.getNodes()) {
                if (node.getId().equals(eateryToRemove)) {
                    node.setState("vacant");
                    RoundedButton button = nodeButtonMap.get(node);
                    if (button != null) {
                        button.setBackground(Helper.cGray);
                        button.setEnabled(true);
                        
                        mmp.updateAllComboBoxes(graph.getEateryNodes(), graph.getAllNodes());
                        mmp.setRemovedEatery("\"" + node.getId() + "\"" + " is set to vacant");
                        break;
                    }
                }
            }
        }

        else {
            throw new UnsupportedOperationException("UNSUPPORTED ACTION: " + source);
        }

    }

}
