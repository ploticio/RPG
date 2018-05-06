package Entities;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RedBlob extends Enemy{

	public RedBlob() {
		try {
			current = ImageIO.read(new File("redBlob.png"));
		} catch (IOException e) {
			System.out.println("No Image Found: Enemy");
		}
	}
	
	public RedBlob(int x, int y) {
		super(x, y);
		try {
			current = ImageIO.read(new File("redBlob.png"));
		} catch (IOException e) {
			System.out.println("No Image Found: Enemy");
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(current, xPos, yPos, null);
	}

}
