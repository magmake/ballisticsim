/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballisticsimulator;
import javax.swing.*;

public class EndScreen extends JTextPane
{

    String text;
    JLabel ikkuna;
   
    public EndScreen()
    {
    
    }


    public void avaaLoppuikkuna(double etäisyys)
    {        
        boolean done = false;
        while (!done)
        {
            int result = JOptionPane.showConfirmDialog(null,
            "Pallo lensi: "+(int)etäisyys+" pikseliä.",
            "Pallon lentomatka",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE);
           
            if (result == JOptionPane.OK_OPTION)
            {
                System.out.println("Input ok!");
                done = true; 

    
            }
        }
    }

    
    public static void main(String[] args)
    {
        EndScreen test = new EndScreen();
        test.avaaLoppuikkuna(40);
    }         
}

