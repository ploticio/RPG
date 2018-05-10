package Items;
import Entities.*;

public abstract class Item {
	private String name;
	private String desc;
	
	public Item() {
		
	}
	public Item(String name, String desc) {
		this.name = name;
		this.name = desc;
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

	public String toString() {
		return "name: \n" + name + "\ndesc: \n" + desc;
	}
	public abstract void use(Entity e);
}