package Items;

import java.awt.image.BufferedImage;

import Entities.Player;

/**
 * 
 * @author Vincent
 * Abstract object for all swords and weapons
 */
public abstract class Weapon implements Equipment {
	private String name;
	private String desc;
	private int increase;
	private boolean isEquiped;
	private int price;
	private BufferedImage picture;

	/**
	 * Default Constructor - marks equipped property to false
	 */
	public Weapon() {
		isEquiped = false;
	}

	/**
	 * Loaded Constructor - Loads name, description, strength percent increase, and price
	 * @param name - weapon name
	 * @param desc - weapon description
	 * @param increase - percent of strength increase
	 * @param price - price in shop
	 */
	public Weapon(String name, String desc, int increase, int price) {
		this.name = name;
		this.desc = desc;
		this.increase = increase;
		this.price = price;
	}

	/**
	 * Returns name of weapon
	 * @return name - name of weapon
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets weapon name
	 * @param n - given name
	 */
	public void setName(String n) {
		this.name = n;
	}

	/**
	 * Returns description of weapon
	 * @return desc - weapon's description
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Sets weapon's description
	 * @param n - given description
	 */
	public void setDesc(String d) {
		this.name = d;
	}

	/**
	 * Checks if this weapon is equipped by  the payer
	 * @return - checks if is equipped on player
	 */
	public boolean isEquiped() {
		return isEquiped;
	}

	/**
	 * Returns the strength increase percent
	 * @return increase - percent increase to player's strength
	 */
	public int getIncrease() {
		return increase;
	}

	/**
	 * Sets price of weapon in shop
	 * @param i - weapon's value in gold
	 */
	public void setPrice(int i) {
		price = i;
	}

	/**
	 * Returns price of weapon in shop
	 * @param i - weapon's value in gold
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Removes gold from player's gold stash and gives weapon to player
	 * @param p - player entity
	 */
	public void buy(Player p) {
		p.addWeapon(this);
		p.setGold(p.getGold() - price);
	}
	
	/**
	 * Adds gold to player's gold stash and removes weapon from player
	 * @param p - player entity
	 */
	public void sell(Player p) {
		p.setGold(p.getGold() + price/2);
	}
	
	/**
	 * Returns weapon's image
	 * @return picture - image of weapon
	 */
	public BufferedImage getPicture() {
		return picture;
	}
	
	/**
	 * Returns name and weapon description as a string
	 */
	public String toString() {
		String s;
		if (isEquiped) {
			s = "EQUIPPED: ";
		} else {
			s = "";
		}
		return s + name + ": " + desc;
	}

	/**
	 * Tags equipped property to true
	 */
	public void equip() {
		isEquiped = true;
	}
	/**
	 * Tags equipped property to false
	 */
	public void unequip() {
		isEquiped = false;
	}
}