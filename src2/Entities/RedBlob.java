package Entities;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class RedBlob extends Enemy {

	/**
	 * Default Constructor - loads enemy image
	 */
	public RedBlob() {
		try {
			current = ImageIO.read(new File("Images\\redBlob.png"));
		} catch (IOException e) {
			System.out.println("No Image Found: Enemy");
		}
	}

	/**
	 * Loaded Constructor - loads enemy image and x and y position
	 */
	public RedBlob(int x, int y) {
		super(x, y, "Red Blob", 20, 20, 10, 25, 3);
		try {
			current = ImageIO.read(new File("Images\\redBlob.png"));
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