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

    public void rect()
    {
        ui.fill(0,0,255);
        ui.stroke(0,0,255);
        ui.rect(10,400,200,180);

        float howFast = 2;
        float size1 = 10;
        int num =0;
        ui.fill(255,218,185);
      
        // while(num <= 5)
        // {
        //     ui.ellipse(i[num], j[num], size1, size1);
        //     num++;
        // }
        
        ui.ellipse(i, j, size1, size1);
		//j = j + 0.1f;
    }
}