package ie.tudublin;

import processing.core.PApplet;
import processing.core.PFont;

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
    public void redbutton()
    {
        ui.fill(255,0,0);
        ui.stroke(255,0,0);
        ui.rect(x, y, width, height);
        ui.fill(0);
        PFont font = ui.createFont("Times New Roman", 11);
        ui.textFont(font);
        ui.text(text, x+10, y - 10);
    }
    public void greenbutton()
    {
        ui.fill(0,255,0);
        ui.stroke(0,255,0);
        ui.rect(x, y, width, height);
        //ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.fill(0);
        PFont font = ui.createFont("Times New Roman", 11);
        ui.textFont(font);
        ui.text(text, x+10, y - 10);

    }

   
}