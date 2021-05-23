import java.awt.Image;
import java.util.Random;

/**
 * This class represents an apple in the game.
 *
 * @author Jhonathan Maia Alves da Silva
 * @date 04/03/2021
 * @version 1.0
 */
public class JMAS_Prey extends JMAS_GameObj {
        
    /**
     * Constructor for objects of class Apple
     */
    public JMAS_Prey() {
        super();
    }
    
    public JMAS_Prey(int xPos, int yPos, Image img) {
        super(xPos, yPos, img);
    }
    
    public JMAS_Prey(Image img) {
        super(img);
    }
}

