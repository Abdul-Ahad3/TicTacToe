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
                    if(turn){buttons[X][Y].setText("O");  turn = !turn;}
                    else{buttons[X][Y].setText("X");  turn = !turn;}
                    
                    //Win condition
                    //top
                    if(buttons[0][0].getText() == "O" && buttons[0][1].getText() == "O" && buttons[0][2].getText() == "O")
                    {JOptionPane.showMessageDialog(null, "Player 1 wins");  clear();}
                    else if(buttons[0][0].getText() == "X" && buttons[0][1].getText() == "X" && buttons[0][2].getText() == "X")
                    {JOptionPane.showMessageDialog(null, "Player 2 wins");  clear();}

                    //horizontal mid
                    if(buttons[1][0].getText() == "O" && buttons[1][1].getText() == "O" && buttons[1][2].getText() == "O")
                    {JOptionPane.showMessageDialog(null, "Player 1 wins");  clear();}
                    else if(buttons[1][0].getText() == "X" && buttons[1][1].getText() == "X" && buttons[1][2].getText() == "X")
                    {JOptionPane.showMessageDialog(null, "Player 2 wins");  clear();}

                    //bottom
                    if(buttons[2][0].getText() == "O" && buttons[2][1].getText() == "O" && buttons[2][2].getText() == "O")
                    {JOptionPane.showMessageDialog(null, "Player 1 wins");  clear();}
                    else if(buttons[2][0].getText() == "X" && buttons[2][1].getText() == "X" && buttons[2][2].getText() == "X")
                    {JOptionPane.showMessageDialog(null, "Player 2 wins");  clear();}

                    //left
                    if(buttons[0][0].getText() == "O" && buttons[1][0].getText() == "O" && buttons[2][0].getText() == "O")
                    {JOptionPane.showMessageDialog(null, "Player 1 wins");  clear();}
                    else if(buttons[0][0].getText() == "X" && buttons[1][0].getText() == "X" && buttons[2][0].getText() == "X")
                    {JOptionPane.showMessageDialog(null, "Player 2 wins");  clear();}

                    //vertical mid
                    if(buttons[0][1].getText() == "O" && buttons[1][1].getText() == "O" && buttons[2][1].getText() == "O")
                    {JOptionPane.showMessageDialog(null, "Player 1 wins");  clear();}
                    else if(buttons[0][1].getText() == "X" && buttons[1][1].getText() == "X" && buttons[2][1].getText() == "X")
                    {JOptionPane.showMessageDialog(null, "Player 2 wins");  clear();}

                    //right
                    if(buttons[0][2].getText() == "O" && buttons[1][2].getText() == "O" && buttons[2][2].getText() == "O")
                    {JOptionPane.showMessageDialog(null, "Player 1 wins");  clear();}
                    else if(buttons[0][2].getText() == "X" && buttons[1][2].getText() == "X" && buttons[2][2].getText() == "X")
                    {JOptionPane.showMessageDialog(null, "Player 2 wins");  clear();}

                    //diagonal-1
                    if(buttons[0][0].getText() == "O" && buttons[1][1].getText() == "O" && buttons[2][2].getText() == "O")
                    {JOptionPane.showMessageDialog(null, "Player 1 wins");  clear();}
                    else if(buttons[0][0].getText() == "X" && buttons[1][1].getText() == "X" && buttons[2][2].getText() == "X")
                    {JOptionPane.showMessageDialog(null, "Player 2 wins");  clear();}

                    //diagonal-2
                    if(buttons[0][2].getText() == "O" && buttons[1][1].getText() == "O" && buttons[2][0].getText() == "O")
                    {JOptionPane.showMessageDialog(null, "Player 1 wins");  clear();}
                    else if(buttons[0][2].getText() == "X" && buttons[1][1].getText() == "X" && buttons[2][0].getText() == "X")
                    {JOptionPane.showMessageDialog(null, "Player 2 wins");  clear();}
                });
            }
        
        sPanel.add(player1, BorderLayout.WEST);  sPanel.add(player2, BorderLayout.EAST);
        
        add(title, BorderLayout.NORTH);  add(sPanel, BorderLayout.SOUTH);
        add(bPanel, BorderLayout.CENTER);
    }

    //Method to clear the text on Buttons
    public void clear(){
        for(int x = 0; x < 3; x++)
            for(int y = 0; y < 3; y++){
                buttons[x][y].setText("");
            }
    }
}