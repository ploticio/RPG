package Items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Entities.*;

/**
 * 
 * @author Vincent
 * Lowest tier potion
 */
public class Potion extends Item {
	private String name;
	private String desc;
	private int price;
	private int increase;
	private BufferedImage picture;

	/**
	 * Default Constructor - Loads name, description, health percent increase, price, and image
	 */
	public Potion() {
		price = 25;
		increase = 25;
		super.setPrice(price);
		name = "(PRICE: " + price +")" + " Potion";
		desc = "Heals " + increase + " hp";
		try {
			picture = ImageIO.read(new File("Images\\potSmall.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Loaded Constructor - Loads name, description and price in shop
	 * @param name - potion name
	 * @param desc - potion description
	 * @param price - potion's price in shop
	 */
	public Potion(String name, String desc, int price) {
		super(name, desc, price);
		// this.p = p;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Increases player's health points
	 */
	public void use(Entity e) {
		e.changeHP(25);
	}

	/**
	 * Returns potion's name and description as a string
	 */
	public String toString() {
		return name + ": " + desc;
	}
	
	/**
	 * Returns potion's description
	 */
	public BufferedImage getPicture() {
		return picture;
	}

}
