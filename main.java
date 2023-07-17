import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        JFrame window = new JFrame();
        window.add(new TicTacToe());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500, 600);
        window.setVisible(true);
    }
}