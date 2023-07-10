import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class TicTacToe extends JPanel
{
    JPanel sPanel = new JPanel();
    JPanel bPanel = new JPanel();
    JLabel title = new JLabel("Tic Tac Toe Game");
    JLabel[][] scoreBoard = new JLabel[2][2];
    JButton[][] buttons = new JButton[3][3];

    public TicTacToe()
    {
        setLayout(new BorderLayout());
        sPanel.setLayout(new GridLayout(2, 2));
        bPanel.setLayout(new GridLayout(3, 3));
        setBackground(Color.pink);  sPanel.setBackground(Color.PINK);

        title.setFont(new Font("Times New Roman", Font.BOLD, 50));
        
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++){
                buttons[i][j] = new JButton();
                buttons[i][j].setBackground(Color.pink);
            }
        
        for(int i = 0; i < 2; i++)
            for(int j = 0; j < 2; j++){
                scoreBoard[i][j] = new JLabel();
                sPanel.add(scoreBoard[i][j]);
                scoreBoard[i][j].setBackground(Color.PINK);
                scoreBoard[i][j].setFont(new Font("Arial", Font.BOLD, 40));
            }
        
        scoreBoard[0][0].setText("PLAYER 1 : O");
        scoreBoard[0][1].setText("PLAYER 2 : X");
        scoreBoard[1][0].setText("0");
        scoreBoard[1][1].setText("0");
        
        
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                bPanel.add(buttons[i][j]);

        add(title, BorderLayout.NORTH);  add(sPanel, BorderLayout.SOUTH);
        add(bPanel, BorderLayout.CENTER);
    }
}