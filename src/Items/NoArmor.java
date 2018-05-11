package Items;

/**
 * 
 * @author A-dam
 *
 */
public class NoArmor extends Armor {
	private static String name = "NoArmor";;
	private static String desc = "This should never pop upinside your inventory";
	private static int increase = 0;

	public NoArmor () {
		super(name, desc, increase);
	}


}
