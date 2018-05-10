package Items;
/**
 * 
 * This shouldn't ever pop up in the inventory
 *
 */
public class NoWeapon extends Weapon {
	private static String name = "No Weapon";
	private static String desc = "Your fist";
	private static int increase = 0;

	public NoWeapon() {
		super(name, desc, increase);
	}

}
