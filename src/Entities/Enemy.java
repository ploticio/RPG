package Entities;

import java.awt.Graphics;
import java.util.Random;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Levels.Tile;

public abstract class Enemy extends Entity {

	Random r = new Random();

	// STARTING POSITION (FOR BOUNDING MOVEMENT)
	int xStart = super.getxGrid();
	int yStart = super.getyGrid();

	// PROPERTIES
	boolean isDead = false;

	private gold = 0;// amount of gold enemy drops

	public Enemy() {

	}

	Enemy(int x, int y, String name, int maxHP, int cHP, int strength, int gold) {
		super(x, y, name, maxHP, cHP, strength);
		this.gold = gold;
	}

	public void randomMovement(Tile[][] grid) {
		randomMovement(grid, 11, 11);
	}

	public void randomMovement(Tile[][] grid, int xBound, int yBound) {
		grid[super.getxGrid()][super.getyGrid()].setHasEntity(false);
		// System.out.println("differenceX: " + Math.abs(super.getxGrid()-xStart) + "
		// differenceY: " + Math.abs(super.getyGrid()-yStart));
		int randomMove = r.nextInt(4);
		if (randomMove == 0 && super.getxGrid() != 0 && Math.abs(super.getxGrid() - 1 - xStart) <= xBound
				&& !grid[super.getxGrid() - 1][super.getyGrid()].isBlocked()
				&& !grid[super.getxGrid() - 1][super.getyGrid()].hasEntity()) {
			super.moveX(-1);
		}
		if (randomMove == 1 && super.getxGrid() != 20 && Math.abs(super.getxGrid() + 1 - xStart) <= xBound
				&& !grid[super.getxGrid() + 1][super.getyGrid()].isBlocked()
				&& !grid[super.getxGrid() + 1][super.getyGrid()].hasEntity()) {
			super.moveX(1);
		}
		if (randomMove == 2 && super.getyGrid() != 0 && Math.abs(super.getyGrid() - 1 - yStart) <= yBound
				&& !grid[super.getxGrid()][super.getyGrid() - 1].isBlocked()
				&& !grid[super.getxGrid()][super.getyGrid() - 1].hasEntity()) {
			super.moveY(-1);
		}
		if (randomMove == 3 && super.getyGrid() != 20 && Math.abs(super.getyGrid() + 1 - yStart) <= yBound
				&& !grid[super.getxGrid()][super.getyGrid() + 1].isBlocked()
				&& !grid[super.getxGrid()][super.getyGrid() + 1].hasEntity()) {
			super.moveY(1);
		}
		grid[super.getxGrid()][super.getyGrid()].setHasEntity(true);
		// System.out.println("X: " + super.getxGrid() + " Y: " + super.getyGrid());
	}

	public void draw(Graphics g) {

	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public void changeHealth(int x) {
		super.setCurrentHP(super.getCurrentHP() + x);
	}

}
