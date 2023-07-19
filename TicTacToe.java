import java.awt.*;
import java.util.Arrays;

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
        player2.setFont(new Font("Arial", Font.BOLD, 40));
        
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
                    int topX=0, mid1X=0, bottomX=0, leftX=0, mid2X=0, rightX=0, cross1X=0, cross2X=0;
                    int topO=0, mid1O=0, bottomO=0, leftO=0, mid2O=0, rightO=0, cross1O=0, cross2O=0;
                    if(buttons[0][0].getText() == "O"){topO++;  leftO++;  cross1O++;}
                    else if(buttons[0][0].getText() == "O"){topO++;  leftO++;  cross1O++;}
                    else if(buttons[0][0].getText() == "O"){topO++;  leftO++;  cross1O++;}
                    else if(buttons[0][0].getText() == "O"){topO++;  leftO++;  cross1O++;}
                    else if(buttons[0][0].getText() == "O"){topO++;  leftO++;  cross1O++;}
                    else if(buttons[0][0].getText() == "O"){topO++;  leftO++;  cross1O++;}
                    else if(buttons[0][0].getText() == "O"){topO++;  leftO++;  cross1O++;}
                    else if(buttons[0][0].getText() == "O"){topO++;  leftO++;  cross1O++;}
                    
                    if(turn){buttons[X][Y].setText("O");  turn = !turn;  buttons[X][Y].setEnabled(false);}
                    else{buttons[X][Y].setText("X");  turn = !turn;  buttons[X][Y].setEnabled(false);}

                    
            });
        
        sPanel.add(player1, BorderLayout.WEST);  sPanel.add(player2, BorderLayout.EAST);
        
        add(title, BorderLayout.NORTH);  add(sPanel, BorderLayout.SOUTH);
        add(bPanel, BorderLayout.CENTER);
    }
}
}