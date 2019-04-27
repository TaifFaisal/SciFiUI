package ie.tudublin;


import processing.core.*;



public class BackGround extends SpaceObject 
{
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
	PImage img;
	float move; 
	float moverotate;
	float movex;

	public BackGround(UI ui) 
	{
		super(ui);
	
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
		move = 0;
		moverotate = 0;
		movex = 0;
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
	void fastmovingstars() 
	{	
		
		for(int num = 0; num<500; num++)
		{
			float x1 = ui.map(x[num] / z[num], 0, 1, 0, ui.width);
			float y1 = ui.map(y[num] / z[num], 0, 1, 0, ui.height);
			z[num] -= 10;
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

	
	}
	
	public void star()
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
		ui.image(img, -140, 610, 500, 500);


		ui.fill(169,169,169);
		ui.noStroke();
		ui.triangle(344 , 324 - move, 460 , 280 - move, 453 , 400 - move);
		ui.triangle(180 + move, 500 - move, 240 + move, 480 - move, 215 + move, 522 - move);
		ui.triangle(345 + move, 530 - move, 350 + move, 615 - move, 319 + move, 593 - move);
		
		ui.pushMatrix();
		ui.translate(380, -80);
		ui.rotate(0.6f);
		ui.noStroke();
		ui.rect(200, 350 + moverotate, 130, 240);

		ui.popMatrix();
		ui.pushMatrix();
		ui.translate(335, -50);
		ui.rotate(0.6f);
		ui.rect(248, 550 + moverotate, 60, 30);
		ui.popMatrix();

		/*// ui.stroke(255);
        // ui.strokeWeight(4);
		// ui.beginShape();
		// ui.vertex(460, 280);
		// ui.vertex(350, 320);
		// ui.vertex(460, 280);
		// ui.vertex(455, 395);
		// ui.vertex(320, 590);
		// ui.vertex(319, 593);
		// ui.vertex(350, 615);
		// ui.endShape();*/

		ui.noStroke();
		ui.fill(65,105,225);
		ui.circle(375 + move, 400 - move, 100);
	}
	public void borders()
    {
        ui.fill(255);
        ui.strokeWeight(4); 
        ui.line(0, ui.height/4, ui.width/8, ui.height/2.7f);
        ui.line(0, ui.height/3 + 400, ui.width/8, ui.height/2.2f + 200);
        ui.line(ui.width, ui.height/3 + 400, ui.width-100, ui.height/2.2f + 200);
        ui.line(ui.width, ui.height/4, ui.width-100, ui.height/2.7f);
        ui.line(ui.width/8, ui.height/2.7f, ui.width-100, ui.height/2.7f);
        ui.line(ui.width/8, ui.height/2.2f + 200, ui.width-100, ui.height/2.2f + 200);
	}
	public void infotext()
    {
        ui.fill(255);
        PFont font = ui.createFont("Apple Chancery", 32);
        ui.textFont(font);
        ui.text("Object Oriented Programming Assignment", ui.width/2, ui.height/2);
        ui.text("D17125070",  ui.width/4 + 200, ui.height/2+50);
	}
	public void structure()
    {
        ui.stroke(86, 86, 86);
        ui.strokeWeight(5);

        ui.beginShape();
        ui.fill(169,169,169);
        ui.vertex(-5, 0);
        ui.vertex(-5, ui.height/16);
        ui.vertex(0, ui.height/16);
        ui.vertex(ui.width/16*1.5f, ui.height/10);
        ui.vertex(ui.width/16*1.5f, ui.height/10);
        ui.vertex(ui.width-100, ui.height/10);
        ui.vertex(ui.width-100, ui.height/10);
        ui.vertex(ui.width, ui.height/16);
        ui.vertex(ui.width+5, ui.height/16);
        ui.vertex(ui.width+5, 0);
        ui.vertex(ui.width, -5);
        ui.vertex(-5, -5);
        ui.endShape();

        ui.beginShape();
        ui.fill(169,169,169);
        ui.vertex(0, ui.height/4 + 400);
        ui.vertex(ui.width/8, ui.height/3 + 200);
        ui.vertex(ui.width/8, ui.height/3 + 200);
        ui.vertex(ui.width - 100,ui.height/3 + 200);
        ui.vertex(ui.width - 100,ui.height/3 + 200);
        ui.vertex(ui.width, ui.height/4 + 400);
        ui.vertex(ui.width, ui.height/4 + 400);
        ui.vertex(ui.width, ui.height);
        ui.vertex(ui.width, ui.height);
        ui.vertex(0, ui.height);
        ui.vertex(0, ui.height);
        ui.vertex(0, ui.height/4 + 400);
        ui.endShape();  
    }
	

}
