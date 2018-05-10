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
	private int unmodifiedHP;
	private int modifiedHP;
	private Armor equipedArmor;
	private NoArmor na = new NoArmor();

	ArrayList<Item> inventory = new ArrayList<Item>();
	ArrayList<Attack> attacks = new ArrayList<Attack>();
	ArrayList<Armor> armor = new ArrayList<Armor>();

	private int requiredEXP; // amount of exp need to level up

	BufferedImage down;
	BufferedImage up;
	BufferedImage left;
	BufferedImage right;
	BufferedImage current;

	public Player() {
		requiredEXP = 3;
		unmodifiedHP = 20;
		super.setMaxHP(20);
		equipedArmor = na;
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

	private void fillAttacks() {
		attacks.add(new Attack("Stab", 2));
		attacks.add(new Attack("Slice", 10));
		attacks.add(new Attack("Kick", 4));
		attacks.add(new Attack("Punch", 6));
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

	public boolean ifNextLevel() {
		if (exp >= requiredEXP) {
			return true;
		} else {
			return false;
		}
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

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getRequiredEXP() {
		return requiredEXP;
	}

	public void addItems(Item i) {
		inventory.add(i);
	}

	public void addArmor(Armor a) {
		armor.add(a);
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public ArrayList<Attack> getAttacks() {
		return attacks;
	}

	public void setEquipedArmor(Armor a) {
		equipedArmor = a;
	}

	public ArrayList<Armor> getArmor() {
		return armor;
	}

	public Armor getEquipArmor() {
		return equipedArmor;
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