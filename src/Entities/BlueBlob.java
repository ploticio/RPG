package Entities;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class BlueBlob extends Enemy {
	static int health = 20;
	static int strength = 18;
	static int exp = 25;
	static int gold = 10;
	/**
	 * Default Constructor - loads enemy image
	 */
	public BlueBlob() {
		try {
			current = ImageIO.read(new File("Images\\blueBlob.png"));
		} catch (IOException e) {
			System.out.println("No Image Found: Enemy");
		}
	}

	/**
	 * Loaded Constructor - loads enemy image and x and y position
	 */
	public BlueBlob(int x, int y) {
		super(x, y, "Blue Blob", health, health, strength, exp, gold);
		try {
			current = ImageIO.read(new File("Images\\blueBlob.png"));
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