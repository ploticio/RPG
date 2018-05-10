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
	
	/**
	 * Loaded Constructor - initializes name and description
	 * @param name - name of potion
	 * @param desc - description of potion
	 */
	public Potion(String name, String desc) {
		super(name, desc);
		this.p = p;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Changes entity's health points
	 * @param e - entity being healed
	 */
	public void use(Entity e) {
		e.changeHP(10);
	}
	
	/**
	 * Formats potion's name and description as string
	 */
	public String toString() {
		return name +": " + desc;
	}


}
