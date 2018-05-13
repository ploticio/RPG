package Items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Entities.*;

public class Potion extends Item {
	private String name;
	private String desc;
	private int price;
	private int increase;
	private BufferedImage picture;

	public Potion() {
		price = 25;
		increase = 25;
		super.setPrice(price);
		name = "(PRICE: " + price +")" + " Potion";
		desc = "Heals " + increase + " hp";
		try {
			picture = ImageIO.read(new File("Images////potSmall.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Potion(String name, String desc, int price) {
		super(name, desc, price);
		// this.p = p;
		// TODO Auto-generated constructor stub
	}

	public void use(Entity e) {
		e.changeHP(25);
	}

	public String toString() {
		return name + ": " + desc;
	}
	
	public BufferedImage getPicture() {
		return picture;
	}

}
