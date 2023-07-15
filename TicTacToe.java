import java.awt.*;
import javax.swing.*;

public class TicTacToe extends JPanel
{
    JPanel sPanel = new JPanel();
    JPanel gPanel = new JPanel();
    JLabel title = new JLabel("Tic Tac Toe Game");
    JLabel player1 = new JLabel("PLAYER 1 : O");
    JLabel player2 = new JLabel("PLAYER 2 : X");

    
    
    public TicTacToe()
    {
        setLayout(new BorderLayout());
        sPanel.setLayout(new GridLayout(2, 2));
        setBackground(Color.ORANGE);
        sPanel.setBackground(Color.ORANGE);
        title.setFont(new Font("Times New Roman", Font.BOLD, 50));
        player1.setFont(new Font("Times New Roman", Font.BOLD, 50));
        player2.setFont(new Font("Times New Roman", Font.BOLD, 50));
        
        sPanel.add(player1);  sPanel.add(player2);
        
        add(title, BorderLayout.NORTH);  add(sPanel, BorderLayout.SOUTH);
        add(new gPanel(), BorderLayout.CENTER);
    }

    public class gPanel extends JPanel
    {
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            int w = getWidth(); int h = getHeight();
            g.drawLine(w/3, 0, w/3, h);
            g.drawLine(w * 2/3, 0, w * 2/3, h);
            g.drawLine(0, h/3, w, h/3);
            g.drawLine(0, h * 2/3, w, h * 2/3);
        }

        public gPanel()
        {
            setBackground(Color.ORANGE);
            setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
        }
    }
}