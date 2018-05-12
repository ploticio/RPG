package Items;

public class WoodenSword extends Weapon {
	private static String name = "Wooden Sword";;
	private static String desc = "Increases Strength by 2";
	private static int increase = 2;
	private static int price = 5;

	public WoodenSword() {
		super(name, desc, increase, 5);
	}

}
