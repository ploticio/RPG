package Items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Entities.*;

/**
 * 
 * A big potion
 *
 */
public class BigPotion extends Item {
	private String name;
	private String desc;
	private int price;
	private int increase;
	private BufferedImage picture;

	/**
	 * sets the price of the potion, and how much it cost
	 */
	public BigPotion() {
		price = 75;
		increase = 100;
		super.setPrice(price);
		name = "(PRICE: " + price + ")" + " Big Potion";
		desc = "Heals " + increase + " hp";
		try {
			picture = ImageIO.read(new File("Images////potBig.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Overloaded constructor for big potion
	 * 
	 * @param name
	 *            the name
	 * @param desc
	 *            the description
	 * @param price
	 *            the price
	 */
	public BigPotion(String name, String desc, int price) {
		super(name, desc, price);
		// this.p = p;
		// TODO Auto-generated constructor stub
	}

	/**
	 * increases health by 100;
	 */
	public void use(Entity e) {
		e.changeHP(100);
	}

	/**
	 * to string method
	 */
	public String toString() {
		return name + ": " + desc;
	}

	/**
	 * getter method for the picture
	 * 
	 * @return the image
	 */
	public BufferedImage getPicture() {
		return picture;
	}

}
