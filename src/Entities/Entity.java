package Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Entity {

	protected int xPos, yPos, xGrid, yGrid;

	BufferedImage current;

	public Entity() {
	}

	public Entity(int x, int y) {
		xGrid = x;
		yGrid = y;
		xPos = x * 40;
		yPos = y * 40;
	}

	public void moveX(int x) {
		xGrid += x;
		xPos += x * 40;
	}

	public void moveY(int y) {
		yGrid += y;
		yPos += y * 40;
	}

	public void setxGrid(int x) {
		xGrid = x;
		xPos = x * 40;
	}

	public void setyGrid(int y) {
		yGrid = y;
		yPos = y * 40;
	}

	public int getxGrid() {
		return xGrid;
	}

	public int getyGrid() {
		return yGrid;
	}

	public void draw(Graphics g) {
	}

	public String toString() {
		return this.getClass().getSimpleName();
	}

}
