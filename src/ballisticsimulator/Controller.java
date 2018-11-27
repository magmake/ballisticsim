package ballisticsimulator;

import javax.swing.Timer;
import java.awt.event.*;

public class Controller
{
    private final double TICK_RATE = 0.01;   //HOW OFTEN Draw() IS CALLED. IN MILLISECONDS
    static public final int DEF_WIND_WIDTH = 700;
    static public final int DEF_WIND_HEIGHT = 400;
    static public final double SCALING_FACTOR = 0.00000001;
    private boolean main_loop = true;
    Bullet bullet;
    Cannon cannon;
    Environment environment;
    View view;
    
    Controller()
    {
        view = new View();
        //FIX FIXED VALUES!!!!!
        bullet = new Bullet(0, DEF_WIND_HEIGHT, 10, 15);
        cannon = new Cannon(0, DEF_WIND_HEIGHT, 30, 10, 15);
        environment = new Environment();
        
        view.AddObject(cannon);
        view.AddObject(bullet);
    }
    private void Start()
    {
        long prev_time = System.nanoTime();
        long time = 0;
        double dt = 0;
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
            dt = (time - prev_time) / 1000000000.0;
            draw_timer = draw_timer + dt;
            //System.out.println(draw_timer);
            prev_time = time;
        }
    }
    private void Update(double dt)
    {
        bullet.setAcc(0, environment.applyGravity());
        bullet.setAcc(environment.applyDrag(bullet.getXAcc()), environment.applyDrag(bullet.getYAcc()));
        bullet.applyForces(dt);
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
