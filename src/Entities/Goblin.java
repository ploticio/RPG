package Entities;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * 
 * Goblin Enemy
 *
 */
public class Goblin extends Enemy {
	
	static double multiplier = 3;
	
	/**
	 * Default Constructor - loads enemy image
	 */
	public Goblin() {
		try {
			current = ImageIO.read(new File("Images\\goblin.png"));
		} catch (IOException e) {
			System.out.println("No Image Found: Enemy");
		}
	}

	/**
	 * Loaded Constructor - loads enemy image and x and y position
	 */
	public Goblin(int x, int y) {
		super(x, y, "Goblin", (int) (BlueBlob.health*multiplier) ,(int) (BlueBlob.health*multiplier)
				, (int) (BlueBlob.strength*multiplier), (int) (BlueBlob.exp*multiplier), (int) (BlueBlob.gold*multiplier));
		try {
			current = ImageIO.read(new File("Images\\goblin.png"));
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