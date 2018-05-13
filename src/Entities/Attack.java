package Entities;

import java.util.Random;

public class Attack {
	private String name;
	private int strength;
	private boolean critical = false;
	private boolean missed = false;
	private final int CRITICAL_CHANCE = 90;
	private final int MISS_CHANCE = 5;
	private Random r = new Random();
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
	 * @return strength - the strength of the attack
	 */
	public int getStrength() {
		int chance = r.nextInt(100);
		if(chance < CRITICAL_CHANCE) {
			critical = true;
			return strength * 2;
		}
		else if(chance > 99-MISS_CHANCE) {
			missed = true;
			return 0;
		}
		else {
			critical = false;
			missed = false;
			return strength;
		}
	}
	
	public boolean wasCritical() {
		return critical;
	}
	
	public boolean wasMissed() {
		return missed;
	}
	
	/**
	 * Sets attack strength
	 * @param strength - the strength to set
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
}
