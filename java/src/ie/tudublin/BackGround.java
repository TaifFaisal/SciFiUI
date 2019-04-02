package ie.tudublin;

import java.util.ArrayList;

import javafx.scene.shape.Circle;
import processing.core.*;



public class BackGround 
{	
	// float[] x1 = new float[50];
	// float[] y1 = new float[50];
	// float[] z1 = new float[50];
	// float[] size1 = new float[50];
	
	ArrayList<Circle> circles;
	float[] x = new float[500];
	float[] y = new float[500];
	float[] z = new float[500];
	float[] size = new float[500];
	int num1 = 0;
    float num2 = 4;
    float[] size2 = new float[50];
    float[] w = new float[50];
	float[] h = new float[50];
	float[] a = new float[50];
	PApplet ui;
	PImage img;

	// float x = random(width);
	// float y = random(height);
	// float z = random(1, 4);
	// float size = random(2, 9);

	// public Back(PApplet ui, float x, float y, float z, float size)
	public BackGround(PApplet ui)
	{
		this.ui = ui;
		circles = new ArrayList<Circle>();
		
		for(int i=0; i<20; i++)
		{
			circles.add(new Circle());
		}
		// float x1 = ui.random(ui.width);
		// float y1 = ui.random(ui.height);
		// float z1 = ui.random(1, 4);
		// float size1 = ui.random(2, 9);
		int number = 0; 
		while(number<500)
		{
			x[number] = ui.random(-ui.width, ui.width);
			y[number] = ui.random(-ui.height, ui.height);
			z[number] = ui.random(ui.width);
			size[number] = ui.random(1, 9);
			number++;
		}

		while(num1 < 50)
        {
            size2[num1] = ui.random(1,8);
            w[num1] = ui.random(ui.width);
			h[num1] = ui.random(ui.height);
			a[num1] = ui.random(1, 4);
            num1++;
        }
		// int num = 0; 
		// while(num<50)
		// {
		// 	ui.x[num] = random(width);
		// 	y[num] = random(height);
		// 	z[num] = random(1, 4);
		// 	size[num] = random(2, 9);
		// 	num++;
		// }
		img = ui.loadImage("moon.png");
		

	}
	
	void movingstars() 
	{	
		
		for(int num = 0; num<500; num++)
		{
			float x1 = ui.map(x[num] / z[num], 0, 1, 0, ui.width);
			float y1 = ui.map(y[num] / z[num], 0, 1, 0, ui.height);
			z[num] -= 1;
			if(z[num] < 1)
			{
				z[num] = ui.width;
			}
			ui.strokeWeight(1);
			ui.fill(255);
			ui.stroke(255);
			ui.ellipse(x1, y1, size[num], size[num]);
		}			
	}

	void star1()
	{
		for(int num = 0; num<50; num++)
		{
			ui.strokeWeight(1);
			ui.fill(255);
			ui.stroke(255);
			ui.ellipse(w[num], h[num], size2[num], size2[num]);
		
			w[num] -=  a[num];
			
			if(w[num] < 0)
			{
				w[num] = ui.width;
				
			}
		}

		// ui.ellipse(x, y, size, size);
			
		// x = x - z;
		// if(x < 0)
		// {
		// 	x = ui.width;
		// }
	
	}
	
	void star()
	{
		for(int i = 0; i<50; i++)
        {
			ui.strokeWeight(1);
			ui.fill(255);
			ui.stroke(255);
            ui.ellipse(w[i], h[i], size2[i], size2[i]);

        }
	}
	
	void spaceship()
	{
		ui.noStroke();
		ui.fill(231,220,184);
		ui.image(img, 100, 850, 500, 500);
		ui.image(img, -140, 610, 500, 500);
		// ui.ellipse();

		ui.stroke(210, 192, 131);
		ui.strokeWeight(3);
		// ui.ellipse(55, 750, 50, 50);
		// ui.ellipse(140, 650, 30, 30);
		// ui.ellipse(140, 690, 40, 40);
		// ui.ellipse(80, 680, 10, 10);
		// ui.ellipse(100, 670, 20, 20);
		// ui.ellipse(140, 650, 30, 30);
		// ui.ellipse(140, 690, 40, 40);
		// ui.ellipse(80, 680, 10, 10);

		for(int i = 0; i<23; i++)
		{

		}
		ui.fill(169,169,169);
		ui.noStroke();
		ui.triangle(344, 324, 460, 280, 453, 400);
		ui.triangle(180, 500, 240, 480, 215, 522);
		ui.triangle(345, 530, 350, 615, 319, 593);
		ui.pushMatrix();
		ui.translate(380, -80);
		ui.rotate(0.6f);
		ui.noStroke();
		
		ui.rect(200, 350, 130, 240);
		ui.popMatrix();
		ui.pushMatrix();
		ui.translate(335, -50);
		ui.rotate(0.6f);
		ui.rect(248, 550, 60, 30);
		ui.popMatrix();

		// ui.stroke(255);
        // ui.strokeWeight(4);
		// ui.beginShape();
		// ui.vertex(460, 280);
		// ui.vertex(350, 320);
		// ui.vertex(460, 280);
		// ui.vertex(455, 395);
		// ui.vertex(320, 590);
		// ui.vertex(319, 593);
		// ui.vertex(350, 615);
		// ui.endShape();


		ui.fill(65,105,225);
		ui.circle(375, 400, 100);
	}
}
