package intsy.group7.pathfinder_sim.view.asset;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import intsy.group7.pathfinder_sim.helper.Helper;

/**
 * A custom JButton with an icon and transparent background settings.
 *
 * @author Jansen Sajeh Mortega
 */
public class IconButton extends JButton {

    /**
     * Creates a JButton with an icon and sets custom appearance properties.
     *
     * @param icon The ImageIcon displayed on the button.
     */
    public IconButton(ImageIcon icon) {
        super(icon);

        // Customize the button appearance
        setContentAreaFilled(false);    // Transparent background
        setFocusPainted(false);         // Remove focus painting
        setBorderPainted(false);        // Remove button border
        setBackground(Helper.WHITE);    // Optional, set to frame's background color
    }
}