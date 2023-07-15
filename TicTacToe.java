import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.Arrays;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class TicTacToe extends JPanel
{
    JPanel sPanel = new JPanel();
    JPanel gPanel = new JPanel();
    JLabel title = new JLabel("Tic Tac Toe");
    JLabel player1 = new JLabel("PLAYER 1 : O");
    JLabel player2 = new JLabel("PLAYER 2 : X");
    JLabel B;  boolean turn = true;
    String[] winner1 = {"O", "O", "O"};
    String[] winner2 = {"X", "X", "X"};
    JLabel[][] Board = new JLabel[5][5];

    /*String[][] Board = {{" ", " |", " ", " |", " "}, 
                        {"--", "--", "--", "--", "--"}, 
                        {" ", " |", " ", " |", " "}, 
                        {"--", "--", "--", "--", "--"}, 
                        {" ", " |", " ", " |", " "}};*/
    
    public TicTacToe()
    {
        setLayout(new BorderLayout());
        sPanel.setLayout(new GridLayout(2, 2));
        gPanel.setLayout(new GridLayout(5, 5));
        setBackground(Color.ORANGE);
        sPanel.setBackground(Color.ORANGE);
        title.setFont(new Font("Times New Roman", Font.BOLD, 50));
        player1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        player2.setFont(new Font("Times New Roman", Font.BOLD, 30));

        
       
        for(int x = 0; x < 5; x++)
            for(int y = 0; y < 5; y++)
            {
                final int X = x;  final int Y = y;
                
                if (x == 1 || x == 3) {Board[x][y] = new JLabel("--");} 
                else if (y == 1 || y == 3) {Board[x][y] = new JLabel(" |");} 
                else {Board[x][y] = new JLabel(" ");}
                Board[x][y].setFont(new Font("Arial", Font.BOLD, 40));
                gPanel.add(Board[x][y]);

                Board[x][y].addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e){
                       

                        if(turn && Board[X][Y].getText().equals(" ") ){Board[X][Y].setText("O");  turn = !turn;}
                        else if(!turn && Board[X][Y].getText().equals(" ")){Board[X][Y].setText("X"); turn = !turn;}

                         String[] top = {Board[0][0].getText(), Board[0][2].getText(), Board[0][4].getText()};
                        String[] midH = {Board[2][0].getText(), Board[2][2].getText(), Board[2][4].getText()};
                        String[] bottom = {Board[4][0].getText(), Board[4][2].getText(), Board[4][4].getText()};
                        String[] left = {Board[0][0].getText(), Board[2][0].getText(), Board[4][0].getText()};
                        String[] midV = {Board[0][2].getText(), Board[2][2].getText(), Board[4][2].getText()};
                        String[] right = {Board[0][4].getText(), Board[2][4].getText(), Board[4][4].getText()};
                        String[] dia1 = {Board[0][0].getText(), Board[2][2].getText(), Board[4][4].getText()};
                        String[] dia2 = {Board[0][4].getText(), Board[2][2].getText(), Board[4][0].getText()};
                        
                        if(Arrays.equals(top, winner1) || Arrays.equals(midH, winner1) || Arrays.equals(bottom, winner1) || Arrays.equals(left, winner1) || Arrays.equals(midV, winner1) || Arrays.equals(right, winner1) || Arrays.equals(dia1, winner1) || Arrays.equals(dia2, winner1))
                        {JOptionPane.showMessageDialog(null, "Player 1 has Won! Congradulations 🎉🎉");}
                        else if(Arrays.equals(top, winner2) || Arrays.equals(midH, winner2) || Arrays.equals(bottom, winner2) || Arrays.equals(left, winner2) || Arrays.equals(midV, winner2) || Arrays.equals(right, winner2) || Arrays.equals(dia1, winner2) || Arrays.equals(dia2, winner2))
                        {JOptionPane.showMessageDialog(null, "Player 2 has Won! Congradulations 🎉🎉");}
                        else
                        {
                            int fill = 0;
                            for (int x = 0; x < 5; x++) {
                                for (int y = 0; y < 5; y++) {
                                    if (!Board[x][y].getText().equals(" ")) {
                                        fill++;
                                    }
                                }
                            }
                            if (fill == 25) {
                                JOptionPane.showMessageDialog(null, "It's a DRAW!");
                            }
                        }
                    }
                
                });
            }
        
        
        sPanel.add(player1);  sPanel.add(player2);
        
        add(title, BorderLayout.NORTH);  add(sPanel, BorderLayout.SOUTH);
        add(gPanel, BorderLayout.CENTER);
    }
}