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
        angle = -a;
        mass = 11.0;
        force = 11.1;
        xacc = Math.cos(angle) * (force / mass);
        yacc = Math.sin(angle) * (force / mass);
        setOpaque(false);
    }
    public double getForce()
    {
        return force;
    }
    public double getMass()
    {
        return mass;
    }
    public double getXAcc()
    {
        return xacc;
    }
    public double getYAcc()
    {
        return yacc;
    }
    public double getXPos()
    {
        return xpos;
    }
    public double getYPos()
    {
        return ypos;
    }
    public void setAcc(double xa, double ya)
    {
        
    }
    public void setPos(double x, double y)
    {
        xpos = x;
        ypos = y;
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
