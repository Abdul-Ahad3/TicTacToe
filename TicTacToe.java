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

    public TicTacToe()
    {
        setLayout(new BorderLayout());
        sPanel.setLayout(new BorderLayout());
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
                    if(turn){buttons[X][Y].setText("O");  turn = !turn;  buttons[X][Y].setEnabled(false);}
                    else{buttons[X][Y].setText("X");  turn = !turn;  buttons[X][Y].setEnabled(false);}
            });
        
        sPanel.add(player1, BorderLayout.WEST);  sPanel.add(player2, BorderLayout.EAST);
        
        add(title, BorderLayout.NORTH);  add(sPanel, BorderLayout.SOUTH);
        add(bPanel, BorderLayout.CENTER);
    }
}
}