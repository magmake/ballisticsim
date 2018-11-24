package ballisticsimulator;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame
{
    private final int DEF_CANV_WIDTH = 400;
    private final int DEF_CANV_HEIGHT = 400;
    
    View()
    {
        add(new Drawing());
        setTitle("Ballistics Simulator");
        setSize(DEF_CANV_WIDTH, DEF_CANV_HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void DrawFrame()
    {
        repaint();
    }
}
