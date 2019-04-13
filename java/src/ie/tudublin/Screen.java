package ie.tudublin;

import processing.core.PApplet;
import processing.core.PFont;

public class Screen extends SpaceObject
{
    private float x;
    private float y;
    // String[] words = ui.loadStrings("screen.txt");
    String[] words;
    public Screen(UI ui, String[] words, float x, float y)
    {
        super(ui);
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
    public void instructions()
    {
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.fill(0,255,0);

        PFont font = ui.createFont("Times New Roman", 10);
        ui.textFont(font);
        ui.text("To collect points: \n \n", x+40, y+75);
        ui.text("1.Point the mouse to the target \n ", x+70, y+95);
        ui.text("2.Click the mouse ", x+45, y+105);
        ui.text("White = 4\t \t\t\t Pink = 2", x+70, y+128);

    }
}