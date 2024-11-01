package intsy.group7.pathfinder_sim.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.OverlayLayout;
import java.awt.BorderLayout;

import intsy.group7.pathfinder_sim.model.Graph;
import intsy.group7.pathfinder_sim.model.Node;
import intsy.group7.pathfinder_sim.view.*;
import intsy.group7.pathfinder_sim.view.asset.RoundedButton;
import intsy.group7.pathfinder_sim.view.subpage.*;

public class MainController implements ActionListener {

    private final DefaultPage       defaultPage;
    private final PathFinderPage    pathFinderPage;
    private final ViewAlgorithmPage viewAlgorithmPage;
    private final AboutPage         aboutPage;
    private final ManageMapPage     manageMapPage;

    private final JFrame            mainFrame;
    private final JLayeredPane      layeredPaneContainer;

    /**
     * Initializes the MainController with a specified Graph model.
     * Sets up all the pages and controllers, the main frame, and page transitions.
     *
     * @param graph the Graph model containing nodes and edges for pathfinding.
     */
    public MainController(Graph graph) {
        this.mainFrame = new JFrame();
        this.layeredPaneContainer = new JLayeredPane();

        this.defaultPage = new DefaultPage();
        this.pathFinderPage = new PathFinderPage();
        this.viewAlgorithmPage = new ViewAlgorithmPage();
        this.aboutPage = new AboutPage();
        this.manageMapPage = new ManageMapPage();

        setupMainFrame();
        setupControllers(graph);
        setupPages();
        setupListeners();

        mainFrame.setVisible(true);
    }

    /**
     * Sets up the main JFrame properties and layout.
     */
    private void setupMainFrame() {
        mainFrame.setLocationRelativeTo(null); // Center JFrame on screen
        mainFrame.getContentPane().setLayout(new BorderLayout());
        mainFrame.getContentPane().add(layeredPaneContainer, BorderLayout.CENTER);
        layeredPaneContainer.setLayout(new OverlayLayout(layeredPaneContainer));
    }

    /**
     * Initializes all sub-controllers responsible for specific pages and functionality.
     *
     * @param graph the Graph model passed to each sub-controller.
     */
    private void setupControllers(Graph graph) {
        HashMap<Node, RoundedButton> nodeButtonMap = new HashMap<>();
        new ManageMapController(graph, manageMapPage, pathFinderPage, mainFrame, nodeButtonMap);
        new PathFinderController(graph, pathFinderPage, mainFrame, nodeButtonMap);
    }

    /**
     * Configures and adds all pages to the layered pane for display.
     */
    private void setupPages() {
        defaultPage.launchDefaultPage(mainFrame);
        viewAlgorithmPage.launchViewAlgorithmPage();
        aboutPage.launchAboutPage();

        addPageLayer(defaultPage.getSecondaryLayer(), 1);
        addPageLayer(defaultPage.getMainLayer(), 2);
        addPageLayer(pathFinderPage.getLayeredPane(), 3);
        addPageLayer(manageMapPage.getLayeredPane(), 4);
        addPageLayer(viewAlgorithmPage.getLayeredPane(), 5);
        addPageLayer(aboutPage.getLayeredPane(), 6);
    }

    /**
     * Adds a page to the layered pane if the layer is not null.
     *
     * @param layerPane the JLayeredPane representing a page
     * @param layerIndex the index to display this layer
     */
    private void addPageLayer(JLayeredPane layerPane, int layerIndex) {
        if (layerPane == null) {
            System.err.println("Warning: Attempted to add a null JLayeredPane at layer index " + layerIndex);
            return;
        }
        layeredPaneContainer.add(layerPane, layerIndex);
    }

    /**
     * Sets up action listeners for the default page's navigation buttons.
     */
    private void setupListeners() {
        defaultPage.addClickListener(this);
    }

    /**
     * Resets all pages by hiding their respective layered panes.
     */
    private void resetPages() {
        pathFinderPage.getLayeredPane().setVisible(false);
        manageMapPage.getLayeredPane().setVisible(false);
        viewAlgorithmPage.getLayeredPane().setVisible(false);
        aboutPage.getLayeredPane().setVisible(false);
    }

    /**
     * Handles user actions from the DefaultPage buttons.
     * Controls page transitions and application exit.
     *
     * @param e the ActionEvent triggered by a button click
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        // Hide the main default layer on any navigation action
        defaultPage.getMainLayer().setVisible(false);

        if (source == defaultPage.getPathFinderButton()) {
            navigateToPage(pathFinderPage);
        }
        else if (source == defaultPage.getManageMapButton()) {
            navigateToPage(manageMapPage);
        }
        else if (source == defaultPage.getViewAlgosButton()) {
            navigateToPage(viewAlgorithmPage);
        }
        else if (source == defaultPage.getAboutButton()) {
            navigateToPage(aboutPage);
        }
        else if (source == defaultPage.getExitButton()) {
            System.exit(0);
        }
        else {
            throw new UnsupportedOperationException("Unsupported action: " + source);
        }
    }

    /**
     * Navigates to the specified page by resetting visibility of all pages,
     * then showing the selected page.
     *
     * @param page the page to navigate to
     */
    private void navigateToPage(SubPage page) {
        resetPages();
        page.getLayeredPane().setVisible(true);
    }
}
