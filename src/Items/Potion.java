package Items;

import Entities.*;

public class Potion extends Item {
	private String name;
	private String desc;
	private Player p;

	public Potion() {
		name = "Potion";
		desc = "Heals 10 hp";
	}

	public Potion(String name, String desc) {
		super(name, desc);
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
