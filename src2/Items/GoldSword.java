package Items;

public class GoldSword extends Weapon {
	private static String name = "Gold Sword";
	private static String desc = "Increases Strength by 10";
	private static int increase = 10;
	private static int price = 15;

	public GoldSword() {
		super(name, desc, increase, price);
	}

}
