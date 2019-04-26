package ie.tudublin;

import processing.core.PApplet;
import processing.core.PFont;
import processing.data.Table;
import processing.data.TableRow;

import java.util.ArrayList;

import ddf.minim.*;

public class UI extends PApplet  
{
    Button button1;
    Button button2;
    Button button3;
    Button button4;
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
    Button beforespeed;
    Button afterspeed;
    Button information;
    Button help;
    Button targets;
    ExtraButton extrabuttons1; 
    ExtraButton extrabuttons2; 
    BackGround background;
    Radar radar;
    Clock clock;
    Info info;
    Spaceship spaceship;
    Screen screen;
    Graph graph;
    Targets fire;

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
    AudioPlayer infoaudio;
    AudioPlayer helpaudio;
    AudioPlayer Level;

    public void setup()
    {
        
        Table table = loadTable("Numbers.csv", "header");

        String[] words = loadStrings("screen.txt");
        sound = new Minim(this);
        start = sound.loadFile("BackgroundSound.mp3");
        // Level = sound.loadFile("EmergencyAlarm.mp3");
        
        // start.play();
        
        button1 = new Button(this, buttonX, buttonY, 100, 50,"Start");
        button2 = new Button(this, buttonX + 150, buttonY, 100, 50,"Info");
        button3 = new Button(this, buttonX + 300, buttonY, 100, 50,"Exit");
        button4 = new Button(this, buttonX + 450, buttonY, 100, 50,"Back");

        redbutton = new Button(this, 60 , 600, 17, 17,"Radar / OFF");
        greenbutton = new Button(this, 60 , 600, 17, 17,"Radar / ON");
        exitbutton = new Button(this, 650 , 20, 60, 40,"Exit");
        redcirclebutton = new Button(this, 385 , 20, 20, 20,"");
        greencirclebutton = new Button(this, 385 , 20, 20, 20,"");
        startbutton = new Button(this, 90 , 490, 110, 60,"Start");
        beforespeed = new Button(this, 170 , 630, 100, 30,"");
        afterspeed = new Button(this, 170 , 630, 100, 30,"");

        information = new Button(this, 350 , 25, 25, 25,"Info");
        help = new Button(this, 310 , 25, 25, 25,"Help");
       

        extrabuttons1 = new ExtraButton(this, 17, 17, table);
        extrabuttons2 = new ExtraButton(this, 17, 17, table);

        screen = new Screen(this, words, 300, 470);
        background = new BackGround(this);
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
        targets = new Button(this, 620 , 545, 50, 20,"Find targets");
        fire = new Targets(this, sound);        
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
    int speedcheck = 0;
    int checkinfo = 0;
    int checkhelp = 0;
    int checktargets = 0;
    public void draw()
    {
        background(0);
        start.play();

        if (checkKey(ENTER))
        {
            

            
            if(checkbutton == 1)
            {   
                
                button1.buttons();
                button2.buttons();
                button3.buttons();
                background.star1();
                background.spaceship();
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
                    if(mouseX > buttonX + 450 && mouseX < buttonX + 550 && mouseY > buttonY && mouseY < buttonY + 50)
                    {
                        button = 4;
                    }
                
                }
            }

            if (button == 1)
            {
                checkbutton = 0;
                //background.star();
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
                        else if(mouseX > 190 && mouseX < 250 && mouseY > 590 && mouseY < 605)
                        {
                            speedcheck = 1;

                        }
                        else if(mouseX > 190 && mouseX < 250 && mouseY > 690 && mouseY < 705)
                        {
                            speedcheck = 0;
                        }
                        else if(mouseX > 350 && mouseX < 375 && mouseY > 25 && mouseY < 50)
                        {
                            checkinfo =1;
                        }
                        else if(mouseX > 310 && mouseX < 335 && mouseY > 25 && mouseY < 50)
                        {
                            checkhelp =1;
                        }
                    }
                    
                    if(firecheck == 1)
                    {
                        fire.mouse();
                        fire.pinkdiamonds();
                        fire.diamonds();
                        if(mousePressed == true)
                        {
                            if(mouseX > 620  && mouseX < 670 && mouseY > 545 && mouseY < 565)
                            {
                                checktargets = 1;
                            } 
                        }
                    }
                    else
                    {
                        firecheck = 0;
                    }
                    if(checktargets == 1)
                    {
                        fire.findtargets();
                        checktargets = 0;
                    }
                    if(speedcheck == 1)
                    {
                        pushMatrix();
                        translate(width / 2, height / 2);
                        background.fastmovingstars();
                        //fire.monsters();
                        popMatrix();
                    }
                    else
                    {
                        pushMatrix();
                        translate(width / 2, height / 2);
                        background.movingstars();
                        popMatrix();
                    }

                    

                    spaceship.structure();
                    startbutton.afterstartbutton();
                    information.phonebuttons();
                    help.phonebuttons();
                    greencirclebutton.greencirclebutton();
                    radar.rect();
                    exitbutton.exitbutton();
                    screen.displayscreen();
                    screen.displaywords();
                    clock.frame();
                    graph.graphrect();
                    fireoff.redbutton();
                    fireon.greenbutton();
                    extrabuttons1.startextrabuttons1();
                    extrabuttons2.startextrabuttons2();
                    fire.pointsrect();
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
                    if(speedcheck == 1)
                    {
                        afterspeed.afterspeed();
                        
                    }
                    else
                    {
                        speedcheck = 0;
                        beforespeed.beforespeed();
                      
                    }
                    if(checkinfo == 1)
                    {
                        infoaudio = sound.loadFile("information.mp3");
                        infoaudio.play();
                        checkinfo = 0;
                    }
                    if(checkhelp == 1)
                    {
                        helpaudio = sound.loadFile("EmergencyAlarm.mp3");
                        helpaudio.play();
                        checkhelp = 0;
                    }
                    if(firecheck == 1)
                    {
                        targets.targetbuttons();
                        fire.displaypoints();
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
                    beforespeed.beforespeed();
                    extrabuttons1.extrabuttons1();
                    extrabuttons2.extrabuttons2();
                    information.phonebuttons();
                    help.phonebuttons();
                    fire.pointsrect();
                }
                
                if(exitcheck == 1)
                {
                    System.exit(0);
                }


            }
            if (button == 2)
            {
                background(0);
                background.star1();
                button1.buttons();
                button2.buttons();
                button3.buttons();
                button4.buttons();
                info.borders();
                info.infotext();
                checkbutton = 1;
            }
            if (button == 3)
            {
                background(0);
                background.star1();
                button1.buttons();
                button2.buttons();
                button3.buttons();
                button4.buttons();
                info.borders();
                text("Are you sure you want to exit?!", width/2 -20, height/2);
                text("if yes press Y or Space", width/4 +170, height/2 + 50);
                
                if(checkKey('Y') || checkKey('y'))
                {
                    System.exit(0);
                }
                checkbutton = 1;
            }
            if(button == 4)
            {
                button1.buttons();
                button2.buttons();
                button3.buttons();
                background.star1();
                background.spaceship();
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
    }   
        
}

