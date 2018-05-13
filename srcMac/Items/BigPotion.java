package Items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Entities.*;

public class BigPotion extends Item {
	private String name;
	private String desc;
	private int price;
	private BufferedImage picture;

	public BigPotion() {
		price = 15;
		super.setPrice(price);
		name = "(PRICE: " + price +")" + " Big Potion";
		desc = "Heals 15 hp";
		try {
			picture = ImageIO.read(new File("Images//potBig.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BigPotion(String name, String desc, int price) {
		super(name, desc, price);
		// this.p = p;
		// TODO Auto-generated constructor stub
	}

	public void use(Entity e) {
		e.changeHP(15);
	}

	public String toString() {
		return name + ": " + desc;
	}
	
	public BufferedImage getPicture() {
		return picture;
	}

}
