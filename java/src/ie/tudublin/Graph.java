package ie.tudublin;


import processing.core.PApplet;
import processing.core.PFont;
import processing.data.Table;
import processing.data.TableRow;

public class Graph
{
    PApplet ui;
    String[] planets = {"Mercury", "Pluto",  "Mars","Venus", "Earth", "Jupiter", "Uranus", "Saturn", "Neptune"};
    float[] Temperature = {300, 37, 150, 326, 260, 120, 48, 88, 59};

    public Graph(PApplet ui)
    {
        this.ui = ui;

    }
    
    public void graphrect()
    {
        ui.fill(0);
        ui.noStroke();
        ui.rect(620,610,150,130);
    }

    public void drawgraph()
    {
        
        float h = (ui.width / (float) Temperature.length)/8;
        int j = 5;
        float value=600;
        for(int i = 0 ; i < Temperature.length ; i ++) 
        {
            
            ui.noStroke();
            ui.fill(255);
            value = 621 +i * h;
            ui.rect(value +j, ui.map(i, 0, Temperature.length, ui.height-11, ui.height-11), h, -Temperature[i]/4);

            j += 5;
            
            //ui.fill(255);
            // float textY = ui.map(i, 0, Temperature.length, h * 0.5f, ui.height + (h * 0.5f));//i * h + (h * 0.5f);
            // ui.text(planets[i], 5, textY);
       }     
    }
}