package ie.tudublin;

import processing.core.PApplet;


public class Fire
{
    PApplet ui;

    public Fire(PApplet ui)
    {
        this.ui = ui;
    }
    
    public void mouse()
    {
        ui.stroke(255);
        ui.strokeWeight(3);
        ui.noFill();
        ui.ellipse(ui.mouseX, ui.mouseY, 50, 50);
    }

    // public void bullets()
    // {
        
    // }

   
}