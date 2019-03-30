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
    float[] planetx = new float[5];
    float[] planety = new float[5];
    int num1 = 0;

    private float rotation;
    // float speed
    public Radar(PApplet ui, float x, float y,  float size)
    {
        this.ui = ui;
        pos = new PVector(x, y);
        this.x = x;
        this.y = y;
        // this.speed = speed;
        this.size = size;

        while(num1 < 5)
        {
            planetx[num1] = ui.random(20,100);
            planety[num1] = ui.random(635, 720);
            num1++;
        }
    }


    public void render()
    {
        ui.fill(0);
        ui.noStroke();
        ui.rect(10,625,115,110);

        float howFast = 2;
        

        ui.pushMatrix();
        ui.noFill();
        ui.strokeWeight(2);
        ui.stroke(0,128,0);
        ui.circle(x, y, size);
        ui.circle(x, y, size-15);
        ui.circle(x, y, size-30);
        ui.circle(x, y, size-45);
        ui.circle(x, y, size-60);
        ui.circle(x, y, size-75);
        ui.circle(x, y, size-90);
        ui.circle(x, y, size-98);
        ui.translate(pos.x, pos.y);
        ui.rotate(rotation);


        ui.stroke(0,128,0);

        ui.line(0, 0, pos.x/2, pos.x/2);
        ui.popMatrix();
        float size1 = 6;

        for(int i = 0; i< 5; i++)
        {
            ui.noStroke();
			ui.fill(255,218,185);
            ui.ellipse(planetx[i], planety[i], size1, size1);

        }
    }
    
    public void update()
    {
        //pos.x += speed;
        rotation += 0.1f;

    }


}