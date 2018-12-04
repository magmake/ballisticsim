/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballisticsimulator;

import javax.swing.JPanel;
import java.awt.*;

public class Ruler extends JPanel
{
    private final int lineSpacing;
    private final int lineHeight = 5;
    private final int startPosX, startPosY;
    private Color color = Color.BLACK;
    
    Ruler()
    {
        lineSpacing = 10;
        startPosX = 0;
        startPosY = Controller.DEF_WIND_HEIGHT;
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
        for (int i = startPosX; i < Controller.DEF_WIND_WIDTH; i = i + lineSpacing)
        {
            g.drawLine(i, startPosY, i, startPosY - lineHeight);
        }
    }
}
