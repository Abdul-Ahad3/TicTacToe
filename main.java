import javax.swing.JFrame;

public class main {
    public static void main(String[] args)
    {
        JFrame window = new JFrame();
        window.add(new TicTacToe());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(600, 600);
        window.setVisible(true);
    }
}