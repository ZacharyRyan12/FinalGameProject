import java.awt.*;
import javax.swing.*;
public class Card extends Component
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

    // public void paint(Graphics g, Image img)
    // {
        // g.drawImage(img, 150, 350, this);
    // }

    public String toString()
    {
        String result = "";
        result += value + " of " + suit;
        return result;
    }
}