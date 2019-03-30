package ie.tudublin;

import processing.core.PApplet;

public class Button
{
    PApplet ui;
    private float x;
    private float y;
    private float width;
    private float height;
    private String text;

    public Button(PApplet ui, float x, float y, float width, float height, String text)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }
    public void buttons()
    {
        ui.noFill();
        ui.stroke(255);
        ui.rect(x, y, width, height);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.fill(255);
        ui.text(text, x + 50, y + 15);
    }

   
}