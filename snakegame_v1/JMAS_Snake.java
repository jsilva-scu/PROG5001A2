/**
 * This class represents a snake in the game.
 *
 * @author Jhonathan Maia Alves da Silva
 * @date 30/04/2021
 * @version 1.0
 */
public class JMAS_Snake extends JMAS_GameElement {
        // instance variables
        private int length;
        private float speed;
        
    /**
     * Constructor for objects of class Snake
     */
    public JMAS_Snake(){
    }
    
    /**
     * Returns the length of the snake
     * 
     * @return property length
     */
    public int getLength() {
        return this.length; 
    }
    
    /**
     * Method to set the length of the snake
     *
     * @param  length the length to be set
     */
    public void setLength(int length) {
        
    }
    
    /**
     * Increases the length of the snake
     *
     * @param  amount the amount to which to increase the length
     * @return length + amount
     */
    public void increaseLength(int amount) {
        
    }
    
    /**
     * Method to return the snakes movement speed.
     *
     * @return the speed property
     */
    public float getSpeed() {
        return this.speed;
    }
    
    /**
     * Method to set the speed of the snake
     *
     * @param  amount  the amount to be set as speed
     */
    public void setSpeed(float amount) {
        
    }
    
    /**
     * Method to change the x or y position of the snake
     *
     * @param  direction the movement direction (left, right, up, down)
     */
    public void move(int direction) {
    }
    
    /**
     * Checks if snake collided on walls or its body.
     * 
     * @return True if collision adentified, False otherwise.
     */
    public boolean checkCollision() {
        return false;
    }
}
