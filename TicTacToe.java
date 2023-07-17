import java.awt.*;
import javax.swing.*;

public class TicTacToe extends JPanel
{
    JPanel sPanel = new JPanel();
    JPanel bPanel = new JPanel();
    JLabel title = new JLabel("Tic Tac Toe Game");
    JLabel player1 = new JLabel("PLAYER 1 : O");
    JLabel player2 = new JLabel("PLAYER 2 : X");
    JButton[][] buttons = new JButton[3][3];
    boolean turn = true;  boolean clicks = true;  int score = 0;
    String[] win1 = {"O", "O", "O"};  String[] win2 = {"X", "X", "X"};

    public TicTacToe()
    {
        setLayout(new BorderLayout());
        sPanel.setLayout(new BorderLayout());
        bPanel.setLayout(new GridLayout(3, 3));
        setBackground(Color.pink);  sPanel.setBackground(Color.PINK);
        title.setFont(new Font("Times New Roman", Font.BOLD, 50));
        player1.setFont(new Font("Arial", Font.BOLD, 40));
        player2.setFont(new Font("Atial", Font.BOLD, 40));
        
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
                    String[] top = {buttons[0][0].getText(), buttons[0][1].getText(), buttons[0][2].getText()};
                    String[] mid1 = {buttons[1][0].getText(), buttons[1][1].getText(), buttons[1][2].getText()};
                    String[] bottom = {buttons[2][0].getText(), buttons[2][1].getText(), buttons[2][2].getText()};
                    String[] left = {buttons[0][0].getText(), buttons[1][0].getText(), buttons[2][0].getText()};
                    String[] mid2 = {buttons[0][1].getText(), buttons[1][1].getText(), buttons[2][1].getText()};
                    String[] right = {buttons[0][2].getText(), buttons[1][2].getText(), buttons[2][2].getText()};
                    String[] cross1 = {buttons[0][0].getText(), buttons[1][1].getText(), buttons[2][2].getText()};
                    String[] cross2 = {buttons[0][2].getText(), buttons[1][1].getText(), buttons[2][0].getText()};
                    
                    if(turn){buttons[X][Y].setText("O");  turn = !turn;  buttons[X][Y].setEnabled(false);}
                    else{buttons[X][Y].setText("X");  turn = !turn;  buttons[X][Y].setEnabled(false);}
            });
        
        sPanel.add(player1, BorderLayout.WEST);  sPanel.add(player2, BorderLayout.EAST);
        
        add(title, BorderLayout.NORTH);  add(sPanel, BorderLayout.SOUTH);
        add(bPanel, BorderLayout.CENTER);
    }
}
}