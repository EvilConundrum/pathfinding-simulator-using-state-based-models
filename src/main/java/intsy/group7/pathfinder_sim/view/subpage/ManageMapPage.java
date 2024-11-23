package intsy.group7.pathfinder_sim.view.subpage;

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
import intsy.group7.pathfinder_sim.view.asset.RoundedButton;
import intsy.group7.pathfinder_sim.view.asset.SquarePanel;

import java.awt.event.ActionListener;

public class ManageMapPage extends JPanel implements SubPage {

    private JLayeredPane layeredPane;

    private JTextArea addedEatery;
    private JTextArea removedEatery;
    private JTextArea addedEdges;

    private RoundedButton add1Button;
    private RoundedButton add2Button;
    private RoundedButton rmvButton;

    private JTextField addName;

    private JFormattedTextField fTraf;

    private JComboBox<String> startNode;
    private JComboBox<String> endNode;
    private JComboBox<String> rmvPlace;

    //@param MainFrame & list of locations
    public void launchManageMapPage(String[] locations, String[] nodes){

        // Panel for map
        JPanel mapPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(Helper.MAP_IMAGE.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        mapPanel.setBounds(385, 60, 890, 630);

        // LayeredPane for positioning
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(Helper.SCREEN_SIZE);
        layeredPane.setBackground(Helper.WHITE);

        //tab buttons
        add1Button = new RoundedButton("Add");
        add1Button.setFont(new Font("Helvetica", Font.BOLD, 14));
        add1Button.setForeground(Helper.WHITE);
        add1Button.setBackground(Helper.GREEN_ACCENT);
        add1Button.setBounds(185, 225, 100, 30);
        add1Button.setBorder(null);
        add1Button.setContentAreaFilled(true);
        add1Button.setOpaque(false);
        add1Button.setCustomBorderColor(Helper.WHITE);
        add1Button.setCustomBorderThickness(2);

        add2Button = new RoundedButton("Add");
        add2Button.setFont(new Font("Helvetica", Font.BOLD, 14));
        add2Button.setForeground(Helper.WHITE);
        add2Button.setBackground(Helper.GREEN_ACCENT);
        add2Button.setBounds(185, 425, 100, 30);
        add2Button.setBorder(null);
        add2Button.setContentAreaFilled(true);
        add2Button.setOpaque(false);
        add2Button.setCustomBorderColor(Helper.WHITE);
        add2Button.setCustomBorderThickness(2);

        rmvButton = new RoundedButton("Remove");
        rmvButton.setFont(new Font("Helvetica", Font.BOLD, 14));
        rmvButton.setForeground(Helper.WHITE);
        rmvButton.setBackground(Helper.MAROON_RED);
        rmvButton.setBounds(185, 590, 100, 30);
        rmvButton.setBorder(null);
        rmvButton.setContentAreaFilled(true);
        rmvButton.setOpaque(false);
        rmvButton.setCustomBorderColor(Helper.WHITE);
        rmvButton.setCustomBorderThickness(2);

        // Resulting Text
        addedEatery = new JTextArea();
        addedEatery.setFont(new Font("Futura", Font.BOLD, 15));
        addedEatery.setBounds(185, 270, 300, 50);
        addedEatery.setForeground(Helper.NEON_BLUE);
        addedEatery.setOpaque(false);

        addedEdges = new JTextArea();
        addedEdges.setFont(new Font("Futura", Font.BOLD, 15));
        addedEdges.setBounds(100, 462, 300, 50);
        addedEdges.setForeground(Helper.NEON_BLUE);
        addedEdges.setOpaque(false);

        removedEatery = new JTextArea();
        removedEatery.setFont(new Font("Futura", Font.BOLD, 15));
        removedEatery.setBounds(178, 627, 300, 50);
        removedEatery.setForeground(Helper.MAROON_RED);
        removedEatery.setOpaque(false);

        // Labels (add/remove) and Instructions (pick)
        JLabel addFpLbl = new JLabel("Add a Food Place");
        addFpLbl.setFont(new Font("Futura", Font.BOLD,16));
        addFpLbl.setBounds(162, 90, 300, 40);
        addFpLbl.setForeground(Helper.GREEN_TEXT);

        JLabel insLbl = new JLabel("Pick a location first");
        insLbl.setFont(new Font("Futura", Font.PLAIN,11));
        insLbl.setBounds(180, 111, 300, 40);
        insLbl.setForeground(Helper.GREEN_TEXT);

        JLabel addNameLbl = new JLabel("Name: ");
        addNameLbl.setFont(new Font("Futura", Font.BOLD,12));
        addNameLbl.setBounds(100, 140, 300, 40);
        addNameLbl.setForeground(Helper.GREEN_TEXT);

        JLabel ftTrafbl = new JLabel("Foot Traffic:");
        ftTrafbl.setFont(new Font("Futura", Font.BOLD,12));
        ftTrafbl.setBounds(100, 170, 300, 40);
        ftTrafbl.setForeground(Helper.GREEN_TEXT);

        JLabel edgesLbl = new JLabel("Edges");
        edgesLbl.setFont(new Font("Futura", Font.BOLD,16));
        edgesLbl.setBounds(215, 300, 300, 40);
        edgesLbl.setForeground(Helper.GREEN_TEXT);

        JLabel sNodeLbl = new JLabel("Start Node:");
        sNodeLbl.setFont(new Font("Futura", Font.BOLD,12));
        sNodeLbl.setBounds(100, 335, 300, 40);
        sNodeLbl.setForeground(Helper.GREEN_TEXT);

        JLabel eNodeLbl = new JLabel("End Node:");
        eNodeLbl.setFont(new Font("Futura", Font.BOLD,12));
        eNodeLbl.setBounds(100, 365, 300, 40);
        eNodeLbl.setForeground(Helper.GREEN_TEXT);

        JLabel rmvLbl = new JLabel("Remove a Food Place");
        rmvLbl.setFont(new Font("Futura", Font.BOLD,16));
        rmvLbl.setBounds(145, 500, 300, 40);
        rmvLbl.setForeground(Helper.GREEN_TEXT);

        JLabel rmvNameLbl = new JLabel("Name: ");
        rmvNameLbl.setFont(new Font("Futura", Font.BOLD,12));
        rmvNameLbl.setBounds(100, 530, 300, 40);
        rmvNameLbl.setForeground(Helper.GREEN_TEXT);

        //text fields
        addName = new JTextField();
        addName.setColumns(15);
        addName.setBounds(145, 150, 220, 25);

        fTraf = new JFormattedTextField();
        Helper.updateNumberFieldFormatter(fTraf, 1, 20, Integer.class);
        fTraf.setColumns(15);
        fTraf.setBounds(180, 180, 185, 25);

        //Dropdown Menu
        startNode = new JComboBox<>(nodes);
        startNode.setVisible(true);
        startNode.setBounds(170,345,200,25);

        endNode = new JComboBox<>(nodes);
        endNode.setVisible(true);
        endNode.setBounds(170,375,200,25);

        rmvPlace = new JComboBox<>(locations);
        rmvPlace.setVisible(true);
        rmvPlace.setBounds(145,540,220,25);

        JPanel redSquare = new SquarePanel(Helper.MAROON_RED, 20);
        redSquare.setVisible(true);
        redSquare.setBounds(410, 85, 20, 20);

        JPanel yellowSquare = new SquarePanel(Helper.NEON_YELLOW, 20);
        yellowSquare.setVisible(true);
        yellowSquare.setBounds(410, 115, 20, 20);

        JPanel blackSquare = new SquarePanel(Helper.DARK_GRAY, 20);
        blackSquare.setVisible(true);
        blackSquare.setBounds(410, 145, 20, 20);

        JTextArea redIndicateText = new JTextArea();
        redIndicateText.setText("- Vacant Eateries (Selection)");
        redIndicateText.setEditable(false);
        redIndicateText.setFont(new Font("Futura", Font.BOLD, 18));
        redIndicateText.setBounds(438, 82, 300, 150);
        redIndicateText.setOpaque(false);
        redIndicateText.setForeground(Helper.WHITE);

        JTextArea yellowIndicateText = new JTextArea();
        yellowIndicateText.setText("- Current Eateries");
        yellowIndicateText.setEditable(false);
        yellowIndicateText.setFont(new Font("Futura", Font.BOLD, 18));
        yellowIndicateText.setBounds(438, 112, 300, 150);
        yellowIndicateText.setOpaque(false);
        yellowIndicateText.setForeground(Helper.WHITE);

        JTextArea blackIndicateText = new JTextArea();
        blackIndicateText.setText("- Roads");
        blackIndicateText.setEditable(false);
        blackIndicateText.setFont(new Font("Futura", Font.BOLD, 18));
        blackIndicateText.setBounds(438, 142, 300, 150);
        blackIndicateText.setOpaque(false);
        blackIndicateText.setForeground(Helper.WHITE);


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

        layeredPane.add(redSquare, JLayeredPane.POPUP_LAYER);
        layeredPane.add(yellowSquare, JLayeredPane.POPUP_LAYER);
        layeredPane.add(blackSquare, JLayeredPane.POPUP_LAYER);

        layeredPane.add(redIndicateText, JLayeredPane.POPUP_LAYER);
        layeredPane.add(yellowIndicateText, JLayeredPane.POPUP_LAYER);
        layeredPane.add(blackIndicateText, JLayeredPane.POPUP_LAYER);

        layeredPane.setVisible(false);
    }

    //actionListener
    public void addClickListener(ActionListener listener) {
        this.add1Button.addActionListener(listener);
        this.add2Button.addActionListener(listener);
        this.rmvButton.addActionListener(listener);
    }

    public JLayeredPane getLayeredPane(){
        return this.layeredPane;
    }

    public String getAddName(){
        return this.addName.getText();
    }

    public String getfTraf(){
        return this.fTraf.getText();
    }

    // TESTING
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
        this.startNode.setModel(new DefaultComboBoxModel<>(nodes));
        this.endNode.setModel(new DefaultComboBoxModel<>(nodes));
        this.rmvPlace.setModel(new DefaultComboBoxModel<>(locations));
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
