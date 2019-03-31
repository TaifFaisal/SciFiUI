package ie.tudublin;

import processing.core.PApplet;
import processing.core.PFont;

public class Screen
{
    PApplet ui;
    private float x;
    private float y;
    // String[] words = ui.loadStrings("screen.txt");
    String[] words;
    public Screen(PApplet ui, String[] words, float x, float y)
    {
        this.ui = ui;
        this.words = words;
        this.x = x;
        this.y = y;
    }

   
}