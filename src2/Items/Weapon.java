package Items;

import Entities.Player;

public abstract class Weapon implements Equipment {
	private String name;
	private String desc;
	private int increase;
	private boolean isEquiped;
	private int price;

	public Weapon() {
		isEquiped = false;
	}

	public Weapon(String name, String desc, int increase, int price) {
		this.name = name;
		this.desc = desc;
		this.increase = increase;
		this.price = price;
	}

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

	public boolean isEquiped() {
		return isEquiped;
	}

	public int getIncrease() {
		return increase;
	}

	public void setPrice(int i) {
		price = i;
	}

	public int getPrice() {
		return price;
	}

	public void buy(Player p) {
		p.addWeapon(this);
		p.setGold(p.getGold() - price);
	}
	public void sell(Player p) {
		p.setGold(p.getGold() + price);
	}

	public String toString() {
		String s;
		if (isEquiped) {
			s = "EQUIPED: ";
		} else {
			s = "";
		}
		return s + name + ": " + desc;
	}

	public void equip() {
		isEquiped = true;
	}

	public void unequip() {
		isEquiped = false;
	}
}