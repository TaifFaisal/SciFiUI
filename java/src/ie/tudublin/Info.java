package ie.tudublin;

import processing.core.PApplet;

public class Info
{
    PApplet ui;
    private float x;
    private float y;
    private float width;
    private float height;


    public Info(PApplet ui, float x, float y, float width, float height)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


   
}