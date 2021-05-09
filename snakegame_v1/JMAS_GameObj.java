import java.awt.Image;
import java.awt.Graphics;

/**
 * Abstract class GameObj - Represents and object on the game e.g.: prey.
 *
 * @author Jhonathan Silva
 * @date 06/05/2021
 * @version 1.0
 */
public abstract class JMAS_GameObj {
    
    private int xPos, yPos;
    private Image img;
    
    /**
     * Default constructor for class JMAS_GameObj
     */
    public JMAS_GameObj() {
    }
    
    public JMAS_GameObj(int xPos, int yPos, Image img) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.img = img;
    }
    
    public JMAS_GameObj(Image img) {
        this(290, 290, img);    
    }
    
    /**
     * Method to return the X position of the element.
     *
     * @return the x position of the element.
     */
    public int getXPos() {
        return xPos;
    }
    
    /**
     * Method to set the element's xPos
     *
     * @param  position  the value for position X
     */
    public void setXPos(int xPos) {
        this.xPos = xPos;
    }
    
    /**
     * Method to return the Y position of the element.
     *
     * @return the y position of the element.
     */
    public int getYPos() {
        return yPos;
    }
    
    /**
     * Method to set the element's yPos
     *
     * @param  position  the value for position Y
     */
    public void setYPos(int yPos) {
        this.yPos = yPos;
    }
    // NEW
    public int[] getXAndYPos() {
        return new int[]{ xPos, yPos };
    }
    
    public void setXAndYPos(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }
    
    /**
     * Method to return the Image of the element.
     *
     * @return the Image representing the the element on the screen.
     */
    public Image getImg() {
        return img;
    }
    
    /**
     * Method to set the element's Image
     *
     * @param  Image to be displayed as a representation of the element on the screen
     */
    public void setImg(Image img) {
        this.img = img;
    }
    
    /**
     * Method to draw the element on the screen
     *
     */
    public void draw(Graphics g) {
        g.drawImage(img, xPos, yPos, null);
    }
    
}
