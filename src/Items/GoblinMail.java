package Items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Goblin Mail decrease damage taken by 10%
 *
 */
public class GoblinMail extends Armor {

	private static double increase = .10;
	private static int price = 150;
	private static String name = "(PRICE: " + price + ")" + " Goblin Mail";
	private static String desc = "Decreases damage taken by 10%";
	private BufferedImage picture;

	/**
	 * Constructor for Goblin Mail
	 */
	public GoblinMail() {
		super(name, desc, increase, price);
		try {
			picture = ImageIO.read(new File("Images\\goblinMail.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * getter method for goblin mail's sprite
	 * 
	 * @return the sprite
	 */
	public BufferedImage getPicture() {
		return picture;
	}

}
