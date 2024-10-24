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

public class ViewAlgorithmPage extends JPanel {
    private JLabel algo;
    private JLabel algo2;

    private JLayeredPane layeredPane;

    //@param MainFrame & list of locations
    public void launchViewAlgorithmPage(JFrame mainFrame) {

        // LayeredPane for positioning
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(Helper.screenSize);
        layeredPane.setBackground(Helper.cWhite);

        //Algo label
        algo = new JLabel("Algorithms");
        algo.setFont(new Font("Futura", Font.BOLD, 20));
        algo.setBounds(600, 95, 300, 40);
        algo.setForeground(Helper.cGreenText);

        algo2 = new JLabel("Algorithm Definition");
        algo2.setFont(new Font("Futura", Font.BOLD, 15));
        algo2.setBounds(100, 130, 300, 40);
        algo2.setForeground(Helper.cGreenText);

        //text
        JTextArea algoDef = new JTextArea(25, 27);
        algoDef.setFont(new Font("Helvetica", Font.PLAIN, 15));
        algoDef.setForeground(Helper.cGreenText);
        algoDef.setBackground(Helper.cDirtyWhite);
        algoDef.setText(Helper.sampleText);
        algoDef.setEditable(false);
        algoDef.setWrapStyleWord(true);
        algoDef.setLineWrap(true);

        //JScrollPane
        JScrollPane scrollPane = new JScrollPane(algoDef);
        scrollPane.setBounds(93, 165, 1175, 500); // Set bounds for the JScrollPane
        scrollPane.setBorder(new LineBorder(Helper.cDirtyWhite, 2));

        // LayeredPane Components
        layeredPane.add(algo, JLayeredPane.POPUP_LAYER);
        layeredPane.add(algo2, JLayeredPane.POPUP_LAYER);
        layeredPane.add(scrollPane, JLayeredPane.PALETTE_LAYER);

        layeredPane.setVisible(false);
    }

    //returns the layeredPane
    public JLayeredPane getLayeredPane(){
        return this.layeredPane;
    }
}
