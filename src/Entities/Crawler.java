package Entities;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Crawler extends Enemy {

	static double multiplier = 3.5;
	
	/**
	 * Default Constructor - loads enemy image
	 */
	public Crawler() {
		try {
			current = ImageIO.read(new File("Images\\crawler.png"));
		} catch (IOException e) {
			System.out.println("No Image Found: Enemy");
		}
	}

	/**
	 * Loaded Constructor - loads enemy image and x and y position
	 */
	public Crawler(int x, int y) {
		super(x, y, "Crawler", (int) (BlueBlob.health*multiplier) ,(int) (BlueBlob.health*multiplier)
				, (int) (BlueBlob.strength*multiplier), (int) (BlueBlob.exp*multiplier), (int) (BlueBlob.gold*multiplier));
		try {
			current = ImageIO.read(new File("Images\\crawler.png"));
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