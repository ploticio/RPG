package Items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Gold Mail reduces damage taken by 30%
 *
 */
public class GoldMail extends Armor {

	private static double increase = .3;
	private static int price = 700;
	private static String name = "(PRICE: " + price + ")" + " Gold Mail";
	private static String desc = "Decreases damage taken by 30%";
	private BufferedImage picture;

	/**
	 * Constructor for Gold Mail
	 */
	public GoldMail() {
		super(name, desc, increase, price);
		try {
			picture = ImageIO.read(new File("Images////goldMail.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * getter method for gold mail's sprite
	 * 
	 * @return the sprite
	 */
	public BufferedImage getPicture() {
		return picture;
	}
}
