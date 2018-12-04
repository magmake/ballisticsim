package ballisticsimulator;

import javax.swing.Timer;
import java.awt.event.*;

public class Controller
{
    private final double TICK_RATE = 0.01;    //HOW OFTEN Draw() IS CALLED. IN MILLISECONDS
    static public final int DEF_WIND_WIDTH = 700;   //DEFAULT WINDOW SIZE
    static public final int DEF_WIND_HEIGHT = 400;
    static private boolean main_loop;   //MAIN LOOP BOOL
    static public boolean reset;
    Bullet bullet;
    Cannon cannon;
    Environment environment;
    View view;
    Ruler ruler;
    InputGUI gui;
    EndScreen loppuruutu;
    
    Controller()
    {
        KeyListener listener = new KeyInput();
        loppuruutu = new EndScreen();
        view = new View(listener);
        Initialize();
    }
    private void Initialize()
    {
        helloText();
        main_loop = true;
        reset = false;
        gui = new InputGUI();
        gui.drawWindow();
        ruler = new Ruler();
        bullet = new Bullet(0, DEF_WIND_HEIGHT, 10);
        cannon = new Cannon(0, DEF_WIND_HEIGHT, 30, 10);
        environment = new Environment();
        
        //GET THE VALUES FROM GUI WINDOW
        bullet.setForce(gui.getForce());
        bullet.setAngle(gui.getAngle());
        cannon.setAngle(gui.getAngle());
        bullet.setMass(gui.getMass());
        environment.setGravity(gui.getGravity());
        bullet.calculateAcc();
        
        //ADD OBJECTS TO MAIN FRAME
        view.AddObject(ruler);
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
            
            if (bullet.getYpos() > 400)
            {
                main_loop = false;
                loppuruutu.avaaLoppuikkuna(bullet.getXpos());
                cannon.setVisible(false);
                ruler.setVisible(false);
                Initialize();
                prev_time = System.nanoTime();
            }
            if (reset == true)
            {
                //RESET THE SIMULATION FROM KEYINPUT
                bullet.setVisible(false);
                cannon.setVisible(false);
                ruler.setVisible(false);
                Initialize();
                prev_time = System.nanoTime();
            }
        }
    }
    private void Update(double dt)
    {
        //UPDATE PHYSICS
        bullet.applyPhysics(dt, environment.getDrag(), environment.getGravity());
        bullet.updatePos();
    }
    private void Draw()
    {
        view.DrawFrame();
    }
    private void helloText()
    {
        System.out.println("BALLISTIC SIMULATOR V1\nMade by Kalle, Arttu and Markus.\nPress Spacebar to reset simulation!");
    }
    public static void main(String[] args)
    {
        //START POINT
        Controller c = new Controller();
        c.Start();
    }
}
