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

   
}