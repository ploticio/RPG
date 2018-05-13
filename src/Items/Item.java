package Items;

import java.awt.image.BufferedImage;

import Entities.*;

/**
 * Abstract class for Items
 *
 */
public abstract class Item {
	private String name;
	private String desc;
	private int price;
	private BufferedImage picture;

	public Item() {

	}

	/**
	 * 
	 * @param name
	 *            item name
	 * @param desc
	 *            item description
	 * @param price
	 *            item price
	 */
	public Item(String name, String desc, int price) {
		this.name = name;
		this.name = desc;
		this.price = price;
	}

	/**
	 * getters method
	 * 
	 * @return - name
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
	 * setter method for price
	 * 
	 * @param i
	 *            item's price
	 */
	public void setPrice(int i) {
		price = i;
	}

	/**
	 * getter method for price
	 * 
	 * @return item's price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * method to buy items. Places item into player's inventory and removes some of
	 * the player's gold
	 * 
	 * @param p
	 *            player buying the item
	 */
	public void buy(Player p) {
		p.addItems(this);
		p.setGold(p.getGold() - price);
	}

	/**
	 * method to sell items. Removes the item from player's inventory and gives the
	 * player gold
	 * 
	 * @param p
	 */
	public void sell(Player p) {
		p.setGold(p.getGold() + price / 2);
	}

	/**
	 * getter method for the item's sprite
	 * 
	 * @return the item's sprite
	 */
	public BufferedImage getPicture() {
		return picture;
	}

	/**
	 * to string method for the item
	 */
	public String toString() {
		return "name: \n" + name + "\ndesc: \n" + desc;
	}

	/**
	 * Abstract method for using items.
	 * 
	 * @param e
	 *            the entity that is using the item
	 */
	public abstract void use(Entity e);
}