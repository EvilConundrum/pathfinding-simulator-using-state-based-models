package intsy.group7.pathfinder_sim.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import intsy.group7.pathfinder_sim.model.Graph;
import intsy.group7.pathfinder_sim.model.Node;
import intsy.group7.pathfinder_sim.view.asset.RoundedButton;
import intsy.group7.pathfinder_sim.helper.Helper;

public class NodeMaker {

    private static RoundedButton currentClickedButton = null;
    private static RoundedButton lastClickedButton = null;

    /**
     * Creates buttons representing nodes in the graph, setting properties based on the mode.
     *
     * @param graph The graph containing nodes.
     * @param mode  The mode that determines button appearance and state.
     * @return Array of RoundedButton objects representing the nodes.
     */
    public static RoundedButton[] getButtons(Graph graph, String mode) {
        RoundedButton[] roundButtons = new RoundedButton[graph.getNodes().size()];

        for (int i = 0; i < roundButtons.length; i++) {
            Node node = graph.getNodes().get(i);
            roundButtons[i] = createButton(node, mode);
            if (mode.equalsIgnoreCase("ManageMap")) 
                roundButtons[i].addActionListener(new ButtonClickListener());
        }
        return roundButtons;
    }

    /**
     * Creates a button for a node with appearance settings based on its state and mode.
     *
     * @param node The node represented by the button.
     * @param mode The mode that determines button appearance and behavior.
     * @return Configured RoundedButton object for the node.
     */
    private static RoundedButton createButton(Node node, String mode) {
        Point location = new Point(node.getXCoord(), node.getYCoord());
        RoundedButton button = new RoundedButton(node.getId());

        button.setFont(new Font("Helvetica", Font.BOLD, 10));
        button.setForeground(Helper.WHITE);
        button.setBounds(location.x, location.y, 22, 22);
        button.setBorder(null);
        button.setContentAreaFilled(true);
        button.setCustomBorderColor(Helper.WHITE);
        button.setCustomBorderThickness(2);

        // Apply visual settings based on node state and mode
        configureButtonAppearance(button, node, mode);

        return button;
    }

    /**
     * Configures the button's appearance based on the node state and mode.
     *
     * @param button The button to configure.
     * @param node   The node associated with the button.
     * @param mode   The mode that determines button appearance.
     */
    private static void configureButtonAppearance(RoundedButton button, Node node, String mode) {
        String state = node.getState().toLowerCase();

        if (mode.equalsIgnoreCase("ManageMap")) {
            setManageMapAppearance(button, state);
        } else if (mode.equalsIgnoreCase("PathFinder")) {
            setPathFinderAppearance(button, state);
        }
    }

    /**
     * Sets the appearance for ManageMap mode based on the node state.
     */
    private static void setManageMapAppearance(RoundedButton button, String state) {
        switch (state) {
            case "road":
                button.setEnabled(false);
                button.setVisible(true);
                button.setOpaque(false);
                button.setBackground(Helper.LIGHT_GRAY);
                button.setCustomBorderColor(Helper.DARK_GRAY);
                break;
            case "eatery":
                button.setBackground(Color.YELLOW);
                button.setOpaque(false);
                button.setEnabled(false);
                break;
            case "vacant":
                button.setBackground(Helper.MAROON_RED);
                button.setOpaque(false);
                break;
        }
    }

    /**
     * Sets the appearance for PathFinder mode based on the node state.
     */
    private static void setPathFinderAppearance(RoundedButton button, String state) {
        switch (state) {
            case "road":
                button.setBackground(Helper.BLACK);
                button.setOpaque(false);
                button.setEnabled(false);
                break;
            case "eatery":
                button.setBackground(Helper.NEON_YELLOW);
                button.setOpaque(false);
                button.setEnabled(false);
                break;
            case "vacant":
                button.setBackground(Helper.MAROON_RED);
                button.setOpaque(false);
                break;
        }
    }

    public static RoundedButton getClickedButton() {
        return currentClickedButton;
    }

    /**
     * Inner class to handle button click events.
     */
    static class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentClickedButton = (RoundedButton) e.getSource();

            // Reset the color of the last clicked button
            if (lastClickedButton != null && lastClickedButton.getBackground() != Color.YELLOW) {
                lastClickedButton.setBackground(Helper.MAROON_RED);
            }

            // Set the color of the currently clicked button to green
            currentClickedButton.setBackground(Color.GREEN);
            lastClickedButton = currentClickedButton;
        }
    }
}
