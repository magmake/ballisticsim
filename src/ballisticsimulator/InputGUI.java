/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballisticsimulator;
import javax.swing.*;

public class InputGUI extends JPanel
{
    private double angle;
    private double mass;
    private double force;
    private double gravity;
    private JTextField kulmaKenttä = new JTextField(5);   
    private JTextField massaKenttä = new JTextField(5);
    private JTextField voimaKenttä = new JTextField(5);
    private JTextField gKenttä = new JTextField(5);
    
    JPanel myPanel;
   
    public InputGUI()
    {
        //Default Values
        massaKenttä.setText("5");
        kulmaKenttä.setText("45");
        gKenttä.setText("500");
        voimaKenttä.setText("5000");
    }
    public void drawWindow()
    {
        //DRAWS WINDOW AND WAITS UNTIL USER HAS ENTERED INPUT
        this.myPanel = new JPanel();
        myPanel.add(new JLabel("Angle:"));
        myPanel.add(kulmaKenttä);
        myPanel.add(new JLabel("Mass:"));
        myPanel.add(massaKenttä);
        myPanel.add(new JLabel("Force:"));
        myPanel.add(voimaKenttä);
        myPanel.add(new JLabel("Gravity:"));
        myPanel.add(gKenttä);
        
        boolean done = false;
        while (!done)
        {
            int result = JOptionPane.showConfirmDialog(null,myPanel,
                "Syöte",JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION)
            {
                System.out.println("Input ok!");

                try
                {
                    angle = Double.parseDouble(kulmaKenttä.getText());
                    mass = Double.parseDouble(massaKenttä.getText());      
                    force = Double.parseDouble(voimaKenttä.getText());            
                    gravity = Double.parseDouble(gKenttä.getText());           
                    //Angle limiter. Passes if the angle is under 90
                    if (angle<90)
                    { 
                        done = true; 
                    } 
                    else
                    {
                        System.out.println("Angle is too high!!!");
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Make sure you fill in all the boxes!");
                }
            }
            else
            {
                System.out.println("Invalid input! Press spacebar to enter input.");
                break;
            }      
        }
    }
    public double getAngle()
    {
        return angle;
    } 
    public double getMass(){
        return mass;
    }
    public double getForce()
    {
        return force;
    }
    public double getGravity()
    {
        return gravity;
    }
    
    //Testing
    public static void main(String[] args)
    {
        InputGUI GUI = new InputGUI();            
        System.out.println(GUI.getAngle()+" "+GUI.getForce()+" "+GUI.getGravity());
    }         
}
