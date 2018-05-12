package Entities;

public class Attack {
	private String name;
	private int strength;

	/**
	 * Loaded Constructor - initializes name and strength of attack
	 * @param name - attack name
	 * @param strength - attack strength
	 */
	public Attack(String name, int strength) {
		this.name = name;
		this.strength = strength;
	}

	/**
	 * Gets the name of the attack
	 * @return name - name of attack
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets attack name
	 * 
	 * @param name - the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets strength of attack
	 * @return strngth - the strength of the attack
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * Sets attack strength
	 * @param strength - the strength to set
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}
}
