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
    
    Bullet(int x, int y, int r)
    {
        xpos = x;
        ypos = y;
        xvel = 0;
        yvel = 0; 
        xacc = 0;
        yacc = 0;
        radius = r;
        //angle = a;
        //mass = 5;
        //force = 5000;
        setOpaque(false);
    }
    public void setForce(double f)
    {
        force = f;
    }
    public void setAngle(double a)
    {
        angle = a;
    }
    public void setMass(double m)
    {
        mass = m;
    }
    public double getYpos()
    {
        return ypos;
    }
    public double getXpos()
    {
        return xpos;
    }
    public void calculateAcc()
    {
        //SHOULD BE CALLED WHEN INITIALIZING
        xacc = (Math.cos(Math.toRadians(angle)) * (force / mass));
        yacc = (Math.sin(Math.toRadians(angle)) * (force / mass));
    }
    public void applyPhysics(double dt, double drag, double g)
    {
        //PSEUDOPHYSICS! DON'T WORK PROPERLY
        xvel = xvel + xacc;
        yvel = yvel + yacc;
        
        xacc = xacc - xacc * drag * dt;
        yacc = yacc - yacc * drag * dt;
        yacc = yacc - g * drag * dt;
        
        xvel = xvel * drag * dt;
        yvel = yvel * drag * dt;
        
    }
    public void updatePos()
    {
        //JUST A METHOD TO UPDATE X & Y POSITION
        xpos = xpos + xvel;
        ypos = ypos - yvel;
        // DEBUG
        //System.out.println(ypos);
        //System.out.println(xacc + " " + yacc);
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
