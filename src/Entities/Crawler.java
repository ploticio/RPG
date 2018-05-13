package Entities;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Crawler extends Enemy {

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
		super(x, y, "Crawler", 30, 30, 60, 30, 3);
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