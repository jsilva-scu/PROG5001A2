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
import java.util.Random;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontMetrics;
import javax.swing.JFrame;
import java.awt.Component;

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
    private final int DIMENTION_W = WIDTH * CELLSZ;
    private final int DIMENTION_H = HEIGHT * CELLSZ;
    private final int DELAY = 240;

    // List to store preys and snakes
    private ArrayList<JMAS_Prey> preys = new ArrayList<JMAS_Prey>();
    private ArrayList<JMAS_Snake> snakes = new ArrayList<JMAS_Snake>();

    private Timer timer = new Timer(DELAY, this);
    private boolean isPaused = false;

    // Variable that indicates if the game is running or not.
    private boolean inGame = false;
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    // Variable for snake 2
    private boolean aDirection = false;
    private boolean dDirection = true;
    private boolean wDirection = false;
    private boolean sDirection = false;    

    private JMAS_SnakeGame parent;

    public JMAS_GameBoard() {
        addKeyListener(new TAdapter());
        setPreferredSize(new Dimension(DIMENTION_W, DIMENTION_H));        
        setBackground(Color.black);
        setFocusable(true);

        initGame();
    }

    public JMAS_GameBoard(JMAS_SnakeGame parent) {
        this();
        this.parent = parent;
    }

    public void initGame() {
        inGame = true;

        // Sets the initial X and Y positions for the Prey
        spawnPrey();

        // Sets the initial X and Y positions for the Snake
        spawnSnake();

        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawings(g);
    }

    public void doDrawings(Graphics g) {
        if(inGame) {
            for(int i = 0; i < preys.size(); i++) {
                preys.get(i).draw(g);
            }

            //DRAW SNAKES 
            for(int i = 0; i < snakes.size(); i++) {
                snakes.get(i).draw(g);
            }
        } else {
            gameOver(g);
        }
    }

    /**
     * Returns the Panels parent component.
     * 
     * @return JMAS_SnakeGame - The parent or container of this JPanel.
     */
    public JMAS_SnakeGame getParent() {
        return this.parent;
    }

    /**
     * Method to generate a random X and Y location for the prey.
     * 
     */
    public void spawnPrey() {
        Random rnd;
        int x, y;
        if(preys.size() < 1) {
            preys.add(new JMAS_Prey(new ImageIcon("resources/prey.png").getImage()));
            preys.add(new JMAS_Prey(new ImageIcon("resources/prey.png").getImage()));
        } else if(preys.size() == 1) {
            preys.add(new JMAS_Prey(new ImageIcon("resources/prey.png").getImage()));
        }

        for(int i = (preys.size() - 1); i > 0; i--) {
            rnd = new Random();
            x = (rnd.nextInt(WIDTH) * CELLSZ) - WIDTH;
            y = (rnd.nextInt(HEIGHT) * CELLSZ) - HEIGHT;
            if(x < 0) {
                x = (x * -1);
            } else if (y < 0) {
                y = (y * -1);
            }
            preys.get(i).setXAndYPos(x, y);
        }
    }

    /**
     * Method to set the X and Y location for the snake.
     * 
     */
    public void spawnSnake() {
        ArrayList<JMAS_BodySeguiment> snakeBody;
        int x, y;

        if(snakes.size() < 1) {
            snakes.add(new JMAS_Snake());
            snakes.add(new JMAS_Snake()); 
        }

        for(int i = 0; i < snakes.size(); i++) {
            snakeBody = snakes.get(i).getBody();
            System.out.println(snakes.get(i).getBody());
            if(snakeBody.size() > 0) {
                for(int j = 0; j < snakeBody.size(); j++) {
                    x = 50 - j * 10;
                    y = 50;
                    snakeBody.get(j).setXAndYPos(x, y);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {  
        if (inGame) {        
            if (leftDirection) {
                snakes.get(0).move("LEFT");
            }

            if(aDirection) {
                snakes.get(1).move("LEFT");
            }

            if (rightDirection) {
                snakes.get(0).move("RIGHT");
            } 

            if(dDirection) {
                snakes.get(1).move("RIGHT");
            }

            if (upDirection) {
                snakes.get(0).move("UP");
            }

            if(wDirection) {
                snakes.get(1).move("UP");
            }

            if (downDirection) {
                snakes.get(0).move("DOWN");
            }

            if(sDirection) {
                snakes.get(1).move("DOWN");
            }

            for(int i = 0; i < snakes.size(); i++) {
                checkPreyEaten(snakes.get(i));
                checkCollision(snakes.get(i));
            }
        }

        repaint();
    }

    /**
     * Checks if the snake's head is at the same X and Y position as the prey.
     * 
     * @return none.
     */
    private void checkPreyEaten(JMAS_Snake snake) {       
        int[] snakeHeadPos = snake.getHead().getXAndYPos();
        JMAS_Prey prey1 = preys.get(0);
        JMAS_Prey prey2 = preys.get(1);   

        if ((snakeHeadPos[0] == prey1.getXPos()) && (snakeHeadPos[1] == prey1.getYPos())) {
            preys.remove(0);
            snake.increaseLength();
            JMAS_SnakeGame parent = getParent();
            parent.incrementScore(1);
            spawnPrey();
        } else if ((snakeHeadPos[0] == prey2.getXPos()) && (snakeHeadPos[1] == prey2.getYPos())) {
            preys.remove(1);
            snake.increaseLength();
            JMAS_SnakeGame parent = getParent();
            parent.incrementScore(1);
            spawnPrey();
        }
    }

    /**
     * Checks if snake collided on walls or its body.
     * 
     * @return True if collision adentified, False otherwise.
     */
    public void checkCollision(JMAS_Snake snake) {
        int[] headPos = snake.getHead().getXAndYPos();
        JMAS_BodySeguiment bSeg;
        ArrayList<JMAS_BodySeguiment> snakeBody = snake.getBody();

        for (int z = 1; z < snakeBody.size(); z++) {
            bSeg = snakeBody.get(z);
            if(snakeBody.size() > 4 && (headPos[0] == bSeg.getXPos()) && headPos[1] == bSeg.getYPos()) {
                inGame = false;
            }
        }

        // Check collision with board.
        if (headPos[1] >= DIMENTION_H) {
            inGame = false;
        }

        if (headPos[1] < 0) {
            inGame = false;
        }

        if (headPos[0] >= DIMENTION_W) {
            inGame = false;
        }

        if (headPos[0] < 0) {
            inGame = false;
        }

        if (!inGame) {
            timer.stop();
            parent.setPlayerBestScore();
        }
    }

    public void gameOver(Graphics g) {
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (DIMENTION_W - metr.stringWidth(msg)) / 2, DIMENTION_H / 2);
    }

    private class TAdapter extends KeyAdapter {

        //##### NEW CODE #####//

        private boolean checkKeyPressedSnake1(int key) {
            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
                return true;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
                return true;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
                return true;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
                return true;
            }
            return false;
        }

        private void checkKeySnake2(int key) {
            if ((key == KeyEvent.VK_A) && (!dDirection)) {
                aDirection = true;
                wDirection = false;
                sDirection = false;
            }

            if ((key == KeyEvent.VK_D) && (!aDirection)) {
                dDirection = true;
                wDirection = false;
                sDirection = false;
            }

            if ((key == KeyEvent.VK_W) && (!sDirection)) {
                wDirection = true;
                dDirection = false;
                aDirection = false;
            }

            if ((key == KeyEvent.VK_S) && (!wDirection)) {
                sDirection = true;
                dDirection = false;
                aDirection = false;
            } 
        }

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();
            if(!checkKeyPressedSnake1(key)) {
                checkKeySnake2(key);
            }

            if ((key == KeyEvent.VK_BACK_SPACE || key == 32)) {
                if(isPaused) {
                    timer.start();
                    isPaused = false;
                } else {
                    timer.stop();
                    isPaused = true;
                }

            }
        }
    }
}
