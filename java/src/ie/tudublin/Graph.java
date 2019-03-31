package ie.tudublin;


import processing.core.PApplet;
import processing.core.PFont;
import processing.data.Table;
import processing.data.TableRow;

public class Graph
{
    PApplet ui;
    private float x;
    private float y;
    Table table;

    public Graph(PApplet ui, float x, float y, Table table)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.table = table;
    }

    public void drawgraph()
    {
        ui.fill(0);
        ui.noStroke();
        ui.rect(x, y, 150, 140);
        for(int i = 0 ; i < table.getRowCount() ; i ++)
        {
            TableRow row = table.getRow(i);
            System.out.println(row.getString("Planet"));
            System.out.println(row.getString("Temperature"));            
        }
    }
}