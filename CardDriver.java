import java.util.*;
import javax.swing.*;
import java.awt.*;
public class CardDriver
{
    public static void main(String[] args)
    {
        DeckOfCards y = new DeckOfCards();
        JFrame frame = new JFrame();
        y.setPreferredSize(new Dimension(1000,600));
        frame.add(y);
        frame.pack();
        frame.setVisible(true);
        int a = 1;
        while (a==1)
        {
            y.shuffle();
            int pCards = 26;
            while (y.getEnd()==false)
            {
                y.playRound();
            }

            String s = "";
            if (y.getScore()>51)
            {
                s += "You win!";
                y.setText(s);
            }
            else
            {
                s += "You lose.";
                y.setText(s);
            }
            //s += "\nDo you want to play again?";
            //y.setText(s);
            //a = scan.nextInt();
            //scan.nextLine();
            a = 0;
        }
    }
}