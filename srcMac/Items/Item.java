package Items;

import java.awt.image.BufferedImage;

import Entities.*;

public abstract class Item {
	private String name;
	private String desc;
	private int price;
	private BufferedImage picture;

	public Item() {

	}

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

	public void setPrice(int i) {
		price = i;
	}

	public int getPrice() {
		return price;
	}

	public void buy(Player p) {
		p.addItems(this);
		p.setGold(p.getGold() - price);
	}
	public void sell(Player p) {
		p.setGold(p.getGold() + price/2);
	}

	public BufferedImage getPicture() {
		return picture;
	}
	
	public String toString() {
		return "name: //n" + name + "//ndesc: //n" + desc;
	}

	public abstract void use(Entity e);
}