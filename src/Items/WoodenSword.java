package Items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author Vincent
 * The lowest tier weapon you can buy
 */
public class WoodenSword extends Weapon {
	
	private static int increase = 20;
	private static int price = 150;
	private static String name = "(PRICE: " + price +")" + " Wooden Sword";
	private static String desc = "Increases Strength by 2";
	private BufferedImage picture;
	
	/**
	 * Default Constructor - Loads name, description, strength percent increase, price, and image
	 */
	public WoodenSword() {
		super(name, desc, increase, price);
		try {
			picture = ImageIO.read(new File("Images\\swordWood.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Returns image of sword
	 */
	public BufferedImage getPicture() {
		return picture;
	}
}
