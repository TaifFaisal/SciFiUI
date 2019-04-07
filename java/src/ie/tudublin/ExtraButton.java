package ie.tudublin;

import processing.data.Table;
import processing.data.TableRow;

public class ExtraButton extends SpaceObject
{
    private float width;
    private float height;
    private Table table;
    public ExtraButton(UI ui,float width, float height, Table table)
    {
        super(ui);
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
            ui.strokeWeight(1);
            ui.fill(0,100,0);
            ui.stroke(0,100,0);
            ui.rect(x, y, width, height);
            System.out.println(row.getColumnCount());  
            
        } 
    }
    public void startextrabuttons()
    {
        for(TableRow row:table.rows())
        {   
            int x = row.getInt("x");
            int y = row.getInt("y");
            ui.strokeWeight(1);
            ui.fill(0,ui.random(100),0);
            ui.stroke(0,100,0);
            ui.rect(x, y, width, height);
            System.out.println(row.getColumnCount());  
            
        } 
    }
}