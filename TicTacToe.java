import java.awt.*;
import javax.swing.*;

public class TicTacToe extends JPanel
{
    JPanel sPanel = new JPanel();
    JPanel gPanel = new JPanel();
    JLabel title = new JLabel("Tic Tac Toe");
    JLabel player1 = new JLabel("PLAYER 1 : O");
    JLabel player2 = new JLabel("PLAYER 1 : X");
    
    String[][] Board = {{"  ", "|", " ", "|", " "}, 
                        {"--", "--", "--", "--", "--"}, 
                        {"  ", "|", " ", "|", " "}, 
                        {"--", "--", "--", "--", "--"}, 
                        {"  ", "|", " ", "|", " "}};
    
    public TicTacToe()
    {
        setLayout(new BorderLayout());
        sPanel.setLayout(new GridLayout(2, 2));
        gPanel.setLayout(new GridLayout(5, 5));
        setBackground(Color.ORANGE);
        sPanel.setBackground(Color.ORANGE);
        title.setFont(new Font("Times New Roman", Font.BOLD, 50));
        player1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        player2.setFont(new Font("Times New Roman", Font.BOLD, 30));
       
        for(int x = 0; x <=4; x++)
        {
            for(int y = 0; y <= 4; y++)
            {
                JLabel B = new JLabel(Board[x][y]);
                B.setFont(new Font("Arial", Font.BOLD, 70));
                gPanel.add(B);
            }
        }
        
        sPanel.add(player1);  sPanel.add(player2);
        
        add(title, BorderLayout.NORTH);  add(sPanel, BorderLayout.SOUTH);
        add(gPanel, BorderLayout.CENTER);
    }
}