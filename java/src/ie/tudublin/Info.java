package ie.tudublin;

import processing.core.PApplet;

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
        System.out.println("x ="+ x);
        System.out.println("\n y ="+ y);
        ui.fill(255);
        ui.strokeWeight(4); 
        ui.line(0, y/4, x/8, y/2.7f);
        ui.line(0, y/3 + 400, x/8, y/2.2f + 200);
        ui.line(x, y/3 + 400, x-100, y/2.2f + 200);
        ui.line(x, y/4, x-100, y/2.7f);
        ui.line(x/8, y/2.7f, x-100, y/2.7f);
        ui.line(x/8, y/2.2f + 200, x-100, y/2.2f + 200);

    }


   
}