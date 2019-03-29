package ie.tudublin;

import processing.core.PApplet;
import processing.core.PFont;

public class UI extends PApplet
{
    Button button1;
    Button button2;
    Button button3;
    MovingCircle mc;
    BackGround background;
    Radar radar;
    Clock clock;
    Info info;


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
        button2 = new Button(this, buttonX + 150, buttonY, 100, 50,"Info");
        button3 = new Button(this, buttonX + 300, buttonY, 100, 50,"Exit");

        mc = new MovingCircle(this, width / 2, height / 2, 50);
        background = new BackGround(this);
        radar = new Radar(this, 110, 490,  150, random(20,160), random(420,140));
        clock = new Clock(this);
        info = new Info(this, width , height);
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
            button1.render();
            button2.render();
            button3.render();
            if(mousePressed == true)
            {
                //for the first button Start
                if(mouseX > buttonX && mouseX < buttonX + 100 && mouseY > buttonY && mouseY < buttonY + 50)
                {
                    button = 1;
                }
                //for the second button Information
                if(mouseX > buttonX + 150 && mouseX < buttonX + 250 && mouseY > buttonY && mouseY < buttonY + 50)
                {
                    button = 2;
                    //background.movingstars(); 
                }
                //for the third button Exit
                if(mouseX > buttonX + 300 && mouseX < buttonX + 400 && mouseY > buttonY && mouseY < buttonY + 50)
                {
                    button = 3;
                }
            }
            if (button == 1)
            {
                background.movingstars();
            }
            if (button == 2)
            {
                background.movingstars();
                info.render();
            }
            if (button == 3)
            {
                background.movingstars();
                text("Are you sure you want to exit?!", width/3, height/2);
                text("if yes press Y if no press any key", width/3, height/2 + 50);
                if(checkKey('Y') || checkKey('y'))
                {
                    System.exit(0);
                }
                else 
                {
                    
                }
            }
           
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

