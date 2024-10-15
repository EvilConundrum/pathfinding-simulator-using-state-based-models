import javax.swing.*;
import java.awt.*;

public class ImageResizer extends JFrame {

    public ImageResizer() {
        // Load the image
        ImageIcon originalIcon = new ImageIcon("images/MapDLSU.png");

        // Get the original image from the ImageIcon
        Image originalImage = originalIcon.getImage();

        // Scale the image to the desired width and height (e.g., 400x400)
        Image scaledImage = originalImage.getScaledInstance(400, 400, Image.SCALE_SMOOTH);  // Maintain smooth scaling

        // Create a new ImageIcon using the scaled image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Add the scaled image to a JLabel
        JLabel imageLabel = new JLabel(scaledIcon);

        // Add the JLabel to the JFrame
        add(imageLabel);

        // JFrame settings
        setTitle("Image Resizer Example");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on screen
    }
}
