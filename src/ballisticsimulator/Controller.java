package ballisticsimulator;

import javax.swing.Timer;
import java.awt.event.*;

public class Controller
{
    private final int TICK_RATE = 200;   //HOW OFTEN Draw() IS CALLED. IN MILLISECONDS
    private boolean main_loop = true;
    Bullet bullet;
    Cannon cannon;
    Environment environment;
    View view;
    
    Controller()
    {
        bullet = new Bullet();
        cannon = new Cannon();
        environment = new Environment();
        view = new View();
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
