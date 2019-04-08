package ie.tudublin;

import ddf.minim.*;

public class Satellitephone extends SpaceObject
{
    private float x;
    private float y;


    public Satellitephone(UI ui,float x, float y)
    {
        super(ui);
        this.x = x;
        this.y = y;
    }
    public void rect()
    {
        ui.strokeWeight(3);
        ui.fill(0);
        // ui.stroke(192,192,192);
        ui.stroke(211,211,211);
        ui.rect(x, y, 110, 50);
        ui.strokeWeight(1);
        ui.stroke(0,128,0); 
    }
    
    
  
    // public void phone()
    // {
    //     ui.pushMatrix();
    //     ui.fill(68, 68, 68);
    //     ui.strokeWeight(2);
    //     ui.stroke(68, 68, 68);
    //     ui.translate(0, 0);
    //     ui.rotate(ui.PI/3.0f);
    //     ui.rect(830, -106, 50, 50);
    //     ui.stroke(0);
    //     //ui.curve(470, 700, 475, 710,510, 710 ,500, 690 );

    //     ui.popMatrix();
    //     ui.line(x-20, y+20, x+5, y+5);
    //     ui.line(x-20, y+30, x+10, y+10);
    // }
}