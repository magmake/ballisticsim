/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballisticsimulator;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

public class Bullet extends JPanel
{
    private double xpos, ypos, radius, angle;
    private double force, xacc, yacc, xvel, yvel, mass;
    private Color color = Color.BLACK;
    
    Bullet(int x, int y, int r, int a)
    {
        xpos = x;
        ypos = y;
        radius = r;
        angle = a;
        mass = 1;
        force = 1000;
        xacc = (Math.cos(Math.toRadians(angle)) * (force / mass)) * Controller.SCALING_FACTOR;
        yacc = (Math.sin(Math.toRadians(angle)) * (force / mass)) * Controller.SCALING_FACTOR;
        setOpaque(false);
    }
    public void applyVel(double dt)
    {
        xvel = xvel + (xacc * dt);
        yvel = yvel + (yacc * dt);
    }
    public void test(double dt, double xa, double ya)
    {
        xvel = xvel + xa;
        yvel = yvel + ya;
    }
    public void updatePos()
    {
        xpos = xpos + xvel;
        ypos = ypos - yvel;
        System.out.println(xpos + " " + ypos);
    }
    public double getXAcc()
    {
        return xacc;
    }
    public double getYAcc()
    {
        return yacc;
    }
    public void setAcc(double xa, double ya)
    {
        xacc = xacc + xa * Controller.SCALING_FACTOR;
        yacc = yacc + ya * Controller.SCALING_FACTOR;
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
        Ellipse2D.Double ell = new Ellipse2D.Double(xpos, ypos - radius, radius, radius);
        g2d.draw(ell);
    }
}
