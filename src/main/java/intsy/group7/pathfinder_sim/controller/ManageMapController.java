package intsy.group7.pathfinder_sim.controller;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.util.HashMap;

import intsy.group7.pathfinder_sim.helper.Helper;
import intsy.group7.pathfinder_sim.model.*;
import intsy.group7.pathfinder_sim.view.asset.RoundedButton;
import intsy.group7.pathfinder_sim.view.subpage.ManageMapPage;
import intsy.group7.pathfinder_sim.view.subpage.PathFinderPage;

public class ManageMapController implements ActionListener {

    private final Graph             graph;
    private final ManageMapPage manageMapPage;
    private final PathFinderPage pathFinderPage;
    private final JFrame            mainFrame;

    private final HashMap<Node, RoundedButton> nodeButtonMap;

    public ManageMapController(Graph graph, ManageMapPage manageMapPage, PathFinderPage pathFinderPage,
                               JFrame mainFrame, HashMap<Node, RoundedButton> nodeButtonMap) {

        this.graph = graph;

        this.manageMapPage = manageMapPage;
        this.mainFrame = mainFrame;
        this.nodeButtonMap = nodeButtonMap;

        this.pathFinderPage = pathFinderPage;

        String[] locations = graph.getEateryNodes();  // Set current locations as all eatery nodes
        String[] nodes = graph.getAllNodes();

        manageMapPage.launchManageMapPage(locations, nodes);
        manageMapPage.addClickListener(this);

        HashMap<String, RoundedButton> stringButtonMap = new HashMap<>();
        Helper.assignButtons(graph, manageMapPage.getLayeredPane(), "ManageMap",
                             this.nodeButtonMap, stringButtonMap);
    }

    /**
     * Handles the process of adding a node to the graph.
     */
    private void runAddNodeEvent() {
        String name = manageMapPage.getAddName().trim();
        boolean isDefault = false;

        if (!validateNodeSelection() || !validateHeuristicInput()) {
            return;
        }

        if (name.isEmpty()) {
            if (!handleEmptyNodeName()) {
                return;
            }
            isDefault = true;
            name = NodeMaker.getClickedButton().getText();
        }

        if (!validateNameLength(name) || !validateNameRestrictions(name)) {
            return;
        }

        int heuristic1 = Integer.parseInt(manageMapPage.getfTraf().trim());

        if (!isDefault && checkNodeExists(name)) {
            return;
        }

        assignNodeToEatery(name, heuristic1);
    }

    /**
     * Validates if a node has been selected by the user.
     *
     * @return true if a node is selected, false otherwise.
     */
    private boolean validateNodeSelection() {
        if (NodeMaker.getClickedButton() == null) {
            JOptionPane.showMessageDialog(mainFrame, "Please select a node", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Validates if the heuristic input field is filled.
     *
     * @return true if the heuristic is provided, false otherwise.
     */
    private boolean validateHeuristicInput() {
        if (manageMapPage.getfTraf().trim().isEmpty()) {
            JOptionPane.showMessageDialog(mainFrame, "Please enter a heuristic", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Handles the scenario where the node name is left empty. It asks the user
     * for confirmation to use the default name (button text) and sets the heuristic value.
     *
     * @return true if the user confirms, false otherwise.
     */
    private boolean handleEmptyNodeName() {
        int heuristic1 = Integer.parseInt(manageMapPage.getfTraf().trim());
        if (heuristic1 <= 0) {
            JOptionPane.showMessageDialog(mainFrame, "Please enter a name", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        int response = JOptionPane.showConfirmDialog(mainFrame,
                "Do you want to keep the existing name: \"" + NodeMaker.getClickedButton().getText() +
                        "\" and set Foot Traffic to " + heuristic1 + "?",
                "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(mainFrame, "Please enter a name", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Validates that the length of the node name is at most 2 characters.
     *
     * @param name The name of the node.
     * @return true if the length is valid, false otherwise.
     */
    private boolean validateNameLength(String name) {
        if (name.length() > 2) {
            JOptionPane.showMessageDialog(mainFrame, "Max char for name is 2", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Validates that the name does not start with 'R' or 'S'.
     *
     * @param name The name of the node.
     * @return true if the name is valid, false otherwise.
     */
    private boolean validateNameRestrictions(String name) {
        if (name.startsWith("R") || name.startsWith("S")) {
            JOptionPane.showMessageDialog(mainFrame, "Name cannot start with 'R' or 'S'", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        int response = JOptionPane.showConfirmDialog(mainFrame,
                "Name and heuristics are valid. Do you want to proceed?",
                "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        return response == JOptionPane.YES_OPTION;
    }

    /**
     * Checks if the node already exists in the graph.
     *
     * @param name The name of the node.
     * @return true if the node exists, false otherwise.
     */
    private boolean checkNodeExists(String name) {
        for (Node node : graph.getNodes()) {
            if (node.getId().equals(name)) {
                JOptionPane.showMessageDialog(mainFrame, "Node already exists");
                return true;
            }
        }
        return false;
    }

    /**
     * Assigns the vacant node to an eatery with the given name and heuristic.
     *
     * @param name       The name of the node.
     * @param heuristic1 The heuristic value.
     */
    private void assignNodeToEatery(String name, int heuristic1) {
        for (Node node : graph.getNodes()) {
            if (node.getId().equals(NodeMaker.getClickedButton().getText())) {
                RoundedButton clickedButton = NodeMaker.getClickedButton();

                updateButtonText(name, clickedButton);
                updateNodeProperties(node, name, heuristic1);
                clickedButton.setEnabled(false);

                manageMapPage.updateAllComboBoxes(graph.getEateryNodes(), graph.getAllNodes());
                pathFinderPage.updateAllComboBoxes(graph.getAllNodes());
                manageMapPage.setAddedEatery("\"" + name + "\"" + " added");
                break;
            }
        }
    }

    /**
     * Updates the button text and modifies its properties in the pathFinderPage.
     *
     * @param name          The new name for the node.
     * @param clickedButton The button clicked by the user.
     */
    private void updateButtonText(String name, RoundedButton clickedButton) {
        for (HashMap.Entry<String, RoundedButton> entry : pathFinderPage.getStringButtonMap().entrySet()) {
            if (entry.getKey().equals(clickedButton.getText())) {
                RoundedButton button = entry.getValue();
                button.setBackground(Color.YELLOW);
                button.setText(name);

                pathFinderPage.getStringButtonMap().remove(entry.getKey());
                pathFinderPage.getStringButtonMap().put(name, button);
                break;
            }
        }
    }

    /**
     * Updates the node's properties to reflect the newly assigned eatery.
     *
     * @param node       The node being updated.
     * @param name       The new name for the node.
     * @param heuristic1 The heuristic value.
     */
    private void updateNodeProperties(Node node, String name, int heuristic1) {
        node.setId(name);
        node.setState("eatery");
        node.setHeuristic(heuristic1 * 5);
    }


    /**
     * Handles the event of adding an edge between two nodes (eateries).
     */
    private void runAddEdgeEvent() {
        String startNode = manageMapPage.getStartNode();
        String endNode = manageMapPage.getEndNode();

        if (!validateDifferentNodes(startNode, endNode) || !confirmNodeSelection()) {
            return;
        }

        addEdgeBetweenNodes(startNode, endNode);
    }

    /**
     * Validates that the start and end nodes are not the same.
     *
     * @param startNode The starting node (eatery).
     * @param endNode   The ending node (eatery).
     * @return true if the nodes are different, false otherwise.
     */
    private boolean validateDifferentNodes(String startNode, String endNode) {
        if (startNode.equals(endNode)) {
            JOptionPane.showMessageDialog(mainFrame, "Start and End nodes cannot be the same",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Confirms if the user wants to proceed with the selected nodes.
     *
     * @return true if the user confirms, false otherwise.
     */
    private boolean confirmNodeSelection() {
        int response = JOptionPane.showConfirmDialog(mainFrame,
                "Do you want to proceed with the selected nodes?",
                "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        return response == JOptionPane.YES_OPTION;
    }

    /**
     * Adds an edge between the start and end nodes by calculating the distance and
     * updating the graph.
     *
     * @param startNode The starting node (eatery).
     * @param endNode   The ending node (eatery).
     */
    private void addEdgeBetweenNodes(String startNode, String endNode) {
        Node start = getNodeById(startNode);
        Node end = getNodeById(endNode);

        if (start != null && end != null) {
            int distance = (int) Helper.calcDist(start, end);
            graph.addEdges(start, end, distance);
            manageMapPage.setAddedEdges("Eatery \"" + startNode + "\" to \"Eatery \"" + endNode + "\" connected");
        }
    }

    /**
     * Retrieves a node from the graph by its ID.
     *
     * @param nodeId The ID of the node.
     * @return The node object if found, null otherwise.
     */
    private Node getNodeById(String nodeId) {
        for (Node node : graph.getNodes()) {
            if (node.getId().equals(nodeId)) {
                return node;
            }
        }
        return null;
    }

    /**
     * Handles the event of removing an eatery (setting its state to vacant).
     */
    private void runRemoveEateryEvent() {
        String eateryToRemove = manageMapPage.getRmvPlace().trim();

        if (!confirmEateryRemoval(eateryToRemove)) {
            return;
        }

        removeEatery(eateryToRemove);
    }

    /**
     * Confirms if the user wants to remove the specified eatery.
     *
     * @param eateryToRemove The eatery to remove.
     * @return true if the user confirms, false otherwise.
     */
    private boolean confirmEateryRemoval(String eateryToRemove) {
        int response = JOptionPane.showConfirmDialog(mainFrame,
                "Are you sure you want to remove " + eateryToRemove + "?",
                "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        return response == JOptionPane.YES_OPTION;
    }

    /**
     * Removes the eatery by setting its state to vacant and updating the UI.
     *
     * @param eateryToRemove The eatery to remove.
     */
    private void removeEatery(String eateryToRemove) {
        Node node = getNodeById(eateryToRemove);

        if (node == null) {
            return;
        }

        node.setState("vacant");
        RoundedButton button = nodeButtonMap.get(node);
        RoundedButton button2 = pathFinderPage.getStringButtonMap().get(node.getId());

        if (button == null) {
            return;
        }

        resetButtonToVacantState(button, button2);
        manageMapPage.updateAllComboBoxes(graph.getEateryNodes(), graph.getAllNodes());
        manageMapPage.setRemovedEatery("\"" + node.getId() + "\"" + " is set to vacant");
    }

    /**
     * Resets the button appearance and functionality when the eatery is set to vacant.
     *
     * @param button The button associated with the eatery.
     */
    private void resetButtonToVacantState(RoundedButton button, RoundedButton button2) {
        button.setBackground(Helper.MAROON_RED);
        button.setEnabled(true);

        button2.setBackground(Helper.MAROON_RED);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == manageMapPage.getAdd1Button()) { // Add Node Button
            runAddNodeEvent();
        }
        else if (source == manageMapPage.getAdd2Button()) { // Add Edge Button
            runAddEdgeEvent();
        }
        else if (source == manageMapPage.getRmvButton()) { // Remove Eatery Button
            runRemoveEateryEvent();
        }
        else {
            throw new UnsupportedOperationException("UNSUPPORTED ACTION: " + source);
        }
    }
}
