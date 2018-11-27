package ballisticsimulator;

import javax.swing.Timer;
import java.awt.event.*;

public class Controller
{
    private final int TICK_RATE = 17;   //HOW OFTEN Draw() IS CALLED. IN MILLISECONDS
    static public final int DEF_WIND_WIDTH = 700;
    static public final int DEF_WIND_HEIGHT = 400;
    private boolean main_loop = true;
    Bullet bullet;
    Cannon cannon;
    Environment environment;
    View view;
    
    Controller()
    {
        view = new View();
        //FIX FIXED VALUES!!!!!
        bullet = new Bullet(0, DEF_WIND_HEIGHT, 10, 40);
        cannon = new Cannon(0, DEF_WIND_HEIGHT, 30, 10, 40);
        environment = new Environment();
        
        view.AddObject(cannon);
        view.AddObject(bullet);
    }
    private void Start()
    {
        long prev_time = System.nanoTime();
        long time = 0;
        double dt = 0;  //DELTATIME. SHOULD BE CHANGED TO INT OR LONG
        double draw_timer = 0;
        while(main_loop)
        {
            //MAIN LOOP. SIMULATION RUNS IN THIS
            time = System.nanoTime();
            
            Update(dt);
            if(draw_timer > TICK_RATE)
            {
                //IF CERTAIN AMOUNT OF TIME HAS PASSED Draw() IS CALLED
                Draw();
                draw_timer = 0;
            }
            
            //TIMER STUFF
            dt = (time - prev_time) / 1000000.0;
            draw_timer = draw_timer + dt;
            prev_time = time;
        }
    }
    private void Update(double dt)
    {
        bullet.setPos(bullet.getXPos() + (1 * dt/5), bullet.getYPos() - (1 * dt/5));
        System.out.println(bullet.getXPos() + " " + bullet.getYPos());
    }
    private void Draw()
    {
        view.DrawFrame();
    }

    public static void main(String[] args)
    {
        //START POINT
        Controller c = new Controller();
        c.Start();
    }
}
