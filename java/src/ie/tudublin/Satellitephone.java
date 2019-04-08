package ie.tudublin;


public class Satellitephone extends SpaceObject
{
    private float x;
    private float y;


    public Satellitephone(UI ui,float x, float y)
    {
        super(ui);
        this.x = x;
        this.y = y;
    }
    public void rect()
    {
        ui.strokeWeight(3);
        ui.fill(0);
        // ui.stroke(192,192,192);
        ui.stroke(211,211,211);
        ui.rect(x, y, 110, 50);
        ui.strokeWeight(1);
        ui.stroke(0,128,0); 
    }
  
    
}