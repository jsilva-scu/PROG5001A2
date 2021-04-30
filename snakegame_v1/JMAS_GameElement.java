
/**
 * This class is has commonly shared properties of game objects.
 *
 * @author Jhonathan Maia Alves da Silva
 * @date 30/04/2021
 * @version 1.0
 */
public abstract class JMAS_GameElement {
    private int xPosition, yPosition;
    
    /**
     * Constructor for class JMAS_GameElement
     */
    public JMAS_GameElement(){
    }
    
    /**
     * Method to return the X position of the element.
     *
     * @return the x position of the element.
     */
    public int getXPosition() {
        return this.xPosition;
    }
    
    /**
     * Method to set the element's xPosition
     *
     * @param  position  the value for position X
     */
    public void setXPosition(int position) {
        
    }
    
    /**
     * Method to return the Y position of the element
     *
     * @return the y position of the element
     */
    public int getYPosition() {
        return yPosition;
    }
    
    /**
     * Method to set the element's yPosition
     *
     * @param  position the value for y position to be set
     */
    public void setYPosition(int position) {
        
    }
    
    /**
     * Method to set the element's initial x and y position.
     * 
     */
    public void setInitialPosition(int x, int y) {
    }
    
    /**
     * Method to draw the element on the screen
     *
     */
    public void draw() {
    
    }
}
