package Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Entity {

	protected int xPos, yPos, xGrid, yGrid;
	private String myName;
	private int maxHP;
	private int currentHP;
	private int myStrength;

	BufferedImage current;
	
	/**
	 * Constructor - Default constructor
	 */
	public Entity() {
	}

	/**
	 * Constructor - loaded constructor with all needed stats
	 * @param x - x position on grid
	 * @param y - y position on grid
	 * @param name - Name of entity
	 * @param maxHP - Capacity of health
	 * @param cHP - current health
	 * @param strength - strength points of entity
	 */
	public Entity(int x, int y, String name, int maxHP, int cHP, int strength) {
		xGrid = x;
		yGrid = y;
		xPos = x * 40;
		yPos = y * 40;
		this.myName = name;
		this.maxHP = maxHP;
		this.currentHP = cHP;
		this.myStrength = strength;
	}
	
	/**
	 * Moves the image of entity in 
	 * the window and the entity on 
	 * the grid in the x direction
	 * @param x - distance moved
	 */
	public void moveX(int x) {
		xGrid += x;
		xPos += x * 40;
	}

	/**
	 * Moves the image of entity in 
	 * the window and the entity on 
	 * the grid in the y direction 
	 * @param y - distance moved
	 */
	public void moveY(int y) {
		yGrid += y;
		yPos += y * 40;
	}

	/**
	 * Sets the position of the entity in 
	 * the window and on the grid in the x 
	 * direction
	 * @param x - position set
	 */
	public void setxGrid(int x) {
		xGrid = x;
		xPos = x * 40;
	}

	/**
	 * Sets the position of the entity in 
	 * the window and on the grid in the y 
	 * direction
	 * @param y - position set
	 */
	public void setyGrid(int y) {
		yGrid = y;
		yPos = y * 40;
	}

	/**
	 * Returns the position of the entity in 
	 * the window and on the grid in the x 
	 * direction
	 * @param x - position set
	 */
	public int getxGrid() {
		return xGrid;
	}
	
	/**
	 * Returns the position of the entity in 
	 * the window and on the grid in the y 
	 * direction
	 * @param y - position set
	 */
	public int getyGrid() {
		return yGrid;
	}
	
	/**
	 * Draws the entity in the window
	 * @param g - graphic for enemy
	 */
	public void draw(Graphics g) {
	}

	/**
	 * Returns name of entity
	 * @return myName - name of entity
	 */
	public String getName() {
		return myName;
	}

	/**
	 * Returns current health points of entity
	 * @return currentHP - current health points of entity
	 */
	public int getCurrentHP() {
		return currentHP;
	}

	/**
	 * Returns maximum amount of health points entity can have
	 * @return maxHP - capacity of health points
	 */
	public int getMaxHP() {
		return maxHP;
	}

	/**
	 * Returns strength points
	 * @return myStrength - strength of entity
	 */
	public int getStrength() {
		return myStrength;
	}

	/**
	 * Changes health points by amount
	 * @param amount - number that health is changed
	 */
	public void changeHP(int amount) {
		setCurrentHP(getCurrentHP() + amount);
		if(getCurrentHP() > getMaxHP()) {
			setCurrentHP(getMaxHP());
		}
	}

	/**
	 * Changes name of entity
	 * @param name - new name
	 */
	public void setName(String name) {
		myName = name;
	}

	/**
	 * changes current health
	 * @param health - new current health
	 */
	public void setCurrentHP(int health) {
		this.currentHP = health;
	}

	/**
	 * changes maximum health
	 * @param maxHealth - new max health
	 */
	public void setMaxHP(int maxHealth) {
		this.maxHP = maxHealth;
	}

	/**
	 * changes strength points
	 * @param str - new strength
	 */
	public void setStrength(int str) {
		myStrength = str;
	}

	/**
	 * Returns entity's simple name
	 */
	public String toString() {
		return this.getClass().getSimpleName();
	}

}