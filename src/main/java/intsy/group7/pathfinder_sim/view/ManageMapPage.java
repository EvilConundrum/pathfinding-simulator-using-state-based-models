package intsy.group7.pathfinder_sim.view;

import java.awt.*;
import javax.swing.*;

import intsy.group7.pathfinder_sim.helper.Helper;

import java.awt.event.ActionListener;

public class ManageMapPage extends JPanel {
    
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

    JTextArea addedEatery, removedEatery;

    IconButton pathFinderButton;
    IconButton manageMapButton;
    IconButton viewAlgosButton;
    IconButton aboutButton;
    IconButton exitButton;

    RoundedButton add1Button;
    RoundedButton add2Button;
    RoundedButton rmvButton;

    JLayeredPane layeredPane;

    JPanel mapPanel;

    JTextField addName;
    JFormattedTextField fTraf;

    JComboBox<String> startNode;
    JComboBox<String> endNode;
    JComboBox<String> rmvPlace;

    DefaultComboBoxModel<String> rmvPlaceModel;

    Color greenTHA = new Color(0, 105, 55);
    Color greenText = new Color(5, 65, 3);
    Color greenTHA2 = new Color(0, 112, 60);
    Color noRed = new Color(188, 24, 35);



    //@param MainFrame & list of locations
    public void launchManageMapPage(JFrame mainFrame, String[] locations, String[] nodes){

        // Header panel
        JPanel pageHeader = new JPanel();
        pageHeader.setBounds(0, 0, 1500, 60);
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

        //tab buttons
        add1Button = new RoundedButton("Add");
        add1Button.setFont(new Font("Helvetica", Font.BOLD, 14));
        add1Button.setForeground(Color.WHITE);
        add1Button.setBackground(greenTHA2);
        add1Button.setBounds(185, 225, 100, 30); 
        add1Button.setOpaque(true); 
        add1Button.setBorder(null);
        add1Button.setContentAreaFilled(true); 
        add1Button.setCustomBorderColor(Color.WHITE); 
        add1Button.setCustomBorderThickness(2);

        add2Button = new RoundedButton("Add");
        add2Button.setFont(new Font("Helvetica", Font.BOLD, 14));
        add2Button.setForeground(Color.WHITE);
        add2Button.setBackground(greenTHA2);
        add2Button.setBounds(185, 425, 100, 30); 
        add2Button.setOpaque(true); 
        add2Button.setBorder(null);
        add2Button.setContentAreaFilled(true); 
        add2Button.setCustomBorderColor(Color.WHITE); 
        add2Button.setCustomBorderThickness(2);

        rmvButton = new RoundedButton("Remove");
        rmvButton.setFont(new Font("Helvetica", Font.BOLD, 14));
        rmvButton.setForeground(Color.WHITE);
        rmvButton.setBackground(noRed);
        rmvButton.setBounds(185, 590, 100, 30); 
        rmvButton.setOpaque(true); 
        rmvButton.setBorder(null);
        rmvButton.setContentAreaFilled(true); 
        rmvButton.setCustomBorderColor(Color.WHITE); 
        rmvButton.setCustomBorderThickness(2);

        // Resulting Text
        addedEatery = new JTextArea();
        addedEatery.setFont(new Font("Futura", Font.BOLD, 15));
        addedEatery.setBounds(185, 270, 300, 50);
        addedEatery.setForeground(Helper.noBlue);
        addedEatery.setOpaque(false);

        removedEatery = new JTextArea();
        removedEatery.setFont(new Font("Futura", Font.BOLD, 15));
        removedEatery.setBounds(185, 627, 300, 50);
        removedEatery.setForeground(Helper.noRed);
        removedEatery.setOpaque(false);

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
        
        //Labels (add/remove) and Instructions (pick)
        JLabel addFpLbl = new JLabel("Add a Food Place");
        addFpLbl.setFont(new Font("Futura", Font.BOLD,16));
        addFpLbl.setBounds(162, 90, 300, 40);
        addFpLbl.setForeground(greenText);

        JLabel insLbl = new JLabel("Pick a location first");
        insLbl.setFont(new Font("Futura", Font.PLAIN,11));
        insLbl.setBounds(180, 111, 300, 40);
        insLbl.setForeground(greenText);

        JLabel addNameLbl = new JLabel("Name: ");
        addNameLbl.setFont(new Font("Futura", Font.BOLD,12));
        addNameLbl.setBounds(100, 140, 300, 40);
        addNameLbl.setForeground(greenText);

        JLabel ftTrafbl = new JLabel("Foot Traffic:");
        ftTrafbl.setFont(new Font("Futura", Font.BOLD,12));
        ftTrafbl.setBounds(100, 170, 300, 40);
        ftTrafbl.setForeground(greenText);

        JLabel edgesLbl = new JLabel("Edges");
        edgesLbl.setFont(new Font("Futura", Font.BOLD,16));
        edgesLbl.setBounds(215, 300, 300, 40);
        edgesLbl.setForeground(greenText);

        JLabel sNodeLbl = new JLabel("Start Node:");
        sNodeLbl.setFont(new Font("Futura", Font.BOLD,12));
        sNodeLbl.setBounds(100, 335, 300, 40);
        sNodeLbl.setForeground(greenText);

        JLabel eNodeLbl = new JLabel("End Node:");
        eNodeLbl.setFont(new Font("Futura", Font.BOLD,12));
        eNodeLbl.setBounds(100, 365, 300, 40);
        eNodeLbl.setForeground(greenText);

        JLabel rmvLbl = new JLabel("Remove a Food Place");
        rmvLbl.setFont(new Font("Futura", Font.BOLD,16));
        rmvLbl.setBounds(145, 500, 300, 40);
        rmvLbl.setForeground(greenText);

        JLabel rmvNameLbl = new JLabel("Name: ");
        rmvNameLbl.setFont(new Font("Futura", Font.BOLD,12));
        rmvNameLbl.setBounds(100, 530, 300, 40);
        rmvNameLbl.setForeground(greenText);

        //text fields
        addName = new JTextField();
        addName.setColumns(15);
        addName.setBounds(145, 150, 220, 25);

        fTraf = new JFormattedTextField();
        Helper.updateNumberFieldFormatter(fTraf, 1, 20, Integer.class);
        fTraf.setColumns(15);
        fTraf.setBounds(180, 180, 185, 25);

        //Dropdown Menu
        startNode = new JComboBox<String>(nodes);
        startNode.setVisible(true);
        startNode.setBounds(170,345,200,25);

        endNode = new JComboBox<String>(nodes);
        endNode.setVisible(true);
        endNode.setBounds(170,375,200,25);

        rmvPlace = new JComboBox<String>(locations);
        rmvPlace.setVisible(true);
        rmvPlace.setBounds(145,540,220,25);

        // LayeredPane Components
        layeredPane.add(pageHeader, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(logoHeader, JLayeredPane.POPUP_LAYER);
        layeredPane.add(labelHeader, JLayeredPane.POPUP_LAYER);

        layeredPane.add(pathFinderButton, JLayeredPane.POPUP_LAYER);
        layeredPane.add(manageMapButton, JLayeredPane.POPUP_LAYER);
        layeredPane.add(viewAlgosButton, JLayeredPane.POPUP_LAYER);
        layeredPane.add(aboutButton, JLayeredPane.POPUP_LAYER);
        layeredPane.add(exitButton, JLayeredPane.POPUP_LAYER);

        layeredPane.add(pathFinderLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(manageMapLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(viewAlgosLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(aboutLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(exitLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(addFpLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(insLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(addNameLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(ftTrafbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(edgesLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(sNodeLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(eNodeLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(rmvLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(rmvNameLbl, JLayeredPane.POPUP_LAYER);

        layeredPane.add(verticalLine, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(mapPanel, JLayeredPane.DEFAULT_LAYER);

        layeredPane.add(startNode, JLayeredPane.POPUP_LAYER);
        layeredPane.add(endNode, JLayeredPane.POPUP_LAYER);
        layeredPane.add(rmvPlace, JLayeredPane.POPUP_LAYER);

        layeredPane.add(addName, JLayeredPane.POPUP_LAYER);
        layeredPane.add(fTraf, JLayeredPane.POPUP_LAYER);
       
        layeredPane.add(add1Button, JLayeredPane.POPUP_LAYER);
        layeredPane.add(add2Button, JLayeredPane.POPUP_LAYER);
        layeredPane.add(rmvButton, JLayeredPane.POPUP_LAYER);

        layeredPane.add(addedEatery, JLayeredPane.POPUP_LAYER);
        layeredPane.add(removedEatery, JLayeredPane.POPUP_LAYER);
        

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
        this.add1Button.addActionListener(listener);
        this.add2Button.addActionListener(listener);
        this.rmvButton.addActionListener(listener);
    }

    //returns the layeredPane
    public JLayeredPane getLayeredPane(){
        return this.layeredPane;
    }

    //returns map panel
    public JPanel getMap(){
        return this.mapPanel;
    }

    //returns values from textfields
    public String getAddName(){
        return this.addName.getText();
    }

    public String getfTraf(){
        return this.fTraf.getText();
    }

    //returns textArea values
    public void setAddedEatery(String addedEatery){
        this.addedEatery.setText(addedEatery);
    }
    public void setRemovedEatery(String removedEatery){
        this.removedEatery.setText(removedEatery);
    }

    //returns dropdown menu value
    public String getStartNode(){
        return (String) this.startNode.getSelectedItem();
    }

    public String getEndNode(){
        return (String) this.endNode.getSelectedItem();
    }

    public String getRmvPlace(){
        return (String) this.rmvPlace.getSelectedItem();
    }

    public void updateAllComboBoxes(String[] locations, String[] nodes){
        this.startNode.setModel(new DefaultComboBoxModel<String>(nodes));
        this.endNode.setModel(new DefaultComboBoxModel<String>(nodes));
        this.rmvPlace.setModel(new DefaultComboBoxModel<String>(locations));
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

    // returns submit buttons
    public RoundedButton getAdd1Button(){
        return this.add1Button;
    }
    public RoundedButton getAdd2Button(){
        return this.add2Button;
    }
    public RoundedButton getRmvButton(){
        return this.rmvButton;
    }
}
