package ie.tudublin;

import processing.core.PApplet;
import processing.core.PFont;

public class UI extends PApplet
{
    Button button1;
    
    MovingCircle mc;
    BackGround background;
    Radar radar;
    Clock clock;

    boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = true;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    

    public void settings()
    {
        size(800, 800);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen();
        //fullScreen(P3D);
    }
    float buttonX = width/3;
    float buttonY = height/3;
    public void setup()
    {
        
        button1 = new Button(this, buttonX, buttonY, 100, 50,"Start");
        

        mc = new MovingCircle(this, width / 2, height / 2, 50);
        background = new BackGround(this);
        radar = new Radar(this, 110, 490,  150, random(20,160), random(420,140));
        clock = new Clock(this);
    }
    int button = 0;

    public void draw()
    {
        background(0);

        // mc.update();
        // mc.render();
        
        if (checkKey(ENTER))
        {
            // background.star();
            // background.spaceship();

            
           
        }
        else
        {
            //background.star1();
            fill(255);
            PFont font = createFont("Apple Chancery", 32);
            textFont(font);
            text("Press Enter to start", width/3, height/2);  
        }
        
        
        
        // radar.rect();
        // radar.render();
        // radar.update();
        // clock.digitalclock();
        // clock.analogclock();

        
    }
}

