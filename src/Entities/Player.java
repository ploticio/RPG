package Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import Items.*;

import javax.imageio.ImageIO;

import Graphics.GraphicsMaker;

public class Player extends Entity {
	private int gold;
	private int level;
	private int exp;

	ArrayList<Item> inventory = new ArrayList<Item>();
	ArrayList<Attack> attacks = new ArrayList<Attack>();

	private int requiredEXP; // amount of exp need to level up

	BufferedImage down;
	BufferedImage up;
	BufferedImage left;
	BufferedImage right;
	BufferedImage current;

	/**
	 * Default Constructor - initializes player sprites and sets the current direction to down
	 */
	public Player() {
		try {
			fillAttacks();
			up = ImageIO.read(new File("Images\\boiBack.png"));
			down = ImageIO.read(new File("Images\\boiFront.png"));
			left = ImageIO.read(new File("Images\\boiLeft.png"));
			right = ImageIO.read(new File("Images\\boiRight.png"));
			current = down;
		} catch (IOException e) {
			System.out.println("No Image Found: Player");
		}
	}

	/**
	 * Loaded Constructor - initializes player sprites, x and y positions, 
	 * gold amount, and sets the current direction to down
	 * @param x - x position
	 * @param y - y position
	 * @param gold - amount of gold held
	 */
	public Player(int x, int y, int gold) {
		super(x, y, "Player", 10, 10, 10);
		this.gold = gold;
		level = 1;
		exp = 0;
		requiredEXP = 3;
		fillAttacks();

		// movement and graphics
		try {
			up = ImageIO.read(new File("Images\\boiBack.png"));
			down = ImageIO.read(new File("Images\\boiFront.png"));
			left = ImageIO.read(new File("Images\\boiLeft.png"));
			right = ImageIO.read(new File("Images\\boiRight.png"));
			current = down;
		} catch (IOException e) {
			System.out.println("No Image Found: Player");
		}
	}

	/**
	 * Adds attacks to players attack list
	 */
	private void fillAttacks() {
		attacks.add(new Attack("Stab", 2));
		attacks.add(new Attack("Slice", 10));
		attacks.add(new Attack("Kick", 4));
		attacks.add(new Attack("Punch", 6));
	}

	///////// Graphics/////////////
	/**
	 * Sets player direction according to keyboard input
	 * @param s - direction name
	 */
	public void setCurrent(String s) {
		if (s.equals("up"))
			current = up;
		if (s.equals("left"))
			current = left;
		if (s.equals("right"))
			current = right;
		if (s.equals("down"))
			current = down;
	}

	/**
	 * Renders player entity
	 * @param g - graphics drawer
	 */
	public void draw(Graphics g) {
		g.drawImage(current, xPos, yPos, null);
	}

	//////// Character Stats and levels////////////
	
	/**
	 * Raises level, max health, strength points, and next level requirements
	 */
	public void levelUp() {
		super.setMaxHP(super.getMaxHP() + 1);
		super.setStrength(super.getStrength() + 1);
		requiredEXP += (level * 2);
		level++;
		exp = exp % requiredEXP;
		System.out.println("Level Up!");
		System.out.println("Level has increased to " + level);
		System.out.println("Strength has increased to " + super.getStrength());
		System.out.println("Health has increased to " + super.getMaxHP());
	}
	
	/**
	 * Checks if player has enough experience points to level up
	 * @return if ready for next level
	 */
	public boolean ifNextLevel() {
		if(exp >= requiredEXP) {
			return true;
		} else {
			return false;
		}
	}

	/////////// getters and setters///////////
	/**
	 * Adds health to player
	 * @param x - health points added to player
	 */
	public void changeHealth(int x) {
		super.setCurrentHP(super.getCurrentHP() + x);
	}

	/**
	 * Gets current level
	 * @return level - level number
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Gets current amount of experience points
	 * @return exp - amount of experience points
	 */
	public int getExp() {
		return exp;
	}

	/**
	 * Sets amount of experience points
	 * @param exp - new amount of experience points
	 */
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	/**
	 * Gets amount of experience points needed to level up
	 * @return requiredEXP - experience requirement
	 */
	public int getRequiredEXP() {
		return requiredEXP;
	}

	/**
	 * Adds item to inventory list
	 * @param i - new item added
	 */
	public void addItems(Item i) {
		inventory.add(i);
	}

	/**
	 * Gets list of items in inventory
	 * @return inventory - list of items in player's inventory
	 */
	public ArrayList<Item> getInventory() {
		return inventory;
	}

	/**
	 * Gets list of player's attacks
	 * @return attacks - list of attacks
	 */
	public ArrayList<Attack> getAttacks() {
		return attacks;
	}

	/*
	 * public ArrayList getInventory() { return inventory; }
	 * 
	 * public ArrayList getEquipped() { return equipped; }
	 */
	
	/**
	 * Gets amount of gold player has
	 * @return gold - amount of gold
	 */
	public int getGold() {
		return gold;
	}
 
	/**
	 * Sets amount of gold player has
	 * @param gold - new amount of gold
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}

	/*
	 * public String toString() { return "Player [level=" + level + ", exp=" + exp +
	 * ", requiredEXP=" + requiredEXP + ", inventory=" + inventory + ", equipped=" +
	 * equipped + ", myName=" + super.getName() + ", maxHP=" + super.getMaxHP() +
	 * ", currentHP=" + super.getCurrentHP() + ", myStrength=" + super.getStrength()
	 * + "]"; }
	 */

}