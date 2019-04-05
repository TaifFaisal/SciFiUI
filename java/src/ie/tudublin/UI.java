package ie.tudublin;

import processing.core.PApplet;
import processing.core.PFont;
import processing.data.Table;

import java.util.ArrayList;

import ddf.minim.*;

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
    Button beforgraphbutton;
    Button aftergraphbutton;
    Button redcirclebutton;
    Button greencirclebutton;
    Button fireoff;
    Button fireon;
    ExtraButton extrabuttons; 
    BackGround background;
    Radar radar;
    Clock clock;
    Info info;
    Spaceship spaceship;
    Screen screen;
    Graph graph;
    Fire fire;

    boolean[] keys = new boolean[1024];
    public ArrayList<SpaceObject> spaceObject = new ArrayList<SpaceObject>(); 

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

    Minim sound;
    AudioPlayer start;

    public void setup()
    {
        Table table = loadTable("Numbers.csv", "header");

        String[] words = loadStrings("screen.txt");
        sound = new Minim(this);
        start = sound.loadFile("BackgroundSound.mp3");
        // start.play();
        
        button1 = new Button(this, buttonX, buttonY, 100, 50,"Start");
        button2 = new Button(this, buttonX + 150, buttonY, 100, 50,"Info");
        button3 = new Button(this, buttonX + 300, buttonY, 100, 50,"Exit");
        redbutton = new Button(this, 60 , 600, 17, 17,"Radar / OFF");
        greenbutton = new Button(this, 60 , 600, 17, 17,"Radar / ON");
        exitbutton = new Button(this, 650 , 20, 60, 40,"Exit");
        redcirclebutton = new Button(this, 300 , 20, 20, 20,"");
        greencirclebutton = new Button(this, 300 , 20, 20, 20,"");
        startbutton = new Button(this, 90 , 490, 110, 60,"Start");
        extrabuttons = new ExtraButton(this, 450 , 500, 17, 17, table);
        screen = new Screen(this, words, 300, 470);
        background = new BackGround(this);

        // spaceObject.add(background);
        
        radar = new Radar(this, 65, 680,  100);
        clock = new Clock(this, 120, 20);
        clockredbutton = new Button(this, 85 , 35, 17, 17,"Clock / OFF");
        clockgreenbutton = new Button(this, 85 , 35, 17, 17,"Clock / ON");
        info = new Info(this, width , height);
        spaceship = new Spaceship(this, width, height);
        graph = new Graph(this);
        beforgraphbutton = new Button(this, 685 , 580, 17, 17,"Bar char/OFF");
        aftergraphbutton = new Button(this, 685 , 580, 17, 17,"Bar char/ON");
        fireon = new Button(this, 610 , 510, 17, 17,"Fire / ON");
        fireoff = new Button(this, 660 , 510, 17, 17,"Fire / OFF");
        fire = new Fire(this);
    }
   
    int button = 0;
    int checkbutton = 1;
    int homebutton = 1;
    int onoffbutton = 0;
    int exitcheck = 0;
    int startcheck = 0;
    int clockckeck = 0;
    int graphcheck = 0;
    int firecheck = 0;
    public void draw()
    {
        background(0);
        // start.play();
        // fire.monsters();
        // background.loadData();
        // background.star();
        pushMatrix();
        translate(width / 2, height / 2);
        background.movingstars();
        //fire.monsters();

        popMatrix();
        // background.spaceship();
        //background.update();
        fire.mouse();
        spaceship.structure();

        radar.rect();
        exitbutton.exitbutton();
        startbutton.beforestartbutton();
        screen.displayscreen();
        clock.frame();
        radar.render();
        radar.update();

        // redbutton.redbutton();
        // startbutton.beforestartbutton();
        screen.displayscreen();
        screen.displaywords();
        //screen.instructions();
        // clock.frame();
        //clockredbutton.clockredbutton();
        // clockgreenbutton.clockgreenbutton();
        // clock.digitalclock();
        
        graph.graphrect();
        fireoff.redbutton();
        fireon.greenbutton();
        extrabuttons.extrabuttons();
        
        // graph.drawgraph();
        // clock.analogclock();



      /*
        if (checkKey(ENTER))
        {
            

            
            if(checkbutton == 1)
            {   
                
                button1.buttons();
                button2.buttons();
                button3.buttons();
                background.star1();
                background.spaceship();
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
                
            }
            if (button == 1)
            {
                checkbutton = 0;
                background.star();
                spaceship.structure();
                if(mousePressed == true)
                {
                    if(mouseX > 650  && mouseX < 710 && mouseY > 20 && mouseY < 60)
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
                        
                        else if(mouseX > 685  && mouseX < 702 && mouseY > 580 && mouseY < 597)
                        {
                            graphcheck = 1;
                        }
                        else if(mouseX > 85 && mouseX < 102 && mouseY > 35 && mouseY < 52 )
                        {
                            clockckeck = 1;
                        }
                        else if(mouseX > 610 && mouseX < 627 && mouseY > 510 && mouseY < 527 )
                        {
                            firecheck = 1;
                        }
                        else if(mouseX > 660 && mouseX < 677 && mouseY > 510 && mouseY < 527 )
                        {
                            firecheck = 0;
                        }
                    }
                    
                    if(firecheck == 1)
                    {
                        
                        fire.mouse();
                        //screen.instructions();
                    }
                    else
                    {
                        firecheck = 0;
                    }
                    pushMatrix();
                    translate(width / 2, height / 2);
                    background.movingstars();
                    popMatrix();
                    spaceship.structure();
                    startbutton.afterstartbutton();
                    greencirclebutton.greencirclebutton();
                    radar.rect();
                    exitbutton.exitbutton();
                    screen.displayscreen();
                    screen.displaywords();
                    clock.frame();
                    graph.graphrect();
                    fireoff.redbutton();
                    fireon.greenbutton();
                    
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
                    if(graphcheck == 1)
                    {
                        aftergraphbutton.aftergraphbutton();
                        graph.drawgraph();
                        graph.update();
                    }
                    else
                    {
                        graphcheck = 0;
                        beforgraphbutton.beforegraphbutton();
                    }
                    if(firecheck == 1)
                    {

                        screen.instructions();
                    }
                    else
                    {
                        firecheck = 0;
                    }
                    
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
                    graph.graphrect();
                    beforgraphbutton.beforegraphbutton();
                    redbutton.redbutton();
                    clockredbutton.clockredbutton();
                    redcirclebutton.redcirclebutton();
                    fireoff.redbutton();
                    fireon.greenbutton();
        
                }
                // if(clockckeck == 1)
                // {
                //     clockgreenbutton.clockgreenbutton();
                //     clock.digitalclock();
                // }
                // else
                // {
                //     clockredbutton.clockredbutton();
                // }
                // if(onoffbutton == 0)
                // {
                //     redbutton.redbutton();
                // }
                
                // else
                // {
                //     greenbutton.greenbutton();
                //     radar.render();
                //     radar.update();
                //     // if(mouseX > 60  && mouseX < 77 && mouseY > 600 && mouseY < 617)
                //     // {
                //     //     onoffbutton = 0;
                //     // } 
                // }
                // if(graphcheck == 1)
                // {
                //     aftergraphbutton.aftergraphbutton();
                //     graph.drawgraph();
                //     graph.update();
                // }
                // else
                // {
                //     beforgraphbutton.beforegraphbutton();
                // }
                if(exitcheck == 1)
                {
                    System.exit(0);
                }


            }
            if (button == 2)
            {
                checkbutton = 0;
                background.star1();
                button1.buttons();
                button2.buttons();
                button3.buttons();
                info.borders();
                if(mouseX > buttonX + 150 && mouseX < buttonX + 250 && mouseY > buttonY && mouseY < buttonY + 50)
                {
                    
                }
            }
            if (button == 3)
            {
                checkbutton = 0;
                background.star1();
                button1.buttons();
                button2.buttons();
                button3.buttons();
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
            background.star();
            fill(255);
            PFont font = createFont("Apple Chancery", 32);
            textFont(font);
            text("Press Enter to start", width/3, height/2);  
        }
        */
        
        
        
    }
}

