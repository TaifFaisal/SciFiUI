package ie.tudublin;

public class Graph extends SpaceObject
{
    float[] Temperature = new float[9];
    public Graph(UI ui)
    {
        super(ui);
    }
    
    public void graphrect()
    {
        ui.fill(0);
        ui.noStroke();
        ui.rect(620,610,150,130);
    }

    public void drawgraph()
    {
        
        float h = (ui.width / (float) Temperature.length)/8;
        int j = 5;
        float value=600;
        for(int i = 0 ; i < Temperature.length ; i ++) 
        {
            ui.noStroke();
            ui.fill(255);
            value = 621 +i * h;
            ui.rect(value +j, ui.map(i, 0, Temperature.length, ui.height-11, ui.height-11), h, -Temperature[i]/4);
            j += 5;
        }
    }
    public void update()
    {
        for(int i = 0; i<Temperature.length;i++)
        {
            Temperature[i] += 1;
            if(Temperature[i] > 330)
            {
                Temperature[i] = ui.random(0, 330);
            }
        }

    }
}