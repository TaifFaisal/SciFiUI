package ie.tudublin;



public class Fire extends SpaceObject
{

    public Fire(UI ui)
    {
        super(ui);
    }
    
    public void mouse()
    {
        ui.stroke(255);
        ui.strokeWeight(3);
        ui.noFill();
        ui.ellipse(ui.mouseX, ui.mouseY, 50, 50);
    }


    // public void bullets()
    // {
        
    // }

   
}