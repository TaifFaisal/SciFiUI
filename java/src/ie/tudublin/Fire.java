package ie.tudublin;

import processing.core.PImage;

public class Fire extends SpaceObject
{
    float[] x = new float[50];
	float[] y = new float[50];
	float[] z = new float[50];
    float[] size = new float[50];
    float PI = 3.14f;
    PImage img2;
    
    public Fire(UI ui)
    {
        super(ui);

        for(int i =0; i< x.length; i++)
        {
            x[i] = ui.random(0, ui.width);
			y[i] = ui.random(0, ui.height);
			z[i] = ui.random(ui.width);
			size[i] = ui.random(50, 100);
        }

        img2 = ui.loadImage("ghost.png");
    }
    
    public void mouse()
    {
        ui.stroke(255);
        ui.strokeWeight(3);
        ui.noFill();
        ui.arc(ui.mouseX, ui.mouseY, 50, 50, 0, PI*0.3f); 
        ui.arc(ui.mouseX, ui.mouseY, 50, 50, PI*0.5f, PI*0.8f); 
        ui.arc(ui.mouseX, ui.mouseY, 50, 50, PI*1, PI*1.3f); 
        ui.arc(ui.mouseX, ui.mouseY, 50, 50, PI*1.5f, PI*1.8f); 

    }
    public void monsters()
    {
        int j =0;
		while(j < x.length)
		{
			float x1 = ui.map(x[j] / z[j], 0, 1, 0, ui.width);
			float y1 = ui.map(y[j] / z[j], 0, 1, 0, ui.height);
			z[j] -= 1;
			if(z[j] < 1)
			{
				z[j] = ui.width;
            }
            // ui.strokeWeight(1);
			// ui.fill(255);
			// ui.stroke(255);
			//ui.ellipse(x1, y1, 10, 10);
			// ui.noStroke();
            ui.image(img2, x1, y1, size[j], size[j]);
            j++;
		}		
    }

    // public void bullets()
    // {
    //     if (ui.checkKey(' '))
    //     {

    //     }
    // }
 
}