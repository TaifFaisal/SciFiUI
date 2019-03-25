package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Radar 
{
    private PVector pos;
    private float x;
    private float y;
    // private float speed;
    private float size;
    PApplet ui;
    float i;
    float j;
  

    private float rotation;
    // float speed
    public Radar(PApplet ui, float x, float y,  float size, float i, float j)
    {
        this.ui = ui;
        pos = new PVector(x, y);
        this.x = x;
        this.y = y;
        // this.speed = speed;
        this.size = size;
        this.i = i; //random(20,160)
        this.j = j; //random(420,140)
        
    }
}