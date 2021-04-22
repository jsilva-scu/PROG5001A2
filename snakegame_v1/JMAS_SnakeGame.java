import java.awt.EventQueue;
import javax.swing.JFrame;

public class JMAS_SnakeGame extends JFrame {

    public JMAS_SnakeGame(String gameTille) {        
        setTitle(gameTille);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();        
    }
    
    public static void main(String[] args) {        
        EventQueue.invokeLater(() -> {
            //create the game with a game title as follow: The Snake Game (C) Your_Name
            JFrame sgame = new JMAS_SnakeGame("The Snake Game (C) Jhonathan Silva");
            sgame.setVisible(true);
        });
    }
}
