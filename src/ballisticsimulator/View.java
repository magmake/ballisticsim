package ballisticsimulator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View extends JFrame
{
    /*private final int DEF_CANV_WIDTH = 400;
    private final int DEF_CANV_HEIGHT = 500;<*/
    
    View(KeyListener l)
    {
        setTitle("Ballistics Simulator");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(l);
        setFocusable(true);
    }
    public void AddObject(JPanel o)
    {
        add(o);
        pack();
    }
    void DrawFrame()
    {
        repaint();
    }
}
