package ie.tudublin;

import processing.core.*;

 public class Spaceship
{
    PApplet ui;
    private float x;
    private float y;
    private float rotate;

    public Spaceship(PApplet ui, float x, float y)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        rotate =  0.6f;
        
    }
    
    public void structure()
    {
        ui.stroke(169,169,169);
        ui.strokeWeight(4);
        

        // ui.line(0, y/4, x/8, y/2.7f);
        // ui.line(x, y/4, x-100, y/2.7f);
        // ui.line(x/8, y/2.7f, x-100, y/2.7f);


        // ui.line(0, y/3 + 400, x/8, y/2.2f + 200);
        // ui.line(x, y/3 + 400, x-100, y/2.2f + 200);
        // ui.line(x/8, y/2.2f + 200, x-100, y/2.2f + 200);

        ui.beginShape();
        ui.fill(169,169,169);
        ui.vertex(0, 0);
        ui.vertex(0, y/16);
        ui.vertex(0, y/16);
        ui.vertex(x/10, y/10);
        ui.vertex(x/10, y/10);
        ui.vertex(x-100, y/10);
        ui.vertex(x-100, y/10);
        ui.vertex(x, y/16);
        ui.vertex(x, y/16);
        ui.vertex(x, 0);
        ui.vertex( x, 0);
        ui.vertex(0, 0);
        ui.endShape();

        ui.beginShape();
        ui.fill(169,169,169);
        ui.vertex(0, y/4 + 400);
        ui.vertex(x/8, y/3 + 200);
        ui.vertex(x/8, y/3 + 200);
        ui.vertex(x - 100,y/3 + 200);
        ui.vertex(x - 100,y/3 + 200);
        ui.vertex(x, y/4 + 400);
        ui.vertex(x, y/4 + 400);
        ui.vertex(x, y);
        ui.vertex(x, y);
        ui.vertex(0, y);
        ui.vertex(0, y);
        ui.vertex(0, y/4 + 400);
        ui.endShape();

       
    }

    


   
}