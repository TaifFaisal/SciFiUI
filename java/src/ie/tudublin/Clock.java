package ie.tudublin;

import processing.core.PApplet;

public class Clock
{
    PApplet ui;
    private float x;
    private float y;


    public Clock(PApplet ui, float x, float y)
    {
        this.ui = ui;
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
        ui.text(h+":"+m+":"+s, 15, 50); 
    }
   
    public void analogclock()
    {
        float x =0;
        float y =0;
        //ellipse();
    }
}