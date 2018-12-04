
package ballisticsimulator;

import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;


public class UserInput extends JPanel
{
    public void InputInterface()
    {
        JTextField kulmaKenttä = new JTextField(5);
        JTextField vastusKenttä = new JTextField(5);
        JTextField voimaKenttä = new JTextField(5);
        JTextField gKenttä = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Kulma:"));
        myPanel.add(kulmaKenttä);
        myPanel.add(new JLabel("Vastus:"));
        myPanel.add(vastusKenttä);
        myPanel.add(new JLabel("Voima:"));
        myPanel.add(voimaKenttä);
        myPanel.add(new JLabel("Painovoima:"));
        myPanel.add(gKenttä);

        boolean done = false;
        while (!done)
        {
            int result = JOptionPane.showConfirmDialog(null,myPanel, "Syöte",JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION)
            {
                System.out.println("Kulma: " + kulmaKenttä.getText());
                System.out.println("Nopeus: " + vastusKenttä.getText());
                System.out.println("Voima: " + voimaKenttä.getText());
                System.out.println("Painovoima: " + gKenttä.getText());

                try {
                    double Kulma = Double.parseDouble(kulmaKenttä.getText());
                    double vastus = Double.parseDouble(vastusKenttä.getText());
                    double voima = Double.parseDouble(voimaKenttä.getText());
                    double Painovoima = Double.parseDouble(gKenttä.getText());
                    done = true;
                }
                catch(Exception e)
                {
                    System.out.println("Make sure you type in all the boxes!");
                }
            }
            else
            {
                break;
            }  
        }
    }
    public static void main(String[] args)
    {
       UserInput input = new UserInput();
       input.InputInterface();
    }
}


