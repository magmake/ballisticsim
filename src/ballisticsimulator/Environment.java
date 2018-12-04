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
        //gravity = 500;
        drag = 1; //ACTUALLY JUST THE SPEED OF THE PROJECTILE. DOESN'T WORK AS INTEDED
    }
    public double getDrag()
    {
        return drag;
    }
    public void setGravity(double g)
    {
        gravity = g;
    }
    public double getGravity()
    {
        return gravity;
    }
}
