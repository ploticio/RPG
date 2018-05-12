package Items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GoldMail extends Armor {
	
	private static int increase = 15;
	private static int price = 15;
	private static String name = "(PRICE: " + price +")" + " Gold Mail";
	private static String desc = "Increases maximum HP by 15";
	private BufferedImage picture;
	
	public GoldMail () {
		super(name, desc, increase, price);
		try {
			picture = ImageIO.read(new File("Images\\goldMail.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BufferedImage getPicture() {
		return picture;
	}
}
