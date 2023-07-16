import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class TicTacToe extends JPanel
{
    JPanel sPanel = new JPanel();  JPanel gPanel = new JPanel();
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
        player1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        player2.setFont(new Font("Times New Roman", Font.BOLD, 25));
        
        sPanel.add(player1);  sPanel.add(player2);
        
        add(title, BorderLayout.NORTH);  add(sPanel, BorderLayout.SOUTH);
        add(new gPanel(), BorderLayout.CENTER);
    }

    public class gPanel extends JPanel implements Icon
    {
        int w, h;
        int x, y;  boolean turn = true;
        
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            w = getWidth();  h = getHeight();
            g.drawLine(w/3, 0, w/3, h);
            g.drawLine(w * 2/3, 0, w * 2/3, h);
            g.drawLine(0, h/3, w, h/3);
            g.drawLine(0, h * 2/3, w, h * 2/3);
        }

        public gPanel()
        {
            setBackground(Color.ORANGE);
            setSize(500, 500);
            setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));

            addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e){
                    x = e.getX();  y = e.getY();
                    paintIcon(gPanel, getGraphics(), x, y);
                }
            });
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2d = (Graphics2D) g.create();
            if(turn && x <= h/3 && y <= h/3){
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(5, 5, w/3 , h/3);
                g2d.drawLine(5, h/3, w/3, 5);
                turn = !turn;
            }else{
                g2d.setColor(Color.BLUE);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawOval(5, 5, w/3 - 5, h/3 - 5);
                turn = !turn;
            }
            
            
        }

        @Override
        public int getIconWidth() {return getWidth();}

        @Override
        public int getIconHeight() {return getHeight();}
    }
}