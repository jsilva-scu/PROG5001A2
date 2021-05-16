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
        
    private int length = 3;
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
    public JMAS_Snake(int length, float speed){
        this();
        this.length = length;
        this.speed = speed;
    }
    
    /**
     * Returns the length of the snakeBody
     * 
     * @return property length
     */
    public int getLength() {
        return this.length; 
    }
    
    /**
     * Method to set the length of the snakeBody
     *
     * @param  length the length to be set
     */
    public void setLength(int length) {
        this.length = length;
    }
    
    /**
     * Increases the length of the snakeBody
     *
     * @param  amount the amount to which to increase the length
     * @return length + amount
     */
    public void increaseLength(int amount) {
        this.length += amount;
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
    
    /**
     * Method to change the x or y position of the snake
     *
     * @param  direction - the movement direction (left, right, up, down)
     */
    public void move() {
        for (int z = length; z > 0; z--) {
            int index = (z - 1);
            JMAS_BodySeguiment bSeg = snakeBody.get(index);
            
            bSeg.setXPos(bSeg.getXPos() + 10);
            
            //snakeBody.get(index).setXAndYPos(x++, y++);
        }

        // Continue here... Add direction change
    }
    
    /**
     * Checks if snake collided on walls or its body.
     * 
     * @return True if collision adentified, False otherwise.
     */
    public boolean checkCollision() {
        return false;
    }
    
    /**
     * Method to create a basic snakeBody.
     *
     */
    public void createSnake() {
        for(int i = 0; i < length; i++) {            
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
