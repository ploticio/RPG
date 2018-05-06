package Entities;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Graphics.GraphicsMaker;

public class Player extends Entity {

	 BufferedImage down;
	 BufferedImage up;
	 BufferedImage left;
	 BufferedImage right;
	 BufferedImage current;
	
	public Player() {
		
	}
	
	public Player(int x, int y) {
		super(x, y);
		try {
			up = ImageIO.read(new File("boiBack.png"));
			down = ImageIO.read(new File("boiFront.png"));
			left = ImageIO.read(new File("boiLeft.png"));
			right = ImageIO.read(new File("boiRight.png"));
			current = down;
		} catch (IOException e) {
			System.out.println("No Image Found: Player");
		}
	}
	
	
	public void setCurrent(String s) {
		if(s.equals("up"))
			current = up;
		if(s.equals("left"))
			current = left;
		if(s.equals("right"))
			current = right;
		if(s.equals("down"))
			current = down;
	}
	
	
	
	public void draw(Graphics g) {
		g.drawImage(current, xPos, yPos, null);	
	}
	
}
