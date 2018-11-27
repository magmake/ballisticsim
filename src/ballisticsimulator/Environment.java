/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballisticsimulator;


public class Environment
{
    private double gravity;
    private double drag;
    
    Environment()
    {
        gravity = 9.8;
        drag = 0.9;
    }
    public double applyDrag(double a)
    {
        return (-a * (1 - drag));
    }
    public double applyGravity()
    {
        return -gravity;
    }
}
