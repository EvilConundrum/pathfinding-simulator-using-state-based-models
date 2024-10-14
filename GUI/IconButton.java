import javax.swing.*;
import java.awt.*;

public class IconButton extends JButton {
    
    public IconButton(ImageIcon iconPath) {
        super(iconPath);
        
        // Customize the button appearance
        setContentAreaFilled(false); // Make button background transparent
        setFocusPainted(false); // Remove focus painting
        setBorderPainted(false); // Remove button border
        setBackground(Color.WHITE); // Set to match the frame's background (optional)
    }
}
