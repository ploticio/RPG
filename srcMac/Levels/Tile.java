package Levels;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Tile {

	private int xPos, yPos;
	private Color color = Color.black; // default color (black)
	private BufferedImage image;

	// PROPERTIES
	private boolean blocked = false;
	private boolean hasEntity = false;
	private int changer = 0;

	/**
	 * Default Constructor - Creates new tile
	 */
	public Tile() {
		// default constructor
	}

	/**
	 * Loaded Constructor - initializes x and y position of tile
	 * @param x - x position
	 * @param y - y position
	 */
	public Tile(int x, int y) {
		xPos = x;
		yPos = y;
	}

	/**
	 * Sets color to tile
	 * @param c - new color
	 */
	public void setColor(Color c) {
		color = c;
	}

	/**
	 * Sets image to tile
	 * @param s - name of new image
	 */
	public void setImage(String s) {
		try {
			image = ImageIO.read(new File(s));
		} catch (IOException e) {
			System.out.println("No Image Found: " + s);
		}
	}

	/**
	 * Renders tile
	 * @param g - graphics grawer
	 */
	public void drawTile(Graphics g) {
		g.setColor(color);
		g.fillRect(xPos, yPos, 40, 40);
		if (image != null) {
			g.drawImage(image, xPos, yPos, 40, 40, null);
		}

	}
	
	// PROPERTIES
	
	/**
	 * Gets block property
	 * @return blocked - block property
	 */
	public boolean isBlocked() {
		return blocked;
	}
	
	/**
	 * Sets block property
	 * @param b - block property
	 */
	public void setBlocked(boolean b) {
		blocked = b;
	}
	
	/**
	 * Sets entity possession property
	 * @param b - entity possession property
	 */
	public void setHasEntity(boolean b) {
		hasEntity = b;
	}
	
	/**
	 * Gets entity possession property
	 * @return hasEnntity -  entity possession property
	 */
	public boolean hasEntity() {
		return hasEntity;
	}
	
	/**
	 * Sets level changer property
	 * @param n - level changer property
	 */
	public void setChanger(int n) {
		changer = n;
	}
	
	/**
	 * Gets level changer property
	 * @return n - level changer property
	 */
	public int getChanger() {
		return changer;
	}
	
}