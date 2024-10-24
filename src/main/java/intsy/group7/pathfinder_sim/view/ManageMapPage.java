package intsy.group7.pathfinder_sim.view;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Graphics;

import intsy.group7.pathfinder_sim.helper.Helper;

import java.awt.event.ActionListener;

public class ManageMapPage extends JPanel {   

    private JLayeredPane layeredPane;
    
    private JPanel mapPanel, redSquare, greenSquare, blueSquare;
    
    private JTextArea addedEatery, removedEatery, addedEdges;

    private RoundedButton add1Button, add2Button, rmvButton;

    private JTextField addName;
    private JFormattedTextField fTraf;

    private JComboBox<String> startNode, endNode, rmvPlace;

    //@param MainFrame & list of locations
    public void launchManageMapPage(JFrame mainFrame, String[] locations, String[] nodes){

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

        //tab buttons
        add1Button = new RoundedButton("Add");
        add1Button.setFont(new Font("Helvetica", Font.BOLD, 14));
        add1Button.setForeground(Helper.cWhite);
        add1Button.setBackground(Helper.cGreenTHA2);
        add1Button.setBounds(185, 225, 100, 30); 
        add1Button.setBorder(null);
        add1Button.setContentAreaFilled(true); 
        add1Button.setOpaque(false);
        add1Button.setCustomBorderColor(Helper.cWhite); 
        add1Button.setCustomBorderThickness(2);

        add2Button = new RoundedButton("Add");
        add2Button.setFont(new Font("Helvetica", Font.BOLD, 14));
        add2Button.setForeground(Helper.cWhite);
        add2Button.setBackground(Helper.cGreenTHA2);
        add2Button.setBounds(185, 425, 100, 30); 
        add2Button.setBorder(null);
        add2Button.setContentAreaFilled(true); 
        add2Button.setOpaque(false);
        add2Button.setCustomBorderColor(Helper.cWhite); 
        add2Button.setCustomBorderThickness(2);

        rmvButton = new RoundedButton("Remove");
        rmvButton.setFont(new Font("Helvetica", Font.BOLD, 14));
        rmvButton.setForeground(Helper.cWhite);
        rmvButton.setBackground(Helper.cRed);
        rmvButton.setBounds(185, 590, 100, 30); 
        rmvButton.setBorder(null);
        rmvButton.setContentAreaFilled(true); 
        rmvButton.setOpaque(false);
        rmvButton.setCustomBorderColor(Helper.cWhite); 
        rmvButton.setCustomBorderThickness(2);

        // Resulting Text
        addedEatery = new JTextArea();
        addedEatery.setFont(new Font("Futura", Font.BOLD, 15));
        addedEatery.setBounds(185, 270, 300, 50);
        addedEatery.setForeground(Helper.cBlue);
        addedEatery.setOpaque(false);

        addedEdges = new JTextArea();
        addedEdges.setFont(new Font("Futura", Font.BOLD, 15));
        addedEdges.setBounds(100, 462, 300, 50);
        addedEdges.setForeground(Helper.cBlue);
        addedEdges.setOpaque(false);

        removedEatery = new JTextArea();
        removedEatery.setFont(new Font("Futura", Font.BOLD, 15));
        removedEatery.setBounds(178, 627, 300, 50);
        removedEatery.setForeground(Helper.cRed);
        removedEatery.setOpaque(false); 
        
        //Labels (add/remove) and Instructions (pick)
        JLabel addFpLbl = new JLabel("Add a Food Place");
        addFpLbl.setFont(new Font("Futura", Font.BOLD,16));
        addFpLbl.setBounds(162, 90, 300, 40);
        addFpLbl.setForeground(Helper.cGreenText);

        JLabel insLbl = new JLabel("Pick a location first");
        insLbl.setFont(new Font("Futura", Font.PLAIN,11));
        insLbl.setBounds(180, 111, 300, 40);
        insLbl.setForeground(Helper.cGreenText);

        JLabel addNameLbl = new JLabel("Name: ");
        addNameLbl.setFont(new Font("Futura", Font.BOLD,12));
        addNameLbl.setBounds(100, 140, 300, 40);
        addNameLbl.setForeground(Helper.cGreenText);

        JLabel ftTrafbl = new JLabel("Foot Traffic:");
        ftTrafbl.setFont(new Font("Futura", Font.BOLD,12));
        ftTrafbl.setBounds(100, 170, 300, 40);
        ftTrafbl.setForeground(Helper.cGreenText);

        JLabel edgesLbl = new JLabel("Edges");
        edgesLbl.setFont(new Font("Futura", Font.BOLD,16));
        edgesLbl.setBounds(215, 300, 300, 40);
        edgesLbl.setForeground(Helper.cGreenText);

        JLabel sNodeLbl = new JLabel("Start Node:");
        sNodeLbl.setFont(new Font("Futura", Font.BOLD,12));
        sNodeLbl.setBounds(100, 335, 300, 40);
        sNodeLbl.setForeground(Helper.cGreenText);

        JLabel eNodeLbl = new JLabel("End Node:");
        eNodeLbl.setFont(new Font("Futura", Font.BOLD,12));
        eNodeLbl.setBounds(100, 365, 300, 40);
        eNodeLbl.setForeground(Helper.cGreenText);

        JLabel rmvLbl = new JLabel("Remove a Food Place");
        rmvLbl.setFont(new Font("Futura", Font.BOLD,16));
        rmvLbl.setBounds(145, 500, 300, 40);
        rmvLbl.setForeground(Helper.cGreenText);

        JLabel rmvNameLbl = new JLabel("Name: ");
        rmvNameLbl.setFont(new Font("Futura", Font.BOLD,12));
        rmvNameLbl.setBounds(100, 530, 300, 40);
        rmvNameLbl.setForeground(Helper.cGreenText);

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
        layeredPane.add(addFpLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(insLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(addNameLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(ftTrafbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(edgesLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(sNodeLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(eNodeLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(rmvLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(rmvNameLbl, JLayeredPane.POPUP_LAYER);

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
        layeredPane.add(addedEdges, JLayeredPane.POPUP_LAYER);
        layeredPane.add(removedEatery, JLayeredPane.POPUP_LAYER);

        layeredPane.setVisible(false);
    }

    //actionListener
    public void addClickListener(ActionListener listener) {
        this.add1Button.addActionListener(listener);
        this.add2Button.addActionListener(listener);
        this.rmvButton.addActionListener(listener);
    }

    //returns the layeredPane
    public JLayeredPane getLayeredPane(){
        return this.layeredPane;
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
    public void setAddedEdges(String addedEdges){
        this.addedEdges.setText(addedEdges);
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
