package Entities;

import java.awt.Color;
import java.awt.Font;
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
	private double exp;
	private int trueHP;// hp before armor is added
	private int trueStrength;
	private Armor equipedArmor;
	private NoArmor na = new NoArmor();
	private Weapon equipedWeapon;
	private NoWeapon nw = new NoWeapon();
	private Player alt;

	ArrayList<Item> inventory = new ArrayList<Item>();
	ArrayList<Attack> attacks = new ArrayList<Attack>();
	ArrayList<Armor> armor = new ArrayList<Armor>();
	ArrayList<Weapon> weapon = new ArrayList<Weapon>();

	private double requiredEXP; // amount of exp need to level up

	BufferedImage down;
	BufferedImage up;
	BufferedImage left;
	BufferedImage right;
	BufferedImage current;
	BufferedImage statBoxImage;

	/**
	 * Default Constructor - initializes player sprites and sets the current
	 * direction to down
	 */
	public Player() {
		requiredEXP = 50;
		trueHP = 5;
		trueStrength = 5;
		super.setCurrentHP(5);
		gold = 100;
		equipedArmor = na;
		equipedWeapon = nw;
		try {
			fillAttacks();
			statBoxImage = ImageIO.read(new File("Images\\boiStat.png"));
			up = ImageIO.read(new File("Images\\boiBack.png"));
			down = ImageIO.read(new File("Images\\boiFront.png"));
			left = ImageIO.read(new File("Images\\boiLeft.png"));
			right = ImageIO.read(new File("Images\\boiRight.png"));
			current = down;
		} catch (IOException e) {
			System.out.println("No Image Found: Player");
		}
	}

	public void setAltPlayer(Player alt) {
		this.alt = alt;
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
	 * 
	 * @param s
	 *            - direction name
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
	 * 
	 * @param g
	 *            - graphics drawer
	 */
	public void draw(Graphics g) {
		if (alt != null) {
			g.drawImage(statBoxImage, 5, 5, 70, 70, null);
			g.setFont(new Font("Arial", Font.BOLD, 16));
			g.setColor(Color.WHITE);
			g.drawString("Gold: " + alt.getGold(), 80, 64);
			g.drawString("Health: " + alt.getCurrentHP() + "/" + alt.getMaxHP(), 80, 44);
			g.drawString("Level: " + alt.getLevel(), 80, 24);
			g.drawString(
					"EXP: " + Math.round(alt.getExp() * 10) / 10 + "/" + Math.round(alt.getRequiredEXP() * 10) / 10, 80,
					84);
		}
		g.drawImage(current, xPos, yPos, null);
	}

	//////// Character Stats and levels////////////

	/**
	 * Raises level, max health, strength points, and next level requirements
	 */
	public void levelUp() {
		trueHP++;
		trueStrength++;
		level++;
		exp = exp % requiredEXP;
		requiredEXP = 50 * Math.exp(0.1 * level);
	}

	/**
	 * Checks if player has enough experience points to level up
	 * 
	 * @return if ready for next level
	 */
	public boolean ifNextLevel() {
		if (exp >= requiredEXP) {
			return true;
		} else {
			return false;
		}
	}

	/////////// getters and setters///////////
	/**
	 * Adds health to player
	 * 
	 * @param x
	 *            - health points added to player
	 */
	public void changeHealth(int x) {
		super.setCurrentHP(super.getCurrentHP() + x);
	}

	/**
	 * Gets current level
	 * 
	 * @return level - level number
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Gets current amount of experience points
	 * 
	 * @return exp - amount of experience points
	 */
	public double getExp() {
		return exp;
	}

	/**
	 * Sets amount of experience points
	 * 
	 * @param d
	 *            - new amount of experience points
	 */
	public void setExp(double d) {
		this.exp = d;
	}

	/**
	 * Gets amount of experience points needed to level up
	 * 
	 * @return requiredEXP - experience requirement
	 */
	public double getRequiredEXP() {
		return requiredEXP;
	}

	/**
	 * Adds item to inventory list
	 * 
	 * @param i
	 *            - new item added
	 */
	public void addItems(Item i) {
		inventory.add(i);
	}

	/**
	 * Adds armor to inventory list
	 * 
	 * @param a
	 *            - new armor added
	 */
	public void addArmor(Armor a) {
		armor.add(a);
	}

	/**
	 * Adds weapon to inventory list
	 * 
	 * @param w
	 *            - new weapon added
	 */
	public void addWeapon(Weapon w) {
		weapon.add(w);
	}

	/**
	 * Gets list of items in inventory
	 * 
	 * @return inventory - list of items in player's inventory
	 */
	public ArrayList<Item> getInventory() {
		return inventory;
	}

	/**
	 * Gets list of player's attacks
	 * 
	 * @return attacks - list of attacks
	 */
	public ArrayList<Attack> getAttacks() {
		return attacks;
	}

	///////// HP STUFF///////////////
	/**
	 * Gets health
	 * 
	 * @return health without armor
	 */
	public int getTrueHP() {
		return trueHP;
	}

	/**
	 * sets max hp
	 */
	public void setMaxHP() {
		super.setMaxHP(trueHP + equipedArmor.getIncrease());
	}

	/**
	 * gets max hp
	 * 
	 * @return gets max hp
	 */
	public int getMaxHP() {
		return equipedArmor.getIncrease() + trueHP;
	}

	/**
	 * gets equipped armor
	 * 
	 * @return gets armor
	 */
	public Armor getEquipedArmor() {
		return equipedArmor;
	}

	/**
	 * Sets equipped armor
	 * 
	 * @param a
	 *            - the armor
	 */
	public void setEquipedArmor(Armor a) {
		equipedArmor = a;
	}

	/**
	 * Gets armor list
	 * 
	 * @return armor list
	 */
	public ArrayList<Armor> getArmor() {
		return armor;
	}

	////////// STRENGTH STUFF///////////
	/**
	 * sets the equipped weapon
	 * 
	 * @param w
	 *            - the equipped weapon
	 */
	public void setEquipedWeapon(Weapon w) {
		equipedWeapon = w;
	}

	/**
	 * gets the equipped weapon
	 * 
	 * @return the equipped weapon
	 */
	public Weapon getEquipedWeapon() {
		return equipedWeapon;
	}

	/**
	 * gets the strength without modifiers
	 * 
	 * @return strength
	 */
	public int getTrueStrength() {
		return trueStrength;
	}

	/**
	 * sets the strength
	 */
	public void setStrength() {
		super.setStrength(trueStrength + equipedWeapon.getIncrease());
	}

	/**
	 * gets the current strength
	 */
	public int getStrength() {
		return trueStrength + equipedWeapon.getIncrease();
	}

	/**
	 * gets the list of weapons
	 * 
	 * @return - list of weapons
	 */
	public ArrayList<Weapon> getWeapons() {
		return weapon;
	}

	/**
	 * Gets amount of gold player has
	 * 
	 * @return gold - amount of gold
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * Sets amount of gold player has
	 * 
	 * @param gold
	 *            - new amount of gold
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