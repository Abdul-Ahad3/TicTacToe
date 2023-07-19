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
    int topX=0, mid1X=0, bottomX=0, leftX=0, mid2X=0, rightX=0, cross1X=0, cross2X=0;
    int topO=0, mid1O=0, bottomO=0, leftO=0, mid2O=0, rightO=0, cross1O=0, cross2O=0;

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
                    if(turn){buttons[X][Y].setText("O");  turn = !turn;  buttons[X][Y].setEnabled(false);}
                    else{buttons[X][Y].setText("X");  turn = !turn;  buttons[X][Y].setEnabled(false);}
                    
                    if(buttons[0][0].getText() == "O"){topO++;  leftO++;  cross1O++;}
                    else if(buttons[0][1].getText() == "O"){topO++;  mid2O++;}
                    else if(buttons[0][2].getText() == "O"){topO++;  rightO++;  cross2O++;}
                    else if(buttons[1][0].getText() == "O"){mid1O++;  leftO++;}
                    else if(buttons[1][1].getText() == "O"){mid1O++;  mid2O++;  cross1O++;  cross2O++;}
                    else if(buttons[1][2].getText() == "O"){mid1O++;  rightO++;}
                    else if(buttons[2][0].getText() == "O"){leftO++;  bottomO++;  cross1O++;}
                    else if(buttons[2][1].getText() == "O"){mid2O++;  bottomO++;}
                    else if(buttons[2][2].getText() == "O"){rightO++;  bottomO++;  cross1O++;}

                    if(buttons[0][0].getText() == "X"){topX++;  leftX++;  cross1X++;}
                    else if(buttons[0][1].getText() == "X"){topX++;  mid2X++;}
                    else if(buttons[0][2].getText() == "X"){topX++;  rightX++;  cross2X++;}
                    else if(buttons[1][0].getText() == "X"){mid1X++;  leftX++;}
                    else if(buttons[1][1].getText() == "X"){mid1X++;  mid2X++;  cross1X++;  cross2X++;}
                    else if(buttons[1][2].getText() == "X"){mid1X++;  rightX++;}
                    else if(buttons[2][0].getText() == "X"){leftX++;  bottomX++;  cross1X++;}
                    else if(buttons[2][1].getText() == "X"){mid2X++;  bottomX++;}
                    else if(buttons[2][2].getText() == "X"){rightX++;  bottomX++;  cross1X++;}
            });
        
        sPanel.add(player1, BorderLayout.WEST);  sPanel.add(player2, BorderLayout.EAST);
        
        add(title, BorderLayout.NORTH);  add(sPanel, BorderLayout.SOUTH);
        add(bPanel, BorderLayout.CENTER);
    }
}
}