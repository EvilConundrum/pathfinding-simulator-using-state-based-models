package intsy.group7.pathfinder_sim.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import intsy.group7.pathfinder_sim.helper.Helper;

public class IconButton extends JButton {
    
    public IconButton(ImageIcon iconPath) {
        super(iconPath);
        
        // Customize the button appearance
        setContentAreaFilled(false); // Make button background transparent
        setFocusPainted(false); // Remove focus painting
        setBorderPainted(false); // Remove button border
        setBackground(Helper.cWhite); // Set to match the frame's background (optional)
    }
}
