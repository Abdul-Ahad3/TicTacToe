import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

    //gPanel for the game board
    public class gPanel extends JPanel implements Icon
    {
        int w, h;
        int x, y;  boolean turn = true;
        
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            w = getWidth();  h = getHeight();
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(5));
            g2d.drawLine(w/3, 0, w/3, h);
            g2d.drawLine(w * 2/3, 0, w * 2/3, h);
            g2d.drawLine(0, h/3, w, h/3);
            g2d.drawLine(0, h * 2/3, w, h * 2/3);
        }

        public gPanel()
        {
            setBackground(Color.ORANGE);
            setSize(500, 500);
            setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));

            addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e){
                    x = e.getX();  y = e.getY();
                    paintIcon(gPanel, getGraphics(), x, y);
                }
            });
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            boolean b1 = x <= w/3 && y <= h/3;
            boolean b2 = x >= w/3 && x <= 2*w/3 && y <= h/3;
            boolean b3 = x >= 2*w/3 && y <= h/3;
            boolean b4 = x <= w/3 && y >= h/3 && y <= 2*h/3;
            boolean b5 = x >= w/3 && x <= 2*w/3 && y >= h/3 && y <= 2*h/3;
            boolean b6 = x >= 2*w/3 && y >= h/3 && y <= 2*h/3;
            boolean b7 = x <= w/3 && y >= 2*h/3;
            boolean b8 = x >= w/3 && x <= 2*w/3 && y >= 2*h/3;
            boolean b9 = x >= 2*w/3 && y >= 2*h/3;
            
            Graphics2D g2d = (Graphics2D) g.create();
            if(turn && b1){
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(8, 8, w/3 - 8 , h/3 - 8);
                g2d.drawLine(8, h/3 - 8, w/3 - 8, 8);
                turn = !turn;
            }else if(!turn && b1){
                g2d.setColor(Color.BLUE);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawOval(5, 5, w/3 - 8, h/3 - 8);
                turn = !turn;
            }
            
            if(turn && b2){
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(w/3 + 8, 8, 2*w/3 - 8 , h/3 - 8);
                g2d.drawLine(w/3 + 8, h/3 - 8, 2*w/3 - 8, 8);
                turn = !turn;
            }else if(!turn && b2){
                g2d.setColor(Color.BLUE);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawOval(w/3 + 5, 5, w/3 - 8, h/3 - 8);
                turn = !turn;
            }

            if(turn && b3){
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(2*w/3 + 8, 8, w - 8 , h/3 - 8);
                g2d.drawLine(2*w/3 + 8, h/3 - 8, w - 8, 8);
                turn = !turn;
            }else if(!turn && b3){
                g2d.setColor(Color.BLUE);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawOval(2*w/3 + 5, 5, w/3 - 8, h/3 - 8);
                turn = !turn;
            }

            if(turn && b4){
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(8, h/3 + 8, w/3 - 8 , 2*h/3 - 8);
                g2d.drawLine(8, 2*h/3 - 8, w/3 - 8, h/3 + 8);
                turn = !turn;
            }else if(!turn && b4){
                g2d.setColor(Color.BLUE);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawOval(5, h/3 + 5, w/3 - 8, h/3 - 8);
                turn = !turn;
            }

            if(turn && b5){
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(w/3 + 8, h/3 + 8, 2*w/3 - 8 , 2*h/3 - 8);
                g2d.drawLine(w/3 + 8, 2*h/3 - 8, 2*w/3 - 8, h/3 + 8);
                turn = !turn;
            }else if(!turn && b5){
                g2d.setColor(Color.BLUE);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawOval(w/3 + 5, h/3 + 5, w/3 - 8, h/3 - 8);
                turn = !turn;
            }

            if(turn && b6){
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(2*w/3 + 8, h/3 + 8, w - 8 , 2*h/3 - 8);
                g2d.drawLine(w - 8, h/3 + 8, 2*w/3 + 8, 2*h/3 - 8);
                turn = !turn;
            }else if(!turn && b6){
                g2d.setColor(Color.BLUE);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawOval(2*w/3 + 5, h/3 + 5, w/3 - 8, h/3 - 8);
                turn = !turn;
            }

            if(turn && b7){
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(8, 2*h/3 + 8, w/3 - 8 , h - 8);
                g2d.drawLine(8, h - 8, w/3 - 8, 2*h/3 + 8);
                turn = !turn;
            }else if(!turn && b7){
                g2d.setColor(Color.BLUE);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawOval(5, 2*h/3 + 5, w/3 - 8, h/3 - 8);
                turn = !turn;
            }

            if(turn && b8){
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(w/3 + 8, 2*h/3 + 8, 2*w/3 - 8 , h - 8);
                g2d.drawLine(w/3 + 8, h - 8, 2*w/3 - 8, 2*h/3 + 8);
                turn = !turn;
            }else if(!turn && b8){
                g2d.setColor(Color.BLUE);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawOval(w/3 + 5, 2*h/3 + 5, w/3 - 8, h/3 - 8);
                turn = !turn;
            }

            if(turn && b9){
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(2*w/3 + 8, 2*h/3 + 8, w - 8 , h - 8);
                g2d.drawLine(2*w/3 + 8, h - 8, w - 8, 2*h/3 + 8);
                turn = !turn;
            }else if(!turn && b9){
                g2d.setColor(Color.BLUE);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawOval(2*w/3 + 5, 2*h/3 + 5, w/3 - 8, h/3 - 8);
                turn = !turn;
            }
        }

        @Override
        public int getIconWidth() {return getWidth();}

        @Override
        public int getIconHeight() {return getHeight();}
    }
}