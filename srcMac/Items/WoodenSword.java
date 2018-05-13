package Items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WoodenSword extends Weapon {
	
	private static int increase = 2;
	private static int price = 5;
	private static String name = "(PRICE: " + price +")" + " Wooden Sword";
	private static String desc = "Increases Strength by 2";
	private BufferedImage picture;
	
	public WoodenSword() {
		super(name, desc, increase, 5);
		try {
			picture = ImageIO.read(new File("Images//swordWood.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BufferedImage getPicture() {
		return picture;
	}
}
