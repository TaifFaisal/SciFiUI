package ie.tudublin;

import processing.core.PImage;
import processing.data.Table;
import processing.data.TableRow;


public class Targets extends SpaceObject
{
    // float[] x = new float[10];
	// float[] y = new float[10];
	// float[] z = new float[10];
    // float[] size = new float[10];
    float x;
	float y;
	float z;
    float size;

    Table table;
    int count = 0;
    PImage oneimg;
    PImage[] images = new PImage[2];

    public Targets(UI ui)
    {
        super(ui);

        // forward = new PVector(0, -1);
        // pos = new PVector(ui.mouseX, ui.mouseY);
        table = new Table();

        table.addColumn("x1");
        table.addColumn("y1");
        table.addColumn("x2");
        table.addColumn("y2");
        table.addColumn("z");
        table.addColumn("size");

        for(int i=0; i<10; i++)
        {
            TableRow newRow = table.addRow();
            newRow.setFloat("x1", ui.random(0, ui.width));
            newRow.setFloat("y1", ui.random(0, ui.height));
            newRow.setFloat("x2", ui.random(0, ui.width));
            newRow.setFloat("y2", ui.random(0, ui.height));
            newRow.setFloat("z", ui.random(ui.width));
            newRow.setFloat("size", ui.random(10, 20));
        }
        images[0] = ui.loadImage("diamond.png");
        images[1] = ui.loadImage("pinkdiamond.png");
    }

    public void mouse()
    {
        ui.stroke(255);
        ui.strokeWeight(3);
        ui.noFill();
        ui.arc(ui.mouseX, ui.mouseY, 50, 50, 0, ui.PI*0.3f); 
        ui.arc(ui.mouseX, ui.mouseY, 50, 50, ui.PI*0.5f, ui.PI*0.8f); 
        ui.arc(ui.mouseX, ui.mouseY, 50, 50, ui.PI*1, ui.PI*1.3f); 
        ui.arc(ui.mouseX, ui.mouseY, 50, 50, ui.PI*1.5f, ui.PI*1.8f); 

    }


    public void pinkdiamonds()
    {
        int j =0;

		while(j < table.getRowCount())
		{
            TableRow row = table.getRow(j);
			float x1 = ui.map(row.getFloat("x1") / row.getFloat("z"), 0, 1, 0, ui.width);
			float y1 = ui.map(row.getFloat("y1") / row.getFloat("z"), 0, 1, 0, ui.height);
            
            float value = row.getFloat("z");
            row.setFloat("z", value -= 1);
            
            if(row.getFloat("z") < 1)
			{
                row.setFloat("z", ui.width);
            }

			//ui.ellipse(x1, y1, 10, 10);
            // ui.noStroke();
            
            ui.image(images[1], x1, y1, row.getFloat("size"), row.getFloat("size"));
            ui.strokeWeight(3);
			ui.fill(255,20,147);
            ui.stroke(255,20,147);
            
            //ui.ellipse(x1, y1, row.getFloat("size"), row.getFloat("size"));
            if (ui.mousePressed == true)
            {
                if(ui.mouseX > x1 && ui.mouseX< x1+row.getFloat("size") && ui.mouseY>y1 && ui.mouseY<y1 + row.getFloat("size"))
                {
                    count++;
                    table.removeRow(j);
                }
            }
            
            j++;
        }	
        System.out.println("count pink" + count);	
    }
    public void diamonds()
    {
        int j = 0;

		while(j < table.getRowCount())
		{
            TableRow row = table.getRow(j);
			float x1 = ui.map(row.getFloat("x2") / row.getFloat("z"), 0, 1, 0, ui.width);
			float y1 = ui.map(row.getFloat("y2") / row.getFloat("z"), 0, 1, 0, ui.height);
            
            float value = row.getFloat("z");
            row.setFloat("z", value -= 1);
            
            if(row.getFloat("z") < 1)
			{
                row.setFloat("z", ui.width);
            }

			//ui.ellipse(x1, y1, 10, 10);
            // ui.noStroke();
            
            ui.image(images[0], x1, y1, row.getFloat("size"), row.getFloat("size"));
            ui.strokeWeight(3);
			ui.fill(255,20,147);
            ui.stroke(255,20,147);
            
            //ui.ellipse(x1, y1, row.getFloat("size"), row.getFloat("size"));
            if (ui.mousePressed == true)
            {
                if(ui.mouseX > x1 && ui.mouseX< x1+row.getFloat("size") && ui.mouseY>y1 && ui.mouseY<y1 + row.getFloat("size"))
                {
                    count+=2;
                    table.removeRow(j);
                }
            }
            
            j++;
        }	
        System.out.println("count original" + count);	
    }

   
 
}