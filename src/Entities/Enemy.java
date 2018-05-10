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

	private int gold = 0;// amount of gold enemy drops

	/**
	 * Default Constructor - creates enemy
	 */
	public Enemy() {

	}

	/**
	 * Loaded Constructor - initializes enemy position, name, maximum health, current health, 
	 * strength points, and gold amount
	 * @param x - x position
	 * @param y - y position
	 * @param name - enemy name
	 * @param maxHP - maximum health points
	 * @param cHP - current health points
	 * @param strength - strength points
	 * @param gold - amount of gold held
	 */
	Enemy(int x, int y, String name, int maxHP, int cHP, int strength, int gold) {
		super(x, y, name, maxHP, cHP, strength);
		this.gold = gold;
	}

	/**
	 * Randomly moves enemy one tile
	 * @param grid - array of tiles for level
	 */
	public void randomMovement(Tile[][] grid) {
		randomMovement(grid, 11, 11);
	}

	/**
	 * Picks a random direction; checks if there is an entity there, is blocked, or at the edge of the grid;
	 * then moves the enemy if it meets the conditions
	 * @param grid - array for level
	 * @param xBound - clearance boundary in the x direction
	 * @param yBound - clearance boundary in the y direction
	 */
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

	/**
	 * Renders enemy
	 */
	public void draw(Graphics g) {

	}

	/**
	 * Gets gold amount
	 * @return gold - amount of gold held
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * Sets gold amount
	 * @param gold - amount of gold held
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}

	/**
	 * Adds to enemy health
	 * @param x - health points added
	 */
	public void changeHealth(int x) {
		super.setCurrentHP(super.getCurrentHP() + x);
	}

}