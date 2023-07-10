import java.awt.*;
import javax.swing.*;

public class TicTacToe extends JPanel
{
    JPanel sPanel = new JPanel();
    JPanel bPanel = new JPanel();
    JLabel title = new JLabel("Tic Tac Toe Game");
    JLabel player1 = new JLabel("PLAYER 1 : O");
    JLabel player2 = new JLabel("PLAYER 1 : X");
    JLabel score1 = new JLabel("0");  JLabel score2 = new JLabel("0");
    
    public TicTacToe()
    {
        setLayout(new BorderLayout());
        sPanel.setLayout(new GridLayout(2, 2));
        bPanel.setLayout(new GridLayout(3, 3));
        setBackground(Color.ORANGE);
        sPanel.setBackground(Color.ORANGE);
        title.setFont(new Font("Times New Roman", Font.BOLD, 50));
        player1.setFont(new Font("Times New Roman", Font.BOLD, 50));
        player2.setFont(new Font("Times New Roman", Font.BOLD, 50));
        score1.setFont(new Font("Arial", Font.BOLD, 40));
        score2.setFont(new Font("Arial", Font.BOLD, 40));

       
        
        sPanel.add(player1);  sPanel.add(player2);
        sPanel.add(score1);  sPanel.add(score2);
        
        add(title, BorderLayout.NORTH);  add(sPanel, BorderLayout.SOUTH);
        add(bPanel, BorderLayout.CENTER);
    }
}