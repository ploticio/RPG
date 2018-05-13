package Items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StoneSword extends Weapon {
	
	private static int increase = 5;
	private static int price = 10;
	private static String name = "(PRICE: " + price +")" + " Stone Sword";
	private static String desc = "Increases Strength by 5";
	private BufferedImage picture;

	public StoneSword() {
		super(name, desc, increase, price);
		try {
			picture = ImageIO.read(new File("Images//swordStone.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public BufferedImage getPicture() {
		return picture;
	}
}
