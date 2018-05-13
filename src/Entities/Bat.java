package Entities;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
/**
 * 
 * Bat enemy
 *
 */
public class Bat extends Enemy {

	static double multiplier = 2;
	
	/**
	 * Default Constructor - loads enemy image
	 */
	public Bat() {
		try {
			current = ImageIO.read(new File("Images\\bat.png"));
		} catch (IOException e) {
			System.out.println("No Image Found: Enemy");
		}
	}

	/**
	 * Loaded Constructor - loads enemy image and x and y position
	 */
	public Bat(int x, int y) {
		super(x, y, "Bat", (int) (BlueBlob.health*multiplier) ,(int) (BlueBlob.health*multiplier)
				, (int) (BlueBlob.strength*multiplier), (int) (BlueBlob.exp*multiplier), (int) (BlueBlob.gold*multiplier));
		try {
			current = ImageIO.read(new File("Images\\bat.png"));
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