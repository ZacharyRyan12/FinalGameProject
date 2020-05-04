import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
public class DeckOfCards extends JPanel
{
    private Card[] deck;
    private int position;
    private JTextArea scoreboard;
    private JTextArea text;
    private int score;
    private JButton draw;
    public DeckOfCards()
    {
        this.setBackground(new Color(43, 176, 97));
        this.setLayout(null);
        score = 26;
        ImageIcon img = new ImageIcon("warcardgame.png");
        img.setImage(img.getImage().getScaledInstance(800, 250, Image.SCALE_DEFAULT));
        JLabel pic = new JLabel(img);
        pic.setBounds(100, 0, 800, 250);
        add(pic);
        scoreboard = new JTextArea("Your Cards: " + score + " Computer's Cards: " + (52-score));
        scoreboard.setPreferredSize(new Dimension(204, 16));
        scoreboard.setAlignmentX(CENTER_ALIGNMENT);
        scoreboard.setBounds(398, 250, 204, 16);
        scoreboard.setBackground(new Color(43, 176, 97));
        add(scoreboard);
        text = new JTextArea("Would you like to play war?");
        text.setPreferredSize(new Dimension(400,100));
        text.setAlignmentX(CENTER_ALIGNMENT);
        text.setBounds(0,300,1000,300);
        text.setBackground(new Color(43, 176, 97));
        text.setEditable(false);
        add(text);
        draw = new JButton();
        //draw.addActionListener(new ListenerClass());
        draw.setPreferredSize(new Dimension(50,50));
        draw.setBounds(500, 300, 50, 50);
        this.add(draw);
        isFocusable();
        position = 0;
        deck = new Card[52];
        String[] values = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
        for (int i=0; i<13; i++)
        {
            for(int j=i; j<values.length; j++)
            {
                deck[i] = new Card("Hearts", values[j]);
                break;
            }
        }
        for (int i=13; i<26; i++)
        {
            for(int j=i-13; j<values.length; j++)
            {
                deck[i] = new Card("Diamonds", values[j]);
                break;
            }
        }
        for (int i=26; i<39; i++)
        {
            for(int j=i-26; j<values.length; j++)
            {
                deck[i] = new Card("Clubs", values[j]);
                break;
            }
        }
        for (int i=39; i<52; i++)
        {
            for(int j=i-39; j<values.length; j++)
            {
                deck[i] = new Card("Spades", values[j]);
                break;
            }
        }
    }

    public void shuffle()
    {
        for (int i=0; i<deck.length; i++)
        {
            Card temp = deck[i];
            int j = (int)(Math.random()*52);
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    public String deal(int inPosition)
    {
        String result = "";
        if (position+inPosition > 52)
        {
            result += "Not enough cards remain in the deck.";
            return result;
        }
        for (int i=position; i<inPosition+position; i++)
        {
            result += deck[i];
            result += "\n";
        }
        position = position + inPosition;
        return result;
    }

    public String warDeal(int inPosition)
    {
        String result = "";
        if (position+inPosition > 52)
        {
            position = 0;
        }
        for (int i=position; i<inPosition+position; i++)
        {
            result += deck[i];
            result += "\n";
        }
        position = position + inPosition;
        return result;
    }

    public int count()
    {
        int n = 52-position;
        return n;
    }

    public int getPrecedence()
    {
        int precedence = 0;
        String value = deck[position-1].getValue();;
        if (value.equals("2"))
        {
            precedence = 2;
        }
        if (value.equals("3"))
        {
            precedence = 3;
        }
        if (value.equals("4"))
        {
            precedence = 4;
        }
        if (value.equals("5"))
        {
            precedence = 5;
        }
        if (value.equals("6"))
        {
            precedence = 6;
        }
        if (value.equals("7"))
        {
            precedence = 7;
        }
        if (value.equals("8"))
        {
            precedence = 8;
        }
        if (value.equals("9"))
        {
            precedence = 9;
        }
        if (value.equals("10"))
        {
            precedence = 10;
        }
        if (value.equals("Jack"))
        {
            precedence = 11;
        }
        if (value.equals("Queen"))
        {
            precedence = 12;
        }
        if (value.equals("King"))
        {
            precedence = 13;
        }
        if (value.equals("Ace"))
        {
            precedence = 14;
        }
        return precedence;
    }

    public void setScore(int inScore)
    {
        score = inScore; 
        scoreboard.setText("Your Cards: " + score + " Computer's Cards: " + (52-score));
    }
    
    public void setText(String str)
    {
        text.setText(str);
    }
    
    public void paintComponent(Graphics g)
    {
        // calling overridden paintComponent method
        super.paintComponent(g);
        setFocusable(true);
        add(scoreboard);
        
        // for (int i=0; i<13; i++)
        // {
        // for(int j=i; j<13; j++)
        // {
        // deck[i].draw(g, 50, 80*j+20, 25, 40, 2, 2); 
        // break;
        // }
        // }
        // for (int i=13; i<26; i++)
        // {
        // for(int j=i-13; j<13; j++)
        // {
        // deck[i].draw(g, 150, 80*j, 25, 40, 2, 2); 
        // break;
        // }
        // }
        // for (int i=26; i<39; i++)
        // {
        // for(int j=i-26; j<13; j++)
        // {
        // deck[i].draw(g, 250, 80*j, 25, 40, 2, 2); 
        // break;
        // }
        // }
        // for (int i=39; i<52; i++)
        // {
        // for(int j=i-39; j<13; j++)
        // {
        // deck[i].draw(g, 350, 80*j, 25, 40, 2, 2); 
        // break;
        // }
        // }
        try 
        {
            Thread.sleep(25);
        }
        catch (Exception e)
        {
        }
        repaint(); // refreshes the screen
    }
    
    public class ListenerClass implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            
        }
    }
    
    public String toString()
    {
        String result = "";
        result += "Deck: \n";
        for (int i=position; i<deck.length; i++)
        {
            result += deck[i].toString();
            position++;
            result += "\n";
        }
        return result;
    }

}
