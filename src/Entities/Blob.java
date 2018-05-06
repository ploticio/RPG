package Entities;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Blob extends Enemy{

	public Blob() {
		try {
			current = ImageIO.read(new File("blob.png"));
		} catch (IOException e) {
			System.out.println("No Image Found: Enemy");
		}
	}
	
	public Blob(int x, int y) {
		super(x, y);
		try {
			current = ImageIO.read(new File("blob.png"));
		} catch (IOException e) {
			System.out.println("No Image Found: Enemy");
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(current, xPos, yPos, null);
	}
	
	
}
