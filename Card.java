import java.awt.*;
import javax.swing.*;
public class Card
{
    private String suit;
    private String value;

    public Card(String inSuit, String inValue)
    {
        suit = inSuit;
        value = inValue;
    }

    public String getValue()
    {
        return value;
    }

    public void draw(Graphics g, int x, int y, int width, int height, int arcWidth, int arcHeight)
    {
        g.setColor(new Color(255,255,255));
        g.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
    }

    public String toString()
    {
        String result = "";
        result += value + " of " + suit;
        return result;
    }
}