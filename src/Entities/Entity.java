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

	public Entity() {
	}

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

	public String getName() {
		return myName;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public int getStrength() {
		return myStrength;
	}

	public void changeHP(int amount) {
		currentHP = currentHP + amount;
	}

	public void setName(String name) {
		myName = name;
	}

	public void setCurrentHP(int health) {
		this.currentHP = health;
	}

	public void setMaxHP(int maxHealth) {
		this.maxHP = maxHealth;
	}

	public void setStrength(int str) {
		myStrength = str;
	}

	public String toString() {
		return this.getClass().getSimpleName();
	}

}
