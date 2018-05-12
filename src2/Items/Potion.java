package Items;

import Entities.*;

public class Potion extends Item {
	private String name;
	private String desc;
	private Player p;
	private int price;

	public Potion() {
		name = "Potion";
		desc = "Heals 10 hp";
		price = 10;
		super.setPrice(price);
	}

	public Potion(String name, String desc, int price) {
		super(name, desc, price);
		// this.p = p;
		// TODO Auto-generated constructor stub
	}

	public void use(Entity e) {
		e.changeHP(10);
	}

	public String toString() {
		return name + ": " + desc;
	}

}
