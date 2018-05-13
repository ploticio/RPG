package Items;

/**
 * Object for when nothing is equipped. This should never be in the player's
 * inventory
 *
 */
public class NoArmor extends Armor {
	private static String name = "NoArmor";;
	private static String desc = "This should never pop upinside your inventory";
	private static int increase = 0;

	/**
	 * Constructor for NoArmor
	 */
	public NoArmor() {
		super(name, desc, increase, 0);
	}

}
