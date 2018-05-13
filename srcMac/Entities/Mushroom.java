package Entities;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * 
 * Mushroom Enemy
 *
 */
public class Mushroom extends Enemy {
	
	static double multiplier = 1.5;
	
	/**
	 * Default Constructor - loads enemy image
	 */
	public Mushroom() {
		try {
			current = ImageIO.read(new File("Images////mushroom.png"));
		} catch (IOException e) {
			System.out.println("No Image Found: Enemy");
		}
	}

	/**
	 * Loaded Constructor - loads enemy image and x and y position
	 */
	public Mushroom(int x, int y) {
		super(x, y, "Mushroom", (int) (BlueBlob.health*multiplier) ,(int) (BlueBlob.health*multiplier)
				, (int) (BlueBlob.strength*multiplier), (int) (BlueBlob.exp*multiplier), (int) (BlueBlob.gold*multiplier));
		try {
			current = ImageIO.read(new File("Images////mushroom.png"));
		} catch (IOException e) {
			System.out.println("No Image Found: Enemy");
		}
	}

	/**
	 * Renders enemy
	 */
	public void draw(Graphics g) {
		g.drawImage(current, xPos, yPos, null);
	}

}