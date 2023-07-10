import java.awt.*;
import javax.swing.*;

public class TicTacToe extends JPanel
{
    JPanel sPanel = new JPanel();
    JPanel bPanel = new JPanel();
    JLabel title = new JLabel("Tic Tac Toe Game");
    JLabel score1 = new JLabel("0");  JLabel score2 = new JLabel("0");
    JButton[][] buttons = new JButton[3][3];

    public TicTacToe()
    {
        setLayout(new BorderLayout());
        sPanel.setLayout(new GridLayout(2, 2));
        bPanel.setLayout(new GridLayout(3, 3));
        title.setFont(new Font("Times New Roman", Font.BOLD, 50));

        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                buttons[i][j] = new JButton();
        
        sPanel.add(new JLabel("PLAYER 1 : O"));
        sPanel.add(new JLabel("PLAYER 2 : X"));
        sPanel.add(score1);  sPanel.add(score2);
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                bPanel.add(buttons[i][j]);

        add(title, BorderLayout.NORTH);  add(sPanel, BorderLayout.SOUTH);
        add(bPanel, BorderLayout.CENTER);
    }
}