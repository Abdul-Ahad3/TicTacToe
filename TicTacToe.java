import java.awt.*;
import javax.swing.*;

public class TicTacToe extends JPanel
{
    JPanel sPanel = new JPanel();
    JPanel bPanel = new JPanel();
    JLabel title = new JLabel("Tic Tac Toe Game");
    JLabel[][] scoreBoard = new JLabel[2][2];
    JButton[][] buttons = new JButton[3][3];
    boolean turn = true;  boolean clicks = true;

    public TicTacToe()
    {
        setLayout(new BorderLayout());
        sPanel.setLayout(new GridLayout(2, 2));
        bPanel.setLayout(new GridLayout(3, 3));
        setBackground(Color.pink);  sPanel.setBackground(Color.PINK);
        title.setFont(new Font("Times New Roman", Font.BOLD, 50));
        
        for(int x = 0; x < 3; x++)
            for(int y = 0; y < 3; y++)
            {
                final int X = x;
                final int Y =y;
                buttons[x][y] = new JButton();
                buttons[x][y].setBackground(Color.pink);
                buttons[x][y].setFont(new Font("Arial", Font.BOLD, 100));
                bPanel.add(buttons[x][y]);

                buttons[x][y].addActionListener(e -> {
                    if(turn){buttons[X][Y].setText("O");  turn = !turn;}
                    else{buttons[X][Y].setText("X");  turn = !turn;}
                });
            }
        
        for(int i = 0; i < 2; i++)
            for(int j = 0; j < 2; j++)
            {
                scoreBoard[i][j] = new JLabel();
                sPanel.add(scoreBoard[i][j]);
                scoreBoard[i][j].setBackground(Color.PINK);
                scoreBoard[i][j].setFont(new Font("Arial", Font.BOLD, 40));
            }
            
        scoreBoard[0][0].setText("PLAYER 1 : O");
        scoreBoard[0][1].setText("PLAYER 2 : X");
        scoreBoard[1][0].setText("0");
        scoreBoard[1][1].setText("0");
        
        add(title, BorderLayout.NORTH);  add(sPanel, BorderLayout.SOUTH);
        add(bPanel, BorderLayout.CENTER);
    }
}