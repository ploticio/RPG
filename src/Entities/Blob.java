package Entities;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Blob extends Enemy {

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
		super(x, y, "Green Blob", 15, 15, 10, gold());
		try {
			current = ImageIO.read(new File("Images\\blob.png"));
		} catch (IOException e) {
			System.out.println("No Image Found: Enemy");
		}
	}

	/**
	 * Randomizes amount of gold held
	 * @return gold - amount of gold held
	 */
	// random amount of gold to be dropped
	private static int gold() {
		Random rand = new Random();
		int gold = rand.nextInt(9) + 1;
		return gold;
	}

	/**
	 * Renders enemy
	 */
	public void draw(Graphics g) {
		g.drawImage(current, xPos, yPos, null);
	}

}