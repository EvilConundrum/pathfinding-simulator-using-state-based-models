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
        JTextArea aboutProg = createTextArea(Helper.GREEN_TEXT, Helper.DIRTY_WHITE, Helper.SAMPLE_TEXT);

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
    private JTextArea createTextArea(Color textColor, Color backgroundColor, String text) {
        JTextArea textArea = new JTextArea(25, 27);
        textArea.setFont(new Font("Helvetica", Font.PLAIN, 15));
        textArea.setForeground(textColor);
        textArea.setBackground(backgroundColor);
        textArea.setText(text);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        return textArea;
    }

    /**
     * Creates a JScrollPane containing the specified JTextArea.
     *
     * @param textArea the JTextArea to be added to the JScrollPane
     * @param border   the border for the JScrollPane
     * @return the configured JScrollPane
     */
    private JScrollPane createScrollPane(JTextArea textArea, LineBorder border) {
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(93, 155, 1175, 500);
        scrollPane.setBorder(border);
        return scrollPane;
    }
}
