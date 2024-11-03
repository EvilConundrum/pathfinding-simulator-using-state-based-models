package intsy.group7.pathfinder_sim.view.subpage;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import java.awt.Color;
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
        JTextPane algoDef = createTextPane(Helper.GREEN_TEXT, Helper.DIRTY_WHITE, Helper.VIEWALGO_INFO);

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

    /**
     * Creates a JTextArea with specified properties.
     *
     * @param textColor       the color of the text in the JTextArea
     * @param backgroundColor the background color of the JTextArea
     * @param text            the initial text to display in the JTextArea
     * @return the configured JTextArea
     */
    private JTextPane createTextPane(Color textColor, Color backgroundColor, String text) {
        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html"); // Set content type to HTML
        
        // Convert the Color object to a hex string
        String textColorHex = String.format("#%02x%02x%02x", textColor.getRed(), 
                        textColor.getGreen(), textColor.getBlue());
        String backgroundColorHex = String.format("#%02x%02x%02x", backgroundColor.getRed(), 
                        backgroundColor.getGreen(), backgroundColor.getBlue());
        
        // Include font settings and margins within the HTML content
        String htmlText = "<html><body style='text-align: justify; font-family: Helvetica; " +
                "font-size: 12px; color: " + textColorHex + "; background-color: " + 
                backgroundColorHex + "; margin: 10px 20px 20px 10px;'>" + text + "</body></html>";
        
        textPane.setText(htmlText);
        textPane.setEditable(false);

        textPane.setBorder(BorderFactory.createEmptyBorder());
        return textPane;
    }


}
