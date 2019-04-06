package ie.tudublin;

import processing.core.*;

 public class Spaceship extends SpaceObject
{
    private float x;
    private float y;

    public Spaceship(UI ui, float x, float y)
    {
        super(ui);
        this.x = x;
        this.y = y;
    }
    public void structure()
    {
        ui.stroke(86, 86, 86);
        ui.strokeWeight(5);

        ui.beginShape();
        ui.fill(169,169,169);
        ui.vertex(-5, 0);
        ui.vertex(-5, y/16);
        ui.vertex(0, y/16);
        ui.vertex(x/16*1.5f, y/10);
        ui.vertex(x/16*1.5f, y/10);
        ui.vertex(x-100, y/10);
        ui.vertex(x-100, y/10);
        ui.vertex(x, y/16);
        ui.vertex(x+5, y/16);
        ui.vertex(x+5, 0);
        ui.vertex(x, -5);
        ui.vertex(-5, -5);
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