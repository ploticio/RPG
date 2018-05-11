package Items;

public abstract class Armor implements Equipment {
	private String name;
	private String desc;
	private int increase;
	private boolean isEquiped;

	public Armor() {
		isEquiped = false;
	}

	public Armor(String name, String desc, int increase) {
		this.name = name;
		this.desc = desc;
		this.increase = increase;
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