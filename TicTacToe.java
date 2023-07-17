import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class TicTacToe extends JPanel
{
    JPanel sPanel = new JPanel();  JPanel gPanel = new JPanel();
    JLabel title = new JLabel("Tic Tac Toe Game");
    JLabel player1 = new JLabel("PLAYER 1 : X");
    JLabel player2 = new JLabel("PLAYER 2 : O");
    
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
        boolean c1, c2, c3, c4, c5, c6, c7, c8, c9;
        int topX=0, mid1X=0, bottomX=0, leftX=0, mid2X=0, rightX=0, cross1X=0, cross2X=0;
        int topO=0, mid1O=0, bottomO=0, leftO=0, mid2O=0, rightO=0, cross1O=0, cross2O=0;
        
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

                    if(topX == 3 || mid1X == 3 || bottomX == 3 || leftX == 3 || mid2X == 3 || rightX ==3 || cross1X == 3 || cross2X == 3){
                        JOptionPane.showMessageDialog(null, "Player 1 wins");
                        removeAll();  revalidate();  repaint();
                        topX=0; mid1X=0; bottomX=0; leftX=0; mid2X=0; rightX=0; cross1X=0; cross2X=0;
                        topO=0; mid1O=0; bottomO=0; leftO=0; mid2O=0; rightO=0; cross1O=0; cross2O=0;
                    }else if(topO == 3 || mid1O == 3 || bottomO == 3 || leftO == 3 || mid2O == 3 || rightO ==3 || cross1O == 3 || cross2O == 3){
                        JOptionPane.showMessageDialog(null, "Player 2 wins");
                        removeAll();  revalidate();  repaint();
                        topX=0; mid1X=0; bottomX=0; leftX=0; mid2X=0; rightX=0; cross1X=0; cross2X=0;
                        topO=0; mid1O=0; bottomO=0; leftO=0; mid2O=0; rightO=0; cross1O=0; cross2O=0;
                    }else if (topX + mid1X + bottomX + leftX + mid2X + rightX + cross1X + cross2X + topO + mid1O + bottomO + leftO + mid2O + rightO + cross1O + cross2O == 24) {
                        JOptionPane.showMessageDialog(null, "It's a tie!");
                        removeAll();  revalidate();  repaint();
                        topX=0; mid1X=0; bottomX=0; leftX=0; mid2X=0; rightX=0; cross1X=0; cross2X=0;
                        topO=0; mid1O=0; bottomO=0; leftO=0; mid2O=0; rightO=0; cross1O=0; cross2O=0;
                    }
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
                turn = !turn;  topX++;  leftX++;  cross1X++;
            }else if(!turn && b1){
                g2d.setColor(Color.BLUE);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawOval(5, 5, w/3 - 8, h/3 - 8);
                turn = !turn;  topO++; leftO++;  cross1O++;
            }
            
            if(turn && b2){
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(w/3 + 8, 8, 2*w/3 - 8 , h/3 - 8);
                g2d.drawLine(w/3 + 8, h/3 - 8, 2*w/3 - 8, 8);
                turn = !turn;  topX++;  mid2X++;
            }else if(!turn && b2){
                g2d.setColor(Color.BLUE);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawOval(w/3 + 5, 5, w/3 - 8, h/3 - 8);
                turn = !turn;  topO++;  mid2O++;
            }

            if(turn && b3){
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(2*w/3 + 8, 8, w - 8 , h/3 - 8);
                g2d.drawLine(2*w/3 + 8, h/3 - 8, w - 8, 8);
                turn = !turn;  topX++;  rightX++;  cross2X++;
            }else if(!turn && b3){
                g2d.setColor(Color.BLUE);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawOval(2*w/3 + 5, 5, w/3 - 8, h/3 - 8);
                turn = !turn;  topO++;  rightO++;  cross2O++;
            }

            if(turn && b4){
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(8, h/3 + 8, w/3 - 8 , 2*h/3 - 8);
                g2d.drawLine(8, 2*h/3 - 8, w/3 - 8, h/3 + 8);
                turn = !turn;  mid1X++;  leftX++;
            }else if(!turn && b4){
                g2d.setColor(Color.BLUE);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawOval(5, h/3 + 5, w/3 - 8, h/3 - 8);
                turn = !turn;  leftO++;  mid1O++;
            }

            if(turn && b5){
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(w/3 + 8, h/3 + 8, 2*w/3 - 8 , 2*h/3 - 8);
                g2d.drawLine(w/3 + 8, 2*h/3 - 8, 2*w/3 - 8, h/3 + 8);
                turn = !turn;  mid1X++;  mid2X++;  cross1X++;  cross2X++;
            }else if(!turn && b5){
                g2d.setColor(Color.BLUE);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawOval(w/3 + 5, h/3 + 5, w/3 - 8, h/3 - 8);
                turn = !turn;  mid1O++;  mid2O++;  cross1O++;  cross2O++;
            }

            if(turn && b6){
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(2*w/3 + 8, h/3 + 8, w - 8 , 2*h/3 - 8);
                g2d.drawLine(w - 8, h/3 + 8, 2*w/3 + 8, 2*h/3 - 8);
                turn = !turn;  rightX++;  mid1X++;
            }else if(!turn && b6){
                g2d.setColor(Color.BLUE);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawOval(2*w/3 + 5, h/3 + 5, w/3 - 8, h/3 - 8);
                turn = !turn;  rightO++;  mid1O++;
            }

            if(turn && b7){
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(8, 2*h/3 + 8, w/3 - 8 , h - 8);
                g2d.drawLine(8, h - 8, w/3 - 8, 2*h/3 + 8);
                turn = !turn;  leftX++;  bottomX++;
            }else if(!turn && b7){
                g2d.setColor(Color.BLUE);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawOval(5, 2*h/3 + 5, w/3 - 8, h/3 - 8);
                turn = !turn; leftO++;  bottomO++;
            }

            if(turn && b8){
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(w/3 + 8, 2*h/3 + 8, 2*w/3 - 8 , h - 8);
                g2d.drawLine(w/3 + 8, h - 8, 2*w/3 - 8, 2*h/3 + 8);
                turn = !turn;  mid2X++;  bottomX++;
            }else if(!turn && b8){
                g2d.setColor(Color.BLUE);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawOval(w/3 + 5, 2*h/3 + 5, w/3 - 8, h/3 - 8);
                turn = !turn;  mid2O++;  bottomO++;
            }

            if(turn && b9){
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(2*w/3 + 8, 2*h/3 + 8, w - 8 , h - 8);
                g2d.drawLine(2*w/3 + 8, h - 8, w - 8, 2*h/3 + 8);
                turn = !turn;  rightX++;  bottomX++;
            }else if(!turn && b9){
                g2d.setColor(Color.BLUE);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawOval(2*w/3 + 5, 2*h/3 + 5, w/3 - 8, h/3 - 8);
                turn = !turn;  rightO++;  bottomO++;
            }
        }

        @Override
        public int getIconWidth() {return getWidth();}

        @Override
        public int getIconHeight() {return getHeight();}
    }
}