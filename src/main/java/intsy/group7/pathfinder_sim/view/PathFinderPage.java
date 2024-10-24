package intsy.group7.pathfinder_sim.view;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.event.ActionListener;
import java.util.HashMap;

import intsy.group7.pathfinder_sim.helper.Helper;

public class PathFinderPage {

    private JLabel traversalLbl, pathLbl, pathCostLbl;

    private JTextArea pathText, traversalText;

    private HashMap<String, RoundedButton> nodeButtonMap;
    private RoundedButton subButton;

    private JLayeredPane layeredPane;

    private JPanel mapPanel;

    private JComboBox<String> fromMenu, toMenu, algoMenu;

    //@param MainFrame & list of locations
    public void launchPathFinderPage(JFrame mainFrame, String[] locations, String[] algorithms){

        // Jpanel for map
        mapPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(Helper.mapImage.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        mapPanel.setBounds(385, 60, 890, 630);

        // LayeredPane for positioning
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(Helper.screenSize);
        layeredPane.setBackground(Helper.cWhite);

        //Submit Button (disable after click)
        subButton = new RoundedButton("Submit");
        subButton.setFont(new Font("Helvetica", Font.BOLD, 14));
        subButton.setForeground(Helper.cWhite);
        subButton.setBackground(Helper.cGreenTHA2);
        subButton.setBounds(175, 320, 100, 35); 
        subButton.setBorder(null);
        subButton.setContentAreaFilled(true); 
        subButton.setOpaque(false);
        subButton.setCustomBorderColor(Helper.cWhite); 
        subButton.setCustomBorderThickness(2);

        //Labels (From, To, & Algorithm)
        JLabel locLbl = new JLabel("Locations");
        locLbl.setFont(new Font("Futura", Font.BOLD,18));
        locLbl.setBounds(180, 90, 300, 40);
        locLbl.setForeground(Helper.cGreenText);

        JLabel fromLbl = new JLabel("From:");
        fromLbl.setFont(new Font("Futura", Font.BOLD, 15));
        fromLbl.setBounds(95, 130, 300, 40);
        fromLbl.setForeground(Helper.cGreenText);

        JLabel toLbl = new JLabel("To:");
        toLbl.setFont(new Font("Futura", Font.BOLD, 15));
        toLbl.setBounds(95,160, 300, 40);
        toLbl.setForeground(Helper.cGreenText);

        JLabel algoLbl = new JLabel("Algorithm");
        algoLbl.setFont(new Font("Futura", Font.BOLD, 18));
        algoLbl.setBounds(180,220, 300, 40);
        algoLbl.setForeground(Helper.cGreenText);

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
        traversalLbl.setForeground(Helper.cWhite);

        pathLbl = new JLabel("Path: ");
        pathLbl.setFont(new Font("Futura", Font.BOLD,18));  
        pathLbl.setBounds(400, 184, 800, 40);
        pathLbl.setForeground(Helper.cWhite);

        // LayeredPane Components
        layeredPane.add(subButton, JLayeredPane.POPUP_LAYER);

        layeredPane.add(locLbl, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(fromLbl, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(toLbl, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(algoLbl, JLayeredPane.PALETTE_LAYER);

        layeredPane.add(fromMenu, JLayeredPane.POPUP_LAYER);
        layeredPane.add(toMenu, JLayeredPane.POPUP_LAYER);
        layeredPane.add(algoMenu, JLayeredPane.POPUP_LAYER);

        layeredPane.add(mapPanel, JLayeredPane.DEFAULT_LAYER);

        layeredPane.add(traversalLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(pathLbl, JLayeredPane.POPUP_LAYER);

        layeredPane.setVisible(false);
    }


    //actionListener
    public void addClickListener(ActionListener listener) {
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

    public HashMap<String, RoundedButton> getStringButtonMap() {
        return this.nodeButtonMap;
    }
    public void setStringButtonMap(HashMap<String, RoundedButton> nodeButtonMap) {
        this.nodeButtonMap = nodeButtonMap;
    }

    public RoundedButton getSubmitButton() {
        return this.subButton;
    }

    public void addPathCost(int pathCost, String traversal, String path) {
        traversalText = new JTextArea();
        traversalText.setText(traversal);
        traversalText.setEditable(false);
        traversalText.setFont(new Font("Futura", Font.BOLD, 12));
        traversalText.setBounds(494, 75, 800, 150);
        traversalText.setOpaque(false);
        traversalText.setForeground(Helper.cWhite);

        pathCostLbl = new JLabel("Cost: " + pathCost);
        pathCostLbl.setFont(new Font("Futura", Font.BOLD, 16));
        pathCostLbl.setBounds(400, 160, 300, 40);
        pathCostLbl.setForeground(Helper.cPureRed);


        pathText = new JTextArea();
        pathText.setText(path);
        pathText.setEditable(false);
        pathText.setFont(new Font("Futura", Font.BOLD,15));
        pathText.setBounds(453, 194, 800, 100);
        pathText.setOpaque(false);
        pathText.setForeground(Helper.cWhite);

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
