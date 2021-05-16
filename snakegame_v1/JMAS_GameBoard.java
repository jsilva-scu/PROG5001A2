import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * This class represents the game board or canvas. 
 *
 * @author Jhonathan Maia Alves da Silva
 * @date 30/04/2021
 * @version 1.0
 */
public class JMAS_GameBoard extends JPanel implements ActionListener {
    
    private final int WIDTH = 30;
    private final int HEIGHT = 30;
    private final int CELLSZ = 10;
    private final int DELAY = 240;
    private JMAS_Snake snake = new JMAS_Snake();
    private JMAS_Apple prey = new JMAS_Apple(new ImageIcon("resources/prey.png").getImage());
    
    //Game usage variables
    private Timer timer;
    // Variable that indicates if the game is running or not.
    private boolean inGame = false;
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    
    public JMAS_GameBoard() {
        setPreferredSize(new Dimension(WIDTH * CELLSZ, HEIGHT * CELLSZ));        
        setBackground(Color.black);
        setFocusable(true);
        initGame();
    }
    
    public void initGame() {
        inGame = true;
        
        // Sets the initial X and Y positions for the Prey
        spawnPrey();
        // Sets the initial X and Y positions for the Snake
        spawnSnake();
        
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        doDrawings(g);
    }
    
    public void doDrawings(Graphics g) {
        if(inGame) {
            // Draws the snake
            snake.draw(g);
            // Draws the prey
            prey.draw(g);
        }
    }
    
    /**
     * Method to generate a random X and Y location for the prey.
     * 
     */
    public void spawnPrey() {
        int x = (int)(Math.random() * ((WIDTH * CELLSZ) - WIDTH + CELLSZ) + 10);
        int y = (int)(Math.random() * ((HEIGHT * CELLSZ) - HEIGHT + CELLSZ) + 10);
        
        prey.setXAndYPos(x, y);
    }
    
    /**
     * Method to set the X and Y location for the snake.
     * 
     */
    public void spawnSnake() {
        ArrayList<JMAS_BodySeguiment> snakeBody = snake.getBody();
        int x, y;
        if(snakeBody.size() > 0) {
            for(int i = 0; i < snakeBody.size(); i++) {
                x = 50 - i * 10;
                y = 50;
                snakeBody.get(i).setXAndYPos(x, y);
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {
            snake.move();
        }

        repaint();
    }
    
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
        }
    }
}
