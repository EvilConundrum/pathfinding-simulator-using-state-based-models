package intsy.group7.pathfinder_sim.view;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

import intsy.group7.pathfinder_sim.helper.Helper;
/**
 * Custom JButton with rounded corners and customizable border.
 */
public class RoundedButton extends JButton {
    Color cGreenTHA = new Color(0, 112, 60);
    private Color customBorderColor;
    private int customBorderThickness;
    private Color disabledTextColor;

    /**
     * Constructor to initialize a RoundedButton with specified text.
     *
     * @param text The text displayed on the button.
     */
    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false); // Remove default fill
        setFocusPainted(false); // Remove default focus painting
        setOpaque(false); // Make sure button is not opaque
        customBorderColor = Helper.cWhite; // Default border color
        customBorderThickness = 2;
    }

    /**
     * Sets the custom border color for the button.
     *
     * @param color The custom border color to set.
     */
    public void setCustomBorderColor(Color color) {
        this.customBorderColor = color;
    }

    /**
     * Sets the custom border thickness for the button.
     *
     * @param thickness The custom border thickness to set.
     */
    public void setCustomBorderThickness(int thickness) {
        this.customBorderThickness = thickness;
    }

    /**
     * Sets the disabled text color for the button.
     *
     * @param color The disabled text color to set.
     */
    public void setDisabledTextColor(Color color) {
        this.disabledTextColor = color;
    }



     /**
     * Paints the component, filling the rounded rectangle background.
     *
     * @param g The Graphics context to paint.
     */
    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(cGreenTHA); // Set pressed color
        } else {
            g.setColor(getBackground()); // Set default color
        }
        // Draw rounded rectangle
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 40, 40);

        super.paintComponent(g);
    }

    /**
     * Paints the custom border with specified color and thickness.
     *
     * @param g The Graphics context to paint.
     */
    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setStroke(new BasicStroke(customBorderThickness));
        g2.setColor(customBorderColor);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 40, 40);
        g2.dispose();
    }

}

