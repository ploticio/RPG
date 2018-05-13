package Items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * GoldSword increases damage by 95
 *
 */
public class GoldSword extends Weapon {

	private static int increase = 95;
	private static int price = 700;
	private static String name = "(PRICE: " + price + ")" + " Gold Sword";
	private static String desc = "Increases Strength by " + increase;
	private BufferedImage picture;

	/**
	 * Constructor for Gold Sword
	 */
	public GoldSword() {
		super(name, desc, increase, price);
		try {
			picture = ImageIO.read(new File("Images\\swordGold.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * getter method for gold sword's sprite
	 */
	public BufferedImage getPicture() {
		return picture;
	}

}
