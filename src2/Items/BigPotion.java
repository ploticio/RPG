package Items;

import Entities.*;

public class BigPotion extends Item {
	private String name;
	private String desc;
	private Player p;
	private int price;

	public BigPotion() {
		name = "Big Potion";
		desc = "Heals 15 hp";
		price = 15;
		super.setPrice(price);
	}

	public BigPotion(String name, String desc, int price) {
		super(name, desc, price);
		// this.p = p;
		// TODO Auto-generated constructor stub
	}

	public void use(Entity e) {
		e.changeHP(15);
	}

	public String toString() {
		return name + ": " + desc;
	}

}
