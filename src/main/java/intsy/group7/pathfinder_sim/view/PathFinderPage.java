package intsy.group7.pathfinder_sim.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class PathFinderPage {
    ImageIcon map = new ImageIcon("src/main/java/intsy/group7/pathfinder_sim/view/images/MapDLSU.png");
    ImageIcon pathFinderImg = new ImageIcon("src/main/java/intsy/group7/pathfinder_sim/view/images/PathFinder.png");
    ImageIcon manageMapImg = new ImageIcon("src/main/java/intsy/group7/pathfinder_sim/view/images/ManageMap.png");
    ImageIcon viewAlgosImg = new ImageIcon("src/main/java/intsy/group7/pathfinder_sim/view/images/ViewAlgos.png");
    ImageIcon aboutImg = new ImageIcon("src/main/java/intsy/group7/pathfinder_sim/view/images/About.png");
    ImageIcon exitImg = new ImageIcon("src/main/java/intsy/group7/pathfinder_sim/view/images/Exit.png");
    ImageIcon logoImg = new ImageIcon("src/main/java/intsy/group7/pathfinder_sim/view/images/LogoTHA.png"); 

    JLabel pathFinderLbl;
    JLabel manageMapLbl;
    JLabel viewAlgosLbl;
    JLabel aboutLbl;
    JLabel exitLbl;
    JLabel traversalLbl;
    JLabel pathCostLbl;
    JLabel pathLbl;

    JTextArea pathText, traversalText;

    IconButton pathFinderButton;
    IconButton manageMapButton;
    IconButton viewAlgosButton;
    IconButton aboutButton;
    IconButton exitButton;

    RoundedButton subButton;

    JLayeredPane layeredPane;

    JPanel mapPanel;

    JComboBox<String> fromMenu;
    JComboBox<String> toMenu;
    JComboBox<String> algoMenu;

    Color greenTHA = new Color(0, 105, 55);
    Color greenText = new Color(5, 65, 3);
    Color greenTHA2 = new Color(0, 112, 60);


    //@param MainFrame & list of locations
    public void launchPathFinderPage(JFrame mainFrame, String[] locations, String[] algorithms){

        // Header panel
        JPanel pageHeader = new JPanel();
        pageHeader.setBounds(0, 0, 1275, 60);
        pageHeader.setBackground(greenTHA);

        JLabel labelHeader = new JLabel("The Bow & Bite Map");
        labelHeader.setFont(new Font("Tahoma", Font.BOLD, 23));
        labelHeader.setBounds(70, 10, 300, 40);
        labelHeader.setForeground(Color.WHITE);

        ImageIcon lgHeader = new ImageIcon(logoImg.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

        JLabel logoHeader = new JLabel(lgHeader);
        logoHeader.setBackground(greenTHA);
        logoHeader.setBounds(1, -5, 70, 70);

        //button images
        ImageIcon scaledPathFinderImg = new ImageIcon(pathFinderImg.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
        ImageIcon scaledManageMapImg = new ImageIcon(manageMapImg.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        ImageIcon scaledViewAlgosImg = new ImageIcon(viewAlgosImg.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        ImageIcon scaledAboutImg = new ImageIcon(aboutImg.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        ImageIcon scaledExitImg = new ImageIcon(exitImg.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));

        // Jpanel for map
        mapPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(map.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        mapPanel.setBounds(385, 60, 890, 630);

        // LayeredPane for positioning
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1920, 1080));
        layeredPane.setBackground(Color.WHITE);

        // buttons
        pathFinderButton = new IconButton(scaledPathFinderImg);
        pathFinderButton.setBounds(-55, 100, 180, 40); 
        pathFinderButton.setBorder(null);

        manageMapButton = new IconButton(scaledManageMapImg);
        manageMapButton.setBounds(-55, 180, 180, 40); 
        manageMapButton.setBorder(null);

        viewAlgosButton = new IconButton(scaledViewAlgosImg);
        viewAlgosButton.setBounds(-55, 260, 180, 40); 
        viewAlgosButton.setBorder(null);

        aboutButton = new IconButton(scaledAboutImg);
        aboutButton.setBounds(-55, 340, 180, 40); 
        aboutButton.setBorder(null);

        exitButton = new IconButton(scaledExitImg);
        exitButton.setBounds(-55, 420, 180, 40); 
        exitButton.setBorder(null);

        //Submit Button (disable after click)
        subButton = new RoundedButton("Submit");
        subButton.setFont(new Font("Helvetica", Font.BOLD, 14));
        subButton.setForeground(Color.WHITE);
        subButton.setBackground(greenTHA2);
        subButton.setBounds(175, 320, 100, 35); 
        subButton.setOpaque(true); 
        subButton.setBorder(null);
        subButton.setContentAreaFilled(true); 
        subButton.setCustomBorderColor(Color.WHITE); 
        subButton.setCustomBorderThickness(2);

        //button label
        pathFinderLbl = new JLabel("Path Finder");
        pathFinderLbl.setFont(new Font("Futura", Font.PLAIN, 8));
        pathFinderLbl.setBounds(13, 120, 300, 40);
        pathFinderLbl.setForeground(greenText);

        manageMapLbl = new JLabel("Manage Map");
        manageMapLbl.setFont(new Font("Futura", Font.PLAIN, 8));
        manageMapLbl.setBounds(13, 200, 300, 40);
        manageMapLbl.setForeground(greenText);

        viewAlgosLbl = new JLabel("View Algorithms");
        viewAlgosLbl.setFont(new Font("Futura", Font.PLAIN, 8));
        viewAlgosLbl.setBounds(8, 285, 300, 40);
        viewAlgosLbl.setForeground(greenText);

        aboutLbl = new JLabel("About");
        aboutLbl.setFont(new Font("Futura", Font.PLAIN, 8));
        aboutLbl.setBounds(25, 365, 300, 40);
        aboutLbl.setForeground(greenText);

        exitLbl = new JLabel("Exit");
        exitLbl.setFont(new Font("Futura", Font.PLAIN, 8));
        exitLbl.setBounds(28, 445, 300, 40);
        exitLbl.setForeground(greenText);

        // Vertical Divider
        JSeparator verticalLine = new JSeparator(SwingConstants.VERTICAL);
        verticalLine.setBounds(75, 20, 10, 700);  
        verticalLine.setForeground(greenTHA);    
        
        //Labels (From, To, & Algorithm)
        JLabel locLbl = new JLabel("Locations");
        locLbl.setFont(new Font("Futura", Font.BOLD,18));
        locLbl.setBounds(180, 90, 300, 40);
        locLbl.setForeground(greenText);

        JLabel fromLbl = new JLabel("From:");
        fromLbl.setFont(new Font("Futura", Font.BOLD, 15));
        fromLbl.setBounds(95, 130, 300, 40);
        fromLbl.setForeground(greenText);

        JLabel toLbl = new JLabel("To:");
        toLbl.setFont(new Font("Futura", Font.BOLD, 15));
        toLbl.setBounds(95,160, 300, 40);
        toLbl.setForeground(greenText);

        JLabel algoLbl = new JLabel("Algorithm");
        algoLbl.setFont(new Font("Futura", Font.BOLD, 18));
        algoLbl.setBounds(180,220, 300, 40);
        algoLbl.setForeground(greenText);


        //Dropdown Menu
        fromMenu = new JComboBox<String>(locations);
        fromMenu.setVisible(true);
        fromMenu.setBounds(140,140,230,25);

        toMenu = new JComboBox<String>(locations);
        toMenu.setVisible(true);
        toMenu.setBounds(140,170,230,25);

        algoMenu = new JComboBox<String>(algorithms);
        algoMenu.setVisible(true);
        algoMenu.setBounds(95,260,275,25);

        // Label display
        traversalLbl = new JLabel("Traversal: ");
        traversalLbl.setFont(new Font("Futura", Font.BOLD,18));
        traversalLbl.setBounds(400, 42, 800, 80);
        traversalLbl.setForeground(Color.WHITE);

        pathLbl = new JLabel("Path: ");
        pathLbl.setFont(new Font("Futura", Font.BOLD,18));  
        pathLbl.setBounds(400, 184, 800, 40);
        pathLbl.setForeground(Color.WHITE);

        // LayeredPane Components
        layeredPane.add(pageHeader, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(logoHeader, JLayeredPane.POPUP_LAYER);
        layeredPane.add(labelHeader, JLayeredPane.POPUP_LAYER);

        layeredPane.add(pathFinderButton, JLayeredPane.POPUP_LAYER);
        layeredPane.add(manageMapButton, JLayeredPane.POPUP_LAYER);
        layeredPane.add(viewAlgosButton, JLayeredPane.POPUP_LAYER);
        layeredPane.add(aboutButton, JLayeredPane.POPUP_LAYER);
        layeredPane.add(exitButton, JLayeredPane.POPUP_LAYER);
        layeredPane.add(subButton, JLayeredPane.POPUP_LAYER);

        layeredPane.add(pathFinderLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(manageMapLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(viewAlgosLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(aboutLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(exitLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(locLbl, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(fromLbl, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(toLbl, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(algoLbl, JLayeredPane.PALETTE_LAYER);

        layeredPane.add(fromMenu, JLayeredPane.POPUP_LAYER);
        layeredPane.add(toMenu, JLayeredPane.POPUP_LAYER);
        layeredPane.add(algoMenu, JLayeredPane.POPUP_LAYER);

        layeredPane.add(verticalLine, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(mapPanel, JLayeredPane.DEFAULT_LAYER);

        layeredPane.add(traversalLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(pathLbl, JLayeredPane.POPUP_LAYER);

        // JFrame 
        mainFrame.setTitle("The Bow & Bite Map");
        mainFrame.setSize(1275, 700);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);

        // backgroundPanel and layeredPane on JFrame
        mainFrame.getContentPane().setLayout(new BorderLayout());
        mainFrame.getContentPane().add(layeredPane, BorderLayout.CENTER);

        mainFrame.setLocationRelativeTo(null); // Center JFrame on screen
    }


    //actionListener
    public void addClickListener(ActionListener listener) {
        this.pathFinderButton.addActionListener(listener);
        this.manageMapButton.addActionListener(listener);
        this.viewAlgosButton.addActionListener(listener);
        this.aboutButton.addActionListener(listener);
        this.exitButton.addActionListener(listener);
        this.subButton.addActionListener(listener);
    }

    //returns the layeredPane
    public JLayeredPane getLayeredPane(){
        return this.layeredPane;
    }

    //returns map panel
    public JPanel getMap(){
        return this.mapPanel;
    }

    //returns dropdown menu value
    public String fromDrop(){
        return (String) this.fromMenu.getSelectedItem();
    }

    public String toDrop(){
        return (String) this.toMenu.getSelectedItem();
    }

    public String algoDrop(){
        return (String) this.algoMenu.getSelectedItem();
    }

    public void updateAllComboBoxes(String[] locations){
        this.fromMenu.setModel(new DefaultComboBoxModel<String>(locations));
        this.toMenu.setModel(new DefaultComboBoxModel<String>(locations));


    }

    //returns IconButton buttons (jic needed)
    public IconButton getPathFinderButton(){
        return this.pathFinderButton;
    }

    public IconButton getManageMapButton(){
        return this.manageMapButton;
    }

    public IconButton getViewAlgosButton(){
        return this.viewAlgosButton;
    }

    public IconButton getAboutButton(){
        return this.aboutButton;
    }

    public IconButton getExitButton(){
        return this.exitButton;
    }

    public RoundedButton getSubmitButton() {
        return this.subButton;
    }

    public void addPathCost(int pathCost, String traversal, String path) {
        traversalText = new JTextArea();
        traversalText.setText(traversal);
        traversalText.setEditable(false);
        traversalText.setFont(new Font("Futura", Font.BOLD,15));
        traversalText.setBounds(494, 72, 800, 150);
        traversalText.setOpaque(false);
        traversalText.setForeground(Color.WHITE);

        pathCostLbl = new JLabel("Cost: " + pathCost);
        pathCostLbl.setFont(new Font("Futura", Font.BOLD, 16));
        pathCostLbl.setBounds(400, 160, 300, 40);
        pathCostLbl.setForeground(Color.RED);


        pathText = new JTextArea();
        pathText.setText(path);
        pathText.setEditable(false);
        pathText.setFont(new Font("Futura", Font.BOLD,15));
        pathText.setBounds(453, 194, 800, 100);
        pathText.setOpaque(false);
        pathText.setForeground(Color.WHITE);

        layeredPane.add(traversalText, JLayeredPane.POPUP_LAYER);
        layeredPane.add(pathCostLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(pathText, JLayeredPane.POPUP_LAYER);
    }

    public JLabel getTraversalLbl() {
        return traversalLbl;
    }
    public JLabel getPathCostLbl() {
        return pathCostLbl;
    }
    public JLabel getPathLbl() {
        return pathLbl;
    }

    public JTextArea getPathText() {
        return pathText;
    }
    public JTextArea getTraversalText() {
        return traversalText;
    }

}
