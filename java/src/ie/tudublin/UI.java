package ie.tudublin;

import java.awt.GraphicsEnvironment;

import processing.core.PApplet;
import processing.core.PFont;

public class UI extends PApplet
{
    Button button1;
    Button button2;
    Button button3;
    Button redbutton;
    Button greenbutton;
    Button exitbutton;
    Button startbutton;
    Button clockredbutton;
    Button clockgreenbutton;
    BackGround background;
    Radar radar;
    Clock clock;
    Info info;
    Spaceship spaceship;
    Screen screen;

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
        size(800, 750);
        // Use fullscreen instead of size to make your interface fullscreen
        // fullScreen();
        //fullScreen(P3D);
    }
    float buttonX = width/3;
    float buttonY = height/3;
    public void setup()
    {
        String[] words = loadStrings("screen.txt");
        
        button1 = new Button(this, buttonX, buttonY, 100, 50,"Start");
        button2 = new Button(this, buttonX + 150, buttonY, 100, 50,"Info");
        button3 = new Button(this, buttonX + 300, buttonY, 100, 50,"Exit");
        redbutton = new Button(this, 60 , 600, 17, 17,"Radar / OFF");
        greenbutton = new Button(this, 60 , 600, 17, 17,"Radar / ON");
        exitbutton = new Button(this, 650 , 20, 60, 40,"Exit");
        startbutton = new Button(this, 90 , 490, 110, 60,"Start");
        screen = new Screen(this, words, 300, 470);
        background = new BackGround(this);
        radar = new Radar(this, 65, 680,  100);
        clock = new Clock(this, 120, 20);
        clockredbutton = new Button(this, 85 , 35, 17, 17,"Clock / OFF");
        clockgreenbutton = new Button(this, 85 , 35, 17, 17,"Clock / ON");
        info = new Info(this, width , height);
        spaceship = new Spaceship(this, width, height);
        
    }
    int button = 0;
    int checkbutton = 1;
    int homebutton = 1;
    int onoffbutton = 0;
    int exitcheck = 0;
    int startcheck = 0;
    int clockckeck = 0;
    public void draw()
    {
        background(0);

        // spaceship.structure();
        // radar.render();
        // radar.update();
        // redbutton.redbutton();
        // startbutton.beforestartbutton();
        // screen.displayscreen();
        // screen.displaywords();
        // clock.frame();
        // //clockredbutton.clockredbutton();
        // // clockgreenbutton.clockgreenbutton();
        // clock.digitalclock();
        // // clock.analogclock();


    //    /*
        if (checkKey(ENTER))
        {
            // background.star();
            // background.spaceship();
            if(checkbutton == 1)
            {
                button1.buttons();
                button2.buttons();
                button3.buttons();
            }
            
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
                if(mouseX > 85 && mouseX < 102 && mouseY > 35 && mouseY < 52 )
                {
                    clockckeck = 1;
                }
            }
            if (button == 1)
            {
                checkbutton = 0;
                // background.star();
                // spaceship.structure();
                // radar.rect();
                // exitbutton.exitbutton();
                
                if(mousePressed == true)
                {
                    if(mouseX > 60  && mouseX < 77 && mouseY > 600 && mouseY < 617)
                    {
                        onoffbutton = 1;
                    } 
                    else if(mouseX > 650  && mouseX < 710 && mouseY > 20 && mouseY < 60)
                    {
                        exitcheck = 1;
                    }
                    else if(mouseX > 90  && mouseX < 200 && mouseY > 490 && mouseY < 550)
                    {
                        startcheck = 1;
                    }
                }
                if(startcheck == 1)
                {
                    background.movingstars();
                    spaceship.structure();
                    startbutton.afterstartbutton();
                    radar.rect();
                    exitbutton.exitbutton();
                    screen.displayscreen();
                    screen.displaywords();
                    clock.frame();
                    
                    

                }
                else
                {
                    background.star();
                    spaceship.structure();
                    radar.rect();
                    exitbutton.exitbutton();
                    startbutton.beforestartbutton();
                    screen.displayscreen();
                    clock.frame();
                }
                if(clockckeck == 1)
                    {
                        clockgreenbutton.clockgreenbutton();
                        clock.digitalclock();
                    }
                    else
                    {
                        clockredbutton.clockredbutton();
                    }
                if(onoffbutton == 0)
                {
                    redbutton.redbutton();
                }
                
                else
                {
                    greenbutton.greenbutton();
                    radar.render();
                    radar.update();
                    // if(mouseX > 60  && mouseX < 77 && mouseY > 600 && mouseY < 617)
                    // {
                    //     onoffbutton = 0;
                    // } 
                }
                if(exitcheck == 1)
                {
                    System.exit(0);
                }


            }
            if (button == 2)
            {
                checkbutton = 1;
                button2 = new Button(this, buttonX + 150, buttonY, 100, 50,"Home");
                background.movingstars();
                info.borders();
                if(mouseX > buttonX + 150 && mouseX < buttonX + 250 && mouseY > buttonY && mouseY < buttonY + 50)
                {
                    
                }
            }
            if (button == 3)
            {
                checkbutton = 1;
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
        // */
        
        
        
    }
}

