package Items;
import Entities.*;

public abstract class Item {
	private String name;
	private String desc;
	
	/**
	 * Default Constructor - creates item object
	 */
	public Item() {
		
	}
	
	/**
	 * Loaded Constructor - initializes name and description
	 * @param name - name of item
	 * @param desc - description of item
	 */
	public Item(String name, String desc) {
		this.name = name;
		this.name = desc;
	}

	/**
	 * Gets name of item
	 * @return name - item name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name of item
	 * @param n - name of item
	 */
	public void setName(String n) {
		this.name = n;
	}
	
	/**
	 * Gets description of item
	 * @return desc - description of item
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Sets description of item
	 * @param d - description of item
	 */
	
	public void setDesc(String d) {
		this.name = d;
	}

	/**
	 * Formats item's name and description as a string
	 */
	public String toString() {
		return "name: \n" + name + "\ndesc: \n" + desc;
	}
	public abstract void use(Entity e);
}