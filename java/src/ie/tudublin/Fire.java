package ie.tudublin;

import processing.data.Table;
import processing.data.TableRow;


public class Fire extends SpaceObject
{
    // float[] x = new float[10];
	// float[] y = new float[10];
	// float[] z = new float[10];
    // float[] size = new float[10];
    float x;
	float y;
	float z;
    float size;

    float rotation=5;
    Table table;
    int count = 0;


    public Fire(UI ui)
    {
        super(ui);

        // forward = new PVector(0, -1);
        // pos = new PVector(ui.mouseX, ui.mouseY);
        table = new Table();

        table.addColumn("x");
        table.addColumn("y");
        table.addColumn("z");
        table.addColumn("size");

        for(int i=0; i<20; i++)
        {
            TableRow newRow = table.addRow();
            newRow.setFloat("x", ui.random(0, ui.width));
            newRow.setFloat("y", ui.random(0, ui.height));
            newRow.setFloat("z", ui.random(ui.width));
            newRow.setFloat("size", ui.random(10, 20));
        }
        
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


    public void monsters()
    {
        int j =0;

		while(j < table.getRowCount())
		{
            TableRow row = table.getRow(j);
			float x1 = ui.map(row.getFloat("x") / row.getFloat("z"), 0, 1, 0, ui.width);
			float y1 = ui.map(row.getFloat("y") / row.getFloat("z"), 0, 1, 0, ui.height);
            
            float value = row.getFloat("z");
            row.setFloat("z", value -= 1);
            
            if(row.getFloat("z") < 1)
			{
                row.setFloat("z", ui.width);
            }

			//ui.ellipse(x1, y1, 10, 10);
			// ui.noStroke();
            //ui.image(img2, x1, y1, size[j], size[j]);
            ui.strokeWeight(3);
			ui.fill(255,20,147);
			ui.stroke(255,20,147);
            ui.ellipse(x1, y1, row.getFloat("size"), row.getFloat("size"));
            // if (ui.mousePressed == true)
            // {
            //     if(ui.mouseX > x1 && ui.mouseX< x1+size[j] && ui.mouseY>y1 && ui.mouseY<y1 + size[j])
            //     {
            //         count++;
            //         System.out.println("count"+count);
                    
            //     }
            // }
          
            j++;
		}		
    }

    // public void target()
    // {
    //     int clunter1 = 0;
    //     if (ui.mousePressed == true)
    //         {
    //             if(ui.mouseX > x1 && ui.mouseX< x1+size[j] && ui.mouseY>y1 && ui.mouseY<y1 + size[j])
    //             {
    //                 clunter1 += 1;
    //                 System.out.println("clunter1"+clunter1);
    //             }
    //         }
    // }
 
}