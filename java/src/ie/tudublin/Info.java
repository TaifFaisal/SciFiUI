package ie.tudublin;

import processing.core.PApplet;
import processing.core.PFont;

public class Info
{
    PApplet ui;
    private float x;
    private float y;

    public Info(PApplet ui, float x, float y)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        
    }
    public void render()
    {
        ui.fill(255);
        ui.strokeWeight(4); 
        ui.line(0, y/4, x/8, y/2.7f);
        ui.line(0, y/3 + 400, x/8, y/2.2f + 200);
        ui.line(x, y/3 + 400, x-100, y/2.2f + 200);
        ui.line(x, y/4, x-100, y/2.7f);
        ui.line(x/8, y/2.7f, x-100, y/2.7f);
        ui.line(x/8, y/2.2f + 200, x-100, y/2.2f + 200);
        ui.fill(255);
        PFont font = ui.createFont("Apple Chancery", 32);
        ui.textFont(font);
        ui.text("Object Oriented Programming Assignment", x/2, y/2);
        ui.text("D17125070", x/3 + 150, y/2+50);
    }


   
}