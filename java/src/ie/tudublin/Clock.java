package ie.tudublin;

import processing.core.PApplet;

public class Clock
{
    PApplet ui;
    private float x;
    private float y;


    public Clock(PApplet ui)
    {
        this.ui = ui;
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