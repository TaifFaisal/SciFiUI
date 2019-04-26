package ie.tudublin;


import processing.core.PFont;

public class Clock extends SpaceObject 
{
    private float x;
    private float y;


    public Clock(UI ui, float x, float y)
    {
        super(ui);
        this.x = x;
        this.y = y;
    }

    public void frame()
    {
        ui.stroke(0);
        ui.fill(0);
        ui.rect(x , y , 150, 40);
    }
    
    public void digitalclock()
    {
        int s = ui.second(); 
        int m =ui. minute(); 
        int h = ui.hour(); 
        ui.fill(255);
        PFont font = ui.createFont("Times New Roman", 30);
        ui.textFont(font);
        ui.text(h+":"+m+":"+s, x + 73, y+15); 
    }
   
}