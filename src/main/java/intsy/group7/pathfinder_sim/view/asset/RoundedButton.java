package intsy.group7.pathfinder_sim.view.asset;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.RenderingHints;

import intsy.group7.pathfinder_sim.helper.Helper;

/**
 * A JButton with rounded corners and customizable border settings.
 * <p></p>
 * Supports custom border color and thickness, as well as a green shade for pressed state.
 * Maintains its background color even when disabled.
 *
 * @author Jansen Sajeh Mortega
 * @author Sean Kyle Dimaunahan
 */
public class RoundedButton extends JButton {
    private final Color pressedColor = new Color(0, 112, 60);
    private Color borderColor;
    private int borderThickness;
    private Color normalBackground;

    /**
     * Initializes the button with text and default custom border color.
     *
     * @param text The text to display on the button.
     */
    public RoundedButton(String text) {
        super(text);
        // setContentAreaFilled(false);
        setFocusPainted(false);
        // setOpaque(false);
        borderColor = Helper.WHITE;
        borderThickness = 2;
        // setUI(new MetalButtonUI() {
        //     protected Color getDisabledTextColor() {
        //         return Helper.WHITE;
        //     }
        // });
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        normalBackground = bg;  // Store the normal background color
    }

    /**
     * Sets a custom color for the button's border.
     *
     * @param color The desired border color.
     */
    public void setCustomBorderColor(Color color) {
        this.borderColor = color;
    }

    /**
     * Sets a custom thickness for the button's border.
     *
     * @param thickness The desired border thickness.
     */
    public void setCustomBorderThickness(int thickness) {
        this.borderThickness = thickness;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Use stored background color when disabled, otherwise use normal logic
        if (!isEnabled() && normalBackground != null) {
            g2d.setColor(normalBackground);
        } else {
            g2d.setColor(getModel().isArmed() ? pressedColor : getBackground());
        }

        g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 40, 40);
        g2d.dispose();
        
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(borderThickness));
        g2.setColor(borderColor);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 40, 40);
        g2.dispose();
    }
}