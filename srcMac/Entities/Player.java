package Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import Items.*;

import javax.imageio.ImageIO;
/**
 * 
 * Player object to be used ingame.
 *
 */
public class Player extends Entity {
	private int gold;
	private int level;
	private double exp;
	private int trueStrength;
	private Armor equipedArmor;
	private NoArmor na = new NoArmor();
	private Weapon equipedWeapon;
	private NoWeapon nw = new NoWeapon();
	private Random r = new Random();

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

	Attack punch = new Attack("Punch", 4);
	Attack kick = new Attack("Kick", 9);
	Attack stab = new Attack("Stab", 19);
	Attack slice = new Attack("Slice", 29);

	/**
	 * Default Constructor - initializes player sprites and sets the current
	 * direction to down
	 */
	public Player() {
		requiredEXP = 50;
		trueStrength = 10;
		super.setMaxHP(100);
		super.setCurrentHP(100);
		equipedArmor = na;
		equipedWeapon = nw;
		attacks.add(punch);
		try {
			up = ImageIO.read(new File("Images////boiBack.png"));
			down = ImageIO.read(new File("Images////boiFront.png"));
			left = ImageIO.read(new File("Images////boiLeft.png"));
			right = ImageIO.read(new File("Images////boiRight.png"));
			current = down;
		} catch (IOException e) {
			System.out.println("No Image Found: Player");
		}
	}

	/**
	 * Adds attacks to players attack list
	 */

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
		g.drawImage(current, xPos, yPos, null);
	}

	//////// Character Stats and levels////////////

	/**
	 * Raises level, max health, strength points, and next level requirements
	 */
	public void levelUp() {
		// trueHP++;
		trueStrength = 10 + level*5;
		super.setMaxHP(100 + level * 10);
		if (super.getCurrentHP() < super.getMaxHP() / 2) {
			super.setCurrentHP(super.getMaxHP() / 2);
		}
		level++;
		if (level == 3) {
			attacks.add(kick);
		}
		exp = exp % requiredEXP;
		requiredEXP = 50 * Math.exp(0.1 * level);
	}
	
	public void setLevel(int n) {
		level = n;
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
	 * checks to see if the player has a weapon
	 * @return whether the player has a weapon equipped
	 */
	public boolean hasWeapon() {
		if (equipedWeapon.equals(nw)) {
			return false;
		} else {
			return true;
		}
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

	/**
	 * sets whether the player has weapon attacks
	 * @param b - allows the player to have weapon attacks
	 */
	public void setWeaponAttacks(boolean b) {
		if (b && !attacks.contains(stab)) {
			attacks.add(stab);
		}
		if (b && level == 10 && !attacks.contains(slice)) { 
			attacks.add(slice);
		}
		if (!b) {
			if (attacks.contains(stab)) {
				attacks.remove(stab);
			}
			if (attacks.contains(slice)) {
				attacks.remove(slice);
			}
		}
	}
	
	/**
	 *  unequips the player's weapon
	 */
	public void unequipWeapon() {
		equipedWeapon = nw;
	}
	/**
	 * unequips the player's armor
	 */
	public void unequipArmor() {
		equipedArmor = na;
	}
	/**
	 * helper method for recursive mergesort
	 * @param first - left list
	 * @param second - right list
	 * @return - sorted list
	 */
	private ArrayList<Weapon> weaponMerge(ArrayList<Weapon> first, ArrayList<Weapon> second) {
        ArrayList<Weapon> mergedList = new ArrayList<>();
        while (first.size() > 0  && second.size() > 0) {
            if (first.get(0).getPrice() <= second.get(0).getPrice()) {
                mergedList.add(first.remove(0));
            } else {
                mergedList.add(second.remove(0));
            }
        }
        mergedList.addAll(first);
        mergedList.addAll(second);
        return mergedList;
    }
	/**
	 * recursive mergesort for weapons
	 * @param list - weapons list to be sorted
	 */
    public void weaponMergeSort(ArrayList<Weapon> list) {
        if (list.size() != 1) {
            ArrayList<Weapon> left = new ArrayList<Weapon>();
            ArrayList<Weapon> right = new ArrayList<Weapon>();
            boolean changeList = true;
            while (list.size() > 0) {
                if (changeList) {
                    left.add(list.remove(0));
                } else {
                    right.add(list.remove(0));
                }
                changeList = !changeList;
            }
            weaponMergeSort(left);
            weaponMergeSort(right);
            list.addAll(weaponMerge(left, right));
        }
    }
    /**
     * helper method for recursive mergesort
     * @param first - left list
     * @param second - right list
     * @return sorted list
     */
    private ArrayList<Armor> armorMerge(final ArrayList<Armor> first, final ArrayList<Armor> second) {
        ArrayList<Armor> mergedList = new ArrayList<>();
        while (first.size() > 0  && second.size() > 0) {
            if (first.get(0).getPrice() <= second.get(0).getPrice()) {
                mergedList.add(first.remove(0));
            } else {
                mergedList.add(second.remove(0));
            }
        }
        mergedList.addAll(first);
        mergedList.addAll(second);
        return mergedList;
    }
    /**
     * recursive mergesort for armors
     * @param list - list of armor to be sorted
     */
    public void armorMergeSort(final ArrayList<Armor> list) {
        if (list.size() != 1) {
            ArrayList<Armor> left = new ArrayList<Armor>();
            ArrayList<Armor> right = new ArrayList<Armor>();
            boolean changeList = true;
            while (list.size() > 0) {
                if (changeList) {
                    left.add(list.remove(0));
                } else {
                    right.add(list.remove(0));
                }
                changeList = !changeList;
            }
            armorMergeSort(left);
            armorMergeSort(right);
            list.addAll(armorMerge(left, right));
        }
    }
	
}