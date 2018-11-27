/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballisticsimulator;

import java.awt.Color;
import java.awt.*;
import javax.swing.JPanel;

public class Cannon extends JPanel
{
    private int xpos, ypos, xsize, ysize, angle;
    private Color color = Color.BLACK;
    
    Cannon(int x, int y, int xs, int ys, int a)
    {
        xpos = x;
        ypos = y;
        xsize = xs;
        ysize = ys;
        angle = a;
        setOpaque(false);
    }
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(Controller.DEF_WIND_WIDTH, Controller.DEF_WIND_HEIGHT);
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        Rectangle rect = new Rectangle(xpos, ypos - ysize, xsize, ysize);
        g2d.rotate(Math.toRadians(-angle), xpos, ypos + ysize);
        g2d.draw(rect);
    }
}
