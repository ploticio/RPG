package Entities;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Blob extends Enemy {

	static Random r = new Random();

	/**
	 * Default Constructor - loads enemy image
	 */
	public Blob() {
		try {
			current = ImageIO.read(new File("Images\\blob.png"));
		} catch (IOException e) {
			System.out.println("No Image Found: Enemy");
		}
	}

	/**
	 * Loaded Constructor - loads enemy image and x and y position
	 */
	public Blob(int x, int y) {
		super(x, y, "Green Blob", 20, 20, 1, r.nextInt(3) + 5, 3);
		try {
			current = ImageIO.read(new File("Images\\blob.png"));
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