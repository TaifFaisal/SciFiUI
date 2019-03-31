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

    public void displayscreen()
    {
        ui.stroke(0);
        ui.fill(0);

        ui.rect(x , y , 150, 150);
    }
    public void displaywords()
    {
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.fill(0,255,0);

        PFont font = ui.createFont("Times New Roman", 12);
        
        for (int i = 0 ; i < words.length; i++) 
        {
            ui.textFont(font);
            ui.text(words[i], x+35, y+25);
        }
    }
}