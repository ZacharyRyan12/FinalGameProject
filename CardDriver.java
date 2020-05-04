import java.util.*;
import javax.swing.*;
import java.awt.*;
public class CardDriver
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int a = 0;
        DeckOfCards y = new DeckOfCards();
        JFrame frame = new JFrame();
        y.setPreferredSize(new Dimension(1000,600));
        frame.add(y);
        frame.pack();
        frame.setVisible(true);
        System.out.println("Would you like to play war? (1 = yes, 0 = no)");
        a = scan.nextInt();
        scan.nextLine();
        while (a==1)
        {
            y.shuffle();
            int pCards = 26;
            while (pCards>0 && pCards<52)
            {
                String str = "Draw a Card";
                y.setText(str);
                scan.nextLine();
                str += "\nYou drew: " + y.warDeal(1);
                y.setText(str);
                int p = y.getPrecedence();
                str += "\nThe computer drew: " + y.warDeal(1);
                y.setText(str);
                int c = y.getPrecedence();
                int warCount = 0;
                if (p>c)
                {
                    str += "\nYou win this round.";
                    y.setText(str);
                    pCards++;
                    y.setScore(pCards);
                }
                if (c>p)
                {
                    str += "\nYou lose this round.";
                    y.setText(str);
                    pCards--;
                    y.setScore(pCards);
                }
                while (p==c)
                {
                    warCount++;
                    str += "\nWar!\nDraw one card face down and one card face up.";
                    y.setText(str);
                    y.warDeal(1);
                    scan.nextLine();
                    str += "\nYou drew: " + y.warDeal(1);
                    y.setText(str);
                    p = y.getPrecedence();
                    y.warDeal(1);
                    str += "\nThe computer drew: " + y.warDeal(1);
                    y.setText(str);
                    c = y.getPrecedence();
                    if (p>c)
                    {
                        str += "\nYou won the war.";
                        y.setText(str);
                        pCards+=((2*warCount)+1);
                        if(pCards>52)
                        {
                            pCards = 52;
                        }
                    }
                    if (c>p)
                    {
                        str += "\nYou lost the war.";
                        y.setText(str);
                        pCards-=((2*warCount)+1);
                        if (pCards<0)
                        {
                            pCards = 0;
                        }
                    }
                }
                y.setScore(pCards);
                str += "\nContinue?";
                y.setText(str);
                scan.nextLine();
            }
            String s = "";
            if (pCards>51)
            {
                s += "You win!";
                y.setText(s);
            }
            else
            {
                s += "You lose.";
                y.setText(s);
            }
            s += "\nDo you want to play again?";
            y.setText(s);
            a = scan.nextInt();
            scan.nextLine();
        }
    }
}