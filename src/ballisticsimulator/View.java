package ballisticsimulator;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame
{
    /*private final int DEF_CANV_WIDTH = 400;
    private final int DEF_CANV_HEIGHT = 500;<*/
    
    View()
    {
        setTitle("Ballistics Simulator");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
