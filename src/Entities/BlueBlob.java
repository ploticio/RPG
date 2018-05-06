package Entities;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BlueBlob extends Enemy{

	public BlueBlob() {
		try {
			current = ImageIO.read(new File("blueBlob.png"));
		} catch (IOException e) {
			System.out.println("No Image Found: Enemy");
		}	
	}
	
	public BlueBlob(int x, int y) {
		super(x, y);
		try {
			current = ImageIO.read(new File("blueBlob.png"));
		} catch (IOException e) {
			System.out.println("No Image Found: Enemy");
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(current, xPos, yPos, null);
	}

}
