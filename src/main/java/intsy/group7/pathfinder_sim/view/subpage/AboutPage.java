package intsy.group7.pathfinder_sim.view.subpage;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import intsy.group7.pathfinder_sim.helper.Helper;

/**
 * The AboutPage class represents the about section of the application,
 * displaying information about the program.
 * <p><p/>
 * This class implements the SubPage interface and contains a JLayeredPane
 * to manage the layout of the components on the about page.
 *
 * @author Jansen Sajeh Mortega
 * @author Sean Kyle Dimaunahan
 */
public class AboutPage extends JPanel implements SubPage {

    private JLayeredPane layeredPane;

    /**
     * Launches the About page, setting up the UI components.
     */
    public void launchAboutPage() {
        // Initialize the layered pane for positioning components
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(Helper.SCREEN_SIZE);
        layeredPane.setBackground(Helper.WHITE);

        // Create and configure the "About" label
        JLabel abtLbl = createLabel(new Font("Futura", Font.BOLD, 20), Helper.GREEN_TEXT);

        // Create and configure the JTextArea for program information
        JTextPane aboutProg = createTextPane(Helper.GREEN_TEXT, Helper.DIRTY_WHITE, Helper.ABOUT_INFO);

        // Create and configure the JScrollPane to contain the JTextArea
        JScrollPane scrollPane = createScrollPane(aboutProg, new LineBorder(Helper.DIRTY_WHITE, 2));

        // Add components to the layered pane
        layeredPane.add(abtLbl, JLayeredPane.POPUP_LAYER);
        layeredPane.add(scrollPane, JLayeredPane.PALETTE_LAYER);

        layeredPane.setVisible(false); // Set the layered pane visibility
    }

    /**
     * Returns the layered pane containing the About page components.
     *
     * @return the JLayeredPane for the About page
     */
    public JLayeredPane getLayeredPane() {
        return this.layeredPane;
    }

    /**
     * Creates a JLabel with specified properties.
     *
     * @param font  the font to use for the label text
     * @param color the color of the label text
     * @return the configured JLabel
     */
    private JLabel createLabel(Font font, Color color) {
        JLabel label = new JLabel("About");
        label.setFont(font);
        label.setBounds(620, 95, 300, 40);
        label.setForeground(color);
        return label;
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

    /**
     * Creates a JScrollPane containing the specified JTextArea.
     *
     * @param textArea the JTextArea to be added to the JScrollPane
     * @param border   the border for the JScrollPane
     * @return the configured JScrollPane
     */
    private JScrollPane createScrollPane(JTextPane textArea, LineBorder border) {
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(93, 140, 1175, 600);
        scrollPane.setBorder(border);
        return scrollPane;
    }
}
