/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballisticsimulator;

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Drawing extends JPanel
{
    int test = 1;
    Drawing()
    {
        
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.fillOval(100, 100, test, test); 
        System.out.println(test);
        test++;
    }
}
