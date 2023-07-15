import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class TicTacToe extends JPanel
{
    JPanel sPanel = new JPanel();
    JPanel gPanel = new JPanel();
    JLabel title = new JLabel("Tic Tac Toe");
    JLabel player1 = new JLabel("PLAYER 1 : O");
    JLabel player2 = new JLabel("PLAYER 1 : X");
    JLabel B;  
    boolean turn = true;
    
    String[][] Board = {{"  ", " |", " ", " |", " "}, 
                        {"--", "--", "--", "--", "--"}, 
                        {"  ", " |", " ", " |", " "}, 
                        {"--", "--", "--", "--", "--"}, 
                        {"  ", " |", " ", " |", " "}};
    
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
        {
            for(int y = 0; y < 5; y++)
            {
                B = new JLabel(Board[x][y]);
                B.setFont(new Font("Arial", Font.BOLD, 70));
                gPanel.add(B);

                B.addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e){
                        for(int i = 0; i <= 4; i++){
                            for(int j = 0; j <= 4; j++){
                                JLabel l = (JLabel) e.getSource();
                                if(turn && l.getText() == " "){l.setText("O");  turn = !turn;}
                                else if(!turn && l.getText() == " "){l.setText("X"); turn = !turn;}
                            }
                        }
                    }
                
                });
            }
        }
        
        sPanel.add(player1);  sPanel.add(player2);
        
        add(title, BorderLayout.NORTH);  add(sPanel, BorderLayout.SOUTH);
        add(gPanel, BorderLayout.CENTER);
    }

    public class Adapter extends MouseAdapter
    {
        
    }
}