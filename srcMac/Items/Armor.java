package Items;

import java.awt.image.BufferedImage;

import Entities.Player;

/**
 * 
 * Abstract class for Armors
 *
 */
public abstract class Armor implements Equipment {
	private String name;
	private String desc;
	private double increase;
	private boolean isEquiped;
	private int price;
	private BufferedImage picture;

	/**
	 * Default constructor. Sets the armor to be not equipped.
	 */
	public Armor() {
		isEquiped = false;
	}

	/**
	 * 
	 * @param name
	 *            Armor name
	 * @param desc
	 *            Armor description
	 * @param increase
	 *            percentage of damage decreased
	 * @param price
	 *            price of the armor
	 */
	public Armor(String name, String desc, double increase, int price) {
		this.name = name;
		this.desc = desc;
		this.increase = increase;
		this.price = price;
	}

	/**
	 * getter method for string
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * setters method
	 * 
	 * @param n
	 *            - given name
	 */
	public void setName(String n) {
		this.name = n;
	}

	/**
	 * getters method
	 * 
	 * @return - description
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * setters method
	 * 
	 * @param n
	 *            - given description
	 */
	public void setDesc(String d) {
		this.name = d;
	}

	/**
	 * checks to see if the armor is equipped or not
	 * 
	 * @return isEquiped
	 */
	public boolean isEquiped() {
		return isEquiped;
	}

	/**
	 * getter method for the percent damage decrease
	 * 
	 * @return percent decrease
	 */
	public double getIncrease() {
		return increase;
	}

	/**
	 * setter method for price
	 * 
	 * @param i
	 *            given price
	 */
	public void setPrice(int i) {
		price = i;
	}

	/**
	 * getter method for price
	 * 
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * puts the item into the player's inventory and takes away some of the player's
	 * gold
	 * 
	 * @param p
	 *            the player buying the armor
	 */
	public void buy(Player p) {
		p.addArmor(this);
		p.setGold(p.getGold() - price);
	}

	/**
	 * removes the item from the player's inventory
	 * 
	 * @param p
	 *            player selling the armor
	 */
	public void sell(Player p) {
		p.setGold(p.getGold() + price / 2);
	}

	/**
	 * to string method for the armor
	 */
	public String toString() {
		String s;
		if (isEquiped) {
			s = "EQUIPED: ";
		} else {
			s = "";
		}
		return s + name + ": " + desc;
	}

	/**
	 * getter method for the armor's picture
	 * 
	 * @return the given picture
	 */
	public BufferedImage getPicture() {
		return picture;
	}

	/**
	 * equips the armor
	 */
	public void equip() {
		isEquiped = true;
	}

	/**
	 * unequips the armor
	 */
	public void unequip() {
		isEquiped = false;
	}
}