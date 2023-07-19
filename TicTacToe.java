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
                    
                    //Checks for text on buttons
                    if (buttons[X][0].getText().equals("O")) {topO++;  leftO++;  cross1O++;} 
                    else if (buttons[X][0].getText().equals("X")) {topX++;  leftX++;  cross1X++;}

                    if (buttons[X][1].getText().equals("O")) {mid1O++;  leftO++;  cross1O++;} 
                    else if (buttons[X][1].getText().equals("X")) {mid1X++;  leftX++;  cross1X++;}

                    if (buttons[X][2].getText().equals("O")) {bottomO++;  leftO++;  cross2O++;} 
                    else if (buttons[X][2].getText().equals("X")) {bottomX++;  leftX++;  cross2X++;}

                    if (buttons[0][Y].getText().equals("O")) {topO++;  leftO++;  cross1O++;} 
                    else if (buttons[0][Y].getText().equals("X")) {topX++;  leftX++;  cross1X++;}

                    if (buttons[1][Y].getText().equals("O")) {topO++;  leftO++;  cross1O++;} 
                    else if (buttons[1][Y].getText().equals("X")) {topX++;  leftX++;  cross1X++;}

                    if (buttons[2][Y].getText().equals("O")) {topO++;  leftO++;  cross1O++;} 
                    else if (buttons[2][Y].getText().equals("X")) {topX++;  leftX++;  cross1X++;}

                    if (buttons[X][0].getText().equals("O")) {topO++;  leftO++;  cross1O++;} 
                    else if (buttons[X][0].getText().equals("X")) {topX++;  leftX++;  cross1X++;}

                    if (buttons[X][0].getText().equals("O")) {topO++;  leftO++;  cross1O++;} 
                    else if (buttons[X][0].getText().equals("X")) {topX++;  leftX++;  cross1X++;}

                    if(topX == 3 || mid1X == 3 || bottomX == 3 || leftX == 3 || mid2X == 3 || rightX ==3 || cross1X == 3 || cross2X == 3){
                        JOptionPane.showMessageDialog(null, "Player 2 wins");
                        revalidate();  repaint();
                        topX=0; mid1X=0; bottomX=0; leftX=0; mid2X=0; rightX=0; cross1X=0; cross2X=0;
                        topO=0; mid1O=0; bottomO=0; leftO=0; mid2O=0; rightO=0; cross1O=0; cross2O=0;
                    }else if(topO == 3 || mid1O == 3 || bottomO == 3 || leftO == 3 || mid2O == 3 || rightO ==3 || cross1O == 3 || cross2O == 3){
                        JOptionPane.showMessageDialog(null, "Player 1 wins");
                        revalidate();  repaint();
                        topX=0; mid1X=0; bottomX=0; leftX=0; mid2X=0; rightX=0; cross1X=0; cross2X=0;
                        topO=0; mid1O=0; bottomO=0; leftO=0; mid2O=0; rightO=0; cross1O=0; cross2O=0;
                    }else if (topX + mid1X + bottomX + leftX + mid2X + rightX + cross1X + cross2X + topO + mid1O + bottomO + leftO + mid2O + rightO + cross1O + cross2O == 24) {
                        JOptionPane.showMessageDialog(null, "It's a tie!");
                        revalidate();  repaint();
                        topX=0; mid1X=0; bottomX=0; leftX=0; mid2X=0; rightX=0; cross1X=0; cross2X=0;
                        topO=0; mid1O=0; bottomO=0; leftO=0; mid2O=0; rightO=0; cross1O=0; cross2O=0;
                    }
            });
        
        sPanel.add(player1, BorderLayout.WEST);  sPanel.add(player2, BorderLayout.EAST);
        
        add(title, BorderLayout.NORTH);  add(sPanel, BorderLayout.SOUTH);
        add(bPanel, BorderLayout.CENTER);
    }
}
}