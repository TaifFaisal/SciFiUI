package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;
import processing.data.Table;
import processing.data.TableRow;

public class ExtraButton extends SpaceObject
{
    private float x;
    private float y;
    private float width;
    private float height;
    //float[] buttons = new float[3];
    private Table table;

    public ExtraButton(UI ui, float x, float y, float width, float height, Table table)
    {
        super(ui);
        //Button s = new button();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.table = table;
        
    }
    public void extrabuttons()
    {
        for(TableRow row:table.rows())
        {   
            int x = row.getInt("x");
            int y = row.getInt("y");
            ui.strokeWeight(3);
            ui.fill(85,107,47);
            ui.stroke(0,100,0);
            ui.rect(x, y, width, height);            
        } 

    }
}