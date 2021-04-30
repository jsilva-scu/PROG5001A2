import java.awt.Image;

/**
 * This class represents an apple in the game.
 *
 * @author Jhonathan Maia Alves da Silva
 * @date 04/03/2021
 * @version 1.0
 */
public class JMAS_Apple extends JMAS_GameElement {
    
    private Image apple;
    
    /**
     * Constructor for objects of class Apple
     */
    public JMAS_Apple() {    
    }
    
    /**
     * Constructor for objects of class Apple
     * 
     * @param Image - represents an apple
     */
    public JMAS_Apple(Image appleImg) {
        this.apple = appleImg;
    }
    
    public Image getAppleImg() {
        return this.apple;
    }
}

