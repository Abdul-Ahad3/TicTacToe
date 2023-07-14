import java.awt.*;
import javax.swing.*;

public class TicTacToe extends JPanel
{
    JPanel sPanel = new JPanel();
    JPanel gPanel = new JPanel();
    JLabel title = new JLabel("Tic Tac Toe Game");
    JLabel player1 = new JLabel("PLAYER 1 : O");
    JLabel player2 = new JLabel("PLAYER 1 : X");
    JLabel score1 = new JLabel("0");  JLabel score2 = new JLabel("0");

    @Override
    public void paintComponent(Graphics g)
    {
        System.out.println("Called");
        super.paintComponent(g);
        int w = getWidth(); int h = getHeight();
        g.drawLine(w/3, 60, w/3, h - 90);
        g.drawLine(w * 2/3, 60, w * 2/3, h - 90);
        g.drawLine(0, h/3, w, h/3);
        g.drawLine(0, h * 2/3, w, h * 2/3);
    }
    
    public TicTacToe()
    {
        setLayout(new BorderLayout());
        sPanel.setLayout(new GridLayout(2, 2));
        setBackground(Color.ORANGE);
        sPanel.setBackground(Color.ORANGE);
        title.setFont(new Font("Times New Roman", Font.BOLD, 50));
        player1.setFont(new Font("Times New Roman", Font.BOLD, 50));
        player2.setFont(new Font("Times New Roman", Font.BOLD, 50));
        score1.setFont(new Font("Arial", Font.BOLD, 40));
        score2.setFont(new Font("Arial", Font.BOLD, 40));
        gPanel.repaint();
        
        sPanel.add(player1);  sPanel.add(player2);
        sPanel.add(score1);  sPanel.add(score2);
        
        add(title, BorderLayout.NORTH);  add(sPanel, BorderLayout.SOUTH);
        //add(gPanel, BorderLayout.CENTER);
    }
}