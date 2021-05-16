import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

/**
 * This class represents the game board or canvas. 
 *
 * @author Jhonathan Maia Alves da Silva
 * @date 30/04/2021
 * @version 1.0
 */
public class JMAS_GameBoard extends JPanel {
    
    private final int WIDTH = 30;
    private final int HEIGHT = 30;
    private final int CELLSZ = 10;
    private final int DELAY = 240;
    // Variable that indicates if the game is running or not.
    private boolean inGame = false;
    private JMAS_Snake snake = new JMAS_Snake();
    private JMAS_Apple prey = new JMAS_Apple(new ImageIcon("resources/prey.png").getImage());
           
    public JMAS_GameBoard() {
        setPreferredSize(new Dimension(WIDTH * CELLSZ, HEIGHT * CELLSZ));        
        setBackground(Color.black);
        setFocusable(true);        
    }
    
    public void initGame() {
        inGame = true;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawings(g);
    }
    
    public void doDrawings(Graphics g) {
        if(!inGame) {
            // Draws the snake
            snake.draw(g);
            // Spawn the prey
            spawnPrey(g);
        }
    }
    
    /**
     * Method to geberate a random location for the prey. 
     * 
     * @param Graphic g - Used to render the prey image on a random location on the screen.
     */
    public void spawnPrey(Graphics g) {
        int x = (int)(Math.random() * ((WIDTH * CELLSZ) - WIDTH + CELLSZ) + 10);
        int y = (int)(Math.random() * ((HEIGHT * CELLSZ) - HEIGHT + CELLSZ) + 10);
        
        prey.setXAndYPos(x, y);
        prey.draw(g);
    }
}
