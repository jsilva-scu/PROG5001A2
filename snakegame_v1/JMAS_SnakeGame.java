import java.awt.EventQueue;
import javax.swing.JFrame;

public class JMAS_SnakeGame extends JFrame {

    public JMAS_SnakeGame(String gameTille) {
        //Adds an instance of GameBoard to the game
        add(new JMAS_GameBoard());
        setTitle(gameTille);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();        
    }
    
    public static void main(String[] args) {    
        EventQueue.invokeLater(() -> {           
            //Creates a new instance of JMAS_LoginForm
            JMAS_LoginForm lf = new JMAS_LoginForm();
            
            //Prompts the login form when Game starts
            lf.show();
        });
    }
}
