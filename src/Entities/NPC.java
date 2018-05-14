package Entities;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
/**
 * 
 * BlueBlob Enemy
 *
 */
public class NPC extends Enemy {
	/**
	 * Default Constructor - loads enemy image
	 */
	public NPC() {
		try {
			current = ImageIO.read(new File("Images\\npc.png"));
		} catch (IOException e) {
			System.out.println("No Image Found: Enemy");
		}
	}

	/**
	 * Loaded Constructor - loads enemy image and x and y position
	 */
	public NPC(int x, int y) {
		super(x, y, "Townsman", 1, 1, 1, 1, 1);
		try {
			current = ImageIO.read(new File("Images\\npc.png"));
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