/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballisticsimulator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *
 * @author PUROBUKKU
 */
public class KeyInput implements KeyListener
{
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            Controller.reset = true;
            System.out.println("Simulation reset!");
        }
    }
}
