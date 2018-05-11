package Entities;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Bat extends Enemy {

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
		super(x, y, "Bat", 15, 15, 10, 10, 10);
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