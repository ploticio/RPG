package Items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ChainMail extends Armor {

	private static double increase = .2;
	private static int price = 400;
	private static String name = "(PRICE: " + price + ")" + " Chain Mail";
	private static String desc = "Decreases damage taken by 20%";
	private BufferedImage picture;

	public ChainMail() {
		super(name, desc, increase, price);
		try {
			picture = ImageIO.read(new File("Images\\chainMail.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BufferedImage getPicture() {
		return picture;
	}
}
