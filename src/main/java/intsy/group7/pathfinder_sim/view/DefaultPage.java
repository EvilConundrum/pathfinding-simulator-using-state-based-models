package intsy.group7.pathfinder_sim.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class DefaultPage {
    ImageIcon map = new ImageIcon("images/MapDLSU.png");
    ImageIcon pathFinderImg = new ImageIcon("images/PathFinder.png");
    ImageIcon manageMapImg = new ImageIcon("images/ManageMap.png");
    ImageIcon viewAlgosImg = new ImageIcon("images/ViewAlgos.png");
    ImageIcon aboutImg = new ImageIcon("images/About.png");
    ImageIcon exitImg = new ImageIcon("images/Exit.png");
    ImageIcon logoImg = new ImageIcon("images/LogoTHA.png"); 

    JLabel pathFinderLbl;
    JLabel manageMapLbl;
    JLabel viewAlgosLbl;
    JLabel aboutLbl;
    JLabel exitLbl;

    IconButton pathFinderButton;
    IconButton manageMapButton;
    IconButton viewAlgosButton;
    IconButton aboutButton;
    IconButton exitButton;

    Color greenTHA = new Color(0, 105, 55);
    Color greenText = new Color(5, 65, 3);

    String welcomeMessage = "Welcome to The Bow & Bite Map! Ready to explore the different food spots around campus? This map uses different algorithms to help you find the best paths to satisfy your cravings—whether you’re in the mood for a quick bite or a nice meal. Grab your friends, start exploring, and let the algorithms guide you to your next favorite meal! Happy munching! :)";

    //@param MainFrame
    public void launchDefaultPage(JFrame mainFrame){

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
        JPanel mapPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(map.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        mapPanel.setBounds(385, 60, 890, 630);

        // LayeredPane for positioning
        JLayeredPane layeredPane = new JLayeredPane();
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
        
        // Welcome Message
        JTextArea welcome1 = new JTextArea(1, 27);
        welcome1.setFont(new Font("Helvetica", Font.BOLD, 18));
        welcome1.setForeground(greenText);
        welcome1.setBackground(new Color(238, 238, 238));
        welcome1.setText("Hey, Archer! 🏹");
        welcome1.setEditable(false);
        welcome1.setWrapStyleWord(true);
        welcome1.setLineWrap(true);
        welcome1.setBounds(100, 100, 250, 50); 

        JTextArea welcome2 = new JTextArea(25, 27);
        welcome2.setFont(new Font("Helvetica", Font.PLAIN, 15));
        welcome2.setForeground(greenText);
        welcome2.setBackground(new Color(238, 238, 238));
        welcome2.setText(welcomeMessage);
        welcome2.setEditable(false);
        welcome2.setWrapStyleWord(true);
        welcome2.setLineWrap(true);
        welcome2.setBounds(100, 130, 250, 300); 

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

        layeredPane.add(verticalLine, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(mapPanel, JLayeredPane.POPUP_LAYER);
        layeredPane.add(welcome1, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(welcome2, JLayeredPane.POPUP_LAYER);

        // JFrame 
        mainFrame.setTitle("The Bow & Bite Map");
        mainFrame.setSize(1920, 1080);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);

        // backgroundPanel and layeredPane on JFrame
        mainFrame.getContentPane().setLayout(new BorderLayout());
        mainFrame.getContentPane().add(layeredPane, BorderLayout.CENTER);

        mainFrame.setLocationRelativeTo(null); // Center JFrame on screen
        mainFrame.setVisible(true);
    }


    //actionListener
    public void addClickListener(ActionListener listener) {
        this.pathFinderButton.addActionListener(listener);
        this.manageMapButton.addActionListener(listener);
        this.viewAlgosButton.addActionListener(listener);
        this.aboutButton.addActionListener(listener);
        this.exitButton.addActionListener(listener);
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
}
