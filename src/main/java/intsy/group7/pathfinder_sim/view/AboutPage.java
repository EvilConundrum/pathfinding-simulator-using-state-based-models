package intsy.group7.pathfinder_sim.view;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Font;

import intsy.group7.pathfinder_sim.helper.Helper;

public class AboutPage extends JPanel {

    private JLabel abtLbl;

    private JLayeredPane layeredPane;

    //@param MainFrame & list of locations
    public void launchAboutPage(JFrame mainFrame) {

        // LayeredPane for positioning
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(Helper.screenSize);
        layeredPane.setBackground(Helper.cWhite);

        //Algo label
        abtLbl = new JLabel("About");
        abtLbl.setFont(new Font("Futura", Font.BOLD, 20));
        abtLbl.setBounds(620, 95, 300, 40);
        abtLbl.setForeground(Helper.cGreenText); 

        //text
        JTextArea aboutProg = new JTextArea(25, 27);
        aboutProg.setFont(new Font("Helvetica", Font.PLAIN, 15));
        aboutProg.setForeground(Helper.cGreenText);
        aboutProg.setBackground(Helper.cDirtyWhite);
        aboutProg.setText(Helper.sampleText);
        aboutProg.setEditable(false);
        aboutProg.setWrapStyleWord(true);
        aboutProg.setLineWrap(true);

        //JScrollPane
        JScrollPane scrollPane = new JScrollPane(aboutProg);
        scrollPane.setBounds(93, 155, 1175, 500); // Set bounds for the JScrollPane
        scrollPane.setBorder(new LineBorder(Helper.cDirtyWhite, 2));

        // LayeredPane Components
        layeredPane.add(abtLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(scrollPane, JLayeredPane.PALETTE_LAYER);

        layeredPane.setVisible(false);
    }

    //returns the layeredPane
    public JLayeredPane getLayeredPane(){
        return this.layeredPane;
    }
}