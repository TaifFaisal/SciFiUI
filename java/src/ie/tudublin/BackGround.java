package ie.tudublin;

import processing.core.*;


public class BackGround 
{	
	// float[] x1 = new float[50];
	// float[] y1 = new float[50];
	// float[] z1 = new float[50];
	// float[] size1 = new float[50];
	

	float[] x = new float[50];
	float[] y = new float[50];
	float[] z = new float[50];
	float[] size = new float[50];
	int num1 = 0;
    float num2 = 4;
    float[] num = new float[50];
    float[] w = new float[50];
    float[] h = new float[50];
	PApplet ui;

	// float x = random(width);
	// float y = random(height);
	// float z = random(1, 4);
	// float size = random(2, 9);

	// public Back(PApplet ui, float x, float y, float z, float size)
	public BackGround(PApplet ui)
	{
		this.ui = ui;
		// this.x = x;
		// this.y =y;
		// this.z = z;
		// this.size = size;

		// float x1 = ui.random(ui.width);
		// float y1 = ui.random(ui.height);
		// float z1 = ui.random(1, 4);
		// float size1 = ui.random(2, 9);

		int number = 0; 
		while(number<50)
		{
			x[number] = ui.random(ui.width);
			y[number] = ui.random(ui.height);
			z[number] = ui.random(1, 4);
			size[number] = ui.random(2, 9);
			number++;
		}

		while(num1 < 50)
        {
            num[num1] = ui.random(1,8);
            w[num1] = ui.random(ui.width);
            h[num1] = ui.random(ui.height);
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

	}
	
	void movingstars() 
	{	
		for(int num = 0; num<50; num++)
		{
			ui.fill(255);
			ui.ellipse(x[num], y[num], size[num], size[num]);
		
			x[num] = x[num] - z[num];
			
			if(x[num] < 0)
			{
				x[num] = ui.width;
				
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
            ui.ellipse(w[i], h[i], num[i], num[i]);

        }
	}
	
	void spaceship()
	{
		
	}
	



}
