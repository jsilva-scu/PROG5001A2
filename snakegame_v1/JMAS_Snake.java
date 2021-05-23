import java.util.Timer;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.LinkedList;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * This class represents a snake in the game.
 *
 * @author Jhonathan Maia Alves da Silva
 * @date 30/04/2021
 * @version 1.0
 */
public class JMAS_Snake extends JMAS_GameObj {

    private int initialLength = 3;
    private float speed = 10;
    private int cellSize = 50;

    private JMAS_BodySeguiment bs;
    private ArrayList<JMAS_BodySeguiment> snakeBody = new ArrayList<JMAS_BodySeguiment>();

    /**
     * Constructor for objects of class Snake
     */
    public JMAS_Snake() {
        createSnake();
    }

    /**
     * Constructor for objects of class Snake
     */
    public JMAS_Snake(int initialLength, float speed){
        this();
        this.initialLength = initialLength;
        this.speed = speed;
    }

    /**
     * Returns the initialLength of the snakeBody
     * 
     * @return property initialLength
     */
    public int getLength() {
        return this.snakeBody.size(); 
    }

    /**
     * Increases the initialLength of the snakeBody
     *
     */
    public void increaseLength() {
        int[] lastSeg = snakeBody.get(getLength() - 1).getXAndYPos();
        bs = new JMAS_BodySeguiment(lastSeg[0], lastSeg[1], new ImageIcon("resources/body.png").getImage());
        this.snakeBody.add(bs);
    }

    /**
     * Method to return the snake's movement speed.
     *
     * @return the speed property
     */
    public float getSpeed() {
        return this.speed;
    }

    /**
     * Method to set the speed of the snake
     *
     * @param  amount - the amount to be set as speed
     */
    public void setSpeed(float amount) {
        this.speed = amount;
    }

    /**
     * Method to return the array of JMAS_BodySegment
     *
     */
    public ArrayList<JMAS_BodySeguiment> getBody() {
        return snakeBody;
    }
    
    public JMAS_BodySeguiment getHead() {
        return snakeBody.get(0);
    }

    /**
     * Method to change the x or y position of the snake
     *
     * @param  direction - the movement direction (left, right, up, down)
     */
    public void move(String direction) {
        JMAS_BodySeguiment bSeg, bSegTemp;
        
        // Gets the current position of the head.
        int[] oldPos = getHead().getXAndYPos();
        
        if (direction == "LEFT") {
            getHead().setXAndYPos(oldPos[0] - 10, oldPos[1]);
        }

        if (direction == "RIGHT") {
            getHead().setXAndYPos(oldPos[0] + 10, oldPos[1]);

        }

        if (direction == "UP") {
            getHead().setXAndYPos(oldPos[0], oldPos[1] - 10);
        }

        if (direction == "DOWN") {
            getHead().setXAndYPos(oldPos[0], oldPos[1] + 10);
        }
        
        // Make body parts follow the head
        for (int z = 1; z < snakeBody.size(); z++) {
            bSeg = snakeBody.get(z); 
             
            int x = bSeg.getXPos();
            int y = bSeg.getYPos();
            
            // Gets another copy and sets the position
            bSeg.setXAndYPos(oldPos[0], oldPos[1]);
            
            // Update oldPos with position before the change
            oldPos[0] = x;
            oldPos[1] = y;
        }
    }
    

    /**
     * Method to create a basic snakeBody.
     *
     */
    public void createSnake() {
        for(int i = 0; i < initialLength; i++) {            
            if(i == 0) {
                bs = new JMAS_BodySeguiment(i, i, new ImageIcon("resources/head.png").getImage());
                snakeBody.add(bs);
            } else {
                bs = new JMAS_BodySeguiment(i, i, new ImageIcon("resources/body.png").getImage());
                snakeBody.add(bs);
            }
        }
    }

    /**
     * Method to draw the snake on the screen
     *
     */
    @Override
    public void draw(Graphics g) {
        for(int i = 0; i < snakeBody.size(); i++) {
            snakeBody.get(i).draw(g);
        }
    }
}
