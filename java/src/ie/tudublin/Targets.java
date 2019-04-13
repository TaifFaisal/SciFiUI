package ie.tudublin;

import processing.core.PFont;
import processing.core.PImage;
import processing.data.Table;
import processing.data.TableRow;
import ddf.minim.*;

public class Targets extends SpaceObject
{
    Minim sound;
    AudioPlayer levelup;
    Table table;
    int count = 0;
    int checkpink = 0;
    int checkwhite = 0;
    int level = 0;
    int x = 0;
    PImage oneimg;
    PImage[] images = new PImage[2];

    public Targets(UI ui, Minim sound)
    {
        super(ui);
        this.sound = sound;
        // this.Level = Level;
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
                    checkwhite = 0;
                    count += 2;
                    checkpink =1;
                    table.removeRow(j);
                }
            }
            
            j++;
        }	
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

            ui.image(images[0], x1, y1, row.getFloat("size"), row.getFloat("size"));
            ui.strokeWeight(3);
			ui.fill(255,20,147);
            ui.stroke(255,20,147);
            
            if (ui.mousePressed == true)
            {
                if(ui.mouseX > x1 && ui.mouseX< x1+row.getFloat("size") && ui.mouseY>y1 && ui.mouseY<y1 + row.getFloat("size"))
                {
                    checkpink = 0;
                    count += 4;
                    checkwhite =1;
                    table.removeRow(j);
                }
            }
            j++;
        }	
    }
    public void pointsrect()
    {
        ui.strokeWeight(3);
        ui.fill(0);
        ui.stroke(211, 211, 211);
        ui.rect(470, 630, 110, 100);
    }
    public void displaypoints()
    {
        
        ui.fill(211, 211, 211);
        ui.strokeWeight(3);
        ui.stroke(0);
        ui.rect(480, 670, 90, 40);
        
        if(checkwhite ==1)
        {
            ui.image(images[0], 480, 665, 50, 50);
            
        }
        else if(checkpink ==1)
        {
            ui.image(images[1], 485, 675, 35, 30);
            
        }
        else
        {
            ui.noFill();
            ui.strokeWeight(3);
            ui.stroke(0);
            ui.rect(480, 670, 50, 50);
        }
        PFont font = ui.createFont("Times New Roman", 20);
        ui.textFont(font);
        ui.fill(0);
        ui.text(count, 550 , 687);
        ui.fill(255);
        ui.text("Level \t \t" + level, 515 , 650);
        if(count > 0)
        {
            if(count > 9 + (10 * x))
            {
                level++;
                levelup = sound.loadFile("LevelUp.mp3");
                levelup.play();
                x++;
            }
        }
        if(table.getRowCount() < 5)
        {
            for(int i=0; i<7; i++)
            {
                TableRow newRow = table.addRow();
                newRow.setFloat("x1", ui.random(0, ui.width));
                newRow.setFloat("y1", ui.random(0, ui.height));
                newRow.setFloat("x2", ui.random(0, ui.width));
                newRow.setFloat("y2", ui.random(0, ui.height));
                newRow.setFloat("z", ui.random(ui.width));
                newRow.setFloat("size", ui.random(10, 20));

            }
        }
    }
    public void findtargets()
    {
        for(int i=0; i<4; i++)
        {
            TableRow newRow = table.addRow();
            newRow.setFloat("x1", ui.random(0, ui.width));
            newRow.setFloat("y1", ui.random(0, ui.height));
            newRow.setFloat("x2", ui.random(0, ui.width));
            newRow.setFloat("y2", ui.random(0, ui.height));
            newRow.setFloat("z", ui.random(ui.width));
            newRow.setFloat("size", ui.random(10, 20));
        } 
    }

   
 
}