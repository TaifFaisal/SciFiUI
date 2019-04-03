package ie.tudublin;

import processing.core.PVector;

public class Radar extends SpaceObject
{
    private PVector pos;
    private float x;
    private float y;
    // private float speed;
    private float size;
    float[] planetx = new float[5];
    float[] planety = new float[5];
    int num1 = 0;

    private float rotation;
    // float speed
    public Radar(UI ui, float x, float y,  float size)
    {
        super(ui);
        pos = new PVector(x, y);
        // this.speed = speed;
        this.size = size;
        while(num1 < 5)
        {
            planetx[num1] = ui.random(12, 110);
            planety[num1] = ui.random(630, 720);

            num1++;
        }
        
    }

    public void rect()
    {
        ui.fill(0);
        ui.noStroke();
        ui.rect(10,625,115,110);
    }

    public void render()
    {

        float howFast = 2;
        

        ui.pushMatrix();
        ui.noFill();
        ui.strokeWeight(2);
        ui.stroke(0,128,0);
        ui.circle(pos.x, pos.y, size);
        ui.circle(pos.x, pos.y, size-15);
        ui.circle(pos.x, pos.y, size-30);
        ui.circle(pos.x, pos.y, size-45);
        ui.circle(pos.x, pos.y, size-60);
        ui.circle(pos.x, pos.y, size-75);
        ui.circle(pos.x, pos.y, size-90);
        ui.circle(pos.x, pos.y, size-98);
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
            planety[i] += 0.09f;

            if(planety[i] > 720)
            {
                planety[i]= 630;
                planetx[i] = ui.random(12, 110);
        
            }
            ui.ellipse(planetx[i], ui.map(i, 0, 100, planety[i] , planety[i]), size1, size1);
            
        }
    }
    
    public void update()
    {
        rotation += 0.1f;
    }

}