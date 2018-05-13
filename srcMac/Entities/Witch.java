package Entities;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Witch extends Enemy {

	/**
	 * Default Constructor - loads enemy image
	 */
	public Witch() {
		try {
			current = ImageIO.read(new File("Images//witch.png"));
		} catch (IOException e) {
			System.out.println("No Image Found: Enemy");
		}
	}

	/**
	 * Loaded Constructor - loads enemy image and x and y position
	 */
	public Witch(int x, int y) {
		super(x, y, "Witch", 15, 15, 10, 25, 3);
		try {
			current = ImageIO.read(new File("Images//witch.png"));
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