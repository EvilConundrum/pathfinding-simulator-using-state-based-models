package intsy.group7.pathfinder_sim.view.subpage;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Font;

import intsy.group7.pathfinder_sim.helper.Helper;

public class ViewAlgorithmPage extends JPanel implements SubPage {

    private JLayeredPane layeredPane;

    //@param MainFrame & list of locations
    public void launchViewAlgorithmPage() {

        // LayeredPane for positioning
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(Helper.SCREEN_SIZE);
        layeredPane.setBackground(Helper.WHITE);

        //Algo label
        JLabel algo = new JLabel("Algorithms");
        algo.setFont(new Font("Futura", Font.BOLD, 20));
        algo.setBounds(600, 95, 300, 40);
        algo.setForeground(Helper.GREEN_TEXT);

        JLabel algo2 = new JLabel("Algorithm Definition");
        algo2.setFont(new Font("Futura", Font.BOLD, 15));
        algo2.setBounds(100, 130, 300, 40);
        algo2.setForeground(Helper.GREEN_TEXT);

        //text
        JTextArea algoDef = new JTextArea(25, 27);
        algoDef.setFont(new Font("Helvetica", Font.PLAIN, 15));
        algoDef.setForeground(Helper.GREEN_TEXT);
        algoDef.setBackground(Helper.DIRTY_WHITE);
        algoDef.setText(Helper.SAMPLE_TEXT);
        algoDef.setEditable(false);
        algoDef.setWrapStyleWord(true);
        algoDef.setLineWrap(true);

        //JScrollPane
        JScrollPane scrollPane = new JScrollPane(algoDef);
        scrollPane.setBounds(93, 165, 1175, 500); // Set bounds for the JScrollPane
        scrollPane.setBorder(new LineBorder(Helper.DIRTY_WHITE, 2));

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
