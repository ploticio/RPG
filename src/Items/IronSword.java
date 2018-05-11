package Items;

public class IronSword extends Weapon {
	private static String name = "Iron Sword";
	private static String desc = "Increases Strength by 5";
	private static int increase = 5;

	public IronSword() {
		super(name, desc, increase);
	}

}
