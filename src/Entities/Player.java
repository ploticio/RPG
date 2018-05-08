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
	private int requiredEXP; // amount of exp need to level up
	// private ArrayList<Item> inventory = new ArrayList<>();
	// private ArrayList<Item> equipped = new ArrayList<>();

	BufferedImage down;
	BufferedImage up;
	BufferedImage left;
	BufferedImage right;
	BufferedImage current;

	public Player() {
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

	public Player(int x, int y, int gold) {
		super(x, y, "Player", 10, 10, 10);
		this.gold = gold;
		level = 1;
		exp = 0;
		requiredEXP = 10;

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

	///////// Graphics/////////////
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

	public void draw(Graphics g) {
		g.drawImage(current, xPos, yPos, null);
	}

	//////// Character Stats and levels////////////
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

	/////////// getters and setters///////////
	public void changeHealth(int x) {
		super.setCurrentHP(super.getCurrentHP() + x);
	}

	public int getLevel() {
		return level;
	}

	public int getExp() {
		return exp;
	}

	public int getRequiredEXP() {
		return requiredEXP;
	}

	public void addItems(Item i) {
		inventory.add(i);
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	/*
	 * public ArrayList getInventory() { return inventory; }
	 * 
	 * public ArrayList getEquipped() { return equipped; }
	 */
	public int getGold() {
		return gold;
	}

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